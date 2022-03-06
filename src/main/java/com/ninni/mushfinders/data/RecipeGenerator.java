package com.ninni.mushfinders.data;

import com.ninni.mushfinders.item.MushfindersItems;
import com.ninni.mushfinders.tag.MushfindersItemTags;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.moddingplayground.frame.api.toymaker.v0.generator.recipe.AbstractRecipeGenerator;

public class RecipeGenerator extends AbstractRecipeGenerator {
    public RecipeGenerator(String modId) {
        super(modId);
    }

    @Override
    public void generate() {
        this.add("foraging_basket", ShapedRecipeJsonBuilder.create(MushfindersItems.FORAGING_BASKET, 1)
                                                           .input('/', Items.STICK)
                                                           .input('B', MushfindersItemTags.FORAGEABLES)
                                                           .input('O', Items.BOWL)
                                                           .pattern(" / ")
                                                           .pattern("/B/")
                                                           .pattern(" O ")
                                                           .criterion("has_forageable", hasItems(MushfindersItemTags.FORAGEABLES)));
    }
}
