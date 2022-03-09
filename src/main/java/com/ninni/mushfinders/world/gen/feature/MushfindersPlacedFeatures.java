package com.ninni.mushfinders.world.gen.feature;

import com.ninni.mushfinders.Mushfinders;
import com.ninni.mushfinders.block.MushfindersMushroomPlantBlock;
import com.ninni.mushfinders.mixin.VegetationPlacedFeaturesInvoker;
import com.ninni.mushfinders.tag.MushfindersBiomeTags;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.block.Block;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.RandomPatchFeatureConfig;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

import java.util.List;
import java.util.function.Function;

public interface MushfindersPlacedFeatures {
    Function<Block, RegistryEntry<PlacedFeature>> SURFACE_MUSHROOM = Util.memoize(block -> {
        Identifier id = Registry.BLOCK.getId(block);
        RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> feature = MushfindersConfiguredFeatures.PATCH_SURFACE_MUSHROOM.apply(block);
        return register(
            new Identifier(id.getNamespace(), "mushroom_%s".formatted(id.getPath())), feature,
            VegetationPlacedFeaturesInvoker.invokeModifiersWithChance(512, null)
        );
    });

    static void onInitialize() {
        for (Block block : Registry.BLOCK) {
            Identifier id = Registry.BLOCK.getId(block);
            if (id.getNamespace().equals(Mushfinders.MOD_ID)) {
                if (block instanceof MushfindersMushroomPlantBlock) {
                    RegistryEntry<PlacedFeature> feature = SURFACE_MUSHROOM.apply(block);
                    tryPlace(feature, MushfindersBiomeTags.SPAWNS.apply(feature), GenerationStep.Feature.VEGETAL_DECORATION);
                }
            }
        }
    }

    private static void tryPlace(RegistryEntry<PlacedFeature> feature, TagKey<Biome> tag, GenerationStep.Feature step) {
        feature.getKey().ifPresent(key -> BiomeModifications.addFeature(BiomeSelectors.tag(tag), step, key));
    }

    private static RegistryEntry<PlacedFeature> register(String id, RegistryEntry<? extends ConfiguredFeature<?, ?>> feature, List<PlacementModifier> modifiers) {
        return register(new Identifier(Mushfinders.MOD_ID, id), feature, modifiers);
    }

    private static RegistryEntry<PlacedFeature> register(Identifier id, RegistryEntry<? extends ConfiguredFeature<?, ?>> feature, List<PlacementModifier> modifiers) {
        return PlacedFeatures.register(id.toString(), feature, modifiers);
    }
}
