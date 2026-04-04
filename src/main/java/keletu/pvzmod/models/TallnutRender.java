package keletu.pvzmod.models;

import keletu.pvzmod.entities.EntityTallnut;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class TallnutRender extends GeoEntityRenderer<EntityTallnut> {
    public TallnutRender(EntityRendererProvider.Context context) {
        super(context, new TallnutModel());
    }
}
