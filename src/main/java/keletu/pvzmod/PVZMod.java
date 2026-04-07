package keletu.pvzmod;

import keletu.pvzmod.init.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(PVZMod.MODID)
public class PVZMod {
    public static final String MODID = "pvz_kedit";

    public PVZMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        PVZBlocks.BLOCKS.register(modEventBus);
        PVZBlocks.BLOCK_ENTITIES.register(modEventBus);
        PVZItems.ITEMS.register(modEventBus);
        PVZEntities.ENTITIES.register(modEventBus);
        PVZEffects.EFFECTS.register(modEventBus);
        PVZSounds.SOUNDS.register(modEventBus);
        modEventBus.addListener(PVZEntities::registerEntityAttributes);

        PVZTabs.TABS.register(modEventBus);
    }
}
