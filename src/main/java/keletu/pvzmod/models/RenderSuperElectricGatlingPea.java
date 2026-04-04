package keletu.pvzmod.models;

import keletu.pvzmod.entities.EntitySuperElectricGatlingPea;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

import javax.annotation.Nullable;

public class RenderSuperElectricGatlingPea extends GeoEntityRenderer<EntitySuperElectricGatlingPea> {
    public RenderSuperElectricGatlingPea(EntityRendererProvider.Context context) {
        super(context, new SuperElectricGatlingPeaModel());
    }

    @Override
    public RenderType getRenderType(EntitySuperElectricGatlingPea animatable,
                                    ResourceLocation texture,
                                    @Nullable MultiBufferSource bufferSource,
                                    float partialTick) {
        return RenderType.entityTranslucentCull(texture);
    }
}
