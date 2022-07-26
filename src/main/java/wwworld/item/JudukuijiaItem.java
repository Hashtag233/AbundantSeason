
package wwworld.item;

import wwworld.itemgroup.WuqiItemGroup;

import wwworld.WwworldModElements;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ArmorItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.Entity;

@WwworldModElements.ModElement.Tag
public class JudukuijiaItem extends WwworldModElements.ModElement {
	@ObjectHolder("wwworld:judukuijia_helmet")
	public static final Item helmet = null;
	@ObjectHolder("wwworld:judukuijia_chestplate")
	public static final Item body = null;
	@ObjectHolder("wwworld:judukuijia_leggings")
	public static final Item legs = null;
	@ObjectHolder("wwworld:judukuijia_boots")
	public static final Item boots = null;

	public JudukuijiaItem(WwworldModElements instance) {
		super(instance, 227);
	}

	@Override
	public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			@Override
			public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 17;
			}

			@Override
			public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[]{3, 6, 7, 4}[slot.getIndex()];
			}

			@Override
			public int getEnchantability() {
				return 10;
			}

			@Override
			public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
			}

			@Override
			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(DuciweipiItem.block));
			}

			@OnlyIn(Dist.CLIENT)
			@Override
			public String getName() {
				return "judukuijia";
			}

			@Override
			public float getToughness() {
				return 1.5f;
			}

			@Override
			public float getKnockbackResistance() {
				return 0f;
			}
		};
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.CHEST, new Item.Properties().group(WuqiItemGroup.tab)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "wwworld:textures/models/armor/judukuijia_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}
		}.setRegistryName("judukuijia_chestplate"));
	}

}
