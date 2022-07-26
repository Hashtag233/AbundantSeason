package wwworld.entity.renderer;

import wwworld.entity.ShuiguihuaEntity;

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
public class ShuiguihuaRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(ShuiguihuaEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelshuiguihua(), 0.5f) {

					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("wwworld:textures/shui_gui_hua_.png");
					}
				};
			});
		}
	}

	// Made with Blockbench 3.9.2
	// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
	// Paste this class into your mod and generate all required imports
	public static class Modelshuiguihua extends EntityModel<Entity> {
		private final ModelRenderer head;
		private final ModelRenderer flower;
		private final ModelRenderer flower2;
		private final ModelRenderer flower3;
		private final ModelRenderer flower4;
		private final ModelRenderer flower5;
		private final ModelRenderer flower6;
		private final ModelRenderer flower7;
		private final ModelRenderer flower8;
		private final ModelRenderer flower9;
		private final ModelRenderer flower10;
		private final ModelRenderer flower11;
		private final ModelRenderer flower12;
		private final ModelRenderer flower13;

		public Modelshuiguihua() {
			textureWidth = 64;
			textureHeight = 64;
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, 24.0F, 0.0F);
			head.setTextureOffset(4, 44).addBox(-5.0F, -11.0F, -5.0F, 10.0F, 10.0F, 10.0F, 0.0F, true);
			flower = new ModelRenderer(this);
			flower.setRotationPoint(0.0F, 20.0F, 7.0F);
			flower.setTextureOffset(31, 23).addBox(-2.0F, -12.0F, -9.0F, 0.0F, 5.0F, 4.0F, 0.0F, false);
			flower.setTextureOffset(48, 60).addBox(-2.0F, -7.0F, -9.0F, 4.0F, 0.0F, 4.0F, 0.0F, false);
			flower.setTextureOffset(56, 11).addBox(2.0F, -12.0F, -9.0F, 0.0F, 5.0F, 4.0F, 0.0F, false);
			flower.setTextureOffset(62, 46).addBox(2.0F, -13.0F, -9.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
			flower.setTextureOffset(51, 22).addBox(-2.0F, -13.0F, -6.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
			flower.setTextureOffset(62, 36).addBox(2.0F, -14.0F, -8.0F, 0.0F, 2.0F, 1.0F, 0.0F, false);
			flower.setTextureOffset(55, 24).addBox(-2.0F, -14.0F, -7.0F, 0.0F, 2.0F, 1.0F, 0.0F, false);
			flower.setTextureOffset(21, 22).addBox(2.0F, -15.0F, -7.0F, 0.0F, 3.0F, 1.0F, 0.0F, false);
			flower.setTextureOffset(47, 18).addBox(-2.0F, -15.0F, -8.0F, 0.0F, 3.0F, 1.0F, 0.0F, false);
			flower.setTextureOffset(11, 23).addBox(2.0F, -16.0F, -6.0F, 0.0F, 4.0F, 1.0F, 0.0F, false);
			flower.setTextureOffset(41, 21).addBox(-2.0F, -16.0F, -9.0F, 0.0F, 4.0F, 1.0F, 0.0F, false);
			flower.setTextureOffset(46, 23).addBox(-2.0F, -13.0F, -5.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
			flower.setTextureOffset(11, 8).addBox(1.0F, -13.0F, -9.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
			flower.setTextureOffset(51, 12).addBox(-1.0F, -14.0F, -5.0F, 1.0F, 2.0F, 0.0F, 0.0F, false);
			flower.setTextureOffset(11, 2).addBox(0.0F, -14.0F, -9.0F, 1.0F, 2.0F, 0.0F, 0.0F, false);
			flower.setTextureOffset(62, 21).addBox(0.0F, -15.0F, -5.0F, 1.0F, 3.0F, 0.0F, 0.0F, false);
			flower.setTextureOffset(35, 21).addBox(-1.0F, -15.0F, -9.0F, 1.0F, 3.0F, 0.0F, 0.0F, false);
			flower.setTextureOffset(62, 30).addBox(1.0F, -16.0F, -5.0F, 1.0F, 4.0F, 0.0F, 0.0F, false);
			flower.setTextureOffset(31, 19).addBox(-2.0F, -16.0F, -9.0F, 1.0F, 4.0F, 0.0F, 0.0F, false);
			flower.setTextureOffset(56, 0).addBox(-2.0F, -12.0F, -9.0F, 4.0F, 5.0F, 0.0F, 0.0F, false);
			flower.setTextureOffset(41, 43).addBox(-2.0F, -12.0F, -5.0F, 4.0F, 5.0F, 0.0F, 0.0F, false);
			flower2 = new ModelRenderer(this);
			flower2.setRotationPoint(-1.0F, 21.0F, 7.0F);
			setRotationAngle(flower2, 0.0F, 0.0F, -0.3927F);
			flower2.setTextureOffset(31, 23).addBox(-2.0F, -12.0F, -9.0F, 0.0F, 5.0F, 4.0F, 0.0F, false);
			flower2.setTextureOffset(56, 11).addBox(2.0F, -12.0F, -9.0F, 0.0F, 5.0F, 4.0F, 0.0F, false);
			flower2.setTextureOffset(62, 46).addBox(2.0F, -13.0F, -9.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
			flower2.setTextureOffset(51, 22).addBox(-2.0F, -13.0F, -6.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
			flower2.setTextureOffset(62, 36).addBox(2.0F, -14.0F, -8.0F, 0.0F, 2.0F, 1.0F, 0.0F, false);
			flower2.setTextureOffset(55, 24).addBox(-2.0F, -14.0F, -7.0F, 0.0F, 2.0F, 1.0F, 0.0F, false);
			flower2.setTextureOffset(21, 22).addBox(2.0F, -15.0F, -7.0F, 0.0F, 3.0F, 1.0F, 0.0F, false);
			flower2.setTextureOffset(47, 18).addBox(-2.0F, -15.0F, -8.0F, 0.0F, 3.0F, 1.0F, 0.0F, false);
			flower2.setTextureOffset(11, 23).addBox(2.0F, -16.0F, -6.0F, 0.0F, 4.0F, 1.0F, 0.0F, false);
			flower2.setTextureOffset(41, 21).addBox(-2.0F, -16.0F, -9.0F, 0.0F, 4.0F, 1.0F, 0.0F, false);
			flower2.setTextureOffset(46, 23).addBox(-2.0F, -13.0F, -5.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
			flower2.setTextureOffset(11, 8).addBox(1.0F, -13.0F, -9.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
			flower2.setTextureOffset(51, 12).addBox(-1.0F, -14.0F, -5.0F, 1.0F, 2.0F, 0.0F, 0.0F, false);
			flower2.setTextureOffset(11, 2).addBox(0.0F, -14.0F, -9.0F, 1.0F, 2.0F, 0.0F, 0.0F, false);
			flower2.setTextureOffset(62, 21).addBox(0.0F, -15.0F, -5.0F, 1.0F, 3.0F, 0.0F, 0.0F, false);
			flower2.setTextureOffset(35, 21).addBox(-1.0F, -15.0F, -9.0F, 1.0F, 3.0F, 0.0F, 0.0F, false);
			flower2.setTextureOffset(62, 30).addBox(1.0F, -16.0F, -5.0F, 1.0F, 4.0F, 0.0F, 0.0F, false);
			flower2.setTextureOffset(31, 19).addBox(-2.0F, -16.0F, -9.0F, 1.0F, 4.0F, 0.0F, 0.0F, false);
			flower2.setTextureOffset(56, 0).addBox(-2.0F, -12.0F, -9.0F, 4.0F, 5.0F, 0.0F, 0.0F, false);
			flower2.setTextureOffset(48, 60).addBox(-2.0F, -9.0F, -9.0F, 4.0F, 2.0F, 4.0F, 0.0F, false);
			flower2.setTextureOffset(41, 43).addBox(-2.0F, -12.0F, -5.0F, 4.0F, 5.0F, 0.0F, 0.0F, false);
			flower3 = new ModelRenderer(this);
			flower3.setRotationPoint(0.0F, 19.0F, 5.0F);
			setRotationAngle(flower3, 0.3491F, 0.0F, 0.0F);
			flower3.setTextureOffset(31, 23).addBox(-2.0F, -12.0F, -9.0F, 0.0F, 5.0F, 4.0F, 0.0F, false);
			flower3.setTextureOffset(56, 11).addBox(2.0F, -12.0F, -9.0F, 0.0F, 5.0F, 4.0F, 0.0F, false);
			flower3.setTextureOffset(62, 46).addBox(2.0F, -13.0F, -9.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
			flower3.setTextureOffset(51, 22).addBox(-2.0F, -13.0F, -6.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
			flower3.setTextureOffset(62, 36).addBox(2.0F, -14.0F, -8.0F, 0.0F, 2.0F, 1.0F, 0.0F, false);
			flower3.setTextureOffset(55, 24).addBox(-2.0F, -14.0F, -7.0F, 0.0F, 2.0F, 1.0F, 0.0F, false);
			flower3.setTextureOffset(21, 22).addBox(2.0F, -15.0F, -7.0F, 0.0F, 3.0F, 1.0F, 0.0F, false);
			flower3.setTextureOffset(47, 18).addBox(-2.0F, -15.0F, -8.0F, 0.0F, 3.0F, 1.0F, 0.0F, false);
			flower3.setTextureOffset(11, 23).addBox(2.0F, -16.0F, -6.0F, 0.0F, 4.0F, 1.0F, 0.0F, false);
			flower3.setTextureOffset(41, 21).addBox(-2.0F, -16.0F, -9.0F, 0.0F, 4.0F, 1.0F, 0.0F, false);
			flower3.setTextureOffset(46, 23).addBox(-2.0F, -13.0F, -5.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
			flower3.setTextureOffset(11, 8).addBox(1.0F, -13.0F, -9.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
			flower3.setTextureOffset(51, 12).addBox(-1.0F, -14.0F, -5.0F, 1.0F, 2.0F, 0.0F, 0.0F, false);
			flower3.setTextureOffset(11, 2).addBox(0.0F, -14.0F, -9.0F, 1.0F, 2.0F, 0.0F, 0.0F, false);
			flower3.setTextureOffset(62, 21).addBox(0.0F, -15.0F, -5.0F, 1.0F, 3.0F, 0.0F, 0.0F, false);
			flower3.setTextureOffset(35, 21).addBox(-1.0F, -15.0F, -9.0F, 1.0F, 3.0F, 0.0F, 0.0F, false);
			flower3.setTextureOffset(62, 30).addBox(1.0F, -16.0F, -5.0F, 1.0F, 4.0F, 0.0F, 0.0F, false);
			flower3.setTextureOffset(31, 19).addBox(-2.0F, -16.0F, -9.0F, 1.0F, 4.0F, 0.0F, 0.0F, false);
			flower3.setTextureOffset(56, 0).addBox(-2.0F, -12.0F, -9.0F, 4.0F, 5.0F, 0.0F, 0.0F, false);
			flower3.setTextureOffset(48, 60).addBox(-2.0F, -10.0F, -9.0F, 4.0F, 3.0F, 4.0F, 0.0F, false);
			flower3.setTextureOffset(41, 43).addBox(-2.0F, -12.0F, -5.0F, 4.0F, 5.0F, 0.0F, 0.0F, false);
			flower4 = new ModelRenderer(this);
			flower4.setRotationPoint(1.0F, 21.0F, 7.0F);
			setRotationAngle(flower4, 0.0F, 0.0F, 0.3927F);
			flower4.setTextureOffset(31, 23).addBox(-2.0F, -12.0F, -9.0F, 0.0F, 5.0F, 4.0F, 0.0F, false);
			flower4.setTextureOffset(56, 11).addBox(2.0F, -12.0F, -9.0F, 0.0F, 5.0F, 4.0F, 0.0F, false);
			flower4.setTextureOffset(62, 46).addBox(2.0F, -13.0F, -9.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
			flower4.setTextureOffset(51, 22).addBox(-2.0F, -13.0F, -6.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
			flower4.setTextureOffset(62, 36).addBox(2.0F, -14.0F, -8.0F, 0.0F, 2.0F, 1.0F, 0.0F, false);
			flower4.setTextureOffset(55, 24).addBox(-2.0F, -14.0F, -7.0F, 0.0F, 2.0F, 1.0F, 0.0F, false);
			flower4.setTextureOffset(21, 22).addBox(2.0F, -15.0F, -7.0F, 0.0F, 3.0F, 1.0F, 0.0F, false);
			flower4.setTextureOffset(47, 18).addBox(-2.0F, -15.0F, -8.0F, 0.0F, 3.0F, 1.0F, 0.0F, false);
			flower4.setTextureOffset(11, 23).addBox(2.0F, -16.0F, -6.0F, 0.0F, 4.0F, 1.0F, 0.0F, false);
			flower4.setTextureOffset(41, 21).addBox(-2.0F, -16.0F, -9.0F, 0.0F, 4.0F, 1.0F, 0.0F, false);
			flower4.setTextureOffset(46, 23).addBox(-2.0F, -13.0F, -5.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
			flower4.setTextureOffset(11, 8).addBox(1.0F, -13.0F, -9.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
			flower4.setTextureOffset(51, 12).addBox(-1.0F, -14.0F, -5.0F, 1.0F, 2.0F, 0.0F, 0.0F, false);
			flower4.setTextureOffset(11, 2).addBox(0.0F, -14.0F, -9.0F, 1.0F, 2.0F, 0.0F, 0.0F, false);
			flower4.setTextureOffset(62, 21).addBox(0.0F, -15.0F, -5.0F, 1.0F, 3.0F, 0.0F, 0.0F, false);
			flower4.setTextureOffset(35, 21).addBox(-1.0F, -15.0F, -9.0F, 1.0F, 3.0F, 0.0F, 0.0F, false);
			flower4.setTextureOffset(62, 30).addBox(1.0F, -16.0F, -5.0F, 1.0F, 4.0F, 0.0F, 0.0F, false);
			flower4.setTextureOffset(31, 19).addBox(-2.0F, -16.0F, -9.0F, 1.0F, 4.0F, 0.0F, 0.0F, false);
			flower4.setTextureOffset(56, 0).addBox(-2.0F, -12.0F, -9.0F, 4.0F, 5.0F, 0.0F, 0.0F, false);
			flower4.setTextureOffset(48, 58).addBox(-2.0F, -9.0F, -9.0F, 4.0F, 2.0F, 4.0F, 0.0F, false);
			flower4.setTextureOffset(41, 43).addBox(-2.0F, -12.0F, -5.0F, 4.0F, 5.0F, 0.0F, 0.0F, false);
			flower5 = new ModelRenderer(this);
			flower5.setRotationPoint(0.0F, 24.0F, 7.0F);
			setRotationAngle(flower5, -0.4363F, 0.0F, 0.0F);
			flower5.setTextureOffset(31, 23).addBox(-2.0F, -12.0F, -9.0F, 0.0F, 5.0F, 4.0F, 0.0F, false);
			flower5.setTextureOffset(56, 11).addBox(2.0F, -12.0F, -9.0F, 0.0F, 5.0F, 4.0F, 0.0F, false);
			flower5.setTextureOffset(48, 60).addBox(-2.0F, -10.0F, -9.0F, 4.0F, 3.0F, 4.0F, 0.0F, false);
			flower5.setTextureOffset(62, 46).addBox(2.0F, -13.0F, -9.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
			flower5.setTextureOffset(51, 22).addBox(-2.0F, -13.0F, -6.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
			flower5.setTextureOffset(62, 36).addBox(2.0F, -14.0F, -8.0F, 0.0F, 2.0F, 1.0F, 0.0F, false);
			flower5.setTextureOffset(55, 24).addBox(-2.0F, -14.0F, -7.0F, 0.0F, 2.0F, 1.0F, 0.0F, false);
			flower5.setTextureOffset(21, 22).addBox(2.0F, -15.0F, -7.0F, 0.0F, 3.0F, 1.0F, 0.0F, false);
			flower5.setTextureOffset(47, 18).addBox(-2.0F, -15.0F, -8.0F, 0.0F, 3.0F, 1.0F, 0.0F, false);
			flower5.setTextureOffset(11, 23).addBox(2.0F, -16.0F, -6.0F, 0.0F, 4.0F, 1.0F, 0.0F, false);
			flower5.setTextureOffset(41, 21).addBox(-2.0F, -16.0F, -9.0F, 0.0F, 4.0F, 1.0F, 0.0F, false);
			flower5.setTextureOffset(46, 23).addBox(-2.0F, -13.0F, -5.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
			flower5.setTextureOffset(11, 8).addBox(1.0F, -13.0F, -9.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
			flower5.setTextureOffset(51, 12).addBox(-1.0F, -14.0F, -5.0F, 1.0F, 2.0F, 0.0F, 0.0F, false);
			flower5.setTextureOffset(11, 2).addBox(0.0F, -14.0F, -9.0F, 1.0F, 2.0F, 0.0F, 0.0F, false);
			flower5.setTextureOffset(62, 21).addBox(0.0F, -15.0F, -5.0F, 1.0F, 3.0F, 0.0F, 0.0F, false);
			flower5.setTextureOffset(35, 21).addBox(-1.0F, -15.0F, -9.0F, 1.0F, 3.0F, 0.0F, 0.0F, false);
			flower5.setTextureOffset(62, 30).addBox(1.0F, -16.0F, -5.0F, 1.0F, 4.0F, 0.0F, 0.0F, false);
			flower5.setTextureOffset(31, 19).addBox(-2.0F, -16.0F, -9.0F, 1.0F, 4.0F, 0.0F, 0.0F, false);
			flower5.setTextureOffset(56, 0).addBox(-2.0F, -12.0F, -9.0F, 4.0F, 5.0F, 0.0F, 0.0F, false);
			flower5.setTextureOffset(41, 43).addBox(-2.0F, -12.0F, -5.0F, 4.0F, 5.0F, 0.0F, 0.0F, false);
			flower6 = new ModelRenderer(this);
			flower6.setRotationPoint(-2.0F, 24.0F, 7.0F);
			setRotationAngle(flower6, -0.4232F, -0.1096F, -0.2382F);
			flower6.setTextureOffset(31, 23).addBox(-2.0F, -12.0F, -9.0F, 0.0F, 5.0F, 4.0F, 0.0F, false);
			flower6.setTextureOffset(56, 11).addBox(2.0F, -12.0F, -9.0F, 0.0F, 5.0F, 4.0F, 0.0F, false);
			flower6.setTextureOffset(62, 46).addBox(2.0F, -13.0F, -9.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
			flower6.setTextureOffset(51, 22).addBox(-2.0F, -13.0F, -6.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
			flower6.setTextureOffset(62, 36).addBox(2.0F, -14.0F, -8.0F, 0.0F, 2.0F, 1.0F, 0.0F, false);
			flower6.setTextureOffset(55, 24).addBox(-2.0F, -14.0F, -7.0F, 0.0F, 2.0F, 1.0F, 0.0F, false);
			flower6.setTextureOffset(21, 22).addBox(2.0F, -15.0F, -7.0F, 0.0F, 3.0F, 1.0F, 0.0F, false);
			flower6.setTextureOffset(47, 18).addBox(-2.0F, -15.0F, -8.0F, 0.0F, 3.0F, 1.0F, 0.0F, false);
			flower6.setTextureOffset(11, 23).addBox(2.0F, -16.0F, -6.0F, 0.0F, 4.0F, 1.0F, 0.0F, false);
			flower6.setTextureOffset(41, 21).addBox(-2.0F, -16.0F, -9.0F, 0.0F, 4.0F, 1.0F, 0.0F, false);
			flower6.setTextureOffset(46, 23).addBox(-2.0F, -13.0F, -5.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
			flower6.setTextureOffset(11, 8).addBox(1.0F, -13.0F, -9.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
			flower6.setTextureOffset(51, 12).addBox(-1.0F, -14.0F, -5.0F, 1.0F, 2.0F, 0.0F, 0.0F, false);
			flower6.setTextureOffset(11, 2).addBox(0.0F, -14.0F, -9.0F, 1.0F, 2.0F, 0.0F, 0.0F, false);
			flower6.setTextureOffset(62, 21).addBox(0.0F, -15.0F, -5.0F, 1.0F, 3.0F, 0.0F, 0.0F, false);
			flower6.setTextureOffset(35, 21).addBox(-1.0F, -15.0F, -9.0F, 1.0F, 3.0F, 0.0F, 0.0F, false);
			flower6.setTextureOffset(62, 30).addBox(1.0F, -16.0F, -5.0F, 1.0F, 4.0F, 0.0F, 0.0F, false);
			flower6.setTextureOffset(31, 19).addBox(-2.0F, -16.0F, -9.0F, 1.0F, 4.0F, 0.0F, 0.0F, false);
			flower6.setTextureOffset(56, 0).addBox(-2.0F, -12.0F, -9.0F, 4.0F, 5.0F, 0.0F, 0.0F, false);
			flower6.setTextureOffset(48, 60).addBox(-2.0F, -10.0F, -9.0F, 4.0F, 3.0F, 4.0F, 0.0F, false);
			flower6.setTextureOffset(41, 43).addBox(-2.0F, -12.0F, -5.0F, 4.0F, 5.0F, 0.0F, 0.0F, false);
			flower7 = new ModelRenderer(this);
			flower7.setRotationPoint(2.0F, 23.0F, 9.0F);
			setRotationAngle(flower7, -0.191F, 0.1222F, 0.2444F);
			flower7.setTextureOffset(31, 23).addBox(-2.0F, -12.0F, -9.0F, 0.0F, 5.0F, 4.0F, 0.0F, false);
			flower7.setTextureOffset(56, 11).addBox(2.0F, -12.0F, -9.0F, 0.0F, 5.0F, 4.0F, 0.0F, false);
			flower7.setTextureOffset(62, 46).addBox(2.0F, -13.0F, -9.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
			flower7.setTextureOffset(51, 22).addBox(-2.0F, -13.0F, -6.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
			flower7.setTextureOffset(62, 36).addBox(2.0F, -14.0F, -8.0F, 0.0F, 2.0F, 1.0F, 0.0F, false);
			flower7.setTextureOffset(55, 24).addBox(-2.0F, -14.0F, -7.0F, 0.0F, 2.0F, 1.0F, 0.0F, false);
			flower7.setTextureOffset(21, 22).addBox(2.0F, -15.0F, -7.0F, 0.0F, 3.0F, 1.0F, 0.0F, false);
			flower7.setTextureOffset(47, 18).addBox(-2.0F, -15.0F, -8.0F, 0.0F, 3.0F, 1.0F, 0.0F, false);
			flower7.setTextureOffset(11, 23).addBox(2.0F, -16.0F, -6.0F, 0.0F, 4.0F, 1.0F, 0.0F, false);
			flower7.setTextureOffset(41, 21).addBox(-2.0F, -16.0F, -9.0F, 0.0F, 4.0F, 1.0F, 0.0F, false);
			flower7.setTextureOffset(46, 23).addBox(-2.0F, -13.0F, -5.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
			flower7.setTextureOffset(11, 8).addBox(1.0F, -13.0F, -9.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
			flower7.setTextureOffset(51, 12).addBox(-1.0F, -14.0F, -5.0F, 1.0F, 2.0F, 0.0F, 0.0F, false);
			flower7.setTextureOffset(11, 2).addBox(0.0F, -14.0F, -9.0F, 1.0F, 2.0F, 0.0F, 0.0F, false);
			flower7.setTextureOffset(62, 21).addBox(0.0F, -15.0F, -5.0F, 1.0F, 3.0F, 0.0F, 0.0F, false);
			flower7.setTextureOffset(35, 21).addBox(-1.0F, -15.0F, -9.0F, 1.0F, 3.0F, 0.0F, 0.0F, false);
			flower7.setTextureOffset(62, 30).addBox(1.0F, -16.0F, -5.0F, 1.0F, 4.0F, 0.0F, 0.0F, false);
			flower7.setTextureOffset(31, 19).addBox(-2.0F, -16.0F, -9.0F, 1.0F, 4.0F, 0.0F, 0.0F, false);
			flower7.setTextureOffset(56, 0).addBox(-2.0F, -12.0F, -9.0F, 4.0F, 5.0F, 0.0F, 0.0F, false);
			flower7.setTextureOffset(50, 60).addBox(-2.0F, -10.0F, -9.0F, 4.0F, 3.0F, 4.0F, 0.0F, false);
			flower7.setTextureOffset(41, 43).addBox(-2.0F, -12.0F, -5.0F, 4.0F, 5.0F, 0.0F, 0.0F, false);
			flower8 = new ModelRenderer(this);
			flower8.setRotationPoint(2.0F, 20.0F, 5.0F);
			setRotationAngle(flower8, 0.2445F, -0.0896F, 0.1916F);
			flower8.setTextureOffset(31, 23).addBox(-2.0F, -12.0F, -9.0F, 0.0F, 5.0F, 4.0F, 0.0F, false);
			flower8.setTextureOffset(56, 11).addBox(2.0F, -12.0F, -9.0F, 0.0F, 5.0F, 4.0F, 0.0F, false);
			flower8.setTextureOffset(48, 60).addBox(-2.0F, -10.0F, -9.0F, 4.0F, 3.0F, 4.0F, 0.0F, false);
			flower8.setTextureOffset(62, 46).addBox(2.0F, -13.0F, -9.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
			flower8.setTextureOffset(51, 22).addBox(-2.0F, -13.0F, -6.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
			flower8.setTextureOffset(62, 36).addBox(2.0F, -14.0F, -8.0F, 0.0F, 2.0F, 1.0F, 0.0F, false);
			flower8.setTextureOffset(55, 24).addBox(-2.0F, -14.0F, -7.0F, 0.0F, 2.0F, 1.0F, 0.0F, false);
			flower8.setTextureOffset(21, 22).addBox(2.0F, -15.0F, -7.0F, 0.0F, 3.0F, 1.0F, 0.0F, false);
			flower8.setTextureOffset(47, 18).addBox(-2.0F, -15.0F, -8.0F, 0.0F, 3.0F, 1.0F, 0.0F, false);
			flower8.setTextureOffset(11, 23).addBox(2.0F, -16.0F, -6.0F, 0.0F, 4.0F, 1.0F, 0.0F, false);
			flower8.setTextureOffset(41, 21).addBox(-2.0F, -16.0F, -9.0F, 0.0F, 4.0F, 1.0F, 0.0F, false);
			flower8.setTextureOffset(46, 23).addBox(-2.0F, -13.0F, -5.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
			flower8.setTextureOffset(11, 8).addBox(1.0F, -13.0F, -9.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
			flower8.setTextureOffset(51, 12).addBox(-1.0F, -14.0F, -5.0F, 1.0F, 2.0F, 0.0F, 0.0F, false);
			flower8.setTextureOffset(11, 2).addBox(0.0F, -14.0F, -9.0F, 1.0F, 2.0F, 0.0F, 0.0F, false);
			flower8.setTextureOffset(62, 21).addBox(0.0F, -15.0F, -5.0F, 1.0F, 3.0F, 0.0F, 0.0F, false);
			flower8.setTextureOffset(35, 21).addBox(-1.0F, -15.0F, -9.0F, 1.0F, 3.0F, 0.0F, 0.0F, false);
			flower8.setTextureOffset(62, 30).addBox(1.0F, -16.0F, -5.0F, 1.0F, 4.0F, 0.0F, 0.0F, false);
			flower8.setTextureOffset(31, 19).addBox(-2.0F, -16.0F, -9.0F, 1.0F, 4.0F, 0.0F, 0.0F, false);
			flower8.setTextureOffset(56, 0).addBox(-2.0F, -12.0F, -9.0F, 4.0F, 5.0F, 0.0F, 0.0F, false);
			flower8.setTextureOffset(41, 43).addBox(-2.0F, -12.0F, -5.0F, 4.0F, 5.0F, 0.0F, 0.0F, false);
			flower9 = new ModelRenderer(this);
			flower9.setRotationPoint(-4.0F, 20.0F, 5.0F);
			setRotationAngle(flower9, 0.2639F, -0.1702F, -0.192F);
			flower9.setTextureOffset(31, 23).addBox(-2.0F, -12.0F, -9.0F, 0.0F, 5.0F, 4.0F, 0.0F, false);
			flower9.setTextureOffset(48, 60).addBox(-2.0F, -10.0F, -9.0F, 4.0F, 3.0F, 4.0F, 0.0F, false);
			flower9.setTextureOffset(56, 11).addBox(2.0F, -12.0F, -9.0F, 0.0F, 5.0F, 4.0F, 0.0F, false);
			flower9.setTextureOffset(62, 46).addBox(2.0F, -13.0F, -9.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
			flower9.setTextureOffset(51, 22).addBox(-2.0F, -13.0F, -6.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
			flower9.setTextureOffset(62, 36).addBox(2.0F, -14.0F, -8.0F, 0.0F, 2.0F, 1.0F, 0.0F, false);
			flower9.setTextureOffset(55, 24).addBox(-2.0F, -14.0F, -7.0F, 0.0F, 2.0F, 1.0F, 0.0F, false);
			flower9.setTextureOffset(21, 22).addBox(2.0F, -15.0F, -7.0F, 0.0F, 3.0F, 1.0F, 0.0F, false);
			flower9.setTextureOffset(47, 18).addBox(-2.0F, -15.0F, -8.0F, 0.0F, 3.0F, 1.0F, 0.0F, false);
			flower9.setTextureOffset(11, 23).addBox(2.0F, -16.0F, -6.0F, 0.0F, 4.0F, 1.0F, 0.0F, false);
			flower9.setTextureOffset(41, 21).addBox(-2.0F, -16.0F, -9.0F, 0.0F, 4.0F, 1.0F, 0.0F, false);
			flower9.setTextureOffset(46, 23).addBox(-2.0F, -13.0F, -5.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
			flower9.setTextureOffset(11, 8).addBox(1.0F, -13.0F, -9.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
			flower9.setTextureOffset(51, 12).addBox(-1.0F, -14.0F, -5.0F, 1.0F, 2.0F, 0.0F, 0.0F, false);
			flower9.setTextureOffset(11, 2).addBox(0.0F, -14.0F, -9.0F, 1.0F, 2.0F, 0.0F, 0.0F, false);
			flower9.setTextureOffset(62, 21).addBox(0.0F, -15.0F, -5.0F, 1.0F, 3.0F, 0.0F, 0.0F, false);
			flower9.setTextureOffset(35, 21).addBox(-1.0F, -15.0F, -9.0F, 1.0F, 3.0F, 0.0F, 0.0F, false);
			flower9.setTextureOffset(62, 30).addBox(1.0F, -16.0F, -5.0F, 1.0F, 4.0F, 0.0F, 0.0F, false);
			flower9.setTextureOffset(31, 19).addBox(-2.0F, -16.0F, -9.0F, 1.0F, 4.0F, 0.0F, 0.0F, false);
			flower9.setTextureOffset(56, 0).addBox(-2.0F, -12.0F, -9.0F, 4.0F, 5.0F, 0.0F, 0.0F, false);
			flower9.setTextureOffset(41, 43).addBox(-2.0F, -12.0F, -5.0F, 4.0F, 5.0F, 0.0F, 0.0F, false);
			flower10 = new ModelRenderer(this);
			flower10.setRotationPoint(0.0F, 24.0F, 1.0F);
			setRotationAngle(flower10, -1.1345F, 0.0F, 0.0F);
			flower10.setTextureOffset(31, 23).addBox(-2.0F, -12.0F, -9.0F, 0.0F, 5.0F, 4.0F, 0.0F, false);
			flower10.setTextureOffset(56, 11).addBox(2.0F, -12.0F, -9.0F, 0.0F, 5.0F, 4.0F, 0.0F, false);
			flower10.setTextureOffset(48, 60).addBox(-2.0F, -10.0F, -9.0F, 4.0F, 3.0F, 4.0F, 0.0F, false);
			flower10.setTextureOffset(62, 46).addBox(2.0F, -13.0F, -9.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
			flower10.setTextureOffset(51, 22).addBox(-2.0F, -13.0F, -6.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
			flower10.setTextureOffset(62, 36).addBox(2.0F, -14.0F, -8.0F, 0.0F, 2.0F, 1.0F, 0.0F, false);
			flower10.setTextureOffset(55, 24).addBox(-2.0F, -14.0F, -7.0F, 0.0F, 2.0F, 1.0F, 0.0F, false);
			flower10.setTextureOffset(21, 22).addBox(2.0F, -15.0F, -7.0F, 0.0F, 3.0F, 1.0F, 0.0F, false);
			flower10.setTextureOffset(47, 18).addBox(-2.0F, -15.0F, -8.0F, 0.0F, 3.0F, 1.0F, 0.0F, false);
			flower10.setTextureOffset(11, 23).addBox(2.0F, -16.0F, -6.0F, 0.0F, 4.0F, 1.0F, 0.0F, false);
			flower10.setTextureOffset(41, 21).addBox(-2.0F, -16.0F, -9.0F, 0.0F, 4.0F, 1.0F, 0.0F, false);
			flower10.setTextureOffset(46, 23).addBox(-2.0F, -13.0F, -5.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
			flower10.setTextureOffset(11, 8).addBox(1.0F, -13.0F, -9.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
			flower10.setTextureOffset(51, 12).addBox(-1.0F, -14.0F, -5.0F, 1.0F, 2.0F, 0.0F, 0.0F, false);
			flower10.setTextureOffset(11, 2).addBox(0.0F, -14.0F, -9.0F, 1.0F, 2.0F, 0.0F, 0.0F, false);
			flower10.setTextureOffset(62, 21).addBox(0.0F, -15.0F, -5.0F, 1.0F, 3.0F, 0.0F, 0.0F, false);
			flower10.setTextureOffset(35, 21).addBox(-1.0F, -15.0F, -9.0F, 1.0F, 3.0F, 0.0F, 0.0F, false);
			flower10.setTextureOffset(62, 30).addBox(1.0F, -16.0F, -5.0F, 1.0F, 4.0F, 0.0F, 0.0F, false);
			flower10.setTextureOffset(31, 19).addBox(-2.0F, -16.0F, -9.0F, 1.0F, 4.0F, 0.0F, 0.0F, false);
			flower10.setTextureOffset(56, 0).addBox(-2.0F, -12.0F, -9.0F, 4.0F, 5.0F, 0.0F, 0.0F, false);
			flower10.setTextureOffset(41, 43).addBox(-2.0F, -12.0F, -5.0F, 4.0F, 5.0F, 0.0F, 0.0F, false);
			flower11 = new ModelRenderer(this);
			flower11.setRotationPoint(0.0F, 12.0F, 5.0F);
			setRotationAngle(flower11, 1.048F, -0.0032F, -0.0367F);
			flower11.setTextureOffset(31, 23).addBox(-2.0F, -12.0F, -9.0F, 0.0F, 5.0F, 4.0F, 0.0F, false);
			flower11.setTextureOffset(56, 11).addBox(2.0F, -12.0F, -9.0F, 0.0F, 5.0F, 4.0F, 0.0F, false);
			flower11.setTextureOffset(62, 46).addBox(2.0F, -13.0F, -9.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
			flower11.setTextureOffset(51, 22).addBox(-2.0F, -13.0F, -6.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
			flower11.setTextureOffset(62, 36).addBox(2.0F, -14.0F, -8.0F, 0.0F, 2.0F, 1.0F, 0.0F, false);
			flower11.setTextureOffset(55, 24).addBox(-2.0F, -14.0F, -7.0F, 0.0F, 2.0F, 1.0F, 0.0F, false);
			flower11.setTextureOffset(21, 22).addBox(2.0F, -15.0F, -7.0F, 0.0F, 3.0F, 1.0F, 0.0F, false);
			flower11.setTextureOffset(47, 18).addBox(-2.0F, -15.0F, -8.0F, 0.0F, 3.0F, 1.0F, 0.0F, false);
			flower11.setTextureOffset(11, 23).addBox(2.0F, -16.0F, -6.0F, 0.0F, 4.0F, 1.0F, 0.0F, false);
			flower11.setTextureOffset(41, 21).addBox(-2.0F, -16.0F, -9.0F, 0.0F, 4.0F, 1.0F, 0.0F, false);
			flower11.setTextureOffset(46, 23).addBox(-2.0F, -13.0F, -5.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
			flower11.setTextureOffset(11, 8).addBox(1.0F, -13.0F, -9.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
			flower11.setTextureOffset(51, 12).addBox(-1.0F, -14.0F, -5.0F, 1.0F, 2.0F, 0.0F, 0.0F, false);
			flower11.setTextureOffset(11, 2).addBox(0.0F, -14.0F, -9.0F, 1.0F, 2.0F, 0.0F, 0.0F, false);
			flower11.setTextureOffset(62, 21).addBox(0.0F, -15.0F, -5.0F, 1.0F, 3.0F, 0.0F, 0.0F, false);
			flower11.setTextureOffset(35, 21).addBox(-1.0F, -15.0F, -9.0F, 1.0F, 3.0F, 0.0F, 0.0F, false);
			flower11.setTextureOffset(62, 30).addBox(1.0F, -16.0F, -5.0F, 1.0F, 4.0F, 0.0F, 0.0F, false);
			flower11.setTextureOffset(31, 19).addBox(-2.0F, -16.0F, -9.0F, 1.0F, 4.0F, 0.0F, 0.0F, false);
			flower11.setTextureOffset(56, 0).addBox(-2.0F, -12.0F, -9.0F, 4.0F, 5.0F, 0.0F, 0.0F, false);
			flower11.setTextureOffset(48, 60).addBox(-2.0F, -10.0F, -9.0F, 4.0F, 3.0F, 4.0F, 0.0F, false);
			flower11.setTextureOffset(41, 43).addBox(-2.0F, -12.0F, -5.0F, 4.0F, 5.0F, 0.0F, 0.0F, false);
			flower12 = new ModelRenderer(this);
			flower12.setRotationPoint(2.0F, 18.0F, 7.0F);
			setRotationAngle(flower12, 0.0F, 0.0F, -1.0472F);
			flower12.setTextureOffset(31, 23).addBox(-2.0F, -12.0F, -9.0F, 0.0F, 5.0F, 4.0F, 0.0F, false);
			flower12.setTextureOffset(56, 11).addBox(2.0F, -12.0F, -9.0F, 0.0F, 5.0F, 4.0F, 0.0F, false);
			flower12.setTextureOffset(62, 46).addBox(2.0F, -13.0F, -9.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
			flower12.setTextureOffset(51, 22).addBox(-2.0F, -13.0F, -6.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
			flower12.setTextureOffset(62, 36).addBox(2.0F, -14.0F, -8.0F, 0.0F, 2.0F, 1.0F, 0.0F, false);
			flower12.setTextureOffset(55, 24).addBox(-2.0F, -14.0F, -7.0F, 0.0F, 2.0F, 1.0F, 0.0F, false);
			flower12.setTextureOffset(21, 22).addBox(2.0F, -15.0F, -7.0F, 0.0F, 3.0F, 1.0F, 0.0F, false);
			flower12.setTextureOffset(47, 18).addBox(-2.0F, -15.0F, -8.0F, 0.0F, 3.0F, 1.0F, 0.0F, false);
			flower12.setTextureOffset(11, 23).addBox(2.0F, -16.0F, -6.0F, 0.0F, 4.0F, 1.0F, 0.0F, false);
			flower12.setTextureOffset(41, 21).addBox(-2.0F, -16.0F, -9.0F, 0.0F, 4.0F, 1.0F, 0.0F, false);
			flower12.setTextureOffset(46, 23).addBox(-2.0F, -13.0F, -5.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
			flower12.setTextureOffset(11, 8).addBox(1.0F, -13.0F, -9.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
			flower12.setTextureOffset(51, 12).addBox(-1.0F, -14.0F, -5.0F, 1.0F, 2.0F, 0.0F, 0.0F, false);
			flower12.setTextureOffset(11, 2).addBox(0.0F, -14.0F, -9.0F, 1.0F, 2.0F, 0.0F, 0.0F, false);
			flower12.setTextureOffset(62, 21).addBox(0.0F, -15.0F, -5.0F, 1.0F, 3.0F, 0.0F, 0.0F, false);
			flower12.setTextureOffset(35, 21).addBox(-1.0F, -15.0F, -9.0F, 1.0F, 3.0F, 0.0F, 0.0F, false);
			flower12.setTextureOffset(62, 30).addBox(1.0F, -16.0F, -5.0F, 1.0F, 4.0F, 0.0F, 0.0F, false);
			flower12.setTextureOffset(31, 19).addBox(-2.0F, -16.0F, -9.0F, 1.0F, 4.0F, 0.0F, 0.0F, false);
			flower12.setTextureOffset(56, 0).addBox(-2.0F, -12.0F, -9.0F, 4.0F, 5.0F, 0.0F, 0.0F, false);
			flower12.setTextureOffset(48, 60).addBox(-2.0F, -9.0F, -9.0F, 4.0F, 2.0F, 4.0F, 0.0F, false);
			flower12.setTextureOffset(41, 43).addBox(-2.0F, -12.0F, -5.0F, 4.0F, 5.0F, 0.0F, 0.0F, false);
			flower13 = new ModelRenderer(this);
			flower13.setRotationPoint(-3.0F, 17.0F, 7.0F);
			setRotationAngle(flower13, 0.0F, 0.0F, 1.1345F);
			flower13.setTextureOffset(31, 23).addBox(-2.0F, -12.0F, -9.0F, 0.0F, 5.0F, 4.0F, 0.0F, false);
			flower13.setTextureOffset(56, 11).addBox(2.0F, -12.0F, -9.0F, 0.0F, 5.0F, 4.0F, 0.0F, false);
			flower13.setTextureOffset(62, 46).addBox(2.0F, -13.0F, -9.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
			flower13.setTextureOffset(51, 22).addBox(-2.0F, -13.0F, -6.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
			flower13.setTextureOffset(62, 36).addBox(2.0F, -14.0F, -8.0F, 0.0F, 2.0F, 1.0F, 0.0F, false);
			flower13.setTextureOffset(55, 24).addBox(-2.0F, -14.0F, -7.0F, 0.0F, 2.0F, 1.0F, 0.0F, false);
			flower13.setTextureOffset(21, 22).addBox(2.0F, -15.0F, -7.0F, 0.0F, 3.0F, 1.0F, 0.0F, false);
			flower13.setTextureOffset(47, 18).addBox(-2.0F, -15.0F, -8.0F, 0.0F, 3.0F, 1.0F, 0.0F, false);
			flower13.setTextureOffset(11, 23).addBox(2.0F, -16.0F, -6.0F, 0.0F, 4.0F, 1.0F, 0.0F, false);
			flower13.setTextureOffset(41, 21).addBox(-2.0F, -16.0F, -9.0F, 0.0F, 4.0F, 1.0F, 0.0F, false);
			flower13.setTextureOffset(46, 23).addBox(-2.0F, -13.0F, -5.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
			flower13.setTextureOffset(11, 8).addBox(1.0F, -13.0F, -9.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
			flower13.setTextureOffset(51, 12).addBox(-1.0F, -14.0F, -5.0F, 1.0F, 2.0F, 0.0F, 0.0F, false);
			flower13.setTextureOffset(11, 2).addBox(0.0F, -14.0F, -9.0F, 1.0F, 2.0F, 0.0F, 0.0F, false);
			flower13.setTextureOffset(62, 21).addBox(0.0F, -15.0F, -5.0F, 1.0F, 3.0F, 0.0F, 0.0F, false);
			flower13.setTextureOffset(35, 21).addBox(-1.0F, -15.0F, -9.0F, 1.0F, 3.0F, 0.0F, 0.0F, false);
			flower13.setTextureOffset(62, 30).addBox(1.0F, -16.0F, -5.0F, 1.0F, 4.0F, 0.0F, 0.0F, false);
			flower13.setTextureOffset(31, 19).addBox(-2.0F, -16.0F, -9.0F, 1.0F, 4.0F, 0.0F, 0.0F, false);
			flower13.setTextureOffset(56, 0).addBox(-2.0F, -12.0F, -9.0F, 4.0F, 5.0F, 0.0F, 0.0F, false);
			flower13.setTextureOffset(48, 58).addBox(-2.0F, -9.0F, -9.0F, 4.0F, 2.0F, 4.0F, 0.0F, false);
			flower13.setTextureOffset(41, 43).addBox(-2.0F, -12.0F, -5.0F, 4.0F, 5.0F, 0.0F, 0.0F, false);
		}

		@Override
		public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			// previously the render function, render code was moved to a method below
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			head.render(matrixStack, buffer, packedLight, packedOverlay);
			flower.render(matrixStack, buffer, packedLight, packedOverlay);
			flower2.render(matrixStack, buffer, packedLight, packedOverlay);
			flower3.render(matrixStack, buffer, packedLight, packedOverlay);
			flower4.render(matrixStack, buffer, packedLight, packedOverlay);
			flower5.render(matrixStack, buffer, packedLight, packedOverlay);
			flower6.render(matrixStack, buffer, packedLight, packedOverlay);
			flower7.render(matrixStack, buffer, packedLight, packedOverlay);
			flower8.render(matrixStack, buffer, packedLight, packedOverlay);
			flower9.render(matrixStack, buffer, packedLight, packedOverlay);
			flower10.render(matrixStack, buffer, packedLight, packedOverlay);
			flower11.render(matrixStack, buffer, packedLight, packedOverlay);
			flower12.render(matrixStack, buffer, packedLight, packedOverlay);
			flower13.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}
	}

}
