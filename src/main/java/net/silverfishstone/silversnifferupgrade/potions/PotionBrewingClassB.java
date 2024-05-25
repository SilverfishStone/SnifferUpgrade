package net.silverfishstone.silversnifferupgrade.potions;

import net.minecraft.Util;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraftforge.common.brewing.IBrewingRecipe;
import net.silverfishstone.silversnifferupgrade.item.ModItems;

// BetterBrewingRecipe Class by CAS-ual-TY from https://github.com/CAS-ual-TY/Extra-Potions (GPL-3.0 License)
// https://github.com/CAS-ual-TY/Extra-Potions/blob/main/LICENSE
public class PotionBrewingClassB implements IBrewingRecipe {
    private final Potion inputb;
    private final Item ingredientb;
    private final Item outputb;

    public PotionBrewingClassB(Potion input, Item ingredient, Item output) {
        this.inputb = input;
        this.ingredientb = ingredient;
        this.outputb = output;
    }

    @Override
    public boolean isInput(ItemStack input) {
        return PotionUtils.getPotion(input) == this.inputb;
    }

    @Override
    public boolean isIngredient(ItemStack ingredient) {
        return ingredient.getItem() == this.ingredientb;
    }

    @Override
    public ItemStack getOutput(ItemStack input, ItemStack ingredient) {
        if(!this.isInput(input) || !this.isIngredient(ingredient)) {
            return ItemStack.EMPTY;
        }

        ItemStack itemStack = new ItemStack(input.getItem());
        itemStack.setTag(new CompoundTag());
        Item.getId( this.outputb);
        return itemStack;
    }
}