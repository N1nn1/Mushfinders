package com.ninni.mushfinders;

import com.google.common.reflect.Reflection;
import com.ninni.mushfinders.block.MushfindersBlocks;
import com.ninni.mushfinders.item.MushfindersItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Mushfinders implements ModInitializer {
	public static final String MOD_ID   = "mushfinders";
	public static final String MOD_NAME = "Mushfinders";
	public static final Logger LOGGER   = LoggerFactory.getLogger(MOD_ID);

	public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(new Identifier(Mushfinders.MOD_ID, "item_group"), () -> new ItemStack(MushfindersItems.FORAGING_BASKET));

	@SuppressWarnings("UnstableApiUsage")
	@Override
	public void onInitialize() {
		LOGGER.info("Initializing {}", MOD_NAME);
		Reflection.initialize(MushfindersItems.class, MushfindersBlocks.class);
		LOGGER.info("Initialized {}", MOD_NAME);
	}
}
