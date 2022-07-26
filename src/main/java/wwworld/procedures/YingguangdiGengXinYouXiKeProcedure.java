package wwworld.procedures;

import wwworld.block.YingguangdingaBlock;
import wwworld.block.YingguangdiBlock;
import wwworld.block.YinggenkuaiBlock;
import wwworld.block.QiuzhicaofangkuaiBlock;
import wwworld.block.JishiBlock;

import wwworld.WwworldMod;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import java.util.Map;

public class YingguangdiGengXinYouXiKeProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				WwworldMod.LOGGER.warn("Failed to load dependency world for procedure YingguangdiGengXinYouXiKe!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				WwworldMod.LOGGER.warn("Failed to load dependency x for procedure YingguangdiGengXinYouXiKe!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				WwworldMod.LOGGER.warn("Failed to load dependency y for procedure YingguangdiGengXinYouXiKe!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				WwworldMod.LOGGER.warn("Failed to load dependency z for procedure YingguangdiGengXinYouXiKe!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if (!world.isRemote()) {
			BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
			TileEntity _tileEntity = world.getTileEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_tileEntity != null)
				_tileEntity.getTileData().putDouble("time", (new Object() {
					public double getValue(IWorld world, BlockPos pos, String tag) {
						TileEntity tileEntity = world.getTileEntity(pos);
						if (tileEntity != null)
							return tileEntity.getTileData().getDouble(tag);
						return -1;
					}
				}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "time") + 1));
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
		}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "time") == 1) {
			for (int index0 = 0; index0 < (int) (50); index0++) {
				if (!(new Object() {
					public double getValue(IWorld world, BlockPos pos, String tag) {
						TileEntity tileEntity = world.getTileEntity(pos);
						if (tileEntity != null)
							return tileEntity.getTileData().getDouble(tag);
						return -1;
					}
				}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "stay") == 1)) {
					if (!world.isRemote()) {
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putDouble("yy", (new Object() {
								public double getValue(IWorld world, BlockPos pos, String tag) {
									TileEntity tileEntity = world.getTileEntity(pos);
									if (tileEntity != null)
										return tileEntity.getTileData().getDouble(tag);
									return -1;
								}
							}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "yy") + 1));
						if (world instanceof World)
							((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
					if ((world.getBlockState(new BlockPos((int) x, (int) (new Object() {
						public double getValue(IWorld world, BlockPos pos, String tag) {
							TileEntity tileEntity = world.getTileEntity(pos);
							if (tileEntity != null)
								return tileEntity.getTileData().getDouble(tag);
							return -1;
						}
					}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "yy")), (int) z))).getBlock() == JishiBlock.block
							&& ((world.getBlockState(new BlockPos((int) x, (int) ((new Object() {
								public double getValue(IWorld world, BlockPos pos, String tag) {
									TileEntity tileEntity = world.getTileEntity(pos);
									if (tileEntity != null)
										return tileEntity.getTileData().getDouble(tag);
									return -1;
								}
							}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "yy")) - 1), (int) z))).getBlock() == Blocks.AIR
									|| (world.getBlockState(new BlockPos((int) x, (int) ((new Object() {
										public double getValue(IWorld world, BlockPos pos, String tag) {
											TileEntity tileEntity = world.getTileEntity(pos);
											if (tileEntity != null)
												return tileEntity.getTileData().getDouble(tag);
											return -1;
										}
									}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "yy")) - 1), (int) z)))
											.getBlock() == Blocks.CAVE_AIR)) {
						world.setBlockState(new BlockPos((int) x, (int) (new Object() {
							public double getValue(IWorld world, BlockPos pos, String tag) {
								TileEntity tileEntity = world.getTileEntity(pos);
								if (tileEntity != null)
									return tileEntity.getTileData().getDouble(tag);
								return -1;
							}
						}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "yy")), (int) z), YingguangdingaBlock.block.getDefaultState(), 3);
						if (!world.isRemote()) {
							BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
							TileEntity _tileEntity = world.getTileEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_tileEntity != null)
								_tileEntity.getTileData().putDouble("stay", 1);
							if (world instanceof World)
								((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
						}
					}
				}
			}
			sx = (-1);
			for (int index1 = 0; index1 < (int) (3); index1++) {
				sy = (-1);
				for (int index2 = 0; index2 < (int) (4); index2++) {
					sz = (-1);
					for (int index3 = 0; index3 < (int) (3); index3++) {
						if ((world.getBlockState(new BlockPos((int) (x + sx), (int) (y + sy), (int) (z + sz)))).getBlock() == JishiBlock.block
								&& ((world.getBlockState(new BlockPos((int) (x + sx), (int) (y + sy + 1), (int) (z + sz)))).getBlock() == Blocks.AIR
										|| (world.getBlockState(new BlockPos((int) (x + sx), (int) (y + sy + 1), (int) (z + sz))))
												.getBlock() == Blocks.CAVE_AIR)) {
							world.setBlockState(new BlockPos((int) (x + sx), (int) (y + sy), (int) (z + sz)),
									YingguangdiBlock.block.getDefaultState(), 3);
						}
						sz = (sz + 1);
					}
					sy = (sy + 1);
				}
				sx = (sx + 1);
			}
		}
		if (new Object() {
			public double getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "time") == 2) {
			if (world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z)).isSolid()
					&& world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z)).isSolid()
					&& world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1))).isSolid()
					&& world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1))).isSolid() && Math.random() < 0.08) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.WATER.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), Blocks.AIR.getDefaultState(), 3);
			} else if (Math.random() < 0.6) {
				if ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.CAVE_AIR
						|| (world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.AIR) {
					if (!world.isRemote()) {
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putDouble("notallow", 1);
						if (world instanceof World)
							((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
					world.setBlockState(new BlockPos((int) x, (int) y, (int) z), QiuzhicaofangkuaiBlock.block.getDefaultState(), 3);
					if (Math.random() < 0.2) {
						world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), Blocks.FERN.getDefaultState(), 3);
						world.setBlockState(new BlockPos((int) x, (int) y, (int) z), QiuzhicaofangkuaiBlock.block.getDefaultState(), 3);
					}
					if (Math.random() < 0.5) {
						world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), Blocks.GRASS.getDefaultState(), 3);
						world.setBlockState(new BlockPos((int) x, (int) y, (int) z), QiuzhicaofangkuaiBlock.block.getDefaultState(), 3);
					}
				}
			}
		}
		if (new Object() {
			public double getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "time") == 3 && !(new Object() {
			public double getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "notallow") == 1)) {
			if (Math.random() < 0.15) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), YinggenkuaiBlock.block.getDefaultState(), 3);
			} else {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), JishiBlock.block.getDefaultState(), 3);
			}
		}
	}
}
