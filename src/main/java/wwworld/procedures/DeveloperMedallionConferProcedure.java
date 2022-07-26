package wwworld.procedures;

import wwworld.item.DeveloperMedallionItem;

import wwworld.WwworldModVariables;

import wwworld.WwworldModElements;

import wwworld.WwworldMod;

import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;
import java.util.HashMap;

@WwworldModElements.ModElement.Tag
public class DeveloperMedallionConferProcedure extends WwworldModElements.ModElement {
	public DeveloperMedallionConferProcedure(WwworldModElements instance) {
		super(instance, 678);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				WwworldMod.LOGGER.warn("Failed to load dependency entity for procedure DeveloperMedallionConfer!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((((entity.getCapability(WwworldModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new WwworldModVariables.PlayerVariables())).isMedallionConferred) == (false)) && (entity instanceof PlayerEntity))) {
			if ((((((((entity.getUniqueID().toString()).equals("bf7b5fea-d6ea-405e-b78e-ef8687958a13"))
					|| ((entity.getUniqueID().toString()).equals("5ec8bc75-6b75-453f-ba76-63f95d359c02")))
					|| ((entity.getUniqueID().toString()).equals("d07c43e4-32d6-493c-88f6-a7efee8bccd7"))))
					|| ((entity.getUniqueID().toString()).equals("d07c43e4-32d6-493c-88f6-a7efee8bccd7"))))){
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(DeveloperMedallionItem.block, (int) (1));
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
			}
			{
				boolean _setval = (boolean) (true);
				entity.getCapability(WwworldModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.isMedallionConferred = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}

	@SubscribeEvent
	public void onEntityJoin(EntityJoinWorldEvent event) {
		World world = event.getWorld();
		Entity entity = event.getEntity();
		double i = entity.getPosX();
		double j = entity.getPosY();
		double k = entity.getPosZ();
		Map<String, Object> dependencies = new HashMap<>();
		dependencies.put("x", i);
		dependencies.put("y", j);
		dependencies.put("z", k);
		dependencies.put("world", world);
		dependencies.put("entity", entity);
		dependencies.put("event", event);
		this.executeProcedure(dependencies);
	}
}
