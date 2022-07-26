package wwworld.entity.renderer;

import wwworld.entity.Yunguoguai1Entity;

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
public class Yunguoguai1Renderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(Yunguoguai1Entity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelyunguoguai1(), 0.5f) {

					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("wwworld:textures/yunguoguai1.2.3.png");
					}
				};
			});
		}
	}

	// Made with Blockbench 3.9.2
	// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
	// Paste this class into your mod and generate all required imports
	public static class Modelyunguoguai1 extends EntityModel<Entity> {
		private final ModelRenderer bone;
		private final ModelRenderer piao;

		public Modelyunguoguai1() {
			textureWidth = 128;
			textureHeight = 128;
			bone = new ModelRenderer(this);
			bone.setRotationPoint(-1.0F, 28.0F, 0.0F);
			setRotationAngle(bone, 0.0F, 0.0F, 0.0F);
			bone.setTextureOffset(7, 25).addBox(-8.0F, -17.0F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bone.setTextureOffset(7, 25).addBox(1.0F, -16.0F, 6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bone.setTextureOffset(7, 25).addBox(-1.0F, -18.0F, 6.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			bone.setTextureOffset(7, 25).addBox(3.0F, -13.0F, 6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bone.setTextureOffset(7, 25).addBox(2.0F, -14.0F, 6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bone.setTextureOffset(7, 25).addBox(-4.0F, -13.0F, 6.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
			bone.setTextureOffset(7, 25).addBox(-1.0F, -12.0F, 6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bone.setTextureOffset(7, 25).addBox(-8.0F, -16.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bone.setTextureOffset(7, 25).addBox(9.0F, -15.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bone.setTextureOffset(7, 25).addBox(-8.0F, -13.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bone.setTextureOffset(7, 25).addBox(0.0F, -18.0F, 6.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
			bone.setTextureOffset(7, 25).addBox(3.0F, -15.0F, 6.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
			bone.setTextureOffset(7, 25).addBox(-3.0F, -12.0F, 6.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
			bone.setTextureOffset(7, 25).addBox(9.0F, -13.0F, -4.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
			bone.setTextureOffset(7, 25).addBox(-8.0F, -13.0F, 1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
			bone.setTextureOffset(7, 25).addBox(-7.0F, -18.0F, -6.0F, 1.0F, 9.0F, 10.0F, 0.0F, false);
			bone.setTextureOffset(7, 25).addBox(8.0F, -18.0F, -6.0F, 1.0F, 9.0F, 10.0F, 0.0F, false);
			bone.setTextureOffset(7, 25).addBox(9.0F, -18.0F, -2.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
			bone.setTextureOffset(7, 25).addBox(-1.0F, -17.0F, -9.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
			bone.setTextureOffset(7, 25).addBox(1.0F, -18.0F, -9.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
			bone.setTextureOffset(7, 25).addBox(-2.0F, -12.0F, -8.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
			bone.setTextureOffset(7, 25).addBox(-1.0F, -11.0F, -9.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
			bone.setTextureOffset(7, 25).addBox(-4.0F, -19.0F, -8.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			bone.setTextureOffset(7, 25).addBox(-5.0F, -13.0F, -8.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
			bone.setTextureOffset(7, 25).addBox(4.0F, -13.0F, -8.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			bone.setTextureOffset(7, 25).addBox(6.0F, -19.0F, -8.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			bone.setTextureOffset(7, 25).addBox(5.0F, -12.0F, -8.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
			bone.setTextureOffset(7, 25).addBox(-4.0F, -11.0F, -8.0F, 9.0F, 2.0F, 1.0F, 0.0F, false);
			bone.setTextureOffset(7, 25).addBox(-3.0F, -19.0F, -8.0F, 9.0F, 3.0F, 1.0F, 0.0F, false);
			bone.setTextureOffset(0, 31).addBox(-2.0F, -7.0F, -3.0F, 6.0F, 1.0F, 5.0F, 0.0F, false);
			bone.setTextureOffset(0, 31).addBox(-4.0F, -8.0F, -6.0F, 10.0F, 1.0F, 11.0F, 0.0F, false);
			bone.setTextureOffset(0, 31).addBox(-4.0F, -20.0F, -6.0F, 10.0F, 1.0F, 11.0F, 0.0F, false);
			bone.setTextureOffset(30, 60).addBox(-6.0F, -19.0F, -7.0F, 14.0F, 11.0F, 13.0F, 0.0F, false);
			piao = new ModelRenderer(this);
			piao.setRotationPoint(0.0F, 31.0F, 0.0F);
			piao.setTextureOffset(0, 0).addBox(12.0F, -16.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
			piao.setTextureOffset(0, 0).addBox(-15.0F, -16.0F, -4.0F, 2.0F, 2.0F, 5.0F, 0.0F, false);
			piao.setTextureOffset(0, 0).addBox(-14.0F, -18.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			piao.setTextureOffset(0, 0).addBox(-14.0F, -17.0F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			piao.setTextureOffset(0, 0).addBox(-16.0F, -16.0F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			piao.setTextureOffset(0, 0).addBox(-3.0F, -17.0F, 13.0F, 3.0F, 2.0F, 2.0F, 0.0F, false);
			piao.setTextureOffset(0, 0).addBox(-3.0F, -18.0F, 13.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
			piao.setTextureOffset(0, 0).addBox(-5.0F, -16.0F, 13.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			piao.setTextureOffset(0, 0).addBox(-3.0F, -16.0F, 15.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			piao.setTextureOffset(0, 0).addBox(0.0F, -14.0F, 12.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			piao.setTextureOffset(7, 25).addBox(14.0F, -17.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			piao.setTextureOffset(7, 25).addBox(13.0F, -16.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			piao.setTextureOffset(7, 25).addBox(13.0F, -17.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			piao.setTextureOffset(7, 25).addBox(15.0F, -15.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			bone.render(matrixStack, buffer, packedLight, packedOverlay);
			piao.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {

			this.piao.rotateAngleY = f4 / (180F / (float) Math.PI);
		}
	}

}
