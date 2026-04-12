package keletu.pvzmod.models;

import keletu.pvzmod.PVZMod;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.model.GeoModel;

public class PotBlockModel extends GeoModel {
    @Override
    public ResourceLocation getModelResource(GeoAnimatable t) {
        return new ResourceLocation(PVZMod.MODID, "geo/block/pot.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GeoAnimatable t) {
        return new ResourceLocation(PVZMod.MODID, "textures/block/pot.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GeoAnimatable t) {
        return new ResourceLocation(PVZMod.MODID, "animations/pot.animation.json");
    }
}
