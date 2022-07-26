package wwworld.entity.renderer;

import wwworld.entity.YinghuochongEntity;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.IRenderTypeBuffer;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class YinghuochongRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(YinghuochongEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelyinghuochong(), 0.5f) {
					{
						this.addLayer(new GlowingLayer<>(this));
					}

					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("wwworld:textures/yinghuochong.png");
					}
				};
			});
		}
	}

	@OnlyIn(Dist.CLIENT)
	private static class GlowingLayer<T extends Entity, M extends EntityModel<T>> extends LayerRenderer<T, M> {
		public GlowingLayer(IEntityRenderer<T, M> er) {
			super(er);
		}

		public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, T entitylivingbaseIn, float limbSwing,
				float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
			IVertexBuilder ivertexbuilder = bufferIn.getBuffer(RenderType.getEyes(new ResourceLocation("wwworld:textures/yinghuochong.png")));
			this.getEntityModel().render(matrixStackIn, ivertexbuilder, 15728640, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
		}
	}

	// Made with Blockbench 3.8.4
	// Exported for Minecraft version 1.15 - 1.16
	// Paste this class into your mod and generate all required imports
	public static class Modelyinghuochong extends EntityModel<Entity> {
		private final ModelRenderer bb_main;

		public Modelyinghuochong() {
			textureWidth = 64;
			textureHeight = 64;
			bb_main = new ModelRenderer(this);
			bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
			bb_main.setTextureOffset(48, 0).addBox(-2.0F, -7.0F, -7.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 0).addBox(-5.0F, -12.0F, -3.0F, 10.0F, 10.0F, 10.0F, 0.0F, false);
			bb_main.setTextureOffset(6, 0).addBox(-2.0F, -8.0F, -8.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(6, 0).addBox(2.0F, -8.0F, -8.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 0).addBox(-2.0F, -9.0F, -10.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 0).addBox(2.0F, -9.0F, -10.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 0).addBox(-2.0F, -2.0F, -1.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 0).addBox(2.0F, -2.0F, -1.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 0).addBox(2.0F, -1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 0).addBox(-2.0F, -1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 0).addBox(-2.0F, -1.0F, 4.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 0).addBox(-2.0F, -2.0F, 3.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 0).addBox(2.0F, -1.0F, 4.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 0).addBox(2.0F, -2.0F, 3.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		}

		@Override
		public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			// previously the render function, render code was moved to a method below
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			bb_main.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}
	}

}
