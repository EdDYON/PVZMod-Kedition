package keletu.pvzmod.models;

import keletu.pvzmod.PVZMod;
import keletu.pvzmod.entities.EntityTallnut;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class TallnutModel extends GeoModel<EntityTallnut> {
    @Override
    public ResourceLocation getModelResource(EntityTallnut t) {
        if (t.getHealth() > t.getMaxHealth() * 2 / 3) {
            return new ResourceLocation(PVZMod.MODID, "geo/entity/plant/tall_nut.geo.json");
        } else if (t.getHealth() > t.getMaxHealth() * 1 / 3 && t.getHealth() <= t.getMaxHealth() * 2 / 3) {
            return new ResourceLocation(PVZMod.MODID, "geo/entity/plant/tall_nut1.geo.json");
        } else {
            return new ResourceLocation(PVZMod.MODID, "geo/entity/plant/tall_nut2.geo.json");
        }
    }

    @Override
    public ResourceLocation getTextureResource(EntityTallnut t) {
        if (t.getHealth() > t.getMaxHealth() * 2 / 3) {
            return new ResourceLocation(PVZMod.MODID, "textures/entity/plant/tallnut.png");
        } else if (t.getHealth() > t.getMaxHealth() * 1 / 3 && t.getHealth() <= t.getMaxHealth() * 2 / 3) {
            return new ResourceLocation(PVZMod.MODID, "textures/entity/plant/tallnut1.png");
        } else {
            return new ResourceLocation(PVZMod.MODID, "textures/entity/plant/tallnut2.png");
        }
    }

    @Override
    public ResourceLocation getAnimationResource(EntityTallnut t) {
        if (t.getHealth() > t.getMaxHealth() * 2 / 3) {
            return new ResourceLocation(PVZMod.MODID, "animations/tallnut.animation.json");
        } else if (t.getHealth() > t.getMaxHealth() * 1 / 3 && t.getHealth() <= t.getMaxHealth() * 2 / 3) {
            return new ResourceLocation(PVZMod.MODID, "animations/tallnut1.animation.json");
        } else {
            return new ResourceLocation(PVZMod.MODID, "animations/tallnut2.animation.json");
        }
    }
}
