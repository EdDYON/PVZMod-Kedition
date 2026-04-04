package keletu.pvzmod.item;

import keletu.pvzmod.entities.EntityPlantBase;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
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