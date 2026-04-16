package keletu.pvzmod.entities;

import keletu.pvzmod.entities.ai.TrueRangedAttackGoal;
import keletu.pvzmod.entities.projectile.SporeProjectile;
import keletu.pvzmod.init.PVZItems;
import keletu.pvzmod.init.PVZSounds;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;

public class ScaredyShroomEntity extends EntityPlantShooterBase {

    private static final EntityDataAccessor<Integer> SCARED_TIME = SynchedEntityData.defineId(ScaredyShroomEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Boolean> IS_SCARED = SynchedEntityData.defineId(ScaredyShroomEntity.class, EntityDataSerializers.BOOLEAN);
    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState shootAnimationState = new AnimationState();
    public final AnimationState hideAnimation = new AnimationState();
    public final AnimationState hiddenAnimation = new AnimationState();
    public final AnimationState standAnimation = new AnimationState();

    public ScaredyShroomEntity(EntityType<? extends EntityPlantShooterBase> entityType, Level par1World) {
        super(entityType, par1World, new ItemStack(PVZItems.SCAREDY_SHROOM_CARD.get()));
    }

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
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(SCARED_TIME, 0);
        this.entityData.define(IS_SCARED, false);
    }

    public int getScaredTime() {
        return this.entityData.get(SCARED_TIME);
    }

    public void setScaredTime(int time) {
        this.entityData.set(SCARED_TIME, time);
    }

    public boolean isScared() {
        return this.entityData.get(IS_SCARED);
    }

    public void setScared(boolean isStart) {
        this.entityData.set(IS_SCARED, isStart);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putInt("GrowTime", this.getScaredTime());
        pCompound.putBoolean("isStart", this.isScared());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        this.setScaredTime(pCompound.getInt("GrowTime"));
        this.setScared(pCompound.getBoolean("isStart"));
    }

    @Override
    public void performRangedAttack(LivingEntity target, float distanceFactor) {
        if (!this.level().isClientSide) {
            if (this.isScared() || this.getScaredTime() > 0) {
                return;
            }

            this.faceTarget(target);

            ThrowableProjectile projectile = entitySelect(this.level());
            projectile.setPos(this.getX(), this.getEyeY() - 0.78125F, this.getZ());

            double toX = target.getX() - this.getX();
            double toZ = target.getZ() - this.getZ();

            projectile.shoot(toX, 0, toZ, 1.6F, 0.0F);

            this.playSound(PVZSounds.PUFF_SHROOM_SHOOT.get(), 1.0F, 1.0F / (this.getRandom().nextFloat() * 0.4F + 0.8F));

            this.level().addFreshEntity(projectile);

            if (target instanceof PathfinderMob mob && (mob.getTarget() == null || !mob.getTarget().isAlive())) {
                mob.setTarget(this);
            }
        }
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.0D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1.0D)
                .add(Attributes.FOLLOW_RANGE, 24D);
    }

    @Override
    public boolean canAttack(LivingEntity target) {
        return super.canAttack(target) && !hasMonsterWithinFearRange();
    }

    @Override
    public void tick() {
        super.tick();

        this.setXRot(0.0F);
        this.xRotO = 0.0F;

        updateScaredState();
        if (this.level().isClientSide) {
            setupAnimationStates();
        }
    }

    private void updateScaredState() {
        boolean hasMonsterNearby = hasMonsterWithinFearRange();

        if ((hasMonsterNearby || this.getScaredTime() > 0) && this.getScaredTime() < 20 && !this.isScared()) {
            this.setScaredTime(this.getScaredTime() + 1);
        }

        if (this.getScaredTime() == 20) {
            this.setScared(true);
        }

        if (this.level().isClientSide) {
            if (this.getScaredTime() > 0 && !this.isScared()) {
                this.hideAnimation.startIfStopped(this.tickCount);
                this.standAnimation.stop();
            } else if (hasMonsterNearby && this.isScared()) {
                this.hiddenAnimation.startIfStopped(this.tickCount);
                this.hideAnimation.stop();
                this.standAnimation.stop();
            }
        }

        if (!hasMonsterNearby && this.isScared()) {
            this.setScaredTime(this.getScaredTime() - 1);
            if (this.getScaredTime() == 0) {
                this.setScared(false);
                if (this.level().isClientSide) {
                    this.standAnimation.stop();
                    return;
                }
            }

            if (this.level().isClientSide) {
                this.standAnimation.startIfStopped(this.tickCount);
                this.hiddenAnimation.stop();
                this.hideAnimation.stop();
            }
        }
    }

    private boolean hasMonsterWithinFearRange() {
        double halfSize = 2.5D;
        AABB box = new AABB(
                this.getX() - halfSize, this.getY(), this.getZ() - halfSize,
                this.getX() + halfSize, this.getY() + halfSize, this.getZ() + halfSize
        );

        return !this.level().getEntitiesOfClass(Monster.class, box, Entity::isAlive).isEmpty();
    }

    public void setupAnimationStates() {
        if (this.getScaredTime() > 0) {
            this.idleAnimationState.stop();
            this.shootAnimationState.stop();
            return;
        } else {
            this.standAnimation.stop();
            this.hiddenAnimation.stop();
            this.hideAnimation.stop();
        }

        if (this.isShooting()) {
            this.idleAnimationState.stop();
            this.shootAnimationState.startIfStopped(this.tickCount);
        } else {
            this.shootAnimationState.stop();
            this.idleAnimationState.startIfStopped(this.tickCount);
        }
    }
}