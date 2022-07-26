package wwworld.entity.renderer;

import wwworld.entity.LinghunkulouEntity;

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
public class LinghunkulouRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(LinghunkulouEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modellinghunkulou(), 0.3f) {

					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("wwworld:textures/linghunkulou.png");
					}
				};
			});
		}
	}

	// Made with Blockbench 4.1.2
	// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
	// Paste this class into your mod and generate all required imports
	public static class Modellinghunkulou extends EntityModel<Entity> {
		private final ModelRenderer head;

		public Modellinghunkulou() {
			textureWidth = 64;
			textureHeight = 32;
			head = new ModelRenderer(this);
			head.setRotationPoint(-18.0F, 20.0F, 0.0F);
			head.setTextureOffset(0, 0).addBox(14.0F, 3.0F, -4.0F, 8.0F, 1.0F, 1.0F, 0.0F, false);
			head.setTextureOffset(0, 0).addBox(15.0F, 3.0F, -3.0F, 6.0F, 1.0F, 6.0F, 0.0F, false);
			head.setTextureOffset(0, 0).addBox(15.0F, -4.0F, -3.0F, 6.0F, 1.0F, 6.0F, 0.0F, false);
			head.setTextureOffset(0, 0).addBox(14.0F, 1.0F, -4.0F, 8.0F, 1.0F, 1.0F, 0.0F, false);
			head.setTextureOffset(0, 0).addBox(14.0F, -4.0F, -4.0F, 8.0F, 4.0F, 1.0F, 0.0F, false);
			head.setTextureOffset(0, 0).addBox(15.0F, -4.0F, 3.0F, 6.0F, 8.0F, 1.0F, 0.0F, false);
			head.setTextureOffset(0, 0).addBox(14.0F, 0.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			head.setTextureOffset(0, 0).addBox(21.0F, 0.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			head.setTextureOffset(0, 0).addBox(17.0F, 0.0F, -4.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
			head.setTextureOffset(0, 0).addBox(14.0F, 2.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			head.setTextureOffset(0, 0).addBox(21.0F, 2.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			head.setTextureOffset(0, 0).addBox(21.0F, -4.0F, -3.0F, 1.0F, 8.0F, 7.0F, 0.0F, false);
			head.setTextureOffset(0, 0).addBox(14.0F, -4.0F, -3.0F, 1.0F, 8.0F, 7.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			head.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
		}
	}

}
