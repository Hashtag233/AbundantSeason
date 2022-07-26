package wwworld.procedures;

import wwworld.WwworldMod;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.block.Blocks;

import java.util.Map;

public class Modcaveair1GengXinYouXiKeProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				WwworldMod.LOGGER.warn("Failed to load dependency world for procedure Modcaveair1GengXinYouXiKe!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				WwworldMod.LOGGER.warn("Failed to load dependency x for procedure Modcaveair1GengXinYouXiKe!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				WwworldMod.LOGGER.warn("Failed to load dependency y for procedure Modcaveair1GengXinYouXiKe!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				WwworldMod.LOGGER.warn("Failed to load dependency z for procedure Modcaveair1GengXinYouXiKe!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		double zsss = 0;
		double zsssss = 0;
		double ysss = 0;
		double xsss = 0;
		double yssss = 0;
		double xssss = 0;
		double xsssss = 0;
		double zssss = 0;
		double yss = 0;
		double zs = 0;
		double xss = 0;
		double ys = 0;
		double xs = 0;
		double zss = 0;
		double ysssss = 0;
		world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.CAVE_AIR.getDefaultState(), 3);
		zs = (-1);
		for (int index0 = 0; index0 < (int) (3); index0++) {
			xs = (-1);
			for (int index1 = 0; index1 < (int) (3); index1++) {
				ys = (-2);
				for (int index2 = 0; index2 < (int) (5); index2++) {
					ys = (ys + 1);
					if (BlockTags.getCollection().getTagByID(new ResourceLocation("wwworld:diaokefangkuai"))
							.contains((world.getBlockState(new BlockPos((int) (x + xs), (int) (y + ys), (int) (z + zs)))).getBlock())) {
						world.setBlockState(new BlockPos((int) (x + xs), (int) (y + ys), (int) (z + zs)), Blocks.CAVE_AIR.getDefaultState(), 3);
					}
				}
				xs = (xs + 1);
			}
			zs = (zs + 1);
		}
		zss = (-1);
		for (int index3 = 0; index3 < (int) (3); index3++) {
			xss = 2;
			for (int index4 = 0; index4 < (int) (1); index4++) {
				yss = (-1);
				for (int index5 = 0; index5 < (int) (3); index5++) {
					yss = (yss + 1);
					if (BlockTags.getCollection().getTagByID(new ResourceLocation("wwworld:diaokefangkuai"))
							.contains((world.getBlockState(new BlockPos((int) (x + xss), (int) (y + yss), (int) (z + zss)))).getBlock())) {
						world.setBlockState(new BlockPos((int) (x + xss), (int) (y + yss), (int) (z + zss)), Blocks.CAVE_AIR.getDefaultState(), 3);
					}
				}
				xss = (xss + 1);
			}
			zss = (zss + 1);
		}
		zsss = (-1);
		for (int index6 = 0; index6 < (int) (3); index6++) {
			xsss = (-2);
			for (int index7 = 0; index7 < (int) (1); index7++) {
				ysss = (-1);
				for (int index8 = 0; index8 < (int) (3); index8++) {
					ysss = (ysss + 1);
					if (BlockTags.getCollection().getTagByID(new ResourceLocation("wwworld:diaokefangkuai"))
							.contains((world.getBlockState(new BlockPos((int) (x + xsss), (int) (y + ysss), (int) (z + zsss)))).getBlock())) {
						world.setBlockState(new BlockPos((int) (x + xsss), (int) (y + ysss), (int) (z + zsss)), Blocks.CAVE_AIR.getDefaultState(), 3);
					}
				}
				xsss = (xsss + 1);
			}
			zsss = (zsss + 1);
		}
		zssss = 2;
		for (int index9 = 0; index9 < (int) (1); index9++) {
			xssss = (-1);
			for (int index10 = 0; index10 < (int) (3); index10++) {
				yssss = (-1);
				for (int index11 = 0; index11 < (int) (3); index11++) {
					yssss = (yssss + 1);
					if (BlockTags.getCollection().getTagByID(new ResourceLocation("wwworld:diaokefangkuai"))
							.contains((world.getBlockState(new BlockPos((int) (x + xssss), (int) (y + yssss), (int) (z + zssss)))).getBlock())) {
						world.setBlockState(new BlockPos((int) (x + xssss), (int) (y + yssss), (int) (z + zssss)), Blocks.CAVE_AIR.getDefaultState(),
								3);
					}
				}
				xssss = (xssss + 1);
			}
			zssss = (zssss + 1);
		}
		zsssss = (-2);
		for (int index12 = 0; index12 < (int) (1); index12++) {
			xsssss = (-1);
			for (int index13 = 0; index13 < (int) (3); index13++) {
				ysssss = (-1);
				for (int index14 = 0; index14 < (int) (3); index14++) {
					ysssss = (ysssss + 1);
					if (BlockTags.getCollection().getTagByID(new ResourceLocation("wwworld:diaokefangkuai"))
							.contains((world.getBlockState(new BlockPos((int) (x + xsssss), (int) (y + ysssss), (int) (z + zsssss)))).getBlock())) {
						world.setBlockState(new BlockPos((int) (x + xsssss), (int) (y + ysssss), (int) (z + zsssss)),
								Blocks.CAVE_AIR.getDefaultState(), 3);
					}
				}
				xsssss = (xsssss + 1);
			}
			zsssss = (zsssss + 1);
		}
	}
}
