package keletu.pvzmod.entities;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Ghast;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class EntityPlantBase extends AbstractGolem {
    private String texture;
    private String livingSound;
    private String hurtSound;
    private String deathSound;
    public int baseHealth;
    public ItemStack spawnStack;
    public float range = 10.0F;

    public EntityPlantBase(EntityType<? extends EntityPlantBase> entityType, Level level) {
        super(entityType, level);
    }

    public EntityPlantBase(EntityType<? extends EntityPlantBase> entityType, Level level, ItemStack spawnStack) {
        this(entityType, level);
        this.spawnStack = spawnStack;
    }

    @Override
    public float maxUpStep() {
        return 0.0F;
    }

    /*@Override
    protected void registerGoals() {
        this.getNavigation().setCanFloat(false); // setAvoidsWater
        this.goalSelector.addGoal(1, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(2, new RandomLookAroundGoal(this));
    }*/

    public static AttributeSupplier.Builder createAttributes() {
        return AbstractGolem.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.0D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1.0D)
                .add(Attributes.FOLLOW_RANGE, 32.0D);
    }

    @Override
    protected void playStepSound(net.minecraft.core.BlockPos pos, net.minecraft.world.level.block.state.BlockState state) {
    }

    public void setTexture(String texture) {
        this.texture = texture;
    }

    public String getTexture() {
        return this.texture;
    }

    @Override
    public MobType getMobType() {
        return /*PvZ.PLANT_TYPE*/ MobType.UNDEFINED;
    }

    @Override
    public boolean canBreatheUnderwater() {
        return true;
    }

    @Override
    public void tick() {
        this.zza = 0.0F;
        this.xxa = 0.0F;
        this.setSpeed(0.0F);

        super.tick();
    }

    @Override
    public void knockback(double strength, double x, double z) {
    }

    @Override
    protected void doPush(net.minecraft.world.entity.Entity entity) {
    }

    @Override
    public boolean isPushable() {
        return false;
    }

    @Override
    public boolean canAttack(net.minecraft.world.entity.LivingEntity target) {
        return !(target instanceof Creeper) && !(target instanceof Ghast);
    }

    @Override
    public boolean isNoAi(){
        return false;
    }
}