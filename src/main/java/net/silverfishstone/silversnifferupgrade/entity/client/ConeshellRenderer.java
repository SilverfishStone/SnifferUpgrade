package net.silverfishstone.silversnifferupgrade.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.silverfishstone.silversnifferupgrade.SnifferUpgrade;
import net.silverfishstone.silversnifferupgrade.entity.custom.ConeshellEntity;
import net.silverfishstone.silversnifferupgrade.entity.custom.NautilusEntity;

public class ConeshellRenderer extends MobRenderer<ConeshellEntity, ConeshellModel<ConeshellEntity>> {
    public ConeshellRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new ConeshellModel<>(pContext.bakeLayer(ModModelLayers.CONESHELL_LAYER)), 0.1f);
    }

    @Override
    public ResourceLocation getTextureLocation(ConeshellEntity pEntity) {
        return new ResourceLocation(SnifferUpgrade.MODID, "textures/entity/coneshell.png");
    }

    @Override
    public void render(ConeshellEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()) {
            pMatrixStack.scale(0.5f, 0.5f, 0.5f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
