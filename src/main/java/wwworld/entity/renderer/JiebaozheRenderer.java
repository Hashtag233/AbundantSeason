package wwworld.entity.renderer;

import wwworld.entity.JiebaozheEntity;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class JiebaozheRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(JiebaozheEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modeljiebaozhe(), 0.5f) {

					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("wwworld:textures/jiebaozhe.png");
					}
				};
			});
		}
	}

	// Made with Blockbench 3.9.2
	// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
	// Paste this class into your mod and generate all required imports
	public static class Modeljiebaozhe extends EntityModel<Entity> {
		private final ModelRenderer head;
		private final ModelRenderer body;
		private final ModelRenderer left_arm;
		private final ModelRenderer right_arm;
		private final ModelRenderer left_leg;
		private final ModelRenderer right_leg;

		public Modeljiebaozhe() {
			textureWidth = 64;
			textureHeight = 64;
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, 0.0F, 0.0F);
			head.setTextureOffset(0, 0).addBox(-5.0F, -8.0F, -4.0F, 10.0F, 8.0F, 8.0F, 0.0F, false);
			head.setTextureOffset(31, 1).addBox(-2.0F, -4.0F, -5.0F, 4.0F, 3.0F, 1.0F, 0.0F, false);
			head.setTextureOffset(2, 0).addBox(-3.0F, -2.0F, -6.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
			head.setTextureOffset(2, 0).addBox(2.0F, -2.0F, -6.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
			head.setTextureOffset(51, 6).addBox(5.0F, -11.0F, -2.0F, 1.0F, 5.0F, 4.0F, 0.0F, false);
			head.setTextureOffset(39, 6).addBox(-6.0F, -11.0F, -2.0F, 1.0F, 5.0F, 4.0F, 0.0F, false);
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 0.0F, 0.0F);
			body.setTextureOffset(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);
			body.setTextureOffset(9, 24).addBox(0.0F, 11.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			body.setTextureOffset(8, 24).addBox(0.0F, 10.0F, 3.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
			body.setTextureOffset(8, 34).addBox(-3.0F, 0.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			body.setTextureOffset(8, 34).addBox(-3.0F, 1.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			body.setTextureOffset(8, 34).addBox(-2.0F, 2.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			body.setTextureOffset(8, 34).addBox(2.0F, 0.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			body.setTextureOffset(8, 34).addBox(2.0F, 1.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			body.setTextureOffset(45, 35).addBox(-3.0F, 5.0F, -4.0F, 6.0F, 6.0F, 2.0F, 0.0F, false);
			left_arm = new ModelRenderer(this);
			left_arm.setRotationPoint(4.0F, 2.0F, 0.0F);
			left_arm.setTextureOffset(40, 16).addBox(0.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
			left_arm.setTextureOffset(0, 36).addBox(1.0F, 7.0F, -12.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);
			left_arm.setTextureOffset(4, 51).addBox(1.0F, 6.0F, -11.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
			left_arm.setTextureOffset(4, 51).addBox(2.0F, 7.0F, -11.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
			left_arm.setTextureOffset(4, 51).addBox(0.0F, 7.0F, -11.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
			left_arm.setTextureOffset(4, 51).addBox(1.0F, 8.0F, -11.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
			right_arm = new ModelRenderer(this);
			right_arm.setRotationPoint(-4.0F, 2.0F, 0.0F);
			right_arm.setTextureOffset(40, 16).addBox(-4.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
			left_leg = new ModelRenderer(this);
			left_leg.setRotationPoint(2.0F, 12.0F, 0.0F);
			left_leg.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
			right_leg = new ModelRenderer(this);
			right_leg.setRotationPoint(-2.0F, 12.0F, 0.0F);
			right_leg.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			head.render(matrixStack, buffer, packedLight, packedOverlay);
			body.render(matrixStack, buffer, packedLight, packedOverlay);
			left_arm.render(matrixStack, buffer, packedLight, packedOverlay);
			right_arm.render(matrixStack, buffer, packedLight, packedOverlay);
			left_leg.render(matrixStack, buffer, packedLight, packedOverlay);
			right_leg.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {

			this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.right_arm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.left_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.left_arm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
			this.right_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		}
	}

}
