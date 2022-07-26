
package wwworld.item;

import wwworld.itemgroup.YuanjingwupinItemGroup;

import wwworld.WwworldModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

@WwworldModElements.ModElement.Tag
public class PosuidechunjigushizhizhangItem extends WwworldModElements.ModElement {
	@ObjectHolder("wwworld:posuidechunjigushizhizhang")
	public static final Item block = null;

	public PosuidechunjigushizhizhangItem(WwworldModElements instance) {
		super(instance, 159);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(YuanjingwupinItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("posuidechunjigushizhizhang");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

		@Override
		public boolean canHarvestBlock(BlockState state) {
			return true;
		}
	}
}