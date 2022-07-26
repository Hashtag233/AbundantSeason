package wwworld.procedures;

import wwworld.entity.VineEntity;

import wwworld.WwworldMod;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import java.util.Map;

public class VineQueenChuShiShiTiShengChengProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				WwworldMod.LOGGER.warn("Failed to load dependency world for procedure VineQueenChuShiShiTiShengCheng!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				WwworldMod.LOGGER.warn("Failed to load dependency x for procedure VineQueenChuShiShiTiShengCheng!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				WwworldMod.LOGGER.warn("Failed to load dependency y for procedure VineQueenChuShiShiTiShengCheng!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				WwworldMod.LOGGER.warn("Failed to load dependency z for procedure VineQueenChuShiShiTiShengCheng!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if (world instanceof ServerWorld) {
			Entity entityToSpawn = new VineEntity.CustomEntity(VineEntity.entity, (World) world);
			entityToSpawn.setLocationAndAngles((x + 1), y, (z + 1), (float) 0, (float) 0);
			entityToSpawn.setRenderYawOffset((float) 0);
			entityToSpawn.setRotationYawHead((float) 0);
			if (entityToSpawn instanceof MobEntity)
				((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
						SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
			world.addEntity(entityToSpawn);
		}
		if (world instanceof ServerWorld) {
			Entity entityToSpawn = new VineEntity.CustomEntity(VineEntity.entity, (World) world);
			entityToSpawn.setLocationAndAngles((x + 1), y, (z - 1), (float) 0, (float) 0);
			entityToSpawn.setRenderYawOffset((float) 0);
			entityToSpawn.setRotationYawHead((float) 0);
			if (entityToSpawn instanceof MobEntity)
				((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
						SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
			world.addEntity(entityToSpawn);
		}
		if (world instanceof ServerWorld) {
			Entity entityToSpawn = new VineEntity.CustomEntity(VineEntity.entity, (World) world);
			entityToSpawn.setLocationAndAngles((x - 1), y, (z + 1), (float) 0, (float) 0);
			entityToSpawn.setRenderYawOffset((float) 0);
			entityToSpawn.setRotationYawHead((float) 0);
			if (entityToSpawn instanceof MobEntity)
				((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
						SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
			world.addEntity(entityToSpawn);
		}
		if (world instanceof ServerWorld) {
			Entity entityToSpawn = new VineEntity.CustomEntity(VineEntity.entity, (World) world);
			entityToSpawn.setLocationAndAngles((x - 1), y, (z - 1), (float) 0, (float) 0);
			entityToSpawn.setRenderYawOffset((float) 0);
			entityToSpawn.setRotationYawHead((float) 0);
			if (entityToSpawn instanceof MobEntity)
				((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
						SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
			world.addEntity(entityToSpawn);
		}
		world.setBlockState(new BlockPos((int) (Math.floor(x) + 1), (int) y, (int) (Math.floor(z) + 1)), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos((int) (Math.floor(x) + 1), (int) y, (int) (Math.floor(z) - 1)), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos((int) (Math.floor(x) + 1), (int) (y + 1), (int) (Math.floor(z) + 1)), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos((int) (Math.floor(x) + 1), (int) (y + 1), (int) (Math.floor(z) - 1)), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos((int) (Math.floor(x) - 1), (int) y, (int) (Math.floor(z) + 1)), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos((int) (Math.floor(x) - 1), (int) y, (int) (Math.floor(z) - 1)), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos((int) (Math.floor(x) - 1), (int) (y + 1), (int) (Math.floor(z) + 1)), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(new BlockPos((int) (Math.floor(x) - 1), (int) (y + 1), (int) (Math.floor(z) - 1)), Blocks.AIR.getDefaultState(), 3);
	}
}
