package keletu.pvzmod.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import keletu.pvzmod.PVZMod;
import keletu.pvzmod.entities.projectile.SporeProjectile;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class SporeRenderer extends EntityRenderer<SporeProjectile> {
    private static final ResourceLocation DAGGERFROST_SNOWBALL_TEXTURE = new ResourceLocation(PVZMod.MODID, "textures/item/spore.png");

    public SporeRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public void render(SporeProjectile snowball, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        if (snowball.tickCount >= 2 || !(this.entityRenderDispatcher.camera.getEntity().distanceToSqr(snowball) < 12.25)) {
            poseStack.pushPose();
            poseStack.scale(0.5F, 0.5F, 0.5F);
            poseStack.mulPose(this.entityRenderDispatcher.cameraOrientation());
            poseStack.mulPose(Axis.YP.rotationDegrees(180.0F));
            PoseStack.Pose pose = poseStack.last();
            VertexConsumer vertexconsumer = buffer.getBuffer(RenderType.entityCutoutNoCull(this.getTextureLocation(snowball)));
            vertex(vertexconsumer, pose, packedLight, 0.0F, 0, 0, 1);
            vertex(vertexconsumer, pose, packedLight, 1.0F, 0, 1, 1);
            vertex(vertexconsumer, pose, packedLight, 1.0F, 1, 1, 0);
            vertex(vertexconsumer, pose, packedLight, 0.0F, 1, 0, 0);
            poseStack.popPose();
            super.render(snowball, entityYaw, partialTicks, poseStack, buffer, packedLight);
        }
    }

    private static void vertex(VertexConsumer consumer, PoseStack.Pose pose, int packedLight, float x, int y, int u, int v) {
        consumer.vertex(pose.pose(), x - 0.5F, (float) y - 0.25F, 0.0F)
                .color(255, 255, 255, 255)
                .uv((float) u, (float) v)
                .overlayCoords(OverlayTexture.NO_OVERLAY)
                .uv2(packedLight)
                .normal(pose.normal(), 0.0F, 1.0F, 0.0F);
    }

    @Override
    public ResourceLocation getTextureLocation(SporeProjectile snowball) {
        return DAGGERFROST_SNOWBALL_TEXTURE;
    }
}