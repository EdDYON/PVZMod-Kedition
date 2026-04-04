package keletu.pvzmod;

import keletu.pvzmod.entities.EntityTallnut;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = PVZMod.MODID)
public class ServerEvents {

    @SubscribeEvent
    public static void livingHurtEvent(LivingDamageEvent event) {
        if (event.getEntity() instanceof EntityTallnut tallnut && event.getAmount() > tallnut.getMaxHealth() * 1 / 2) {
            event.setAmount(tallnut.getMaxHealth() * 1 / 2);
        }
    }
}
