package wwworld.entity.renderer;

import wwworld.entity.HuoYanLongJuanFengEntity;

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
public class HuoYanLongJuanFengRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(HuoYanLongJuanFengEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelhuoyanlongjuanfeng(), 0.5f) {

					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("wwworld:textures/huoyanlongjuanfeng.png");
					}
				};
			});
		}
	}

	// Made with Blockbench 3.9.2
	// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
	// Paste this class into your mod and generate all required imports
	public static class Modelhuoyanlongjuanfeng extends EntityModel<Entity> {
		private final ModelRenderer body1;
		private final ModelRenderer body0;
		private final ModelRenderer cube_r1;
		private final ModelRenderer body2;
		private final ModelRenderer body3;
		private final ModelRenderer body4;
		private final ModelRenderer body5;
		private final ModelRenderer body6;
		private final ModelRenderer body7;
		private final ModelRenderer body_2_1;
		private final ModelRenderer cube_r2;
		private final ModelRenderer body_2_2;
		private final ModelRenderer cube_r3;
		private final ModelRenderer body_2_3;
		private final ModelRenderer cube_r4;
		private final ModelRenderer body_2_4;
		private final ModelRenderer cube_r5;
		private final ModelRenderer body_2_5;
		private final ModelRenderer cube_r6;
		private final ModelRenderer body_2_6;
		private final ModelRenderer cube_r7;
		private final ModelRenderer body_2_7;
		private final ModelRenderer cube_r8;
		private final ModelRenderer body_2_8;
		private final ModelRenderer cube_r9;
		private final ModelRenderer eyes;
		private final ModelRenderer zhuan;

		public Modelhuoyanlongjuanfeng() {
			textureWidth = 256;
			textureHeight = 256;
			body1 = new ModelRenderer(this);
			body1.setRotationPoint(0.0F, 24.0F, 0.0F);
			body1.setTextureOffset(0, 7).addBox(-3.0F, -7.0F, -1.85F, 5.0F, 1.0F, 5.0F, 0.0F, false);
			body0 = new ModelRenderer(this);
			body0.setRotationPoint(0.5F, -21.5F, -0.25F);
			body1.addChild(body0);
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(-1.0F, 16.0F, 0.9F);
			body0.addChild(cube_r1);
			setRotationAngle(cube_r1, 0.0F, -0.2618F, 0.0F);
			cube_r1.setTextureOffset(0, 29).addBox(-2.0F, -0.5F, -2.0F, 4.0F, 1.0F, 4.0F, 0.0F, false);
			body2 = new ModelRenderer(this);
			body2.setRotationPoint(0.5F, 22.5F, -0.25F);
			setRotationAngle(body2, 0.0F, -0.2618F, 0.0F);
			body2.setTextureOffset(0, 0).addBox(-3.733F, -6.5F, -1.8718F, 6.0F, 1.0F, 6.0F, 0.0F, false);
			body2.setTextureOffset(30, 83).addBox(-5.733F, -12.5F, -3.8718F, 10.0F, 1.0F, 10.0F, 0.0F, false);
			body3 = new ModelRenderer(this);
			body3.setRotationPoint(0.5F, 21.5F, -0.25F);
			setRotationAngle(body3, 0.0F, -0.5236F, 0.0F);
			body3.setTextureOffset(96, 48).addBox(-3.916F, -6.5F, -2.2206F, 7.0F, 1.0F, 7.0F, 0.0F, false);
			body3.setTextureOffset(78, 13).addBox(-5.916F, -12.5F, -4.2206F, 11.0F, 1.0F, 11.0F, 0.0F, false);
			body4 = new ModelRenderer(this);
			body4.setRotationPoint(0.5F, 20.5F, -0.25F);
			setRotationAngle(body4, 0.0F, -0.7854F, 0.0F);
			body4.setTextureOffset(32, 96).addBox(-4.0707F, -6.5F, -2.6565F, 8.0F, 1.0F, 8.0F, 0.0F, false);
			body4.setTextureOffset(78, 0).addBox(-6.0707F, -12.5F, -4.6565F, 12.0F, 1.0F, 12.0F, 0.0F, false);
			body5 = new ModelRenderer(this);
			body5.setRotationPoint(1.0F, 19.5F, 0.25F);
			setRotationAngle(body5, 0.0F, -1.0472F, 0.0F);
			body5.setTextureOffset(88, 94).addBox(-4.7206F, -6.5F, -2.684F, 9.0F, 1.0F, 9.0F, 0.0F, false);
			body6 = new ModelRenderer(this);
			body6.setRotationPoint(0.0F, 18.5F, 0.25F);
			setRotationAngle(body6, 0.0F, -1.309F, 0.0F);
			body6.setTextureOffset(61, 93).addBox(-3.8895F, -6.5F, -3.3011F, 9.0F, 1.0F, 9.0F, 0.0F, false);
			body7 = new ModelRenderer(this);
			body7.setRotationPoint(0.2F, 17.5F, 0.35F);
			setRotationAngle(body7, 0.0F, -1.5708F, 0.0F);
			body7.setTextureOffset(0, 93).addBox(-4.1019F, -6.5F, -3.9451F, 10.0F, 1.0F, 10.0F, 0.0F, false);
			body_2_1 = new ModelRenderer(this);
			body_2_1.setRotationPoint(0.0F, 12.0F, -0.25F);
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(-1.0F, -1.0F, 1.0F);
			body_2_1.addChild(cube_r2);
			setRotationAngle(cube_r2, 0.0F, -0.2618F, 0.0F);
			cube_r2.setTextureOffset(57, 103).addBox(-3.0F, 8.0F, -3.5F, 7.0F, 3.0F, 7.0F, 0.0F, false);
			body_2_2 = new ModelRenderer(this);
			body_2_2.setRotationPoint(0.0F, 0.0F, 0.0F);
			body_2_1.addChild(body_2_2);
			cube_r3 = new ModelRenderer(this);
			cube_r3.setRotationPoint(-1.0F, -1.0F, 1.0F);
			body_2_2.addChild(cube_r3);
			setRotationAngle(cube_r3, 0.0F, -0.2618F, 0.0F);
			cube_r3.setTextureOffset(0, 80).addBox(-4.5F, 5.0F, -5.0F, 10.0F, 3.0F, 10.0F, 0.0F, false);
			body_2_3 = new ModelRenderer(this);
			body_2_3.setRotationPoint(0.483F, -7.0F, 0.1294F);
			body_2_1.addChild(body_2_3);
			cube_r4 = new ModelRenderer(this);
			cube_r4.setRotationPoint(-1.0F, -1.0F, 1.0F);
			body_2_3.addChild(cube_r4);
			setRotationAngle(cube_r4, 0.0F, -0.5236F, 0.0F);
			cube_r4.setTextureOffset(71, 77).addBox(-6.5F, 9.0F, -6.5F, 13.0F, 3.0F, 13.0F, 0.0F, false);
			body_2_4 = new ModelRenderer(this);
			body_2_4.setRotationPoint(0.483F, -7.0F, 0.1294F);
			body_2_1.addChild(body_2_4);
			cube_r5 = new ModelRenderer(this);
			cube_r5.setRotationPoint(-1.0F, -1.0F, 1.0F);
			body_2_4.addChild(cube_r5);
			setRotationAngle(cube_r5, 0.0F, -0.5236F, 0.0F);
			cube_r5.setTextureOffset(72, 29).addBox(-8.0F, 6.0F, -8.0F, 16.0F, 3.0F, 16.0F, 0.0F, false);
			body_2_5 = new ModelRenderer(this);
			body_2_5.setRotationPoint(1.233F, -11.0F, -0.3706F);
			body_2_1.addChild(body_2_5);
			setRotationAngle(body_2_5, 0.0F, -0.2618F, 0.0F);
			cube_r6 = new ModelRenderer(this);
			cube_r6.setRotationPoint(-1.0F, 2.0F, -1.0F);
			body_2_5.addChild(cube_r6);
			setRotationAngle(cube_r6, 0.0F, -0.5236F, 0.0F);
			cube_r6.setTextureOffset(63, 56).addBox(-7.2929F, 4.0F, -5.8787F, 18.0F, 3.0F, 18.0F, 0.0F, false);
			body_2_6 = new ModelRenderer(this);
			body_2_6.setRotationPoint(3.733F, -13.0F, -0.1206F);
			body_2_1.addChild(body_2_6);
			setRotationAngle(body_2_6, 0.0F, -0.2618F, 0.0F);
			cube_r7 = new ModelRenderer(this);
			cube_r7.setRotationPoint(-1.0F, 2.0F, -1.0F);
			body_2_6.addChild(cube_r7);
			setRotationAngle(cube_r7, 0.0F, -0.5236F, 0.0F);
			cube_r7.setTextureOffset(0, 56).addBox(-10.2929F, 3.0F, -5.8787F, 21.0F, 3.0F, 21.0F, 0.0F, false);
			body_2_7 = new ModelRenderer(this);
			body_2_7.setRotationPoint(2.9401F, -15.0F, 3.3365F);
			body_2_1.addChild(body_2_7);
			setRotationAngle(body_2_7, 0.0F, -0.5236F, 0.0F);
			cube_r8 = new ModelRenderer(this);
			cube_r8.setRotationPoint(1.2929F, 2.0F, -4.7071F);
			body_2_7.addChild(cube_r8);
			setRotationAngle(cube_r8, 0.0F, -0.5236F, 0.0F);
			cube_r8.setTextureOffset(0, 29).addBox(-12.9269F, 2.0F, -5.9269F, 24.0F, 3.0F, 24.0F, 0.0F, false);
			body_2_8 = new ModelRenderer(this);
			body_2_8.setRotationPoint(4.1401F, -17.0F, 3.6365F);
			body_2_1.addChild(body_2_8);
			setRotationAngle(body_2_8, 0.0F, -0.5236F, 0.0F);
			cube_r9 = new ModelRenderer(this);
			cube_r9.setRotationPoint(1.2929F, 2.0F, -4.7071F);
			body_2_8.addChild(cube_r9);
			setRotationAngle(cube_r9, 0.0F, -0.5236F, 0.0F);
			cube_r9.setTextureOffset(0, 0).addBox(-14.9269F, 1.0F, -5.9269F, 26.0F, 3.0F, 26.0F, 0.0F, false);
			eyes = new ModelRenderer(this);
			eyes.setRotationPoint(0.0F, 22.0F, 0.0F);
			eyes.setTextureOffset(16, 21).addBox(-5.0F, -12.0F, -11.0F, 2.0F, 3.0F, 1.0F, 0.0F, false);
			eyes.setTextureOffset(0, 0).addBox(1.0F, -12.0F, -11.0F, 2.0F, 3.0F, 1.0F, 0.0F, false);
			zhuan = new ModelRenderer(this);
			zhuan.setRotationPoint(-19.0F, 24.0F, 0.0F);
			zhuan.setTextureOffset(0, 4).addBox(6.0F, -8.0F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			zhuan.setTextureOffset(15, 7).addBox(5.8137F, -9.0F, -7.5743F, 2.0F, 1.0F, 2.0F, 0.0F, false);
			zhuan.setTextureOffset(12, 13).addBox(5.3182F, -10.0F, -7.8842F, 3.0F, 1.0F, 3.0F, 0.0F, false);
			zhuan.setTextureOffset(0, 13).addBox(4.1378F, -11.0F, -8.1527F, 4.0F, 1.0F, 4.0F, 0.0F, false);
			zhuan.setTextureOffset(15, 7).addBox(29.8137F, -9.0F, -7.5743F, 2.0F, 1.0F, 2.0F, 0.0F, false);
			zhuan.setTextureOffset(0, 4).addBox(30.0F, -8.0F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			zhuan.setTextureOffset(12, 13).addBox(29.3182F, -10.0F, -7.8842F, 3.0F, 1.0F, 3.0F, 0.0F, false);
			zhuan.setTextureOffset(0, 13).addBox(29.1378F, -11.0F, -8.1527F, 4.0F, 1.0F, 4.0F, 0.0F, false);
			zhuan.setTextureOffset(0, 4).addBox(6.0F, -8.0F, 14.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			zhuan.setTextureOffset(12, 13).addBox(5.3182F, -10.0F, 13.1158F, 3.0F, 1.0F, 3.0F, 0.0F, false);
			zhuan.setTextureOffset(0, 13).addBox(4.1378F, -11.0F, 12.8473F, 4.0F, 1.0F, 4.0F, 0.0F, false);
			zhuan.setTextureOffset(0, 4).addBox(30.0F, -8.0F, 14.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			zhuan.setTextureOffset(12, 13).addBox(29.3182F, -10.0F, 13.1158F, 3.0F, 1.0F, 3.0F, 0.0F, false);
			zhuan.setTextureOffset(0, 13).addBox(29.1378F, -11.0F, 12.8473F, 4.0F, 1.0F, 4.0F, 0.0F, false);
			zhuan.setTextureOffset(15, 7).addBox(29.8137F, -9.0F, 13.4257F, 2.0F, 1.0F, 2.0F, 0.0F, false);
			zhuan.setTextureOffset(15, 7).addBox(5.8137F, -9.0F, 13.4257F, 2.0F, 1.0F, 2.0F, 0.0F, false);
			zhuan.setTextureOffset(0, 4).addBox(-4.0F, -12.0F, 4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			zhuan.setTextureOffset(15, 7).addBox(-4.1863F, -13.0F, 3.4257F, 2.0F, 1.0F, 2.0F, 0.0F, false);
			zhuan.setTextureOffset(12, 13).addBox(-4.6818F, -14.0F, 3.1158F, 3.0F, 1.0F, 3.0F, 0.0F, false);
			zhuan.setTextureOffset(0, 13).addBox(-5.8622F, -15.0F, 2.8473F, 4.0F, 1.0F, 4.0F, 0.0F, false);
			zhuan.setTextureOffset(15, 7).addBox(18.8137F, -13.0F, 21.4257F, 2.0F, 1.0F, 2.0F, 0.0F, false);
			zhuan.setTextureOffset(0, 4).addBox(19.0F, -12.0F, 22.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			zhuan.setTextureOffset(12, 13).addBox(18.3182F, -14.0F, 21.1158F, 3.0F, 1.0F, 3.0F, 0.0F, false);
			zhuan.setTextureOffset(0, 4).addBox(40.0F, -12.0F, 3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			zhuan.setTextureOffset(0, 13).addBox(17.1378F, -15.0F, 20.8473F, 4.0F, 1.0F, 4.0F, 0.0F, false);
			zhuan.setTextureOffset(15, 7).addBox(39.8137F, -13.0F, 2.4257F, 2.0F, 1.0F, 2.0F, 0.0F, false);
			zhuan.setTextureOffset(12, 13).addBox(39.3182F, -14.0F, 2.1158F, 3.0F, 1.0F, 3.0F, 0.0F, false);
			zhuan.setTextureOffset(0, 13).addBox(38.1378F, -15.0F, 1.8473F, 4.0F, 1.0F, 4.0F, 0.0F, false);
			zhuan.setTextureOffset(0, 4).addBox(18.0F, -13.0F, -22.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			zhuan.setTextureOffset(12, 13).addBox(17.3182F, -15.0F, -22.8842F, 3.0F, 1.0F, 3.0F, 0.0F, false);
			zhuan.setTextureOffset(15, 7).addBox(17.8137F, -14.0F, -22.5743F, 2.0F, 1.0F, 2.0F, 0.0F, false);
			zhuan.setTextureOffset(0, 13).addBox(16.1378F, -16.0F, -23.1527F, 4.0F, 1.0F, 4.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			body1.render(matrixStack, buffer, packedLight, packedOverlay);
			body2.render(matrixStack, buffer, packedLight, packedOverlay);
			body3.render(matrixStack, buffer, packedLight, packedOverlay);
			body4.render(matrixStack, buffer, packedLight, packedOverlay);
			body5.render(matrixStack, buffer, packedLight, packedOverlay);
			body6.render(matrixStack, buffer, packedLight, packedOverlay);
			body7.render(matrixStack, buffer, packedLight, packedOverlay);
			body_2_1.render(matrixStack, buffer, packedLight, packedOverlay);
			eyes.render(matrixStack, buffer, packedLight, packedOverlay);
			zhuan.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {

			this.zhuan.rotateAngleY = f3 / (180F / (float) Math.PI);
		}
	}

}
