package keletu.pvzmod;

import keletu.pvzmod.init.PVZEntities;
import keletu.pvzmod.init.PVZItems;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(PVZMod.MODID)
public class PVZMod {
    public static final String MODID = "pvz_kedit";

    public PVZMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        PVZItems.ITEMS.register(modEventBus);
        PVZEntities.ENTITIES.register(modEventBus);
        modEventBus.addListener(PVZEntities::registerEntityAttributes);
    }
}
