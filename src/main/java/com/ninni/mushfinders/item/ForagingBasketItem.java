package com.ninni.mushfinders.item;

import com.ninni.mushfinders.mixin.ItemStackAccessor;
import com.ninni.mushfinders.tag.MushfindersBlockTags;
import com.ninni.mushfinders.tag.MushfindersItemTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.client.item.TooltipData;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.StackReference;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtList;
import net.minecraft.screen.slot.Slot;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ClickType;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class ForagingBasketItem extends Item {
    public static final short MAX_ITEMS = (64 * 2) + (64 / 2);

    public static final String ITEMS_KEY = "Items";
    public static final String COUNT_KEY = "Count";
    public static final String TAGS_KEY = "tag";
    public static final String ID_KEY = "id";

    public ForagingBasketItem(Settings settings) {
        super(settings);
    }

    @Override
    public boolean onStackClicked(ItemStack stack, Slot slot, ClickType type, PlayerEntity player) {
        if (type == ClickType.LEFT) return false;

        ItemStack sstack = slot.getStack();
        if (sstack.isEmpty()) {
            this.removeFirstStack(stack).ifPresent(s -> {
                this.addToStorage(stack, slot.insertStack(s));
                this.playRemoveOneSound(player);
            });
        } else if (sstack.isIn(MushfindersItemTags.FORAGEABLES)) {
            int max = (MAX_ITEMS - this.getStorageOccupancy(stack)) / this.getItemOccupancy(sstack);
            int in = this.addToStorage(stack, slot.takeStackRange(sstack.getCount(), max, player));
            if (in > 0) this.playInsertSound(player);
        }

        return true;
    }

    @Override
    public boolean onClicked(ItemStack stack, ItemStack otherStack, Slot slot, ClickType clickType, PlayerEntity player, StackReference ref) {
        if (clickType == ClickType.RIGHT && slot.canTakePartial(player)) {
            if (otherStack.isEmpty()) {
                this.removeFirstStack(stack).ifPresent(s -> {
                    this.playRemoveOneSound(player);
                    ref.set(s);
                });
            } else {
                int in = this.addToStorage(stack, otherStack);
                if (in > 0) {
                    this.playInsertSound(player);
                    otherStack.decrement(in);
                }
            }

            return true;
        }

        return false;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);
        if (player.shouldCancelInteraction() && this.dropAllStoredItems(stack, player)) {
            this.playDropContentsSound(player);
            player.incrementStat(Stats.USED.getOrCreateStat(this));
            return TypedActionResult.success(stack, world.isClient);
        } else return TypedActionResult.fail(stack);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        PlayerEntity player = context.getPlayer();
        if (!player.shouldCancelInteraction()) {
            World world = context.getWorld();
            BlockPos pos = context.getBlockPos();

            BlockState state = world.getBlockState(pos);
            Block block = state.getBlock();
            Item item = block.asItem();
            ItemStack stack = item.getDefaultStack();

            if (stack.isIn(MushfindersItemTags.FORAGEABLES) && !state.isIn(MushfindersBlockTags.NO_PICKUP_FORAGEABLES)) {
                ItemStack storage = context.getStack();
                int in = this.addToStorage(storage, stack);
                if (in > 0) {
                    world.removeBlock(pos, false);
                    this.playInsertSound(player);
                    return ActionResult.success(world.isClient);
                }
            }
        }

        return super.useOnBlock(context);
    }

    @Override
    public boolean isItemBarVisible(ItemStack stack) {
        return this.getStorageOccupancy(stack) > 0;
    }

    @Override
    public int getItemBarStep(ItemStack stack) {
        return Math.min(1 + 12 * this.getStorageOccupancy(stack) / MAX_ITEMS, 13);
    }

    @Override
    public int getItemBarColor(ItemStack stack) {
        return 0xFF6666;
    }

    public int addToStorage(ItemStack stack, ItemStack nu) {
        if (!nu.isEmpty() && nu.isIn(MushfindersItemTags.FORAGEABLES)) {
            NbtCompound nbt = stack.getOrCreateNbt();
            if (!nbt.contains(ITEMS_KEY)) nbt.put(ITEMS_KEY, new NbtList());

            int occb = this.getStorageOccupancy(stack);
            int occi = this.getItemOccupancy(nu);
            int in = Math.min(nu.getCount(), (MAX_ITEMS - occb) / occi);
            if (in == 0) {
                return 0;
            } else {
                NbtList items = nbt.getList(ITEMS_KEY, NbtElement.COMPOUND_TYPE);
                Optional<NbtCompound> nbtmo = this.canMergeStack(nu, items);
                if (nbtmo.isPresent()) {
                    NbtCompound nbtm = nbtmo.get();
                    ItemStack merged = this.fromNbt(nbtm);
                    merged.increment(in);
                    this.writeNbt(merged, nbtm);
                    items.remove(nbtm);
                    items.add(0, nbtm);
                } else {
                    ItemStack cstack = nu.copy();
                    cstack.setCount(in);
                    NbtCompound cnbt = new NbtCompound();
                    this.writeNbt(cstack, cnbt);
                    items.add(0, cnbt);
                }

                return in;
            }
        }

        return 0;
    }

    public Optional<NbtCompound> canMergeStack(ItemStack stack, NbtList list) {
        if (stack.isOf(MushfindersItems.FORAGING_BASKET)) return Optional.empty();
        Stream<NbtElement> items = list.stream().filter(NbtCompound.class::isInstance);
        return items.map(NbtCompound.class::cast).filter(i -> ItemStack.canCombine(this.fromNbt(i), stack)).findFirst();
    }

    public int getItemOccupancy(ItemStack stack) {
        return stack.isOf(MushfindersItems.FORAGING_BASKET) ? 4 + this.getStorageOccupancy(stack) : 1;
    }

    public int getStorageOccupancy(ItemStack stack) {
        return this.getStoredStacks(stack).mapToInt(s -> this.getItemOccupancy(s) * s.getCount()).sum();
    }

    public Optional<ItemStack> removeFirstStack(ItemStack stack) {
        NbtCompound nbt = stack.getOrCreateNbt();
        if (!nbt.contains(ITEMS_KEY)) {
            return Optional.empty();
        } else {
            NbtList items = nbt.getList(ITEMS_KEY, NbtElement.COMPOUND_TYPE);
            if (items.isEmpty()) {
                return Optional.empty();
            } else {
                NbtCompound item = items.getCompound(0);
                ItemStack first = this.fromNbt(item);
                int max = first.getMaxCount();
                int remainder = max - first.getCount();
                if (remainder < 0) {
                    first.setCount(max); // cap count
                    item.putShort(COUNT_KEY, (short) -remainder); // fix listed count
                } else {
                    items.remove(0);
                }
                if (items.isEmpty()) stack.removeSubNbt(ITEMS_KEY);
                return Optional.of(first);
            }
        }
    }

    public boolean dropAllStoredItems(ItemStack stack, PlayerEntity player) {
        NbtCompound nbt = stack.getOrCreateNbt();
        if (!nbt.contains(ITEMS_KEY)) return false;

        if (player instanceof ServerPlayerEntity) {
            Optional<ItemStack> drop = this.removeFirstStack(stack); // remove up to 64 until empty
            do {
                drop.ifPresent(s -> player.dropItem(s, true));
                drop = this.removeFirstStack(stack);
            } while (drop.isPresent());
        }

        stack.removeSubNbt(ITEMS_KEY);
        return true;
    }

    public Stream<ItemStack> getStoredStacks(ItemStack stack) {
        NbtCompound nbt = stack.getNbt();
        if (nbt == null) return Stream.empty();
        NbtList items = nbt.getList(ITEMS_KEY, NbtElement.COMPOUND_TYPE);
        return items.stream().map(NbtCompound.class::cast).map(this::fromNbt);
    }

    @Override
    public Optional<TooltipData> getTooltipData(ItemStack stack) {
        DefaultedList<ItemStack> inventory = DefaultedList.of();
        this.getStoredStacks(stack).forEach(inventory::add);
        return Optional.of(new ForagingBasketTooltipData(inventory, getStorageOccupancy(stack)));
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(new TranslatableText("%s.fullness".formatted(this.getTranslationKey()), this.getStorageOccupancy(stack), MAX_ITEMS).formatted(Formatting.GRAY));
    }

    @Override
    public void onItemEntityDestroyed(ItemEntity entity) {
        World world = entity.world;
        if (world.isClient) return;

        ItemStack stack = entity.getStack();
        Optional<ItemStack> drop = this.removeFirstStack(stack); // remove up to 64 until empty
        do {
            drop.ifPresent(s -> world.spawnEntity(new ItemEntity(world, entity.getX(), entity.getY(), entity.getZ(), s)));
            drop = this.removeFirstStack(stack);
        } while (drop.isPresent());
    }

    public void playRemoveOneSound(Entity entity) {
        entity.playSound(SoundEvents.ITEM_BUNDLE_REMOVE_ONE, 0.8F, 0.8F + entity.getWorld().getRandom().nextFloat() * 0.4F);
    }

    public void playInsertSound(Entity entity) {
        entity.playSound(SoundEvents.ITEM_BUNDLE_INSERT, 0.8F, 0.8F + entity.getWorld().getRandom().nextFloat() * 0.4F);
    }

    public void playDropContentsSound(Entity entity) {
        entity.playSound(SoundEvents.ITEM_BUNDLE_DROP_CONTENTS, 0.8F, 0.8F + entity.getWorld().getRandom().nextFloat() * 0.4F);
    }

    public void writeNbt(ItemStack stack, NbtCompound nbt) {
        Item item = stack.getItem();
        nbt.putString(ID_KEY, Registry.ITEM.getId(item).toString());
        nbt.putShort(COUNT_KEY, (short) stack.getCount());
        if (stack.getNbt() != null) {
            nbt.put(TAGS_KEY, stack.getNbt().copy());
        }
    }

    public ItemStack fromNbt(NbtCompound nbt) {
        try {
            Item item = Registry.ITEM.get(new Identifier(nbt.getString(ID_KEY)));
            int count = nbt.getShort(COUNT_KEY);
            ItemStack stack = new ItemStack(item, count);
            if (nbt.contains(TAGS_KEY, NbtElement.COMPOUND_TYPE)) stack.setNbt(nbt.getCompound(TAGS_KEY));
            return stack;
        } catch (RuntimeException exception) { ItemStackAccessor.getLOGGER().debug("Tried to load invalid item: {}", nbt, exception); }
        return ItemStack.EMPTY;
    }
}
