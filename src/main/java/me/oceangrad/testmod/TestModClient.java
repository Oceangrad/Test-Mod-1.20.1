package me.oceangrad.testmod;

import me.oceangrad.testmod.blocks.ModBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.scoreboard.ScoreboardCriterion;

public class TestModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.INFESTED_TEST_BLOCK, RenderLayer.getCutout());
    }
}
