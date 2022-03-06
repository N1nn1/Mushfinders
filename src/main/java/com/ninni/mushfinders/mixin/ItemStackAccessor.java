package com.ninni.mushfinders.mixin;

import net.minecraft.item.ItemStack;
import org.slf4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ItemStack.class)
public interface ItemStackAccessor {
    @Accessor static Logger getLOGGER() { throw new AssertionError(); }
}
