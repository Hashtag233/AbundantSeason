package wwworld.entity.renderer;

import wwworld.entity.VineQueenEntity;

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
public class VineQueenRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(VineQueenEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelvine_boss(), 0.5f) {

					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("wwworld:textures/vine_boss.png");
					}
				};
			});
		}
	}

	// Made with Blockbench 3.9.2
	// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
	// Paste this class into your mod and generate all required imports
	public static class Modelvine_boss extends EntityModel<Entity> {
		private final ModelRenderer bone;
		private final ModelRenderer bone2;
		private final ModelRenderer bone3;
		private final ModelRenderer cube_r1;
		private final ModelRenderer bone11;
		private final ModelRenderer cube_r2;
		private final ModelRenderer bone9;
		private final ModelRenderer bone10;
		private final ModelRenderer bone7;
		private final ModelRenderer bone8;
		private final ModelRenderer bone5;
		private final ModelRenderer bone6;
		private final ModelRenderer leftleg;
		private final ModelRenderer rightleg;
		private final ModelRenderer cube_r3;
		private final ModelRenderer bone4;

		public Modelvine_boss() {
			textureWidth = 64;
			textureHeight = 64;
			bone = new ModelRenderer(this);
			bone.setRotationPoint(0.0F, 24.0F, 0.0F);
			setRotationAngle(bone, 0.0F, 1.5708F, 0.0F);
			bone2 = new ModelRenderer(this);
			bone2.setRotationPoint(1.0F, -12.0F, 0.0F);
			bone.addChild(bone2);
			bone2.setTextureOffset(11, 3).addBox(-2.0F, 2.0F, -2.5F, 2.0F, 2.0F, 5.0F, 0.0F, false);
			bone2.setTextureOffset(0, 8).addBox(-2.0F, -4.0F, -2.0F, 2.0F, 6.0F, 4.0F, 0.0F, false);
			bone3 = new ModelRenderer(this);
			bone3.setRotationPoint(0.0F, 0.0F, 0.0F);
			bone2.addChild(bone3);
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(-1.0F, -6.5F, 0.0F);
			bone3.addChild(cube_r1);
			setRotationAngle(cube_r1, 0.0F, -1.5708F, 0.0F);
			cube_r1.setTextureOffset(0, 0).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);
			bone11 = new ModelRenderer(this);
			bone11.setRotationPoint(0.0F, 0.0F, 0.0F);
			bone3.addChild(bone11);
			bone11.setTextureOffset(26, 0).addBox(-1.3549F, -9.4262F, -1.8547F, 4.0F, 6.0F, 4.0F, 0.0F, false);
			bone11.setTextureOffset(26, 0).addBox(-4.3549F, -9.4262F, -1.8547F, 4.0F, 6.0F, 4.0F, 0.0F, false);
			bone11.setTextureOffset(26, 0).addBox(-3.3549F, -9.4262F, 0.1453F, 4.0F, 6.0F, 4.0F, 0.0F, false);
			bone11.setTextureOffset(26, 0).addBox(-3.3549F, -9.4262F, -3.8547F, 4.0F, 6.0F, 4.0F, 0.0F, false);
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(0.4273F, -5.1279F, 0.0F);
			bone11.addChild(cube_r2);
			setRotationAngle(cube_r2, 3.1416F, 0.0F, 0.0F);
			cube_r2.setTextureOffset(26, 0).addBox(-3.7823F, 3.7018F, -1.8547F, 4.0F, 6.0F, 4.0F, 0.0F, false);
			bone9 = new ModelRenderer(this);
			bone9.setRotationPoint(-1.0F, 0.5F, 2.5F);
			bone2.addChild(bone9);
			setRotationAngle(bone9, 0.1309F, 0.0F, 0.0F);
			bone9.setTextureOffset(22, 17).addBox(-0.5F, -4.0F, 0.0F, 1.0F, 8.0F, 1.0F, 0.0F, false);
			bone10 = new ModelRenderer(this);
			bone10.setRotationPoint(-1.0F, 0.5F, -3.5F);
			bone2.addChild(bone10);
			setRotationAngle(bone10, -0.1309F, 0.0F, 0.0F);
			bone10.setTextureOffset(18, 17).addBox(-0.5F, -4.0F, 0.0F, 1.0F, 8.0F, 1.0F, 0.0F, false);
			bone7 = new ModelRenderer(this);
			bone7.setRotationPoint(-2.0F, 1.0F, 2.0F);
			bone2.addChild(bone7);
			bone7.setTextureOffset(0, 0).addBox(0.5F, -5.5F, -2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bone8 = new ModelRenderer(this);
			bone8.setRotationPoint(-3.0F, 7.0F, 2.0F);
			bone2.addChild(bone8);
			bone8.setTextureOffset(12, 10).addBox(0.5F, -5.5F, -4.5F, 1.0F, 2.0F, 5.0F, 0.0F, false);
			bone5 = new ModelRenderer(this);
			bone5.setRotationPoint(-1.0F, -3.0F, 0.0F);
			bone2.addChild(bone5);
			setRotationAngle(bone5, 0.0F, 0.0F, -0.3491F);
			bone5.setTextureOffset(20, 0).addBox(0.158F, -0.0603F, -2.2F, 1.0F, 2.0F, 2.0F, 0.0F, false);
			bone6 = new ModelRenderer(this);
			bone6.setRotationPoint(-1.0F, -3.0F, 3.0F);
			bone2.addChild(bone6);
			setRotationAngle(bone6, 0.0F, 0.0F, -0.3491F);
			bone6.setTextureOffset(19, 10).addBox(0.158F, -0.0603F, -2.8F, 1.0F, 2.0F, 2.0F, 0.0F, false);
			leftleg = new ModelRenderer(this);
			leftleg.setRotationPoint(0.0F, 0.0F, 0.0F);
			bone.addChild(leftleg);
			leftleg.setTextureOffset(0, 18).addBox(-1.0F, -8.0F, -2.5F, 2.0F, 8.0F, 2.0F, 0.0F, false);
			rightleg = new ModelRenderer(this);
			rightleg.setRotationPoint(0.0F, 0.0F, 1.0F);
			bone.addChild(rightleg);
			cube_r3 = new ModelRenderer(this);
			cube_r3.setRotationPoint(0.0F, -4.0F, 0.5F);
			rightleg.addChild(cube_r3);
			setRotationAngle(cube_r3, 0.0F, 3.1416F, 0.0F);
			cube_r3.setTextureOffset(10, 17).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F, false);
			bone4 = new ModelRenderer(this);
			bone4.setRotationPoint(0.0F, 0.0F, 0.0F);
			bone.addChild(bone4);
			bone4.setTextureOffset(0, 28).addBox(-8.0F, 0.0F, -8.0F, 16.0F, 0.0F, 16.0F, 0.0F, false);
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
