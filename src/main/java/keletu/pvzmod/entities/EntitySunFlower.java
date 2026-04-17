package keletu.pvzmod.entities;

import keletu.pvzmod.init.PVZItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class EntitySunFlower extends EntityPlantBase {

    private static final EntityDataAccessor<Integer> GENERATE = SynchedEntityData.defineId(EntitySunFlower.class, EntityDataSerializers.INT);
    public final AnimationState idleAnimation0 = new AnimationState();
    public final AnimationState idleAnimation1 = new AnimationState();
    public final AnimationState generateSunAnimation = new AnimationState();

    public EntitySunFlower(EntityType<? extends EntityPlantBase> type, Level par1World) {
        super(type, par1World, new ItemStack(PVZItems.SUN_FLOWER_CARD.get(), 1));
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(GENERATE, 0);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return EntityPlantBase.createAttributes().add(Attributes.MAX_HEALTH, 20.0D);
    }

    @Override
    protected void registerGoals() {
        this.getNavigation().setCanFloat(false);
    }

    public int getGenerateTime() {
        return this.entityData.get(GENERATE);
    }

    public void setGenTime(int time) {
        this.entityData.set(GENERATE, time);
    }

    @Override
    public void tick() {
        super.tick();

        if (this.level().isClientSide()) {
            setupAnimationStates();
        }

        if (this.entityData.get(GENERATE) < 400) {
            this.setGenTime(this.getGenerateTime() + 1);
        }

        if (this.getGenerateTime() == 390 && !this.level().isClientSide) {
            ItemEntity item = new ItemEntity(this.level(), this.xo, this.yo + this.getEyeHeight(), this.zo, new ItemStack(PVZItems.SUN.get()), this.level().random.nextDouble() * 0.2D - 0.1D, 0.05f, this.level().random.nextDouble() * 0.2D - 0.1D);
            item.setGlowingTag(true);
            this.level().addFreshEntity(item);
        }

        if (this.getGenerateTime() >= 400) {
            this.setGenTime(0);
        }
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putInt("GenerateSun", this.entityData.get(GENERATE));
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        this.entityData.set(GENERATE, pCompound.getInt("GenerateSun"));
    }

    public void setupAnimationStates() {
        if (this.getGenerateTime() >= 360) {
            this.idleAnimation0.stop();
            this.generateSunAnimation.startIfStopped(this.tickCount);
        } else {
            this.idleAnimation0.startIfStopped(this.tickCount);
            this.generateSunAnimation.stop();
        }
    }
}
