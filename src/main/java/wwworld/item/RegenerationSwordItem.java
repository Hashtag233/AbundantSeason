
package wwworld.item;

import wwworld.procedures.RegenerationSwordLivingEntityIsHitWithToolProcedure;

import wwworld.itemgroup.WuqiItemGroup;

import wwworld.WwworldModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.entity.LivingEntity;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

@WwworldModElements.ModElement.Tag
public class RegenerationSwordItem extends WwworldModElements.ModElement {
	@ObjectHolder("wwworld:regeneration_sword")
	public static final Item block = null;

	public RegenerationSwordItem(WwworldModElements instance) {
		super(instance, 245);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 500;
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
				return 0;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 1, 96f, new Item.Properties().group(WuqiItemGroup.tab)) {
			@Override
			public boolean hitEntity(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
				boolean retval = super.hitEntity(itemstack, entity, sourceentity);
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				World world = entity.world;

				RegenerationSwordLivingEntityIsHitWithToolProcedure.executeProcedure(
						Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("sourceentity", sourceentity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return retval;
			}
		}.setRegistryName("regeneration_sword"));
	}
}
