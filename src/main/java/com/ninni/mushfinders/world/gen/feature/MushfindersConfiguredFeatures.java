package com.ninni.mushfinders.world.gen.feature;

import com.ninni.mushfinders.Mushfinders;
import net.minecraft.block.Block;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.RandomPatchFeatureConfig;
import net.minecraft.world.gen.feature.SimpleBlockFeatureConfig;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

import java.util.function.Function;

public interface MushfindersConfiguredFeatures {
    Function<Block, RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>>> PATCH_MUSHROOM = Util.memoize(block -> {
        Identifier id = Registry.BLOCK.getId(block);
        return register(new Identifier(id.getNamespace(), "patch_mushroom_%s".formatted(id.getPath())), Feature.RANDOM_PATCH, randomPatch(block));
    });

    private static RandomPatchFeatureConfig randomPatch(Block block) {
        return randomPatch(block, 96);
    }

    private static RandomPatchFeatureConfig randomPatch(Block block, int tries) {
        return randomPatch(BlockStateProvider.of(block), tries);
    }

    private static RandomPatchFeatureConfig randomPatch(BlockStateProvider block, int tries) {
        return ConfiguredFeatures.createRandomPatchFeatureConfig(tries, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(block)));
    }

    private static <C extends FeatureConfig, F extends Feature<C>> RegistryEntry<ConfiguredFeature<C, ?>> register(String id, F feature, C config) {
        return register(new Identifier(Mushfinders.MOD_ID, id), feature, config);
    }

    private static <C extends FeatureConfig, F extends Feature<C>> RegistryEntry<ConfiguredFeature<C, ?>> register(Identifier id, F feature, C config) {
        return BuiltinRegistries.method_40360(BuiltinRegistries.CONFIGURED_FEATURE, id.toString(), new ConfiguredFeature<>(feature, config));
    }
}
