package net.silverfishstone.silversnifferupgrade.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.silverfishstone.silversnifferupgrade.entity.animations.ModAnimationDefinitions;
import net.silverfishstone.silversnifferupgrade.entity.custom.ConeshellEntity;
import net.silverfishstone.silversnifferupgrade.entity.custom.NautilusEntity;

public class ConeshellModel<T extends Entity> extends HierarchicalModel<T> {
    private final ModelPart coneshell;
    private final ModelPart head;

    public ConeshellModel(ModelPart root) {
        this.coneshell = root.getChild("coneshell");
        this.head = coneshell.getChild("head");
    }

        public static LayerDefinition createBodyLayer() {
            MeshDefinition meshdefinition = new MeshDefinition();
            PartDefinition partdefinition = meshdefinition.getRoot();

            PartDefinition coneshell = partdefinition.addOrReplaceChild("coneshell", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

            PartDefinition tentacles = coneshell.addOrReplaceChild("tentacles", CubeListBuilder.create(), PartPose.offset(-2.25F, -11.5937F, -3.0007F));

            PartDefinition bone = tentacles.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(34, 20).addBox(-0.5F, -0.5F, -3.5F, 1.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(2.4955F, 6.6022F, 19.7166F));

            PartDefinition bone10 = tentacles.addOrReplaceChild("bone10", CubeListBuilder.create().texOffs(24, 35).addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(2.4955F, 10.5851F, 19.4673F));

            PartDefinition bone6 = tentacles.addOrReplaceChild("bone6", CubeListBuilder.create().texOffs(10, 35).addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5975F, 10.5097F, 19.2081F));

            PartDefinition bone5 = tentacles.addOrReplaceChild("bone5", CubeListBuilder.create().texOffs(9, 27).addBox(-0.5F, -0.5F, -3.5F, 1.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0045F, 7.9237F, 19.6918F));

            PartDefinition bone4 = tentacles.addOrReplaceChild("bone4", CubeListBuilder.create().texOffs(26, 8).addBox(-0.5F, -0.5F, -3.5F, 1.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(4.4955F, 8.452F, 19.6784F));

            PartDefinition bone2 = tentacles.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(34, 20).addBox(-0.5F, -0.5F, -3.5F, 1.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(4.3939F, 6.6022F, 19.7317F));

            PartDefinition bone3 = tentacles.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(24, 35).addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(4.4955F, 10.2741F, 19.079F));

            PartDefinition bone7 = tentacles.addOrReplaceChild("bone7", CubeListBuilder.create().texOffs(25, 27).addBox(-0.5F, -0.5F, -3.5F, 1.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(1.4955F, 8.1022F, 19.7166F));

            PartDefinition bone8 = tentacles.addOrReplaceChild("bone8", CubeListBuilder.create().texOffs(0, 23).addBox(-0.5F, -0.5F, -3.5F, 1.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(2.6901F, 9.2022F, 19.7849F));

            PartDefinition bone9 = tentacles.addOrReplaceChild("bone9", CubeListBuilder.create(), PartPose.offset(0.5078F, 6.6022F, 19.7165F));

            PartDefinition tentacle_r1 = bone9.addOrReplaceChild("tentacle_r1", CubeListBuilder.create().texOffs(0, 31).addBox(1.2422F, -2.9914F, -20.2158F, 1.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.7422F, 2.4914F, -16.7158F, 0.0F, 3.1416F, 0.0F));

            PartDefinition head = coneshell.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(-0.25F, -16.5F, 4.5766F));

            PartDefinition cube_r1 = head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(16, 13).addBox(-0.7455F, -0.4914F, 14.7841F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                    .texOffs(18, 0).addBox(-1.2455F, -0.9914F, 11.7841F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                    .texOffs(26, 0).addBox(-1.7455F, -1.4914F, 6.7841F, 3.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
                    .texOffs(16, 17).addBox(-2.2455F, -1.9914F, 0.7841F, 4.0F, 4.0F, 6.0F, new CubeDeformation(0.0F))
                    .texOffs(18, 27).addBox(-2.7455F, -2.4914F, -13.2159F, 5.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
                    .texOffs(0, 12).addBox(-2.7455F, -2.4914F, -5.2159F, 5.0F, 5.0F, 6.0F, new CubeDeformation(0.0F))
                    .texOffs(0, 0).addBox(-3.2455F, -2.9914F, -11.2159F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.25F, 13.2414F, -4.5766F, 0.0F, 3.1416F, 0.0F));

            return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.animate(((ConeshellEntity) entity).idleAnimationState, ModAnimationDefinitions.TENTACLE_SWIM, ageInTicks, 1f);
    }


    private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
        pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
        pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

        this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
        this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        coneshell.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Override
    public ModelPart root() {
        return coneshell;
    }

    public ModelPart getHead() {
        return head;
    }
}
