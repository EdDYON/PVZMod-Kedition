package keletu.pvzmod.models;

import keletu.pvzmod.PVZMod;
import keletu.pvzmod.entities.FumeShroomEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class FumeShroomRenderer<T extends FumeShroomEntity> extends MobRenderer<FumeShroomEntity, FumeShroomModelVanilla> {
    public FumeShroomRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new FumeShroomModelVanilla(pContext.bakeLayer(FumeShroomModelVanilla.LAYER_LOCATION)), 0.4F);
    }

    @Override
    public ResourceLocation getTextureLocation(FumeShroomEntity pEntity) {
        return new ResourceLocation(PVZMod.MODID, "textures/entity/plant/fume_shroom_new.png");
    }
}
