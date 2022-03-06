package com.ninni.mushfinders.block;

import com.ninni.mushfinders.Mushfinders;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.function.BiFunction;

@SuppressWarnings("unused")
public interface MushfindersBlocks {
    Block WHITE_PILLUP = register("white_pillup", new MushfindersMushroomPlantBlock(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM)));
    Block POTTED_WHITE_PILLUP = register("potted_white_pillup", new FlowerPotBlock(WHITE_PILLUP,
        FabricBlockSettings.of(Material.DECORATION)
                           .breakInstantly().nonOpaque()
    ), null);

    private static Block register(String id, Block block, BiFunction<Block, Item.Settings, Item> item) {
        Identifier identifier = new Identifier(Mushfinders.MOD_ID, id);
        if (item != null) Registry.register(Registry.ITEM, identifier, item.apply(block, new FabricItemSettings().group(Mushfinders.ITEM_GROUP)));
        return Registry.register(Registry.BLOCK, identifier, block);
    }

    private static Block register(String id, Block block) {
        return register(id, block, BlockItem::new);
    }
}
