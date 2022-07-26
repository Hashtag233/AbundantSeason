
package wwworld.block;

import wwworld.WwworldModElements;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.Items;
import net.minecraft.item.Item;
import net.minecraft.item.BucketItem;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.block.material.Material;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

@WwworldModElements.ModElement.Tag
public class LiquidXPBlock extends WwworldModElements.ModElement {
	@ObjectHolder("wwworld:liquid_xp")
	public static final FlowingFluidBlock block = null;
	@ObjectHolder("wwworld:liquid_xp_bucket")
	public static final Item bucket = null;
	public static FlowingFluid flowing = null;
	public static FlowingFluid still = null;
	private ForgeFlowingFluid.Properties fluidproperties = null;

	public LiquidXPBlock(WwworldModElements instance) {
		super(instance, 958);
		FMLJavaModLoadingContext.get().getModEventBus().register(new FluidRegisterHandler());
	}

	private static class FluidRegisterHandler {
		@SubscribeEvent
		public void registerFluids(RegistryEvent.Register<Fluid> event) {
			event.getRegistry().register(still);
			event.getRegistry().register(flowing);
		}
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void clientLoad(FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(still, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(flowing, RenderType.getTranslucent());
	}

	@Override
	public void initElements() {
		fluidproperties = new ForgeFlowingFluid.Properties(() -> still, () -> flowing,
				FluidAttributes
						.builder(new ResourceLocation("wwworld:blocks/liquid_xp_still"), new ResourceLocation("wwworld:blocks/liquid_xp_flowing"))
						.luminosity(0).density(1000).viscosity(1000).temperature(300)

						.rarity(Rarity.COMMON).sound(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.empty"))))
								.explosionResistance(100f)

								.tickRate(5).levelDecreasePerBlock(1).slopeFindDistance(4).bucket(() -> bucket).block(() -> block);
		still = (FlowingFluid) new ForgeFlowingFluid.Source(fluidproperties).setRegistryName("liquid_xp");
		flowing = (FlowingFluid) new ForgeFlowingFluid.Flowing(fluidproperties).setRegistryName("liquid_xp_flowing");
		elements.blocks
				.add(() -> new FlowingFluidBlock(still, Block.Properties.create(Material.WATER).hardnessAndResistance(100f).setLightLevel(s -> 0)) {
					@Override
					public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
						return true;
					}
				}.setRegistryName("liquid_xp"));
		elements.items
				.add(() -> new BucketItem(still, new Item.Properties().containerItem(Items.BUCKET).maxStackSize(1).group(null).rarity(Rarity.COMMON))
						.setRegistryName("liquid_xp_bucket"));
	}
}
