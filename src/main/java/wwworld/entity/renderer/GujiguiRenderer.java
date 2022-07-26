package wwworld.entity.renderer;

import wwworld.entity.GujiguiEntity;

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
public class GujiguiRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(GujiguiEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelgujikulou(), 0.5f) {

					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("wwworld:textures/gujikulou.png");
					}
				};
			});
		}
	}

	// Made with Blockbench 4.1.2
	// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
	// Paste this class into your mod and generate all required imports
	public static class Modelgujikulou extends EntityModel<Entity> {
		private final ModelRenderer head;
		private final ModelRenderer body;
		private final ModelRenderer left_arm;
		private final ModelRenderer right_arm;

		public Modelgujikulou() {
			textureWidth = 64;
			textureHeight = 32;
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, 10.0F, 0.0F);
			setRotationAngle(head, 0.1181F, 0.0131F, -0.0068F);
			head.setTextureOffset(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 10.0F, 0.0F);
			setRotationAngle(body, 0.3054F, 0.0F, 0.0F);
			body.setTextureOffset(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);
			left_arm = new ModelRenderer(this);
			left_arm.setRotationPoint(4.0F, 12.0F, 0.0F);
			setRotationAngle(left_arm, -1.4835F, 0.0F, 0.0F);
			left_arm.setTextureOffset(40, 16).addBox(0.0F, -2.0F, -1.0F, 2.0F, 12.0F, 2.0F, 0.0F, true);
			right_arm = new ModelRenderer(this);
			right_arm.setRotationPoint(-4.0F, 12.0F, 0.0F);
			setRotationAngle(right_arm, -1.4835F, 0.0F, 0.0F);
			right_arm.setTextureOffset(40, 16).addBox(-2.0F, -2.0F, -1.0F, 2.0F, 12.0F, 2.0F, 0.0F, false);
		}

		@Override
		public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			// previously the render function, render code was moved to a method below
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
	}

}
