package keletu.pvzmod.models;

import keletu.pvzmod.entities.EntitySuperSnowGatlingPea;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class SuperSnowGatlingPeaRender<T extends EntitySuperSnowGatlingPea> extends MobRenderer<EntitySuperSnowGatlingPea, SnowySuperGatlingPeaModel> {
    public SuperSnowGatlingPeaRender(EntityRendererProvider.Context pContext) {
        super(pContext, new SnowySuperGatlingPeaModel(pContext.bakeLayer(SnowySuperGatlingPeaModel.LAYER_LOCATION)), 0.5F);
    }

    @Override
    public ResourceLocation getTextureLocation(EntitySuperSnowGatlingPea pEntity) {
        return SnowySuperGatlingPeaModel.LAYER_LOCATION.getModel();
    }
}
