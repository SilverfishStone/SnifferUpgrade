package net.silverfishstone.silversnifferupgrade.block.properties;

import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.WallSide;

public class SnifferBlockProperties extends BlockStateProperties {
    public static final BooleanProperty MIDDLE = BooleanProperty.create("middle");
    public static final EnumProperty<CarpetSide> EAST_EDGE = EnumProperty.create("east_edge", CarpetSide.class);
    public static final EnumProperty<CarpetSide> NORTH_EDGE = EnumProperty.create("north_edge", CarpetSide.class);
    public static final EnumProperty<CarpetSide> SOUTH_EDGE = EnumProperty.create("south_edge", CarpetSide.class);
    public static final EnumProperty<CarpetSide> WEST_EDGE = EnumProperty.create("west_edge", CarpetSide.class);

}
