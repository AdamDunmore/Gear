package net.fabricmc.gear;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.impl.biome.modification.BiomeSelectionContextImpl;
import net.fabricmc.gear.items.BismuthArmor;
import net.fabricmc.gear.items.BismuthBar;
import net.fabricmc.gear.items.blocks.BismuthOre;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

public class Main implements ModInitializer {

	//Materials
	public static final Item BISMUTH_BAR = new BismuthBar(new FabricItemSettings());

	//Armour
		//Bismuth Armour
	public static final ArmorMaterial BISMUTH_ARMOR = new BismuthArmor();
	public static final Item BISMUTH_HELMENT = new ArmorItem(BISMUTH_ARMOR, EquipmentSlot.HEAD, new FabricItemSettings());
	public static final Item BISMUTH_CHESTPLATE = new ArmorItem(BISMUTH_ARMOR, EquipmentSlot.CHEST, new FabricItemSettings());
	public static final Item BISMUTH_LEGGINGS = new ArmorItem(BISMUTH_ARMOR, EquipmentSlot.LEGS, new FabricItemSettings());
	public static final Item BISMUTH_BOOTS = new ArmorItem(BISMUTH_ARMOR, EquipmentSlot.FEET, new FabricItemSettings());

	//Blocks
	public static final Block BISMUTH_ORE = new BismuthOre(FabricBlockSettings.copyOf(Blocks.IRON_ORE));

	private static final ConfiguredFeature<?, ?> BISMUTH_ORE_OVERWOLRD = Feature.ORE
			.configure(new OreFeatureConfig(
					OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
					BISMUTH_ORE.getDefaultState(),
					8))
			.decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(
					0,64, 100
			)))
			.spreadHorizontally()
			.repeat(20);





//	public static final ItemGroup GEAR_ITEM_GROUP = FabricItemGroupBuilder.create(
//			new Identifier("gearmod", "gearItemGroup"))
//			.icon(() -> new ItemStack(Main.BISMUTH_BAR))
//			.appendItems(stacks -> {
//				stacks.add(new ItemStack(Main.BISMUTH_BAR));
//				stacks.add(new ItemStack(Main.BISMUTH_ORE));
//				stacks.add(new ItemStack(Main.BISMUTH_HELMENT));
//				stacks.add(new ItemStack(Main.BISMUTH_CHESTPLATE));
//				stacks.add(new ItemStack(Main.BISMUTH_LEGGINGS));
//				stacks.add(new ItemStack(Main.BISMUTH_BOOTS));
//
//			}).build();



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

		//Ore world gen
		RegistryKey<ConfiguredFeature<?, ?>> bismuthOreOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gearmod", "bismuth_ore_overworld"));
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, bismuthOreOverworld.getValue(), BISMUTH_ORE_OVERWOLRD);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, bismuthOreOverworld);


	}
}
