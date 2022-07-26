package wwworld.procedures;

import wwworld.WwworldMod;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

public class ZhirezhimuDangFangKuaiBeiWanJiaPoPiShiProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				WwworldMod.LOGGER.warn("Failed to load dependency world for procedure ZhirezhimuDangFangKuaiBeiWanJiaPoPiShi!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				WwworldMod.LOGGER.warn("Failed to load dependency x for procedure ZhirezhimuDangFangKuaiBeiWanJiaPoPiShi!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				WwworldMod.LOGGER.warn("Failed to load dependency y for procedure ZhirezhimuDangFangKuaiBeiWanJiaPoPiShi!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				WwworldMod.LOGGER.warn("Failed to load dependency z for procedure ZhirezhimuDangFangKuaiBeiWanJiaPoPiShi!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				WwworldMod.LOGGER.warn("Failed to load dependency entity for procedure ZhirezhimuDangFangKuaiBeiWanJiaPoPiShi!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if (!((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).abilities.isCreativeMode : false)) {
			if (Math.random() < 0.5) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.5), (y + 0.5), (z + 0.5), new ItemStack(Items.STICK));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
			}
			if (Math.random() < 0.6) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.5), (y + 0.5), (z + 0.5), new ItemStack(Items.STICK));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
			}
			if (Math.random() < 0.7) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.5), (y + 0.5), (z + 0.5), new ItemStack(Items.STICK));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
			}
			if (Math.random() < 0.8) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.5), (y + 0.5), (z + 0.5), new ItemStack(Items.STICK));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
			}
			if (Math.random() < 0.9) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.5), (y + 0.5), (z + 0.5), new ItemStack(Items.STICK));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
			}
			if (Math.random() < 1) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.5), (y + 0.5), (z + 0.5), new ItemStack(Items.STICK));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
			}
		}
	}
}
