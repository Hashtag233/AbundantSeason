package wwworld.entity.renderer;

import wwworld.entity.LiulangguiEntity;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class LiulangguiRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(LiulangguiEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelliulangkulou(), 0.5f) {

					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("wwworld:textures/liulangkulou.png");
					}
				};
			});
		}
	}

	// Made with Blockbench 4.1.2
	// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
	// Paste this class into your mod and generate all required imports
	public static class Modelliulangkulou extends EntityModel<Entity> {
		private final ModelRenderer head;
		private final ModelRenderer body;
		private final ModelRenderer tengwan3_r1;
		private final ModelRenderer tengwan2_r1;
		private final ModelRenderer left_arm;
		private final ModelRenderer left_arm_r1;
		private final ModelRenderer right_arm;
		private final ModelRenderer right_arm_r1;

		public Modelliulangkulou() {
			textureWidth = 64;
			textureHeight = 32;
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, 23.0F, -9.0F);
			setRotationAngle(head, -0.0128F, 0.0131F, -0.0068F);
			head.setTextureOffset(0, 0).addBox(-4.0F, -7.0F, -1.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
			head.setTextureOffset(53, 0).addBox(1.0F, -13.0F, 0.0F, 0.0F, 6.0F, 5.0F, 0.0F, false);
			head.setTextureOffset(53, 6).addBox(-2.0F, -12.0F, 3.0F, 0.0F, 5.0F, 5.0F, 0.0F, false);
			head.setTextureOffset(54, 16).addBox(-2.0F, -12.0F, 3.0F, 5.0F, 5.0F, 0.0F, 0.0F, false);
			head.setTextureOffset(58, 23).addBox(0.0F, -12.0F, 2.0F, 3.0F, 5.0F, 0.0F, 0.0F, false);
			head.setTextureOffset(58, 23).addBox(-4.0F, -12.0F, 5.0F, 3.0F, 5.0F, 0.0F, 0.0F, false);
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 21.0F, -2.0F);
			setRotationAngle(body, 1.4399F, 0.0F, 0.0F);
			body.setTextureOffset(16, 16).addBox(-4.0F, 0.0F, -3.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);
			tengwan3_r1 = new ModelRenderer(this);
			tengwan3_r1.setRotationPoint(0.0F, 31.0F, 7.0F);
			body.addChild(tengwan3_r1);
			setRotationAngle(tengwan3_r1, -1.5268F, 0.0009F, 0.0057F);
			tengwan3_r1.setTextureOffset(54, 16).addBox(-2.0F, 0.0F, -21.0F, 5.0F, 5.0F, 0.0F, 0.0F, false);
			tengwan2_r1 = new ModelRenderer(this);
			tengwan2_r1.setRotationPoint(0.0F, 31.0F, 7.0F);
			body.addChild(tengwan2_r1);
			setRotationAngle(tengwan2_r1, -1.5708F, 0.0F, 0.0F);
			tengwan2_r1.setTextureOffset(53, 0).addBox(0.0F, 1.0F, -23.0F, 0.0F, 5.0F, 5.0F, 0.0F, false);
			left_arm = new ModelRenderer(this);
			left_arm.setRotationPoint(4.0F, 12.0F, 0.0F);
			setRotationAngle(left_arm, -1.4835F, 0.0F, 0.0F);
			left_arm_r1 = new ModelRenderer(this);
			left_arm_r1.setRotationPoint(-4.0F, 22.0F, 0.0F);
			left_arm.addChild(left_arm_r1);
			setRotationAngle(left_arm_r1, -0.2593F, 0.0112F, -0.0254F);
			left_arm_r1.setTextureOffset(40, 16).addBox(4.0F, -22.0F, 5.0F, 2.0F, 12.0F, 2.0F, 0.0F, true);
			right_arm = new ModelRenderer(this);
			right_arm.setRotationPoint(-4.0F, 12.0F, 0.0F);
			setRotationAngle(right_arm, -1.4835F, 0.0F, 0.0F);
			right_arm_r1 = new ModelRenderer(this);
			right_arm_r1.setRotationPoint(4.0F, 22.0F, 0.0F);
			right_arm.addChild(right_arm_r1);
			setRotationAngle(right_arm_r1, -0.2516F, 0.0189F, 0.0141F);
			right_arm_r1.setTextureOffset(40, 16).addBox(-6.0F, -22.0F, 5.0F, 2.0F, 12.0F, 2.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			head.render(matrixStack, buffer, packedLight, packedOverlay);
			body.render(matrixStack, buffer, packedLight, packedOverlay);
			left_arm.render(matrixStack, buffer, packedLight, packedOverlay);
			right_arm.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
		}
	}

}
