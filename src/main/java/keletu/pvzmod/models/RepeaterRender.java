package keletu.pvzmod.models;

import keletu.pvzmod.entities.EntityRepeater;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class RepeaterRender<T extends EntityRepeater> extends MobRenderer<EntityRepeater, RepeaterModel> {
    public RepeaterRender(EntityRendererProvider.Context pContext) {
        super(pContext, new RepeaterModel(pContext.bakeLayer(RepeaterModel.LAYER_LOCATION)), 0.0F);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityRepeater pEntity) {
        return RepeaterModel.LAYER_LOCATION.getModel();
    }
}
