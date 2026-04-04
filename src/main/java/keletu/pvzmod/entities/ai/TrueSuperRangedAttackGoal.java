package keletu.pvzmod.entities.ai;

import keletu.pvzmod.entities.EntitySuperGatlingPea;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;

import java.util.EnumSet;

public class TrueSuperRangedAttackGoal extends Goal {
    private final EntitySuperGatlingPea mob;
    private LivingEntity target;
    private final double speedModifier;
    private int attackTime = -1;
    private final int attackIntervalMin;
    private final float attackIntervalMax;
    private final float attackRadius;
    private final float attackRadiusSqr;
    private int seeTime;
    private final int burstCount;
    private final int burstDelay;
    private int remainingShots;
    private int burstTimer;

    public TrueSuperRangedAttackGoal(EntitySuperGatlingPea attacker, double speedModifier, int attackIntervalMin, float attackIntervalMax, float attackRadius) {
        this(attacker, speedModifier, attackIntervalMin, attackIntervalMax, attackRadius, 1, 0);
    }

    public TrueSuperRangedAttackGoal(EntitySuperGatlingPea attacker, double speedModifier, int attackIntervalMin, float attackIntervalMax, float attackRadius, int burstCount, int burstDelay) {
        if (attacker == null) {
            throw new IllegalArgumentException("ArrowAttackGoal requires Mob implements RangedAttackMob");
        }

        this.mob = attacker;
        this.speedModifier = speedModifier;
        this.attackIntervalMin = attackIntervalMin;
        this.attackIntervalMax = attackIntervalMax;
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
            this.mob.setShooting(true);
            return true;
        }
        return false;
    }

    @Override
    public boolean canContinueToUse() {
        return this.canUse();
    }

    @Override
    public void stop() {
        this.target = null;
        this.seeTime = 0;
        this.attackTime = -1;
        this.remainingShots = 0;
        this.burstTimer = 0;
        this.mob.setShooting(false);
    }

    @Override
    public boolean requiresUpdateEveryTick() {
        return true;
    }

    @Override
    public void tick() {
        if (this.target == null || !this.target.isAlive() || !this.mob.canAttack(this.target)) {
            if (this.mob.isSuperFiring()) {
                this.mob.setShooting(true);
                return;
            }

            this.target = null;
            this.mob.setTarget(null);
            this.mob.setShooting(false);
            return;
        }

        if (this.mob.isSuperFiring()) {
            this.mob.getLookControl().setLookAt(this.target, 30.0F, 30.0F);
            this.mob.setShooting(true);
            return;
        }

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

        double distanceSqr = Math.sqrt(living);
        int cooldown = Mth.floor(Mth.lerp(distanceSqr / this.attackRadius, this.attackIntervalMin, this.attackIntervalMax));

        if (this.remainingShots > 0) {
            --this.burstTimer;
            if (this.burstTimer <= 0) {
                if (hasSight && this.target != null && this.target.isAlive()) {
                    float f2 = (float) Math.sqrt(living) / this.attackRadius;
                    float f3 = Mth.clamp(f2, 0.1F, 1.0F);
                    this.mob.performRangedAttack(this.target, f3);
                    this.tryTriggerSuperRapidFire();
                }
                --this.remainingShots;

                if (this.remainingShots > 0) {
                    this.burstTimer = this.burstDelay;
                }
            }
        }

        if (--this.attackTime == 0) {
            if (!hasSight) {
                return;
            }

            float f2 = (float) Math.sqrt(living) / this.attackRadius;
            float f3 = Mth.clamp(f2, 0.1F, 1.0F);

            this.tryTriggerSuperRapidFire();
            this.mob.performRangedAttack(this.target, f3);

            this.remainingShots = this.burstCount - 1;
            if (this.remainingShots > 0) {
                this.burstTimer = this.burstDelay;
            }

            this.attackTime = cooldown;
        } else if (this.attackTime < 0) {
            this.attackTime = cooldown;
        }
    }

    private void tryTriggerSuperRapidFire() {
        if (this.mob.canTriggerSuperRapidFire() && this.mob.getRandom().nextFloat() < EntitySuperGatlingPea.SUPER_RAPID_FIRE_CHANCE) {
            this.mob.triggerSuperRapidFire();
        }
    }
}