package net.silverfishstone.silversnifferupgrade.util;

import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.silverfishstone.silversnifferupgrade.SnifferUpgrade;

public class ModWoodTypes {
    public static final WoodType GINKGO = WoodType.register(new WoodType(SnifferUpgrade.MODID + ":ginkgo", BlockSetType.SPRUCE));
    public static final WoodType SPIKETIP = WoodType.register(new WoodType(SnifferUpgrade.MODID + ":spiketip", BlockSetType.SPRUCE));
    public static final WoodType TREE_FERN = WoodType.register(new WoodType(SnifferUpgrade.MODID + ":tree_fern", BlockSetType.SPRUCE));
}
