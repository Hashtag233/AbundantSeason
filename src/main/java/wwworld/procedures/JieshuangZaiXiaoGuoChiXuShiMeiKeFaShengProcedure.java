package wwworld.procedures;

import wwworld.WwworldMod;

import net.minecraft.util.DamageSource;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

public class JieshuangZaiXiaoGuoChiXuShiMeiKeFaShengProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				WwworldMod.LOGGER.warn("Failed to load dependency entity for procedure JieshuangZaiXiaoGuoChiXuShiMeiKeFaSheng!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 1, (int) 2, (false), (false)));
		entity.getPersistentData().putDouble("jieshuang", (entity.getPersistentData().getDouble("jieshuang") + 1));
		if (entity.getPersistentData().getDouble("jieshuang") == 40) {
			entity.attackEntityFrom(DamageSource.GENERIC, (float) 3);
			entity.getPersistentData().putDouble("jieshuang", 0);
		}
	}
}
