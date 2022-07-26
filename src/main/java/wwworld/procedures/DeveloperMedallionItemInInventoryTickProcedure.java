package wwworld.procedures;

import wwworld.WwworldModElements;

import wwworld.WwworldMod;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;

import java.util.Map;

@WwworldModElements.ModElement.Tag
public class DeveloperMedallionItemInInventoryTickProcedure extends WwworldModElements.ModElement {
	public DeveloperMedallionItemInInventoryTickProcedure(WwworldModElements instance) {
		super(instance, 677);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				WwworldMod.LOGGER.warn("Failed to load dependency entity for procedure DeveloperMedallionItemInInventoryTick!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				WwworldMod.LOGGER.warn("Failed to load dependency itemstack for procedure DeveloperMedallionItemInInventoryTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if (((!((entity.getUniqueID().toString()).equals("d07c43e4-32d6-493c-88f6-a7efee8bccd7")))
				&& ((!((entity.getUniqueID().toString()).equals("bf7b5fea-d6ea-405e-b78e-ef8687958a13")))
						&& (!((entity.getUniqueID().toString()).equals("5ec8bc75-6b75-453f-ba76-63f95d359c02")))))) {
			((itemstack)).shrink((int) 1);
		}
	}
}
