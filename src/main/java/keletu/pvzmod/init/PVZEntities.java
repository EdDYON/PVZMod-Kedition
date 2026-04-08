package keletu.pvzmod.init;

import keletu.pvzmod.PVZMod;
import keletu.pvzmod.entities.*;
import keletu.pvzmod.entities.projectile.*;
import keletu.pvzmod.models.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class PVZEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, PVZMod.MODID);
    public static final RegistryObject<EntityType<EntityPeaShooter>> PEA_SHOOTER = PVZEntities.ENTITIES.register("pea_shooter", () -> EntityType.Builder.of(EntityPeaShooter::new, MobCategory.MISC).sized(1.0F, 1.0F).clientTrackingRange(8).build(PVZMod.MODID + ".pea_shooter"));
    public static final RegistryObject<EntityType<EntitySnowPea>> SNOW_PEA = PVZEntities.ENTITIES.register("snow_pea", () -> EntityType.Builder.of(EntitySnowPea::new, MobCategory.MISC).sized(1.0F, 1.0F).clientTrackingRange(8).build(PVZMod.MODID + ".snow_pea"));
    public static final RegistryObject<EntityType<EntityRepeater>> REPEATER = PVZEntities.ENTITIES.register("repeater", () -> EntityType.Builder.of(EntityRepeater::new, MobCategory.MISC).sized(1.0F, 1.0F).clientTrackingRange(8).build(PVZMod.MODID + ".repeater"));
    public static final RegistryObject<EntityType<EntityGatlingPea>> GATLING_PEA = PVZEntities.ENTITIES.register("gatling_pea", () -> EntityType.Builder.of(EntityGatlingPea::new, MobCategory.MISC).sized(1.0F, 1.0F).clientTrackingRange(8).build(PVZMod.MODID + ".gatling_pea"));
    public static final RegistryObject<EntityType<EntityPrimalPeashooter>> PRIMAL_PEASHOOTER = PVZEntities.ENTITIES.register("primal_peashooter", () -> EntityType.Builder.of(EntityPrimalPeashooter::new, MobCategory.MISC).sized(1.0F, 1.0F).clientTrackingRange(8).build(PVZMod.MODID + ".primal_peashooter"));
    public static final RegistryObject<EntityType<EntityWalnut>> WALNUT = PVZEntities.ENTITIES.register("walnut", () -> EntityType.Builder.of((EntityType<EntityWalnut> event, Level level) -> new EntityWalnut(event, level, 10F), MobCategory.MISC).sized(1.0F, 1.2F).clientTrackingRange(8).build(PVZMod.MODID + ".walnut"));
    public static final RegistryObject<EntityType<EntityTallnut>> TALL_NUT = PVZEntities.ENTITIES.register("tallnut", () -> EntityType.Builder.of(EntityTallnut::new, MobCategory.MISC).sized(1.0F, 1.8F).clientTrackingRange(8).build(PVZMod.MODID + ".tallnut"));
    public static final RegistryObject<EntityType<EntitySuperGatlingPea>> SUPER_GATLING_PEA = PVZEntities.ENTITIES.register("super_gatling_pea", () -> EntityType.Builder.of(EntitySuperGatlingPea::new, MobCategory.MISC).sized(1.0F, 1.0F).clientTrackingRange(8).build(PVZMod.MODID + ".super_gatling_pea"));
    public static final RegistryObject<EntityType<EntitySuperSnowGatlingPea>> SUPER_SNOW_GATLING_PEA = PVZEntities.ENTITIES.register("super_snow_gatling_pea", () -> EntityType.Builder.of(EntitySuperSnowGatlingPea::new, MobCategory.MISC).sized(1.0F, 1.0F).clientTrackingRange(8).build(PVZMod.MODID + ".super_snow_gatling_pea"));
    public static final RegistryObject<EntityType<EntitySuperPrimalGatlingPea>> SUPER_PRIMAL_GATLING_PEA = PVZEntities.ENTITIES.register("super_primal_gatling_pea", () -> EntityType.Builder.of(EntitySuperPrimalGatlingPea::new, MobCategory.MISC).sized(1.0F, 1.0F).clientTrackingRange(8).build(PVZMod.MODID + ".super_primal_gatling_pea"));
    public static final RegistryObject<EntityType<EntitySuperElectricGatlingPea>> SUPER_ELECTRIC_GATLING_PEA = PVZEntities.ENTITIES.register("super_electric_gatling_pea", () -> EntityType.Builder.of(EntitySuperElectricGatlingPea::new, MobCategory.MISC).sized(1.0F, 1.0F).clientTrackingRange(8).build(PVZMod.MODID + ".super_electric_gatling_pea"));
    public static final RegistryObject<EntityType<EntityPotatoMine>> POTATO_MINE = PVZEntities.ENTITIES.register("potato_mine", () -> EntityType.Builder.of(EntityPotatoMine::new, MobCategory.MISC).sized(1.0F, 0.5F).clientTrackingRange(8).build(PVZMod.MODID + ".potato_mine"));
    public static final RegistryObject<EntityType<PuffShroomEntity>> PUFF_SHROOM = PVZEntities.ENTITIES.register("puff_shroom", () -> EntityType.Builder.of(PuffShroomEntity::new, MobCategory.MISC).sized(1.0F, 0.75F).clientTrackingRange(8).build(PVZMod.MODID + ".puff_shroom"));
    public static final RegistryObject<EntityType<FumeShroomEntity>> FUME_SHROOM = PVZEntities.ENTITIES.register("fume_shroom", () -> EntityType.Builder.of(FumeShroomEntity::new, MobCategory.MISC).sized(1.0F, 1.0F).clientTrackingRange(8).build(PVZMod.MODID + ".fume_shroom"));
    public static final RegistryObject<EntityType<PeaProjectile>> PEA_PROJECTILE = PVZEntities.ENTITIES.register("pea_projectile",
            () -> EntityType.Builder.<PeaProjectile>of(PeaProjectile::new, MobCategory.MISC)
                    .sized(0.25F, 0.25F)
                    .clientTrackingRange(4)
                    .updateInterval(10)
                    .build("pea_projectile"));
    public static final RegistryObject<EntityType<SnowPeaProjectile>> ICE_PEA_PROJECTILE = PVZEntities.ENTITIES.register("ice_pea_projectile",
            () -> EntityType.Builder.<SnowPeaProjectile>of(SnowPeaProjectile::new, MobCategory.MISC)
                    .sized(0.25F, 0.25F)
                    .clientTrackingRange(4)
                    .updateInterval(10)
                    .build("snow_pea_projectile"));
    public static final RegistryObject<EntityType<PrimalPeaProjectile>> PRIMAL_PEA_PROJECTILE = PVZEntities.ENTITIES.register("primal_pea_projectile",
            () -> EntityType.Builder.<PrimalPeaProjectile>of(PrimalPeaProjectile::new, MobCategory.MISC)
                    .sized(0.25F, 0.25F)
                    .clientTrackingRange(4)
                    .updateInterval(10)
                    .build("primal_pea_projectile"));
    public static final RegistryObject<EntityType<ElectricPeaProjectile>> ELECTRIC_PEA_PROJECTILE = PVZEntities.ENTITIES.register("electric_pea_projectile",
            () -> EntityType.Builder.<ElectricPeaProjectile>of(ElectricPeaProjectile::new, MobCategory.MISC)
                    .sized(0.35F, 0.35F)
                    .clientTrackingRange(4)
                    .updateInterval(10)
                    .build("electric_pea_projectile"));
    public static final RegistryObject<EntityType<SporeProjectile>> SPORE_PROJECTILE = PVZEntities.ENTITIES.register("spore_projectile",
            () -> EntityType.Builder.<SporeProjectile>of(SporeProjectile::new, MobCategory.MISC)
                    .sized(0.25F, 0.25F)
                    .clientTrackingRange(4)
                    .updateInterval(10)
                    .build("spore_projectile"));

    public static void registerEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(PEA_SHOOTER.get(), EntityPeaShooter.createAttributes().build());
        event.put(SNOW_PEA.get(), EntitySnowPea.createAttributes().build());
        event.put(REPEATER.get(), EntityRepeater.createAttributes().build());
        event.put(GATLING_PEA.get(), EntityGatlingPea.createAttributes().build());
        event.put(PRIMAL_PEASHOOTER.get(), EntityPrimalPeashooter.createAttributes().build());

        event.put(WALNUT.get(), EntityWalnut.createAttributes().build());
        event.put(TALL_NUT.get(), EntityTallnut.createAttributes().build());

        event.put(SUPER_GATLING_PEA.get(), EntitySuperGatlingPea.createAttributes().build());
        event.put(SUPER_SNOW_GATLING_PEA.get(), EntitySuperSnowGatlingPea.createAttributes().build());
        event.put(SUPER_PRIMAL_GATLING_PEA.get(), EntitySuperPrimalGatlingPea.createAttributes().build());
        event.put(SUPER_ELECTRIC_GATLING_PEA.get(), EntitySuperElectricGatlingPea.createAttributes().build());

        event.put(POTATO_MINE.get(), EntityPotatoMine.createAttributes().build());

        event.put(PUFF_SHROOM.get(), PuffShroomEntity.createAttributes().build());
        event.put(FUME_SHROOM.get(), FumeShroomEntity.createAttributes().build());
    }

    @OnlyIn(Dist.CLIENT)
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(PEA_SHOOTER.get(), ((EntityRendererProvider.Context context) -> new GeoEntityRenderer<>(context, new PeaShooterModel())));
        event.registerEntityRenderer(PEA_PROJECTILE.get(), ThrownItemRenderer::new);

        event.registerEntityRenderer(SNOW_PEA.get(), RenderSnowPea::new);
        event.registerEntityRenderer(ICE_PEA_PROJECTILE.get(), ThrownItemRenderer::new);

        event.registerEntityRenderer(REPEATER.get(), RenderRepeater::new);
        event.registerEntityRenderer(GATLING_PEA.get(), RenderGatlingPea::new);

        event.registerEntityRenderer(PRIMAL_PEASHOOTER.get(), RenderPrimalPeashooter::new);
        event.registerEntityRenderer(PRIMAL_PEA_PROJECTILE.get(), RenderPrimalPea::new);

        event.registerEntityRenderer(SUPER_GATLING_PEA.get(), ((EntityRendererProvider.Context context) -> new GeoEntityRenderer<>(context, new SuperGatlingPeaModel())));
        event.registerEntityRenderer(SUPER_SNOW_GATLING_PEA.get(), ((EntityRendererProvider.Context context) -> new GeoEntityRenderer<>(context, new SuperSnowGatlingPeaModel())));
        event.registerEntityRenderer(SUPER_PRIMAL_GATLING_PEA.get(), ((EntityRendererProvider.Context context) -> new GeoEntityRenderer<>(context, new SuperPrimalGatlingPeaModel())));
        event.registerEntityRenderer(SUPER_ELECTRIC_GATLING_PEA.get(), RenderSuperElectricGatlingPea::new);

        event.registerEntityRenderer(ELECTRIC_PEA_PROJECTILE.get(), ElectricPeaProjectileRenderer::new);

        event.registerEntityRenderer(WALNUT.get(), WalnutRender::new);
        event.registerEntityRenderer(TALL_NUT.get(), TallnutRender::new);

        event.registerEntityRenderer(POTATO_MINE.get(), ((EntityRendererProvider.Context context) -> new GeoEntityRenderer<>(context, new PotatoMineModel())));

        event.registerEntityRenderer(PUFF_SHROOM.get(), ((EntityRendererProvider.Context context) -> new GeoEntityRenderer<>(context, new PuffShroomModel())));
        event.registerEntityRenderer(SPORE_PROJECTILE.get(), ThrownItemRenderer::new);

        event.registerEntityRenderer(FUME_SHROOM.get(), ((EntityRendererProvider.Context context) -> new GeoEntityRenderer<>(context, new FumeShroomModel())));
    }
}
