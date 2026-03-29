package keletu.pvzmod.entities;

import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.monster.RangedAttackMob;

import javax.annotation.Nullable;
import java.util.EnumSet;

public class TrueRangedAttackGoal extends Goal {
    private final EntityPlantShooterBase mob;
    private final RangedAttackMob rangedAttackMob;
    @Nullable
    private LivingEntity target;
    private int attackTime;
    private final double speedModifier;
    private int seeTime;
    private final int attackIntervalMin;
    private final int attackIntervalMax;
    private final float attackRadius;
    private final float attackRadiusSqr;

    public TrueRangedAttackGoal(EntityPlantShooterBase pRangedAttackMob, double pSpeedModifier, int pAttackInterval, float pAttackRadius) {
        this(pRangedAttackMob, pSpeedModifier, pAttackInterval, pAttackInterval, pAttackRadius);
    }

    public TrueRangedAttackGoal(EntityPlantShooterBase pRangedAttackMob, double pSpeedModifier, int pAttackIntervalMin, int pAttackIntervalMax, float pAttackRadius) {
        this.attackTime = -1;
        if (pRangedAttackMob == null) {
            throw new IllegalArgumentException("ArrowAttackGoal requires Mob implements RangedAttackMob");
        } else {
            this.rangedAttackMob = pRangedAttackMob;
            this.mob = pRangedAttackMob;
            this.speedModifier = pSpeedModifier;
            this.attackIntervalMin = pAttackIntervalMin;
            this.attackIntervalMax = pAttackIntervalMax;
            this.attackRadius = pAttackRadius;
            this.attackRadiusSqr = pAttackRadius * pAttackRadius;
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
        if (this.target == null || !this.target.isAlive()) {
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
        this.mob.setShooting(false);
    }

    public boolean requiresUpdateEveryTick() {
        return true;
    }

    public void tick() {
        if (this.target == null || !this.target.isAlive()) {
            this.target = null;
            this.mob.setTarget(null);
            this.mob.setShooting(false);
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
        if (--this.attackTime == 0) {
            if (!hasSight) {
                return;
            }

            float f2 = (float) Math.sqrt(living) / this.attackRadius;
            float f3 = Mth.clamp(f2, 0.1F, 1.0F);
            this.rangedAttackMob.performRangedAttack(this.target, f3);
            this.attackTime = 20;
        } else if (this.attackTime < 0) {
            this.attackTime = 20;
        }

    }
}