package wwworld.procedures;

import wwworld.block.YingguangdiBlock;
import wwworld.block.TianmiDiBlock;
import wwworld.block.MogudiBlock;
import wwworld.block.JishiBlock;
import wwworld.block.HanbingdiBlock;
import wwworld.block.FanguodiBlock;

import wwworld.WwworldMod;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import java.util.Map;

public class ZhuangshidongxuefangkuaiGengXinYouXiKeProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				WwworldMod.LOGGER.warn("Failed to load dependency world for procedure ZhuangshidongxuefangkuaiGengXinYouXiKe!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				WwworldMod.LOGGER.warn("Failed to load dependency x for procedure ZhuangshidongxuefangkuaiGengXinYouXiKe!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				WwworldMod.LOGGER.warn("Failed to load dependency y for procedure ZhuangshidongxuefangkuaiGengXinYouXiKe!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				WwworldMod.LOGGER.warn("Failed to load dependency z for procedure ZhuangshidongxuefangkuaiGengXinYouXiKe!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		double h = 0;
		if (!world.isRemote()) {
			BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
			TileEntity _tileEntity = world.getTileEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_tileEntity != null)
				_tileEntity.getTileData().putDouble("timer", (new Object() {
					public double getValue(IWorld world, BlockPos pos, String tag) {
						TileEntity tileEntity = world.getTileEntity(pos);
						if (tileEntity != null)
							return tileEntity.getTileData().getDouble(tag);
						return -1;
					}
				}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "timer") + 1));
			if (world instanceof World)
				((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
		}
		if (new Object() {
			public double getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "timer") == 1) {
			for (int index0 = 0; index0 < (int) (50); index0++) {
				h = (h - 1);
				if (((world.getBlockState(new BlockPos((int) x, (int) (y + h + 1), (int) z))).getBlock() == Blocks.CAVE_AIR
						|| (world.getBlockState(new BlockPos((int) x, (int) (y + h + 1), (int) z))).getBlock() == Blocks.AIR)
						&& (world.getBlockState(new BlockPos((int) x, (int) (y + h), (int) z))).getBlock() == JishiBlock.block) {
					if (world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z))) != null
							&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z)))
									.equals(new ResourceLocation("wwworld:fan_mao_yi_lin"))
							&& Math.random() <= 0.5) {
						world.setBlockState(new BlockPos((int) x, (int) (y + h), (int) z), TianmiDiBlock.block.getDefaultState(), 3);
					} else if (world.func_241828_r().getRegistry(Registry.BIOME_KEY)
							.getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z))) != null
							&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z)))
									.equals(new ResourceLocation("wwworld:fan_mao_yi_lin"))) {
						world.setBlockState(new BlockPos((int) x, (int) (y + h), (int) z), FanguodiBlock.block.getDefaultState(), 3);
					}
					if (world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z))) != null
							&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z)))
									.equals(new ResourceLocation("wwworld:mo_gu_lin"))) {
						world.setBlockState(new BlockPos((int) x, (int) (y + h), (int) z), MogudiBlock.block.getDefaultState(), 3);
					}
					if (world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z))) != null
							&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z)))
									.equals(new ResourceLocation("wwworld:feng_lin"))) {
						world.setBlockState(new BlockPos((int) x, (int) (y + h), (int) z), YingguangdiBlock.block.getDefaultState(), 3);
					}
					if (world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z))) != null
							&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z)))
									.equals(new ResourceLocation("wwworld:han_chao_lin"))) {
						world.setBlockState(new BlockPos((int) x, (int) (y + h), (int) z), HanbingdiBlock.block.getDefaultState(), 3);
					}
				}
			}
		}
		if (new Object() {
			public double getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "timer") == 2) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.CAVE_AIR.getDefaultState(), 3);
		}
	}
}
