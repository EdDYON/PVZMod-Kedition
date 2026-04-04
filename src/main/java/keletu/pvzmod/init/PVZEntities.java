package keletu.pvzmod.init;

import keletu.pvzmod.PVZMod;
import keletu.pvzmod.entities.*;
import keletu.pvzmod.entities.projectile.PeaProjectile;
import keletu.pvzmod.entities.projectile.PrimalPeaProjectile;
import keletu.pvzmod.entities.projectile.SnowPeaProjectile;
import keletu.pvzmod.models.*;
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

public class PVZEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, PVZMod.MODID);
    public static final RegistryObject<EntityType<EntityPeaShooter>> PEA_SHOOTER = PVZEntities.ENTITIES.register("pea_shooter", () -> EntityType.Builder.of(EntityPeaShooter::new, MobCategory.MISC).sized(1.0F, 1.0F).clientTrackingRange(8).build(PVZMod.MODID + ".pea_shooter"));
    public static final RegistryObject<EntityType<EntitySnowPea>> SNOW_PEA = PVZEntities.ENTITIES.register("snow_pea", () -> EntityType.Builder.of(EntitySnowPea::new, MobCategory.MISC).sized(1.0F, 1.0F).clientTrackingRange(8).build(PVZMod.MODID + ".snow_pea"));
    public static final RegistryObject<EntityType<EntityRepeater>> REPEATER = PVZEntities.ENTITIES.register("repeater", () -> EntityType.Builder.of(EntityRepeater::new, MobCategory.MISC).sized(1.0F, 1.0F).clientTrackingRange(8).build(PVZMod.MODID + ".repeater"));
    public static final RegistryObject<EntityType<EntityGatlingPea>> GATLING_PEA = PVZEntities.ENTITIES.register("gatling_pea", () -> EntityType.Builder.of(EntityGatlingPea::new, MobCategory.MISC).sized(1.0F, 1.0F).clientTrackingRange(8).build(PVZMod.MODID + ".gatling_pea"));
    public static final RegistryObject<EntityType<EntityPrimalPeashooter>> PRIMAL_PEASHOOTER = PVZEntities.ENTITIES.register("primal_peashooter", () -> EntityType.Builder.of(EntityPrimalPeashooter::new, MobCategory.MISC).sized(1.0F, 1.0F).clientTrackingRange(8).build(PVZMod.MODID + ".primal_peashooter"));
    public static final RegistryObject<EntityType<EntityWalnut>> WALNUT = PVZEntities.ENTITIES.register("walnut", () -> EntityType.Builder.of((EntityType<EntityWalnut> event, Level level) -> new EntityWalnut(event, level, 10F), MobCategory.MISC).sized(1.0F, 1.2F).clientTrackingRange(8).build(PVZMod.MODID + ".walnut"));
    public static final RegistryObject<EntityType<EntityTallnut>> TALL_NUT = PVZEntities.ENTITIES.register("tallnut", () -> EntityType.Builder.of(EntityTallnut::new, MobCategory.MISC).sized(1.0F, 1.8F).clientTrackingRange(8).build(PVZMod.MODID + ".tallnut"));
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

    public static void registerEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(PEA_SHOOTER.get(), EntityPeaShooter.createAttributes().build());
        event.put(SNOW_PEA.get(), EntitySnowPea.createAttributes().build());
        event.put(REPEATER.get(), EntityRepeater.createAttributes().build());
        event.put(GATLING_PEA.get(), EntityRepeater.createAttributes().build());
        event.put(PRIMAL_PEASHOOTER.get(), EntityRepeater.createAttributes().build());

        event.put(WALNUT.get(), EntityWalnut.createAttributes().build());
        event.put(TALL_NUT.get(), EntityTallnut.createAttributes().build());
    }

    @OnlyIn(Dist.CLIENT)
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(PEA_SHOOTER.get(), RenderPeaShooter::new);
        event.registerEntityRenderer(PEA_PROJECTILE.get(), ThrownItemRenderer::new);

        event.registerEntityRenderer(SNOW_PEA.get(), RenderSnowPea::new);
        event.registerEntityRenderer(ICE_PEA_PROJECTILE.get(), ThrownItemRenderer::new);

        event.registerEntityRenderer(REPEATER.get(), RenderRepeater::new);
        event.registerEntityRenderer(GATLING_PEA.get(), RenderGatlingPea::new);

        event.registerEntityRenderer(PRIMAL_PEASHOOTER.get(), RenderPrimalPeashooter::new);
        event.registerEntityRenderer(PRIMAL_PEA_PROJECTILE.get(), RenderPrimalPea::new);

        event.registerEntityRenderer(WALNUT.get(), WalnutRender::new);
        event.registerEntityRenderer(TALL_NUT.get(), TallnutRender::new);
    }
}
