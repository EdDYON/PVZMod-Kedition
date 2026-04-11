/*package keletu.pvzmod.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import keletu.pvzmod.PVZMod;
import keletu.pvzmod.entities.EntitySuperElectricGatlingPea;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

import javax.annotation.Nullable;

public class RenderSuperElectricGatlingPea extends GeoEntityRenderer<EntitySuperElectricGatlingPea> {

    public RenderSuperElectricGatlingPea(EntityRendererProvider.Context context) {
        super(context, new SuperElectricGatlingPeaModel());
        this.addRenderLayer(new EmissiveGeoLayer(this));
    }

    @Override
    public RenderType getRenderType(EntitySuperElectricGatlingPea animatable,
                                    ResourceLocation texture,
                                    @Nullable MultiBufferSource bufferSource,
                                    float partialTick) {
        return RenderType.entityTranslucentCull(texture);
    }

    private static class EmissiveGeoLayer extends GeoRenderLayer<EntitySuperElectricGatlingPea> {
        private static final ResourceLocation EMISSIVE = new ResourceLocation(PVZMod.MODID, "textures/entity/plant/super_electric_gatling_pea_emissive.png");

        public EmissiveGeoLayer(GeoRenderer<EntitySuperElectricGatlingPea> renderer) {
            super(renderer);
        }

        @Override
        public void render(PoseStack poseStack, EntitySuperElectricGatlingPea animatable, BakedGeoModel bakedModel,
                           RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer,
                           float partialTick, int packedLight, int packedOverlay) {

            RenderType emissiveType = RenderType.eyes(EMISSIVE);
            VertexConsumer emissiveBuffer = bufferSource.getBuffer(emissiveType);

            getRenderer().reRender(bakedModel, poseStack, bufferSource, animatable, emissiveType, emissiveBuffer, partialTick, 15728640, packedOverlay, 0.5f, 1.0f, 0.5f, 1.0f);
        }
    }
}
*/