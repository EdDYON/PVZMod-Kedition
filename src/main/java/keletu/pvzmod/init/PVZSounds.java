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
    public static final RegistryObject<SoundEvent> CARD_SELECT = SOUNDS.register("card_select", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(PVZMod.MODID, "card_select")));
    public static final RegistryObject<SoundEvent> SHOVEL_SELECT = SOUNDS.register("shovel_select", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(PVZMod.MODID, "shovel_select")));
    public static final RegistryObject<SoundEvent> PLANT = SOUNDS.register("plant_plant", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(PVZMod.MODID, "plant_plant")));
    public static final RegistryObject<SoundEvent> REMOVE = SOUNDS.register("remove_plant", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(PVZMod.MODID, "remove_plant")));
    public static final RegistryObject<SoundEvent> FUME_SHROOM_SHOOT = SOUNDS.register("fume_shroom_shoot", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(PVZMod.MODID, "fume_shroom_shoot")));
    public static final RegistryObject<SoundEvent> SUPERGATLINGPEA_POWER = SOUNDS.register("supergatlingpea_power", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(PVZMod.MODID, "fume_shroom_shoot")));
    public static final RegistryObject<SoundEvent> SUPERGATLINGPEA_SHOOT = SOUNDS.register("supergatlingpea_shoot", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(PVZMod.MODID, "supergatlingpea_power")));
    public static final RegistryObject<SoundEvent> PRIMALPEASHOOTER_SHOOT = SOUNDS.register("primalpeashooter_shoot", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(PVZMod.MODID, "primalpeashooter_shoot")));
    public static final RegistryObject<SoundEvent> PRIMALPEA_BOOM = SOUNDS.register("primalpea_boom", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(PVZMod.MODID, "primalpea_boom")));
    public static final RegistryObject<SoundEvent> PEASHOOTER_SHOOT = SOUNDS.register("peashooter_shoot", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(PVZMod.MODID, "peashooter_shoot")));
    public static final RegistryObject<SoundEvent> PEA_BOOM = SOUNDS.register("pea_boom", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(PVZMod.MODID, "pea_boom")));
    public static final RegistryObject<SoundEvent> ELECTRICPEASHOOTER_SHOOT = SOUNDS.register("electricpeashooter_shoot", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(PVZMod.MODID, "electricpeashooter_shoot")));

}