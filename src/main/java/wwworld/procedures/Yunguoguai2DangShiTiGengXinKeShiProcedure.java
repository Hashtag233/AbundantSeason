package wwworld.procedures;

import wwworld.entity.Yunguoguai3Entity;

import wwworld.WwworldMod;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.Entity;

import java.util.function.Function;
import java.util.Map;
import java.util.Comparator;

public class Yunguoguai2DangShiTiGengXinKeShiProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				WwworldMod.LOGGER.warn("Failed to load dependency world for procedure Yunguoguai2DangShiTiGengXinKeShi!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				WwworldMod.LOGGER.warn("Failed to load dependency x for procedure Yunguoguai2DangShiTiGengXinKeShi!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				WwworldMod.LOGGER.warn("Failed to load dependency y for procedure Yunguoguai2DangShiTiGengXinKeShi!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				WwworldMod.LOGGER.warn("Failed to load dependency z for procedure Yunguoguai2DangShiTiGengXinKeShi!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				WwworldMod.LOGGER.warn("Failed to load dependency entity for procedure Yunguoguai2DangShiTiGengXinKeShi!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		double fangxiang = 0;
		double health = 0;
		double jiaodu = 0;
		if (Math.random() < 0.001 && y >= 100) {
			if (!entity.world.isRemote())
				entity.remove();
			health = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1);
			jiaodu = (entity.rotationPitch);
			fangxiang = (entity.rotationYaw);
			if (world instanceof ServerWorld) {
				Entity entityToSpawn = new Yunguoguai3Entity.CustomEntity(Yunguoguai3Entity.entity, (World) world);
				entityToSpawn.setLocationAndAngles(x, y, z, (float) fangxiang, (float) jiaodu);
				entityToSpawn.setRenderYawOffset((float) fangxiang);
				entityToSpawn.setRotationYawHead((float) fangxiang);
				if (entityToSpawn instanceof MobEntity)
					((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
							SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
				world.addEntity(entityToSpawn);
			}
			if (((Entity) world
					.getEntitiesWithinAABB(Yunguoguai3Entity.CustomEntity.class,
							new AxisAlignedBB(x - (1 / 2d), y - (1 / 2d), z - (1 / 2d), x + (1 / 2d), y + (1 / 2d), z + (1 / 2d)), null)
					.stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity)
				((LivingEntity) ((Entity) world
						.getEntitiesWithinAABB(Yunguoguai3Entity.CustomEntity.class,
								new AxisAlignedBB(x - (1 / 2d), y - (1 / 2d), z - (1 / 2d), x + (1 / 2d), y + (1 / 2d), z + (1 / 2d)), null)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null))).setHealth((float) health);
		}
	}
}
