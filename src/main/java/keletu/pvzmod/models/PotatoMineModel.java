package keletu.pvzmod.models;

import keletu.pvzmod.PVZMod;
import keletu.pvzmod.entities.EntityPotatoMine;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class PotatoMineModel extends GeoModel<EntityPotatoMine> {
    @Override
    public ResourceLocation getModelResource(EntityPotatoMine t) {
        return new ResourceLocation(PVZMod.MODID, "geo/entity/plant/potato_mine.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityPotatoMine t) {
        return new ResourceLocation(PVZMod.MODID, "textures/entity/plant/potato_mine.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityPotatoMine t) {
        return new ResourceLocation(PVZMod.MODID, "animations/potato_mine.animation.json");
    }
}
