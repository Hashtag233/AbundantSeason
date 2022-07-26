package wwworld.procedures;

import wwworld.WwworldMod;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.entity.item.ExperienceOrbEntity;

import java.util.Map;

public class JingyanchanDangFangKuaiBeiGongJuPoPiProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				WwworldMod.LOGGER.warn("Failed to load dependency world for procedure JingyanchanDangFangKuaiBeiGongJuPoPi!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				WwworldMod.LOGGER.warn("Failed to load dependency x for procedure JingyanchanDangFangKuaiBeiGongJuPoPi!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				WwworldMod.LOGGER.warn("Failed to load dependency y for procedure JingyanchanDangFangKuaiBeiGongJuPoPi!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				WwworldMod.LOGGER.warn("Failed to load dependency z for procedure JingyanchanDangFangKuaiBeiGongJuPoPi!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if (Math.random() < 0.9) {
			if (world instanceof World && !world.isRemote()) {
				((World) world).addEntity(new ExperienceOrbEntity(((World) world), (x + 0.5), (y + 0.5), (z + 0.5), (int) 4));
			}
		}
		if (Math.random() < 0.6) {
			if (world instanceof World && !world.isRemote()) {
				((World) world).addEntity(new ExperienceOrbEntity(((World) world), (x + 0.5), (y + 0.5), (z + 0.5), (int) 4));
			}
		}
		if (Math.random() < 0.5) {
			if (world instanceof World && !world.isRemote()) {
				((World) world).addEntity(new ExperienceOrbEntity(((World) world), (x + 0.5), (y + 0.5), (z + 0.5), (int) 4));
			}
		}
	}
}
