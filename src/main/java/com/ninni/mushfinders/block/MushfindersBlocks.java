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
    //normal mushrooms
    Block AZURE_SKIRT = register("azure_skirt", new MushfindersMushroomPlantBlock(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM)));
    Block WHITE_PILLUP = register("white_pillup", new MushfindersMushroomPlantBlock(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM)));
    Block BROWN_PILLUP = register("brown_pillup", new MushfindersMushroomPlantBlock(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM)));
    Block CRIMSON_PLUMP = register("crimson_plump", new MushfindersMushroomPlantBlock(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM)));
    Block DISHCAP = register("dishcap", new MushfindersMushroomPlantBlock(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM)));
    Block GOADSTOOL = register("goadstool", new MushfindersMushroomPlantBlock(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM)));
    Block HELBRIM = register("helbrim", new MushfindersMushroomPlantBlock(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM)));
    Block MARITOLD = register("maritold", new MushfindersMushroomPlantBlock(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM)));
    Block ROYAL_BEND = register("royal_bend", new MushfindersMushroomPlantBlock(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM)));
    Block STRIPED_LUMINO = register("striped_lumino", new MushfindersMushroomPlantBlock(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM)));
    Block SULFUR_BOLETE = register("sulfur_bolete", new MushfindersMushroomPlantBlock(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM)));
    Block TOQUESWAB = register("toqueswab", new MushfindersMushroomPlantBlock(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM)));
    Block WARPFUNNEL = register("warpfunnel", new MushfindersMushroomPlantBlock(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM)));
    //taller mushrooms
    Block CATSBANE = register("catsbane", new MushfindersTallMushroomPlantBlock(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM)));
    Block DUKES_PLUMP = register("dukes_plump", new MushfindersTallMushroomPlantBlock(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM)));
    Block DUNGWILT = register("dungwilt", new MushfindersTallMushroomPlantBlock(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM)));
    Block GNOME_HEAD = register("gnome_head", new MushfindersTallMushroomPlantBlock(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM)));
    Block HEDGEKING = register("hedgeking", new MushfindersTallMushroomPlantBlock(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM)));
    Block INKWEEP = register("inkweep", new MushfindersTallMushroomPlantBlock(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM)));
    Block SALMONOKI = register("salmonoki", new MushfindersTallMushroomPlantBlock(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM)));
    Block SNAGGLEHORN = register("snagglehorn", new MushfindersTallMushroomPlantBlock(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM)));
    Block SWINGBULB = register("swingbulb", new MushfindersTallMushroomPlantBlock(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM)));
    Block THROATBINDER = register("throatbinder", new MushfindersTallMushroomPlantBlock(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM)));
    Block WAX_STACK = register("wax_stack", new MushfindersTallMushroomPlantBlock(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM)));

    //normal potted mushrooms
    Block POTTED_AZURE_SKIRT = register("potted_azure_skirt", new FlowerPotBlock(AZURE_SKIRT, FabricBlockSettings.of(Material.DECORATION).breakInstantly().nonOpaque()), null);
    Block POTTED_WHITE_PILLUP = register("potted_white_pillup", new FlowerPotBlock(WHITE_PILLUP, FabricBlockSettings.of(Material.DECORATION).breakInstantly().nonOpaque()), null);
    Block POTTED_BROWN_PILLUP = register("potted_brown_pillup", new FlowerPotBlock(BROWN_PILLUP, FabricBlockSettings.of(Material.DECORATION).breakInstantly().nonOpaque()), null);
    Block POTTED_CRIMSON_PLUMP = register("potted_crimson_plump", new FlowerPotBlock(CRIMSON_PLUMP, FabricBlockSettings.of(Material.DECORATION).breakInstantly().nonOpaque()), null);
    Block POTTED_DISHCAP = register("potted_dishcap", new FlowerPotBlock(DISHCAP, FabricBlockSettings.of(Material.DECORATION).breakInstantly().nonOpaque()), null);
    Block POTTED_GOADSTOOL = register("potted_goadstool", new FlowerPotBlock(GOADSTOOL, FabricBlockSettings.of(Material.DECORATION).breakInstantly().nonOpaque()), null);
    Block POTTED_HELBRIM = register("potted_helbrim", new FlowerPotBlock(HELBRIM, FabricBlockSettings.of(Material.DECORATION).breakInstantly().nonOpaque()), null);
    Block POTTED_MARITOLD = register("potted_maritold", new FlowerPotBlock(MARITOLD, FabricBlockSettings.of(Material.DECORATION).breakInstantly().nonOpaque()), null);
    Block POTTED_ROYAL_BEND = register("potted_royal_bend", new FlowerPotBlock(ROYAL_BEND, FabricBlockSettings.of(Material.DECORATION).breakInstantly().nonOpaque()), null);
    Block POTTED_STRIPED_LUMINO = register("potted_striped_lumino", new FlowerPotBlock(STRIPED_LUMINO, FabricBlockSettings.of(Material.DECORATION).breakInstantly().nonOpaque()), null);
    Block POTTED_SULFUR_BOLETE = register("potted_sulfur_bolete", new FlowerPotBlock(SULFUR_BOLETE, FabricBlockSettings.of(Material.DECORATION).breakInstantly().nonOpaque()), null);
    Block POTTED_TOQUESWAB = register("potted_toqueswab", new FlowerPotBlock(TOQUESWAB, FabricBlockSettings.of(Material.DECORATION).breakInstantly().nonOpaque()), null);
    Block POTTED_WARPFUNNEL = register("potted_warpfunnel", new FlowerPotBlock(WARPFUNNEL, FabricBlockSettings.of(Material.DECORATION).breakInstantly().nonOpaque()), null);
    //taller potted mushrooms
    Block POTTED_CATSBANE = register("potted_catsbane", new FlowerPotBlock(CATSBANE, FabricBlockSettings.of(Material.DECORATION).breakInstantly().nonOpaque()), null);
    Block POTTED_DUKES_PLUMP = register("potted_dukes_plump", new FlowerPotBlock(DUKES_PLUMP, FabricBlockSettings.of(Material.DECORATION).breakInstantly().nonOpaque()), null);
    Block POTTED_DUNGWILT = register("potted_dungwilt", new FlowerPotBlock(DUNGWILT, FabricBlockSettings.of(Material.DECORATION).breakInstantly().nonOpaque()), null);
    Block POTTED_GNOME_HEAD = register("potted_gnome_head", new FlowerPotBlock(GNOME_HEAD, FabricBlockSettings.of(Material.DECORATION).breakInstantly().nonOpaque()), null);
    Block POTTED_HEDGEKING = register("potted_hedgeking", new FlowerPotBlock(HEDGEKING, FabricBlockSettings.of(Material.DECORATION).breakInstantly().nonOpaque()), null);
    Block POTTED_INKWEEP = register("potted_inkweep", new FlowerPotBlock(INKWEEP, FabricBlockSettings.of(Material.DECORATION).breakInstantly().nonOpaque()), null);
    Block POTTED_SALMONOKI = register("potted_salmonoki", new FlowerPotBlock(SALMONOKI, FabricBlockSettings.of(Material.DECORATION).breakInstantly().nonOpaque()), null);
    Block POTTED_SNAGGLEHORN = register("potted_snagglehorn", new FlowerPotBlock(SNAGGLEHORN, FabricBlockSettings.of(Material.DECORATION).breakInstantly().nonOpaque()), null);
    Block POTTED_SWINGBULB = register("potted_swingbulb", new FlowerPotBlock(SWINGBULB, FabricBlockSettings.of(Material.DECORATION).breakInstantly().nonOpaque()), null);
    Block POTTED_THROATBINDER = register("potted_throatbinder", new FlowerPotBlock(THROATBINDER, FabricBlockSettings.of(Material.DECORATION).breakInstantly().nonOpaque()), null);
    Block POTTED_WAX_STACK = register("potted_wax_stack", new FlowerPotBlock(WAX_STACK, FabricBlockSettings.of(Material.DECORATION).breakInstantly().nonOpaque()), null);

    private static Block register(String id, Block block, BiFunction<Block, Item.Settings, Item> item) {
        Identifier identifier = new Identifier(Mushfinders.MOD_ID, id);
        if (item != null) Registry.register(Registry.ITEM, identifier, item.apply(block, new FabricItemSettings().group(Mushfinders.ITEM_GROUP)));
        return Registry.register(Registry.BLOCK, identifier, block);
    }

    private static Block register(String id, Block block) {
        return register(id, block, BlockItem::new);
    }
}
