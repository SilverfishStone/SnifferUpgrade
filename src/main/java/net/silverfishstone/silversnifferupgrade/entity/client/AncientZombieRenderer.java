package net.silverfishstone.silversnifferupgrade.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.ZombieModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.silverfishstone.silversnifferupgrade.SnifferUpgrade;
import net.silverfishstone.silversnifferupgrade.entity.custom.AncientZombieEntity;

public class AncientZombieRenderer extends MobRenderer<AncientZombieEntity, AncientZombieModel<AncientZombieEntity>> {
    public AncientZombieRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new AncientZombieModel<>(pContext.bakeLayer(ModModelLayers.ANCIENT_ZOMBIE_LAYER)), 0.3f);
    }

    @Override
    public ResourceLocation getTextureLocation(AncientZombieEntity pEntity) {
        return new ResourceLocation(SnifferUpgrade.MODID, "textures/entity/ancient_zombie.png");
    }

    @Override
    public void render(AncientZombieEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()) {
            pMatrixStack.scale(0.5f, 0.5f, 0.5f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
