
package wwworld.block;

import wwworld.itemgroup.ZhuangtshixingItemGroup;

import wwworld.WwworldModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.IBlockReader;
import net.minecraft.world.IBlockDisplayReader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.fluid.FluidState;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import java.util.List;
import java.util.Collections;

@WwworldModElements.ModElement.Tag
public class BingzhuikuaiBlock extends WwworldModElements.ModElement {
	@ObjectHolder("wwworld:bingzhuikuai")
	public static final Block block = null;

	public BingzhuikuaiBlock(WwworldModElements instance) {
		super(instance, 146);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(ZhuangtshixingItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.ICE).sound(SoundType.GLASS).hardnessAndResistance(0.5f, 0.5f).setLightLevel(s -> 0)
					.slipperiness(0.89f));
			setRegistryName("bingzhuikuai");
		}

		@Override
		public boolean shouldDisplayFluidOverlay(BlockState state, IBlockDisplayReader world, BlockPos pos, FluidState fluidstate) {
			return true;
		}

		@Override
		public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
			return true;
		}

		@Override
		public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
			return 0;
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}
	}
}
