package net.fabricmc.gear;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.gear.items.BismuthArmor;
import net.fabricmc.gear.items.BismuthBar;
import net.fabricmc.gear.items.blocks.BismuthOre;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class Main implements ModInitializer {
	//Materials
	public static final Item BISMUTH_BAR = new BismuthBar(new FabricItemSettings().group(Main.GEAR_ITEM_GROUP));

	//Armour
		//Bismuth Armour
	public static final ArmorMaterial BISMUTH_ARMOR = new BismuthArmor();
	public static final Item BISMUTH_HELMENT = new ArmorItem(BISMUTH_ARMOR, EquipmentSlot.HEAD, new FabricItemSettings().group(Main.GEAR_ITEM_GROUP));
	public static final Item BISMUTH_CHESTPLATE = new ArmorItem(BISMUTH_ARMOR, EquipmentSlot.CHEST, new FabricItemSettings().group(Main.GEAR_ITEM_GROUP));
	public static final Item BISMUTH_LEGGINGS = new ArmorItem(BISMUTH_ARMOR, EquipmentSlot.LEGS, new FabricItemSettings().group(Main.GEAR_ITEM_GROUP));
	public static final Item BISMUTH_BOOTS = new ArmorItem(BISMUTH_ARMOR, EquipmentSlot.FEET, new FabricItemSettings().group(Main.GEAR_ITEM_GROUP));

	//Blocks
	public static final Block BISMUTH_ORE = new BismuthOre(FabricBlockSettings.copyOf(Blocks.IRON_ORE));




	public static final ItemGroup GEAR_ITEM_GROUP = FabricItemGroupBuilder.build(new Identifier("gear", "general"),
			() -> new ItemStack(Main.BISMUTH_BAR)); //Group Icon


	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		System.out.println("Hello Fabric world!");

		Registry.register(Registry.ITEM, new Identifier("gearmod", "bismuth_bar"), BISMUTH_BAR);

		Registry.register(Registry.ITEM, new Identifier("gearmod", "bismuth_helmet"), BISMUTH_HELMENT);
		Registry.register(Registry.ITEM, new Identifier("gearmod", "bismuth_chestplate"), BISMUTH_CHESTPLATE);
		Registry.register(Registry.ITEM, new Identifier("gearmod", "bismuth_leggings"), BISMUTH_LEGGINGS);
		Registry.register(Registry.ITEM, new Identifier("gearmod", "bismuth_boots"), BISMUTH_BOOTS);

		Registry.register(Registry.BLOCK, new Identifier("gearmod", "bismuth_ore"), BISMUTH_ORE);
		Registry.register(Registry.ITEM, new Identifier("gearmod", "bismuth_ore"), new BlockItem(BISMUTH_ORE, new FabricItemSettings()));


	}
}
