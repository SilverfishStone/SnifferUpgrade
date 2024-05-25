package net.silverfishstone.silversnifferupgrade.enchantments;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.silverfishstone.silversnifferupgrade.SnifferUpgrade;
import net.silverfishstone.silversnifferupgrade.enchantments.custom.OxygenPlusEnchantment;

public class SnifferEnchantments {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS =
            DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, SnifferUpgrade.MODID);

    public static RegistryObject<Enchantment> MERMAID =
            ENCHANTMENTS.register("mermaid",
                    () -> new OxygenPlusEnchantment(Enchantment.Rarity.UNCOMMON,
                            EnchantmentCategory.ARMOR_HEAD, EquipmentSlot.HEAD));

    public static void register(IEventBus eventBus) {
        ENCHANTMENTS.register(eventBus);
    }
}


