
package wwworld.item;

import wwworld.itemgroup.WuqiItemGroup;

import wwworld.WwworldModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

@WwworldModElements.ModElement.Tag
public class QiuzhigaoItem extends WwworldModElements.ModElement {
	@ObjectHolder("wwworld:qiuzhigao")
	public static final Item block = null;

	public QiuzhigaoItem(WwworldModElements instance) {
		super(instance, 247);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 500;
			}

			public float getEfficiency() {
				return 13f;
			}

			public float getAttackDamage() {
				return 3f;
			}

			public int getHarvestLevel() {
				return 4;
			}

			public int getEnchantability() {
				return 0;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(FengzhidingItem.block));
			}
		}, 1, -2.8f, new Item.Properties().group(WuqiItemGroup.tab)) {
		}.setRegistryName("qiuzhigao"));
	}
}
