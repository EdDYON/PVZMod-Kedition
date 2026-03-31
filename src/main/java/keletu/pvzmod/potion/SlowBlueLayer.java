package keletu.pvzmod.potion;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import keletu.pvzmod.init.PVZEffects;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;

public class SlowBlueLayer<T extends LivingEntity, M extends EntityModel<T>> extends RenderLayer<T, M> {

    private final RenderLayerParent<T, M> parent;

    public SlowBlueLayer(RenderLayerParent<T, M> parent) {
        super(parent);
        this.parent = parent;
    }

    @Override
    public void render(
            PoseStack poseStack,
            MultiBufferSource bufferSource,
            int packedLight,
            T entity,
            float limbSwing,
            float limbSwingAmount,
            float partialTick,
            float ageInTicks,
            float netHeadYaw,
            float headPitch
    ) {
        if (!entity.hasEffect(PVZEffects.SNOW.get())) {
            return;
        }

        ResourceLocation texture = parent.getTextureLocation(entity);
        VertexConsumer buffer = bufferSource.getBuffer(RenderType.entityTranslucent(texture));

        this.getParentModel().renderToBuffer(
                poseStack,
                buffer,
                packedLight,
                LivingEntityRenderer.getOverlayCoords(entity, 0.0F),
                0.3F, 0.6F, 1.0F, 0.5F
        );
    }
}