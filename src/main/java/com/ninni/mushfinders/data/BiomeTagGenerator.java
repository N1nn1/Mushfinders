package com.ninni.mushfinders.data;

import com.google.common.collect.ImmutableMap;
import com.ninni.mushfinders.Mushfinders;
import com.ninni.mushfinders.block.MushfindersMushroomPlantBlock;
import com.ninni.mushfinders.tag.MushfindersBiomeTags;
import com.ninni.mushfinders.world.gen.feature.MushfindersPlacedFeatures;
import net.minecraft.block.Block;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.moddingplayground.frame.api.toymaker.v0.generator.tag.AbstractTagGenerator;

import java.util.List;
import java.util.Map;

import static com.ninni.mushfinders.block.MushfindersBlocks.*;
import static net.minecraft.world.biome.Biome.*;

public class BiomeTagGenerator extends AbstractTagGenerator<Biome> {
    public BiomeTagGenerator(String modId) {
        super(modId, BuiltinRegistries.BIOME);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void generate() {
        /* Mushrooms */

        Map<Category, List<Block>> mushroomBiomes = Util.make(ImmutableMap.<Category, List<Block>>builder(), map -> {
            map.put(Category.FOREST, List.of(
                WHITE_PILLUP,
                BROWN_PILLUP,
                CRIMSON_PLUMP
            ));
            map.put(Category.TAIGA, List.of(
                BROWN_PILLUP
            ));
            map.put(Category.SWAMP, List.of(
                DISHCAP
            ));
            map.put(Category.ICY, List.of(
                TOQUESWAB
            ));
            map.put(Category.MESA, List.of(
                HELBRIM,
                SULFUR_BOLETE,
                DUNGWILT
            ));
            map.put(Category.DESERT, List.of(
                SULFUR_BOLETE
            ));
            map.put(Category.SAVANNA, List.of(
                SULFUR_BOLETE
            ));
            map.put(Category.UNDERGROUND, List.of(
                INKWEEP
            ));
            map.put(Category.JUNGLE, List.of(
                ROYAL_BEND
            ));
        }).build();

        for (Block block : Registry.BLOCK) {
            Identifier id = Registry.BLOCK.getId(block);
            if (id.getNamespace().equals(Mushfinders.MOD_ID)) {
                if (block instanceof MushfindersMushroomPlantBlock) {
                    RegistryEntry<PlacedFeature> feature = MushfindersPlacedFeatures.SURFACE_MUSHROOM.apply(block);
                    TagKey<Biome> tag = MushfindersBiomeTags.SPAWNS.apply(feature);
                    for (Biome biome : BuiltinRegistries.BIOME) {
                        BuiltinRegistries.BIOME.getKey(biome).flatMap(BuiltinRegistries.BIOME::getEntry).ifPresent(entry -> {
                            Category category = Biome.getCategory(entry);
                            List<Block> blocks = mushroomBiomes.get(category);
                            if (blocks != null && blocks.contains(block)) this.add(tag, biome);
                        });
                    }
                }
            }
        }
    }

    @Override
    public Identifier getId(Identifier id) {
        return new Identifier(id.getNamespace(), String.format("%s/%s", this.tagDir, id.getPath()));
    }
}
