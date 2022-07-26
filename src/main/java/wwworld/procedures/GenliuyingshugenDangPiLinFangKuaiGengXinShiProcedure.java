package wwworld.procedures;

import wwworld.item.GenliufenItem;

import wwworld.block.YinggenkuaiBlock;

import wwworld.WwworldMod;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.block.Block;

import java.util.Map;

public class GenliuyingshugenDangPiLinFangKuaiGengXinShiProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				WwworldMod.LOGGER.warn("Failed to load dependency world for procedure GenliuyingshugenDangPiLinFangKuaiGengXinShi!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				WwworldMod.LOGGER.warn("Failed to load dependency x for procedure GenliuyingshugenDangPiLinFangKuaiGengXinShi!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				WwworldMod.LOGGER.warn("Failed to load dependency y for procedure GenliuyingshugenDangPiLinFangKuaiGengXinShi!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				WwworldMod.LOGGER.warn("Failed to load dependency z for procedure GenliuyingshugenDangPiLinFangKuaiGengXinShi!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if (!((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == YinggenkuaiBlock.block)) {
			if (world instanceof World) {
				Block.spawnDrops(world.getBlockState(new BlockPos((int) x, (int) y, (int) z)), (World) world,
						new BlockPos((int) x, (int) y, (int) z));
				world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
			}
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.5), (y + 0.5), (z + 0.5), new ItemStack(GenliufenItem.block));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			if (Math.random() < 0.45) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.5), (y + 0.5), (z + 0.5), new ItemStack(GenliufenItem.block));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
			}
		}
	}
}
