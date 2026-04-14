package keletu.pvzmod.models;

import keletu.pvzmod.entities.EntitySuperGatlingPea;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class SGPShooterRender<T extends EntitySuperGatlingPea> extends MobRenderer<EntitySuperGatlingPea, SuperGatlingPeaModel> {
    public SGPShooterRender(EntityRendererProvider.Context pContext) {
        super(pContext, new SuperGatlingPeaModel(pContext.bakeLayer(SuperGatlingPeaModel.LAYER_LOCATION)), 0.5F);
    }

    @Override
    public ResourceLocation getTextureLocation(EntitySuperGatlingPea pEntity) {
        return SuperGatlingPeaModel.LAYER_LOCATION.getModel();
    }
}
