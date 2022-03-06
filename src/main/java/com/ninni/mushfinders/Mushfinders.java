package com.ninni.mushfinders;

import com.google.common.reflect.Reflection;
import com.ninni.mushfinders.block.MushfindersBlocks;
import com.ninni.mushfinders.item.MushfindersItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class Mushfinders implements ModInitializer {
	public static final String MOD_ID = "mushfinders";
	public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(new Identifier(Mushfinders.MOD_ID, "item_group"), () -> new ItemStack(MushfindersItems.FORAGING_BASKET));
	//TODO make white pillups generate

	@SuppressWarnings("UnstableApiUsage")
	@Override
	public void onInitialize() {
		Reflection.initialize(
			MushfindersBlocks.class,
			MushfindersItems.class
		);
	}
}