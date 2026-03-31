package keletu.pvzmod.models;

import keletu.pvzmod.entities.EntitySnowPea;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class RenderSnowPea extends GeoEntityRenderer<EntitySnowPea> {
    public RenderSnowPea(EntityRendererProvider.Context context) {
        super(context, new SnowPeaModel());
    }
}
