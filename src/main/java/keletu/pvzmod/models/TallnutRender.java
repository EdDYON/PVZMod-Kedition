package keletu.pvzmod.models;

import keletu.pvzmod.entities.EntityTallnut;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

import javax.annotation.Nullable;

public class TallnutRender extends GeoEntityRenderer<EntityTallnut> {
    public TallnutRender(EntityRendererProvider.Context context) {
        super(context, new TallnutModel());
    }


    @Override
    public RenderType getRenderType(EntityTallnut animatable,
                                    ResourceLocation texture,
                                    @Nullable MultiBufferSource bufferSource,
                                    float partialTick) {
        return RenderType.entityTranslucentCull(texture);
    }
}
