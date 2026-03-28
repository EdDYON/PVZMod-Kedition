package keletu.pvzmod.init;

import keletu.pvzmod.PVZMod;
import keletu.pvzmod.entities.EntityPeaShooter;
import keletu.pvzmod.models.RenderPeaShooter;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class PVZEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, PVZMod.MODID);
    public static final RegistryObject<EntityType<EntityPeaShooter>> PEA_SHOOTER = PVZEntities.ENTITIES.register("pea_shooter", () -> EntityType.Builder.of(EntityPeaShooter::new, MobCategory.CREATURE).sized(1.0F, 0.8F).clientTrackingRange(8).build(PVZMod.MODID + ".pea_shooter"));

    public static void registerEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(PEA_SHOOTER.get(), EntityPeaShooter.createAttributes().build());
    }

    @OnlyIn(Dist.CLIENT)
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(PEA_SHOOTER.get(), RenderPeaShooter::new);
    }
}
