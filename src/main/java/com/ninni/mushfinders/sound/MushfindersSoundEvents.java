package com.ninni.mushfinders.sound;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static com.ninni.mushfinders.Mushfinders.*;

public class MushfindersSoundEvents {

    public static final SoundEvent ITEM_FORAGING_BASKET_PICKUP = foraging_basket("pickup");
    public static final SoundEvent ITEM_FORAGING_BASKET_EMPTIES = foraging_basket("empties");
    private static SoundEvent foraging_basket(String id) {
        return createItemSound("foraging_basket", id);
    }

    private static SoundEvent register(String id) {
        Identifier identifier = new Identifier(MOD_ID, id);
        return Registry.register(Registry.SOUND_EVENT, identifier, new SoundEvent(identifier));
    }

    private static SoundEvent createItemSound(String item, String id) {
        return register("item." + item + "." + id);
    }
}
