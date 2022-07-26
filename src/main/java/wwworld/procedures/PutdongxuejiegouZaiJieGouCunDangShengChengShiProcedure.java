package wwworld.procedures;

import wwworld.block.PutDongxueBlock;

import wwworld.WwworldMod;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;

import java.util.Map;

public class PutdongxuejiegouZaiJieGouCunDangShengChengShiProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				WwworldMod.LOGGER.warn("Failed to load dependency world for procedure PutdongxuejiegouZaiJieGouCunDangShengChengShi!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				WwworldMod.LOGGER.warn("Failed to load dependency x for procedure PutdongxuejiegouZaiJieGouCunDangShengChengShi!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				WwworldMod.LOGGER.warn("Failed to load dependency y for procedure PutdongxuejiegouZaiJieGouCunDangShengChengShi!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				WwworldMod.LOGGER.warn("Failed to load dependency z for procedure PutdongxuejiegouZaiJieGouCunDangShengChengShi!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		double zs = 0;
		double ys = 0;
		double xs = 0;
		zs = (-100);
		for (int index0 = 0; index0 < (int) (200); index0++) {
			xs = (-100);
			for (int index1 = 0; index1 < (int) (20); index1++) {
				ys = (-15);
				for (int index2 = 0; index2 < (int) (30); index2++) {
					ys = (ys + 1);
					if ((world.getBlockState(new BlockPos((int) (x + xs), (int) (y + ys), (int) (z + zs)))).getBlock() == PutDongxueBlock.block) {
						world.setBlockState(new BlockPos((int) (x + xs), (int) (y + ys), (int) (z + zs)), Blocks.CAVE_AIR.getDefaultState(), 3);
					}
				}
				xs = (xs + 1);
			}
			zs = (zs + 1);
		}
		world.getPendingBlockTicks().scheduleTick(new BlockPos((int) x, (int) y, (int) z),
				world.getBlockState(new BlockPos((int) x, (int) y, (int) z)).getBlock(), (int) 2);
	}
}
