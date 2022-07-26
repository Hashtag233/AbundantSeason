
package wwworld.item;

import wwworld.itemgroup.ShiwuItemGroup;

import wwworld.WwworldModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;

@WwworldModElements.ModElement.Tag
public class YingguangmogutangItem extends WwworldModElements.ModElement {
	@ObjectHolder("wwworld:yingguangmogutang")
	public static final Item block = null;

	public YingguangmogutangItem(WwworldModElements instance) {
		super(instance, 274);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(ShiwuItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(6).saturation(8f).setAlwaysEdible()

							.build()));
			setRegistryName("yingguangmogutang");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

		@Override
		public ItemStack onItemUseFinish(ItemStack itemstack, World world, LivingEntity entity) {
			ItemStack retval = new ItemStack(Items.BOWL);
			super.onItemUseFinish(itemstack, world, entity);
			if (itemstack.isEmpty()) {
				return retval;
			} else {
				if (entity instanceof PlayerEntity) {
					PlayerEntity player = (PlayerEntity) entity;
					if (!player.isCreative() && !player.inventory.addItemStackToInventory(retval))
						player.dropItem(retval, false);
				}
				return itemstack;
			}
		}
	}
}
