package me.oceangrad.testmod.items;

import me.oceangrad.testmod.TestMod;
import me.oceangrad.testmod.items.custom.ExploderItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ShearsItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item NETHERITE_SHEARS = registerItem("netherite_shears", new ShearsItem(new FabricItemSettings().fireproof().maxDamage(485)));
    public static final Item EXPLODER = registerItem("exploder", new ExploderItem(new FabricItemSettings().maxCount(1)));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(TestMod.MOD_ID, name), item);
    }
    private static void addItemsToToolsItemGroup(FabricItemGroupEntries entries){
        entries.add(NETHERITE_SHEARS);
        entries.add(EXPLODER);
    }
    public static void onModItemsRegister(){
        TestMod.LOGGER.info(String.format("Started registering mod items for %s", TestMod.MOD_ID));

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(ModItems::addItemsToToolsItemGroup);

        TestMod.LOGGER.info(String.format("Ended registering mod items for %s", TestMod.MOD_ID));
    }
}
