package net.hopperfilter;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.Hopper;
import net.neoforged.neoforge.items.IItemHandler;

public class FilteredExtractItemHandler implements IItemHandler {
    private final IItemHandler parent;
    private final Level level;
    private final Hopper hopper;
    private final BlockPos hopperPos;

    public FilteredExtractItemHandler(IItemHandler parent, Level level, Hopper hopper) {
        this.parent = parent;
        this.level = level;
        this.hopper = hopper;
        this.hopperPos = BlockPos.containing(hopper.getLevelX(), hopper.getLevelY(), hopper.getLevelZ());
    }

    @Override
    public int getSlots() {
        return parent.getSlots();
    }

    @Override
    public ItemStack getStackInSlot(int slot) {
        ItemStack stack = parent.getStackInSlot(slot);
        if (!stack.isEmpty()) {
            if (!HopperFilterHelper.isItemAllowed(level, hopperPos, Direction.UP, stack)) {
                return ItemStack.EMPTY;
            }
        }
        return stack;
    }

    @Override
    public ItemStack insertItem(int slot, ItemStack stack, boolean simulate) {
        return parent.insertItem(slot, stack, simulate);
    }

    @Override
    public ItemStack extractItem(int slot, int amount, boolean simulate) {
        ItemStack simulated = parent.extractItem(slot, amount, true);
        if (!simulated.isEmpty()) {
            if (!HopperFilterHelper.isItemAllowed(level, hopperPos, Direction.UP, simulated)) {
                return ItemStack.EMPTY;
            }
        }
        return parent.extractItem(slot, amount, simulate);
    }

    @Override
    public int getSlotLimit(int slot) {
        return parent.getSlotLimit(slot);
    }

    @Override
    public boolean isItemValid(int slot, ItemStack stack) {
        return parent.isItemValid(slot, stack);
    }
}
