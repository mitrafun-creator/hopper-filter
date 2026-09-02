package net.hopperfilter;

import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.HopperBlockEntity;
import net.neoforged.neoforge.items.IItemHandler;

public class FilteredItemHandler implements IItemHandler {
    private final IItemHandler parent;
    private final HopperBlockEntity hopper;
    private final Direction side;

    public FilteredItemHandler(IItemHandler parent, HopperBlockEntity hopper, Direction side) {
        this.parent = parent;
        this.hopper = hopper;
        this.side = side;
    }

    @Override
    public int getSlots() {
        return parent.getSlots();
    }

    @Override
    public ItemStack getStackInSlot(int slot) {
        return parent.getStackInSlot(slot);
    }

    @Override
    public ItemStack insertItem(int slot, ItemStack stack, boolean simulate) {
        if (side != null) {
            if (!HopperFilterHelper.isItemAllowed(hopper.getLevel(), hopper.getBlockPos(), side, stack)) {
                return stack; // Block insertion by returning the stack unmodified
            }
        }
        return parent.insertItem(slot, stack, simulate);
    }

    @Override
    public ItemStack extractItem(int slot, int amount, boolean simulate) {
        return parent.extractItem(slot, amount, simulate);
    }

    @Override
    public int getSlotLimit(int slot) {
        return parent.getSlotLimit(slot);
    }

    @Override
    public boolean isItemValid(int slot, ItemStack stack) {
        if (side != null) {
            if (!HopperFilterHelper.isItemAllowed(hopper.getLevel(), hopper.getBlockPos(), side, stack)) {
                return false;
            }
        }
        return parent.isItemValid(slot, stack);
    }
}
