package keletu.pvzmod.models;

import keletu.pvzmod.entities.EntityWalnut;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

import javax.annotation.Nullable;

public class WalnutRender extends GeoEntityRenderer<EntityWalnut> {
    public WalnutRender(EntityRendererProvider.Context context) {
        super(context, new WalnutModel());
    }


    @Override
    public RenderType getRenderType(EntityWalnut animatable,
                                    ResourceLocation texture,
                                    @Nullable MultiBufferSource bufferSource,
                                    float partialTick) {
        return RenderType.entityTranslucentCull(texture);
    }
}
