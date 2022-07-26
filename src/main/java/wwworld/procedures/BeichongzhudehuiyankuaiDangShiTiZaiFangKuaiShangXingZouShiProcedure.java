package wwworld.procedures;

import wwworld.entity.XixuechongEntity;

import wwworld.block.HuiyankuaiBlock;

import wwworld.WwworldMod;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.Entity;

import java.util.Map;

public class BeichongzhudehuiyankuaiDangShiTiZaiFangKuaiShangXingZouShiProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				WwworldMod.LOGGER.warn("Failed to load dependency world for procedure BeichongzhudehuiyankuaiDangShiTiZaiFangKuaiShangXingZouShi!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				WwworldMod.LOGGER.warn("Failed to load dependency x for procedure BeichongzhudehuiyankuaiDangShiTiZaiFangKuaiShangXingZouShi!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				WwworldMod.LOGGER.warn("Failed to load dependency y for procedure BeichongzhudehuiyankuaiDangShiTiZaiFangKuaiShangXingZouShi!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				WwworldMod.LOGGER.warn("Failed to load dependency z for procedure BeichongzhudehuiyankuaiDangShiTiZaiFangKuaiShangXingZouShi!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				WwworldMod.LOGGER.warn("Failed to load dependency entity for procedure BeichongzhudehuiyankuaiDangShiTiZaiFangKuaiShangXingZouShi!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if (!entity.isSneaking() && entity instanceof PlayerEntity) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), HuiyankuaiBlock.block.getDefaultState(), 3);
			if (Math.random() < 0.75) {
				if (world instanceof ServerWorld) {
					Entity entityToSpawn = new XixuechongEntity.CustomEntity(XixuechongEntity.entity, (World) world);
					entityToSpawn.setLocationAndAngles((Math.floor(x) + 0.5), (y + 1), (Math.floor(z) + 0.5), world.getRandom().nextFloat() * 360F,
							0);
					if (entityToSpawn instanceof MobEntity)
						((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
								SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
					world.addEntity(entityToSpawn);
				}
			}
		}
	}
}
