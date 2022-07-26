
package wwworld.item;

import wwworld.procedures.FengzhiliandaoDangShiTiBeiGongJuJiZhongShiProcedure;

import wwworld.itemgroup.WuqiItemGroup;

import wwworld.WwworldModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.entity.LivingEntity;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

@WwworldModElements.ModElement.Tag
public class FengzhiliandaoItem extends WwworldModElements.ModElement {
	@ObjectHolder("wwworld:fengzhiliandao")
	public static final Item block = null;

	public FengzhiliandaoItem(WwworldModElements instance) {
		super(instance, 252);
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
				return 4f;
			}

			public int getHarvestLevel() {
				return 0;
			}

			public int getEnchantability() {
				return 10;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(FengzhidingItem.block));
			}
		}, 3, -2.7999999999999998f, new Item.Properties().group(WuqiItemGroup.tab)) {
			@Override
			public boolean hitEntity(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
				boolean retval = super.hitEntity(itemstack, entity, sourceentity);
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				World world = entity.world;

				FengzhiliandaoDangShiTiBeiGongJuJiZhongShiProcedure
						.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("sourceentity", sourceentity)).collect(HashMap::new,
								(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return retval;
			}
		}.setRegistryName("fengzhiliandao"));
	}
}
