package net.silverfishstone.silversnifferupgrade.datagen;

import com.ibm.icu.impl.USerializedSet;
import mezz.jei.api.recipe.vanilla.IJeiAnvilRecipe;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.brewing.BrewingRecipe;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.silverfishstone.silversnifferupgrade.SnifferUpgrade;
import net.silverfishstone.silversnifferupgrade.block.ModBlocks;
import net.silverfishstone.silversnifferupgrade.item.ModItems;
import net.silverfishstone.silversnifferupgrade.util.ModTags;
import org.lwjgl.system.macosx.MacOSXLibraryDL;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> BIOMITE_SMELTABLES = List.of(ModBlocks.BIOMITE_ORE.get(), ModItems.BIOMIC_SLUDGE.get(), ModItems.BIOMIC_SLUDGE_VIAL.get());


    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }


    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreBlasting(pWriter, BIOMITE_SMELTABLES, RecipeCategory.MISC, ModItems.BIOMITE_CRYSTAL.get(), 0.25f, 100, "biomite_crystal");
        oreSmelting(pWriter, BIOMITE_SMELTABLES, RecipeCategory.MISC, ModItems.BIOMITE_CRYSTAL.get(), 0.25f, 200, "biomite_crystal");

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BIOMITE_BLOCK.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.BIOMITE_CRYSTAL.get())
                .unlockedBy(getHasName(ModItems.BIOMITE_CRYSTAL.get()),has(ModItems.BIOMITE_CRYSTAL.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BIOMITE_GEM.get())
                .pattern(" B ")
                .pattern("BDB")
                .pattern(" B ")
                .define('B', ModItems.BIOMITE_CRYSTAL.get())
                .define('D', Items.DIAMOND)
                .unlockedBy(getHasName(ModItems.BIOMITE_CRYSTAL.get()),has(ModItems.BIOMITE_CRYSTAL.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BIOMITE_CRYSTAL.get(), 9)
                .requires(ModBlocks.BIOMITE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.BIOMITE_BLOCK.get()), has(ModBlocks.BIOMITE_BLOCK.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BIOMIC_SLUDGE.get(), 2)
                .requires(ModItems.BIOMITE_FRUIT.get())
                .unlockedBy(getHasName(ModItems.BIOMITE_FRUIT.get()), has(ModItems.BIOMITE_FRUIT.get()))
                .save(pWriter);


        ShapelessRecipeBuilder.shapeless(RecipeCategory.BREWING, ModItems.BIOMIC_SLUDGE_VIAL.get(), 1)
                .requires(ModItems.BIOMIC_SLUDGE.get())
                .requires(Items.GLASS_BOTTLE)
                .unlockedBy(getHasName(ModItems.BIOMIC_SLUDGE.get()), has(ModItems.BIOMIC_SLUDGE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.BIOMIC_SWORD.get())
                .pattern("B")
                .pattern("B")
                .pattern("S")
                .define('B', ModItems.BIOMITE_GEM.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.BIOMITE_GEM.get()),has(ModItems.BIOMITE_GEM.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.BIOMIC_AXE.get())
                .pattern("BB")
                .pattern("SB")
                .pattern("S ")
                .define('B', ModItems.BIOMITE_GEM.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.BIOMITE_GEM.get()),has(ModItems.BIOMITE_GEM.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.BIOMIC_PICKAXE.get())
                .pattern("BBB")
                .pattern(" S ")
                .pattern(" S ")
                .define('B', ModItems.BIOMITE_GEM.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.BIOMITE_GEM.get()),has(ModItems.BIOMITE_GEM.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.BIOMIC_HOE.get())
                .pattern("BB")
                .pattern("S ")
                .pattern("S ")
                .define('B', ModItems.BIOMITE_GEM.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.BIOMITE_GEM.get()),has(ModItems.BIOMITE_GEM.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.BIOMIC_SHOVEL.get())
                .pattern("B")
                .pattern("S")
                .pattern("S")
                .define('B', ModItems.BIOMITE_GEM.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.BIOMITE_GEM.get()),has(ModItems.BIOMITE_GEM.get()))
                .save(pWriter);

        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BOULDERSTONE_BRICKS.get(), ModBlocks.BOULDERSTONE.get());
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_BOULDERSTONE_BRICKS.get(), ModBlocks.BOULDERSTONE.get());
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_BOULDERSTONE_BRICKS.get(), ModBlocks.BOULDERSTONE_BRICKS.get());
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BOULDERSTONE_STAIRS.get(), ModBlocks.BOULDERSTONE.get());
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BOULDERSTONE_SLAB.get(), ModBlocks.BOULDERSTONE.get());
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BOULDERSTONE_WALL.get(), ModBlocks.BOULDERSTONE.get());
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BOULDERSTONE_BRICK_STAIRS.get(), ModBlocks.BOULDERSTONE.get());
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BOULDERSTONE_BRICK_SLAB.get(), ModBlocks.BOULDERSTONE.get());
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BOULDERSTONE_BRICK_WALL.get(), ModBlocks.BOULDERSTONE.get());
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BOULDERSTONE_BRICK_STAIRS.get(), ModBlocks.BOULDERSTONE_BRICKS.get());
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BOULDERSTONE_BRICK_SLAB.get(), ModBlocks.BOULDERSTONE_BRICKS.get());
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BOULDERSTONE_BRICK_WALL.get(), ModBlocks.BOULDERSTONE_BRICKS.get());

        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_POWDERSTONE.get(), ModBlocks.POWDERSTONE.get());
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_POWDERSTONE_STAIRS.get(), ModBlocks.POWDERSTONE.get());
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_POWDERSTONE_WALL.get(), ModBlocks.POWDERSTONE.get());
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_POWDERSTONE_SLAB.get(), ModBlocks.POWDERSTONE.get());
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_POWDERSTONE_STAIRS.get(), ModBlocks.POLISHED_POWDERSTONE.get());
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_POWDERSTONE_WALL.get(), ModBlocks.POLISHED_POWDERSTONE.get());
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_POWDERSTONE_SLAB.get(), ModBlocks.POLISHED_POWDERSTONE.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BOULDERSTONE_BRICKS.get(), 4)
                .define('#', ModBlocks.BOULDERSTONE.get())
                .pattern("##")
                .pattern("##")
                .unlockedBy("has_boulderstone", has(ModBlocks.BOULDERSTONE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_POWDERSTONE.get(), 4)
                .define('#', ModBlocks.POWDERSTONE.get())
                .pattern("##")
                .pattern("##")
                .unlockedBy("has_powderstone", has(ModBlocks.POWDERSTONE.get()))
                .save(pWriter);

        slabBuilder(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BOULDERSTONE_SLAB.get(), Ingredient.of(ModBlocks.BOULDERSTONE.get()))
                .unlockedBy("has_boulderstone", has(ModBlocks.BOULDERSTONE.get()))
                .save(pWriter);
        stairBuilder(ModBlocks.BOULDERSTONE_STAIRS.get(), Ingredient.of(ModBlocks.BOULDERSTONE.get()))
                .unlockedBy("has_boulderstone", has(ModBlocks.BOULDERSTONE.get()))
                .save(pWriter);
        wall(pWriter, RecipeCategory.DECORATIONS, ModBlocks.BOULDERSTONE_WALL.get(), ModBlocks.BOULDERSTONE.get());
        slabBuilder(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BOULDERSTONE_BRICK_SLAB.get(), Ingredient.of(ModBlocks.BOULDERSTONE_BRICKS.get()))
                .unlockedBy("has_boulderstone_bricks", has(ModBlocks.BOULDERSTONE_BRICKS.get()))
                .save(pWriter);
        stairBuilder(ModBlocks.BOULDERSTONE_BRICK_STAIRS.get(), Ingredient.of(ModBlocks.BOULDERSTONE_BRICKS.get()))
                .unlockedBy("has_boulderstone_bricks", has(ModBlocks.BOULDERSTONE_BRICKS.get()))
                .save(pWriter);
        wall(pWriter, RecipeCategory.DECORATIONS, ModBlocks.BOULDERSTONE_BRICK_WALL.get(), ModBlocks.BOULDERSTONE_BRICKS.get());
        slabBuilder(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_POWDERSTONE_SLAB.get(), Ingredient.of(ModBlocks.POLISHED_POWDERSTONE.get()))
                .unlockedBy("has_polished_powderstone", has(ModBlocks.POLISHED_POWDERSTONE.get()))
                .save(pWriter);
        stairBuilder(ModBlocks.POLISHED_POWDERSTONE_STAIRS.get(), Ingredient.of(ModBlocks.POLISHED_POWDERSTONE.get()))
                .unlockedBy("has_polished_powderstone", has(ModBlocks.POLISHED_POWDERSTONE.get()))
                .save(pWriter);
        wall(pWriter, RecipeCategory.DECORATIONS, ModBlocks.POLISHED_POWDERSTONE_WALL.get(), ModBlocks.POLISHED_POWDERSTONE.get());
        chiseledBuilder(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_BOULDERSTONE_BRICKS.get(),
                Ingredient.of(ModBlocks.BOULDERSTONE_BRICK_SLAB.get()))
                .unlockedBy( getHasName(ModBlocks.BOULDERSTONE_BRICKS.get()), has(ModBlocks.BOULDERSTONE_BRICKS.get()))
                .save(pWriter);



        woodFromLogs(pWriter, ModBlocks.GINKGO_WOOD.get(), ModBlocks.GINKGO_LOG.get());
        woodFromLogs(pWriter, ModBlocks.STRIPPED_GINKGO_WOOD.get(), ModBlocks.STRIPPED_GINKGO_LOG.get());
        woodFromLogs(pWriter, ModBlocks.PETRIFIED_WOOD.get(), ModBlocks.PETRIFIED_LOG.get());
        planksFromLog(pWriter, ModBlocks.GINKGO_PLANKS.get(), ModTags.Items.GINKGO_LOGS, 4);
        woodenBoat(pWriter, ModItems.GINKGO_BOAT.get(), ModBlocks.GINKGO_PLANKS.get());
        chestBoat(pWriter, ModItems.GINKGO_CHEST_BOAT.get(), ModItems.GINKGO_BOAT.get());
        hangingSign(pWriter, ModItems.GINKGO_HANGING_SIGN.get(), ModBlocks.STRIPPED_GINKGO_LOG.get());
        signBuilder(ModItems.GINKGO_SIGN.get(),
                Ingredient.of(ModBlocks.GINKGO_PLANKS.get()))
                .unlockedBy("has_ginkgo", has(ModBlocks.GINKGO_PLANKS.get()))
                .save(pWriter);
        fenceBuilder(ModBlocks.GINKGO_FENCE.get(),
                Ingredient.of(ModBlocks.GINKGO_PLANKS.get()))
                .unlockedBy("has_ginkgo", has(ModBlocks.GINKGO_PLANKS.get()))
                .save(pWriter);
        fenceGateBuilder(ModBlocks.GINKGO_FENCE_GATE.get(),
                Ingredient.of(ModBlocks.GINKGO_PLANKS.get()))
                .unlockedBy("has_ginkgo", has(ModBlocks.GINKGO_PLANKS.get()))
                .save(pWriter);
        doorBuilder(ModBlocks.GINKGO_DOOR.get(),
                Ingredient.of(ModBlocks.GINKGO_PLANKS.get()))
                .unlockedBy("has_ginkgo", has(ModBlocks.GINKGO_PLANKS.get()))
                .save(pWriter);
        trapdoorBuilder(ModBlocks.GINKGO_TRAPDOOR.get(),
                Ingredient.of(ModBlocks.GINKGO_PLANKS.get()))
                .unlockedBy("has_ginkgo", has(ModBlocks.GINKGO_PLANKS.get()))
                .save(pWriter);
        slabBuilder(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GINKGO_SLAB.get(),
                Ingredient.of(ModBlocks.GINKGO_PLANKS.get()))
                .unlockedBy("has_ginkgo", has(ModBlocks.GINKGO_PLANKS.get()))
                .save(pWriter);
        stairBuilder(ModBlocks.GINKGO_STAIRS.get(),
                Ingredient.of(ModBlocks.GINKGO_PLANKS.get()))
                .unlockedBy("has_ginkgo", has(ModBlocks.GINKGO_PLANKS.get()))
                .save(pWriter);
        buttonBuilder(ModBlocks.GINKGO_BUTTON.get(),
                Ingredient.of(ModBlocks.GINKGO_PLANKS.get()))
                .unlockedBy("has_ginkgo", has(ModBlocks.GINKGO_PLANKS.get()))
                .save(pWriter);
        pressurePlate(pWriter, ModBlocks.GINKGO_PRESSURE_PLATE.get(),ModBlocks.GINKGO_PLANKS.get().asItem());



        woodFromLogs(pWriter, ModBlocks.SPIKETIP_WOOD.get(), ModBlocks.SPIKETIP_LOG.get());
        woodFromLogs(pWriter, ModBlocks.STRIPPED_SPIKETIP_WOOD.get(), ModBlocks.STRIPPED_SPIKETIP_LOG.get());
        planksFromLog(pWriter, ModBlocks.SPIKETIP_PLANKS.get(), ModTags.Items.SPIKETIP_LOGS, 4);
        woodenBoat(pWriter, ModItems.SPIKETIP_BOAT.get(), ModBlocks.SPIKETIP_PLANKS.get());
        chestBoat(pWriter, ModItems.SPIKETIP_CHEST_BOAT.get(), ModItems.SPIKETIP_BOAT.get());
        hangingSign(pWriter, ModItems.SPIKETIP_HANGING_SIGN.get(), ModBlocks.STRIPPED_SPIKETIP_LOG.get());
        signBuilder(ModItems.SPIKETIP_SIGN.get(),
                Ingredient.of(ModBlocks.SPIKETIP_PLANKS.get()))
                .unlockedBy("has_ginkgo", has(ModBlocks.SPIKETIP_PLANKS.get()))
                .save(pWriter);
        fenceBuilder(ModBlocks.SPIKETIP_FENCE.get(),
                Ingredient.of(ModBlocks.SPIKETIP_PLANKS.get()))
                .unlockedBy("has_ginkgo", has(ModBlocks.SPIKETIP_PLANKS.get()))
                .save(pWriter);
        fenceGateBuilder(ModBlocks.SPIKETIP_FENCE_GATE.get(),
                Ingredient.of(ModBlocks.SPIKETIP_PLANKS.get()))
                .unlockedBy("has_ginkgo", has(ModBlocks.SPIKETIP_PLANKS.get()))
                .save(pWriter);
        doorBuilder(ModBlocks.SPIKETIP_DOOR.get(),
                Ingredient.of(ModBlocks.SPIKETIP_PLANKS.get()))
                .unlockedBy("has_ginkgo", has(ModBlocks.SPIKETIP_PLANKS.get()))
                .save(pWriter);
        trapdoorBuilder(ModBlocks.SPIKETIP_TRAPDOOR.get(),
                Ingredient.of(ModBlocks.SPIKETIP_PLANKS.get()))
                .unlockedBy("has_ginkgo", has(ModBlocks.SPIKETIP_PLANKS.get()))
                .save(pWriter);
        slabBuilder(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SPIKETIP_SLAB.get(),
                Ingredient.of(ModBlocks.SPIKETIP_PLANKS.get()))
                .unlockedBy("has_ginkgo", has(ModBlocks.SPIKETIP_PLANKS.get()))
                .save(pWriter);
        stairBuilder(ModBlocks.SPIKETIP_STAIRS.get(),
                Ingredient.of(ModBlocks.SPIKETIP_PLANKS.get()))
                .unlockedBy("has_ginkgo", has(ModBlocks.SPIKETIP_PLANKS.get()))
                .save(pWriter);
        buttonBuilder(ModBlocks.SPIKETIP_BUTTON.get(),
                Ingredient.of(ModBlocks.SPIKETIP_PLANKS.get()))
                .unlockedBy("has_ginkgo", has(ModBlocks.SPIKETIP_PLANKS.get()))
                .save(pWriter);
        pressurePlate(pWriter, ModBlocks.SPIKETIP_PRESSURE_PLATE.get(),ModBlocks.SPIKETIP_PLANKS.get().asItem());



        woodFromLogs(pWriter, ModBlocks.TREE_FERN_WOOD.get(), ModBlocks.TREE_FERN_STEM.get());
        woodFromLogs(pWriter, ModBlocks.STRIPPED_TREE_FERN_WOOD.get(), ModBlocks.STRIPPED_TREE_FERN_LOG.get());
        planksFromLog(pWriter, ModBlocks.TREE_FERN_PLANKS.get(), ModTags.Items.TREE_FERN_LOGS, 4);
        woodenBoat(pWriter, ModItems.TREE_FERN_BOAT.get(), ModBlocks.TREE_FERN_PLANKS.get());
        chestBoat(pWriter, ModItems.TREE_FERN_CHEST_BOAT.get(), ModItems.TREE_FERN_BOAT.get());
        hangingSign(pWriter, ModItems.TREE_FERN_HANGING_SIGN.get(), ModBlocks.STRIPPED_TREE_FERN_LOG.get());
        signBuilder(ModItems.TREE_FERN_SIGN.get(),
                Ingredient.of(ModBlocks.TREE_FERN_PLANKS.get()))
                .unlockedBy("has_ginkgo", has(ModBlocks.TREE_FERN_PLANKS.get()))
                .save(pWriter);
        fenceBuilder(ModBlocks.TREE_FERN_FENCE.get(),
                Ingredient.of(ModBlocks.TREE_FERN_PLANKS.get()))
                .unlockedBy("has_ginkgo", has(ModBlocks.TREE_FERN_PLANKS.get()))
                .save(pWriter);
        fenceGateBuilder(ModBlocks.TREE_FERN_FENCE_GATE.get(),
                Ingredient.of(ModBlocks.TREE_FERN_PLANKS.get()))
                .unlockedBy("has_ginkgo", has(ModBlocks.TREE_FERN_PLANKS.get()))
                .save(pWriter);
        doorBuilder(ModBlocks.TREE_FERN_DOOR.get(),
                Ingredient.of(ModBlocks.TREE_FERN_PLANKS.get()))
                .unlockedBy("has_ginkgo", has(ModBlocks.TREE_FERN_PLANKS.get()))
                .save(pWriter);
        trapdoorBuilder(ModBlocks.TREE_FERN_TRAPDOOR.get(),
                Ingredient.of(ModBlocks.TREE_FERN_PLANKS.get()))
                .unlockedBy("has_ginkgo", has(ModBlocks.TREE_FERN_PLANKS.get()))
                .save(pWriter);
        slabBuilder(RecipeCategory.BUILDING_BLOCKS, ModBlocks.TREE_FERN_SLAB.get(),
                Ingredient.of(ModBlocks.TREE_FERN_PLANKS.get()))
                .unlockedBy("has_ginkgo", has(ModBlocks.TREE_FERN_PLANKS.get()))
                .save(pWriter);
        stairBuilder(ModBlocks.TREE_FERN_STAIRS.get(),
                Ingredient.of(ModBlocks.TREE_FERN_PLANKS.get()))
                .unlockedBy("has_ginkgo", has(ModBlocks.TREE_FERN_PLANKS.get()))
                .save(pWriter);
        buttonBuilder(ModBlocks.TREE_FERN_BUTTON.get(),
                Ingredient.of(ModBlocks.TREE_FERN_PLANKS.get()))
                .unlockedBy("has_ginkgo", has(ModBlocks.TREE_FERN_PLANKS.get()))
                .save(pWriter);
        pressurePlate(pWriter, ModBlocks.TREE_FERN_PRESSURE_PLATE.get(),ModBlocks.TREE_FERN_PLANKS.get().asItem());

        woodFromLogs(pWriter, ModBlocks.GREAT_CANE_WOOD.get(), ModBlocks.GREAT_CANE_LOG.get());
        planksFromLog(pWriter, Blocks.BAMBOO_PLANKS, ModTags.Items.GREAT_CANE_LOGS, 4);


        SimpleCookingRecipeBuilder.smelting(
                Ingredient.of(ModBlocks.PETRIFIED_WOOD.get()),
                RecipeCategory.MISC, ModBlocks.SMOOTH_PETRIFIED_LOG.get(), 0.1F, 200).
                unlockedBy("has_petrified_wood", has(ModBlocks.PETRIFIED_WOOD.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MAGIGIANS_BOOK.get(), 1)
                .define('#', Items.LAPIS_LAZULI)
                .define('F', ModItems.DODO_FEATHER.get())
                .pattern("###")
                .pattern("#F#")
                .pattern("###")
                .unlockedBy("has_dodo_feather", has(ModItems.DODO_FEATHER.get()))
                .save(pWriter);


        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_CHLORITE.get(), 4)
                .define('#', ModBlocks.CHLORITE.get())
                .pattern("##")
                .pattern("##")
                .unlockedBy("has_chlorite", has(ModBlocks.CHLORITE.get()))
                .save(pWriter);

        slabBuilder(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHLORITE_SLAB.get(), Ingredient.of(ModBlocks.CHLORITE.get()))
                .unlockedBy("has_chlorite", has(ModBlocks.CHLORITE.get()))
                .save(pWriter);
        stairBuilder(ModBlocks.CHLORITE_STAIRS.get(), Ingredient.of(ModBlocks.CHLORITE.get()))
                .unlockedBy("has_chlorite", has(ModBlocks.CHLORITE.get()))
                .save(pWriter);
        wall(pWriter, RecipeCategory.DECORATIONS, ModBlocks.CHLORITE_WALL.get(), ModBlocks.CHLORITE.get());
        slabBuilder(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_CHLORITE_BRICK_SLAB.get(), Ingredient.of(ModBlocks.POLISHED_CHLORITE_BRICKS.get()))
                .unlockedBy("has_chlorite_bricks", has(ModBlocks.BOULDERSTONE_BRICKS.get()))
                .save(pWriter);
        stairBuilder(ModBlocks.POLISHED_CHLORITE_BRICK_STAIRS.get(), Ingredient.of(ModBlocks.POLISHED_CHLORITE_BRICKS.get()))
                .unlockedBy("has_chlorite_bricks", has(ModBlocks.POLISHED_CHLORITE_BRICKS.get()))
                .save(pWriter);
        wall(pWriter, RecipeCategory.DECORATIONS, ModBlocks.POLISHED_CHLORITE_BRICK_WALL.get(), ModBlocks.POLISHED_CHLORITE_BRICKS.get());
        slabBuilder(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_CHLORITE_SLAB.get(), Ingredient.of(ModBlocks.POLISHED_CHLORITE.get()))
                .unlockedBy("has_polished_chlorite", has(ModBlocks.POLISHED_CHLORITE.get()))
                .save(pWriter);
        stairBuilder(ModBlocks.POLISHED_CHLORITE_STAIRS.get(), Ingredient.of(ModBlocks.POLISHED_CHLORITE.get()))
                .unlockedBy("has_polished_chlorite", has(ModBlocks.POLISHED_CHLORITE.get()))
                .save(pWriter);
        wall(pWriter, RecipeCategory.DECORATIONS, ModBlocks.POLISHED_CHLORITE_WALL.get(), ModBlocks.POLISHED_CHLORITE.get());


        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.CHITIN_BOOTS.get())
                .define('X', ModItems.ARTHROPOD_ARMOR.get())
                .pattern("X X")
                .pattern("X X")
                .unlockedBy("has_chitin", has(ModItems.ARTHROPOD_ARMOR.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.CHITIN_CHESTPLATE.get())
                .define('X', ModItems.ARTHROPOD_ARMOR.get())
                .pattern("X X")
                .pattern("XXX")
                .pattern("XXX")
                .unlockedBy("has_chitin", has(ModItems.ARTHROPOD_ARMOR.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.CHITIN_HELMET.get())
                .define('X', ModItems.ARTHROPOD_ARMOR.get())
                .pattern("XXX")
                .pattern("X X")
                .unlockedBy("has_chitin", has(ModItems.ARTHROPOD_ARMOR.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.CHITIN_LEGGINGS.get())
                .define('X', ModItems.ARTHROPOD_ARMOR.get())
                .pattern("XXX")
                .pattern("X X")
                .pattern("X X")
                .unlockedBy("has_chitin", has(ModItems.ARTHROPOD_ARMOR.get()))
                .save(pWriter);


        slabBuilder(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BONE_SLAB.get(), Ingredient.of(Blocks.BONE_BLOCK))
                .unlockedBy("has_bone_block", has(Blocks.BONE_BLOCK))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BAMBOO_PILLAR_LIGHT.get(), 3)
                .define('B', Blocks.BAMBOO_PLANKS)
                .define('C', Items.COAL)
                .pattern("B")
                .pattern("C")
                .pattern("B")
                .unlockedBy("has_coal", has(Items.COAL))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ACACIA_PILLAR_LIGHT.get(), 3)
                .define('B', Blocks.ACACIA_PLANKS)
                .define('C', Items.COAL)
                .pattern("B")
                .pattern("C")
                .pattern("B")
                .unlockedBy("has_coal", has(Items.COAL))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BIRCH_PILLAR_LIGHT.get(), 3)
                .define('B', Blocks.BIRCH_PLANKS)
                .define('C', Items.COAL)
                .pattern("B")
                .pattern("C")
                .pattern("B")
                .unlockedBy("has_coal", has(Items.COAL))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHERRY_PILLAR_LIGHT.get(), 3)
                .define('B', Blocks.CHERRY_PLANKS)
                .define('C', Items.COAL)
                .pattern("B")
                .pattern("C")
                .pattern("B")
                .unlockedBy("has_coal", has(Items.COAL))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRIMSON_PILLAR_LIGHT.get(), 3)
                .define('B', Blocks.CRIMSON_PLANKS)
                .define('C', Items.COAL)
                .pattern("B")
                .pattern("C")
                .pattern("B")
                .unlockedBy("has_coal", has(Items.COAL))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DARK_OAK_PILLAR_LIGHT.get(), 3)
                .define('B', Blocks.DARK_OAK_PLANKS)
                .define('C', Items.COAL)
                .pattern("B")
                .pattern("C")
                .pattern("B")
                .unlockedBy("has_coal", has(Items.COAL))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GINKGO_PILLAR_LIGHT.get(), 3)
                .define('B', ModBlocks.GINKGO_PLANKS.get())
                .define('C', Items.COAL)
                .pattern("B")
                .pattern("C")
                .pattern("B")
                .unlockedBy("has_coal", has(Items.COAL))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.JUNGLE_PILLAR_LIGHT.get(), 3)
                .define('B', Blocks.JUNGLE_PLANKS)
                .define('C', Items.COAL)
                .pattern("B")
                .pattern("C")
                .pattern("B")
                .unlockedBy("has_coal", has(Items.COAL))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MANGROVE_PILLAR_LIGHT.get(), 3)
                .define('B', Blocks.MANGROVE_PLANKS)
                .define('C', Items.COAL)
                .pattern("B")
                .pattern("C")
                .pattern("B")
                .unlockedBy("has_coal", has(Items.COAL))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OAK_PILLAR_LIGHT.get(), 3)
                .define('B', Blocks.OAK_PLANKS)
                .define('C', Items.COAL)
                .pattern("B")
                .pattern("C")
                .pattern("B")
                .unlockedBy("has_coal", has(Items.COAL))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SPIKETIP_PILLAR_LIGHT.get(), 3)
                .define('B', ModBlocks.SPIKETIP_PLANKS.get())
                .define('C', Items.COAL)
                .pattern("B")
                .pattern("C")
                .pattern("B")
                .unlockedBy("has_coal", has(Items.COAL))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SPRUCE_PILLAR_LIGHT.get(), 3)
                .define('B', Blocks.SPRUCE_PLANKS)
                .define('C', Items.COAL)
                .pattern("B")
                .pattern("C")
                .pattern("B")
                .unlockedBy("has_coal", has(Items.COAL))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.TREE_FERN_PILLAR_LIGHT.get(), 3)
                .define('B', ModBlocks.TREE_FERN_PLANKS.get())
                .define('C', Items.COAL)
                .pattern("B")
                .pattern("C")
                .pattern("B")
                .unlockedBy("has_coal", has(Items.COAL))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WARPED_PILLAR_LIGHT.get(), 3)
                .define('B', Blocks.WARPED_PLANKS)
                .define('C', Items.COAL)
                .pattern("B")
                .pattern("C")
                .pattern("B")
                .unlockedBy("has_coal", has(Items.COAL))
                .save(pWriter);
        carpet(pWriter, ModBlocks.SNIFFER_CARPET.get(), ModItems.SNIFFER_FUR.get());
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SNIFFER_WOOL.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.SNIFFER_FUR.get())
                .unlockedBy(getHasName(ModItems.SNIFFER_FUR.get()),has(ModItems.SNIFFER_FUR.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SNIFFER_FUR.get(), 9)
                .requires(ModBlocks.SNIFFER_WOOL.get())
                .unlockedBy(getHasName(ModBlocks.SNIFFER_WOOL.get()), has(ModBlocks.SNIFFER_WOOL.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SNIFFER_BAG.get(), 1)
                .define('S', Items.STRING)
                .define('F', ModItems.SNIFFER_FUR.get())
                .pattern(" S ")
                .pattern("FFF")
                .pattern("FFF")
                .unlockedBy(getHasName(ModItems.SNIFFER_FUR.get()), has(ModItems.SNIFFER_FUR.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CASTLE_SPIKES.get(), 6)
                .define('S', ItemTags.STONE_CRAFTING_MATERIALS)
                .define('I', Items.IRON_NUGGET)
                .pattern("I I")
                .pattern("I I")
                .pattern("SSS")
                .unlockedBy(getHasName(Items.IRON_NUGGET), has(Items.IRON_NUGGET))
                .save(pWriter);


    }
    protected static void cookRecipes(Consumer<FinishedRecipe> pFinishedRecipeConsumer, String pCookingMethod, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, int pCookingTime) {
        simpleCookingRecipe(pFinishedRecipeConsumer, pCookingMethod, pCookingSerializer, pCookingTime, ModItems.RAW_DODO_MEAT.get(), ModItems.ROASTED_DODO_MEAT.get(), 0.35F);
    }


    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                            pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer,  SnifferUpgrade.MODID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
