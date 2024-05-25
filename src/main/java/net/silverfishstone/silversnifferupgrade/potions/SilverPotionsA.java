package net.silverfishstone.silversnifferupgrade.potions;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.silverfishstone.silversnifferupgrade.SnifferUpgrade;

public class SilverPotionsA
{
    private static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(ForgeRegistries.POTIONS, SnifferUpgrade.MODID);

    public static final RegistryObject<Potion> OXYGENATED = POTIONS.register("oxygenated", () -> new Potion(new MobEffectInstance(ModMobEffects.OXYGENATED.get(), 12000)));

    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }
}