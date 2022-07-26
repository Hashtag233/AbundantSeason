
package wwworld.itemgroup;

import wwworld.item.HongbaoshiItem;

import wwworld.WwworldModElements;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

@WwworldModElements.ModElement.Tag
public class YuanjingwupinItemGroup extends WwworldModElements.ModElement {
	public YuanjingwupinItemGroup(WwworldModElements instance) {
		super(instance, 326);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabyuanjingwupin") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(HongbaoshiItem.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}

	public static ItemGroup tab;
}
