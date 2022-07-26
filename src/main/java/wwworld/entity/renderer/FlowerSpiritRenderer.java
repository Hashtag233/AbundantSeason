package wwworld.entity.renderer;

import wwworld.entity.FlowerSpiritEntity;

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
public class FlowerSpiritRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(FlowerSpiritEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelflower_spirit(), 0.5f) {

					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("wwworld:textures/flower_spirit.png");
					}
				};
			});
		}
	}

	// Made with Blockbench 3.9.2
	// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
	// Paste this class into your mod and generate all required imports
	public static class Modelflower_spirit extends EntityModel<Entity> {
		private final ModelRenderer bone;
		private final ModelRenderer bone2;
		private final ModelRenderer bone3;
		private final ModelRenderer bone4;
		private final ModelRenderer bone5;

		public Modelflower_spirit() {
			textureWidth = 32;
			textureHeight = 32;
			bone = new ModelRenderer(this);
			bone.setRotationPoint(0.0F, 24.0F, 0.0F);
			bone2 = new ModelRenderer(this);
			bone2.setRotationPoint(-0.5F, -8.0F, 0.0F);
			bone.addChild(bone2);
			bone2.setTextureOffset(0, 12).addBox(-1.5F, -4.1F, -2.0F, 3.0F, 4.0F, 4.0F, 0.0F, false);
			bone3 = new ModelRenderer(this);
			bone3.setRotationPoint(-3.0F, -2.0F, -3.0F);
			bone.addChild(bone3);
			bone3.setTextureOffset(0, 0).addBox(-0.5F, -6.0F, 0.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
			bone4 = new ModelRenderer(this);
			bone4.setRotationPoint(0.0F, 0.0F, -1.0F);
			bone.addChild(bone4);
			bone4.setTextureOffset(0, 12).addBox(-1.0F, -3.0F, 2.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			bone5 = new ModelRenderer(this);
			bone5.setRotationPoint(0.0F, 0.0F, -4.0F);
			bone.addChild(bone5);
			bone5.setTextureOffset(0, 0).addBox(-1.0F, -3.0F, 2.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		}

		@Override
		public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			// previously the render function, render code was moved to a method below
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			bone.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}
	}

}
