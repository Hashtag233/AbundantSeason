package wwworld.entity.renderer;

import wwworld.entity.SongshuEntity;

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
public class SongshuRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(SongshuEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelsongshu(), 0.3f) {

					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("wwworld:textures/songshu.png");
					}
				};
			});
		}
	}

	// Made with Blockbench 3.8.4
	// Exported for Minecraft version 1.15 - 1.16
	// Paste this class into your mod and generate all required imports
	public static class Modelsongshu extends EntityModel<Entity> {
		private final ModelRenderer left;
		private final ModelRenderer cube_r1;
		private final ModelRenderer right;
		private final ModelRenderer cube_r2;
		private final ModelRenderer hend;
		private final ModelRenderer songguo;
		private final ModelRenderer bb_main;
		private final ModelRenderer cube_r3;

		public Modelsongshu() {
			textureWidth = 64;
			textureHeight = 64;
			left = new ModelRenderer(this);
			left.setRotationPoint(0.0F, 24.0F, 0.0F);
			left.setTextureOffset(0, 0).addBox(-3.0F, 0.0F, -1.0F, 1.0F, 0.0F, 1.0F, 0.0F, false);
			left.setTextureOffset(0, 0).addBox(-3.0F, -2.0F, 0.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
			left.addChild(cube_r1);
			setRotationAngle(cube_r1, -0.9599F, 0.0F, 0.0F);
			cube_r1.setTextureOffset(12, 0).addBox(-3.0F, -3.0F, -2.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			right = new ModelRenderer(this);
			right.setRotationPoint(0.0F, 24.0F, 0.0F);
			right.setTextureOffset(0, 0).addBox(1.0F, 0.0F, -1.0F, 1.0F, 0.0F, 1.0F, 0.0F, false);
			right.setTextureOffset(0, 0).addBox(1.0F, -2.0F, 0.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
			right.addChild(cube_r2);
			setRotationAngle(cube_r2, -0.9599F, 0.0F, 0.0F);
			cube_r2.setTextureOffset(12, 0).addBox(1.0F, -3.0F, -2.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			hend = new ModelRenderer(this);
			hend.setRotationPoint(0.0F, 24.0F, 0.0F);
			hend.setTextureOffset(4, 10).addBox(-2.0F, -10.0F, -3.0F, 3.0F, 3.0F, 3.0F, 0.0F, false);
			hend.setTextureOffset(8, 7).addBox(-1.0F, -8.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			hend.setTextureOffset(0, 0).addBox(-2.0F, -12.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F, false);
			hend.setTextureOffset(0, 0).addBox(1.0F, -12.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F, false);
			songguo = new ModelRenderer(this);
			songguo.setRotationPoint(0.0F, 23.0F, 1.0F);
			songguo.setTextureOffset(30, 8).addBox(-1.0F, -3.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			songguo.setTextureOffset(18, 0).addBox(-2.0F, -4.0F, -6.0F, 3.0F, 1.0F, 3.0F, 0.0F, false);
			songguo.setTextureOffset(32, 8).addBox(-1.0F, -4.0F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			songguo.setTextureOffset(30, 10).addBox(-1.0F, -4.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			songguo.setTextureOffset(29, 12).addBox(-2.0F, -3.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			songguo.setTextureOffset(49, 18).addBox(0.0F, -3.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			songguo.setTextureOffset(33, 10).addBox(-1.0F, -3.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			songguo.setTextureOffset(29, 9).addBox(-1.0F, -3.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			songguo.setTextureOffset(33, 16).addBox(1.0F, -4.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			songguo.setTextureOffset(28, 6).addBox(-1.0F, -2.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, true);
			songguo.setTextureOffset(60, 0).addBox(-1.0F, -5.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			songguo.setTextureOffset(30, 8).addBox(-3.0F, -4.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main = new ModelRenderer(this);
			bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
			bb_main.setTextureOffset(33, 62).addBox(-2.0F, -3.0F, 2.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(30, 60).addBox(-2.0F, -6.0F, 3.0F, 3.0F, 3.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(32, 60).addBox(-2.0F, -8.0F, 4.0F, 3.0F, 2.0F, 2.0F, 0.0F, false);
			bb_main.setTextureOffset(34, 62).addBox(-2.0F, -6.0F, 4.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r3 = new ModelRenderer(this);
			cube_r3.setRotationPoint(0.0F, 0.0F, 0.0F);
			bb_main.addChild(cube_r3);
			setRotationAngle(cube_r3, 0.3927F, 0.0F, 0.0F);
			cube_r3.setTextureOffset(0, 0).addBox(0.0F, -6.0F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
			cube_r3.setTextureOffset(0, 0).addBox(-2.0F, -6.0F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
			cube_r3.setTextureOffset(54, 56).addBox(-2.0F, -7.0F, 1.0F, 3.0F, 6.0F, 2.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			left.render(matrixStack, buffer, packedLight, packedOverlay);
			right.render(matrixStack, buffer, packedLight, packedOverlay);
			hend.render(matrixStack, buffer, packedLight, packedOverlay);
			songguo.render(matrixStack, buffer, packedLight, packedOverlay);
			bb_main.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {

			this.hend.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.hend.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.left.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.right.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		}
	}

}
