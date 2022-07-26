package wwworld.procedures;

import wwworld.WwworldMod;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.container.Slot;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.function.Supplier;
import java.util.Map;

public class TakesijiduanzaotaiProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				WwworldMod.LOGGER.warn("Failed to load dependency entity for procedure Takesijiduanzaotai!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
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
		if (entity instanceof PlayerEntity) {
			ItemStack _setstack = new ItemStack(Items.GLASS_BOTTLE);
			_setstack.setCount((int) 1);
			ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
		}
	}
}
