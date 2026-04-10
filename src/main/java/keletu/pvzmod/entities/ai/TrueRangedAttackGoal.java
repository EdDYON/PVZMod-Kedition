package keletu.pvzmod.entities.ai;

import keletu.pvzmod.entities.EntityPlantShooterBase;
import keletu.pvzmod.entities.FumeShroomEntity;
import keletu.pvzmod.init.PVZSounds;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.EnumSet;

public class TrueRangedAttackGoal extends Goal {
    private final EntityPlantShooterBase mob;
    @Nullable
    private LivingEntity target;
    private int attackTime;
    private final double speedModifier;
    private int seeTime;
    private final float attackRadius;
    private final float attackRadiusSqr;

    private final int burstCount;
    private final int burstDelay;
    private int remainingShots;
    private int burstTimer;
    private int cooldown;
    private int cooldown_first;

    public TrueRangedAttackGoal(EntityPlantShooterBase pRangedAttackMob, double pSpeedModifier, float pAttackRadius) {
        this(pRangedAttackMob, pSpeedModifier, pAttackRadius, 1, 0, 20, 20);
    }

    public TrueRangedAttackGoal(EntityPlantShooterBase pRangedAttackMob, double pSpeedModifier, float pAttackRadius, int pBurstCount, int pBurstDelay, int cooldown) {
        this(pRangedAttackMob, pSpeedModifier, pAttackRadius, pBurstCount, pBurstDelay, cooldown, cooldown);
    }

    public TrueRangedAttackGoal(EntityPlantShooterBase pRangedAttackMob, double pSpeedModifier, float pAttackRadius, int pBurstCount, int pBurstDelay, int cooldown, int cooldown_first) {
        this.attackTime = -1;
        this.remainingShots = 0;
        this.burstTimer = 0;
        this.cooldown_first = cooldown_first;

        if (pRangedAttackMob == null) {
            throw new IllegalArgumentException("ArrowAttackGoal requires Mob implements RangedAttackMob");
        } else {
            this.mob = pRangedAttackMob;
            this.speedModifier = pSpeedModifier;
            this.attackRadius = pAttackRadius;
            this.attackRadiusSqr = pAttackRadius * pAttackRadius;
            this.burstCount = Math.max(1, pBurstCount);
            this.burstDelay = Math.max(0, pBurstDelay);
            this.cooldown = cooldown;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
        }
    }

    public boolean canUse() {
        LivingEntity living = this.mob.getTarget();
        if (living != null && living.isAlive()) {
            this.target = living;
            this.mob.setShooting(true);
            return true;
        } else {
            return false;
        }
    }

    public boolean canContinueToUse() {
        if (this.target == null || !this.target.isAlive() || this.target.distanceTo(this.mob) > 24) {
            this.target = null;
            this.mob.setTarget(null);
            return false;
        }
        return true;
    }

    public void stop() {
        this.target = this.mob.getTarget();
        this.seeTime = 0;
        this.attackTime = -1;
        this.remainingShots = 0;
        this.burstTimer = 0;
        this.mob.setShooting(false);
    }

    public boolean requiresUpdateEveryTick() {
        return true;
    }

    public void tick() {
        if (this.target == null || !this.target.isAlive() || !this.mob.canAttack(this.target)) {
            this.target = null;
            this.mob.setTarget(null);
            this.mob.setShooting(false);
            return;
        }

        this.mob.faceTarget(this.target);

        double living = this.mob.distanceToSqr(this.target.getX(), this.target.getY(), this.target.getZ());
        boolean hasSight = this.mob.getSensing().hasLineOfSight(this.target);

        if (hasSight) {
            ++this.seeTime;
        } else {
            this.seeTime = 0;
        }

        if (!(living > (double) this.attackRadiusSqr) && this.seeTime >= 5) {
            this.mob.getNavigation().stop();
        } else {
            this.mob.getNavigation().moveTo(this.target, this.speedModifier);
        }

        this.mob.getLookControl().setLookAt(this.target, 30.0F, 30.0F);

        if (this.remainingShots > 0) {
            --this.burstTimer;
            if (this.burstTimer <= 0) {
                if (hasSight && this.target != null && this.target.isAlive()) {
                    float f2 = (float) Math.sqrt(living) / this.attackRadius;
                    float f3 = Mth.clamp(f2, 0.1F, 1.0F);
                    this.mob.performRangedAttack(this.target, f3);
                }
                --this.remainingShots;

                if (this.remainingShots > 0) {
                    this.burstTimer = this.burstDelay;
                }
            }
        }

        if (attackTime == 23 && this.mob instanceof FumeShroomEntity) {
            this.mob.playSound(
                    PVZSounds.FUME_SHROOM_SHOOT.get(),
                    1.0F,
                    1.0F / (this.mob.getRandom().nextFloat() * 0.4F + 0.8F)
            );
        }

        if (attackTime > 0 && attackTime < 16 && this.mob instanceof FumeShroomEntity entity) {
            Vec3 flatDir = new Vec3(
                    target.getX() - entity.getX(),
                    0.0D,
                    target.getZ() - entity.getZ()
            );

            Vec3 dir;
            if (flatDir.lengthSqr() < 1.0E-6D) {
                dir = entity.getLookAngle().multiply(1.0D, 0.0D, 1.0D).normalize();
            } else {
                dir = flatDir.normalize();
            }

            Vec3 nozzle = new Vec3(entity.getX(), entity.getY() + 0.7D, entity.getZ()).add(dir.scale(0.45D));
            Vec3 end = nozzle.add(dir.scale(1.0F));

            entity.spawnBeamParticles((ServerLevel) entity.level(), nozzle, dir);

        }
        if (--this.attackTime == 0) {
            if (!hasSight) {
                return;
            }

            float f2 = (float) Math.sqrt(living) / this.attackRadius;
            float f3 = Mth.clamp(f2, 0.1F, 1.0F);

            this.mob.performRangedAttack(this.target, f3);

            this.remainingShots = this.burstCount - 1;
            if (this.remainingShots > 0) {
                this.burstTimer = this.burstDelay;
            }

            this.attackTime = cooldown;
        } else if (this.attackTime < 0) {
            this.attackTime = cooldown_first;
        }
    }
}