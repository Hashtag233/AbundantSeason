
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
public class SongguoItem extends WwworldModElements.ModElement {
	@ObjectHolder("wwworld:songguo")
	public static final Item block = null;

	public SongguoItem(WwworldModElements instance) {
		super(instance, 273);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(ShiwuItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(3).saturation(3f).setAlwaysEdible()

							.build()));
			setRegistryName("songguo");
		}

		@Override
		public int getUseDuration(ItemStack stack) {
			return 12;
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}
	}
}
