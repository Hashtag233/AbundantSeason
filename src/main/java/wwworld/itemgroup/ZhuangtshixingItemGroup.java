
package wwworld.itemgroup;

import wwworld.block.HuahuaBlock;

import wwworld.WwworldModElements;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

@WwworldModElements.ModElement.Tag
public class ZhuangtshixingItemGroup extends WwworldModElements.ModElement {
	public ZhuangtshixingItemGroup(WwworldModElements instance) {
		super(instance, 329);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabzhuangtshixing") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(HuahuaBlock.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}

	public static ItemGroup tab;
}
