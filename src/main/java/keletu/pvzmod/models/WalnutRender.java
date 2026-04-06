package keletu.pvzmod.models;

import keletu.pvzmod.entities.EntityWalnut;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class WalnutRender extends GeoEntityRenderer<EntityWalnut> {
    public WalnutRender(EntityRendererProvider.Context context) {
        super(context, new WalnutModel());
    }
}
