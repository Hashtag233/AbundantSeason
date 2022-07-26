package wwworld.procedures;

import wwworld.entity.BingshuanglongjuanfengEntity;

import wwworld.WwworldMod;

import net.minecraft.entity.Entity;

import java.util.Map;

public class BeixuejiandebingzhuiDangTouZhiWuJiZhongShiTiShiProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				WwworldMod.LOGGER.warn("Failed to load dependency entity for procedure BeixuejiandebingzhuiDangTouZhiWuJiZhongShiTiShi!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof BingshuanglongjuanfengEntity.CustomEntity) {
			entity.getPersistentData().putDouble("chengjiu1", 1);
		}
	}
}
