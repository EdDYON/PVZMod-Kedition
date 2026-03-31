package keletu.pvzmod;

import keletu.pvzmod.init.PVZEffects;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class SlowEffectClientEvents {

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return;

        Minecraft mc = Minecraft.getInstance();
        ClientLevel level = mc.level;
        LivingEntity player = mc.player;

        if (level == null || player == null) return;

        if (level.getGameTime() % 2 != 0) return;

        double range = 32.0D;
        AABB area = player.getBoundingBox().inflate(range);

        for (LivingEntity entity : level.getEntitiesOfClass(LivingEntity.class, area)) {
            if (!entity.hasEffect(PVZEffects.SNOW.get())) continue;

            for (int i = 0; i < 3; i++) {
                double x = entity.getX() + (level.random.nextDouble() - 0.5D) * entity.getBbWidth();
                double y = entity.getY() + level.random.nextDouble() * entity.getBbHeight() + 0.2D;
                double z = entity.getZ() + (level.random.nextDouble() - 0.5D) * entity.getBbWidth();

                double vx = (level.random.nextDouble() - 0.5D) * 0.02D;
                double vy = 0.01D;
                double vz = (level.random.nextDouble() - 0.5D) * 0.02D;

                level.addParticle(ParticleTypes.SNOWFLAKE, x, y, z, vx, vy, vz);
            }
        }
    }
}