package keletu.pvzmod.item;

import keletu.pvzmod.entities.EntityPlantBase;
import keletu.pvzmod.entities.EntityPlantShooterBase;
import keletu.pvzmod.entities.EntitySnowPea;
import keletu.pvzmod.entities.EntitySuperGatlingPea;
import keletu.pvzmod.init.PVZEntities;
import keletu.pvzmod.init.PVZItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

import java.util.function.Supplier;

public class ItemPlantCard extends Item {
    private final Supplier<? extends EntityType<?>> entityTypeSupplier;

    public ItemPlantCard(Properties properties, Supplier<? extends EntityType<?>> entityTypeSupplier) {
        super(properties);
        this.entityTypeSupplier = entityTypeSupplier;
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity entity, InteractionHand hand) {
        if (entity instanceof EntitySuperGatlingPea target && target.getType() == PVZEntities.SUPER_GATLING_PEA.get()) {
            if (entity.level().isClientSide) {
                return InteractionResult.SUCCESS;
            } else {
                if (this != PVZItems.SNOWPEA_CARD.get() && this != PVZItems.PRIMAL_PEASHOOTER_CARD.get()) {
                    return InteractionResult.FAIL;
                }

                BlockPos pos = BlockPos.containing(entity.position());
                if (target.getOwnerUUID() == null || target.getOwnerUUID().equals(player.getUUID())) {
                    target.remove(Entity.RemovalReason.DISCARDED);
                    player.level().playSound(null, pos, SoundEvents.GRASS_PLACE, SoundSource.PLAYERS);
                    ((ServerLevel) player.level()).sendParticles(new BlockParticleOption(ParticleTypes.BLOCK, Blocks.DIRT.defaultBlockState()),
                            pos.getX() + 0.5,
                            pos.getY(),
                            pos.getZ() + 0.5,
                            20,
                            0.25D,
                            0.25D,
                            0.25D,
                            0.15D);


                    EntityPlantShooterBase newOne = entityTypeSupplier.get().create(player.level()) instanceof EntitySnowPea ? PVZEntities.SUPER_SNOW_GATLING_PEA.get().create(player.level()) : PVZEntities.SUPER_PRIMAL_GATLING_PEA.get().create(player.level());

                    if (newOne == null)
                        return InteractionResult.FAIL;

                    double spawnX = target.getX();
                    double spawnY = target.getY();
                    double spawnZ = target.getZ();
                    float yaw = (float) (Math.atan2(player.getZ() - spawnZ, player.getX() - spawnX) * (180F / Math.PI)) - 90.0F;

                    newOne.moveTo(spawnX, spawnY, spawnZ, yaw, 0.0F);
                    newOne.setYRot(yaw);
                    newOne.setYBodyRot(yaw);
                    newOne.setYHeadRot(yaw);

                    player.level().addFreshEntity(newOne);

                    newOne.setOwnerUUID(player.getUUID());

                    if (!player.isCreative()) {
                        stack.shrink(1);
                    }
                }
                return InteractionResult.SUCCESS;
            }
        } else {
            return InteractionResult.PASS;
        }
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos clickedPos = context.getClickedPos();
        Player player = context.getPlayer();
        ItemStack itemStack = context.getItemInHand();

        if (player == null) {
            return InteractionResult.FAIL;
        }

        if (!player.mayUseItemAt(clickedPos, context.getClickedFace(), itemStack)) {
            return InteractionResult.FAIL;
        }

        BlockState clickedState = level.getBlockState(clickedPos);
        BlockPos spawnPos = clickedPos.above((int) Math.ceil(entityTypeSupplier.get().getHeight()));

        if (!level.getBlockState(spawnPos).isAir() && !level.getBlockState(spawnPos).canBeReplaced()) {
            return InteractionResult.PASS;
        }

        //PvZBlocks.ENDOWED_GRASS
        boolean isEndowedGrass = clickedState.is(Blocks.GRASS_BLOCK);

        boolean isWaterLily = clickedState.is(Blocks.LILY_PAD);

        if (isEndowedGrass || isWaterLily) {
            AABB checkBox = new AABB(spawnPos);
            if (!level.getEntitiesOfClass(EntityPlantBase.class, checkBox).isEmpty()) {
                return InteractionResult.FAIL;
            }

            if (!level.isClientSide) {
                Entity entity = entityTypeSupplier.get().create(level);
                if (entity instanceof EntityPlantBase base) {

                    double spawnX;
                    double spawnY;
                    double spawnZ;

                    if (isEndowedGrass) {
                        spawnX = clickedPos.getX() + 0.5D;
                        spawnY = clickedPos.getY() + 1.0D;
                        spawnZ = clickedPos.getZ() + 0.5D;
                        level.setBlockAndUpdate(clickedPos, Blocks.GRASS_BLOCK.defaultBlockState());
                    } else {
                        spawnX = clickedPos.getX() + 0.5D;
                        spawnY = clickedPos.getY() + 0.5D;
                        spawnZ = clickedPos.getZ() + 0.5D;
                    }

                    float yaw = (float) (Math.atan2(player.getZ() - spawnZ, player.getX() - spawnX) * (180F / Math.PI)) - 90.0F;

                    entity.moveTo(spawnX, spawnY, spawnZ, yaw, 0.0F);
                    entity.setYRot(yaw);
                    entity.setYBodyRot(yaw);
                    entity.setYHeadRot(yaw);

                    level.addFreshEntity(entity);

                    base.setOwnerUUID(player.getUUID());

                    if (!player.isCreative()) {
                        itemStack.shrink(1);
                    }
                }
            }
            return InteractionResult.sidedSuccess(level.isClientSide);
        }

        return InteractionResult.PASS;
    }
}