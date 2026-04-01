package keletu.pvzmod.models;

import keletu.pvzmod.entities.EntityGatlingPea;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

import javax.annotation.Nullable;

public class RenderGatlingPea extends GeoEntityRenderer<EntityGatlingPea> {
    public RenderGatlingPea(EntityRendererProvider.Context context) {
        super(context, new GatlingPeaModel());
    }

    @Override
    public RenderType getRenderType(EntityGatlingPea animatable, net.minecraft.resources.ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityTranslucent(texture);
    }
}
