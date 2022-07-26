package wwworld.procedures;

import wwworld.block.TianmiDingBlock;
import wwworld.block.TianmiDiBlock;
import wwworld.block.JishiBlock;
import wwworld.block.HoneyFlowerBlock;

import wwworld.WwworldMod;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import java.util.Map;

public class TianmiDiGengXinYouXiKeProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				WwworldMod.LOGGER.warn("Failed to load dependency world for procedure TianmiDiGengXinYouXiKe!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				WwworldMod.LOGGER.warn("Failed to load dependency x for procedure TianmiDiGengXinYouXiKe!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				WwworldMod.LOGGER.warn("Failed to load dependency y for procedure TianmiDiGengXinYouXiKe!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				WwworldMod.LOGGER.warn("Failed to load dependency z for procedure TianmiDiGengXinYouXiKe!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		double sx = 0;
		double dy = 0;
		double sy = 0;
		double sz = 0;
		double stay = 0;
		double yy = 0;
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
						}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "yy")), (int) z), TianmiDingBlock.block.getDefaultState(), 3);
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
							world.setBlockState(new BlockPos((int) (x + sx), (int) (y + sy), (int) (z + sz)), TianmiDiBlock.block.getDefaultState(),
									3);
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
			if (Math.random() < 0.6) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.HONEYCOMB_BLOCK.getDefaultState(), 3);
				if (Math.random() < 0.07) {
					world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), HoneyFlowerBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.HONEYCOMB_BLOCK.getDefaultState(), 3);
					if (!world.isRemote()) {
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putDouble("notallow", 1);
						if (world instanceof World)
							((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
				}
			}
			if (Math.random() < 0.03 && ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.AIR
					|| (world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.CAVE_AIR)) {
				if (world instanceof ServerWorld) {
					Entity entityToSpawn = new BeeEntity(EntityType.BEE, (World) world);
					entityToSpawn.setLocationAndAngles((Math.ceil(x) + 0.5), (y + 1), (Math.ceil(z) + 0.5), world.getRandom().nextFloat() * 360F, 0);
					if (entityToSpawn instanceof MobEntity)
						((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
								SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
					world.addEntity(entityToSpawn);
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
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.HONEY_BLOCK.getDefaultState(), 3);
		}
	}
}
