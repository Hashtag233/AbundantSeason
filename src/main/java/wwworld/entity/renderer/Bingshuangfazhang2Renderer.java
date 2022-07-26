package wwworld.entity.renderer;

import wwworld.item.Bingshuangfazhang2Item;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.IRenderTypeBuffer;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class Bingshuangfazhang2Renderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(Bingshuangfazhang2Item.arrow, renderManager -> new CustomRender(renderManager));
		}
	}

	@OnlyIn(Dist.CLIENT)
	public static class CustomRender extends EntityRenderer<Bingshuangfazhang2Item.ArrowCustomEntity> {
		private static final ResourceLocation texture = new ResourceLocation("wwworld:textures/bingzidan.png");

		public CustomRender(EntityRendererManager renderManager) {
			super(renderManager);
		}

		@Override
		public void render(Bingshuangfazhang2Item.ArrowCustomEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
				IRenderTypeBuffer bufferIn, int packedLightIn) {
			IVertexBuilder vb = bufferIn.getBuffer(RenderType.getEntityCutout(this.getEntityTexture(entityIn)));
			matrixStackIn.push();
			matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationYaw, entityIn.rotationYaw) - 90));
			matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90 + MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch)));
			EntityModel model = new Modelbingzidan();
			model.render(matrixStackIn, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.0625f);
			matrixStackIn.pop();
			super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
		}

		@Override
		public ResourceLocation getEntityTexture(Bingshuangfazhang2Item.ArrowCustomEntity entity) {
			return texture;
		}
	}

	// Made with Blockbench 3.8.4
	// Exported for Minecraft version 1.15 - 1.16
	// Paste this class into your mod and generate all required imports
	public static class Modelbingzidan extends EntityModel<Entity> {
		private final ModelRenderer big_ball;
		private final ModelRenderer cube_r1;
		private final ModelRenderer cube_r2;
		private final ModelRenderer small_ball;
		private final ModelRenderer cube_r3;
		private final ModelRenderer cube_r4;
		private final ModelRenderer cube_r5;
		private final ModelRenderer cube_r6;
		private final ModelRenderer cube_r7;
		private final ModelRenderer cube_r8;
		private final ModelRenderer cube_r9;
		private final ModelRenderer cube_r10;
		private final ModelRenderer cube_r11;
		private final ModelRenderer cube_r12;
		private final ModelRenderer cube_r13;
		private final ModelRenderer cube_r14;
		private final ModelRenderer cube_r15;
		private final ModelRenderer cube_r16;

		public Modelbingzidan() {
			textureWidth = 64;
			textureHeight = 64;
			big_ball = new ModelRenderer(this);
			big_ball.setRotationPoint(0.0F, 24.0F, 0.0F);
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(-0.5F, -13.5F, 0.5F);
			big_ball.addChild(cube_r1);
			setRotationAngle(cube_r1, 0.1309F, 0.1309F, -0.1309F);
			cube_r1.setTextureOffset(0, 54).addBox(-2.5F, -2.5F, -2.5F, 5.0F, 5.0F, 5.0F, 0.0F, false);
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(-0.5F, -13.5F, 0.5F);
			big_ball.addChild(cube_r2);
			setRotationAngle(cube_r2, -0.3927F, 0.3927F, -0.3927F);
			cube_r2.setTextureOffset(52, 58).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, 0.0F, false);
			small_ball = new ModelRenderer(this);
			small_ball.setRotationPoint(0.0F, 24.0F, 0.0F);
			cube_r3 = new ModelRenderer(this);
			cube_r3.setRotationPoint(-0.3926F, -11.2834F, -4.0883F);
			small_ball.addChild(cube_r3);
			setRotationAngle(cube_r3, -2.0508F, -0.7854F, -0.3054F);
			cube_r3.setTextureOffset(0, 0).addBox(0.8231F, -0.5744F, 1.3347F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r4 = new ModelRenderer(this);
			cube_r4.setRotationPoint(-7.0714F, -14.9556F, -1.0831F);
			small_ball.addChild(cube_r4);
			setRotationAngle(cube_r4, 0.0F, 8.3776F, -0.3054F);
			cube_r4.setTextureOffset(0, 0).addBox(0.7188F, -2.8186F, 2.2437F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r4.setTextureOffset(0, 0).addBox(-1.0537F, -2.2548F, 0.056F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r4.setTextureOffset(0, 0).addBox(-2.2812F, 0.4834F, -0.5371F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r5 = new ModelRenderer(this);
			cube_r5.setRotationPoint(4.9286F, -14.9556F, -1.0831F);
			small_ball.addChild(cube_r5);
			setRotationAngle(cube_r5, 0.0F, 8.3776F, -0.3054F);
			cube_r5.setTextureOffset(0, 0).addBox(0.7188F, -2.8186F, -0.7563F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r5.setTextureOffset(0, 0).addBox(-1.0537F, -2.2548F, 0.056F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r5.setTextureOffset(0, 0).addBox(-2.2812F, 0.4834F, -0.5371F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r6 = new ModelRenderer(this);
			cube_r6.setRotationPoint(-0.1254F, -17.1459F, 0.3335F);
			small_ball.addChild(cube_r6);
			setRotationAngle(cube_r6, 1.6581F, 0.48F, -0.3054F);
			cube_r6.setTextureOffset(0, 0).addBox(0.1F, -0.3646F, 0.5712F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r7 = new ModelRenderer(this);
			cube_r7.setRotationPoint(-1.5F, -8.5F, 3.5F);
			small_ball.addChild(cube_r7);
			setRotationAngle(cube_r7, 0.3927F, 0.2618F, -0.3054F);
			cube_r7.setTextureOffset(0, 0).addBox(2.5F, -3.5F, 3.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r8 = new ModelRenderer(this);
			cube_r8.setRotationPoint(-0.3926F, -11.2834F, -4.0883F);
			small_ball.addChild(cube_r8);
			setRotationAngle(cube_r8, -2.3126F, -0.7854F, -0.3054F);
			cube_r8.setTextureOffset(0, 0).addBox(1.8231F, -5.1136F, 0.1657F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r8.setTextureOffset(0, 0).addBox(-3.1769F, -2.1136F, 0.1657F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r9 = new ModelRenderer(this);
			cube_r9.setRotationPoint(-0.1254F, -17.1459F, 0.3335F);
			small_ball.addChild(cube_r9);
			setRotationAngle(cube_r9, 1.3963F, 0.48F, -0.3054F);
			cube_r9.setTextureOffset(0, 0).addBox(1.1F, -4.7134F, -0.5174F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r9.setTextureOffset(0, 0).addBox(-3.9F, -1.7134F, -0.5174F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r9.setTextureOffset(0, 0).addBox(-2.9F, 3.2866F, -1.5174F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r10 = new ModelRenderer(this);
			cube_r10.setRotationPoint(-0.3926F, -11.2834F, -4.0883F);
			small_ball.addChild(cube_r10);
			setRotationAngle(cube_r10, 2.7053F, -1.0036F, -0.3054F);
			cube_r10.setTextureOffset(0, 0).addBox(-0.4508F, -1.2589F, 2.1816F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r10.setTextureOffset(0, 0).addBox(-1.4508F, 4.7411F, -3.8184F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r11 = new ModelRenderer(this);
			cube_r11.setRotationPoint(-1.5F, -8.5F, 3.5F);
			small_ball.addChild(cube_r11);
			setRotationAngle(cube_r11, 0.1309F, 0.2618F, -0.3054F);
			cube_r11.setTextureOffset(0, 0).addBox(3.5F, -8.5F, 1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r11.setTextureOffset(0, 0).addBox(-1.5F, -5.5F, 1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r11.setTextureOffset(0, 0).addBox(-0.5F, -0.5F, 0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r12 = new ModelRenderer(this);
			cube_r12.setRotationPoint(-0.3926F, -11.2834F, -4.0883F);
			small_ball.addChild(cube_r12);
			setRotationAngle(cube_r12, -2.138F, -0.6109F, -0.6109F);
			cube_r12.setTextureOffset(0, 0).addBox(3.2944F, 2.2655F, -0.2567F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r13 = new ModelRenderer(this);
			cube_r13.setRotationPoint(-0.1254F, -17.1459F, 0.3335F);
			small_ball.addChild(cube_r13);
			setRotationAngle(cube_r13, 1.5708F, 0.6545F, -0.6109F);
			cube_r13.setTextureOffset(0, 0).addBox(2.3762F, 2.2899F, -0.81F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r14 = new ModelRenderer(this);
			cube_r14.setRotationPoint(-7.0714F, -14.9556F, -1.0831F);
			small_ball.addChild(cube_r14);
			setRotationAngle(cube_r14, 0.0F, 8.3776F, -0.6109F);
			cube_r14.setTextureOffset(0, 0).addBox(-0.4655F, 3.9798F, -1.0935F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r15 = new ModelRenderer(this);
			cube_r15.setRotationPoint(4.9286F, -14.9556F, -1.0831F);
			small_ball.addChild(cube_r15);
			setRotationAngle(cube_r15, 0.0F, 8.3776F, -0.6109F);
			cube_r15.setTextureOffset(0, 0).addBox(-0.4655F, 3.9798F, -5.0935F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r16 = new ModelRenderer(this);
			cube_r16.setRotationPoint(3.7776F, -12.5169F, 3.6103F);
			small_ball.addChild(cube_r16);
			setRotationAngle(cube_r16, 0.3054F, 0.4363F, -0.6109F);
			cube_r16.setTextureOffset(0, 0).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			big_ball.render(matrixStack, buffer, packedLight, packedOverlay);
			small_ball.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {

			this.cube_r10.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.cube_r4.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.cube_r15.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.cube_r5.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.cube_r16.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.cube_r6.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.cube_r7.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.cube_r11.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.cube_r1.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.cube_r12.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.cube_r2.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.cube_r13.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.cube_r3.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.cube_r14.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.cube_r8.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.cube_r9.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.small_ball.rotateAngleY = f3 / (180F / (float) Math.PI);
		}
	}

}
