package keletu.pvzmod.entities;

import keletu.pvzmod.entities.ai.TrueRangedAttackGoal;
import keletu.pvzmod.entities.projectile.SporeProjectile;
import keletu.pvzmod.init.PVZItems;
import keletu.pvzmod.init.PVZSounds;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

public class PuffShroomEntity extends EntityPlantShooterBase implements GeoEntity {

    public static final RawAnimation STAND = RawAnimation.begin().thenLoop("stand");
    public static final RawAnimation SHOOT = RawAnimation.begin().thenLoop("shoot");

    public PuffShroomEntity(EntityType<? extends EntityPlantShooterBase> entityType, Level par1World) {
        super(entityType, par1World, new ItemStack(PVZItems.PUFF_SHROOM_CARD.get()));
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
        SporeProjectile ent = new SporeProjectile(world, this, 3);
        return ent;
    }

    @Override
    protected TrueRangedAttackGoal createRangedAttackGoal() {
        return new TrueRangedAttackGoal(this, 0.0F, this.range, 1, 0, 30, 20);
    }

    @Override
    public void performRangedAttack(LivingEntity target, float distanceFactor) {
        if (!this.level().isClientSide) {
            this.faceTarget(target);

            ThrowableProjectile projectile = entitySelect(this.level());
            projectile.setPos(this.getX(), this.getEyeY() - 0.6F, this.getZ());

            double toX = target.getX() - this.getX();
            double toZ = target.getZ() - this.getZ();

            projectile.shoot(toX, 0, toZ, 1.6F, 0.0F);

            this.playSound(PVZSounds.PUFF_SHROOM_SHOOT.get(), 1.0F, 1.0F / (this.getRandom().nextFloat() * 0.4F + 0.8F));

            this.level().addFreshEntity(projectile);

            if (target instanceof PathfinderMob && (((PathfinderMob) target).getTarget() == null || !((PathfinderMob) target).getTarget().isAlive())) {
                ((PathfinderMob) target).setTarget(this);
            }
        }
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 10.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.0D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1.0D)
                .add(Attributes.FOLLOW_RANGE, 16.0F);
    }

    @Override
    public boolean canAttack(LivingEntity target) {
        return super.canAttack(target) && target.distanceTo(this) <= 8.0F;
    }

    @Override
    public void tick() {
        super.tick();

        this.setXRot(0.0F);
        this.xRotO = 0.0F;
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