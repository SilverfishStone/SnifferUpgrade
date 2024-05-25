package net.silverfishstone.silversnifferupgrade.entity.client;// Made with Blockbench 4.9.4


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import net.silverfishstone.silversnifferupgrade.entity.animations.ModAnimationDefinitions;
import net.silverfishstone.silversnifferupgrade.entity.custom.AmphibimusEntity;
import net.silverfishstone.silversnifferupgrade.entity.custom.ArmisorEntity;
import org.checkerframework.checker.units.qual.A;

public class ArmisorModel<T extends Entity> extends HierarchicalModel<T> {
	private final ModelPart armisor;
	private final ModelPart head;

	public ArmisorModel(ModelPart root) {
		this.armisor = root.getChild("armisor");
		this.head = armisor.getChild("head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition armisor = partdefinition.addOrReplaceChild("armisor", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body = armisor.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, -10.5F, -16.2857F));

		PartDefinition cube_r1 = body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-8.5F, -8.5588F, -4.5F, 17.0F, 17.0F, 39.0F, new CubeDeformation(0.0F))
				.texOffs(52, 120).addBox(-12.5F, -6.5588F, -4.5F, 1.0F, 13.0F, 42.0F, new CubeDeformation(0.0F))
				.texOffs(128, 78).addBox(11.5F, -6.5588F, -4.5F, 1.0F, 13.0F, 42.0F, new CubeDeformation(0.0F))
				.texOffs(76, 61).addBox(-11.5F, -8.5588F, -4.5F, 3.0F, 17.0F, 42.0F, new CubeDeformation(0.0F))
				.texOffs(0, 103).addBox(8.5F, -8.5588F, -4.5F, 3.0F, 17.0F, 42.0F, new CubeDeformation(0.0F))
				.texOffs(0, 56).addBox(-8.5F, -11.5588F, -4.5F, 17.0F, 5.0F, 42.0F, new CubeDeformation(0.0F))
				.texOffs(76, 14).addBox(-8.5F, 6.4412F, -4.5F, 17.0F, 5.0F, 42.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0588F, 16.2857F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition head = armisor.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition eyes = head.addOrReplaceChild("eyes", CubeListBuilder.create(), PartPose.offset(0.0F, -10.4412F, 0.0F));

		PartDefinition eye_left = eyes.addOrReplaceChild("eye_left", CubeListBuilder.create(), PartPose.offset(11.0F, -2.5588F, -51.5F));

		PartDefinition eye_left_r1 = eye_left.addOrReplaceChild("eye_left_r1", CubeListBuilder.create().texOffs(165, 186).addBox(-11.5F, -4.5588F, 49.5F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.0F, 2.5588F, 51.5F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition eye_left2 = eyes.addOrReplaceChild("eye_left2", CubeListBuilder.create(), PartPose.offset(-11.0F, -2.5588F, -51.5F));

		PartDefinition cube_r2 = eye_left2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(165, 186).addBox(10.5F, -4.5588F, 49.5F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.0F, 2.5588F, 51.5F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition bone18 = head.addOrReplaceChild("bone18", CubeListBuilder.create(), PartPose.offset(0.0F, -10.5F, -43.5F));

		PartDefinition cube_r3 = bone18.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 81).addBox(7.5F, 5.4412F, 37.5F, 3.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
				.texOffs(128, 61).addBox(-7.5F, 7.4412F, 37.5F, 15.0F, 3.0F, 12.0F, new CubeDeformation(0.0F))
				.texOffs(96, 0).addBox(-10.5F, 5.4412F, 37.5F, 3.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
				.texOffs(152, 0).addBox(-11.5F, -5.5588F, 37.5F, 1.0F, 11.0F, 12.0F, new CubeDeformation(0.0F))
				.texOffs(52, 125).addBox(-10.5F, -7.5588F, 37.5F, 3.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
				.texOffs(152, 23).addBox(10.5F, -5.5588F, 37.5F, 1.0F, 11.0F, 12.0F, new CubeDeformation(0.0F))
				.texOffs(0, 127).addBox(7.5F, -7.5588F, 37.5F, 3.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
				.texOffs(132, 140).addBox(-7.5F, -10.5588F, 37.5F, 15.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0588F, 43.5F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create(), PartPose.offset(0.5F, -10.375F, 64.5F));

		PartDefinition upper_jaw = jaw.addOrReplaceChild("upper_jaw", CubeListBuilder.create(), PartPose.offset(-0.5F, -0.9375F, -117.6563F));

		PartDefinition cube_r4 = upper_jaw.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(18, 81).addBox(6.5F, -5.5588F, 49.5F, 4.0F, 6.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(70, 129).addBox(-5.5F, 0.4412F, 53.5F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(13, 0).addBox(9.5F, 0.4412F, 48.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(20, 0).addBox(-10.5F, 0.4412F, 48.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(126, 10).addBox(5.5F, 0.4412F, 52.5F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(128, 68).addBox(-8.5F, 0.4412F, 52.5F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(18, 127).addBox(-9.5F, 0.4412F, 49.5F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(128, 61).addBox(8.5F, 0.4412F, 49.5F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(80, 129).addBox(4.5F, 0.4412F, 53.5F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(70, 125).addBox(-4.5F, 0.4412F, 57.5F, 9.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(123, 133).addBox(-5.5F, -4.5588F, 57.5F, 11.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 30).addBox(-6.5F, -9.5588F, 49.5F, 13.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(99, 32).addBox(6.5F, -7.5588F, 49.5F, 3.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(114, 0).addBox(-6.5F, -6.5588F, 54.5F, 13.0F, 7.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(99, 61).addBox(-9.5F, -7.5588F, 49.5F, 3.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(100, 120).addBox(-10.5F, -5.5588F, 49.5F, 4.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.8713F, 53.1563F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition lower_jaw = jaw.addOrReplaceChild("lower_jaw", CubeListBuilder.create(), PartPose.offset(-0.5F, 1.6875F, -117.6563F));

		PartDefinition cube_r5 = lower_jaw.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 0).addBox(6.5F, 0.4412F, 49.5F, 4.0F, 6.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(73, 32).addBox(-5.5F, 0.4412F, 57.5F, 11.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 22).addBox(-6.5F, 7.4412F, 49.5F, 13.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 11).addBox(6.5F, 6.4412F, 49.5F, 3.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(76, 87).addBox(-6.5F, 0.4412F, 54.5F, 13.0F, 7.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(20, 11).addBox(-9.5F, 6.4412F, 49.5F, 3.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(20, 0).addBox(-10.5F, 0.4412F, 49.5F, 4.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.7537F, 53.1563F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition cube_r6 = lower_jaw.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(13, 0).addBox(9.5F, -0.4412F, 48.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(20, 0).addBox(-10.5F, -0.4412F, 48.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(126, 10).addBox(5.5F, -0.4412F, 52.5F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(128, 68).addBox(-8.5F, -0.4412F, 52.5F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(18, 127).addBox(-9.5F, -0.4412F, 49.5F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(128, 61).addBox(8.5F, -0.4412F, 49.5F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(70, 129).addBox(-5.5F, -0.4412F, 53.5F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(80, 129).addBox(4.5F, -0.4412F, 53.5F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(70, 125).addBox(-4.5F, -0.4412F, 57.5F, 9.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.7537F, 53.1563F, -3.1416F, 0.0F, 0.0F));

		PartDefinition tail = armisor.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition bone5 = tail.addOrReplaceChild("bone5", CubeListBuilder.create(), PartPose.offset(0.0F, -10.0F, 7.0F));

		PartDefinition cube_r7 = bone5.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 56).addBox(-7.5F, -9.5588F, -9.5F, 15.0F, 20.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.4412F, -7.0F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition bone6 = tail.addOrReplaceChild("bone6", CubeListBuilder.create(), PartPose.offset(0.0F, -9.5F, 12.0F));

		PartDefinition cube_r8 = bone6.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(0, 103).addBox(-5.5F, -8.5588F, -14.5F, 11.0F, 19.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.9412F, -12.0F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition bone7 = tail.addOrReplaceChild("bone7", CubeListBuilder.create(), PartPose.offset(0.0F, -9.5F, 17.0F));

		PartDefinition cube_r9 = bone7.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(128, 76).addBox(-4.5F, -8.5588F, -19.5F, 9.0F, 19.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.9412F, -17.0F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition bone8 = tail.addOrReplaceChild("bone8", CubeListBuilder.create(), PartPose.offset(0.0F, -9.5F, 24.0F));

		PartDefinition cube_r10 = bone8.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(76, 61).addBox(-3.5F, -7.5588F, -28.5F, 7.0F, 17.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.9412F, -24.0F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition bone9 = tail.addOrReplaceChild("bone9", CubeListBuilder.create(), PartPose.offset(0.0F, -9.0F, 31.0F));

		PartDefinition cube_r11 = bone9.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(73, 0).addBox(-2.5F, -6.5588F, -33.5F, 5.0F, 16.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.4412F, -31.0F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition tail_fin = armisor.addOrReplaceChild("tail_fin", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition bone10 = tail_fin.addOrReplaceChild("bone10", CubeListBuilder.create(), PartPose.offset(0.0F, -9.0F, 34.5F));

		PartDefinition cube_r12 = bone10.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(52, 103).addBox(-0.5F, -5.5588F, -35.5F, 1.0F, 14.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.4412F, -34.5F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition bone12 = tail_fin.addOrReplaceChild("bone12", CubeListBuilder.create(), PartPose.offset(0.0F, -9.0F, 39.0F));

		PartDefinition cube_r13 = bone12.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(108, 131).addBox(-0.5F, 8.4412F, -40.5F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(92, 45).addBox(-0.5F, -5.5588F, -40.5F, 1.0F, 14.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(113, 134).addBox(-0.5F, -8.5588F, -40.5F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.4412F, -39.0F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition bone11 = tail_fin.addOrReplaceChild("bone11", CubeListBuilder.create(), PartPose.offset(0.0F, -9.0F, 36.5F));

		PartDefinition cube_r14 = bone11.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(0, 56).addBox(-0.5F, 8.4412F, -37.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(35, 37).addBox(-0.5F, 8.4412F, -36.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(36, 81).addBox(-0.5F, -5.5588F, -37.5F, 1.0F, 14.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 59).addBox(-0.5F, -6.5588F, -36.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(73, 0).addBox(-0.5F, -7.5588F, -37.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.4412F, -36.5F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition bone13 = tail_fin.addOrReplaceChild("bone13", CubeListBuilder.create(), PartPose.offset(0.0F, -9.0F, 41.8333F));

		PartDefinition cube_r15 = bone13.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(140, 35).addBox(-0.5F, 5.4412F, -43.5F, 1.0F, 7.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 25).addBox(-0.5F, 4.4412F, -42.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 22).addBox(-0.5F, 3.4412F, -41.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 30).addBox(-0.5F, -2.5588F, -41.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 33).addBox(-0.5F, -2.5588F, -42.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 81).addBox(-0.5F, -9.5588F, -45.5F, 1.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.4412F, -41.8333F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition bone15 = tail_fin.addOrReplaceChild("bone15", CubeListBuilder.create(), PartPose.offset(0.0F, -19.0F, 51.5F));

		PartDefinition cube_r16 = bone15.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(50, 2).addBox(-0.5F, -11.5588F, -53.5F, 1.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 8.5588F, -51.5F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition bone16 = tail_fin.addOrReplaceChild("bone16", CubeListBuilder.create(), PartPose.offset(0.0F, -20.5F, 54.5F));

		PartDefinition cube_r17 = bone16.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(70, 113).addBox(-0.5F, -12.5588F, -55.5F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 10.0588F, -54.5F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition bone17 = tail_fin.addOrReplaceChild("bone17", CubeListBuilder.create(), PartPose.offset(0.0F, -22.0F, 57.5F));

		PartDefinition cube_r18 = bone17.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(35, 56).addBox(-0.5F, -13.5588F, -59.5F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(112, 49).addBox(-0.5F, -13.5588F, -57.5F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 11.5588F, -57.5F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition bone14 = tail_fin.addOrReplaceChild("bone14", CubeListBuilder.create(), PartPose.offset(0.0F, -3.75F, 45.625F));

		PartDefinition cube_r19 = bone14.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(20, 11).addBox(-0.5F, 11.4412F, -46.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(123, 120).addBox(-0.5F, 6.4412F, -44.5F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(145, 35).addBox(-0.5F, 8.4412F, -45.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(96, 0).addBox(-0.5F, -10.5588F, -49.5F, 1.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.6912F, -45.625F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition fin = armisor.addOrReplaceChild("fin", CubeListBuilder.create(), PartPose.offsetAndRotation(-13.0F, 0.1706F, -12.4899F, 0.1745F, 0.0F, 0.0F));

		PartDefinition cube_r20 = fin.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(110, 61).addBox(12.5F, 12.6194F, -2.3426F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(28, 130).addBox(12.5F, 10.6194F, 0.6574F, 1.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(112, 39).addBox(12.5F, 7.6194F, 27.6574F, 1.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(108, 79).addBox(12.5F, 8.6194F, 3.6574F, 1.0F, 8.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(100, 120).addBox(12.5F, 6.6194F, 6.6574F, 1.0F, 11.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.0F, -8.2817F, 14.1429F, -2.7925F, 0.0F, -3.1416F));

		PartDefinition fin2 = armisor.addOrReplaceChild("fin2", CubeListBuilder.create(), PartPose.offsetAndRotation(13.0F, 0.1706F, -12.4899F, 0.1745F, 0.0F, 0.0F));

		PartDefinition cube_r21 = fin2.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(110, 32).addBox(-13.5F, 12.6194F, -2.3426F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(76, 61).addBox(-13.5F, 10.6194F, 0.6574F, 1.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(70, 103).addBox(-13.5F, 7.6194F, 27.6574F, 1.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(108, 68).addBox(-13.5F, 8.6194F, 3.6574F, 1.0F, 8.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(73, 0).addBox(-13.5F, 6.6194F, 6.6574F, 1.0F, 11.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-13.0F, -8.2817F, 14.1429F, -2.7925F, 0.0F, -3.1416F));

		PartDefinition fin3 = armisor.addOrReplaceChild("fin3", CubeListBuilder.create(), PartPose.offset(0.0F, -23.25F, -11.5F));

		PartDefinition cube_r22 = fin3.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(76, 129).addBox(-0.5F, -12.5588F, -3.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(31, 22).addBox(-0.5F, -13.5588F, 25.5F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(31, 30).addBox(-0.5F, -13.5588F, -0.5F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(33, 0).addBox(-0.5F, -14.5588F, 23.5F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(100, 131).addBox(-0.5F, -14.5588F, 2.5F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-0.5F, -15.5588F, 5.5F, 1.0F, 4.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 12.8088F, 11.5F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition fin4 = armisor.addOrReplaceChild("fin4", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 2.8948F, -5.9914F, 0.0436F, 0.0F, 0.0F));

		PartDefinition cube_r23 = fin4.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(11, 11).addBox(-0.5F, 10.8359F, -2.4914F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(52, 104).addBox(-0.5F, 10.8359F, -18.4914F, 1.0F, 5.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -13.0619F, 6.5674F, -3.098F, 0.0F, 3.1416F));

		PartDefinition bone3 = fin4.addOrReplaceChild("bone3", CubeListBuilder.create(), PartPose.offset(0.5F, 16.2553F, 6.5353F));

		PartDefinition cube_r24 = bone3.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(27, 92).addBox(-0.5F, 11.8359F, -21.4914F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -29.3172F, 0.0321F, -3.098F, 0.0F, 3.1416F));

		PartDefinition bone4 = fin4.addOrReplaceChild("bone4", CubeListBuilder.create(), PartPose.offset(0.5F, 16.2553F, 6.5353F));

		PartDefinition cube_r25 = bone4.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(31, 11).addBox(-0.5F, 11.8359F, -24.4914F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -29.3172F, 0.0321F, -3.098F, 0.0F, 3.1416F));

		return LayerDefinition.create(meshdefinition, 256, 256);


	}


	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		armisor.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public void setupAnim(T pEntity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);
		this.animate(ArmisorEntity.idleAnimationState, ModAnimationDefinitions.IDLE_LOOK, ageInTicks, 1f);
		this.animate(((ArmisorEntity) pEntity).swimIdleAnimationState, ModAnimationDefinitions.SWIM, ageInTicks, 1f);
		this.animate(((ArmisorEntity) pEntity).attackAnimationState, ModAnimationDefinitions.EAT, ageInTicks, 2f);
		if (((ArmisorEntity) pEntity).isMoving()) {
			float f = ageInTicks - (float) pEntity.tickCount;
			float f2 = ((ArmisorEntity) pEntity).getSwimAnimation(f);
		}
	}

	private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
		pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

		this.head.yRot = pNetHeadYaw * ((float)Math.PI / 3600F);
		this.head.xRot = pHeadPitch * ((float)Math.PI / 3600F);
	}


	@Override
	public ModelPart root() {
		return armisor;
	}

	public ModelPart getHead() {
		return head;
	}
}