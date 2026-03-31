package keletu.pvzmod;

import keletu.pvzmod.init.PVZEntities;
import keletu.pvzmod.potion.SlowBlueLayer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = PVZMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void onAddLayers(EntityRenderersEvent.AddLayers event) {
        for (EntityType<?> type : ForgeRegistries.ENTITY_TYPES.getValues()) {
            addLayerToEntity(event, type);
        }

        addLayerToPlayers(event);
    }

    private static void addLayerToPlayers(EntityRenderersEvent.AddLayers event) {
        for (String skin : event.getSkins()) {
            LivingEntityRenderer<?, ?> playerRenderer = event.getSkin(skin);
            if (playerRenderer != null) {
                addLayerSafe(playerRenderer);
            }
        }
    }

    @SuppressWarnings("unchecked")
    private static <T extends LivingEntity> void addLayerToEntity(EntityRenderersEvent.AddLayers event, EntityType<?> type) {
        try {
            EntityRenderer<?> renderer = event.getRenderer((EntityType<T>) type);

            if (renderer instanceof LivingEntityRenderer<?, ?> livingRenderer) {
                addLayerSafe(livingRenderer);
            }
        } catch (Exception ignore) {
        }
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private static void addLayerSafe(LivingEntityRenderer renderer) {
        renderer.addLayer(new SlowBlueLayer(renderer));
    }

    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        PVZEntities.registerRenderers(event);
    }
}
