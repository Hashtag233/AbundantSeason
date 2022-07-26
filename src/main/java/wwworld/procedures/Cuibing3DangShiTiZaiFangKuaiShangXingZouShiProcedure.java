package wwworld.procedures;

import wwworld.block.Cuibing3Block;

import wwworld.WwworldModVariables;

import wwworld.WwworldMod;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import java.util.Map;

public class Cuibing3DangShiTiZaiFangKuaiShangXingZouShiProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				WwworldMod.LOGGER.warn("Failed to load dependency world for procedure Cuibing3DangShiTiZaiFangKuaiShangXingZouShi!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				WwworldMod.LOGGER.warn("Failed to load dependency x for procedure Cuibing3DangShiTiZaiFangKuaiShangXingZouShi!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				WwworldMod.LOGGER.warn("Failed to load dependency y for procedure Cuibing3DangShiTiZaiFangKuaiShangXingZouShi!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				WwworldMod.LOGGER.warn("Failed to load dependency z for procedure Cuibing3DangShiTiZaiFangKuaiShangXingZouShi!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				WwworldMod.LOGGER.warn("Failed to load dependency entity for procedure Cuibing3DangShiTiZaiFangKuaiShangXingZouShi!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if (new Object() {
			public double getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "posui") == 1 && entity instanceof PlayerEntity) {
			{
				double _setval = ((entity.getCapability(WwworldModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new WwworldModVariables.PlayerVariables())).cuibing40 + 1);
				entity.getCapability(WwworldModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.cuibing40 = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.WATER.getDefaultState(), 3);
			if ((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == Cuibing3Block.block) {
				world.destroyBlock(new BlockPos((int) (x + 1), (int) y, (int) z), false);
				world.setBlockState(new BlockPos((int) (x + 1), (int) y, (int) z), Blocks.WATER.getDefaultState(), 3);
			}
			if ((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == Cuibing3Block.block) {
				world.destroyBlock(new BlockPos((int) (x - 1), (int) y, (int) z), false);
				world.setBlockState(new BlockPos((int) (x - 1), (int) y, (int) z), Blocks.WATER.getDefaultState(), 3);
			}
			if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == Cuibing3Block.block) {
				world.destroyBlock(new BlockPos((int) x, (int) y, (int) (z + 1)), false);
				world.setBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)), Blocks.WATER.getDefaultState(), 3);
			}
			if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == Cuibing3Block.block) {
				world.destroyBlock(new BlockPos((int) x, (int) y, (int) (z - 1)), false);
				world.setBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)), Blocks.WATER.getDefaultState(), 3);
			}
		}
	}
}
