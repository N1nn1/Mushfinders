package com.ninni.mushfinders;

import com.google.common.reflect.Reflection;
import com.ninni.mushfinders.block.MushfindersBlocks;
import com.ninni.mushfinders.item.MushfindersItems;
import com.ninni.mushfinders.sound.MushfindersSoundEvents;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Mushfinders implements ModInitializer {
	public static final String MOD_ID   = "mushfinders";
	public static final String MOD_NAME = "Mushfinders";
	public static final Logger LOGGER   = LoggerFactory.getLogger(MOD_ID);

	private static final boolean ORGANISE_GROUP_STACKS = false;
	public static final ItemGroup ITEM_GROUP =
		FabricItemGroupBuilder.create(new Identifier(Mushfinders.MOD_ID, "item_group"))
							  .icon(() -> new ItemStack(MushfindersItems.FORAGING_BASKET))
							  .appendItems((stacks, group) -> {
								  DefaultedList<ItemStack> items = (DefaultedList<ItemStack>) stacks;
								  if (ORGANISE_GROUP_STACKS) appendOrganisedStacks(items, group);
								  else Registry.ITEM.forEach(item -> item.appendStacks(group, items));
							  })
							  .build();

	@SuppressWarnings("UnstableApiUsage")
	@Override
	public void onInitialize() {
		LOGGER.info("Initializing {}", MOD_NAME);
		Reflection.initialize(MushfindersItems.class, MushfindersBlocks.class, MushfindersSoundEvents.class);
		LOGGER.info("Initialized {}", MOD_NAME);
	}

	public static void appendOrganisedStacks(DefaultedList<ItemStack> stacks, ItemGroup group) {
		int blocks = 0;
		for (Item item : Registry.ITEM) {
			Identifier id = Registry.ITEM.getId(item);
			if (id.getNamespace().equals(MOD_ID)) {
				if (item instanceof BlockItem) {
					item.appendStacks(group, stacks);
					blocks++;
				}
			}
		}

		for (int i = 0; i < 9 - (blocks % 9); i++) stacks.add(new ItemStack(Items.AIR));
		MushfindersItems.FORAGING_BASKET.appendStacks(group, stacks);
	}
}
