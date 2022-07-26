package wwworld.procedures;

import wwworld.block.MoguWest1Block;
import wwworld.block.MoguSouth1Block;
import wwworld.block.MoguNorth1Block;
import wwworld.block.MoguEast1Block;

import wwworld.WwworldMod;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Mirror;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.block.BlockState;

import java.util.Map;

public class MogucunzhuangblockGengXinYouXiKeProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				WwworldMod.LOGGER.warn("Failed to load dependency world for procedure MogucunzhuangblockGengXinYouXiKe!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				WwworldMod.LOGGER.warn("Failed to load dependency x for procedure MogucunzhuangblockGengXinYouXiKe!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				WwworldMod.LOGGER.warn("Failed to load dependency y for procedure MogucunzhuangblockGengXinYouXiKe!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				WwworldMod.LOGGER.warn("Failed to load dependency z for procedure MogucunzhuangblockGengXinYouXiKe!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
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
			world.setBlockState(new BlockPos((int) (x + 3), (int) y, (int) z), MoguEast1Block.block.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) (x - 3), (int) y, (int) z), MoguWest1Block.block.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) x, (int) y, (int) (z + 3)), MoguNorth1Block.block.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) x, (int) y, (int) (z - 3)), MoguSouth1Block.block.getDefaultState(), 3);
		}
		if (new Object() {
			public double getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "time") == 30) {
			if (world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z))) != null
					&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z)))
							.equals(new ResourceLocation("wwworld:mo_gu_lin"))) {
				if (world instanceof ServerWorld) {
					Template template = ((ServerWorld) world).getStructureTemplateManager()
							.getTemplateDefaulted(new ResourceLocation("wwworld", "moguzhongxin"));
					if (template != null) {
						template.func_237144_a_((ServerWorld) world, new BlockPos((int) (x - 4), (int) (y - 2), (int) (z - 4)),
								new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
								((World) world).rand);
					}
				}
			}
			if (world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z))) != null
					&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z)))
							.equals(new ResourceLocation("wwworld:fan_mao_yi_lin"))) {
				if (world instanceof ServerWorld) {
					Template template = ((ServerWorld) world).getStructureTemplateManager()
							.getTemplateDefaulted(new ResourceLocation("wwworld", "mogucunzhuang2"));
					if (template != null) {
						template.func_237144_a_((ServerWorld) world, new BlockPos((int) (x - 4), (int) (y - 2), (int) (z - 4)),
								new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
								((World) world).rand);
					}
				}
			}
		}
	}
}
