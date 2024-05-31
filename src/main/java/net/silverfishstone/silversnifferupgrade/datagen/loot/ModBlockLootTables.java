package net.silverfishstone.silversnifferupgrade.datagen.loot;

import net.minecraft.advancements.critereon.EnchantmentPredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;

import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;
import net.silverfishstone.silversnifferupgrade.block.ModBlocks;
import net.silverfishstone.silversnifferupgrade.block.custom.BiomiteCropBlock;
import net.silverfishstone.silversnifferupgrade.item.ModItems;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }
    protected static final LootItemCondition.Builder HAS_SILK_TOUCH = MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1))));
    protected static final LootItemCondition.Builder HAS_NO_SILK_TOUCH = HAS_SILK_TOUCH.invert();
    protected static final LootItemCondition.Builder HAS_SHEARS = MatchTool.toolMatches(ItemPredicate.Builder.item().of(Items.SHEARS));
    private static final LootItemCondition.Builder HAS_SHEARS_OR_SILK_TOUCH = HAS_SHEARS.or(HAS_SILK_TOUCH);
    private static final LootItemCondition.Builder HAS_NO_SHEARS_OR_SILK_TOUCH = HAS_SHEARS_OR_SILK_TOUCH.invert();

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.BOULDERSTONE.get());
        this.dropSelf(ModBlocks.BOULDERSTONE_BRICKS.get());
        this.dropSelf(ModBlocks.POWDERSTONE.get());
        this.dropSelf(ModBlocks.GREATER_DODO_EGG.get());
        this.dropSelf(ModBlocks.BIOMITE_BLOCK.get());
        this.dropSelf(ModBlocks.INCUBATION_BENCH.get());
        this.dropSelf(ModBlocks.ANCIENT_SOIL.get());
        this.dropSelf(ModBlocks.MUDDY_SOIL.get());
        this.dropSelf(ModBlocks.PETRIFIED_LOG.get());
        this.dropSelf(ModBlocks.PETRIFIED_WOOD.get());
        this.dropSelf(ModBlocks.PETRIFIED_PLANKS.get());
        this.dropSelf(ModBlocks.SMOOTH_PETRIFIED_LOG.get());

        this.dropSelf(ModBlocks.POLISHED_POWDERSTONE.get());
        this.dropSelf(ModBlocks.POLISHED_POWDERSTONE_WALL.get());
        this.dropSelf(ModBlocks.POLISHED_POWDERSTONE_STAIRS.get());
        this.dropSelf(ModBlocks.BOULDERSTONE_BRICK_STAIRS.get());
        this.dropSelf(ModBlocks.BOULDERSTONE_BRICK_WALL.get());
        this.dropSelf(ModBlocks.BOULDERSTONE_BRICK_SLAB.get());
        this.dropSelf(ModBlocks.BOULDERSTONE_WALL.get());
        this.dropSelf(ModBlocks.BOULDERSTONE_STAIRS.get());
        this.dropSelf(ModBlocks.BOULDERSTONE_SLAB.get());
        this.dropSelf(ModBlocks.POLISHED_POWDERSTONE_SLAB.get());
        this.dropSelf(ModBlocks.CHISELED_BOULDERSTONE_BRICKS.get());

        this.dropSelf(ModBlocks.GINKGO_SAPLING.get());
        this.dropSelf(ModBlocks.STRIPPED_GINKGO_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_GINKGO_WOOD.get());
        this.dropSelf(ModBlocks.GINKGO_WOOD.get());
        this.dropSelf(ModBlocks.GINKGO_LOG.get());
        this.dropSelf(ModBlocks.GINKGO_PLANKS.get());
        this.dropSelf(ModBlocks.GINKGO_STAIRS.get());
        this.dropSelf(ModBlocks.GINKGO_BUTTON.get());
        this.dropSelf(ModBlocks.GINKGO_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.GINKGO_TRAPDOOR.get());
        this.dropSelf(ModBlocks.GINKGO_FENCE.get());
        this.dropSelf(ModBlocks.GINKGO_FENCE_GATE.get());
        this.add(ModBlocks.GINKGO_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.GINKGO_SLAB.get()));
        this.add(ModBlocks.GINKGO_DOOR.get(),
                block -> createDoorTable(ModBlocks.GINKGO_DOOR.get()));

        this.add(ModBlocks.GINKGO_SIGN.get(), block ->
                createSingleItemTable(ModItems.GINKGO_SIGN.get()));
        this.add(ModBlocks.GINKGO_WALL_SIGN.get(), block ->
                createSingleItemTable(ModItems.GINKGO_SIGN.get()));
        this.add(ModBlocks.GINKGO_WALL_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.GINKGO_HANGING_SIGN.get()));
        this.add(ModBlocks.GINKGO_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.GINKGO_HANGING_SIGN.get()));

        this.add(ModBlocks.GINKGO_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.GINKGO_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        this.dropSelf(ModBlocks.SPIKETIP_SAPLING.get());
        this.dropSelf(ModBlocks.STRIPPED_SPIKETIP_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_SPIKETIP_WOOD.get());
        this.dropSelf(ModBlocks.SPIKETIP_WOOD.get());
        this.dropSelf(ModBlocks.SPIKETIP_LOG.get());
        this.dropSelf(ModBlocks.SPIKETIP_PLANKS.get());
        this.dropSelf(ModBlocks.SPIKETIP_STAIRS.get());
        this.dropSelf(ModBlocks.SPIKETIP_BUTTON.get());
        this.dropSelf(ModBlocks.SPIKETIP_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.SPIKETIP_TRAPDOOR.get());
        this.dropSelf(ModBlocks.SPIKETIP_FENCE.get());
        this.dropSelf(ModBlocks.SPIKETIP_FENCE_GATE.get());
        this.add(ModBlocks.SPIKETIP_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.SPIKETIP_SLAB.get()));
        this.add(ModBlocks.SPIKETIP_DOOR.get(),
                block -> createDoorTable(ModBlocks.SPIKETIP_DOOR.get()));

        this.add(ModBlocks.SPIKETIP_SIGN.get(), block ->
                createSingleItemTable(ModItems.SPIKETIP_SIGN.get()));
        this.add(ModBlocks.SPIKETIP_WALL_SIGN.get(), block ->
                createSingleItemTable(ModItems.SPIKETIP_SIGN.get()));
        this.add(ModBlocks.SPIKETIP_WALL_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.SPIKETIP_HANGING_SIGN.get()));
        this.add(ModBlocks.SPIKETIP_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.SPIKETIP_HANGING_SIGN.get()));

        this.add(ModBlocks.SPIKETIP_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.SPIKETIP_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));


        this.dropSelf(ModBlocks.TREE_FERN_SAPLING.get());
        this.dropSelf(ModBlocks.STRIPPED_TREE_FERN_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_TREE_FERN_WOOD.get());
        this.dropSelf(ModBlocks.TREE_FERN_WOOD.get());
        this.dropSelf(ModBlocks.TREE_FERN_STEM.get());
        this.dropSelf(ModBlocks.TREE_FERN_PLANKS.get());
        this.dropSelf(ModBlocks.TREE_FERN_STAIRS.get());
        this.dropSelf(ModBlocks.TREE_FERN_BUTTON.get());
        this.dropSelf(ModBlocks.TREE_FERN_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.TREE_FERN_TRAPDOOR.get());
        this.dropSelf(ModBlocks.TREE_FERN_FENCE.get());
        this.dropSelf(ModBlocks.TREE_FERN_FENCE_GATE.get());
        this.add(ModBlocks.TREE_FERN_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.TREE_FERN_SLAB.get()));
        this.add(ModBlocks.TREE_FERN_DOOR.get(),
                block -> createDoorTable(ModBlocks.TREE_FERN_DOOR.get()));

        this.add(ModBlocks.TREE_FERN_SIGN.get(), block ->
                createSingleItemTable(ModItems.TREE_FERN_SIGN.get()));
        this.add(ModBlocks.TREE_FERN_WALL_SIGN.get(), block ->
                createSingleItemTable(ModItems.TREE_FERN_SIGN.get()));
        this.add(ModBlocks.TREE_FERN_WALL_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.TREE_FERN_HANGING_SIGN.get()));
        this.add(ModBlocks.TREE_FERN_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.TREE_FERN_HANGING_SIGN.get()));

        this.add(ModBlocks.TREE_FERN_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.TREE_FERN_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        this.dropSelf(ModBlocks.STRIPPED_GREAT_CANE_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_GREAT_CANE_WOOD.get());
        this.dropSelf(ModBlocks.GREAT_CANE_WOOD.get());
        this.dropSelf(ModBlocks.GREAT_CANE_LOG.get());
        this.add(ModBlocks.GREAT_CANE_LEAVES.get(), block ->
                createLeavesDrops(block, Blocks.BAMBOO, NORMAL_LEAVES_SAPLING_CHANCES));

        this.add(ModBlocks.ANCIENT_GRASS_BLOCK.get(), (p_249779_) -> {
            return this.createSingleItemTableWithSilkTouch(p_249779_, ModBlocks.ANCIENT_SOIL.get());
        });
        this.add(ModBlocks.MOSSY_SOIL.get(), (p_249779_) -> {
            return this.createSingleItemTableWithSilkTouch(p_249779_, ModBlocks.MUDDY_SOIL.get());
        });
        this.add(ModBlocks.GRASSY_BOULDERSTONE.get(), (p_249779_) -> {
            return this.createSingleItemTableWithSilkTouch(p_249779_, ModBlocks.BOULDERSTONE.get());
        });

        this.dropSelf(ModBlocks.HORSETAIL.get());
        this.add(ModBlocks.POTTED_HORSETAIL.get(), createPotFlowerItemTable(ModBlocks.HORSETAIL.get()));
        this.dropSelf(ModBlocks.CRATERWEED.get());
        this.add(ModBlocks.POTTED_CRATERWEED.get(), createPotFlowerItemTable(ModBlocks.CRATERWEED.get()));

        this.add(ModBlocks.BIOMITE_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.BIOMITE_ORE.get(), ModItems.BIOMITE_CRYSTAL.get()));

        LootItemCondition.Builder lootitemcondition$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.BIOMITE_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BiomiteCropBlock.AGE, 5));
        this.add(ModBlocks.BIOMITE_CROP.get(), createCropDrops(ModBlocks.BIOMITE_CROP.get(), ModItems.BIOMITE_FRUIT.get(),
                ModItems.BIOMIC_CAPSULE.get(), lootitemcondition$builder));

        LootItemCondition.Builder lootitemcondition$builder3 = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.STRANIP_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BiomiteCropBlock.AGE, 5));
        this.add(ModBlocks.STRANIP_CROP.get(), createCropDrops(ModBlocks.STRANIP_CROP.get(), ModItems.STRANIP_LEAVES.get(),
                ModItems.STRANIP_ROOT.get(), lootitemcondition$builder3));

        LootItemCondition.Builder lootitemcondition$builder2 = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.HORSETAIL_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BiomiteCropBlock.AGE, 5));
        this.add(ModBlocks.HORSETAIL_CROP.get(), createCropDrops(ModBlocks.HORSETAIL_CROP.get(), Item.byBlock(ModBlocks.HORSETAIL.get()),
                ModItems.HORSETAIL_SPORES.get(), lootitemcondition$builder2));

        this.dropSelf(ModBlocks.SNIFFER_PEDESTAL.get());
        this.dropSelf(ModBlocks.CASTLE_SPIKES.get());

        this.dropSelf(ModBlocks.CHLORITE.get());
        this.dropSelf(ModBlocks.CHLORITE_STAIRS.get());
        this.dropSelf(ModBlocks.CHLORITE_WALL.get());
        this.dropSelf(ModBlocks.POLISHED_CHLORITE_BRICK_STAIRS.get());
        this.dropSelf(ModBlocks.POLISHED_CHLORITE_BRICK_WALL.get());
        this.dropSelf(ModBlocks.POLISHED_CHLORITE_BRICKS.get());
        this.dropSelf(ModBlocks.POLISHED_CHLORITE.get());
        this.dropSelf(ModBlocks.POLISHED_CHLORITE_WALL.get());
        this.dropSelf(ModBlocks.POLISHED_CHLORITE_STAIRS.get());
        this.add(ModBlocks.CHLORITE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CHLORITE_SLAB.get()));
        this.add(ModBlocks.POLISHED_CHLORITE_BRICK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.POLISHED_CHLORITE_BRICK_SLAB.get()));
        this.add(ModBlocks.POLISHED_CHLORITE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.POLISHED_CHLORITE_SLAB.get()));

        this.add(ModBlocks.BONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.BONE_SLAB.get()));

        this.dropSelf(ModBlocks.ACACIA_PILLAR_LIGHT.get());
        this.dropSelf(ModBlocks.BAMBOO_PILLAR_LIGHT.get());
        this.dropSelf(ModBlocks.BIRCH_PILLAR_LIGHT.get());
        this.dropSelf(ModBlocks.CHERRY_PILLAR_LIGHT.get());
        this.dropSelf(ModBlocks.CRIMSON_PILLAR_LIGHT.get());
        this.dropSelf(ModBlocks.DARK_OAK_PILLAR_LIGHT.get());
        this.dropSelf(ModBlocks.GINKGO_PILLAR_LIGHT.get());
        this.dropSelf(ModBlocks.JUNGLE_PILLAR_LIGHT.get());
        this.dropSelf(ModBlocks.MANGROVE_PILLAR_LIGHT.get());
        this.dropSelf(ModBlocks.OAK_PILLAR_LIGHT.get());
        this.dropSelf(ModBlocks.SPIKETIP_PILLAR_LIGHT.get());
        this.dropSelf(ModBlocks.SPRUCE_PILLAR_LIGHT.get());
        this.dropSelf(ModBlocks.TREE_FERN_PILLAR_LIGHT.get());
        this.dropSelf(ModBlocks.WARPED_PILLAR_LIGHT.get());

        this.dropSelf(ModBlocks.SNIFFER_CARPET.get());
        this.dropSelf(ModBlocks.SNIFFER_WOOL.get());

        this.add(ModBlocks.POTTED_STRANIP_FLOWER.get(), createPotFlowerItemTable(ModBlocks.STRANIP_FLOWER.get()));
        this.add(ModBlocks.STRANIP_FLOWER.get(), (factory) -> {
            return this.createStranipDrops(ModBlocks.STRANIP_FLOWER.get());
        });

        this.dropOther(ModBlocks.ANCIENT_FARMLAND.get(), ModBlocks.ANCIENT_SOIL.get());

        this.dropSelf(ModBlocks.PUMICE.get());
        this.dropSelf(ModBlocks.LATITE.get());
        this.dropSelf(ModBlocks.LATITE_BRICKS.get());
        this.dropSelf(ModBlocks.COBBLED_LATITE.get());


    }

    protected LootTable.Builder createCopperLikeOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
    protected LootTable.Builder createStranipDrops(Block flower) {
        return createSilkTouchOrShearsDispatchTable(flower, this.applyExplosionDecay(flower, LootItem.lootTableItem(ModItems.STRANIP_ROOT.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))));
    }
}
