
package wwworld.itemgroup;

import wwworld.item.AixinzhijianItem;

import wwworld.WwworldModElements;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

@WwworldModElements.ModElement.Tag
public class WuqiItemGroup extends WwworldModElements.ModElement {
	public WuqiItemGroup(WwworldModElements instance) {
		super(instance, 338);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabwuqi") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(AixinzhijianItem.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}

	public static ItemGroup tab;
}
