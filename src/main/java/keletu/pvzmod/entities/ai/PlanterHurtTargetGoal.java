package keletu.pvzmod.entities.ai;

import keletu.pvzmod.entities.EntityPlantBase;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.target.TargetGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;

import java.util.EnumSet;

public class PlanterHurtTargetGoal extends TargetGoal {
    private final EntityPlantBase tameAnimal;
    private LivingEntity ownerLastHurt;
    private int timestamp;

    public PlanterHurtTargetGoal(EntityPlantBase pTameAnimal) {
        super(pTameAnimal, false);
        this.tameAnimal = pTameAnimal;
        this.setFlags(EnumSet.of(Flag.TARGET));
    }

    public boolean canUse() {
        if (this.tameAnimal.getOwner() != null && this.targetMob != null && this.targetMob.distanceTo(this.tameAnimal) <= 24) {
            LivingEntity $$0 = this.tameAnimal.getOwner();
            if ($$0 == null) {
                return false;
            } else {
                this.ownerLastHurt = $$0.getLastHurtMob();
                int $$1 = $$0.getLastHurtMobTimestamp();
                return $$1 != this.timestamp && this.canAttack(this.ownerLastHurt, TargetingConditions.DEFAULT) && this.tameAnimal.wantsToAttack(this.ownerLastHurt, $$0);
            }
        } else {
            return false;
        }
    }

    public void start() {
        this.mob.setTarget(this.ownerLastHurt);
        LivingEntity $$0 = this.tameAnimal.getOwner();
        if ($$0 != null) {
            this.timestamp = $$0.getLastHurtMobTimestamp();
        }

        super.start();
    }
}
