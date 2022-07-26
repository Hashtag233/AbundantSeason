
package wwworld.itemgroup;

import wwworld.block.YuansuweiduBlock;

import wwworld.WwworldModElements;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

@WwworldModElements.ModElement.Tag
public class YuanjingItemGroup extends WwworldModElements.ModElement {
	public YuanjingItemGroup(WwworldModElements instance) {
		super(instance, 323);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabyuanjing") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(YuansuweiduBlock.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}

	public static ItemGroup tab;
}
