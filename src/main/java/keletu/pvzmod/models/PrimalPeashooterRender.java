package keletu.pvzmod.models;

import keletu.pvzmod.entities.EntityPrimalPeashooter;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class PrimalPeashooterRender<T extends EntityPrimalPeashooter> extends MobRenderer<EntityPrimalPeashooter, PrimalPeashooterModel> {
    public PrimalPeashooterRender(EntityRendererProvider.Context pContext) {
        super(pContext, new PrimalPeashooterModel(pContext.bakeLayer(PrimalPeashooterModel.LAYER_LOCATION)), 0.5F);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityPrimalPeashooter pEntity) {
        return PrimalPeashooterModel.LAYER_LOCATION.getModel();
    }
}
