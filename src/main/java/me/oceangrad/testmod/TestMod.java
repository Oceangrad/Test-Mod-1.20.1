package me.oceangrad.testmod;

import me.oceangrad.testmod.blocks.ModBlocks;
import me.oceangrad.testmod.items.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestMod implements ModInitializer {
	public static final String MOD_ID = "testmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info(String.format("Starting %s", MOD_ID));

		ModItems.onModItemsRegister();
		ModBlocks.onModBlocksRegister();

		LOGGER.info(String.format("Started %s", MOD_ID));
	}
}