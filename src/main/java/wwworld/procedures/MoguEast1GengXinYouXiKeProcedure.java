package wwworld.procedures;

import wwworld.block.PlantRemoverTechBlockBlock;
import wwworld.block.MoguEast1rightBlock;
import wwworld.block.MoguEast1leftBlock;
import wwworld.block.DianGuKuaiBlock;

import wwworld.WwworldMod;

import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tags.BlockTags;

import java.util.Map;

public class MoguEast1GengXinYouXiKeProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				WwworldMod.LOGGER.warn("Failed to load dependency world for procedure MoguEast1GengXinYouXiKe!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				WwworldMod.LOGGER.warn("Failed to load dependency x for procedure MoguEast1GengXinYouXiKe!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				WwworldMod.LOGGER.warn("Failed to load dependency y for procedure MoguEast1GengXinYouXiKe!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				WwworldMod.LOGGER.warn("Failed to load dependency z for procedure MoguEast1GengXinYouXiKe!");
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
			roadEast = (roadEast + 1);
			h1 = (world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) (x + roadEast), (int) z));
			while (h1 >= 0) {
				if (!BlockTags.getCollection().getTagByID(new ResourceLocation("wwworld:road_spawn_ignore"))
						.contains((world.getBlockState(new BlockPos((int) (x + roadEast), (int) h1, (int) z))).getBlock())) {
					break;
				} else {
					h1 = (h1 - 1);
				}
			}
			if (Math.random() < 0.9) {
				world.setBlockState(new BlockPos((int) (x + roadEast), (int) h1, (int) z), DianGuKuaiBlock.block.getDefaultState(), 3);
			}
			h2 = (world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) (x + roadEast), (int) (z - 1)));
			while (h2 >= 0) {
				if (!BlockTags.getCollection().getTagByID(new ResourceLocation("wwworld:road_spawn_ignore"))
						.contains((world.getBlockState(new BlockPos((int) (x + roadEast), (int) h2, (int) (z - 1)))).getBlock())) {
					break;
				} else {
					h2 = (h2 - 1);
				}
			}
			if (Math.random() < 0.9) {
				world.setBlockState(new BlockPos((int) (x + roadEast), (int) h2, (int) (z - 1)), DianGuKuaiBlock.block.getDefaultState(), 3);
			}
			h3 = (world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) (x + roadEast), (int) (z + 1)));
			while (h3 >= 0) {
				if (!BlockTags.getCollection().getTagByID(new ResourceLocation("wwworld:road_spawn_ignore"))
						.contains((world.getBlockState(new BlockPos((int) (x + roadEast), (int) h3, (int) (z + 1)))).getBlock())) {
					break;
				} else {
					h3 = (h3 - 1);
				}
			}
			if (Math.random() < 0.9) {
				world.setBlockState(new BlockPos((int) (x + roadEast), (int) h3, (int) (z + 1)), DianGuKuaiBlock.block.getDefaultState(), 3);
			}
			if (roadEast == 17) {
				world.setBlockState(new BlockPos((int) (x + 17), (int) (h2 + 1), (int) (z - 2)), MoguEast1leftBlock.block.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) (x + 17), (int) (h2 + 1), (int) (z - 5)), PlantRemoverTechBlockBlock.block.getDefaultState(),
						3);
			}
			if (roadEast == 23) {
				world.setBlockState(new BlockPos((int) (x + 23), (int) (h3 + 1), (int) (z + 2)), MoguEast1rightBlock.block.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) (x + 23), (int) (h3 + 1), (int) (z + 5)), PlantRemoverTechBlockBlock.block.getDefaultState(),
						3);
			}
			if (roadEast == 28) {
				world.setBlockState(new BlockPos((int) (x + 28), (int) (h2 + 1), (int) (z - 2)), MoguEast1leftBlock.block.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) (x + 28), (int) (h2 + 1), (int) (z - 5)), PlantRemoverTechBlockBlock.block.getDefaultState(),
						3);
			}
			if (roadEast == 34) {
				world.setBlockState(new BlockPos((int) (x + 34), (int) (h3 + 1), (int) (z + 2)), MoguEast1rightBlock.block.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) (x + 34), (int) (h3 + 1), (int) (z + 5)), PlantRemoverTechBlockBlock.block.getDefaultState(),
						3);
			}
			if (roadEast == 39) {
				world.setBlockState(new BlockPos((int) (x + 39), (int) (h2 + 1), (int) (z - 2)), MoguEast1leftBlock.block.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) (x + 39), (int) (h2 + 1), (int) (z - 5)), PlantRemoverTechBlockBlock.block.getDefaultState(),
						3);
			}
			if (roadEast == 45) {
				world.setBlockState(new BlockPos((int) (x + 45), (int) (h3 + 1), (int) (z + 2)), MoguEast1rightBlock.block.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) (x + 45), (int) (h3 + 1), (int) (z + 5)), PlantRemoverTechBlockBlock.block.getDefaultState(),
						3);
			}
			if (roadEast == 50) {
				world.setBlockState(new BlockPos((int) (x + 50), (int) (h2 + 1), (int) (z - 2)), MoguEast1leftBlock.block.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) (x + 50), (int) (h2 + 1), (int) (z - 5)), PlantRemoverTechBlockBlock.block.getDefaultState(),
						3);
			}
			if (roadEast == 56) {
				world.setBlockState(new BlockPos((int) (x + 56), (int) (h3 + 1), (int) (z + 2)), MoguEast1rightBlock.block.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) (x + 56), (int) (h3 + 1), (int) (z + 5)), PlantRemoverTechBlockBlock.block.getDefaultState(),
						3);
			}
			if (roadEast == 61) {
				world.setBlockState(new BlockPos((int) (x + 61), (int) (h2 + 1), (int) (z - 2)), MoguEast1leftBlock.block.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) (x + 61), (int) (h2 + 1), (int) (z - 5)), PlantRemoverTechBlockBlock.block.getDefaultState(),
						3);
			}
			if (roadEast == 67) {
				world.setBlockState(new BlockPos((int) (x + 67), (int) (h3 + 1), (int) (z + 2)), MoguEast1rightBlock.block.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) (x + 67), (int) (h3 + 1), (int) (z + 5)), PlantRemoverTechBlockBlock.block.getDefaultState(),
						3);
			}
			if (roadEast == 72) {
				world.setBlockState(new BlockPos((int) (x + 72), (int) (h2 + 1), (int) (z - 2)), MoguEast1leftBlock.block.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) (x + 72), (int) (h2 + 1), (int) (z - 5)), PlantRemoverTechBlockBlock.block.getDefaultState(),
						3);
			}
			if (roadEast == 78) {
				world.setBlockState(new BlockPos((int) (x + 78), (int) (h3 + 1), (int) (z + 2)), MoguEast1rightBlock.block.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) (x + 78), (int) (h3 + 1), (int) (z + 5)), PlantRemoverTechBlockBlock.block.getDefaultState(),
						3);
			}
			if (roadEast == 83) {
				world.setBlockState(new BlockPos((int) (x + 83), (int) (h2 + 1), (int) (z - 2)), MoguEast1leftBlock.block.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) (x + 83), (int) (h2 + 1), (int) (z - 5)), PlantRemoverTechBlockBlock.block.getDefaultState(),
						3);
			}
			if (roadEast == 89) {
				world.setBlockState(new BlockPos((int) (x + 89), (int) (h3 + 1), (int) (z + 2)), MoguEast1rightBlock.block.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) (x + 89), (int) (h3 + 1), (int) (z + 5)), PlantRemoverTechBlockBlock.block.getDefaultState(),
						3);
			}
			if (roadEast == 94) {
				world.setBlockState(new BlockPos((int) (x + 94), (int) (h2 + 1), (int) (z - 2)), MoguEast1leftBlock.block.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) (x + 94), (int) (h2 + 1), (int) (z - 5)), PlantRemoverTechBlockBlock.block.getDefaultState(),
						3);
			}
			if (roadEast == 100) {
				world.setBlockState(new BlockPos((int) (x + 100), (int) (h3 + 1), (int) (z + 2)), MoguEast1rightBlock.block.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) (x + 100), (int) (h3 + 1), (int) (z + 5)), PlantRemoverTechBlockBlock.block.getDefaultState(),
						3);
			}
		}
		world.setBlockState(new BlockPos((int) x, (int) y, (int) z), DianGuKuaiBlock.block.getDefaultState(), 3);
	}
}
