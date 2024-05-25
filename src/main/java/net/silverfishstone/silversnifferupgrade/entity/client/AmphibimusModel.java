package net.silverfishstone.silversnifferupgrade.entity.client;// Made with Blockbench 4.9.4


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.silverfishstone.silversnifferupgrade.entity.animations.ModAnimationDefinitions;
import net.silverfishstone.silversnifferupgrade.entity.custom.AmphibimusEntity;
import net.silverfishstone.silversnifferupgrade.entity.custom.GreaterDodoEntity;

public class AmphibimusModel<T extends Entity> extends HierarchicalModel<T> {
	private final ModelPart amphibimus;
	private final ModelPart head;

	public AmphibimusModel(ModelPart root) {
		this.amphibimus = root.getChild("amphibimus");
		this.head = amphibimus.getChild("head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition amphibimus = partdefinition.addOrReplaceChild("amphibimus", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition spine = amphibimus.addOrReplaceChild("spine", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -1.5F, -6.0F, 5.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, -3.5F, 1.0F));

		PartDefinition head = amphibimus.addOrReplaceChild("head", CubeListBuilder.create().texOffs(17, 25).addBox(4.5F, -0.9375F, -1.9375F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(30, 0).addBox(5.5F, -0.9375F, -0.9375F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(22, 8).addBox(-3.5F, -0.9375F, -3.9375F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(22, 0).addBox(3.5F, -0.9375F, -2.9375F, 1.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(0, 23).addBox(-4.5F, -0.9375F, -2.9375F, 1.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(0, 31).addBox(-6.5F, -0.9375F, -0.9375F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-5.5F, -0.9375F, -1.9375F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 15).addBox(-3.5F, -1.9375F, -1.9375F, 7.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, -3.5625F, -7.0625F));

		PartDefinition tail = amphibimus.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition tail1 = tail.addOrReplaceChild("tail1", CubeListBuilder.create().texOffs(19, 18).addBox(-2.0F, -1.0F, -2.5F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, -3.0F, 9.5F));

		PartDefinition tail2 = tail.addOrReplaceChild("tail2", CubeListBuilder.create().texOffs(8, 23).addBox(-1.5F, -1.0F, -2.0F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, -3.0F, 14.0F));

		PartDefinition tail3 = tail.addOrReplaceChild("tail3", CubeListBuilder.create().texOffs(25, 28).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, -3.0F, 18.0F));

		PartDefinition tail4 = tail.addOrReplaceChild("tail4", CubeListBuilder.create().texOffs(11, 29).addBox(-0.5F, -1.25F, -2.5F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(22, 2).addBox(-0.5F, -0.25F, 0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, -2.75F, 22.5F));

		PartDefinition fin = tail.addOrReplaceChild("fin", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition fin1 = fin.addOrReplaceChild("fin1", CubeListBuilder.create().texOffs(0, 7).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, -4.5F, 9.0F));

		PartDefinition fin2 = fin.addOrReplaceChild("fin2", CubeListBuilder.create().texOffs(8, 23).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, -4.5F, 11.5F));

		PartDefinition fin3 = fin.addOrReplaceChild("fin3", CubeListBuilder.create().texOffs(31, 34).addBox(-0.5F, -0.5F, -1.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, -4.5F, 13.5F));

		PartDefinition fin4 = fin.addOrReplaceChild("fin4", CubeListBuilder.create().texOffs(0, 23).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, -4.5F, 15.5F));

		PartDefinition fin5 = fin.addOrReplaceChild("fin5", CubeListBuilder.create().texOffs(22, 16).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, -4.5F, 16.5F));

		PartDefinition fin6 = fin.addOrReplaceChild("fin6", CubeListBuilder.create().texOffs(6, 7).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, -4.5F, 18.0F));

		PartDefinition fin7 = fin.addOrReplaceChild("fin7", CubeListBuilder.create().texOffs(22, 4).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, -4.5F, 19.5F));

		PartDefinition leg4 = amphibimus.addOrReplaceChild("leg4", CubeListBuilder.create(), PartPose.offset(-6.8F, -1.3F, 4.8F));

		PartDefinition shoulder4 = leg4.addOrReplaceChild("shoulder4", CubeListBuilder.create().texOffs(17, 32).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.8F, -1.7F, 0.2F));

		PartDefinition foot4 = leg4.addOrReplaceChild("foot4", CubeListBuilder.create().texOffs(32, 13).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.2F, -0.7F, 0.2F));

