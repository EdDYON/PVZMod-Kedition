package keletu.pvzmod.models;

import keletu.pvzmod.entities.EntitySnowPea;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class SnowPeaRender<T extends EntitySnowPea> extends MobRenderer<EntitySnowPea, SnowPeaModel> {
    public SnowPeaRender(EntityRendererProvider.Context pContext) {
        super(pContext, new SnowPeaModel(pContext.bakeLayer(SnowPeaModel.LAYER_LOCATION)), 0.0F);
    }

    @Override
    public ResourceLocation getTextureLocation(EntitySnowPea pEntity) {
        return SnowPeaModel.LAYER_LOCATION.getModel();
    }
}
