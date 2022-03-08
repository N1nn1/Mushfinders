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

public interface MushfindersBlocks {
    /* Mushrooms */

    Block AZURE_SKIRT = registerMushroom("azure_skirt");
    Block WHITE_PILLUP = registerMushroom("white_pillup");
    Block BROWN_PILLUP = registerMushroom("brown_pillup");
    Block CRIMSON_PLUMP = registerMushroom("crimson_plump");
    Block DISHCAP = registerMushroom("dishcap");
    Block GOADSTOOL = registerMushroom("goadstool");
    Block HELBRIM = registerMushroom("helbrim");
    Block MARITOLD = registerMushroom("maritold");
    Block ROYAL_BEND = registerMushroom("royal_bend");
    Block STRIPED_LUMINO = registerMushroom("striped_lumino");
    Block SULFUR_BOLETE = registerMushroom("sulfur_bolete");
    Block TOQUESWAB = registerMushroom("toqueswab");
    Block WARPFUNNEL = registerMushroom("warpfunnel");

    /* Taller Mushrooms */

    Block CATSBANE = registerTallMushroom("catsbane");
    Block DUKES_PLUMP = registerTallMushroom("dukes_plump");
    Block DUNGWILT = registerTallMushroom("dungwilt");
    Block GNOME_HEAD = registerTallMushroom("gnome_head");
    Block HEDGEKING = registerTallMushroom("hedgeking");
    Block INKWEEP = registerTallMushroom("inkweep");
    Block SALMONOKI = registerTallMushroom("salmonoki");
    Block SNAGGLEHORN = registerTallMushroom("snagglehorn");
    Block SWINGBULB = registerTallMushroom("swingbulb");
    Block THROATBINDER = registerTallMushroom("throatbinder");
    Block WAX_STACK = registerTallMushroom("wax_stack");

    /* Potted Mushrooms */

    Block POTTED_AZURE_SKIRT = registerFlowerPot("potted_azure_skirt", AZURE_SKIRT);
    Block POTTED_WHITE_PILLUP = registerFlowerPot("potted_white_pillup", WHITE_PILLUP);
    Block POTTED_BROWN_PILLUP = registerFlowerPot("potted_brown_pillup", BROWN_PILLUP);
    Block POTTED_CRIMSON_PLUMP = registerFlowerPot("potted_crimson_plump", CRIMSON_PLUMP);
    Block POTTED_DISHCAP = registerFlowerPot("potted_dishcap", DISHCAP);
    Block POTTED_GOADSTOOL = registerFlowerPot("potted_goadstool", GOADSTOOL);
    Block POTTED_HELBRIM = registerFlowerPot("potted_helbrim", HELBRIM);
    Block POTTED_MARITOLD = registerFlowerPot("potted_maritold", MARITOLD);
    Block POTTED_ROYAL_BEND = registerFlowerPot("potted_royal_bend", ROYAL_BEND);
    Block POTTED_STRIPED_LUMINO = registerFlowerPot("potted_striped_lumino", STRIPED_LUMINO);
    Block POTTED_SULFUR_BOLETE = registerFlowerPot("potted_sulfur_bolete", SULFUR_BOLETE);
    Block POTTED_TOQUESWAB = registerFlowerPot("potted_toqueswab", TOQUESWAB);
    Block POTTED_WARPFUNNEL = registerFlowerPot("potted_warpfunnel", WARPFUNNEL);

    /* Taller Potted Mushrooms */

    Block POTTED_CATSBANE = registerFlowerPot("potted_catsbane", CATSBANE);
    Block POTTED_DUKES_PLUMP = registerFlowerPot("potted_dukes_plump", DUKES_PLUMP);
    Block POTTED_DUNGWILT = registerFlowerPot("potted_dungwilt", DUNGWILT);
    Block POTTED_GNOME_HEAD = registerFlowerPot("potted_gnome_head", GNOME_HEAD);
    Block POTTED_HEDGEKING = registerFlowerPot("potted_hedgeking", HEDGEKING);
    Block POTTED_INKWEEP = registerFlowerPot("potted_inkweep", INKWEEP);
    Block POTTED_SALMONOKI = registerFlowerPot("potted_salmonoki", SALMONOKI);
    Block POTTED_SNAGGLEHORN = registerFlowerPot("potted_snagglehorn", SNAGGLEHORN);
    Block POTTED_SWINGBULB = registerFlowerPot("potted_swingbulb", SWINGBULB);
    Block POTTED_THROATBINDER = registerFlowerPot("potted_throatbinder", THROATBINDER);
    Block POTTED_WAX_STACK = registerFlowerPot("potted_wax_stack", WAX_STACK);

    private static Block register(String id, Block block, BiFunction<Block, Item.Settings, Item> item) {
        Identifier identifier = new Identifier(Mushfinders.MOD_ID, id);
        if (item != null) Registry.register(Registry.ITEM, identifier, item.apply(block, new FabricItemSettings().group(Mushfinders.ITEM_GROUP)));
        return Registry.register(Registry.BLOCK, identifier, block);
    }

    private static Block register(String id, Block block) {
        return register(id, block, BlockItem::new);
    }

    private static Block registerMushroom(String id) {
        return register(id, new MushfindersMushroomPlantBlock(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM)));
    }

    private static Block registerTallMushroom(String id) {
        return register(id, new MushfindersTallMushroomPlantBlock(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM)));
    }

    private static Block registerFlowerPot(String id, Block flower) {
        return register(id, new FlowerPotBlock(flower, FabricBlockSettings.of(Material.DECORATION).breakInstantly().nonOpaque()), null);
    }
}
