package wwworld.entity.renderer;

import wwworld.entity.BingshuanglongjuanfengEntity;

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
public class BingshuanglongjuanfengRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(BingshuanglongjuanfengEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelbingshuanglongjuanfeng(), 0.5f) {

					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("wwworld:textures/bingshuanglongjuanfeng.png");
					}
				};
			});
		}
	}

	// Made with Blockbench 3.9.3
	// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
	// Paste this class into your mod and generate all required imports
	public static class Modelbingshuanglongjuanfeng extends EntityModel<Entity> {
		private final ModelRenderer wuguan;
		private final ModelRenderer zhuan;

		public Modelbingshuanglongjuanfeng() {
			textureWidth = 128;
			textureHeight = 128;
			wuguan = new ModelRenderer(this);
			wuguan.setRotationPoint(0.0F, 24.0F, 0.0F);
			wuguan.setTextureOffset(0, 0).addBox(-2.0F, -3.0F, -2.0F, 4.0F, 3.0F, 4.0F, 0.0F, false);
			wuguan.setTextureOffset(42, 38).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 4.0F, 8.0F, 0.0F, false);
			wuguan.setTextureOffset(0, 21).addBox(-6.0F, -11.0F, -6.0F, 12.0F, 4.0F, 12.0F, 0.0F, false);
			wuguan.setTextureOffset(0, 0).addBox(-8.0F, -16.0F, -8.0F, 16.0F, 5.0F, 16.0F, 0.0F, false);
			wuguan.setTextureOffset(0, 37).addBox(-10.0F, -20.0F, -10.0F, 20.0F, 4.0F, 5.0F, 0.0F, false);
			wuguan.setTextureOffset(36, 21).addBox(-10.0F, -20.0F, 5.0F, 20.0F, 4.0F, 5.0F, 0.0F, false);
			wuguan.setTextureOffset(48, 0).addBox(6.0F, -20.0F, -5.0F, 4.0F, 4.0F, 10.0F, 0.0F, false);
			wuguan.setTextureOffset(0, 46).addBox(-10.0F, -20.0F, -5.0F, 4.0F, 4.0F, 10.0F, 0.0F, false);
			wuguan.setTextureOffset(0, 8).addBox(-6.0F, -14.0F, -10.0F, 4.0F, 1.0F, 0.0F, 0.0F, false);
			wuguan.setTextureOffset(8, 8).addBox(-6.0F, -15.0F, -10.0F, 3.0F, 1.0F, 0.0F, 0.0F, false);
			wuguan.setTextureOffset(12, 0).addBox(-6.0F, -16.0F, -10.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);
			wuguan.setTextureOffset(0, 7).addBox(2.0F, -14.0F, -10.0F, 4.0F, 1.0F, 0.0F, 0.0F, false);
			wuguan.setTextureOffset(8, 7).addBox(3.0F, -15.0F, -10.0F, 3.0F, 1.0F, 0.0F, 0.0F, false);
			wuguan.setTextureOffset(11, 9).addBox(4.0F, -16.0F, -10.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);
			zhuan = new ModelRenderer(this);
			zhuan.setRotationPoint(-1.0F, 17.0F, -1.0F);
			zhuan.setTextureOffset(96, 96).addBox(7.0F, 0.0F, -27.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);
			zhuan.setTextureOffset(96, 96).addBox(8.0F, 0.0F, -24.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
			zhuan.setTextureOffset(96, 96).addBox(7.0F, 1.0F, -25.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
			zhuan.setTextureOffset(96, 96).addBox(7.0F, -1.0F, -24.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
			zhuan.setTextureOffset(96, 96).addBox(6.0F, 0.0F, -25.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
			zhuan.setTextureOffset(96, 96).addBox(-8.0F, 0.0F, 21.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);
			zhuan.setTextureOffset(96, 96).addBox(-7.0F, 0.0F, 24.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
			zhuan.setTextureOffset(96, 96).addBox(-8.0F, 1.0F, 23.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
			zhuan.setTextureOffset(96, 96).addBox(-8.0F, -1.0F, 24.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
			zhuan.setTextureOffset(96, 96).addBox(-9.0F, 0.0F, 23.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
			zhuan.setTextureOffset(96, 96).addBox(24.0F, 0.0F, 5.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);
			zhuan.setTextureOffset(96, 96).addBox(25.0F, 0.0F, 8.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
			zhuan.setTextureOffset(96, 96).addBox(24.0F, 1.0F, 7.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
			zhuan.setTextureOffset(96, 96).addBox(24.0F, -1.0F, 8.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
			zhuan.setTextureOffset(96, 96).addBox(23.0F, 0.0F, 7.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
			zhuan.setTextureOffset(96, 96).addBox(-26.0F, 0.0F, -9.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);
			zhuan.setTextureOffset(96, 96).addBox(-25.0F, 0.0F, -6.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
			zhuan.setTextureOffset(96, 96).addBox(-26.0F, 1.0F, -7.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
			zhuan.setTextureOffset(96, 96).addBox(-26.0F, -1.0F, -6.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
			zhuan.setTextureOffset(96, 96).addBox(-27.0F, 0.0F, -7.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			wuguan.render(matrixStack, buffer, packedLight, packedOverlay);
			zhuan.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {

			this.zhuan.rotateAngleY = f2 / 20.f;
		}
	}

}
