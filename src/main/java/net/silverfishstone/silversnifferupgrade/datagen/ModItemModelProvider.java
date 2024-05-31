package net.silverfishstone.silversnifferupgrade.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.silverfishstone.silversnifferupgrade.SnifferUpgrade;
import net.silverfishstone.silversnifferupgrade.block.ModBlocks;
import net.silverfishstone.silversnifferupgrade.item.ModItems;

import java.util.LinkedHashMap;

public class ModItemModelProvider extends ItemModelProvider {
    private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }
    public ModItemModelProvider(PackOutput output, String modid, ExistingFileHelper existingFileHelper) {
        super(output, SnifferUpgrade.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.ANCIENT_APPLE);
        simpleItem(ModItems.BIOMIC_SLUDGE);
        simpleItem(ModItems.BIOMITE_GEM);
        simpleItem(ModItems.ROTTEN_APPLE);
        simpleItem(ModItems.BIOMITE_CRYSTAL);
        simpleItem(ModItems.BIOMIC_SLUDGE_VIAL);
        simpleItem(ModItems.BIOMITE_FRUIT);
        simpleItem(ModItems.BIOMIC_CAPSULE);
        simpleItem(ModItems.HORSETAIL_SPORES);
        simpleItem(ModItems.ROASTED_DODO_MEAT);
        simpleItem(ModItems.RAW_DODO_MEAT);
        simpleItem(ModItems.DODO_FEATHER);
        simpleItem(ModItems.MAGIGIANS_BOOK);
        simpleItem(ModItems.NAUTILUS_BUCKET);
        simpleItem(ModItems.CONESHELL_BUCKET);
        simpleItem(ModItems.ARTHROPOD_ARMOR);
        simpleItem(ModItems.SNIFFER_FUR);
        simpleItem(ModItems.BORSCH);
        simpleItem(ModItems.STRANIP);
        simpleItem(ModItems.STRANIP_LEAVES);
        simpleItem(ModItems.STRANIP_ROOT);
        simpleItem(ModItems.SNIFFER_BAG);
        simpleItem(ModItems.FLAMIPEDE_FANG);
        simpleItem(ModItems.SPICY_CLAW_SOUP);
        simpleItem(ModItems.CLAW_SOUP);


        withExistingParent(ModItems.GREATER_DODO_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.ANCIENT_ZOMBIE_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.NAUTILUS_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.CONESHELL_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.AMPHIBIMUS_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.ARMISOR_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.EURYPTERUS_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.FLAMIPEDE_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));

        handheldItem(ModItems.BIOMIC_SHOVEL);
        handheldItem(ModItems.BIOMIC_SWORD);
        handheldItem(ModItems.BIOMIC_HOE);
        handheldItem(ModItems.BIOMIC_AXE);
        handheldItem(ModItems.BIOMIC_PICKAXE);
        handheldItem(ModItems.BROKEN_TRIDENT);

        simpleItem(ModItems.GINKGO_HANGING_SIGN);
        simpleItem(ModItems.GINKGO_SIGN);
        simpleItem(ModItems.GINKGO_BOAT);
        simpleItem(ModItems.GINKGO_CHEST_BOAT);
        simpleBlockItem(ModBlocks.GINKGO_DOOR);
        fenceItem(ModBlocks.GINKGO_FENCE, ModBlocks.GINKGO_PLANKS);
        buttonItem(ModBlocks.GINKGO_BUTTON, ModBlocks.GINKGO_PLANKS);
        evenSimplerBlockItem(ModBlocks.GINKGO_STAIRS);
        evenSimplerBlockItem(ModBlocks.GINKGO_SLAB);
        evenSimplerBlockItem(ModBlocks.GINKGO_PRESSURE_PLATE);
        evenSimplerBlockItem(ModBlocks.GINKGO_FENCE_GATE);
        trapdoorItem(ModBlocks.GINKGO_TRAPDOOR);

        simpleItem(ModItems.SPIKETIP_HANGING_SIGN);
        simpleItem(ModItems.SPIKETIP_SIGN);
        simpleItem(ModItems.SPIKETIP_BOAT);
        simpleItem(ModItems.SPIKETIP_CHEST_BOAT);
        simpleBlockItem(ModBlocks.SPIKETIP_DOOR);
        fenceItem(ModBlocks.SPIKETIP_FENCE, ModBlocks.SPIKETIP_PLANKS);
        buttonItem(ModBlocks.SPIKETIP_BUTTON, ModBlocks.SPIKETIP_PLANKS);
        evenSimplerBlockItem(ModBlocks.SPIKETIP_STAIRS);
        evenSimplerBlockItem(ModBlocks.SPIKETIP_SLAB);
        evenSimplerBlockItem(ModBlocks.SPIKETIP_PRESSURE_PLATE);
        evenSimplerBlockItem(ModBlocks.SPIKETIP_FENCE_GATE);
        trapdoorItem(ModBlocks.SPIKETIP_TRAPDOOR);

        simpleItem(ModItems.TREE_FERN_HANGING_SIGN);
        simpleItem(ModItems.TREE_FERN_SIGN);
        simpleItem(ModItems.TREE_FERN_BOAT);
        simpleItem(ModItems.TREE_FERN_CHEST_BOAT);
        simpleBlockItem(ModBlocks.TREE_FERN_DOOR);
        fenceItem(ModBlocks.TREE_FERN_FENCE, ModBlocks.TREE_FERN_PLANKS);
        buttonItem(ModBlocks.TREE_FERN_BUTTON, ModBlocks.TREE_FERN_PLANKS);
        evenSimplerBlockItem(ModBlocks.TREE_FERN_STAIRS);
        evenSimplerBlockItem(ModBlocks.TREE_FERN_SLAB);
        evenSimplerBlockItem(ModBlocks.TREE_FERN_PRESSURE_PLATE);
        evenSimplerBlockItem(ModBlocks.TREE_FERN_FENCE_GATE);
        trapdoorItem(ModBlocks.TREE_FERN_TRAPDOOR);



        evenSimplerBlockItem(ModBlocks.BOULDERSTONE_STAIRS);
        evenSimplerBlockItem(ModBlocks.BOULDERSTONE_SLAB);
        wallItem(ModBlocks.BOULDERSTONE_WALL, ModBlocks.BOULDERSTONE);
        evenSimplerBlockItem(ModBlocks.POLISHED_POWDERSTONE_STAIRS);
        evenSimplerBlockItem(ModBlocks.POLISHED_POWDERSTONE_SLAB);
        wallItem(ModBlocks.POLISHED_POWDERSTONE_WALL, ModBlocks.POLISHED_POWDERSTONE);
        evenSimplerBlockItem(ModBlocks.BOULDERSTONE_BRICK_STAIRS);
        evenSimplerBlockItem(ModBlocks.BOULDERSTONE_BRICK_SLAB);
        wallItem(ModBlocks.BOULDERSTONE_BRICK_WALL, ModBlocks.BOULDERSTONE_BRICKS);

        evenSimplerBlockItem(ModBlocks.CHLORITE_STAIRS);
        evenSimplerBlockItem(ModBlocks.CHLORITE_SLAB);
        wallItem(ModBlocks.CHLORITE_WALL, ModBlocks.CHLORITE);
        evenSimplerBlockItem(ModBlocks.POLISHED_CHLORITE_STAIRS);
        evenSimplerBlockItem(ModBlocks.POLISHED_CHLORITE_SLAB);
        wallItem(ModBlocks.POLISHED_CHLORITE_WALL, ModBlocks.POLISHED_CHLORITE);
        evenSimplerBlockItem(ModBlocks.POLISHED_CHLORITE_BRICK_STAIRS);
        evenSimplerBlockItem(ModBlocks.POLISHED_CHLORITE_BRICK_SLAB);
        wallItem(ModBlocks.POLISHED_CHLORITE_BRICK_WALL, ModBlocks.POLISHED_CHLORITE_BRICKS);

        evenSimplerBlockItem(ModBlocks.PETRIFIED_WOOD);

        saplingItem(ModBlocks.GINKGO_SAPLING);
        saplingItem(ModBlocks.SPIKETIP_SAPLING);
        saplingItem(ModBlocks.TREE_FERN_SAPLING);

        trimmedArmorItem(ModItems.CHITIN_BOOTS);
        trimmedArmorItem(ModItems.CHITIN_CHESTPLATE);
        trimmedArmorItem(ModItems.CHITIN_HELMET);
        trimmedArmorItem(ModItems.CHITIN_LEGGINGS);
        trimmedArmorItem(ModItems.CHITIN_SEGMENT);
    }
    private void trimmedArmorItem(RegistryObject<Item> itemRegistryObject) {
        final String MOD_ID = SnifferUpgrade.MODID; // Change this to your mod id

        if(itemRegistryObject.get() instanceof ArmorItem armorItem) {
            trimMaterials.entrySet().forEach(entry -> {

                ResourceKey<TrimMaterial> trimMaterial = entry.getKey();
                float trimValue = entry.getValue();

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = "item/" + armorItem;
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = new ResourceLocation(MOD_ID, armorItemPath);
                ResourceLocation trimResLoc = new ResourceLocation(trimPath); // minecraft namespace
                ResourceLocation trimNameResLoc = new ResourceLocation(MOD_ID, currentTrimName);

                // This is used for making the ExistingFileHelper acknowledge that this texture exist, so this will
                // avoid an IllegalArgumentException
                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                // Trimmed armorItem files
                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc)
                        .texture("layer1", trimResLoc);

                // Non-trimmed armorItem file (normal variant)
                this.withExistingParent(itemRegistryObject.getId().getPath(),
                                mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0",
                                new ResourceLocation(MOD_ID,
                                        "item/" + itemRegistryObject.getId().getPath()));
            });
        }
    }

    private ItemModelBuilder saplingItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(SnifferUpgrade.MODID,"block/" + item.getId().getPath()));
    }
    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(SnifferUpgrade.MODID,"item/" + item.getId().getPath()));
    }

    public void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(SnifferUpgrade.MODID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    public void trapdoorItem(RegistryObject<Block> block) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  new ResourceLocation(SnifferUpgrade.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  new ResourceLocation(SnifferUpgrade.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  new ResourceLocation(SnifferUpgrade.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }
    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(SnifferUpgrade.MODID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(SnifferUpgrade.MODID, "item/" + item.getId().getPath()));
    }
}
