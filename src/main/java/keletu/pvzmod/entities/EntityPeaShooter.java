package keletu.pvzmod.entities;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Snowball;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

public class EntityPeaShooter extends EntityPlantShooterBase implements GeoEntity {

    public static final RawAnimation STAND = RawAnimation.begin().thenLoop("stand");
    public static final RawAnimation SHOOT = RawAnimation.begin().thenLoop("shoot");

    public EntityPeaShooter(EntityType<? extends EntityPlantShooterBase> entityType, Level par1World) {
        super(entityType, par1World/*, new ItemStack(PvZ.basicPlants, 1, 1)*/);
    }

    // protected Item getDropItem() {
    //     return PvZ.peaPod;
    // }

    @Override
    public InteractionResult mobInteract(Player par1EntityPlayer, InteractionHand hand) {
        return InteractionResult.PASS;
    }

    @Override
    public ThrowableProjectile entitySelect(Level world) {
        Snowball ent = new Snowball(world, this);
        return ent;
    }

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "Found/NotFound", 5, state -> state.setAndContinue(this.getTarget() == null ? STAND : SHOOT)));
    }
}