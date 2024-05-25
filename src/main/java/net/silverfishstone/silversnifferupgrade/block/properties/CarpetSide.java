package net.silverfishstone.silversnifferupgrade.block.properties;

import net.minecraft.util.StringRepresentable;

public enum CarpetSide implements StringRepresentable {
    NONE("empty"),
    BASE("attached");

    private final String name;

    private CarpetSide(String pName) {
        this.name = pName;
    }

    public String toString() {
        return this.getSerializedName();
    }

    public String getSerializedName() {
        return this.name;
    }
}
