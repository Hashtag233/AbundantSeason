package wwworld.procedures;

import wwworld.block.YingguangmoguBlock;
import wwworld.block.ShaojiaodenituBlock;
import wwworld.block.JishiBlock;

import wwworld.WwworldMod;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;

import java.util.Map;

public class MogudingGengXinYouXiKeProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				WwworldMod.LOGGER.warn("Failed to load dependency world for procedure MogudingGengXinYouXiKe!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				WwworldMod.LOGGER.warn("Failed to load dependency x for procedure MogudingGengXinYouXiKe!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				WwworldMod.LOGGER.warn("Failed to load dependency y for procedure MogudingGengXinYouXiKe!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				WwworldMod.LOGGER.warn("Failed to load dependency z for procedure MogudingGengXinYouXiKe!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		double prob = 0;
		double sx = 0;
		double dy = 0;
		double dyy = 0;
		double sy = 0;
		double sz = 0;
		sx = (-1);
		for (int index0 = 0; index0 < (int) (3); index0++) {
			sy = 0;
			for (int index1 = 0; index1 < (int) (1); index1++) {
				sz = (-1);
				for (int index2 = 0; index2 < (int) (3); index2++) {
					if (Math.random() < 0.7
							&& (world.getBlockState(new BlockPos((int) (x + sx), (int) (y + sy), (int) (z + sz)))).getBlock() == JishiBlock.block) {
						world.setBlockState(new BlockPos((int) (x + sx), (int) (y + sy), (int) (z + sz)), Blocks.MUSHROOM_STEM.getDefaultState(), 3);
					}
				}
				sy = (sy + 1);
			}
			sx = (sx + 1);
		}
		prob = 1;
		dy = 1;
		dyy = 1;
		if (Math.random() < 0.4) {
			if ((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.CAVE_AIR
					|| (world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.AIR) {
				for (int index3 = 0; index3 < (int) (14); index3++) {
					if (((world.getBlockState(new BlockPos((int) x, (int) ((y - dy) - 1), (int) z))).getBlock() == Blocks.CAVE_AIR
							|| (world.getBlockState(new BlockPos((int) x, (int) ((y - dy) - 1), (int) z))).getBlock() == Blocks.AIR)
							&& Math.random() < 0.6) {
						world.setBlockState(new BlockPos((int) x, (int) (y - dy), (int) z), Blocks.MUSHROOM_STEM.getDefaultState(), 3);
					} else if (Math.random() < 0.7) {
						world.setBlockState(new BlockPos((int) x, (int) (y - dy), (int) z), Blocks.BROWN_MUSHROOM_BLOCK.getDefaultState(), 3);
						break;
					} else if (Math.random() < 0.75) {
						world.setBlockState(new BlockPos((int) x, (int) (y - dy), (int) z), Blocks.RED_MUSHROOM_BLOCK.getDefaultState(), 3);
						break;
					} else {
						world.setBlockState(new BlockPos((int) x, (int) (y - dy), (int) z), YingguangmoguBlock.block.getDefaultState(), 3);
					}
					dy = (dy + 1);
				}
			}
			if (dy == 15) {
				world.setBlockState(new BlockPos((int) x, (int) (y - dy), (int) z), YingguangmoguBlock.block.getDefaultState(), 3);
			}
		}
		if (Math.random() < 0.4) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.MAGMA_BLOCK.getDefaultState(), 3);
		} else if (Math.random() < 0.6) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.MUSHROOM_STEM.getDefaultState(), 3);
		} else {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), ShaojiaodenituBlock.block.getDefaultState(), 3);
		}
	}
}
