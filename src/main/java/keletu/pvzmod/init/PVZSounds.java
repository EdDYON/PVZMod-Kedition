package keletu.pvzmod.init;

import keletu.pvzmod.PVZMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class PVZSounds {

    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(Registries.SOUND_EVENT, PVZMod.MODID);

    public static final RegistryObject<SoundEvent> PUFF_SHROOM_SHOOT = SOUNDS.register("puff_shroom_shoot", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(PVZMod.MODID, "puff_shroom_shoot")));

}