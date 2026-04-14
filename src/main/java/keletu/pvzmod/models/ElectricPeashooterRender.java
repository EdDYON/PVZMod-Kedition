package keletu.pvzmod.models;

import keletu.pvzmod.entities.ElectricPeashooterEntity;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class ElectricPeashooterRender<T extends ElectricPeashooterEntity> extends MobRenderer<ElectricPeashooterEntity, ElectricPeashooterModel> {
    public ElectricPeashooterRender(EntityRendererProvider.Context pContext) {
        super(pContext, new ElectricPeashooterModel(pContext.bakeLayer(ElectricPeashooterModel.LAYER_LOCATION)), 0.5F);
        this.addLayer(new ElectricPeashooterLayer(this));
    }

    @Override
    public ResourceLocation getTextureLocation(ElectricPeashooterEntity pEntity) {
        return ElectricPeashooterModel.LAYER_LOCATION.getModel();
    }

    @Override
    protected RenderType getRenderType(ElectricPeashooterEntity entity, boolean bodyVisible, boolean translucent, boolean glowing) {
        return RenderType.itemEntityTranslucentCull(getTextureLocation(entity));
    }
}
