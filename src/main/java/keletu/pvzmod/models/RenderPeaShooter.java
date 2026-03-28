package keletu.pvzmod.models;

import keletu.pvzmod.entities.EntityPeaShooter;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class RenderPeaShooter extends GeoEntityRenderer<EntityPeaShooter> {
    public RenderPeaShooter(EntityRendererProvider.Context context) {
        super(context, new PeaShooterModel());
    }
}
