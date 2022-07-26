
package wwworld.item;

import wwworld.itemgroup.ShiwuItemGroup;

import wwworld.WwworldModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;

@WwworldModElements.ModElement.Tag
public class QupiboluoItem extends WwworldModElements.ModElement {
	@ObjectHolder("wwworld:qupiboluo")
	public static final Item block = null;

	public QupiboluoItem(WwworldModElements instance) {
		super(instance, 272);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(ShiwuItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(8).saturation(9f).setAlwaysEdible()

							.build()));
			setRegistryName("qupiboluo");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}
	}
}
