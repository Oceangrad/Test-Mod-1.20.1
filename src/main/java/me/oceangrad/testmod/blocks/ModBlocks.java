package me.oceangrad.testmod.blocks;

import me.oceangrad.testmod.TestMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block CORAL_LEAVES_BLOCK = registerBlock("coral_leaves", new LeavesBlock(
        FabricBlockSettings.copyOf(Blocks.ACACIA_LEAVES)
    ));

    public static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(TestMod.MOD_ID, name), block);
    }
    public static Item registerBlockItem(String name, Block block){
        return Registry.register(Registries.ITEM, new Identifier(TestMod.MOD_ID, name), new BlockItem(block, new FabricItemSettings()));
    }

    private static void addBlockItemsToFunctionalBlockItemGroup(FabricItemGroupEntries entries){
        entries.add(CORAL_LEAVES_BLOCK.asItem());
    }
    private static void addBlockItemsToNaturalBlockItemGroup(FabricItemGroupEntries entries){
        entries.add(CORAL_LEAVES_BLOCK.asItem());
    }

    public static void onModBlocksRegister(){
        TestMod.LOGGER.info(String.format("Started registering mod blocks for %s", TestMod.MOD_ID));

        // Code
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(ModBlocks::addBlockItemsToFunctionalBlockItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(ModBlocks::addBlockItemsToNaturalBlockItemGroup);

        TestMod.LOGGER.info(String.format("Ended registering mod blocks for %s", TestMod.MOD_ID));
    }
}
