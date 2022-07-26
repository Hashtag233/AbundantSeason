package wwworld.procedures;

import wwworld.WwworldMod;

import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;

import java.util.Map;

public class ShuiguihuaDangShiTiGengXinKeShiProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				WwworldMod.LOGGER.warn("Failed to load dependency entity for procedure ShuiguihuaDangShiTiGengXinKeShi!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.getPersistentData().putDouble("ticker", (entity.getPersistentData().getDouble("ticker") + 1));
		if (entity.getPersistentData().getDouble("ticker") == 20) {
			if (entity.isInWaterOrBubbleColumn()) {
				if (entity.getPersistentData().getDouble("oxygen") <= 10) {
					entity.getPersistentData().putDouble("oxygen", (entity.getPersistentData().getDouble("oxygen") + 1));
				}
			} else {
				if (entity.getPersistentData().getDouble("oxygen") > 0) {
					entity.getPersistentData().putDouble("oxygen", (entity.getPersistentData().getDouble("oxygen") - 1));
				}
			}
			if (entity.getPersistentData().getDouble("oxygen") <= 0) {
				entity.attackEntityFrom(DamageSource.DROWN, (float) 1);
			}
		}
		if (entity.getPersistentData().getDouble("ticker") >= 20) {
			entity.getPersistentData().putDouble("ticker", 0);
		}
	}
}
