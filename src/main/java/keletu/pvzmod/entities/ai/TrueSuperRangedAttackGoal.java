package keletu.pvzmod.entities.ai;

import keletu.pvzmod.entities.EntitySuperGatlingPea;
import keletu.pvzmod.init.PVZSounds;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;

import java.util.EnumSet;

public class TrueSuperRangedAttackGoal extends Goal {
    private final EntitySuperGatlingPea mob;
    private LivingEntity target;
    private final double speedModifier;
    private int attackTime = -1;
    private final float attackRadius;
    private final float attackRadiusSqr;
    private int seeTime;
    private final int burstCount;
    private final int burstDelay;
    private int remainingShots;
    private int burstTimer;
    private int cooldown;
    private int cooldown_first;
    private boolean attackCycleStarted;

    public TrueSuperRangedAttackGoal(EntitySuperGatlingPea attacker, double speedModifier, float attackRadius) {
        this(attacker, speedModifier, attackRadius, 1, 0, 30, 25);
    }

    public TrueSuperRangedAttackGoal(EntitySuperGatlingPea attacker, double speedModifier, float attackRadius, int burstCount, int burstDelay, int cooldown, int cooldown_first) {
        if (attacker == null) {
            throw new IllegalArgumentException("ArrowAttackGoal requires Mob implements RangedAttackMob");
        }

        this.cooldown = cooldown;
        this.cooldown_first = cooldown_first;
        this.mob = attacker;
        this.speedModifier = speedModifier;
        this.attackRadius = attackRadius;
        this.attackRadiusSqr = attackRadius * attackRadius;
        this.burstCount = Math.max(1, burstCount);
        this.burstDelay = Math.max(0, burstDelay);
        this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
    }

    @Override
    public boolean canUse() {
        LivingEntity livingentity = this.mob.getTarget();
        if (livingentity != null && livingentity.isAlive()) {
            this.target = livingentity;
            return true;
        }
        return false;
    }

    @Override
    public boolean canContinueToUse() {
        if (this.target == null) {
            return false;
        }

        if (!this.target.isAlive()) {
            return this.isAttackCycleInProgress() || this.mob.isShootAnimationInProgress();
        }

        return true;
    }

    @Override
    public void stop() {
        this.target = null;
        this.seeTime = 0;
        this.attackTime = -1;
        this.remainingShots = 0;
        this.burstTimer = 0;
        this.attackCycleStarted = false;
        this.mob.stopShootingIfAnimationFinished();
    }

    @Override
    public boolean requiresUpdateEveryTick() {
        return true;
    }

    @Override
    public void tick() {
        if (this.target == null) {
            this.clearTargetAndStop();
            return;
        }

        boolean targetAlive = this.target.isAlive();
        if (!targetAlive && !this.isAttackCycleInProgress()) {
            if (this.mob.isShootAnimationInProgress()) {
                this.mob.getNavigation().stop();
                return;
            }

            this.clearTargetAndStop();
            return;
        }

        if (targetAlive && !this.mob.canAttack(this.target)) {
            this.clearTargetAndStop();
            return;
        }

        if (this.mob.isSuperFiring()) {
            this.mob.getLookControl().setLookAt(this.target, 30.0F, 30.0F);
            return;
        }

        double living = this.mob.distanceToSqr(this.target.getX(), this.target.getY(), this.target.getZ());
        boolean hasSight = !targetAlive || this.mob.getSensing().hasLineOfSight(this.target);

        if (targetAlive && hasSight) {
            ++this.seeTime;
        } else if (targetAlive) {
            this.seeTime = 0;
        }

        if (!targetAlive || (!(living > (double) this.attackRadiusSqr) && this.seeTime >= 5)) {
            this.mob.getNavigation().stop();
        } else {
            this.mob.getNavigation().moveTo(this.target, this.speedModifier);
        }

        this.mob.getLookControl().setLookAt(this.target, 30.0F, 30.0F);

        if (this.remainingShots > 0) {
            --this.burstTimer;
            if (this.burstTimer <= 0) {
                if (hasSight && this.target != null) {
                    float f2 = (float) Math.sqrt(living) / this.attackRadius;
                    float f3 = Mth.clamp(f2, 0.1F, 1.0F);
                    this.mob.performRangedAttack(this.target, f3);
                    this.tryTriggerSuperRapidFire();
                }
                --this.remainingShots;
                if (this.remainingShots <= 0) {
                    this.attackCycleStarted = false;
                }

                if (this.remainingShots > 0) {
                    this.burstTimer = this.burstDelay;
                }
            }
        }

        if (!targetAlive && !this.isAttackCycleInProgress()) {
            if (!this.mob.isShootAnimationInProgress()) {
                this.clearTargetAndStop();
            }
            return;
        }

        if (this.attackCycleStarted) {
            if (--this.attackTime != 0) {
                return;
            }

            if (!hasSight) {
                return;
            }

            float f2 = (float) Math.sqrt(living) / this.attackRadius;
            float f3 = Mth.clamp(f2, 0.1F, 1.0F);

            this.tryTriggerSuperRapidFire();
            this.mob.performRangedAttack(this.target, f3);
            this.mob.playSound(this.mob.getShootSound(), 1.0F, 1.0F / (this.mob.getRandom().nextFloat() * 0.4F + 0.8F));

            this.remainingShots = this.burstCount - 1;
            if (this.remainingShots > 0) {
                this.burstTimer = this.burstDelay;
            } else {
                this.attackCycleStarted = false;
            }

            this.attackTime = targetAlive ? cooldown : -1;
            return;
        }

        if (this.remainingShots > 0) {
            return;
        }

        if (this.attackTime > 0) {
            --this.attackTime;
            return;
        }

        if (targetAlive) {
            if (this.mob.startShootingAnimation()) {
                this.attackCycleStarted = true;
                this.attackTime = cooldown_first;
            }
        } else if (!this.mob.isShootAnimationInProgress()) {
            this.clearTargetAndStop();
        }
    }

    private boolean isAttackCycleInProgress() {
        return this.attackCycleStarted || this.remainingShots > 0;
    }

    private void clearTargetAndStop() {
        this.target = null;
        this.mob.setTarget(null);
        this.seeTime = 0;
        this.attackTime = -1;
        this.remainingShots = 0;
        this.burstTimer = 0;
        this.attackCycleStarted = false;
        this.mob.setShooting(false);
    }

    private void tryTriggerSuperRapidFire() {
        if (this.mob.canTriggerSuperRapidFire() && this.mob.getRandom().nextFloat() < EntitySuperGatlingPea.SUPER_RAPID_FIRE_CHANCE) {
            this.mob.triggerSuperRapidFire();
            this.mob.playSound(PVZSounds.SUPERGATLINGPEA_POWER.get(), 1.0F, 1.0F / (this.mob.getRandom().nextFloat() * 0.4F + 0.8F));
        }
    }
}
