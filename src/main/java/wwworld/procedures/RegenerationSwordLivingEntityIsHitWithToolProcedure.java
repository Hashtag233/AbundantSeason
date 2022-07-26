package wwworld.procedures;

import wwworld.WwworldMod;

import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import net.minecraft.util.FoodStats;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

public class RegenerationSwordLivingEntityIsHitWithToolProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				WwworldMod.LOGGER.warn("Failed to load dependency entity for procedure RegenerationSwordLivingEntityIsHitWithTool!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				WwworldMod.LOGGER.warn("Failed to load dependency sourceentity for procedure RegenerationSwordLivingEntityIsHitWithTool!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		boolean flag = false;
		if (((sourceentity instanceof PlayerEntity) ? ((PlayerEntity) sourceentity).getFoodStats().getSaturationLevel() : 0) >= 3.6) {
			if (sourceentity instanceof PlayerEntity) {
				ObfuscationReflectionHelper.setPrivateValue(FoodStats.class, ((PlayerEntity) sourceentity).getFoodStats(),
						(float) (((sourceentity instanceof PlayerEntity) ? ((PlayerEntity) sourceentity).getFoodStats().getSaturationLevel() : 0)
								- 3.6),
						"field_75125_b");
			}
			flag = (true);
		} else if (((sourceentity instanceof PlayerEntity) ? ((PlayerEntity) sourceentity).getFoodStats().getFoodLevel() : 0) >= 1) {
			if (sourceentity instanceof PlayerEntity) {
				ObfuscationReflectionHelper.setPrivateValue(FoodStats.class, ((PlayerEntity) sourceentity).getFoodStats(), (float) 0,
						"field_75125_b");
			}
			if (sourceentity instanceof PlayerEntity)
				((PlayerEntity) sourceentity).getFoodStats().setFoodLevel(
						(int) (((sourceentity instanceof PlayerEntity) ? ((PlayerEntity) sourceentity).getFoodStats().getFoodLevel() : 0) - 1));
			flag = (true);
		}
		if (flag) {
			for (int index0 = 0; index0 < (int) (3); index0++) {
				if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) < ((entity instanceof LivingEntity)
						? ((LivingEntity) entity).getMaxHealth()
						: -1)) {
					if (entity instanceof LivingEntity)
						((LivingEntity) entity)
								.setHealth((float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) + 1));
				}
			}
		}
	}
}
