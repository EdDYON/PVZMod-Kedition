package keletu.pvzmod.entities;

import keletu.pvzmod.init.PVZItems;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import software.bernie.geckolib.core.animation.RawAnimation;

import java.util.List;

public class EntityWalnut extends EntityPlantBase {

    public final AnimationState idleAnimation0 = new AnimationState();
    public final AnimationState idleAnimation1 = new AnimationState();
    public final AnimationState idleAnimation2 = new AnimationState();
    private final double protectRadio;
    private static final int RETARGET_INTERVAL = 10;
    public static final RawAnimation STAND = RawAnimation.begin().thenLoop("animation");

    public EntityWalnut(EntityType<? extends EntityPlantBase> type, Level par1World, float protectRadio) {
        super(type, par1World, new ItemStack(PVZItems.WALNUT_CARD.get(), 1));
        this.protectRadio = protectRadio;
    }

    public static AttributeSupplier.Builder createAttributes() {
        return EntityPlantBase.createAttributes().add(Attributes.MAX_HEALTH, 10.0D * 16);
    }

    @Override
    protected void registerGoals() {
        this.getNavigation().setCanFloat(false);
    }

    @Override
    public void tick() {
        super.tick();

        if (this.level().isClientSide()) {
            setupAnimationStates();
        }

        if (this.level().isClientSide || this.tickCount % RETARGET_INTERVAL != 0) {
            return;
        }

        AABB searchBox = new AABB(
                this.getX() - protectRadio, this.getY(), this.getZ() - protectRadio,
                this.getX() + protectRadio, this.getY() + 1.0D, this.getZ() + protectRadio
        );

        List<Mob> nearbyMobs = this.level().getEntitiesOfClass(Mob.class, searchBox);

        for (Mob mob : nearbyMobs) {
            LivingEntity target = mob.getTarget();
            if (target instanceof EntityPlantBase plant && !(plant instanceof EntityWalnut)) {
                mob.setTarget(this);
            }
        }
    }

    @Override
    protected void doPush(Entity entity) {
        if (entity instanceof Mob) {
            entity.push(this);
        }
    }

    @Override
    public boolean canBeCollidedWith() {
        return true;
    }

    public void setupAnimationStates() {
        if (this.getHealth() > this.getMaxHealth() * 2 / 3) {
            this.idleAnimation1.stop();
            this.idleAnimation2.stop();
            this.idleAnimation0.startIfStopped(this.tickCount);
        } else if (this.getHealth() > this.getMaxHealth() * 1 / 3 && this.getHealth() <= this.getMaxHealth() * 2 / 3) {
            this.idleAnimation0.stop();
            this.idleAnimation2.stop();
            this.idleAnimation1.startIfStopped(this.tickCount);
        } else {
            this.idleAnimation0.stop();
            this.idleAnimation1.stop();
            this.idleAnimation2.startIfStopped(this.tickCount);
        }
    }
}