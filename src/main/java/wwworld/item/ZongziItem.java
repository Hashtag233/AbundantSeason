
package wwworld.item;

import wwworld.procedures.ZongziItemIsCraftedProcedure;
import wwworld.procedures.ZongziDangShiWuBeiChiShiProcedure;

import wwworld.itemgroup.ShiwuItemGroup;

import wwworld.WwworldModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

@WwworldModElements.ModElement.Tag
public class ZongziItem extends WwworldModElements.ModElement {
	@ObjectHolder("wwworld:zongzi")
	public static final Item block = null;

	public ZongziItem(WwworldModElements instance) {
		super(instance, 266);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(ShiwuItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(20).saturation(20f)

							.build()));
			setRegistryName("zongzi");
		}

		@Override
		public int getUseDuration(ItemStack stack) {
			return 64;
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

		@Override
		public ItemStack onItemUseFinish(ItemStack itemstack, World world, LivingEntity entity) {
			ItemStack retval = super.onItemUseFinish(itemstack, world, entity);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();

			ZongziDangShiWuBeiChiShiProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			return retval;
		}

		@Override
		public void onCreated(ItemStack itemstack, World world, PlayerEntity entity) {
			super.onCreated(itemstack, world, entity);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();

			ZongziItemIsCraftedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
		}
	}
}
