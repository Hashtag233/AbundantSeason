package wwworld.procedures;

import wwworld.block.MagmaBlock1Block;

import wwworld.WwworldMod;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import java.util.Random;
import java.util.Map;

public class ZhirexingzheBootsTickEventProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				WwworldMod.LOGGER.warn("Failed to load dependency world for procedure ZhirexingzheBootsTickEvent!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				WwworldMod.LOGGER.warn("Failed to load dependency x for procedure ZhirexingzheBootsTickEvent!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				WwworldMod.LOGGER.warn("Failed to load dependency y for procedure ZhirexingzheBootsTickEvent!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				WwworldMod.LOGGER.warn("Failed to load dependency z for procedure ZhirexingzheBootsTickEvent!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				WwworldMod.LOGGER.warn("Failed to load dependency entity for procedure ZhirexingzheBootsTickEvent!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				WwworldMod.LOGGER.warn("Failed to load dependency itemstack for procedure ZhirexingzheBootsTickEvent!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		double sx = 0;
		double sz = 0;
		if (entity.isInWater()) {
			{
				ItemStack _ist = itemstack;
				if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
					_ist.shrink(1);
					_ist.setDamage(0);
				}
			}
		}
		sx = (-4);
		for (int index0 = 0; index0 < (int) (9); index0++) {
			sz = (-4);
			for (int index1 = 0; index1 < (int) (9); index1++) {
				if (sx * sx + sz * sz <= 16) {
					if ((world.getBlockState(new BlockPos((int) (x - 0.5 + sx), (int) (y - 1), (int) (z - 0.5 + sz)))).getBlock() == Blocks.LAVA
							&& (world.getBlockState(new BlockPos((int) (x - 0.5 + sx), (int) (y - 1), (int) (z - 0.5 + sz)))).getFluidState()
									.isSource()) {
						world.setBlockState(new BlockPos((int) (x - 0.5 + sx), (int) (y - 1), (int) (z - 0.5 + sz)),
								MagmaBlock1Block.block.getDefaultState(), 3);
					}
				}
				sz = (sz + 1);
			}
			sx = (sx + 1);
		}
	}
}
