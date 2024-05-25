package net.silverfishstone.silversnifferupgrade.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.silverfishstone.silversnifferupgrade.SnifferUpgrade;
import net.silverfishstone.silversnifferupgrade.potions.ModMobEffects;

@OnlyIn(Dist.CLIENT)
public class SUGUI extends Gui {

    public SUGUI(Minecraft pMinecraft, ItemRenderer pItemRenderer) {
        super(pMinecraft, pItemRenderer);
    }
    @Override
    public void render(GuiGraphics pGuiGraphics, float pPartialTick) {
        this.screenWidth = pGuiGraphics.guiWidth();
        this.screenHeight = pGuiGraphics.guiHeight();
        if (this.minecraft.player.hasEffect(ModMobEffects.DIRTY.get())) {
            this.renderTextureOverlay(pGuiGraphics, new ResourceLocation(SnifferUpgrade.MODID, "textures/misc/dirty"), 50);
        }
    }
}
