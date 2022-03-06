package com.ninni.mushfinders.block;

import com.ninni.mushfinders.Mushfinders;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

@SuppressWarnings("unused")
public class MushfindersBlocks {
    public static final Block WHITE_PILLUP = register("white_pillup", new MushfindersMushroomPlantBlock(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM)));
    //TODO make it fit into the minecraft tag for flower pots
    public static final Block POTTED_WHITE_PILLUP = register("potted_white_pillup", new FlowerPotBlock(WHITE_PILLUP, FabricBlockSettings.of(Material.DECORATION).breakInstantly().nonOpaque()));

    private static Block register(String id, Block block, boolean registerItem) {
        Block registered = Registry.register(Registry.BLOCK, new Identifier(Mushfinders.MOD_ID, id), block);
        if (registerItem) {
            Registry.register(Registry.ITEM, new Identifier(Mushfinders.MOD_ID, id), new BlockItem(registered, new FabricItemSettings().group(Mushfinders.ITEM_GROUP)));
        }
        return registered;
    }
    private static Block register(String id, Block block) {
        return register(id, block, false);
    }
}
