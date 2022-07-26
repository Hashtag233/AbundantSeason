package wwworld.procedures;

import wwworld.block.YuansuweiduBlock;
import wwworld.block.SijizhihuaBlock;
import wwworld.block.ChuansongmenBlock;

import wwworld.WwworldModVariables;

import wwworld.WwworldMod;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import java.util.function.Function;
import java.util.Map;
import java.util.Comparator;

public class YuansuweiduGengXinYouXiKeProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				WwworldMod.LOGGER.warn("Failed to load dependency world for procedure YuansuweiduGengXinYouXiKe!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				WwworldMod.LOGGER.warn("Failed to load dependency x for procedure YuansuweiduGengXinYouXiKe!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				WwworldMod.LOGGER.warn("Failed to load dependency y for procedure YuansuweiduGengXinYouXiKe!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				WwworldMod.LOGGER.warn("Failed to load dependency z for procedure YuansuweiduGengXinYouXiKe!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 2)))).getBlock() == YuansuweiduBlock.block
				&& (world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) (z - 1)))).getBlock() == YuansuweiduBlock.block
				&& (world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) (z + 3)))).getBlock() == YuansuweiduBlock.block
				&& (world.getBlockState(new BlockPos((int) (x + 3), (int) y, (int) (z - 1)))).getBlock() == YuansuweiduBlock.block
				&& (world.getBlockState(new BlockPos((int) (x + 3), (int) y, (int) (z + 3)))).getBlock() == YuansuweiduBlock.block
				&& (world.getBlockState(new BlockPos((int) (x + 4), (int) y, (int) (z + 2)))).getBlock() == YuansuweiduBlock.block
				&& (world.getBlockState(new BlockPos((int) (x + 4), (int) y, (int) z))).getBlock() == YuansuweiduBlock.block
				&& ((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == Blocks.WATER
						|| (world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == ChuansongmenBlock.block)
				&& ((world.getBlockState(new BlockPos((int) (x + 2), (int) y, (int) z))).getBlock() == Blocks.WATER
						|| (world.getBlockState(new BlockPos((int) (x + 2), (int) y, (int) z))).getBlock() == ChuansongmenBlock.block)
				&& ((world.getBlockState(new BlockPos((int) (x + 3), (int) y, (int) z))).getBlock() == Blocks.WATER
						|| (world.getBlockState(new BlockPos((int) (x + 3), (int) y, (int) z))).getBlock() == ChuansongmenBlock.block)
				&& ((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) (z + 1)))).getBlock() == Blocks.WATER
						|| (world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) (z + 1)))).getBlock() == ChuansongmenBlock.block)
				&& ((world.getBlockState(new BlockPos((int) (x + 2), (int) y, (int) (z + 1)))).getBlock() == Blocks.WATER
						|| (world.getBlockState(new BlockPos((int) (x + 2), (int) y, (int) (z + 1)))).getBlock() == ChuansongmenBlock.block)
				&& ((world.getBlockState(new BlockPos((int) (x + 3), (int) y, (int) (z + 1)))).getBlock() == Blocks.WATER
						|| (world.getBlockState(new BlockPos((int) (x + 3), (int) y, (int) (z + 1)))).getBlock() == ChuansongmenBlock.block)
				&& ((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) (z + 2)))).getBlock() == Blocks.WATER
						|| (world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) (z + 2)))).getBlock() == ChuansongmenBlock.block)
				&& ((world.getBlockState(new BlockPos((int) (x + 2), (int) y, (int) (z + 2)))).getBlock() == Blocks.WATER
						|| (world.getBlockState(new BlockPos((int) (x + 2), (int) y, (int) (z + 2)))).getBlock() == ChuansongmenBlock.block)
				&& ((world.getBlockState(new BlockPos((int) (x + 3), (int) y, (int) (z + 2)))).getBlock() == Blocks.WATER
						|| (world.getBlockState(new BlockPos((int) (x + 3), (int) y, (int) (z + 2)))).getBlock() == ChuansongmenBlock.block)
				&& (world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z + 1)))).getBlock() == SijizhihuaBlock.block
				&& (world.getBlockState(new BlockPos((int) (x + 4), (int) (y + 1), (int) (z + 1)))).getBlock() == SijizhihuaBlock.block
				&& (world.getBlockState(new BlockPos((int) (x + 2), (int) (y + 1), (int) (z - 1)))).getBlock() == SijizhihuaBlock.block
				&& (world.getBlockState(new BlockPos((int) (x + 2), (int) (y + 1), (int) (z + 3)))).getBlock() == SijizhihuaBlock.block) {
			if (((Entity) world.getEntitiesWithinAABB(ItemEntity.class, new AxisAlignedBB((x + 2) - (3 / 2d), (y - 1) - (3 / 2d), (z + 1) - (3 / 2d),
					(x + 2) + (3 / 2d), (y - 1) + (3 / 2d), (z + 1) + (3 / 2d)), null).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
						}
					}.compareDistOf((x + 2), (y - 1), (z + 1))).findFirst().orElse(null)) != null) {
				if ((new Object() {
					public ItemStack entityToItem(Entity _ent) {
						if (_ent instanceof ItemEntity) {
							return ((ItemEntity) _ent).getItem();
						}
						return ItemStack.EMPTY;
					}
				}.entityToItem(((Entity) world.getEntitiesWithinAABB(ItemEntity.class, new AxisAlignedBB((x + 2) - (3 / 2d), (y - 1) - (3 / 2d),
						(z + 1) - (3 / 2d), (x + 2) + (3 / 2d), (y - 1) + (3 / 2d), (z + 1) + (3 / 2d)), null).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
							}
						}.compareDistOf((x + 2), (y - 1), (z + 1))).findFirst().orElse(null)))).getItem() == Blocks.DIRT.asItem()) {
					if (world instanceof ServerWorld) {
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) (x + 2), (int) (y - 1), (int) (z + 1))));
						_ent.setEffectOnly(true);
						((World) world).addEntity(_ent);
					}
					if (!((Entity) world.getEntitiesWithinAABB(ItemEntity.class, new AxisAlignedBB((x + 2) - (3 / 2d), (y - 1) - (3 / 2d),
							(z + 1) - (3 / 2d), (x + 2) + (3 / 2d), (y - 1) + (3 / 2d), (z + 1) + (3 / 2d)), null).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
								}
							}.compareDistOf((x + 2), (y - 1), (z + 1))).findFirst().orElse(null)).world.isRemote())
						((Entity) world.getEntitiesWithinAABB(ItemEntity.class, new AxisAlignedBB((x + 2) - (3 / 2d), (y - 1) - (3 / 2d),
								(z + 1) - (3 / 2d), (x + 2) + (3 / 2d), (y - 1) + (3 / 2d), (z + 1) + (3 / 2d)), null).stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
									}
								}.compareDistOf((x + 2), (y - 1), (z + 1))).findFirst().orElse(null)).remove();
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"fill ~1 ~ ~ ~3 ~ ~2 wwworld:chuansongmen replace minecraft:water");
					}
					if (!world.isRemote()) {
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putBoolean("pointer", (true));
						if (world instanceof World)
							((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
					WwworldModVariables.MapVariables.get(world).surfaceTelePointX = x;
					WwworldModVariables.MapVariables.get(world).syncData(world);
					WwworldModVariables.MapVariables.get(world).surfaceTelePointZ = (z - 1);
					WwworldModVariables.MapVariables.get(world).syncData(world);
				}
			}
		} else {
			if ((new Object() {
				public boolean getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getBoolean(tag);
					return false;
				}
			}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "pointer")) == true) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"fill ~1 ~ ~ ~3 ~ ~2 minecraft:water replace wwworld:chuansongmen");
				}
			}
			if (!world.isRemote()) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putBoolean("pointer", (false));
				if (world instanceof World)
					((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
		}
	}
}
