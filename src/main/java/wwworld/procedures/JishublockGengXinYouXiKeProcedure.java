package wwworld.procedures;

import wwworld.block.SssmallbingzhuiblockBlock;
import wwworld.block.SmallbingzhuiblockBlock;
import wwworld.block.JishiBlock;
import wwworld.block.BingzhuikuaiBlock;
import wwworld.block.BigBingzhuiblockBlock;

import wwworld.WwworldMod;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;

import java.util.Map;

public class JishublockGengXinYouXiKeProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				WwworldMod.LOGGER.warn("Failed to load dependency world for procedure JishublockGengXinYouXiKe!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				WwworldMod.LOGGER.warn("Failed to load dependency x for procedure JishublockGengXinYouXiKe!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				WwworldMod.LOGGER.warn("Failed to load dependency y for procedure JishublockGengXinYouXiKe!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				WwworldMod.LOGGER.warn("Failed to load dependency z for procedure JishublockGengXinYouXiKe!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		double sx = 0;
		double sy = 0;
		double sz = 0;
		double dy = 0;
		double prob = 0;
		sx = (-1);
		for (int index0 = 0; index0 < (int) (3); index0++) {
			sy = 0;
			for (int index1 = 0; index1 < (int) (2); index1++) {
				sz = (-1);
				for (int index2 = 0; index2 < (int) (3); index2++) {
					if ((world.getBlockState(new BlockPos((int) (x + sx), (int) (y + sy), (int) (z + sz)))).getBlock() == JishiBlock.block) {
						if (sx * sz == 0) {
							world.setBlockState(new BlockPos((int) (x + sx), (int) (y + sy), (int) (z + sz)),
									BingzhuikuaiBlock.block.getDefaultState(), 3);
						} else if (sy == 0 && Math.random() < 0.5) {
							world.setBlockState(new BlockPos((int) (x + sx), (int) (y + sy), (int) (z + sz)),
									BingzhuikuaiBlock.block.getDefaultState(), 3);
						}
					}
					sz = (sz + 1);
				}
				sy = (sy + 1);
			}
			sx = (sx + 1);
		}
		prob = 1;
		dy = 1;
		world.setBlockState(new BlockPos((int) x, (int) y, (int) z), BingzhuikuaiBlock.block.getDefaultState(), 3);
		if ((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.AIR) {
			if (Math.random() < 0.1) {
				world.setBlockState(new BlockPos((int) x, (int) (y - 1), (int) z), SssmallbingzhuiblockBlock.block.getDefaultState(), 3);
			} else {
				for (int index3 = 0; index3 < (int) (7); index3++) {
					if ((world.getBlockState(new BlockPos((int) x, (int) ((y - dy) - 1), (int) z))).getBlock() == Blocks.AIR
							&& Math.random() < prob) {
						world.setBlockState(new BlockPos((int) x, (int) (y - dy), (int) z), BigBingzhuiblockBlock.block.getDefaultState(), 3);
					} else {
						world.setBlockState(new BlockPos((int) x, (int) (y - dy), (int) z), SmallbingzhuiblockBlock.block.getDefaultState(), 3);
						break;
					}
					prob = (prob - 0.05);
					dy = (dy + 1);
				}
			}
		}
		if (dy == 8) {
			world.setBlockState(new BlockPos((int) x, (int) (y - dy), (int) z), SmallbingzhuiblockBlock.block.getDefaultState(), 3);
		}
	}
}
