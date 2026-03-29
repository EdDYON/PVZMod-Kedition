package keletu.pvzmod.entities;

import keletu.pvzmod.entities.projectile.PeaProjectile;
import keletu.pvzmod.init.PVZItems;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

public class EntityPeaShooter extends EntityPlantShooterBase implements GeoEntity {

    public static final RawAnimation STAND = RawAnimation.begin().thenLoop("stand");
    public static final RawAnimation SHOOT = RawAnimation.begin().thenLoop("shoot");
    private static final EntityDataAccessor<Boolean> IS_SHOOTING = SynchedEntityData.defineId(EntityPeaShooter.class, EntityDataSerializers.BOOLEAN);

    public EntityPeaShooter(EntityType<? extends EntityPlantShooterBase> entityType, Level par1World) {
        super(entityType, par1World, new ItemStack(PVZItems.PEASHOOTER_CARD.get()));
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(IS_SHOOTING, false);
    }

    public boolean isShooting() {
        return this.entityData.get(IS_SHOOTING);
    }

    public void setShooting(boolean shooting) {
        this.entityData.set(IS_SHOOTING, shooting);
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
        PeaProjectile ent = new PeaProjectile(world, this, 3);
        return ent;
    }

    @Override
    public boolean canAttack(LivingEntity target) {
        if (target != null) {
            double yDiff = Math.abs(target.getY() - this.getY());
            if (yDiff > 1.5D) {
                return false;
            }
        }
        return super.canAttack(target);
    }

    @Override
    public void tick() {
        super.tick();

        this.setXRot(0.0F);
        this.xRotO = 0.0F;

        if (this.getOwner() == null) {

        }
    }

    private boolean isValidHorizontalTarget(LivingEntity target) {
        double yDiff = Math.abs(target.getY() - this.getY());
        if (yDiff > 1.5D) {
            return false;
        }

        Vec3 viewVector = this.getViewVector(1.0F);
        Vec3 horizontalView = new Vec3(viewVector.x, 0, viewVector.z).normalize();

        Vec3 targetVector = new Vec3(target.getX() - this.getX(), 0, target.getZ() - this.getZ()).normalize();

        double dotProduct = horizontalView.dot(targetVector);

        return true;
    }

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "Found/NotFound", 5, state -> state.setAndContinue(this.isShooting() ? SHOOT : STAND)));
    }
}