package wwworld.procedures;

import wwworld.entity.FuxiushouweiEntity;

import wwworld.WwworldModVariables;

import wwworld.WwworldMod;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.Entity;

import java.util.Map;

public class FuxiuweiduDangWanJiaJinRuWeiDuShiProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				WwworldMod.LOGGER.warn("Failed to load dependency world for procedure FuxiuweiduDangWanJiaJinRuWeiDuShi!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				WwworldMod.LOGGER.warn("Failed to load dependency x for procedure FuxiuweiduDangWanJiaJinRuWeiDuShi!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				WwworldMod.LOGGER.warn("Failed to load dependency z for procedure FuxiuweiduDangWanJiaJinRuWeiDuShi!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				WwworldMod.LOGGER.warn("Failed to load dependency entity for procedure FuxiuweiduDangWanJiaJinRuWeiDuShi!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity.getCapability(WwworldModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new WwworldModVariables.PlayerVariables())).givelinghuntiao == false && entity instanceof PlayerEntity) {
			{
				boolean _setval = (true);
				entity.getCapability(WwworldModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.givelinghuntiao = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (world instanceof ServerWorld) {
				Entity entityToSpawn = new FuxiushouweiEntity.CustomEntity(FuxiushouweiEntity.entity, (World) world);
				entityToSpawn.setLocationAndAngles((Math.floor(x) + 0.5 + 6),
						(world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) (Math.floor(x) + 0.5 + 6), (int) (Math.floor(z) + 0.5)) + 1),
						(Math.floor(z) + 0.5), world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof MobEntity)
					((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
							SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
				world.addEntity(entityToSpawn);
			}
			if (world instanceof ServerWorld) {
				Entity entityToSpawn = new FuxiushouweiEntity.CustomEntity(FuxiushouweiEntity.entity, (World) world);
				entityToSpawn
						.setLocationAndAngles(
								((Math.floor(x) + 0.5) - 6), (world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
										(int) ((Math.floor(x) + 0.5) - 6), (int) (Math.floor(z) + 0.5)) + 1),
								(Math.floor(z) + 0.5), world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof MobEntity)
					((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
							SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
				world.addEntity(entityToSpawn);
			}
			if (world instanceof ServerWorld) {
				Entity entityToSpawn = new FuxiushouweiEntity.CustomEntity(FuxiushouweiEntity.entity, (World) world);
				entityToSpawn.setLocationAndAngles((Math.floor(x) + 0.5),
						(world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) (Math.floor(x) + 0.5), (int) (Math.floor(z) + 0.5 + 6)) + 1),
						(Math.floor(z) + 0.5 + 6), world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof MobEntity)
					((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
							SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
				world.addEntity(entityToSpawn);
			}
			if (world instanceof ServerWorld) {
				Entity entityToSpawn = new FuxiushouweiEntity.CustomEntity(FuxiushouweiEntity.entity, (World) world);
				entityToSpawn
						.setLocationAndAngles((Math.floor(x) + 0.5),
								(world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) (Math.floor(x) + 0.5),
										(int) ((Math.floor(z) + 0.5) - 6)) + 1),
								((Math.floor(z) + 0.5) - 6), world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof MobEntity)
					((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
							SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
				world.addEntity(entityToSpawn);
			}
		}
	}
}
