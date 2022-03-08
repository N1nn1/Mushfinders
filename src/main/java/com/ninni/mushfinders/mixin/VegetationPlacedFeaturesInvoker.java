package com.ninni.mushfinders.mixin;

import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.util.List;

@Mixin(VegetationPlacedFeatures.class)
public interface VegetationPlacedFeaturesInvoker {
    @Invoker static List<PlacementModifier> invokeModifiersWithChance(int chance, @Nullable PlacementModifier modifier) { throw new AssertionError(); }
}
