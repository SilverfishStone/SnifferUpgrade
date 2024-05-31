package net.silverfishstone.silversnifferupgrade.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.silverfishstone.silversnifferupgrade.potions.ModMobEffects;

public class ModFoods {
    public static final FoodProperties ANCIENT_APPLE = new FoodProperties.Builder().alwaysEat()
            .saturationMod(0.3f).nutrition(6).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 900, 0),  1).build();
    public static final FoodProperties ROTTEN_APPLE = new FoodProperties.Builder().alwaysEat()
            .saturationMod(0.5f).nutrition(7).effect(() -> new MobEffectInstance(MobEffects.POISON, 900, 0),  1).effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 600, 0),  0.3f).build();
    public static final FoodProperties BIOMITE_FRUIT = new FoodProperties.Builder().alwaysEat()
            .saturationMod(0.1f).nutrition(4).effect(() -> new MobEffectInstance(ModMobEffects.MYSTERY.get(), 200, 0),  0.1f).build();
    public static final FoodProperties RAW_DODO_MEAT = new FoodProperties.Builder()
            .saturationMod(0.27f).nutrition(3).build();
    public static final FoodProperties ROASTED_DODO_MEAT = new FoodProperties.Builder()
            .saturationMod(0.4f).nutrition(8).build();
    public static final FoodProperties CRAB_CLAW = new FoodProperties.Builder()
            .saturationMod(0.1f).nutrition(2).build();
    public static final FoodProperties ROASTED_CRAB_CLAW = new FoodProperties.Builder()
            .saturationMod(0.3f).nutrition(7).build();

    public static final FoodProperties STRANIP_ROOT = new FoodProperties.Builder()
            .saturationMod(0.1f).nutrition(2)
            .effect(() -> new MobEffectInstance(ModMobEffects.DIRTY.get(), 100, 0),  0.1f).build();
    public static final FoodProperties STRANIP = new FoodProperties.Builder()
            .saturationMod(0.26f).nutrition(5).build();
    public static final FoodProperties SOUP = new FoodProperties.Builder()
            .saturationMod(0.5f).nutrition(9).build();

    public static final FoodProperties SPICY_SOUP = new FoodProperties.Builder()
            .saturationMod(0.7f).nutrition(15)
            .effect(() -> new MobEffectInstance(ModMobEffects.SPICY.get(), 100, 0, false, false),  0.9f).build();

}
