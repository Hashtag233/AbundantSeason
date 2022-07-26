package wwworld.procedures;

import wwworld.block.SongguodongBlock;
import wwworld.block.ShuyeBlock;
import wwworld.block.ShumuBlock;
import wwworld.block.CaofangkuaiBlock;

import wwworld.WwworldMod;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.block.BlockState;

import java.util.Map;

public class SongshujishublockGengXinYouXiKeProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				WwworldMod.LOGGER.warn("Failed to load dependency world for procedure SongshujishublockGengXinYouXiKe!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				WwworldMod.LOGGER.warn("Failed to load dependency x for procedure SongshujishublockGengXinYouXiKe!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				WwworldMod.LOGGER.warn("Failed to load dependency y for procedure SongshujishublockGengXinYouXiKe!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				WwworldMod.LOGGER.warn("Failed to load dependency z for procedure SongshujishublockGengXinYouXiKe!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		double h = 0;
		world.setBlockState(new BlockPos((int) (x + 1), (int) (y + 1), (int) z), ShumuBlock.block.getDefaultState(), 3);
		world.setBlockState(new BlockPos((int) (x - 1), (int) (y + 1), (int) z), ShumuBlock.block.getDefaultState(), 3);
		world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z + 1)), ShumuBlock.block.getDefaultState(), 3);
		world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z - 1)), ShumuBlock.block.getDefaultState(), 3);
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
			h = 1;
		}
		if (new Object() {
			public double getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "timer") == 2) {
			for (int index0 = 0; index0 < (int) (7); index0++) {
				h = (h + 1);
				world.setBlockState(new BlockPos((int) x, (int) (y + h), (int) z), ShumuBlock.block.getDefaultState(), 3);
			}
			world.setBlockState(new BlockPos((int) (x + 1), (int) (y + 8), (int) z), ShuyeBlock.block.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) (x - 1), (int) (y + 8), (int) z), ShuyeBlock.block.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) x, (int) (y + 8), (int) (z + 1)), ShuyeBlock.block.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) x, (int) (y + 8), (int) (z - 1)), ShuyeBlock.block.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) x, (int) (y + 8 + 1), (int) z), ShuyeBlock.block.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) (x + 1), (int) (y + 6), (int) z), ShuyeBlock.block.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) (x - 1), (int) (y + 6), (int) z), ShuyeBlock.block.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) x, (int) (y + 6), (int) (z + 1)), ShuyeBlock.block.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) x, (int) (y + 6), (int) (z - 1)), ShuyeBlock.block.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) (x + 2), (int) (y + 6), (int) z), ShuyeBlock.block.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) (x - 2), (int) (y + 6), (int) z), ShuyeBlock.block.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) x, (int) (y + 6), (int) (z + 2)), ShuyeBlock.block.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) x, (int) (y + 6), (int) (z - 2)), ShuyeBlock.block.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) (x + 1), (int) (y + 6), (int) (z + 1)), ShuyeBlock.block.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) (x + 1), (int) (y + 6), (int) (z - 1)), ShuyeBlock.block.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) (x - 1), (int) (y + 6), (int) (z + 1)), ShuyeBlock.block.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) (x - 1), (int) (y + 6), (int) (z - 1)), ShuyeBlock.block.getDefaultState(), 3);
			if (Math.random() <= 0.75) {
				world.setBlockState(new BlockPos((int) (x + 2), (int) (y + 5), (int) z), SongguodongBlock.block.getDefaultState(), 3);
			}
			if (Math.random() <= 0.75) {
				world.setBlockState(new BlockPos((int) (x - 2), (int) (y + 5), (int) z), SongguodongBlock.block.getDefaultState(), 3);
			}
			if (Math.random() <= 0.75) {
				world.setBlockState(new BlockPos((int) x, (int) (y + 5), (int) (z + 2)), SongguodongBlock.block.getDefaultState(), 3);
			}
			if (Math.random() <= 0.75) {
				world.setBlockState(new BlockPos((int) x, (int) (y + 5), (int) (z - 2)), SongguodongBlock.block.getDefaultState(), 3);
			}
		}
		if (new Object() {
			public double getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "timer") == 3) {
			try {
				BlockState _bs = world.getBlockState(new BlockPos((int) (x + 2), (int) (y + 5), (int) z));
				DirectionProperty _property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
				if (_property != null) {
					world.setBlockState(new BlockPos((int) (x + 2), (int) (y + 5), (int) z), _bs.with(_property, Direction.EAST), 3);
				} else {
					world.setBlockState(new BlockPos((int) (x + 2), (int) (y + 5), (int) z),
							_bs.with((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis"), Direction.EAST.getAxis()),
							3);
				}
			} catch (Exception e) {
			}
			try {
				BlockState _bs = world.getBlockState(new BlockPos((int) (x - 2), (int) (y + 5), (int) z));
				DirectionProperty _property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
				if (_property != null) {
					world.setBlockState(new BlockPos((int) (x - 2), (int) (y + 5), (int) z), _bs.with(_property, Direction.WEST), 3);
				} else {
					world.setBlockState(new BlockPos((int) (x - 2), (int) (y + 5), (int) z),
							_bs.with((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis"), Direction.WEST.getAxis()),
							3);
				}
			} catch (Exception e) {
			}
			try {
				BlockState _bs = world.getBlockState(new BlockPos((int) x, (int) (y + 5), (int) (z + 2)));
				DirectionProperty _property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
				if (_property != null) {
					world.setBlockState(new BlockPos((int) x, (int) (y + 5), (int) (z + 2)), _bs.with(_property, Direction.SOUTH), 3);
				} else {
					world.setBlockState(new BlockPos((int) x, (int) (y + 5), (int) (z + 2)), _bs.with(
							(EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis"), Direction.SOUTH.getAxis()), 3);
				}
			} catch (Exception e) {
			}
			try {
				BlockState _bs = world.getBlockState(new BlockPos((int) x, (int) (y + 5), (int) (z - 2)));
				DirectionProperty _property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
				if (_property != null) {
					world.setBlockState(new BlockPos((int) x, (int) (y + 5), (int) (z - 2)), _bs.with(_property, Direction.NORTH), 3);
				} else {
					world.setBlockState(new BlockPos((int) x, (int) (y + 5), (int) (z - 2)), _bs.with(
							(EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis"), Direction.NORTH.getAxis()), 3);
				}
			} catch (Exception e) {
			}
		}
		if (new Object() {
			public double getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "timer") == 4) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), CaofangkuaiBlock.block.getDefaultState(), 3);
		}
	}
}
