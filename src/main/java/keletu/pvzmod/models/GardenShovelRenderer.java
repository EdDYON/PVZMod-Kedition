package keletu.pvzmod.models;

import keletu.pvzmod.items.ItemGardenShovel;
import net.minecraft.client.Minecraft;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class GardenShovelRenderer extends GeoItemRenderer<ItemGardenShovel> {
    public GardenShovelRenderer() {
        super(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels(), new GardenShovelModel());
    }
}
