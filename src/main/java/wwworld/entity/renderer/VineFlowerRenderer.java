package wwworld.entity.renderer;

import wwworld.entity.VineFlowerEntity;

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
public class VineFlowerRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(VineFlowerEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelflower_vine(), 0.5f) {

					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("wwworld:textures/flower_vine.png");
					}
				};
			});
		}
	}

	// Made with Blockbench 3.8.4
	// Exported for Minecraft version 1.15 - 1.16
	// Paste this class into your mod and generate all required imports
	public static class Modelflower_vine extends EntityModel<Entity> {
		private final ModelRenderer bone;
		private final ModelRenderer cube_r1;
		private final ModelRenderer cube_r2;
		private final ModelRenderer bone2;

		public Modelflower_vine() {
			textureWidth = 64;
			textureHeight = 64;
			bone = new ModelRenderer(this);
			bone.setRotationPoint(0.0F, 24.0F, 0.0F);
			bone.setTextureOffset(1, 1).addBox(-1.0F, -23.0F, -4.0F, 0.0F, 23.0F, 5.0F, 0.0F, false);
			bone.setTextureOffset(19, 35).addBox(2.0F, -23.0F, -3.0F, 0.0F, 23.0F, 5.0F, 0.0F, false);
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(3.0F, -14.0F, 2.0F);
			bone.addChild(cube_r1);
			setRotationAngle(cube_r1, 0.0F, 1.5708F, 0.0F);
			cube_r1.setTextureOffset(0, 35).addBox(4.0F, -9.0F, -4.0F, 0.0F, 23.0F, 5.0F, 0.0F, false);
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(2.0F, -14.0F, 4.0F);
			bone.addChild(cube_r2);
			setRotationAngle(cube_r2, 0.0F, 1.5708F, 0.0F);
			cube_r2.setTextureOffset(23, 1).addBox(4.0F, -9.0F, -4.0F, 0.0F, 23.0F, 5.0F, 0.0F, false);
			bone2 = new ModelRenderer(this);
			bone2.setRotationPoint(0.0F, 24.0F, 0.0F);
			bone2.setTextureOffset(32, 19).addBox(-2.0F, -27.0F, -6.0F, 0.0F, 10.0F, 10.0F, 0.0F, false);
		}

		@Override
		public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			// previously the render function, render code was moved to a method below
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			bone.render(matrixStack, buffer, packedLight, packedOverlay);
			bone2.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}
	}

}
