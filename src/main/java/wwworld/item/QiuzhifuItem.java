
package wwworld.item;

import wwworld.itemgroup.WuqiItemGroup;

import wwworld.WwworldModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.AxeItem;

@WwworldModElements.ModElement.Tag
public class QiuzhifuItem extends WwworldModElements.ModElement {
	@ObjectHolder("wwworld:qiuzhifu")
	public static final Item block = null;

	public QiuzhifuItem(WwworldModElements instance) {
		super(instance, 248);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 500;
			}

			public float getEfficiency() {
				return 13f;
			}

			public float getAttackDamage() {
				return 6f;
			}

			public int getHarvestLevel() {
				return 4;
			}

			public int getEnchantability() {
				return 0;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 1, -3.1f, new Item.Properties().group(WuqiItemGroup.tab)) {
		}.setRegistryName("qiuzhifu"));
	}
}
