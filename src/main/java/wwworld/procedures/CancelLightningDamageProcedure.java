package wwworld.procedures;

import wwworld.WwworldModElements;

import wwworld.WwworldMod;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.entity.Entity;

import java.util.Map;
import java.util.HashMap;

@WwworldModElements.ModElement.Tag
public class CancelLightningDamageProcedure extends WwworldModElements.ModElement {
	public CancelLightningDamageProcedure(WwworldModElements instance) {
		super(instance, 778);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				WwworldMod.LOGGER.warn("Failed to load dependency entity for procedure CancelLightningDamage!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		LivingHurtEvent event = (LivingHurtEvent) dependencies.get("event");
		if (((entity.getPersistentData().getDouble("lightningTime")) > 0)) {//get immuse time
			if (event.getSource().getDamageType().equals("lightningBolt")) {//get damage source
				if (dependencies.get("event") != null) {
					Object _obj = dependencies.get("event");
					if (_obj instanceof Event) {
						Event _evt = (Event) _obj;
						if (_evt.isCancelable())
							_evt.setCanceled(true);//cancel damage
					}
				}
			}
		}
	}

	@SubscribeEvent
	public void onEntityAttacked(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
			Entity entity = event.getEntity();
			Entity sourceentity = event.getSource().getTrueSource();
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			double amount = event.getAmount();
			World world = entity.world;
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("amount", amount);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("sourceentity", sourceentity);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}
}
