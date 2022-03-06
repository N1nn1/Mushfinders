package com.ninni.mushfinders.data;

import com.ninni.mushfinders.Mushfinders;
import net.minecraft.loot.context.LootContextTypes;
import net.moddingplayground.frame.api.toymaker.v0.ToymakerEntrypoint;
import net.moddingplayground.frame.api.toymaker.v0.registry.generator.ItemModelGeneratorStore;
import net.moddingplayground.frame.api.toymaker.v0.registry.generator.LootGeneratorStore;
import net.moddingplayground.frame.api.toymaker.v0.registry.generator.RecipeGeneratorStore;
import net.moddingplayground.frame.api.toymaker.v0.registry.generator.StateModelGeneratorStore;
import net.moddingplayground.frame.api.toymaker.v0.registry.generator.TagGeneratorStore;

public class MushfindersToymaker implements ToymakerEntrypoint {
    @Override
    public void onInitializeToymaker() {
        ItemModelGeneratorStore.register(() -> new ItemModelGenerator(Mushfinders.MOD_ID));
        StateModelGeneratorStore.register(() -> new StateModelGenerator(Mushfinders.MOD_ID));
        TagGeneratorStore.register(() -> new ItemTagGenerator(Mushfinders.MOD_ID));
        TagGeneratorStore.register(() -> new BlockTagGenerator(Mushfinders.MOD_ID));
        RecipeGeneratorStore.register(() -> new RecipeGenerator(Mushfinders.MOD_ID));
        LootGeneratorStore.register(() -> new BlockLootTableGenerator(Mushfinders.MOD_ID), LootContextTypes.BLOCK);
    }
}
