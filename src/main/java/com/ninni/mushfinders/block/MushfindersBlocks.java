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
    Block BROWN_PILLUP = register("brown_pillup", new MushfindersMushroomPlantBlock(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM)));
    Block CRIMSON_PLUMP = register("crimson_plump", new MushfindersMushroomPlantBlock(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM)));
    Block DISHCAP = register("dishcap", new MushfindersMushroomPlantBlock(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM)));
    Block GOADSTOOL = register("goadstool", new MushfindersMushroomPlantBlock(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM)));
    Block HELBRIM = register("helbrim", new MushfindersMushroomPlantBlock(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM)));
    Block ROYAL_BEND = register("royal_bend", new MushfindersMushroomPlantBlock(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM)));
    Block SULFUR_BOLETE = register("sulfur_bolete", new MushfindersMushroomPlantBlock(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM)));
    Block TOQUESWAB = register("toqueswab", new MushfindersMushroomPlantBlock(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM)));
    Block WARPFUNNEL = register("warpfunnel", new MushfindersMushroomPlantBlock(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM)));

    Block POTTED_WHITE_PILLUP = register("potted_white_pillup", new FlowerPotBlock(WHITE_PILLUP, FabricBlockSettings.of(Material.DECORATION).breakInstantly().nonOpaque()), null);
    Block POTTED_BROWN_PILLUP = register("potted_brown_pillup", new FlowerPotBlock(BROWN_PILLUP, FabricBlockSettings.of(Material.DECORATION).breakInstantly().nonOpaque()), null);
    Block POTTED_CRIMSON_PLUMP = register("potted_crimson_plump", new FlowerPotBlock(CRIMSON_PLUMP, FabricBlockSettings.of(Material.DECORATION).breakInstantly().nonOpaque()), null);
    Block POTTED_DISHCAP = register("potted_dishcap", new FlowerPotBlock(DISHCAP, FabricBlockSettings.of(Material.DECORATION).breakInstantly().nonOpaque()), null);
    Block POTTED_GOADSTOOL = register("potted_goadstool", new FlowerPotBlock(GOADSTOOL, FabricBlockSettings.of(Material.DECORATION).breakInstantly().nonOpaque()), null);
    Block POTTED_HELBRIM = register("potted_helbrim", new FlowerPotBlock(HELBRIM, FabricBlockSettings.of(Material.DECORATION).breakInstantly().nonOpaque()), null);
    Block POTTED_ROYAL_BEND = register("potted_royal_bend", new FlowerPotBlock(ROYAL_BEND, FabricBlockSettings.of(Material.DECORATION).breakInstantly().nonOpaque()), null);
    Block POTTED_SULFUR_BOLETE = register("potted_sulfur_bolete", new FlowerPotBlock(SULFUR_BOLETE, FabricBlockSettings.of(Material.DECORATION).breakInstantly().nonOpaque()), null);
    Block POTTED_TOQUESWAB = register("potted_toqueswab", new FlowerPotBlock(TOQUESWAB, FabricBlockSettings.of(Material.DECORATION).breakInstantly().nonOpaque()), null);
    Block POTTED_WARPFUNNEL = register("potted_warpfunnel", new FlowerPotBlock(WARPFUNNEL, FabricBlockSettings.of(Material.DECORATION).breakInstantly().nonOpaque()), null);

    private static Block register(String id, Block block, BiFunction<Block, Item.Settings, Item> item) {
        Identifier identifier = new Identifier(Mushfinders.MOD_ID, id);
        if (item != null) Registry.register(Registry.ITEM, identifier, item.apply(block, new FabricItemSettings().group(Mushfinders.ITEM_GROUP)));
        return Registry.register(Registry.BLOCK, identifier, block);
    }

    private static Block register(String id, Block block) {
        return register(id, block, BlockItem::new);
    }
}
