package keletu.pvzmod.models;

import keletu.pvzmod.entities.EntityPrimalPeashooter;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class RenderPrimalPeashooter extends GeoEntityRenderer<EntityPrimalPeashooter> {
    public RenderPrimalPeashooter(EntityRendererProvider.Context context) {
        super(context, new PrimalPeashooterModel());
    }
}
