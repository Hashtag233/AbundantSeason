package wwworld.procedures;

import wwworld.WwworldMod;

import net.minecraft.util.DamageSource;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

public class JuduciweiDangShiTiShouShangShiProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				WwworldMod.LOGGER.warn("Failed to load dependency sourceentity for procedure JuduciweiDangShiTiShouShangShi!");
			return;
		}
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		if (sourceentity instanceof LivingEntity)
			((LivingEntity) sourceentity).addPotionEffect(new EffectInstance(Effects.POISON, (int) 80, (int) 3));
		sourceentity.attackEntityFrom(DamageSource.GENERIC, (float) 5);
	}
}
