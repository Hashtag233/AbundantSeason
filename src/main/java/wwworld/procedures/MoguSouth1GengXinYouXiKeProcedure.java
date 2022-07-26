package wwworld.procedures;

import wwworld.block.PlantRemoverTechBlockBlock;
import wwworld.block.MoguNorth1rightBlock;
import wwworld.block.MoguNorth1leftBlock;
import wwworld.block.DianGuKuaiBlock;

import wwworld.WwworldMod;

import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tags.BlockTags;

import java.util.Map;

public class MoguSouth1GengXinYouXiKeProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				WwworldMod.LOGGER.warn("Failed to load dependency world for procedure MoguSouth1GengXinYouXiKe!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				WwworldMod.LOGGER.warn("Failed to load dependency x for procedure MoguSouth1GengXinYouXiKe!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				WwworldMod.LOGGER.warn("Failed to load dependency y for procedure MoguSouth1GengXinYouXiKe!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				WwworldMod.LOGGER.warn("Failed to load dependency z for procedure MoguSouth1GengXinYouXiKe!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		double count = 0;
		double h1 = 0;
		double h2 = 0;
		double h3 = 0;
		double roadEast = 0;
		count = (18 + Math.floor(Math.random() * 85));
		for (int index0 = 0; index0 < (int) (count); index0++) {
			roadEast = (roadEast - 1);
			h1 = (world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z + roadEast)));
			while (h1 >= 0) {
				if (!BlockTags.getCollection().getTagByID(new ResourceLocation("wwworld:road_spawn_ignore"))
						.contains((world.getBlockState(new BlockPos((int) x, (int) h1, (int) (z + roadEast)))).getBlock())) {
					break;
				} else {
					h1 = (h1 - 1);
				}
			}
			if (Math.random() < 0.9) {
				world.setBlockState(new BlockPos((int) x, (int) h1, (int) (z + roadEast)), DianGuKuaiBlock.block.getDefaultState(), 3);
			}
			h2 = (world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) (x - 1), (int) (z + roadEast)));
			while (h2 >= 0) {
				if (!BlockTags.getCollection().getTagByID(new ResourceLocation("wwworld:road_spawn_ignore"))
						.contains((world.getBlockState(new BlockPos((int) (x - 1), (int) h2, (int) (z + roadEast)))).getBlock())) {
					break;
				} else {
					h2 = (h2 - 1);
				}
			}
			if (Math.random() < 0.9) {
				world.setBlockState(new BlockPos((int) (x - 1), (int) h2, (int) (z + roadEast)), DianGuKuaiBlock.block.getDefaultState(), 3);
			}
			h3 = (world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) (x + 1), (int) (z + roadEast)));
			while (h3 >= 0) {
				if (!BlockTags.getCollection().getTagByID(new ResourceLocation("wwworld:road_spawn_ignore"))
						.contains((world.getBlockState(new BlockPos((int) (x + 1), (int) h3, (int) (z + roadEast)))).getBlock())) {
					break;
				} else {
					h3 = (h3 - 1);
				}
			}
			if (Math.random() < 0.9) {
				world.setBlockState(new BlockPos((int) (x + 1), (int) h3, (int) (z + roadEast)), DianGuKuaiBlock.block.getDefaultState(), 3);
			}
			if (roadEast == -17) {
				world.setBlockState(new BlockPos((int) (x - 2), (int) (h2 + 1), (int) (z - 17)), MoguNorth1rightBlock.block.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) (x - 5), (int) (h2 + 1), (int) (z - 17)), PlantRemoverTechBlockBlock.block.getDefaultState(),
						3);
			}
			if (roadEast == -23) {
				world.setBlockState(new BlockPos((int) (x + 2), (int) (h3 + 1), (int) (z - 23)), MoguNorth1leftBlock.block.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) (x + 5), (int) (h3 + 1), (int) (z - 23)), PlantRemoverTechBlockBlock.block.getDefaultState(),
						3);
			}
			if (roadEast == -28) {
				world.setBlockState(new BlockPos((int) (x - 2), (int) (h2 + 1), (int) (z - 28)), MoguNorth1rightBlock.block.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) (x - 5), (int) (h2 + 1), (int) (z - 28)), PlantRemoverTechBlockBlock.block.getDefaultState(),
						3);
			}
			if (roadEast == -34) {
				world.setBlockState(new BlockPos((int) (x + 2), (int) (h3 + 1), (int) (z - 34)), MoguNorth1leftBlock.block.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) (x + 5), (int) (h3 + 1), (int) (z - 34)), PlantRemoverTechBlockBlock.block.getDefaultState(),
						3);
			}
			if (roadEast == -39) {
				world.setBlockState(new BlockPos((int) (x - 2), (int) (h2 + 1), (int) (z - 39)), MoguNorth1rightBlock.block.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) (x - 5), (int) (h2 + 1), (int) (z - 39)), PlantRemoverTechBlockBlock.block.getDefaultState(),
						3);
			}
			if (roadEast == -45) {
				world.setBlockState(new BlockPos((int) (x + 2), (int) (h3 + 1), (int) (z - 45)), MoguNorth1leftBlock.block.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) (x + 5), (int) (h3 + 1), (int) (z - 45)), PlantRemoverTechBlockBlock.block.getDefaultState(),
						3);
			}
			if (roadEast == -50) {
				world.setBlockState(new BlockPos((int) (x - 2), (int) (h2 + 1), (int) (z - 50)), MoguNorth1rightBlock.block.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) (x - 5), (int) (h2 + 1), (int) (z - 50)), PlantRemoverTechBlockBlock.block.getDefaultState(),
						3);
			}
			if (roadEast == -56) {
				world.setBlockState(new BlockPos((int) (x + 2), (int) (h3 + 1), (int) (z - 56)), MoguNorth1leftBlock.block.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) (x + 5), (int) (h3 + 1), (int) (z - 56)), PlantRemoverTechBlockBlock.block.getDefaultState(),
						3);
			}
			if (roadEast == -61) {
				world.setBlockState(new BlockPos((int) (x - 2), (int) (h2 + 1), (int) (z - 61)), MoguNorth1rightBlock.block.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) (x - 5), (int) (h2 + 1), (int) (z - 61)), PlantRemoverTechBlockBlock.block.getDefaultState(),
						3);
			}
			if (roadEast == -67) {
				world.setBlockState(new BlockPos((int) (x + 2), (int) (h3 + 1), (int) (z - 67)), MoguNorth1leftBlock.block.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) (x + 5), (int) (h3 + 1), (int) (z - 67)), PlantRemoverTechBlockBlock.block.getDefaultState(),
						3);
			}
			if (roadEast == -72) {
				world.setBlockState(new BlockPos((int) (x - 2), (int) (h2 + 1), (int) (z - 72)), MoguNorth1rightBlock.block.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) (x - 5), (int) (h2 + 1), (int) (z - 72)), PlantRemoverTechBlockBlock.block.getDefaultState(),
						3);
			}
			if (roadEast == -78) {
				world.setBlockState(new BlockPos((int) (x + 2), (int) (h3 + 1), (int) (z - 78)), MoguNorth1leftBlock.block.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) (x + 5), (int) (h3 + 1), (int) (z - 78)), PlantRemoverTechBlockBlock.block.getDefaultState(),
						3);
			}
			if (roadEast == -83) {
				world.setBlockState(new BlockPos((int) (x - 2), (int) (h2 + 1), (int) (z - 83)), MoguNorth1rightBlock.block.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) (x - 5), (int) (h2 + 1), (int) (z - 83)), PlantRemoverTechBlockBlock.block.getDefaultState(),
						3);
			}
			if (roadEast == -89) {
				world.setBlockState(new BlockPos((int) (x + 2), (int) (h3 + 1), (int) (z - 89)), MoguNorth1leftBlock.block.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) (x + 5), (int) (h3 + 1), (int) (z - 89)), PlantRemoverTechBlockBlock.block.getDefaultState(),
						3);
			}
			if (roadEast == -94) {
				world.setBlockState(new BlockPos((int) (x - 2), (int) (h2 + 1), (int) (z - 94)), MoguNorth1rightBlock.block.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) (x - 5), (int) (h2 + 1), (int) (z - 94)), PlantRemoverTechBlockBlock.block.getDefaultState(),
						3);
			}
			if (roadEast == -100) {
				world.setBlockState(new BlockPos((int) (x + 2), (int) (h3 + 1), (int) (z - 100)), MoguNorth1leftBlock.block.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) (x + 5), (int) (h3 + 1), (int) (z - 100)), PlantRemoverTechBlockBlock.block.getDefaultState(),
						3);
			}
		}
		world.setBlockState(new BlockPos((int) x, (int) y, (int) z), DianGuKuaiBlock.block.getDefaultState(), 3);
	}
}
