package keletu.pvzmod.models;

import keletu.pvzmod.entities.ScaredyShroomEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class ScaredyShroomRender<T extends ScaredyShroomEntity> extends MobRenderer<ScaredyShroomEntity, ScaredyShroomModel> {
    public ScaredyShroomRender(EntityRendererProvider.Context pContext) {
        super(pContext, new ScaredyShroomModel(pContext.bakeLayer(ScaredyShroomModel.LAYER_LOCATION)), 0.5F);
    }

    @Override
    public ResourceLocation getTextureLocation(ScaredyShroomEntity pEntity) {
        return ScaredyShroomModel.LAYER_LOCATION.getModel();
    }
}
