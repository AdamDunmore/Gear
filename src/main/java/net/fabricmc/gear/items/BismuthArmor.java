package net.fabricmc.gear.items;

import net.fabricmc.gear.Main;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class BismuthArmor implements ArmorMaterial {
    private final int[] protectionAmounts = {3, 8, 6, 3};


    private static final int[] BASE_DURABILITY = {11, 16, 15, 13};

    @Override
    public int getDurability(EquipmentSlot slot) {
        return BASE_DURABILITY[slot.getEntitySlotId()] * 25;
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return protectionAmounts[slot.getEntitySlotId()];
    }

    @Override
    public int getEnchantability() {
        return 19;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_IRON;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Main.BISMUTH_BAR);
    }

    @Override
    public String getName() {
        return "gear:bismuth";
    }

    @Override
    public float getToughness() {
        return 2f;
    }

    @Override
    public float getKnockbackResistance() {
        return 0.5f;
    }
}
