package keletu.pvzmod.init;

import keletu.pvzmod.PVZMod;
import keletu.pvzmod.blocks.Pot;
import keletu.pvzmod.blocks.PotBlockEntity;
import keletu.pvzmod.models.PotBlockModel;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class PVZBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, PVZMod.MODID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, PVZMod.MODID);
    public static final RegistryObject<Block> POT = BLOCKS.register("pot", () -> new Pot(BlockBehaviour.Properties.of()
            .mapColor(MapColor.TERRACOTTA_BROWN)
            .strength(0.5F)
            .sound(SoundType.DECORATED_POT)
            .noOcclusion()
    ));

    public static final RegistryObject<BlockEntityType<PotBlockEntity>> POT_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("pot_entity",
                    () -> BlockEntityType.Builder.of(
                            PotBlockEntity::new,
                            PVZBlocks.POT.get()
                    ).build(null));


    @OnlyIn(Dist.CLIENT)
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(POT_BLOCK_ENTITY.get(), ((BlockEntityRendererProvider.Context context) -> new GeoBlockRenderer<>(new PotBlockModel())));
    }
}
