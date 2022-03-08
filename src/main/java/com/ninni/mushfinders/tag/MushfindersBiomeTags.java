package com.ninni.mushfinders.tag;

import com.ninni.mushfinders.Mushfinders;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.PlacedFeature;

import java.util.function.Function;

public interface MushfindersBiomeTags {
    Function<RegistryEntry<PlacedFeature>, TagKey<Biome>> SPAWNS = Util.memoize(entry -> {
        return entry.getKey().map(key -> {
            PlacedFeature feature = BuiltinRegistries.PLACED_FEATURE.get(key);
            Identifier id = BuiltinRegistries.PLACED_FEATURE.getId(feature);
            return TagKey.of(Registry.BIOME_KEY, new Identifier(id.getNamespace(), "spawns_%s".formatted(id.getPath())));
        }).orElseThrow(); // 💀
    });

    private static TagKey<Biome> register(String id) {
        return TagKey.of(Registry.BIOME_KEY, new Identifier(Mushfinders.MOD_ID, id));
    }
}
