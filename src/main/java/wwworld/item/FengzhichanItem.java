
package wwworld.item;

import wwworld.itemgroup.WuqiItemGroup;

import wwworld.WwworldModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

@WwworldModElements.ModElement.Tag
public class FengzhichanItem extends WwworldModElements.ModElement {
	@ObjectHolder("wwworld:fengzhichan")
	public static final Item block = null;

	public FengzhichanItem(WwworldModElements instance) {
		super(instance, 249);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ShovelItem(new IItemTier() {
			public int getMaxUses() {
				return 500;
			}

			public float getEfficiency() {
				return 13f;
			}

			public float getAttackDamage() {
				return 2f;
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
		}, 1, -3f, new Item.Properties().group(WuqiItemGroup.tab)) {
		}.setRegistryName("fengzhichan"));
	}
}
