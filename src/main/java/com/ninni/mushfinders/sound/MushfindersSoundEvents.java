package com.ninni.mushfinders.sound;

import com.ninni.mushfinders.Mushfinders;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public interface MushfindersSoundEvents {
    SoundEvent ITEM_FORAGING_BASKET_PICKUP = foragingBasket("pickup");
    SoundEvent ITEM_FORAGING_BASKET_EMPTIES = foragingBasket("empties");
    private static SoundEvent foragingBasket(String id) {
        return item("foraging_basket", id);
    }

    private static SoundEvent item(String item, String id) {
        return register("item." + item + "." + id);
    }

    private static SoundEvent register(String id) {
        Identifier identifier = new Identifier(Mushfinders.MOD_ID, id);
        return Registry.register(Registry.SOUND_EVENT, identifier, new SoundEvent(identifier));
    }
}
