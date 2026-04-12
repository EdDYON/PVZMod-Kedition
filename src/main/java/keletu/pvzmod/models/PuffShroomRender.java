package keletu.pvzmod.models;

import keletu.pvzmod.entities.PuffShroomEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class PuffShroomRender<T extends PuffShroomEntity> extends MobRenderer<PuffShroomEntity, PuffShroomModel> {
    public PuffShroomRender(EntityRendererProvider.Context pContext) {
        super(pContext, new PuffShroomModel(pContext.bakeLayer(PuffShroomModel.LAYER_LOCATION)), 0.0F);
    }

    @Override
    public ResourceLocation getTextureLocation(PuffShroomEntity pEntity) {
        return PuffShroomModel.LAYER_LOCATION.getModel();
    }
}
