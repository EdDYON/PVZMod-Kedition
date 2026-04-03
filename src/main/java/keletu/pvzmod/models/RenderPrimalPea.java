package keletu.pvzmod.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import keletu.pvzmod.entities.projectile.PrimalPeaProjectile;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.item.ItemDisplayContext;
import org.jetbrains.annotations.NotNull;

public class RenderPrimalPea extends ThrownItemRenderer<PrimalPeaProjectile> {

    public RenderPrimalPea(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public void render(PrimalPeaProjectile entity, float entityYaw, float partialTicks, PoseStack matrixStackIn, @NotNull MultiBufferSource bufferIn, int packedLightIn) {
        matrixStackIn.pushPose();
        matrixStackIn.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTicks, entity.yRotO, entity.getYRot()) - 90.0F));
        matrixStackIn.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(partialTicks, entity.xRotO, entity.getXRot())));
        matrixStackIn.mulPose(Axis.YP.rotationDegrees(0.0F));
        matrixStackIn.mulPose(Axis.ZN.rotationDegrees((entity.tickCount + partialTicks) * 30.0F));
        Minecraft.getInstance().getItemRenderer().renderStatic(((ItemSupplier) entity).getItem(), ItemDisplayContext.GROUND, 240, OverlayTexture.NO_OVERLAY, matrixStackIn, bufferIn, Minecraft.getInstance().level, 0);
        matrixStackIn.popPose();
    }
}