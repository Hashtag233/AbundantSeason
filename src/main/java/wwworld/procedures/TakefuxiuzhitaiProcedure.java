package wwworld.procedures;

import wwworld.WwworldModVariables;

import wwworld.WwworldMod;

import net.minecraft.inventory.container.Slot;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;

import java.util.function.Supplier;
import java.util.Map;

public class TakefuxiuzhitaiProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				WwworldMod.LOGGER.warn("Failed to load dependency entity for procedure Takefuxiuzhitai!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity.getCapability(WwworldModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new WwworldModVariables.PlayerVariables())).jianlinghun == 1) {
			{
				double _setval = ((entity.getCapability(WwworldModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new WwworldModVariables.PlayerVariables())).linghun - 500);
				entity.getCapability(WwworldModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.linghun = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		{
			Entity _ent = entity;
			if (_ent instanceof ServerPlayerEntity) {
				Container _current = ((ServerPlayerEntity) _ent).openContainer;
				if (_current instanceof Supplier) {
					Object invobj = ((Supplier) _current).get();
					if (invobj instanceof Map) {
						((Slot) ((Map) invobj).get((int) (1))).decrStackSize((int) (1));
						_current.detectAndSendChanges();
					}
				}
			}
		}
		{
			Entity _ent = entity;
			if (_ent instanceof ServerPlayerEntity) {
				Container _current = ((ServerPlayerEntity) _ent).openContainer;
				if (_current instanceof Supplier) {
					Object invobj = ((Supplier) _current).get();
					if (invobj instanceof Map) {
						((Slot) ((Map) invobj).get((int) (2))).decrStackSize((int) (1));
						_current.detectAndSendChanges();
					}
				}
			}
		}
		{
			Entity _ent = entity;
			if (_ent instanceof ServerPlayerEntity) {
				Container _current = ((ServerPlayerEntity) _ent).openContainer;
				if (_current instanceof Supplier) {
					Object invobj = ((Supplier) _current).get();
					if (invobj instanceof Map) {
						((Slot) ((Map) invobj).get((int) (3))).decrStackSize((int) (1));
						_current.detectAndSendChanges();
					}
				}
			}
		}
		{
			Entity _ent = entity;
			if (_ent instanceof ServerPlayerEntity) {
				Container _current = ((ServerPlayerEntity) _ent).openContainer;
				if (_current instanceof Supplier) {
					Object invobj = ((Supplier) _current).get();
					if (invobj instanceof Map) {
						((Slot) ((Map) invobj).get((int) (4))).decrStackSize((int) (1));
						_current.detectAndSendChanges();
					}
				}
			}
		}
		{
			Entity _ent = entity;
			if (_ent instanceof ServerPlayerEntity) {
				Container _current = ((ServerPlayerEntity) _ent).openContainer;
				if (_current instanceof Supplier) {
					Object invobj = ((Supplier) _current).get();
					if (invobj instanceof Map) {
						((Slot) ((Map) invobj).get((int) (5))).decrStackSize((int) (1));
						_current.detectAndSendChanges();
					}
				}
			}
		}
		{
			Entity _ent = entity;
			if (_ent instanceof ServerPlayerEntity) {
				Container _current = ((ServerPlayerEntity) _ent).openContainer;
				if (_current instanceof Supplier) {
					Object invobj = ((Supplier) _current).get();
					if (invobj instanceof Map) {
						((Slot) ((Map) invobj).get((int) (6))).decrStackSize((int) (1));
						_current.detectAndSendChanges();
					}
				}
			}
		}
		{
			Entity _ent = entity;
			if (_ent instanceof ServerPlayerEntity) {
				Container _current = ((ServerPlayerEntity) _ent).openContainer;
				if (_current instanceof Supplier) {
					Object invobj = ((Supplier) _current).get();
					if (invobj instanceof Map) {
						((Slot) ((Map) invobj).get((int) (7))).decrStackSize((int) (1));
						_current.detectAndSendChanges();
					}
				}
			}
		}
		{
			Entity _ent = entity;
			if (_ent instanceof ServerPlayerEntity) {
				Container _current = ((ServerPlayerEntity) _ent).openContainer;
				if (_current instanceof Supplier) {
					Object invobj = ((Supplier) _current).get();
					if (invobj instanceof Map) {
						((Slot) ((Map) invobj).get((int) (8))).decrStackSize((int) (1));
						_current.detectAndSendChanges();
					}
				}
			}
		}
		{
			Entity _ent = entity;
			if (_ent instanceof ServerPlayerEntity) {
				Container _current = ((ServerPlayerEntity) _ent).openContainer;
				if (_current instanceof Supplier) {
					Object invobj = ((Supplier) _current).get();
					if (invobj instanceof Map) {
						((Slot) ((Map) invobj).get((int) (9))).decrStackSize((int) (1));
						_current.detectAndSendChanges();
					}
				}
			}
		}
	}
}
