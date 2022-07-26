
package wwworld.block;

import wwworld.procedures.DianGuKuaiDangFangKuaiBeiWanJiaPoPiShiProcedure;

import wwworld.itemgroup.ZhuangtshixingItemGroup;

import wwworld.WwworldModElements;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.fluid.FluidState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.block.material.PushReaction;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import java.util.stream.Stream;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Collections;
import java.util.AbstractMap;

@WwworldModElements.ModElement.Tag
public class DianGuKuaiBlock extends WwworldModElements.ModElement {
	@ObjectHolder("wwworld:dian_gu_kuai")
	public static final Block block = null;

	public DianGuKuaiBlock(WwworldModElements instance) {
		super(instance, 141);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(ZhuangtshixingItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.SPONGE).sound(SoundType.WOOD).hardnessAndResistance(0.1f, 0.2f).setLightLevel(s -> 2)
					.setNeedsPostProcessing((bs, br, bp) -> true).setEmmisiveRendering((bs, br, bp) -> true));
			setRegistryName("dian_gu_kuai");
		}

		@OnlyIn(Dist.CLIENT)
		public boolean isSideInvisible(BlockState state, BlockState adjacentBlockState, Direction side) {
			return adjacentBlockState.getBlock() == this ? true : super.isSideInvisible(state, adjacentBlockState, side);
		}

		@Override
		public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
			return 7;
		}

		@Override
		public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
			return 50;
		}

		@Override
		public PathNodeType getAiPathNodeType(BlockState state, IBlockReader world, BlockPos pos, MobEntity entity) {
			return PathNodeType.LEAVES;
		}

		@Override
		public PushReaction getPushReaction(BlockState state) {
			return PushReaction.DESTROY;
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 0));
		}

		@Override
		public boolean removedByPlayer(BlockState blockstate, World world, BlockPos pos, PlayerEntity entity, boolean willHarvest, FluidState fluid) {
			boolean retval = super.removedByPlayer(blockstate, world, pos, entity, willHarvest, fluid);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();

			DianGuKuaiDangFangKuaiBeiWanJiaPoPiShiProcedure.executeProcedure(Stream
					.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
							new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			return retval;
		}
	}
}
