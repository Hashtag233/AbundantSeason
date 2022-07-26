package wwworld.entity.renderer;

import wwworld.entity.BingshuangliehunEntity;

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
public class BingshuangliehunRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(BingshuangliehunEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelbingshuangliehun(), 0.5f) {

					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("wwworld:textures/bingshuangliehun.png");
					}
				};
			});
		}
	}

	// Made with Blockbench 3.9.2
	// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
	// Paste this class into your mod and generate all required imports
	public static class Modelbingshuangliehun extends EntityModel<Entity> {
		private final ModelRenderer zhuan;
		private final ModelRenderer xuanzhuan_r1;
		private final ModelRenderer xuanzhuan_r2;
		private final ModelRenderer xuanzhuan_r3;
		private final ModelRenderer xuanzhuan_r4;
		private final ModelRenderer head;

		public Modelbingshuangliehun() {
			textureWidth = 64;
			textureHeight = 64;
			zhuan = new ModelRenderer(this);
			zhuan.setRotationPoint(0.0F, 24.0F, 0.0F);
			xuanzhuan_r1 = new ModelRenderer(this);
			xuanzhuan_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
			zhuan.addChild(xuanzhuan_r1);
			setRotationAngle(xuanzhuan_r1, 0.0076F, -0.0131F, -0.3494F);
			xuanzhuan_r1.setTextureOffset(21, 44).addBox(11.0F, -17.0F, -2.0F, 1.0F, 16.0F, 4.0F, 0.0F, false);
			xuanzhuan_r2 = new ModelRenderer(this);
			xuanzhuan_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
			zhuan.addChild(xuanzhuan_r2);
			setRotationAngle(xuanzhuan_r2, -0.0026F, -0.0149F, 0.3488F);
			xuanzhuan_r2.setTextureOffset(26, 44).addBox(-12.0F, -17.0F, -2.0F, 1.0F, 16.0F, 4.0F, 0.0F, false);
			xuanzhuan_r3 = new ModelRenderer(this);
			xuanzhuan_r3.setRotationPoint(0.0F, 0.0F, 0.0F);
			zhuan.addChild(xuanzhuan_r3);
			setRotationAngle(xuanzhuan_r3, 0.3054F, 0.0F, 0.0F);
			xuanzhuan_r3.setTextureOffset(20, 47).addBox(-2.0F, -17.0F, 10.0F, 4.0F, 16.0F, 1.0F, 0.0F, false);
			xuanzhuan_r4 = new ModelRenderer(this);
			xuanzhuan_r4.setRotationPoint(0.0F, 0.0F, 0.0F);
			zhuan.addChild(xuanzhuan_r4);
			setRotationAngle(xuanzhuan_r4, -0.3927F, 0.0F, 0.0F);
			xuanzhuan_r4.setTextureOffset(25, 47).addBox(-2.0F, -16.0F, -12.0F, 4.0F, 16.0F, 1.0F, 0.0F, false);
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, 26.0F, 0.0F);
			head.setTextureOffset(0, 0).addBox(-3.0F, -29.0F, -3.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
			head.setTextureOffset(0, 0).addBox(-3.0F, -30.0F, -3.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
			head.setTextureOffset(0, 0).addBox(2.0F, -30.0F, -3.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
			head.setTextureOffset(0, 0).addBox(1.0F, -30.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			head.setTextureOffset(0, 0).addBox(-2.0F, -30.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			head.setTextureOffset(0, 0).addBox(-2.0F, -30.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			head.setTextureOffset(0, 0).addBox(1.0F, -30.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			head.setTextureOffset(0, 0).addBox(2.0F, -30.0F, 1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
			head.setTextureOffset(0, 0).addBox(-3.0F, -30.0F, 1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			zhuan.render(matrixStack, buffer, packedLight, packedOverlay);
			head.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {

			this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.xuanzhuan_r4.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.xuanzhuan_r3.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.xuanzhuan_r2.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.xuanzhuan_r1.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.zhuan.rotateAngleY = f3 / (180F / (float) Math.PI);
		}
	}

}
