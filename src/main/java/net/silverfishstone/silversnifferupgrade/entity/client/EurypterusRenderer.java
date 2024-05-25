package net.silverfishstone.silversnifferupgrade.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.silverfishstone.silversnifferupgrade.SnifferUpgrade;
import net.silverfishstone.silversnifferupgrade.entity.custom.EurypterusEntity;

public class EurypterusRenderer extends MobRenderer<EurypterusEntity, EurypterusModel<EurypterusEntity>> {
    public EurypterusRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new EurypterusModel<>(pContext.bakeLayer(ModModelLayers.EURYPTERUS_LAYER)), 0.3f);
    }

    @Override
    public ResourceLocation getTextureLocation(EurypterusEntity pEntity) {
        return new ResourceLocation(SnifferUpgrade.MODID, "textures/entity/eurypterus.png");
    }

    @Override
    public void render(EurypterusEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()) {
            pMatrixStack.scale(0.5f, 0.5f, 0.5f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
