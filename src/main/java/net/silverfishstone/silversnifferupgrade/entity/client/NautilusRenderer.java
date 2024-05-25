package net.silverfishstone.silversnifferupgrade.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.silverfishstone.silversnifferupgrade.SnifferUpgrade;
import net.silverfishstone.silversnifferupgrade.entity.custom.GreaterDodoEntity;
import net.silverfishstone.silversnifferupgrade.entity.custom.NautilusEntity;

public class NautilusRenderer extends MobRenderer<NautilusEntity, NautilusModel<NautilusEntity>> {
    public NautilusRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new NautilusModel<>(pContext.bakeLayer(ModModelLayers.NAUTILUS_LAYER)), 0.1f);
    }

    @Override
    public ResourceLocation getTextureLocation(NautilusEntity pEntity) {
        return new ResourceLocation(SnifferUpgrade.MODID, "textures/entity/nautilus.png");
    }

    @Override
    public void render(NautilusEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()) {
            pMatrixStack.scale(0.5f, 0.5f, 0.5f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
