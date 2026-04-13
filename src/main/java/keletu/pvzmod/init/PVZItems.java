package keletu.pvzmod.init;

import keletu.pvzmod.PVZMod;
import keletu.pvzmod.items.ItemGardenShovel;
import keletu.pvzmod.items.ItemPlantCard;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class PVZItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, PVZMod.MODID);
    public static final RegistryObject<Item> POT = ITEMS.register("pot",
            () -> new BlockItem(PVZBlocks.POT.get(), new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> PEA = ITEMS.register("pea", () -> new Item(new Item.Properties()
            .food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.25F)
                    .fast()
                    .build())
            .stacksTo(64)));
    public static final RegistryObject<Item> ICE_PEA = ITEMS.register("ice_pea", () -> new Item(new Item.Properties()
            .food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.25F)
                    .fast()
                    .effect(() -> new MobEffectInstance(PVZEffects.SNOW.get(), 100, 0), 1.0F)
                    .build())
            .stacksTo(64)));

    public static final RegistryObject<Item> PRIMAL_PEA = ITEMS.register("primal_pea", () -> new Item(new Item.Properties()
            .food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(1.0F)
                    .build())
            .stacksTo(16)));

    public static final RegistryObject<Item> ELECTRIC_PEA = ITEMS.register("electric_pea", () -> new Item(new Item.Properties()
            .food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.25F)
                    .effect(() -> new MobEffectInstance(PVZEffects.STUN.get(), 60, 0), 1.0F)
                    .build())
            .stacksTo(16)));
    public static final RegistryObject<Item> SPORE = ITEMS.register("spore", () -> new Item(new Item.Properties()
            .stacksTo(64)));
    public static final RegistryObject<Item> SMALL_STONE = ITEMS.register("small_stone", () -> new Item(new Item.Properties()
            .stacksTo(64)));

    public static final RegistryObject<Item> PEASHOOTER_CARD = ITEMS.register("peashooter_card",
            () -> new ItemPlantCard(new Item.Properties(), PVZEntities.PEA_SHOOTER));
    public static final RegistryObject<Item> SNOWPEA_CARD = ITEMS.register("snowpea_card",
            () -> new ItemPlantCard(new Item.Properties(), PVZEntities.SNOW_PEA));
    public static final RegistryObject<Item> REPEATER_CARD = ITEMS.register("repeater_card",
            () -> new ItemPlantCard(new Item.Properties(), PVZEntities.REPEATER));
    public static final RegistryObject<Item> GATLING_PEA_CARD = ITEMS.register("gatling_pea_card",
            () -> new ItemPlantCard(new Item.Properties(), PVZEntities.GATLING_PEA));
    public static final RegistryObject<Item> PRIMAL_PEASHOOTER_CARD = ITEMS.register("primal_peashooter_card",
            () -> new ItemPlantCard(new Item.Properties(), PVZEntities.PRIMAL_PEASHOOTER));
    public static final RegistryObject<Item> WALNUT_CARD = ITEMS.register("walnut_card",
            () -> new ItemPlantCard(new Item.Properties(), PVZEntities.WALNUT));
    public static final RegistryObject<Item> TALL_NUT_CARD = ITEMS.register("tall_nut_card",
            () -> new ItemPlantCard(new Item.Properties(), PVZEntities.TALL_NUT));
    public static final RegistryObject<Item> SUPER_GATLING_PEA_CARD = ITEMS.register("super_gatling_pea_card",
            () -> new ItemPlantCard(new Item.Properties(), PVZEntities.SUPER_GATLING_PEA));
    public static final RegistryObject<Item> POTATO_MINE_CARD = ITEMS.register("potato_mine_card",
            () -> new ItemPlantCard(new Item.Properties(), PVZEntities.POTATO_MINE));
    public static final RegistryObject<Item> PUFF_SHROOM_CARD = ITEMS.register("puff_shroom_card",
            () -> new ItemPlantCard(new Item.Properties(), PVZEntities.PUFF_SHROOM));
    public static final RegistryObject<Item> FUME_SHROOM_CARD = ITEMS.register("fume_shroom_card",
            () -> new ItemPlantCard(new Item.Properties(), PVZEntities.FUME_SHROOM));
    public static final RegistryObject<Item> ELECTRIC_PEASHOOTER_CARD = ITEMS.register("electric_peashooter_card",
            () -> new ItemPlantCard(new Item.Properties(), PVZEntities.ELECTRIC_PEASHOOTER));
    public static final RegistryObject<Item> GARDEN_SHOVEL = ITEMS.register("garden_shovel", () -> new ItemGardenShovel(new Item.Properties()
            .durability(999)));
}
