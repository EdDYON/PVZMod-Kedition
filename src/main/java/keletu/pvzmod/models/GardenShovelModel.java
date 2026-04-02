package keletu.pvzmod.models;

import keletu.pvzmod.PVZMod;
import keletu.pvzmod.item.ItemGardenShovel;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class GardenShovelModel extends GeoModel<ItemGardenShovel> {
    @Override
    public ResourceLocation getModelResource(ItemGardenShovel itemGardenShovel) {
        return new ResourceLocation(PVZMod.MODID, "geo/item/garden_shovel.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ItemGardenShovel itemGardenShovel) {
        return new ResourceLocation(PVZMod.MODID, "textures/item/garden_shovel.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ItemGardenShovel itemGardenShovel) {
        return null;
    }
}
