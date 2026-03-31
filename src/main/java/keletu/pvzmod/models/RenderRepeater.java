package keletu.pvzmod.models;

import keletu.pvzmod.entities.EntityRepeater;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class RenderRepeater extends GeoEntityRenderer<EntityRepeater> {
    public RenderRepeater(EntityRendererProvider.Context context) {
        super(context, new RepeaterModel());
    }
}
