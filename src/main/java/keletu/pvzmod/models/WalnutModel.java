package keletu.pvzmod.models;

import keletu.pvzmod.PVZMod;
import keletu.pvzmod.entities.EntityWalnut;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class WalnutModel extends GeoModel<EntityWalnut> {
    @Override
    public ResourceLocation getModelResource(EntityWalnut t) {
        if (t.getHealth() > t.getMaxHealth() * 2 / 3) {
            return new ResourceLocation(PVZMod.MODID, "geo/entity/plant/wall_nut.geo.json");
        } else if (t.getHealth() > t.getMaxHealth() * 1 / 3 && t.getHealth() <= t.getMaxHealth() * 2 / 3) {
            return new ResourceLocation(PVZMod.MODID, "geo/entity/plant/wall_nut1.geo.json");
        } else {
            return new ResourceLocation(PVZMod.MODID, "geo/entity/plant/wall_nut2.geo.json");
        }
    }

    @Override
    public ResourceLocation getTextureResource(EntityWalnut t) {
        if (t.getHealth() > t.getMaxHealth() * 2 / 3) {
            return new ResourceLocation(PVZMod.MODID, "textures/entity/plant/walnut.png");
        } else if (t.getHealth() > t.getMaxHealth() * 1 / 3 && t.getHealth() <= t.getMaxHealth() * 2 / 3) {
            return new ResourceLocation(PVZMod.MODID, "textures/entity/plant/walnut1.png");
        } else {
            return new ResourceLocation(PVZMod.MODID, "textures/entity/plant/walnut2.png");
        }
    }

    @Override
    public ResourceLocation getAnimationResource(EntityWalnut t) {
        if (t.getHealth() > t.getMaxHealth() * 2 / 3) {
            return new ResourceLocation(PVZMod.MODID, "animations/walnut.animation.json");
        } else if (t.getHealth() > t.getMaxHealth() * 1 / 3 && t.getHealth() <= t.getMaxHealth() * 2 / 3) {
            return new ResourceLocation(PVZMod.MODID, "animations/walnut1.animation.json");
        } else {
            return new ResourceLocation(PVZMod.MODID, "animations/walnut2.animation.json");
        }
    }
}
