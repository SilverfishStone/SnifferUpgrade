package net.silverfishstone.silversnifferupgrade.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.silverfishstone.silversnifferupgrade.SnifferUpgrade;
import net.silverfishstone.silversnifferupgrade.loot.AddItemModifiers;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output, String modid) {
        super(output, SnifferUpgrade.MODID);
    }

    @Override
    protected void start() {

    }
}
