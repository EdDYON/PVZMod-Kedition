(function() {

	const PLUGIN_ID = 'kodded_entity';
	const PLUGIN_TITLE = 'kodded_entity';
	const PLUGIN_ICON = 'icon-format_java';

	let patched_codec = false;
	let original_compile = null;
	let original_template_117 = null;
	let original_template_117_yarn = null;

	let original_cube_preview_update = null;
	let original_cube_update_transform = null;

	let action_edit_inflate = null;

	/* ----------------------------- utils ----------------------------- */

	function num(v, def = 0) {
		return typeof v === 'number' && !isNaN(v) ? v : def;
	}

	function trimFloatNumber(v) {
		v = Number(v) || 0;
		let s = v.toFixed(4);
		s = s.replace(/\.?0+$/, '');
		if (s === '-0') s = '0';
		return s;
	}

	function getAxisInflate(cube) {
		const base = num(cube.inflate, 0);
		return {
			x: base + num(cube.inflate_x, 0),
			y: base + num(cube.inflate_y, 0),
			z: base + num(cube.inflate_z, 0),
		};
	}

	function withPatchedCubeBounds(cube, callback) {
		if (!cube) return callback();

		const inf = getAxisInflate(cube);

		const allSame = inf.x === inf.y && inf.y === inf.z;
		if (allSame) {
			const original = cube.inflate;
			cube.inflate = inf.x;
			try {
				return callback();
			} finally {
				cube.inflate = original;
			}
		}

		const old_from = cube.from ? cube.from.slice() : [0, 0, 0];
		const old_to = cube.to ? cube.to.slice() : [0, 0, 0];
		const old_inflate = cube.inflate;

		cube.from = [
			old_from[0] - inf.x,
			old_from[1] - inf.y,
			old_from[2] - inf.z
		];
		cube.to = [
			old_to[0] + inf.x,
			old_to[1] + inf.y,
			old_to[2] + inf.z
		];

		cube.inflate = 0;

		try {
			return callback();
		} finally {
			cube.from = old_from;
			cube.to = old_to;
			cube.inflate = old_inflate;
		}
	}

	function refreshCube(cube) {
		if (!cube) return;

		try {
			if (cube.preview_controller && typeof cube.preview_controller.updateGeometry === 'function') {
				cube.preview_controller.updateGeometry(cube);
			} else if (typeof cube.updateGeometry === 'function') {
				cube.updateGeometry();
			} else if (typeof cube.preview === 'function') {
				cube.preview();
			}
		} catch (e) {
			console.warn(`[${PLUGIN_ID}] refreshCube failed`, e);
		}

		try {
			if (cube.preview_controller && typeof cube.preview_controller.updateUV === 'function') {
				cube.preview_controller.updateUV(cube);
			}
		} catch (e) {}

		try {
			if (cube.preview_controller && typeof cube.preview_controller.updateTransform === 'function') {
				cube.preview_controller.updateTransform(cube);
			} else if (typeof cube.updateTransform === 'function') {
				cube.updateTransform();
			}
		} catch (e) {}

		try {
			Canvas.updateView({
				elements: [cube],
				element_aspects: { geometry: true, transform: true, faces: true, uv: true }
			});
		} catch (e) {
			try {
				Canvas.updateAll();
			} catch (e2) {}
		}
	}

	function refreshAllCubes() {
		Cube.all.forEach(cube => refreshCube(cube));
		try {
			Canvas.updateAll();
		} catch (e) {}
	}

	/* ------------------------ property support ------------------------ */

	function ensureCubeProperties() {
		if (!Cube.properties.inflate_x) {
			new Property(Cube, 'number', 'inflate_x', { default: 0, label: 'Inflate X' });
		}
		if (!Cube.properties.inflate_y) {
			new Property(Cube, 'number', 'inflate_y', { default: 0, label: 'Inflate Y' });
		}
		if (!Cube.properties.inflate_z) {
			new Property(Cube, 'number', 'inflate_z', { default: 0, label: 'Inflate Z' });
		}
	}

	/* ----------------------- preview patching ------------------------- */

	function patchPreview() {
		if (!Cube || !Cube.preview_controller) return false;

		const pc = Cube.preview_controller;
		if (!pc) return false;

		if (typeof pc.updateGeometry === 'function' && !original_cube_preview_update) {
			original_cube_preview_update = pc.updateGeometry;
			pc.updateGeometry = function(cube, ...args) {
				return withPatchedCubeBounds(cube, () => {
					return original_cube_preview_update.call(this, cube, ...args);
				});
			};
		}

		if (typeof pc.updateTransform === 'function' && !original_cube_update_transform) {
			original_cube_update_transform = pc.updateTransform;
			pc.updateTransform = function(cube, ...args) {
				return withPatchedCubeBounds(cube, () => {
					return original_cube_update_transform.call(this, cube, ...args);
				});
			};
		}

		return true;
	}

	function restorePreview() {
		if (!Cube || !Cube.preview_controller) return;
		const pc = Cube.preview_controller;
		if (original_cube_preview_update) {
			pc.updateGeometry = original_cube_preview_update;
			original_cube_preview_update = null;
		}
		if (original_cube_update_transform) {
			pc.updateTransform = original_cube_update_transform;
			original_cube_update_transform = null;
		}
	}

	/* ------------------------ export patching ------------------------- */

	function patchTemplates(codec) {
		if (!codec || !codec.templates) return;

		const templates = codec.templates;

		if (templates['1.17']) {
			if (original_template_117 == null) {
				original_template_117 = templates['1.17'].cube;
			}
			templates['1.17'].cube =
				`.texOffs(%(uv_x), %(uv_y)){?(has_mirror).mirror()}.addBox(%(x), %(y), %(z), %(dx), %(dy), %(dz), new CubeDeformation(%(inflate))){?(has_mirror).mirror(false)}`;
		}

		if (templates['1.17_yarn']) {
			if (original_template_117_yarn == null) {
				original_template_117_yarn = templates['1.17_yarn'].cube;
			}
			templates['1.17_yarn'].cube =
				`.uv(%(uv_x), %(uv_y)){?(has_mirror).mirrored()}.cuboid(%(x), %(y), %(z), %(dx), %(dy), %(dz), new Dilation(%(inflate))){?(has_mirror).mirrored(false)}`;
		}
	}

	function patchCompile(codec) {
		if (!codec || patched_codec) return;
		if (typeof codec.compile !== 'function') return;

		original_compile = codec.compile;

		codec.compile = function(options) {
			let model = original_compile.call(this, options);

			const version = Project.modded_entity_version;
			if (version !== '1.17' && version !== '1.17_yarn') {
				return model;
			}

			const exportedCubes = [];
			let all_groups = getAllGroups();

			let loose_cubes = [];
			Cube.all.forEach(cube => {
				if (cube.export == false) return;
				if (cube.parent == 'root') loose_cubes.push(cube);
			});

			if (loose_cubes.length) {
				let group = new Group({ name: 'bb_main' });
				group.is_catch_bone = true;
				group.createUniqueName();
				all_groups.push(group);
				group.children.replace(loose_cubes);
			}

			all_groups.slice().forEach(group => {
				if (group.export == false) return;
				let subgroups = [];
				let group_i = all_groups.indexOf(group);
				group.children.forEachReverse(cube => {
					if (cube instanceof Cube == false || !cube.export) return;
					if (!cube.rotation.allEqual(0)) {
						let sub = subgroups.find(s => {
							if (!s.rotation.equals(cube.rotation)) return false;
							if (s.rotation.filter(n => n).length > 1) {
								return s.origin.equals(cube.origin);
							} else {
								for (var i = 0; i < 3; i++) {
									if (s.rotation[i] == 0 && s.origin[i] != cube.origin[i]) return false;
								}
								return true;
							}
						});
						if (!sub) {
							sub = new Group({
								rotation: cube.rotation,
								origin: cube.origin,
								name: `${cube.name}_r1`
							});
							sub.parent = group;
							sub.is_rotation_subgroup = true;
							sub.createUniqueName(all_groups);
							subgroups.push(sub);
							group_i++;
							all_groups.splice(group_i, 0, sub);
						}
						sub.children.push(cube);
					}
				});
			});

			for (let group of all_groups) {
				if ((group instanceof Group === false && !group.is_catch_bone) || !group.export) continue;
				for (let cube of group.children) {
					if (cube instanceof Cube === false || !cube.export || (!cube.rotation.allEqual(0) && !group.is_rotation_subgroup)) continue;
					exportedCubes.push(cube);
				}
			}

			let cubeIndex = 0;

			if (version === '1.17') {
				model = model.replace(/new CubeDeformation\(([-\d.]+F?)\)/g, function(match) {
					const cube = exportedCubes[cubeIndex++];
					if (!cube) return match;

					const inf = getAxisInflate(cube);
					const x = `${trimFloatNumber(inf.x)}F`;
					const y = `${trimFloatNumber(inf.y)}F`;
					const z = `${trimFloatNumber(inf.z)}F`;

					if (inf.x === inf.y && inf.y === inf.z) {
						return `new CubeDeformation(${x})`;
					}
					return `new CubeDeformation(0.0F).extend(${x}, ${y}, ${z})`;
				});
			} else if (version === '1.17_yarn') {
				model = model.replace(/new Dilation\(([-\d.]+F?)\)/g, function(match) {
					const cube = exportedCubes[cubeIndex++];
					if (!cube) return match;

					const inf = getAxisInflate(cube);
					const x = `${trimFloatNumber(inf.x)}F`;
					const y = `${trimFloatNumber(inf.y)}F`;
					const z = `${trimFloatNumber(inf.z)}F`;

					if (inf.x === inf.y && inf.y === inf.z) {
						return `new Dilation(${x})`;
					}
					return `new Dilation(0.0F).add(${x}, ${y}, ${z})`;
				});
			}

			return model;
		};

		patched_codec = true;
	}

	function restoreCodec(codec) {
		if (!codec) return;

		if (original_compile) {
			codec.compile = original_compile;
			original_compile = null;
		}
		if (codec.templates && codec.templates['1.17'] && original_template_117 != null) {
			codec.templates['1.17'].cube = original_template_117;
		}
		if (codec.templates && codec.templates['1.17_yarn'] && original_template_117_yarn != null) {
			codec.templates['1.17_yarn'].cube = original_template_117_yarn;
		}
		patched_codec = false;
	}

	/* ----------------------------- UI ----------------------------- */

	function openInflateDialog() {
		const cubes = Cube.selected || [];
		if (!cubes.length) {
			Blockbench.showQuickMessage('Please select at least one cube');
			return;
		}

		const first = cubes[0];
		const inf = getAxisInflate(first);

		new Dialog({
			id: 'kodded_entity_inflate_xyz',
			title: 'Edit XYZ Inflate',
			form: {
				inflate_x: { label: 'Inflate X', type: 'number', value: inf.x, step: 0.1 },
				inflate_y: { label: 'Inflate Y', type: 'number', value: inf.y, step: 0.1 },
				inflate_z: { label: 'Inflate Z', type: 'number', value: inf.z, step: 0.1 },
				sync_base: { label: 'Also set cube.inflate', type: 'checkbox', value: false }
			},
			onConfirm(result) {
				Undo.initEdit({ elements: cubes });

				cubes.forEach(cube => {
					cube.inflate_x = Number(result.inflate_x) || 0;
					cube.inflate_y = Number(result.inflate_y) || 0;
					cube.inflate_z = Number(result.inflate_z) || 0;

					if (result.sync_base) {
						cube.inflate = cube.inflate_x;
					}
				});

				Undo.finishEdit('Set XYZ Inflate');

				cubes.forEach(cube => refreshCube(cube));
				Blockbench.showQuickMessage(`Applied XYZ inflate to ${cubes.length} cube(s)`);
			}
		}).show();
	}

	/* ----------------------------- plugin ----------------------------- */

	Plugin.register(PLUGIN_ID, {
		title: PLUGIN_TITLE,
		author: 'OpenAI',
		icon: PLUGIN_ICON,
		description: 'Per-axis inflate preview + modded_entity export support',
		version: '1.1.1',
		variant: 'both',

		onload() {
			ensureCubeProperties();

			const preview_ok = patchPreview();
			if (!preview_ok) {
				console.warn(`[${PLUGIN_ID}] Failed to patch Cube.preview_controller; preview support may not work in this Blockbench version.`);
			}

			const codec = Codecs.modded_entity;
			if (codec) {
				patchTemplates(codec);
				patchCompile(codec);
			} else {
				console.warn(`[${PLUGIN_ID}] modded_entity codec not found; export patch skipped.`);
			}

			action_edit_inflate = new Action('kodded_entity_edit_inflate', {
				name: 'Edit XYZ Inflate',
				description: 'Edit inflate_x / inflate_y / inflate_z for selected cubes',
				icon: 'open_with',
				category: 'tools',
				condition: () => Cube.selected && Cube.selected.length > 0,
				click() {
					openInflateDialog();
				}
			});

			MenuBar.addAction(action_edit_inflate, 'tools');

			setTimeout(() => refreshAllCubes(), 100);
			Blockbench.showQuickMessage('kodded_entity loaded');
		},

		onunload() {
			if (action_edit_inflate) {
				action_edit_inflate.delete();
				action_edit_inflate = null;
			}

			restorePreview();
			restoreCodec(Codecs.modded_entity);

			try {
				refreshAllCubes();
			} catch (e) {}
		}
	});

})();