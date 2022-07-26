
package wwworld.item;

import wwworld.procedures.ZhirejianDangShiTiBeiGongJuJiZhongShiProcedure;
import wwworld.procedures.ZhirejianDangGongJuChuXianZaiShouZhongShiProcedure;

import wwworld.itemgroup.WuqiItemGroup;

import wwworld.WwworldModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.util.ITooltipFlag;

import java.util.stream.Stream;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.AbstractMap;

@WwworldModElements.ModElement.Tag
public class ZhirejianItem extends WwworldModElements.ModElement {
	@ObjectHolder("wwworld:zhirejian")
	public static final Item block = null;

	public ZhirejianItem(WwworldModElements instance) {
		super(instance, 240);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 400;
			}

			public float getEfficiency() {
				return 0f;
			}

			public float getAttackDamage() {
				return -1f;
			}

			public int getHarvestLevel() {
				return 0;
			}

			public int getEnchantability() {
				return 10;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 3, -2.2f, new Item.Properties().group(WuqiItemGroup.tab).isImmuneToFire()) {
			@Override
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent("\u5EFA\u8BAE\u53CC\u6301"));
			}

			@Override
			public boolean hitEntity(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
				boolean retval = super.hitEntity(itemstack, entity, sourceentity);
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				World world = entity.world;

				ZhirejianDangShiTiBeiGongJuJiZhongShiProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return retval;
			}

			@Override
			public void inventoryTick(ItemStack itemstack, World world, Entity entity, int slot, boolean selected) {
				super.inventoryTick(itemstack, world, entity, slot, selected);
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				if (selected)

					ZhirejianDangGongJuChuXianZaiShouZhongShiProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
							.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
		}.setRegistryName("zhirejian"));
	}
}
