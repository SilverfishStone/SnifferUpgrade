package net.silverfishstone.silversnifferupgrade.item;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.*;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.silverfishstone.silversnifferupgrade.SnifferUpgrade;
import net.silverfishstone.silversnifferupgrade.block.ModBlocks;
import net.silverfishstone.silversnifferupgrade.entity.ModEntities;
import net.silverfishstone.silversnifferupgrade.entity.custom.ModBoatEntity;
import net.silverfishstone.silversnifferupgrade.item.armor.SilversArmorMaterials;
import net.silverfishstone.silversnifferupgrade.item.armor.SilversHelmetItem;
import net.silverfishstone.silversnifferupgrade.item.custom.*;

import static net.minecraft.world.item.Tiers.DIAMOND;
import static net.minecraft.world.item.Tiers.IRON;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SnifferUpgrade.MODID);

    public static final RegistryObject<Item> BIOMIC_SLUDGE = ITEMS.register("biomic_sludge",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BIOMIC_SLUDGE_VIAL = ITEMS.register("biomic_sludge_vial",
            () -> new VialItem(new Item.Properties()));
    public static final RegistryObject<Item> BIOMITE_GEM = ITEMS.register("biomite_gem",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BIOMITE_CRYSTAL = ITEMS.register("biomite_crystal",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DODO_FEATHER = ITEMS.register("dodo_feather",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MAGIGIANS_BOOK = ITEMS.register("magicians_book",
            () -> new MagiciansBook(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> HORSETAIL_SPORES = ITEMS.register("horsetail_spores",
            () -> new ItemNameBlockItem(ModBlocks.HORSETAIL_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> BIOMIC_CAPSULE = ITEMS.register("biomic_capsule",
            () -> new ItemNameBlockItem(ModBlocks.BIOMITE_CROP.get(), new Item.Properties()));

    public static final RegistryObject<Item> ANCIENT_APPLE = ITEMS.register("ancient_apple",
            () -> new Item(new Item.Properties().food(ModFoods.ANCIENT_APPLE)));
    public static final RegistryObject<Item> ROTTEN_APPLE = ITEMS.register("rotten_apple",
            () -> new Item(new Item.Properties().food(ModFoods.ROTTEN_APPLE)));
    public static final RegistryObject<Item> BIOMITE_FRUIT = ITEMS.register("biomite_fruit",
            () -> new Item(new Item.Properties().food(ModFoods.BIOMITE_FRUIT)));
    public static final RegistryObject<Item> RAW_DODO_MEAT = ITEMS.register("raw_dodo_meat",
            () -> new Item(new Item.Properties().food(ModFoods.RAW_DODO_MEAT)));
    public static final RegistryObject<Item> ROASTED_DODO_MEAT = ITEMS.register("roasted_dodo_meat",
            () -> new Item(new Item.Properties().food(ModFoods.ROASTED_DODO_MEAT)));

    public static final RegistryObject<Item> BIOMIC_PICKAXE = ITEMS.register("biomic_pickaxe",
            () -> new PickaxeItem(DIAMOND, 1, -2.8f, new Item.Properties()));
    public static final RegistryObject<Item> BIOMIC_AXE = ITEMS.register("biomic_axe",
            () -> new AxeItem(DIAMOND, 5, -3, new Item.Properties()));
    public static final RegistryObject<Item> BIOMIC_SWORD = ITEMS.register("biomic_sword",
            () -> new SwordItem(DIAMOND, 3, -2.4f, new Item.Properties()));
    public static final RegistryObject<Item> BIOMIC_SHOVEL = ITEMS.register("biomic_shovel",
            () -> new ShovelItem(DIAMOND, 1.5f, -3, new Item.Properties()));
    public static final RegistryObject<Item> BIOMIC_HOE = ITEMS.register("biomic_hoe",
            () -> new HoeItem(DIAMOND, -3, 0, new Item.Properties()));

    public static final RegistryObject<Item> GREATER_DODO_SPAWN_EGG = ITEMS.register("greater_dodo_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.GREATERDODO,0xE7F0F3, 0x98A1A3, new Item.Properties()));
    public static final RegistryObject<Item> ANCIENT_ZOMBIE_SPAWN_EGG = ITEMS.register("ancient_zombie_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.ANCIENTZOMBIE,0x4DA4A7, 0x826622, new Item.Properties()));
    public static final RegistryObject<Item> NAUTILUS_SPAWN_EGG = ITEMS.register("nautilus_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.NAUTILUS,0xF19371, 0xFFD9CB, new Item.Properties()));
    public static final RegistryObject<Item> AMPHIBIMUS_SPAWN_EGG = ITEMS.register("amphibimus_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.AMPHIBIMUS,0x103200, 0xE2EC00, new Item.Properties()));
    public static final RegistryObject<Item> CONESHELL_SPAWN_EGG = ITEMS.register("coneshell_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.CONESHELL,0xF4E097, 0x9E5F23, new Item.Properties()));
    public static final RegistryObject<Item> ARMISOR_SPAWN_EGG = ITEMS.register("armisor_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.ARMISOR,0x9DB3EA, 0x85B2E5, new Item.Properties()));
    public static final RegistryObject<Item> EURYPTERUS_SPAWN_EGG = ITEMS.register("eurypterus_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.EURYPTERUS,0x2D7EDA, 0xBE325D, new Item.Properties()));
    public static final RegistryObject<Item> FLAMIPEDE_SPAWN_EGG = ITEMS.register("flamipede_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.FLAMIPEDE,0x7D6E1C, 0xFF8D04, new Item.Properties()));

    public static final RegistryObject<Item> NAUTILUS_BUCKET = ITEMS.register("nautilus_bucket",
            () -> new ModMobBucketItem(ModEntities.NAUTILUS, Fluids.WATER,  new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> CONESHELL_BUCKET = ITEMS.register("coneshell_bucket",
            () -> new ModMobBucketItem(ModEntities.CONESHELL, Fluids.WATER,  new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> GINKGO_SIGN = ITEMS.register("ginkgo_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16),ModBlocks.GINKGO_SIGN.get(), ModBlocks.GINKGO_WALL_SIGN.get()));
    public static final RegistryObject<Item> GINKGO_HANGING_SIGN = ITEMS.register("ginkgo_hanging_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16),ModBlocks.GINKGO_HANGING_SIGN.get(), ModBlocks.GINKGO_WALL_HANGING_SIGN.get()));
    public static final RegistryObject<Item> GINKGO_BOAT = ITEMS.register("ginkgo_boat",
            () -> new ModBoatItem( false, ModBoatEntity.Type.GINKGO, new Item.Properties()));
    public static final RegistryObject<Item> GINKGO_CHEST_BOAT = ITEMS.register("ginkgo_chest_boat",
            () -> new ModBoatItem( true, ModBoatEntity.Type.GINKGO, new Item.Properties()));

    public static final RegistryObject<Item> SPIKETIP_SIGN = ITEMS.register("spiketip_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16),ModBlocks.SPIKETIP_SIGN.get(), ModBlocks.SPIKETIP_WALL_SIGN.get()));
    public static final RegistryObject<Item> SPIKETIP_HANGING_SIGN = ITEMS.register("spiketip_hanging_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16),ModBlocks.SPIKETIP_HANGING_SIGN.get(), ModBlocks.SPIKETIP_WALL_HANGING_SIGN.get()));
    public static final RegistryObject<Item> SPIKETIP_BOAT = ITEMS.register("spiketip_boat",
            () -> new ModBoatItem( false, ModBoatEntity.Type.SPIKETIP, new Item.Properties()));
    public static final RegistryObject<Item> SPIKETIP_CHEST_BOAT = ITEMS.register("spiketip_chest_boat",
            () -> new ModBoatItem( true, ModBoatEntity.Type.SPIKETIP, new Item.Properties()));

    public static final RegistryObject<Item> TREE_FERN_SIGN = ITEMS.register("tree_fern_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16),ModBlocks.TREE_FERN_SIGN.get(), ModBlocks.TREE_FERN_WALL_SIGN.get()));
    public static final RegistryObject<Item> TREE_FERN_HANGING_SIGN = ITEMS.register("tree_fern_hanging_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16),ModBlocks.TREE_FERN_HANGING_SIGN.get(), ModBlocks.TREE_FERN_WALL_HANGING_SIGN.get()));
    public static final RegistryObject<Item> TREE_FERN_BOAT = ITEMS.register("tree_fern_boat",
            () -> new ModBoatItem( false, ModBoatEntity.Type.TREE_FERN, new Item.Properties()));
    public static final RegistryObject<Item> TREE_FERN_CHEST_BOAT = ITEMS.register("tree_fern_chest_boat",
            () -> new ModBoatItem( true, ModBoatEntity.Type.TREE_FERN, new Item.Properties()));

    public static final RegistryObject<Item> TROPICAL_CRAB_CLAW = ITEMS.register("tropical_crab_claw",
            () -> new CrabClaw(IRON, 0, -2.4f, 2.5f, 2,new Item.Properties().food(ModFoods.CRAB_CLAW)));
    public static final RegistryObject<Item> ROASTED_TROPICAL_CRAB_CLAW = ITEMS.register("roasted_tropical_crab_claw",
            () -> new CrabClaw(IRON, -2, -2.4f, 0, 1,new Item.Properties().food(ModFoods.ROASTED_CRAB_CLAW)));
    public static final RegistryObject<Item> BROKEN_TRIDENT = ITEMS.register("broken_trident",
            () -> new SwordItem(DIAMOND, 2, -2.6f, new Item.Properties()));
    public static final RegistryObject<Item> ARTHROPOD_ARMOR = ITEMS.register("arthropod_armor",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CHITIN_HELMET = ITEMS.register("chitin_helmet",
            () -> new SilversHelmetItem(SilversArmorMaterials.ARTHROPOD, ArmorItem.Type.HELMET,new Item.Properties()));
    public static final RegistryObject<Item> CHITIN_CHESTPLATE = ITEMS.register("chitin_chestplate",
            () -> new ArmorItem(SilversArmorMaterials.ARTHROPOD, ArmorItem.Type.CHESTPLATE,new Item.Properties()));
    public static final RegistryObject<Item> CHITIN_LEGGINGS = ITEMS.register("chitin_leggings",
            () -> new ArmorItem(SilversArmorMaterials.ARTHROPOD, ArmorItem.Type.LEGGINGS,new Item.Properties()));
    public static final RegistryObject<Item> CHITIN_BOOTS = ITEMS.register("chitin_boots",
            () -> new ArmorItem(SilversArmorMaterials.ARTHROPOD, ArmorItem.Type.BOOTS,new Item.Properties()));
    public static final RegistryObject<Item> SNIFFER_FUR = ITEMS.register("sniffer_fur",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CHITIN_SEGMENT = ITEMS.register("chitin_segment",
            () -> new SilversHelmetItem(SilversArmorMaterials.SEGMENT, ArmorItem.Type.HELMET,new Item.Properties()));

    public static final RegistryObject<Item> STRANIP_ROOT = ITEMS.register("stranip_root",
            () -> new StranipRoot(ModBlocks.STRANIP_CROP.get(),new Item.Properties().food(ModFoods.STRANIP_ROOT)));
    public static final RegistryObject<Item> STRANIP_LEAVES = ITEMS.register("stranip_leaves",
            () -> new Item(new Item.Properties().food(ModFoods.STRANIP)));
    public static final RegistryObject<Item> STRANIP = ITEMS.register("stranip",
            () -> new Item(new Item.Properties().food(ModFoods.STRANIP)));
    public static final RegistryObject<Item> BORSCH = ITEMS.register("borsch",
            () -> new Item(new Item.Properties().food(ModFoods.BORSCH).stacksTo(16)));

    public static final RegistryObject<Item> SNIFFER_BAG = ITEMS.register("sniffer_bag",
            () -> new SnifferBagItem(new Item.Properties()));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
