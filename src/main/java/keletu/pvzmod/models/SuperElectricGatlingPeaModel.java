package keletu.pvzmod.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import keletu.pvzmod.PVZMod;
import keletu.pvzmod.entities.EntitySuperElectricGatlingPea;
import keletu.pvzmod.models.anim.SGPAnimation;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class SuperElectricGatlingPeaModel extends HierarchicalModel<EntitySuperElectricGatlingPea> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(PVZMod.MODID, "textures/entity/plant/super_electric_gatling_pea.png"), "main");

    private final ModelPart root;
    private final ModelPart all;
    private final ModelPart head;
    private final ModelPart ye;
    private final ModelPart dian1;
    private final ModelPart dian2;
    private final ModelPart dian3;
    private final ModelPart dian5;
    private final ModelPart face;
    private final ModelPart eye;
    private final ModelPart mouth;
    private final ModelPart qiang;
    private final ModelPart mouth1;
    private final ModelPart hat;
    private final ModelPart star1;
    private final ModelPart star2;
    private final ModelPart star3;
    private final ModelPart star4;
    private final ModelPart star5;
    private final ModelPart star6;
    private final ModelPart jin;
    private final ModelPart bone;
    private final ModelPart jin1;
    private final ModelPart bone2;
    private final ModelPart bone3;
    private final ModelPart bone4;
    private final ModelPart bone5;
    private final ModelPart leave5;
    private final ModelPart leave1;
    private final ModelPart leave2;
    private final ModelPart leave3;
    private final ModelPart leave4;

    public SuperElectricGatlingPeaModel(ModelPart root) {
        this.root = root;
        this.all = root.getChild("all");
        this.head = this.all.getChild("head");
        this.ye = this.head.getChild("ye");
        this.dian1 = this.ye.getChild("dian1");
        this.dian2 = this.ye.getChild("dian2");
        this.dian3 = this.ye.getChild("dian3");
        this.dian5 = this.ye.getChild("dian5");
        this.face = this.head.getChild("face");
        this.eye = this.head.getChild("eye");
        this.mouth = this.head.getChild("mouth");
        this.qiang = this.mouth.getChild("qiang");
        this.mouth1 = this.mouth.getChild("mouth1");
        this.hat = this.head.getChild("hat");
        this.star1 = this.hat.getChild("star1");
        this.star2 = this.hat.getChild("star2");
        this.star3 = this.hat.getChild("star3");
        this.star4 = this.hat.getChild("star4");
        this.star5 = this.hat.getChild("star5");
        this.star6 = this.hat.getChild("star6");
        this.jin = this.all.getChild("jin");
        this.bone = this.jin.getChild("bone");
        this.jin1 = this.jin.getChild("jin1");
        this.bone2 = this.jin1.getChild("bone2");
        this.bone3 = this.jin1.getChild("bone3");
        this.bone4 = this.jin1.getChild("bone4");
        this.bone5 = this.jin1.getChild("bone5");
        this.leave5 = this.all.getChild("leave5");
        this.leave1 = this.leave5.getChild("leave1");
        this.leave2 = this.leave5.getChild("leave2");
        this.leave3 = this.leave5.getChild("leave3");
        this.leave4 = this.leave5.getChild("leave4");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition all = partdefinition.addOrReplaceChild("all", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition head = all.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 18).addBox(-4.5F, -4.5F, -4.5F, 10.0F, 9.0F, 9.0F, new CubeDeformation(0.0F).extend(-9.9F, -8.9F, -8.9F))
                .texOffs(38, 18).addBox(-4.0F, -4.0F, -4.0F, 9.0F, 8.0F, 8.0F, new CubeDeformation(0F)), PartPose.offset(-1.0F, -14.0F, 0.0F));

        PartDefinition ye = head.addOrReplaceChild("ye", CubeListBuilder.create(), PartPose.offset(-3.6848F, 1.4428F, 1.5F));

        PartDefinition dian1 = ye.addOrReplaceChild("dian1", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.2001F, 3.05F, 0.0F, -0.2104F, 0.0579F, -1.2713F));

        PartDefinition cube_r1 = dian1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-1.9827F, -0.5F, -0.0951F, 0.7028F, 1.0F, 0.1851F, new CubeDeformation(-0.0001F))
                .texOffs(36, 51).mirror().addBox(-1.6799F, -0.5F, -0.0951F, 0.4F, 1.0F, 1.0F, new CubeDeformation(0.003F)).mirror(false), PartPose.offsetAndRotation(0.6078F, -0.2997F, 0.01F, 1.5708F, 0.0F, -0.7854F));

        PartDefinition cube_r2 = dian1.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(42, 17).addBox(0.0554F, -0.5F, 0.2333F, 3.9392F, 1.0F, 0.6946F, new CubeDeformation(0F)), PartPose.offsetAndRotation(0.1835F, 0.1246F, 0.01F, 1.5708F, 0.0F, 0.9599F));

        PartDefinition cube_r3 = dian1.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(56, 88).addBox(0.0951F, -0.5F, -0.0299F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F).extend(0.0001F, 0.0001F, -0.2499F)), PartPose.offsetAndRotation(0.1835F, 0.1246F, 0.01F, 1.5708F, 0.0F, 0.7854F));

        PartDefinition cube_outline_r1 = dian1.addOrReplaceChild("cube_outline_r1", CubeListBuilder.create().texOffs(16, 91).addBox(-0.5299F, -1.0F, -0.5951F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-1.9F)), PartPose.offsetAndRotation(-0.1092F, 0.4193F, 0.0001F, 1.5708F, 0.0F, -0.7854F));

        PartDefinition cube_outline_r2 = dian1.addOrReplaceChild("cube_outline_r2", CubeListBuilder.create().texOffs(90, 8).addBox(0.5338F, -1.0F, -0.2352F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F).extend(-4.015F, -1.9F, -0.856F)), PartPose.offsetAndRotation(0.1736F, 0.1365F, 0.0001F, 1.5708F, 0.0F, 0.9599F));

        PartDefinition cube_outline_r3 = dian1.addOrReplaceChild("cube_outline_r3", CubeListBuilder.create().texOffs(78, 8).addBox(0.5451F, -1.0F, -0.0299F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F).extend(-4.05F, -1.9F, -2.15F)), PartPose.offsetAndRotation(0.1736F, 0.1365F, 0.0001F, 1.5708F, 0.0F, 0.7854F));

        PartDefinition cube_outline_r4 = dian1.addOrReplaceChild("cube_outline_r4", CubeListBuilder.create().texOffs(56, 75).addBox(-2.5828F, -1.0F, -0.6F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F).extend(-1.8F, -1.9F, -0.89F)), PartPose.offsetAndRotation(0.6035F, -0.2862F, 0.0F, 1.5708F, 0.0F, -0.7854F));

        PartDefinition cube_r4 = dian1.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(34, 49).addBox(-0.1799F, -0.5F, -0.0951F, 1.9F, 1.0F, 1.0F, new CubeDeformation(0.003F))
                .texOffs(36, 51).addBox(-0.6799F, -0.5F, 0.9049F, 0.5F, 1.0F, 1.4F, new CubeDeformation(0.001F))
                .texOffs(34, 51).addBox(-0.8799F, -0.5F, -0.0951F, 0.7F, 1.0F, 1.0F, new CubeDeformation(0.002F))
                .texOffs(56, 91).addBox(-0.1799F, -0.5F, 0.9049F, 0.5F, 1.0F, 3.0F, new CubeDeformation(0.0002F)), PartPose.offsetAndRotation(0.1835F, 0.1246F, 0.01F, 1.5708F, 0.0F, -0.7854F));

        PartDefinition cube_outline_r5 = dian1.addOrReplaceChild("cube_outline_r5", CubeListBuilder.create().texOffs(82, 86).addBox(-10.2742F, -1.0F, 7.6705F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F).extend(-1.0856F, -1.9F, -4.11F)), PartPose.offsetAndRotation(11.3938F, 3.1163F, 0.0F, 1.5708F, 0.0F, -0.48F));

        PartDefinition cube_r5 = dian1.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(68, 90).addBox(-1.918F, -0.5F, -0.5103F, 0.5F, 1.0F, 4.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(0.6078F, -0.2997F, 0.01F, 1.5708F, 0.0F, -0.48F));

        PartDefinition cube_outline_r6 = dian1.addOrReplaceChild("cube_outline_r6", CubeListBuilder.create().texOffs(88, 73).addBox(-0.4124F, -1.0019F, 1.3202F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F).extend(-1.118F, -1.9F, -3.0053F)), PartPose.offsetAndRotation(0.191F, 0.1332F, 0.0019F, 1.5708F, 0.0F, -0.7854F));

        PartDefinition cube_outline_r7 = dian1.addOrReplaceChild("cube_outline_r7", CubeListBuilder.create().texOffs(8, 91).addBox(0.4201F, -1.0F, -0.5951F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F).extend(-1.7F, -1.9F, -1.9F)), PartPose.offsetAndRotation(0.1736F, 0.1365F, 0.0001F, 1.5708F, 0.0F, -0.7854F));

        PartDefinition dian2 = ye.addOrReplaceChild("dian2", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.2001F, 3.05F, -3.0F, 0.2104F, -0.0579F, -1.2713F));

        PartDefinition cube_r6 = dian2.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 0).addBox(-1.9827F, -0.5F, -0.0951F, 0.7028F, 1.0F, 0.1851F, new CubeDeformation(-0.0001F))
                .texOffs(36, 51).mirror().addBox(-1.6799F, -0.5F, -0.0951F, 0.4F, 1.0F, 1.0F, new CubeDeformation(0.003F)).mirror(false), PartPose.offsetAndRotation(0.6078F, -0.2997F, 0.01F, 1.5708F, 0.0F, -0.7854F));

        PartDefinition cube_r7 = dian2.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(42, 17).addBox(0.0554F, -0.5F, 0.2333F, 3.9392F, 1.0F, 0.6946F, new CubeDeformation(0F)), PartPose.offsetAndRotation(0.1835F, 0.1246F, 0.01F, 1.5708F, 0.0F, 0.9599F));

        PartDefinition cube_r8 = dian2.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(56, 88).addBox(0.0951F, -0.5F, -0.0299F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F).extend(0.0001F, 0.0001F, -0.2499F)), PartPose.offsetAndRotation(0.1835F, 0.1246F, 0.01F, 1.5708F, 0.0F, 0.7854F));

        PartDefinition cube_outline_r8 = dian2.addOrReplaceChild("cube_outline_r8", CubeListBuilder.create().texOffs(16, 91).addBox(-0.5299F, -1.0F, -0.5951F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-1.9F)), PartPose.offsetAndRotation(-0.1092F, 0.4193F, 0.0F, 1.5708F, 0.0F, -0.7854F));

        PartDefinition cube_outline_r9 = dian2.addOrReplaceChild("cube_outline_r9", CubeListBuilder.create().texOffs(90, 8).addBox(0.5338F, -1.0F, -0.2352F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F).extend(-4.015F, -1.9F, -0.856F)), PartPose.offsetAndRotation(0.1736F, 0.1365F, 0.0F, 1.5708F, 0.0F, 0.9599F));

        PartDefinition cube_outline_r10 = dian2.addOrReplaceChild("cube_outline_r10", CubeListBuilder.create().texOffs(78, 8).addBox(0.5451F, -1.0F, -0.0299F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F).extend(-4.05F, -1.9F, -2.15F)), PartPose.offsetAndRotation(0.1736F, 0.1365F, 0.0F, 1.5708F, 0.0F, 0.7854F));

        PartDefinition cube_outline_r11 = dian2.addOrReplaceChild("cube_outline_r11", CubeListBuilder.create().texOffs(56, 75).addBox(-2.5828F, -1.0F, -0.6F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F).extend(-1.8F, -1.9F, -0.89F)), PartPose.offsetAndRotation(0.6035F, -0.2862F, 0.0F, 1.5708F, 0.0F, -0.7854F));

        PartDefinition cube_r9 = dian2.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(34, 49).addBox(-0.1799F, -0.5F, -0.0951F, 1.9F, 1.0F, 1.0F, new CubeDeformation(0.003F))
                .texOffs(36, 51).addBox(-0.6799F, -0.5F, 0.9049F, 0.5F, 1.0F, 1.4F, new CubeDeformation(0.001F))
                .texOffs(34, 51).addBox(-0.8799F, -0.5F, -0.0951F, 0.7F, 1.0F, 1.0F, new CubeDeformation(0.002F))
                .texOffs(56, 91).addBox(-0.1799F, -0.5F, 0.9049F, 0.5F, 1.0F, 3.0F, new CubeDeformation(0.0002F)), PartPose.offsetAndRotation(0.1835F, 0.1246F, 0.01F, 1.5708F, 0.0F, -0.7854F));

        PartDefinition cube_outline_r12 = dian2.addOrReplaceChild("cube_outline_r12", CubeListBuilder.create().texOffs(82, 86).addBox(-10.2742F, -1.0F, 7.6705F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F).extend(-1.0856F, -1.9F, -4.11F)), PartPose.offsetAndRotation(11.3938F, 3.1163F, 0.0F, 1.5708F, 0.0F, -0.48F));

        PartDefinition cube_r10 = dian2.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(68, 90).addBox(-1.918F, -0.5F, -0.5103F, 0.5F, 1.0F, 4.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(0.6078F, -0.2997F, 0.01F, 1.5708F, 0.0F, -0.48F));

        PartDefinition cube_outline_r13 = dian2.addOrReplaceChild("cube_outline_r13", CubeListBuilder.create().texOffs(88, 73).addBox(-0.4124F, -1.0019F, 1.3202F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F).extend(-1.118F, -1.9F, -3.0053F)), PartPose.offsetAndRotation(0.191F, 0.1332F, 0.0019F, 1.5708F, 0.0F, -0.7854F));

        PartDefinition cube_outline_r14 = dian2.addOrReplaceChild("cube_outline_r14", CubeListBuilder.create().texOffs(8, 91).addBox(0.4201F, -1.0F, -0.5951F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F).extend(-1.7F, -1.9F, -1.9F)), PartPose.offsetAndRotation(0.1736F, 0.1365F, 0.0F, 1.5708F, 0.0F, -0.7854F));

        PartDefinition dian3 = ye.addOrReplaceChild("dian3", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.0999F, 4.5F, 2.3F, -0.4363F, 0.0F, -1.789F));

        PartDefinition cube_r11 = dian3.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(0, 0).addBox(-1.9827F, -0.5F, -0.0951F, 0.7028F, 1.0F, 0.1851F, new CubeDeformation(-0.0001F))
                .texOffs(36, 51).mirror().addBox(-1.6799F, -0.5F, -0.0951F, 0.4F, 1.0F, 1.0F, new CubeDeformation(0.003F)).mirror(false), PartPose.offsetAndRotation(0.6078F, -0.2998F, 0.01F, 1.5708F, 0.0F, -0.7854F));

        PartDefinition cube_r12 = dian3.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(42, 17).addBox(0.0554F, -0.5F, 0.2333F, 3.9392F, 1.0F, 0.6946F, new CubeDeformation(0F)), PartPose.offsetAndRotation(0.1835F, 0.1245F, 0.01F, 1.5708F, 0.0F, 0.9599F));

        PartDefinition cube_r13 = dian3.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(56, 88).addBox(0.0951F, -0.5F, -0.0299F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F).extend(0.0001F, 0.0001F, -0.2499F)), PartPose.offsetAndRotation(0.1835F, 0.1245F, 0.01F, 1.5708F, 0.0F, 0.7854F));

        PartDefinition cube_outline_r15 = dian3.addOrReplaceChild("cube_outline_r15", CubeListBuilder.create().texOffs(16, 91).addBox(-0.5299F, -1.0F, -0.5951F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-1.9F)), PartPose.offsetAndRotation(-0.1092F, 0.4192F, 0.0F, 1.5708F, 0.0F, -0.7854F));

        PartDefinition cube_outline_r16 = dian3.addOrReplaceChild("cube_outline_r16", CubeListBuilder.create().texOffs(90, 8).addBox(0.5338F, -1.0F, -0.2352F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F).extend(-4.015F, -1.9F, -0.856F)), PartPose.offsetAndRotation(0.1736F, 0.1364F, 0.0F, 1.5708F, 0.0F, 0.9599F));

        PartDefinition cube_outline_r17 = dian3.addOrReplaceChild("cube_outline_r17", CubeListBuilder.create().texOffs(78, 8).addBox(0.5451F, -1.0F, -0.0299F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F).extend(-4.05F, -1.9F, -2.15F)), PartPose.offsetAndRotation(0.1736F, 0.1364F, 0.0F, 1.5708F, 0.0F, 0.7854F));

        PartDefinition cube_outline_r18 = dian3.addOrReplaceChild("cube_outline_r18", CubeListBuilder.create().texOffs(56, 75).addBox(-2.5828F, -1.0F, -0.6F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F).extend(-1.8F, -1.9F, -0.89F)), PartPose.offsetAndRotation(0.6035F, -0.2863F, 0.0F, 1.5708F, 0.0F, -0.7854F));

        PartDefinition cube_r14 = dian3.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(34, 49).addBox(-0.1799F, -0.5F, -0.0951F, 1.9F, 1.0F, 1.0F, new CubeDeformation(0.003F))
                .texOffs(36, 51).addBox(-0.6799F, -0.5F, 0.9049F, 0.5F, 1.0F, 1.4F, new CubeDeformation(0.001F))
                .texOffs(34, 51).addBox(-0.8799F, -0.5F, -0.0951F, 0.7F, 1.0F, 1.0F, new CubeDeformation(0.002F))
                .texOffs(56, 91).addBox(-0.1799F, -0.5F, 0.9049F, 0.5F, 1.0F, 3.0F, new CubeDeformation(0.0002F)), PartPose.offsetAndRotation(0.1835F, 0.1245F, 0.01F, 1.5708F, 0.0F, -0.7854F));

        PartDefinition cube_outline_r19 = dian3.addOrReplaceChild("cube_outline_r19", CubeListBuilder.create().texOffs(82, 86).addBox(-10.2742F, -1.0F, 7.6705F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F).extend(-1.0856F, -1.9F, -4.11F)), PartPose.offsetAndRotation(11.3938F, 3.1162F, 0.0F, 1.5708F, 0.0F, -0.48F));

        PartDefinition cube_r15 = dian3.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(68, 90).addBox(-1.918F, -0.5F, -0.5103F, 0.5F, 1.0F, 4.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(0.6078F, -0.2998F, 0.01F, 1.5708F, 0.0F, -0.48F));

        PartDefinition cube_outline_r20 = dian3.addOrReplaceChild("cube_outline_r20", CubeListBuilder.create().texOffs(88, 73).addBox(-0.4124F, -1.0019F, 1.3202F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F).extend(-1.118F, -1.9F, -3.0053F)), PartPose.offsetAndRotation(0.191F, 0.1331F, 0.0019F, 1.5708F, 0.0F, -0.7854F));

        PartDefinition cube_outline_r21 = dian3.addOrReplaceChild("cube_outline_r21", CubeListBuilder.create().texOffs(8, 91).addBox(0.4201F, -1.0F, -0.5951F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F).extend(-1.7F, -1.9F, -1.9F)), PartPose.offsetAndRotation(0.1736F, 0.1364F, 0.0F, 1.5708F, 0.0F, -0.7854F));

        PartDefinition dian5 = ye.addOrReplaceChild("dian5", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.0999F, 4.5F, -5.3F, 0.4363F, 0.0F, -1.789F));

        PartDefinition cube_r16 = dian5.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(0, 0).addBox(-1.9827F, -0.5F, -0.0951F, 0.7028F, 1.0F, 0.1851F, new CubeDeformation(-0.0001F))
                .texOffs(36, 51).mirror().addBox(-1.6799F, -0.5F, -0.0951F, 0.4F, 1.0F, 1.0F, new CubeDeformation(0.003F)).mirror(false), PartPose.offsetAndRotation(0.6078F, -0.2998F, 0.01F, 1.5708F, 0.0F, -0.7854F));

        PartDefinition cube_r17 = dian5.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(42, 17).addBox(0.0554F, -0.5F, 0.2333F, 3.9392F, 1.0F, 0.6946F, new CubeDeformation(0F)), PartPose.offsetAndRotation(0.1835F, 0.1245F, 0.01F, 1.5708F, 0.0F, 0.9599F));

        PartDefinition cube_r18 = dian5.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(56, 88).addBox(0.0951F, -0.5F, -0.0299F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F).extend(0.0001F, 0.0001F, -0.2499F)), PartPose.offsetAndRotation(0.1835F, 0.1245F, 0.01F, 1.5708F, 0.0F, 0.7854F));

        PartDefinition cube_outline_r22 = dian5.addOrReplaceChild("cube_outline_r22", CubeListBuilder.create().texOffs(16, 91).addBox(-0.5299F, -1.0F, -0.5951F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-1.9F)), PartPose.offsetAndRotation(-0.1092F, 0.4192F, 0.0001F, 1.5708F, 0.0F, -0.7854F));

        PartDefinition cube_outline_r23 = dian5.addOrReplaceChild("cube_outline_r23", CubeListBuilder.create().texOffs(90, 8).addBox(0.5338F, -1.0F, -0.2352F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F).extend(-4.015F, -1.9F, -0.856F)), PartPose.offsetAndRotation(0.1736F, 0.1364F, 0.0001F, 1.5708F, 0.0F, 0.9599F));

        PartDefinition cube_outline_r24 = dian5.addOrReplaceChild("cube_outline_r24", CubeListBuilder.create().texOffs(78, 8).addBox(0.5451F, -1.0F, -0.0299F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F).extend(-4.05F, -1.9F, -2.15F)), PartPose.offsetAndRotation(0.1736F, 0.1364F, 0.0001F, 1.5708F, 0.0F, 0.7854F));

        PartDefinition cube_outline_r25 = dian5.addOrReplaceChild("cube_outline_r25", CubeListBuilder.create().texOffs(56, 75).addBox(-2.5828F, -1.0F, -0.6F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F).extend(-1.8F, -1.9F, -0.89F)), PartPose.offsetAndRotation(0.6035F, -0.2863F, 0.0F, 1.5708F, 0.0F, -0.7854F));

        PartDefinition cube_r19 = dian5.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(34, 49).addBox(-0.1799F, -0.5F, -0.0951F, 1.9F, 1.0F, 1.0F, new CubeDeformation(0.003F))
                .texOffs(36, 51).addBox(-0.6799F, -0.5F, 0.9049F, 0.5F, 1.0F, 1.4F, new CubeDeformation(0.001F))
                .texOffs(34, 51).addBox(-0.8799F, -0.5F, -0.0951F, 0.7F, 1.0F, 1.0F, new CubeDeformation(0.002F))
                .texOffs(56, 91).addBox(-0.1799F, -0.5F, 0.9049F, 0.5F, 1.0F, 3.0F, new CubeDeformation(0.0002F)), PartPose.offsetAndRotation(0.1835F, 0.1245F, 0.01F, 1.5708F, 0.0F, -0.7854F));

        PartDefinition cube_outline_r26 = dian5.addOrReplaceChild("cube_outline_r26", CubeListBuilder.create().texOffs(82, 86).addBox(-10.2742F, -1.0F, 7.6705F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F).extend(-1.0856F, -1.9F, -4.11F)), PartPose.offsetAndRotation(11.3938F, 3.1162F, 0.0F, 1.5708F, 0.0F, -0.48F));

        PartDefinition cube_r20 = dian5.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(68, 90).addBox(-1.918F, -0.5F, -0.5103F, 0.5F, 1.0F, 4.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(0.6078F, -0.2998F, 0.01F, 1.5708F, 0.0F, -0.48F));

        PartDefinition cube_outline_r27 = dian5.addOrReplaceChild("cube_outline_r27", CubeListBuilder.create().texOffs(88, 73).addBox(-0.4124F, -1.0019F, 1.3201F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F).extend(-1.118F, -1.9F, -3.0053F)), PartPose.offsetAndRotation(0.191F, 0.1331F, 0.0019F, 1.5708F, 0.0F, -0.7854F));

        PartDefinition cube_outline_r28 = dian5.addOrReplaceChild("cube_outline_r28", CubeListBuilder.create().texOffs(8, 91).addBox(0.4201F, -1.0F, -0.5951F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F).extend(-1.7F, -1.9F, -1.9F)), PartPose.offsetAndRotation(0.1736F, 0.1364F, 0.0001F, 1.5708F, 0.0F, -0.7854F));

        PartDefinition face = head.addOrReplaceChild("face", CubeListBuilder.create().texOffs(88, 59).addBox(-1.5F, -1.5F, 2.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(-0.001F))
                .texOffs(88, 64).addBox(-1.5F, -1.5F, -4.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(-0.001F)), PartPose.offset(3.5F, 1.5F, 0.0F));

        PartDefinition eye = head.addOrReplaceChild("eye", CubeListBuilder.create().texOffs(40, 92).addBox(-1.5F, -1.5F, -4.0688F, 3.0F, 3.0F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(82, 92).addBox(-1.8F, -1.8F, -4.0438F, 3.6F, 3.6F, 0.0F, new CubeDeformation(0F))
                .texOffs(92, 86).addBox(-1.8F, -1.8F, 4.0313F, 3.6F, 3.6F, 0.0F, new CubeDeformation(0F))
                .texOffs(89, 92).addBox(-1.5F, -1.5F, 4.0812F, 3.0F, 3.0F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offset(1.5F, -1.5F, -0.0063F));

        PartDefinition mouth = head.addOrReplaceChild("mouth", CubeListBuilder.create().texOffs(56, 78).addBox(-2.5667F, -2.5F, -2.5F, 2.0F, 5.0F, 5.0F, new CubeDeformation(0.0F).extend(-1.65F, -4.8F, -4.8F))
                .texOffs(82, 78).addBox(-2.6167F, -2.0F, -2.0F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0F)), PartPose.offset(7.6167F, 0.0F, 0.0F));

        PartDefinition qiang = mouth.addOrReplaceChild("qiang", CubeListBuilder.create(), PartPose.offset(2.0974F, 0.0167F, -0.0009F));

        PartDefinition cube_r21 = qiang.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(36, 88).addBox(-2.0F, -1.0F, -1.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F).extend(0F, -0.25F, -0.25F)), PartPose.offsetAndRotation(0.0F, 1.0035F, 0.0F, -2.3562F, 0.0F, 0.1309F));

        PartDefinition cube_r22 = qiang.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(24, 87).addBox(-2.0F, -1.0F, -1.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F).extend(0F, -0.25F, -0.25F)), PartPose.offsetAndRotation(0.0F, -1.0036F, 0.0F, -2.3562F, 0.0F, -0.1309F));

        PartDefinition cube_r23 = qiang.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(12, 87).addBox(-2.0F, -1.0F, -1.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F).extend(0F, -0.25F, -0.25F)), PartPose.offsetAndRotation(0.0F, 0.0F, -1.3536F, -1.5708F, 0.1309F, 0.0F));

        PartDefinition cube_r24 = qiang.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(0, 87).addBox(-2.0F, -1.0F, -1.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F).extend(0F, -0.25F, -0.25F)), PartPose.offsetAndRotation(0.0F, 0.0F, 1.3536F, -1.5708F, -0.1309F, 0.0F));

        PartDefinition mouth1 = mouth.addOrReplaceChild("mouth1", CubeListBuilder.create().texOffs(20, 75).addBox(-0.325F, -3.0F, -3.0F, 2.0F, 6.0F, 6.0F, new CubeDeformation(0.1F))
                .texOffs(0, 73).addBox(-0.825F, -3.5F, -3.5F, 3.0F, 7.0F, 7.0F, new CubeDeformation(0.0F).extend(-2.9F, -6.9F, -6.9F))
                .texOffs(70, 78).addBox(1.325F, -3.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0001F)), PartPose.offset(-0.1917F, 0.0F, 0.0F));

        PartDefinition hat = head.addOrReplaceChild("hat", CubeListBuilder.create().texOffs(0, 0).addBox(-6.5574F, -4.3774F, -4.0919F, 12.0F, 9.0F, 9.0F, new CubeDeformation(0F))
                .texOffs(34, 60).addBox(-5.3074F, -0.3774F, -5.0919F, 4.0F, 4.0F, 11.0F, new CubeDeformation(0F))
                .texOffs(42, 0).addBox(0.4426F, -0.3774F, -5.0919F, 7.0F, 1.0F, 11.0F, new CubeDeformation(0F))
                .texOffs(0, 36).addBox(0.5926F, -0.3774F, -5.5919F, 7.0F, 1.0F, 12.0F, new CubeDeformation(0.0F).extend(0.19F, 0.09F, -0.16F))
                .texOffs(0, 61).addBox(-7.6574F, 3.6226F, -5.0919F, 5.0F, 1.0F, 11.0F, new CubeDeformation(0.0F).extend(-0.1F, 0F, 0F))
                .texOffs(38, 47).addBox(-7.7824F, 3.6226F, -5.5919F, 5.0F, 1.0F, 12.0F, new CubeDeformation(0.0F).extend(0.135F, 0.11F, -0.14F)), PartPose.offsetAndRotation(-0.093F, -3.2724F, -0.409F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cube_r25 = hat.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(38, 34).addBox(-3.896F, -1.0758F, -3.6828F, 6.0F, 1.0F, 12.0F, new CubeDeformation(0.0F).extend(-0.0528F, 0.1322F, -0.15F))
                .texOffs(0, 49).addBox(-3.9129F, -1.0943F, -3.1828F, 6.0F, 1.0F, 11.0F, new CubeDeformation(0.0F).extend(-0.0759F, 0.0094F, 0F)), PartPose.offsetAndRotation(-0.1025F, 1.851F, -1.9091F, 0.0F, 0.0F, -0.829F));

        PartDefinition cube_r26 = hat.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(88, 69).addBox(-2.9503F, 1.8971F, -2.9328F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F).extend(-0.25F, 0F, -0.25F))
                .texOffs(78, 0).addBox(-2.9503F, 5.9471F, -0.6828F, 3.0F, 2.0F, 6.0F, new CubeDeformation(-0.25F))
                .texOffs(64, 60).addBox(-2.4503F, -0.4529F, -2.6828F, 2.0F, 8.0F, 10.0F, new CubeDeformation(0.0F).extend(0F, -0.25F, -0.25F)), PartPose.offsetAndRotation(-0.1025F, 1.851F, -1.9091F, 0.0F, 0.0F, -0.3054F));

        PartDefinition cube_r27 = hat.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(76, 90).addBox(-2.4503F, 3.2745F, -1.3651F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F).extend(0F, -0.25F, -0.125F)), PartPose.offsetAndRotation(-0.1025F, 1.851F, -1.9091F, -0.48F, 0.0F, -0.3054F));

        PartDefinition cube_r28 = hat.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(62, 91).addBox(6.2406F, 3.5056F, -2.7692F, 0.0F, 1.25F, 3.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-2.9525F, 1.851F, -1.9091F, 0.6545F, 0.0F, -1.5708F));

        PartDefinition cube_r29 = hat.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(62, 91).mirror().addBox(6.2406F, 0.6843F, 3.4459F, 0.0F, 1.25F, 3.0F, new CubeDeformation(0.0001F)).mirror(false), PartPose.offsetAndRotation(-2.9525F, 1.851F, -1.9091F, -0.6545F, 0.0F, -1.5708F));

        PartDefinition cube_r30 = hat.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(62, 91).addBox(6.2406F, 3.5056F, -2.9692F, 0.0F, 1.2F, 3.2F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.2011F, 1.851F, -1.7917F, 0.6109F, 0.0F, -1.5708F));

        PartDefinition cube_r31 = hat.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(62, 91).mirror().addBox(0.0F, -0.625F, -1.5F, 0.0F, 1.2F, 3.2F, new CubeDeformation(0.0001F)).mirror(false), PartPose.offsetAndRotation(3.9105F, -4.3896F, 1.2784F, -0.6109F, 0.0F, -1.5708F));

        PartDefinition cube_r32 = hat.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(32, 92).addBox(0.0F, -0.5F, -1.75F, 0.0F, 1.0F, 3.25F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(5.5107F, -2.8049F, 1.5915F, -0.5847F, 0.0F, 0.0F));

        PartDefinition cube_r33 = hat.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(62, 91).addBox(5.6132F, -3.3803F, 2.2645F, 0.0F, 1.0F, 3.25F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.1025F, 1.6747F, -2.3247F, 0.5847F, 0.0F, 0.0F));

        PartDefinition star1 = hat.addOrReplaceChild("star1", CubeListBuilder.create().texOffs(48, 17).addBox(-0.537F, -0.7469F, 0.0F, 1.0F, 1.4F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(0, 0).addBox(-0.737F, 0.4531F, 0.0F, 0.4F, 0.4F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(0, 0).addBox(-0.937F, 0.7531F, 0.0F, 0.3F, 0.3F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(0, 0).addBox(0.263F, 0.4531F, 0.0F, 0.4F, 0.4F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(0, 0).addBox(0.563F, 0.7531F, 0.0F, 0.3F, 0.3F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(0, 0).addBox(-0.237F, -1.5469F, 0.0F, 0.4F, 0.8F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(48, 17).addBox(-0.787F, -0.5219F, 0.0F, 1.5F, 1.0F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(0, 0).addBox(0.713F, -0.5219F, 0.0F, 0.5F, 0.2F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(0, 0).addBox(-1.287F, -0.5219F, 0.0F, 0.5F, 0.2F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(0, 0).addBox(0.713F, -0.3219F, 0.0F, 0.3F, 0.2F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(0, 0).addBox(-1.087F, -0.3219F, 0.0F, 0.3F, 0.2F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offset(-4.1204F, -2.0959F, -4.1419F));

        PartDefinition cube_r34 = star1.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(0, 0).addBox(-0.1442F, -0.3185F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(1.2834F, -0.606F, 1.0F, 0.0F, 0.0F, 1.5708F));

        PartDefinition cube_r35 = star1.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(0, 0).addBox(0.0256F, -0.2771F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(1.2834F, -0.606F, 1.0F, 0.0F, 0.0F, 0.9599F));

        PartDefinition cube_r36 = star1.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(0, 0).addBox(-0.2896F, -0.2896F, -1.0F, 0.1565F, 0.1564F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-1.4242F, -0.5549F, 1.0F, 0.0F, 0.0F, -0.48F));

        PartDefinition cube_r37 = star1.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(0, 0).addBox(-0.1954F, -0.2518F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-1.4242F, -0.5549F, 1.0F, 0.0F, 0.0F, -0.9599F));

        PartDefinition cube_r38 = star1.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(0, 0).addBox(-0.0546F, -0.2518F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-1.4242F, -0.5549F, 1.0F, 0.0F, 0.0F, -1.5708F));

        PartDefinition cube_r39 = star1.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(0, 0).addBox(-0.2896F, -0.2896F, -1.0F, 0.1565F, 0.1564F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.8713F, 1.0739F, 1.0F, 0.0F, 0.0F, -1.7453F));

        PartDefinition cube_r40 = star1.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(0, 0).addBox(-0.0546F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.8713F, 1.0739F, 1.0F, 0.0F, 0.0F, -2.8362F));

        PartDefinition cube_r41 = star1.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(0, 0).addBox(-0.1954F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.8713F, 1.0739F, 1.0F, 0.0F, 0.0F, -2.2253F));

        PartDefinition cube_r42 = star1.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(0, 0).addBox(-0.0546F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(0.7972F, 1.0739F, 1.0F, 0.0F, 0.0F, 2.2253F));

        PartDefinition cube_r43 = star1.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(0, 0).addBox(-0.2896F, -0.2896F, -1.0F, 0.1565F, 0.1564F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(0.7972F, 1.0739F, 1.0F, 0.0F, 0.0F, -2.9671F));

        PartDefinition cube_r44 = star1.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(0, 0).addBox(-0.1954F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(0.7972F, 1.0739F, 1.0F, 0.0F, 0.0F, 2.8362F));

        PartDefinition cube_r45 = star1.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(0, 0).addBox(-0.2896F, -0.2896F, -1.0F, 0.1565F, 0.1565F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.037F, -1.5719F, 1.0F, 0.0F, 0.0F, 0.7854F));

        PartDefinition cube_r46 = star1.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(0, 0).addBox(-0.1954F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.037F, -1.5719F, 1.0F, 0.0F, 0.0F, 0.3054F));

        PartDefinition cube_r47 = star1.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(0, 0).addBox(-0.0546F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.037F, -1.5719F, 1.0F, 0.0F, 0.0F, -0.3054F));

        PartDefinition cube_r48 = star1.addOrReplaceChild("cube_r48", CubeListBuilder.create().texOffs(0, 0).addBox(-0.275F, -0.3724F, -1.0F, 0.1564F, 0.1564F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(1.2834F, -0.606F, 1.0F, 0.0F, 0.0F, 2.0508F));

        PartDefinition star2 = hat.addOrReplaceChild("star2", CubeListBuilder.create().texOffs(48, 17).addBox(-0.537F, -0.7469F, 0.0F, 1.0F, 1.4F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(0, 0).addBox(-0.737F, 0.4531F, 0.0F, 0.4F, 0.4F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(0, 0).addBox(-0.937F, 0.7531F, 0.0F, 0.3F, 0.3F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(0, 0).addBox(0.263F, 0.4531F, 0.0F, 0.4F, 0.4F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(0, 0).addBox(0.563F, 0.7531F, 0.0F, 0.3F, 0.3F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(0, 0).addBox(-0.237F, -1.5469F, 0.0F, 0.4F, 0.8F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(48, 17).addBox(-0.787F, -0.5219F, 0.0F, 1.5F, 1.0F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(0, 0).addBox(0.713F, -0.5219F, 0.0F, 0.5F, 0.2F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(0, 0).addBox(-1.287F, -0.5219F, 0.0F, 0.5F, 0.2F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(0, 0).addBox(0.713F, -0.3219F, 0.0F, 0.3F, 0.2F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(0, 0).addBox(-1.087F, -0.3219F, 0.0F, 0.3F, 0.2F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offset(0.2796F, -2.0959F, -4.1419F));

        PartDefinition cube_r49 = star2.addOrReplaceChild("cube_r49", CubeListBuilder.create().texOffs(0, 0).addBox(-0.1442F, -0.3185F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(1.2834F, -0.606F, 1.0F, 0.0F, 0.0F, 1.5708F));

        PartDefinition cube_r50 = star2.addOrReplaceChild("cube_r50", CubeListBuilder.create().texOffs(0, 0).addBox(0.0256F, -0.2771F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(1.2834F, -0.606F, 1.0F, 0.0F, 0.0F, 0.9599F));

        PartDefinition cube_r51 = star2.addOrReplaceChild("cube_r51", CubeListBuilder.create().texOffs(0, 0).addBox(-0.2896F, -0.2896F, -1.0F, 0.1565F, 0.1564F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-1.4242F, -0.5549F, 1.0F, 0.0F, 0.0F, -0.48F));

        PartDefinition cube_r52 = star2.addOrReplaceChild("cube_r52", CubeListBuilder.create().texOffs(0, 0).addBox(-0.1954F, -0.2518F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-1.4242F, -0.5549F, 1.0F, 0.0F, 0.0F, -0.9599F));

        PartDefinition cube_r53 = star2.addOrReplaceChild("cube_r53", CubeListBuilder.create().texOffs(0, 0).addBox(-0.0546F, -0.2518F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-1.4242F, -0.5549F, 1.0F, 0.0F, 0.0F, -1.5708F));

        PartDefinition cube_r54 = star2.addOrReplaceChild("cube_r54", CubeListBuilder.create().texOffs(0, 0).addBox(-0.2896F, -0.2896F, -1.0F, 0.1564F, 0.1564F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.8713F, 1.0739F, 1.0F, 0.0F, 0.0F, -1.7453F));

        PartDefinition cube_r55 = star2.addOrReplaceChild("cube_r55", CubeListBuilder.create().texOffs(0, 0).addBox(-0.0546F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.8713F, 1.0739F, 1.0F, 0.0F, 0.0F, -2.8362F));

        PartDefinition cube_r56 = star2.addOrReplaceChild("cube_r56", CubeListBuilder.create().texOffs(0, 0).addBox(-0.1954F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.8713F, 1.0739F, 1.0F, 0.0F, 0.0F, -2.2253F));

        PartDefinition cube_r57 = star2.addOrReplaceChild("cube_r57", CubeListBuilder.create().texOffs(0, 0).addBox(-0.0546F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(0.7972F, 1.0739F, 1.0F, 0.0F, 0.0F, 2.2253F));

        PartDefinition cube_r58 = star2.addOrReplaceChild("cube_r58", CubeListBuilder.create().texOffs(0, 0).addBox(-0.2896F, -0.2896F, -1.0F, 0.1564F, 0.1564F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(0.7972F, 1.0739F, 1.0F, 0.0F, 0.0F, -2.9671F));

        PartDefinition cube_r59 = star2.addOrReplaceChild("cube_r59", CubeListBuilder.create().texOffs(0, 0).addBox(-0.1954F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(0.7972F, 1.0739F, 1.0F, 0.0F, 0.0F, 2.8362F));

        PartDefinition cube_r60 = star2.addOrReplaceChild("cube_r60", CubeListBuilder.create().texOffs(0, 0).addBox(-0.2896F, -0.2896F, -1.0F, 0.1565F, 0.1565F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.037F, -1.5719F, 1.0F, 0.0F, 0.0F, 0.7854F));

        PartDefinition cube_r61 = star2.addOrReplaceChild("cube_r61", CubeListBuilder.create().texOffs(0, 0).addBox(-0.1954F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.037F, -1.5719F, 1.0F, 0.0F, 0.0F, 0.3054F));

        PartDefinition cube_r62 = star2.addOrReplaceChild("cube_r62", CubeListBuilder.create().texOffs(0, 0).addBox(-0.0546F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.037F, -1.5719F, 1.0F, 0.0F, 0.0F, -0.3054F));

        PartDefinition cube_r63 = star2.addOrReplaceChild("cube_r63", CubeListBuilder.create().texOffs(0, 0).addBox(-0.275F, -0.3724F, -1.0F, 0.1565F, 0.1564F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(1.2834F, -0.606F, 1.0F, 0.0F, 0.0F, 2.0508F));

        PartDefinition star3 = hat.addOrReplaceChild("star3", CubeListBuilder.create().texOffs(48, 17).addBox(-0.537F, -0.7469F, 0.0F, 1.0F, 1.4F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(0, 0).addBox(-0.737F, 0.4531F, 0.0F, 0.4F, 0.4F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(0, 0).addBox(-0.937F, 0.7531F, 0.0F, 0.3F, 0.3F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(0, 0).addBox(0.263F, 0.4531F, 0.0F, 0.4F, 0.4F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(0, 0).addBox(0.563F, 0.7531F, 0.0F, 0.3F, 0.3F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(0, 0).addBox(-0.237F, -1.5469F, 0.0F, 0.4F, 0.8F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(48, 17).addBox(-0.787F, -0.5219F, 0.0F, 1.5F, 1.0F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(0, 0).addBox(0.713F, -0.5219F, 0.0F, 0.5F, 0.2F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(0, 0).addBox(-1.287F, -0.5219F, 0.0F, 0.5F, 0.2F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(0, 0).addBox(0.713F, -0.3219F, 0.0F, 0.3F, 0.2F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(0, 0).addBox(-1.087F, -0.3219F, 0.0F, 0.3F, 0.2F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-1.9204F, -4.3959F, -2.2419F, -1.5708F, 0.0F, 0.0F));

        PartDefinition cube_r64 = star3.addOrReplaceChild("cube_r64", CubeListBuilder.create().texOffs(0, 0).addBox(-0.1442F, -0.3185F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(1.2834F, -0.606F, 1.0F, 0.0F, 0.0F, 1.5708F));

        PartDefinition cube_r65 = star3.addOrReplaceChild("cube_r65", CubeListBuilder.create().texOffs(0, 0).addBox(0.0256F, -0.2771F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(1.2834F, -0.606F, 1.0F, 0.0F, 0.0F, 0.9599F));

        PartDefinition cube_r66 = star3.addOrReplaceChild("cube_r66", CubeListBuilder.create().texOffs(0, 0).addBox(-0.2896F, -0.2896F, -1.0F, 0.1565F, 0.1564F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-1.4242F, -0.5549F, 1.0F, 0.0F, 0.0F, -0.48F));

        PartDefinition cube_r67 = star3.addOrReplaceChild("cube_r67", CubeListBuilder.create().texOffs(0, 0).addBox(-0.1954F, -0.2518F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-1.4242F, -0.5549F, 1.0F, 0.0F, 0.0F, -0.9599F));

        PartDefinition cube_r68 = star3.addOrReplaceChild("cube_r68", CubeListBuilder.create().texOffs(0, 0).addBox(-0.0546F, -0.2518F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-1.4242F, -0.5549F, 1.0F, 0.0F, 0.0F, -1.5708F));

        PartDefinition cube_r69 = star3.addOrReplaceChild("cube_r69", CubeListBuilder.create().texOffs(0, 0).addBox(-0.2896F, -0.2896F, -1.0F, 0.1565F, 0.1564F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.8713F, 1.0739F, 1.0F, 0.0F, 0.0F, -1.7453F));

        PartDefinition cube_r70 = star3.addOrReplaceChild("cube_r70", CubeListBuilder.create().texOffs(0, 0).addBox(-0.0546F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.8713F, 1.0739F, 1.0F, 0.0F, 0.0F, -2.8362F));

        PartDefinition cube_r71 = star3.addOrReplaceChild("cube_r71", CubeListBuilder.create().texOffs(0, 0).addBox(-0.1954F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.8713F, 1.0739F, 1.0F, 0.0F, 0.0F, -2.2253F));

        PartDefinition cube_r72 = star3.addOrReplaceChild("cube_r72", CubeListBuilder.create().texOffs(0, 0).addBox(-0.0546F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(0.7972F, 1.0739F, 1.0F, 0.0F, 0.0F, 2.2253F));

        PartDefinition cube_r73 = star3.addOrReplaceChild("cube_r73", CubeListBuilder.create().texOffs(0, 0).addBox(-0.2896F, -0.2896F, -1.0F, 0.1564F, 0.1564F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(0.7972F, 1.0739F, 1.0F, 0.0F, 0.0F, -2.9671F));

        PartDefinition cube_r74 = star3.addOrReplaceChild("cube_r74", CubeListBuilder.create().texOffs(0, 0).addBox(-0.1954F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(0.7972F, 1.0739F, 1.0F, 0.0F, 0.0F, 2.8362F));

        PartDefinition cube_r75 = star3.addOrReplaceChild("cube_r75", CubeListBuilder.create().texOffs(0, 0).addBox(-0.2896F, -0.2896F, -1.0F, 0.1564F, 0.1565F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.037F, -1.5719F, 1.0F, 0.0F, 0.0F, 0.7854F));

        PartDefinition cube_r76 = star3.addOrReplaceChild("cube_r76", CubeListBuilder.create().texOffs(0, 0).addBox(-0.1954F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.037F, -1.5719F, 1.0F, 0.0F, 0.0F, 0.3054F));

        PartDefinition cube_r77 = star3.addOrReplaceChild("cube_r77", CubeListBuilder.create().texOffs(0, 0).addBox(-0.0546F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.037F, -1.5719F, 1.0F, 0.0F, 0.0F, -0.3054F));

        PartDefinition cube_r78 = star3.addOrReplaceChild("cube_r78", CubeListBuilder.create().texOffs(0, 0).addBox(-0.275F, -0.3724F, -1.0F, 0.1564F, 0.1564F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(1.2834F, -0.606F, 1.0F, 0.0F, 0.0F, 2.0508F));

        PartDefinition star4 = hat.addOrReplaceChild("star4", CubeListBuilder.create().texOffs(48, 17).addBox(-0.537F, -0.7469F, 0.0F, 1.0F, 1.4F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(0, 0).addBox(-0.737F, 0.4531F, 0.0F, 0.4F, 0.4F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(0, 0).addBox(-0.937F, 0.7531F, 0.0F, 0.3F, 0.3F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(0, 0).addBox(0.263F, 0.4531F, 0.0F, 0.4F, 0.4F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(0, 0).addBox(0.563F, 0.7531F, 0.0F, 0.3F, 0.3F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(0, 0).addBox(-0.237F, -1.5469F, 0.0F, 0.4F, 0.8F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(48, 17).addBox(-0.787F, -0.5219F, 0.0F, 1.5F, 1.0F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(0, 0).addBox(0.713F, -0.5219F, 0.0F, 0.5F, 0.2F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(0, 0).addBox(-1.287F, -0.5219F, 0.0F, 0.5F, 0.2F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(0, 0).addBox(0.713F, -0.3219F, 0.0F, 0.3F, 0.2F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(0, 0).addBox(-1.087F, -0.3219F, 0.0F, 0.3F, 0.2F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-1.9204F, -4.3959F, 3.0581F, 1.5708F, 0.0F, 0.0F));

        PartDefinition cube_r79 = star4.addOrReplaceChild("cube_r79", CubeListBuilder.create().texOffs(0, 0).addBox(-0.1442F, -0.3185F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(1.2834F, -0.606F, 1.0F, 0.0F, 0.0F, 1.5708F));

        PartDefinition cube_r80 = star4.addOrReplaceChild("cube_r80", CubeListBuilder.create().texOffs(0, 0).addBox(0.0256F, -0.2771F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(1.2834F, -0.606F, 1.0F, 0.0F, 0.0F, 0.9599F));

        PartDefinition cube_r81 = star4.addOrReplaceChild("cube_r81", CubeListBuilder.create().texOffs(0, 0).addBox(-0.2896F, -0.2896F, -1.0F, 0.1565F, 0.1564F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-1.4242F, -0.5549F, 1.0F, 0.0F, 0.0F, -0.48F));

        PartDefinition cube_r82 = star4.addOrReplaceChild("cube_r82", CubeListBuilder.create().texOffs(0, 0).addBox(-0.1954F, -0.2518F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-1.4242F, -0.5549F, 1.0F, 0.0F, 0.0F, -0.9599F));

        PartDefinition cube_r83 = star4.addOrReplaceChild("cube_r83", CubeListBuilder.create().texOffs(0, 0).addBox(-0.0546F, -0.2518F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-1.4242F, -0.5549F, 1.0F, 0.0F, 0.0F, -1.5708F));

        PartDefinition cube_r84 = star4.addOrReplaceChild("cube_r84", CubeListBuilder.create().texOffs(0, 0).addBox(-0.2896F, -0.2896F, -1.0F, 0.1565F, 0.1564F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.8713F, 1.0739F, 1.0F, 0.0F, 0.0F, -1.7453F));

        PartDefinition cube_r85 = star4.addOrReplaceChild("cube_r85", CubeListBuilder.create().texOffs(0, 0).addBox(-0.0546F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.8713F, 1.0739F, 1.0F, 0.0F, 0.0F, -2.8362F));

        PartDefinition cube_r86 = star4.addOrReplaceChild("cube_r86", CubeListBuilder.create().texOffs(0, 0).addBox(-0.1954F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.8713F, 1.0739F, 1.0F, 0.0F, 0.0F, -2.2253F));

        PartDefinition cube_r87 = star4.addOrReplaceChild("cube_r87", CubeListBuilder.create().texOffs(0, 0).addBox(-0.0546F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(0.7972F, 1.0739F, 1.0F, 0.0F, 0.0F, 2.2253F));

        PartDefinition cube_r88 = star4.addOrReplaceChild("cube_r88", CubeListBuilder.create().texOffs(0, 0).addBox(-0.2896F, -0.2896F, -1.0F, 0.1564F, 0.1564F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(0.7972F, 1.0739F, 1.0F, 0.0F, 0.0F, -2.9671F));

        PartDefinition cube_r89 = star4.addOrReplaceChild("cube_r89", CubeListBuilder.create().texOffs(0, 0).addBox(-0.1954F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(0.7972F, 1.0739F, 1.0F, 0.0F, 0.0F, 2.8362F));

        PartDefinition cube_r90 = star4.addOrReplaceChild("cube_r90", CubeListBuilder.create().texOffs(0, 0).addBox(-0.2896F, -0.2896F, -1.0F, 0.1564F, 0.1565F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.037F, -1.5719F, 1.0F, 0.0F, 0.0F, 0.7854F));

        PartDefinition cube_r91 = star4.addOrReplaceChild("cube_r91", CubeListBuilder.create().texOffs(0, 0).addBox(-0.1954F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.037F, -1.5719F, 1.0F, 0.0F, 0.0F, 0.3054F));

        PartDefinition cube_r92 = star4.addOrReplaceChild("cube_r92", CubeListBuilder.create().texOffs(0, 0).addBox(-0.0546F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.037F, -1.5719F, 1.0F, 0.0F, 0.0F, -0.3054F));

        PartDefinition cube_r93 = star4.addOrReplaceChild("cube_r93", CubeListBuilder.create().texOffs(0, 0).addBox(-0.275F, -0.3724F, -1.0F, 0.1564F, 0.1564F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(1.2834F, -0.606F, 1.0F, 0.0F, 0.0F, 2.0508F));

        PartDefinition star5 = hat.addOrReplaceChild("star5", CubeListBuilder.create().texOffs(48, 17).addBox(-0.537F, -0.7469F, 0.0F, 1.0F, 1.4F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(0, 0).addBox(-0.737F, 0.4531F, 0.0F, 0.4F, 0.4F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(0, 0).addBox(-0.937F, 0.7531F, 0.0F, 0.3F, 0.3F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(0, 0).addBox(0.263F, 0.4531F, 0.0F, 0.4F, 0.4F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(0, 0).addBox(0.563F, 0.7531F, 0.0F, 0.3F, 0.3F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(0, 0).addBox(-0.237F, -1.5469F, 0.0F, 0.4F, 0.8F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(48, 17).addBox(-0.787F, -0.5219F, 0.0F, 1.5F, 1.0F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(0, 0).addBox(0.713F, -0.5219F, 0.0F, 0.5F, 0.2F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(0, 0).addBox(-1.287F, -0.5219F, 0.0F, 0.5F, 0.2F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(0, 0).addBox(0.713F, -0.3219F, 0.0F, 0.3F, 0.2F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(0, 0).addBox(-1.087F, -0.3219F, 0.0F, 0.3F, 0.2F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offset(-0.1204F, -2.0959F, 4.9331F));

        PartDefinition cube_r94 = star5.addOrReplaceChild("cube_r94", CubeListBuilder.create().texOffs(0, 0).addBox(-0.1442F, -0.3185F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(1.2834F, -0.606F, 1.0F, 0.0F, 0.0F, 1.5708F));

        PartDefinition cube_r95 = star5.addOrReplaceChild("cube_r95", CubeListBuilder.create().texOffs(0, 0).addBox(0.0256F, -0.2771F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(1.2834F, -0.606F, 1.0F, 0.0F, 0.0F, 0.9599F));

        PartDefinition cube_r96 = star5.addOrReplaceChild("cube_r96", CubeListBuilder.create().texOffs(0, 0).addBox(-0.2896F, -0.2896F, -1.0F, 0.1565F, 0.1564F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-1.4242F, -0.5549F, 1.0F, 0.0F, 0.0F, -0.48F));

        PartDefinition cube_r97 = star5.addOrReplaceChild("cube_r97", CubeListBuilder.create().texOffs(0, 0).addBox(-0.1954F, -0.2518F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-1.4242F, -0.5549F, 1.0F, 0.0F, 0.0F, -0.9599F));

        PartDefinition cube_r98 = star5.addOrReplaceChild("cube_r98", CubeListBuilder.create().texOffs(0, 0).addBox(-0.0546F, -0.2518F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-1.4242F, -0.5549F, 1.0F, 0.0F, 0.0F, -1.5708F));

        PartDefinition cube_r99 = star5.addOrReplaceChild("cube_r99", CubeListBuilder.create().texOffs(0, 0).addBox(-0.2896F, -0.2896F, -1.0F, 0.1565F, 0.1564F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.8713F, 1.0739F, 1.0F, 0.0F, 0.0F, -1.7453F));

        PartDefinition cube_r100 = star5.addOrReplaceChild("cube_r100", CubeListBuilder.create().texOffs(0, 0).addBox(-0.0546F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.8713F, 1.0739F, 1.0F, 0.0F, 0.0F, -2.8362F));

        PartDefinition cube_r101 = star5.addOrReplaceChild("cube_r101", CubeListBuilder.create().texOffs(0, 0).addBox(-0.1954F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.8713F, 1.0739F, 1.0F, 0.0F, 0.0F, -2.2253F));

        PartDefinition cube_r102 = star5.addOrReplaceChild("cube_r102", CubeListBuilder.create().texOffs(0, 0).addBox(-0.0546F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(0.7972F, 1.0739F, 1.0F, 0.0F, 0.0F, 2.2253F));

        PartDefinition cube_r103 = star5.addOrReplaceChild("cube_r103", CubeListBuilder.create().texOffs(0, 0).addBox(-0.2896F, -0.2896F, -1.0F, 0.1564F, 0.1564F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(0.7972F, 1.0739F, 1.0F, 0.0F, 0.0F, -2.9671F));

        PartDefinition cube_r104 = star5.addOrReplaceChild("cube_r104", CubeListBuilder.create().texOffs(0, 0).addBox(-0.1954F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(0.7972F, 1.0739F, 1.0F, 0.0F, 0.0F, 2.8362F));

        PartDefinition cube_r105 = star5.addOrReplaceChild("cube_r105", CubeListBuilder.create().texOffs(0, 0).addBox(-0.2896F, -0.2896F, -1.0F, 0.1564F, 0.1565F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.037F, -1.5719F, 1.0F, 0.0F, 0.0F, 0.7854F));

        PartDefinition cube_r106 = star5.addOrReplaceChild("cube_r106", CubeListBuilder.create().texOffs(0, 0).addBox(-0.1954F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.037F, -1.5719F, 1.0F, 0.0F, 0.0F, 0.3054F));

        PartDefinition cube_r107 = star5.addOrReplaceChild("cube_r107", CubeListBuilder.create().texOffs(0, 0).addBox(-0.0546F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.037F, -1.5719F, 1.0F, 0.0F, 0.0F, -0.3054F));

        PartDefinition cube_r108 = star5.addOrReplaceChild("cube_r108", CubeListBuilder.create().texOffs(0, 0).addBox(-0.275F, -0.3724F, -1.0F, 0.1565F, 0.1564F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(1.2834F, -0.606F, 1.0F, 0.0F, 0.0F, 2.0508F));

        PartDefinition star6 = hat.addOrReplaceChild("star6", CubeListBuilder.create().texOffs(48, 17).addBox(-0.537F, -0.7469F, 0.0F, 1.0F, 1.4F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(0, 0).addBox(-0.737F, 0.4531F, 0.0F, 0.4F, 0.4F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(0, 0).addBox(-0.937F, 0.7531F, 0.0F, 0.3F, 0.3F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(0, 0).addBox(0.263F, 0.4531F, 0.0F, 0.4F, 0.4F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(0, 0).addBox(0.563F, 0.7531F, 0.0F, 0.3F, 0.3F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(0, 0).addBox(-0.237F, -1.5469F, 0.0F, 0.4F, 0.8F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(48, 17).addBox(-0.787F, -0.5219F, 0.0F, 1.5F, 1.0F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(0, 0).addBox(0.713F, -0.5219F, 0.0F, 0.5F, 0.2F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(0, 0).addBox(-1.287F, -0.5219F, 0.0F, 0.5F, 0.2F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(0, 0).addBox(0.713F, -0.3219F, 0.0F, 0.3F, 0.2F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(0, 0).addBox(-1.087F, -0.3219F, 0.0F, 0.3F, 0.2F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offset(-4.1204F, -2.0959F, 4.9581F));

        PartDefinition cube_r109 = star6.addOrReplaceChild("cube_r109", CubeListBuilder.create().texOffs(0, 0).addBox(-0.1442F, -0.3185F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(1.2834F, -0.606F, 1.0F, 0.0F, 0.0F, 1.5708F));

        PartDefinition cube_r110 = star6.addOrReplaceChild("cube_r110", CubeListBuilder.create().texOffs(0, 0).addBox(0.0256F, -0.2771F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(1.2834F, -0.606F, 1.0F, 0.0F, 0.0F, 0.9599F));

        PartDefinition cube_r111 = star6.addOrReplaceChild("cube_r111", CubeListBuilder.create().texOffs(0, 0).addBox(-0.2896F, -0.2896F, -1.0F, 0.1565F, 0.1564F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-1.4242F, -0.5549F, 1.0F, 0.0F, 0.0F, -0.48F));

        PartDefinition cube_r112 = star6.addOrReplaceChild("cube_r112", CubeListBuilder.create().texOffs(0, 0).addBox(-0.1954F, -0.2518F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-1.4242F, -0.5549F, 1.0F, 0.0F, 0.0F, -0.9599F));

        PartDefinition cube_r113 = star6.addOrReplaceChild("cube_r113", CubeListBuilder.create().texOffs(0, 0).addBox(-0.0546F, -0.2518F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-1.4242F, -0.5549F, 1.0F, 0.0F, 0.0F, -1.5708F));

        PartDefinition cube_r114 = star6.addOrReplaceChild("cube_r114", CubeListBuilder.create().texOffs(0, 0).addBox(-0.2896F, -0.2896F, -1.0F, 0.1565F, 0.1564F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.8713F, 1.0739F, 1.0F, 0.0F, 0.0F, -1.7453F));

        PartDefinition cube_r115 = star6.addOrReplaceChild("cube_r115", CubeListBuilder.create().texOffs(0, 0).addBox(-0.0546F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.8713F, 1.0739F, 1.0F, 0.0F, 0.0F, -2.8362F));

        PartDefinition cube_r116 = star6.addOrReplaceChild("cube_r116", CubeListBuilder.create().texOffs(0, 0).addBox(-0.1954F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.8713F, 1.0739F, 1.0F, 0.0F, 0.0F, -2.2253F));

        PartDefinition cube_r117 = star6.addOrReplaceChild("cube_r117", CubeListBuilder.create().texOffs(0, 0).addBox(-0.0546F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(0.7972F, 1.0739F, 1.0F, 0.0F, 0.0F, 2.2253F));

        PartDefinition cube_r118 = star6.addOrReplaceChild("cube_r118", CubeListBuilder.create().texOffs(0, 0).addBox(-0.2896F, -0.2896F, -1.0F, 0.1565F, 0.1564F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(0.7972F, 1.0739F, 1.0F, 0.0F, 0.0F, -2.9671F));

        PartDefinition cube_r119 = star6.addOrReplaceChild("cube_r119", CubeListBuilder.create().texOffs(0, 0).addBox(-0.1954F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(0.7972F, 1.0739F, 1.0F, 0.0F, 0.0F, 2.8362F));

        PartDefinition cube_r120 = star6.addOrReplaceChild("cube_r120", CubeListBuilder.create().texOffs(0, 0).addBox(-0.2896F, -0.2896F, -1.0F, 0.1565F, 0.1565F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.037F, -1.5719F, 1.0F, 0.0F, 0.0F, 0.7854F));

        PartDefinition cube_r121 = star6.addOrReplaceChild("cube_r121", CubeListBuilder.create().texOffs(0, 0).addBox(-0.1954F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.037F, -1.5719F, 1.0F, 0.0F, 0.0F, 0.3054F));

        PartDefinition cube_r122 = star6.addOrReplaceChild("cube_r122", CubeListBuilder.create().texOffs(0, 0).addBox(-0.0546F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.037F, -1.5719F, 1.0F, 0.0F, 0.0F, -0.3054F));

        PartDefinition cube_r123 = star6.addOrReplaceChild("cube_r123", CubeListBuilder.create().texOffs(0, 0).addBox(-0.275F, -0.3724F, -1.0F, 0.1564F, 0.1564F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(1.2834F, -0.606F, 1.0F, 0.0F, 0.0F, 2.0508F));

        PartDefinition jin = all.addOrReplaceChild("jin", CubeListBuilder.create(), PartPose.offset(-0.2455F, -0.8291F, -0.0501F));

        PartDefinition bone = jin.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(36, 82).addBox(-2.5F, -1.5F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0F))
                .texOffs(36, 75).addBox(-3.0F, -1.45F, -2.5F, 5.0F, 2.0F, 5.0F, new CubeDeformation(0.0F).extend(-4.8F, -2.15F, -4.8F)), PartPose.offset(-0.2545F, -8.1709F, 0.0501F));

        PartDefinition jin1 = jin.addOrReplaceChild("jin1", CubeListBuilder.create().texOffs(0, 91).addBox(-1.7545F, -8.1709F, -0.9499F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r124 = jin1.addOrReplaceChild("cube_r124", CubeListBuilder.create().texOffs(48, 88).addBox(-1.4371F, 2.3655F, -0.9499F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.001F)), PartPose.offsetAndRotation(-0.75F, -7.75F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition bone2 = jin1.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(24, 91).addBox(-0.9331F, -0.3885F, -0.9901F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.001F)), PartPose.offset(-0.8214F, -6.7824F, 0.0402F));

        PartDefinition bone3 = jin1.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(24, 91).addBox(-0.9331F, -0.3885F, -0.9901F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.001F)), PartPose.offset(-0.8214F, -6.7824F, 0.0402F));

        PartDefinition bone4 = jin1.addOrReplaceChild("bone4", CubeListBuilder.create().texOffs(24, 91).addBox(-0.9331F, -0.3885F, -0.9901F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.001F)), PartPose.offset(-0.8214F, -6.7824F, 0.0402F));

        PartDefinition bone5 = jin1.addOrReplaceChild("bone5", CubeListBuilder.create().texOffs(24, 91).addBox(-0.9331F, -0.3885F, -0.9901F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.001F)), PartPose.offset(-0.8214F, -6.7824F, 0.0402F));

        PartDefinition leave5 = all.addOrReplaceChild("leave5", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.2943F, -0.0783F, 0.4009F, 0.0F, 0.7854F, 0.0F));

        PartDefinition leave1 = leave5.addOrReplaceChild("leave1", CubeListBuilder.create(), PartPose.offset(0.3F, -0.5F, 0.25F));

        PartDefinition cube_r125 = leave1.addOrReplaceChild("cube_r125", CubeListBuilder.create().texOffs(72, 52).addBox(-2.4082F, 7.864F, -3.9499F, 5.0F, 0.0F, 7.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-1.0F, -8.0F, 0.0F, 0.0F, 0.0F, -0.48F));

        PartDefinition cube_r126 = leave1.addOrReplaceChild("cube_r126", CubeListBuilder.create().texOffs(72, 12).addBox(7.7096F, 2.2198F, -4.9499F, 5.0F, 0.0F, 9.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.113F, -8.4618F, 0.0F, 0.0F, 0.0F, 0.6109F));

        PartDefinition leave2 = leave5.addOrReplaceChild("leave2", CubeListBuilder.create(), PartPose.offset(-0.8F, 0.5F, -0.25F));

        PartDefinition cube_r127 = leave2.addOrReplaceChild("cube_r127", CubeListBuilder.create().texOffs(74, 37).addBox(-2.4309F, 7.5642F, -2.5069F, 7.0F, 0.0F, 5.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(0.0F, -9.0F, 0.0F, -0.4363F, 0.0F, 0.0F));

        PartDefinition cube_r128 = leave2.addOrReplaceChild("cube_r128", CubeListBuilder.create().texOffs(42, 12).addBox(-3.4309F, 2.7938F, -12.1885F, 9.0F, 0.0F, 5.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(0.0F, -9.4226F, -0.9063F, 0.5672F, 0.0F, 0.0F));

        PartDefinition leave3 = leave5.addOrReplaceChild("leave3", CubeListBuilder.create(), PartPose.offset(0.3F, -0.5F, 0.25F));

        PartDefinition cube_r129 = leave3.addOrReplaceChild("cube_r129", CubeListBuilder.create().texOffs(74, 30).addBox(-0.5545F, 6.8196F, -3.9499F, 5.0F, 0.0F, 7.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-1.0F, -8.0F, 0.0F, 0.0F, 0.0F, 0.5236F));

        PartDefinition cube_r130 = leave3.addOrReplaceChild("cube_r130", CubeListBuilder.create().texOffs(72, 21).addBox(-10.8425F, 3.5446F, -4.9499F, 5.0F, 0.0F, 9.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-1.866F, -8.5F, 0.0F, 0.0F, 0.0F, -0.5672F));

        PartDefinition leave4 = leave5.addOrReplaceChild("leave4", CubeListBuilder.create(), PartPose.offset(0.2F, 0.5F, -0.25F));

        PartDefinition cube_r131 = leave4.addOrReplaceChild("cube_r131", CubeListBuilder.create().texOffs(72, 47).addBox(-4.4309F, 2.0957F, 7.484F, 9.0F, 0.0F, 5.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(0.0F, -9.4226F, 0.9063F, -0.6545F, 0.0F, 0.0F));

        PartDefinition cube_r132 = leave4.addOrReplaceChild("cube_r132", CubeListBuilder.create().texOffs(74, 42).addBox(-3.4309F, 7.6066F, -2.4023F, 7.0F, 0.0F, 5.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(0.0F, -9.0F, 0.0F, 0.4363F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setupAnim(EntitySuperElectricGatlingPea entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);

        this.animate(entity.idleAnimation, SGPAnimation.stand2, ageInTicks, 1.0F);
        this.animate(entity.shootAnimation, SGPAnimation.shoot, ageInTicks, 1.0F);
        this.animate(entity.superAnimation, SGPAnimation.power2, ageInTicks, 1.0F);

        this.head.yRot = netHeadYaw * ((float) Math.PI / 180F);
        this.head.xRot = headPitch * ((float) Math.PI / 180F);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        all.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Override
    public ModelPart root() {
        return root;
    }
}