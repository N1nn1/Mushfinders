package com.ninni.mushfinders.data;

import com.ninni.mushfinders.Mushfinders;
import com.ninni.mushfinders.block.MushfindersMushroomPlantBlock;
import com.ninni.mushfinders.tag.MushfindersBiomeTags;
import com.ninni.mushfinders.world.gen.feature.MushfindersPlacedFeatures;
import net.minecraft.block.Block;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.moddingplayground.frame.api.toymaker.v0.generator.tag.AbstractTagGenerator;

import static net.minecraft.world.biome.Biome.*;

public class BiomeTagGenerator extends AbstractTagGenerator<Biome> {
    public BiomeTagGenerator(String modId) {
        super(modId, BuiltinRegistries.BIOME);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void generate() {

        for (Block block : Registry.BLOCK) {
            Identifier id = Registry.BLOCK.getId(block);
            if (id.getNamespace().equals(Mushfinders.MOD_ID)) {
                if (block instanceof MushfindersMushroomPlantBlock) {
                    RegistryEntry<PlacedFeature> feature = MushfindersPlacedFeatures.MUSHROOM.apply(block);
                    TagKey<Biome> tag = MushfindersBiomeTags.SPAWNS.apply(feature);
                    for (Biome biome : BuiltinRegistries.BIOME) {
                        BuiltinRegistries.BIOME.getKey(biome).flatMap(BuiltinRegistries.BIOME::getEntry).ifPresent(entry -> {
                            Category category = Biome.getCategory(entry);
                            if (category == Category.FOREST) this.add(tag, biome);
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
