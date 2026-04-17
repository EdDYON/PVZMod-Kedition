package keletu.pvzmod.entities;

import keletu.pvzmod.entities.ai.PlanterHurtByTargetGoal;
import keletu.pvzmod.entities.ai.PlanterHurtTargetGoal;
import keletu.pvzmod.entities.ai.TrueRangedAttackGoal;
import keletu.pvzmod.init.PVZSounds;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Snowball;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public abstract class EntityPlantShooterBase extends EntityPlantBase implements RangedAttackMob {
    private static final EntityDataAccessor<Boolean> IS_SHOOTING = SynchedEntityData.defineId(EntityPlantShooterBase.class, EntityDataSerializers.BOOLEAN);

    public EntityPlantShooterBase(EntityType<? extends EntityPlantBase> entityType, Level level) {
        super(entityType, level);
    }

    public EntityPlantShooterBase(EntityType<? extends EntityPlantBase> entityType, Level level, ItemStack spawnStack) {
        super(entityType, level, spawnStack);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, createRangedAttackGoal());

        this.goalSelector.addGoal(9, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(10, new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(1, new PlanterHurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new PlanterHurtTargetGoal(this));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Monster.class, true));
    }

    protected Goal createRangedAttackGoal() {
        return new TrueRangedAttackGoal(this, 0.0F, this.range, 1, 0, 30, 25);
    }

    public boolean hasAttackLineOfSight(LivingEntity target) {
        return this.getSensing().hasLineOfSight(target);
    }

    public SoundEvent getShootSound() {
        return PVZSounds.PEASHOOTER_SHOOT.get();
    }

    @Override
    public void performRangedAttack(LivingEntity target, float distanceFactor) {
        if (!this.level().isClientSide) {
            this.faceTarget(target);

            ThrowableProjectile projectile = entitySelect(this.level());
            projectile.setPos(this.getX(), this.getEyeY() - 0.2D, this.getZ());

            double toX = target.getX() - this.getX();
            double toZ = target.getZ() - this.getZ();

            projectile.shoot(toX, 0, toZ, 1.6F, 0.0F);

            if (!(this instanceof EntitySuperGatlingPea))
                this.playSound(getShootSound(), 1.0F, 1.0F / (this.getRandom().nextFloat() * 0.4F + 0.8F));

            this.level().addFreshEntity(projectile);

            if (target instanceof PathfinderMob && (((PathfinderMob) target).getTarget() == null || !((PathfinderMob) target).getTarget().isAlive())) {
                ((PathfinderMob) target).setTarget(this);
            }
        }
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

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putBoolean("Shooting", this.isShooting());
        //this.addPersistentAngerSaveData(pCompound);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        this.setShooting(pCompound.getBoolean("Shooting"));
        //this.readPersistentAngerSaveData(this.level(), pCompound);
    }

    public ThrowableProjectile entitySelect(Level level) {
        return new Snowball(level, this);
    }
}
