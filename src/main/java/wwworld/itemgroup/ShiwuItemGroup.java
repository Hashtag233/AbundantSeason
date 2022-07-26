
package wwworld.itemgroup;

import wwworld.item.Qie1Item;

import wwworld.WwworldModElements;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

@WwworldModElements.ModElement.Tag
public class ShiwuItemGroup extends WwworldModElements.ModElement {
	public ShiwuItemGroup(WwworldModElements instance) {
		super(instance, 445);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabshiwu") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(Qie1Item.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}

	public static ItemGroup tab;
}
