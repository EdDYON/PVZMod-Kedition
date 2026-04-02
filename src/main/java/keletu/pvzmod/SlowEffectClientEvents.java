package keletu.pvzmod;

import keletu.pvzmod.potion.SnowEffect;
import keletu.pvzmod.potion.StunEffect;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
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

        if (level == null) return;

        if (level.getGameTime() % 2 != 0) return;

        for (Entity entity : level.entitiesForRendering()) {
            if (!(entity instanceof LivingEntity living)) continue;


            AttributeInstance speed = living.getAttribute(Attributes.MOVEMENT_SPEED);
            if (speed == null) continue;

            AttributeModifier snow = speed.getModifier(SnowEffect.MOVEMENT_SPEED_MODIFIER_UUID);
            if (snow != null) {
                for (int i = 0; i < 3; i++) {
                    double x = living.getX() + (level.random.nextDouble() - 0.5D) * living.getBbWidth();
                    double y = living.getY() + level.random.nextDouble() * living.getBbHeight() + 0.2D;
                    double z = living.getZ() + (level.random.nextDouble() - 0.5D) * living.getBbWidth();

                    double vx = (level.random.nextDouble() - 0.5D) * 0.02D;
                    double vy = 0.01D;
                    double vz = (level.random.nextDouble() - 0.5D) * 0.02D;

                    level.addParticle(ParticleTypes.SNOWFLAKE, x, y, z, vx, vy, vz);
                }
            }

            AttributeModifier stun = speed.getModifier(StunEffect.MOVEMENT_SPEED_MODIFIER);
            if (stun != null) {

                double radius = 0.6D;
                double y = entity.getY() + entity.getBbHeight() + 0.3D;
                int points = 12;

                double rotation = entity.tickCount * 0.25D;

                for (int i = 0; i < points; i++) {
                    double angle = 2.0D * Math.PI * i / points + rotation;
                    double x = entity.getX() + Math.cos(angle) * radius;
                    double z = entity.getZ() + Math.sin(angle) * radius;

                    level.addParticle(
                            ParticleTypes.CRIT,
                            x, y, z,
                            0.0D, 0.0D, 0.0D
                    );
                }
            }
        }
    }
}