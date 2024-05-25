package net.silverfishstone.silversnifferupgrade.util;

import com.mojang.blaze3d.platform.GlStateManager.DestFactor;
import com.mojang.blaze3d.platform.GlStateManager.SourceFactor;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.silverfishstone.silversnifferupgrade.SnifferUpgrade;
import net.silverfishstone.silversnifferupgrade.potions.ModMobEffects;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class DirtyOverlay {
    public DirtyOverlay() {
    }

    @SubscribeEvent(
            priority = EventPriority.HIGH
    )
    public static void eventHandler(RenderGuiEvent.Pre event) {
        int w = event.getWindow().getWidth();
        int h = event.getWindow().getHeight();
        Level world = null;
        double x = 0.0;
        double y = 0.0;
        double z = 0.0;
        Player entity = Minecraft.getInstance().player;
        RenderSystem.disableDepthTest();
        RenderSystem.depthMask(false);
        RenderSystem.enableBlend();
        RenderSystem.setShader(GameRenderer::getRendertypeCutoutShader);
        RenderSystem.blendFuncSeparate(SourceFactor.SRC_ALPHA, DestFactor.ONE_MINUS_SRC_ALPHA, SourceFactor.ONE, DestFactor.ZERO);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        if (entity.hasEffect(ModMobEffects.DIRTY.get())) {
            event.getGuiGraphics().blit(new ResourceLocation(SnifferUpgrade.MODID,  "textures/misc/dirty.png"), 0, 0, 0.0F, 0.0F, w, h, w/3, h/3);
        }

        RenderSystem.depthMask(true);
        RenderSystem.defaultBlendFunc();
        RenderSystem.enableDepthTest();
        RenderSystem.disableBlend();
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
    }
}