		PartDefinition toes4 = foot4.addOrReplaceChild("toes4", CubeListBuilder.create().texOffs(0, 7).addBox(-5.5F, -1.0F, -2.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 2).addBox(-5.5F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-3.5F, -1.0F, -2.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 2.0F, 1.0F));

		PartDefinition leg2 = amphibimus.addOrReplaceChild("leg2", CubeListBuilder.create(), PartPose.offset(-6.8F, -1.3F, -1.2F));

		PartDefinition shoulder2 = leg2.addOrReplaceChild("shoulder2", CubeListBuilder.create().texOffs(23, 34).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.8F, -1.7F, 0.2F));

		PartDefinition foot2 = leg2.addOrReplaceChild("foot2", CubeListBuilder.create().texOffs(6, 34).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.2F, -0.7F, 0.2F));

		PartDefinition toes2 = foot2.addOrReplaceChild("toes2", CubeListBuilder.create().texOffs(19, 15).addBox(-5.5F, -1.0F, -2.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 17).addBox(-5.5F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 15).addBox(-3.5F, -1.0F, -2.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 2.0F, 1.0F));

		PartDefinition leg3 = amphibimus.addOrReplaceChild("leg3", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 6.0F));

		PartDefinition shoulder3 = leg3.addOrReplaceChild("shoulder3", CubeListBuilder.create().texOffs(33, 25).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -3.0F, -1.0F));

		PartDefinition foot3 = leg3.addOrReplaceChild("foot3", CubeListBuilder.create().texOffs(32, 17).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, -2.0F, -1.0F));

		PartDefinition toes3 = foot3.addOrReplaceChild("toes3", CubeListBuilder.create().texOffs(0, 9).addBox(4.5F, -1.0F, -2.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(7, 2).addBox(4.5F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(7, 0).addBox(2.5F, -1.0F, -2.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 2.0F, 1.0F));

		PartDefinition leg = amphibimus.addOrReplaceChild("leg", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition shoulder = leg.addOrReplaceChild("shoulder", CubeListBuilder.create().texOffs(36, 3).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -3.0F, -1.0F));

		PartDefinition foot = leg.addOrReplaceChild("foot", CubeListBuilder.create().texOffs(0, 36).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, -2.0F, -1.0F));

		PartDefinition toes = foot.addOrReplaceChild("toes", CubeListBuilder.create().texOffs(0, 25).addBox(4.5F, -1.0F, -2.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(19, 17).addBox(2.5F, -1.0F, -2.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(22, 0).addBox(4.5F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 2.0F, 1.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);
		this.animateWalk(ModAnimationDefinitions.WALK_AMPHI, limbSwing, limbSwingAmount, 10f, 8f);
		this.animate(((AmphibimusEntity) entity).idleAnimationState, ModAnimationDefinitions.LOOK_AMPHI, ageInTicks, 1f);
		this.animate(((AmphibimusEntity) entity).attackAnimationState, ModAnimationDefinitions.ATTACK_AMPHI, ageInTicks, 1f);
		this.animate(((AmphibimusEntity) entity).swimIdleAnimationState, ModAnimationDefinitions.SWIM_AMPHI, ageInTicks, 2f);
		this.animate(((AmphibimusEntity) entity).crawlAnimationState, ModAnimationDefinitions.WALK_AMPHI, ageInTicks, 5f);
	}

	private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
		pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

		this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
		this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		amphibimus.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return amphibimus;
	}

	public ModelPart getHead() {
		return head;
	}
}