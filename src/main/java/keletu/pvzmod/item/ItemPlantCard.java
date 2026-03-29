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

        if (player != null && !player.mayUseItemAt(clickedPos, context.getClickedFace(), itemStack)) {
            return InteractionResult.FAIL;
        }

        BlockState clickedState = level.getBlockState(clickedPos);
        BlockPos spawnPos = clickedPos.above();

        if (!level.getBlockState(spawnPos).isAir() && !level.getBlockState(spawnPos).canBeReplaced()) {
            return InteractionResult.PASS;
        }

        //PvZBlocks.ENDOWED_GRASS
        boolean isEndowedGrass = clickedState.is(Blocks.GRASS_BLOCK);

        boolean isWaterLily = clickedState.is(Blocks.LILY_PAD);

        if (isEndowedGrass || isWaterLily) {
            if (!level.isClientSide) {
                Entity entity = entityTypeSupplier.get().create(level);
                if (entity instanceof EntityPlantBase base) {

                    if (isEndowedGrass) {
                        entity.moveTo(clickedPos.getX() + 0.5D, clickedPos.getY() + 1.0D, clickedPos.getZ() + 0.5D, 0.0F, 0.0F);
                        level.setBlockAndUpdate(clickedPos, Blocks.GRASS_BLOCK.defaultBlockState());
                    } else {
                        entity.moveTo(clickedPos.getX() + 0.5D, clickedPos.getY(), clickedPos.getZ() + 0.5D, 0.0F, 0.0F);
                    }

                    level.addFreshEntity(entity);

                    if (player != null) {
                        base.setOwnerUUID(player.getUUID());

                        if (!player.isCreative())
                            itemStack.shrink(1);
                    }
                }
            }
            return InteractionResult.sidedSuccess(level.isClientSide);
        }

        return InteractionResult.PASS;
    }
}
