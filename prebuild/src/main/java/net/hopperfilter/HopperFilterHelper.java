package net.hopperfilter;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.decoration.ItemFrame;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class HopperFilterHelper {

    /**
     * Determines whether an item is allowed to enter the hopper.
     * We check all 6 faces of the hopper for item frames. If at least one frame contains an item,
     * the hopper will only accept items that match one of the items inside the frames.
     */
    public static boolean isItemAllowed(Level level, BlockPos hopperPos, Direction dir, ItemStack stack) {
        if (level == null || hopperPos == null || stack == null || stack.isEmpty()) {
            return true;
        }

        boolean hasAnyFilter = false;
        boolean matched = false;
        ItemStack matchedFilter = ItemStack.EMPTY;

        // Check all 6 faces around the hopper
        for (Direction d : Direction.values()) {
            ItemFrame frame = getAttachedFrame(level, hopperPos, d);
            if (frame != null) {
                ItemStack filter = frame.getItem();
                if (!filter.isEmpty()) {
                    hasAnyFilter = true;
                    if (ItemStack.isSameItem(stack, filter)) {
                        matched = true;
                        matchedFilter = filter;
                    }
                }
            }
        }

        if (hasAnyFilter) {
            return matched;
        }

        return true;
    }

    /**
     * Finds the item frame attached to the hopper on the specified face.
     */
    public static ItemFrame getAttachedFrame(Level level, BlockPos hopperPos, Direction dir) {
        BlockPos expectedFramePos = hopperPos.relative(dir);
        List<ItemFrame> entities = level.getEntitiesOfClass(
            ItemFrame.class,
            new AABB(hopperPos).inflate(0.5),
            entity -> entity.getDirection() == dir && (entity.blockPosition().equals(expectedFramePos) || entity.blockPosition().equals(hopperPos))
        );
        return entities.isEmpty() ? null : entities.get(0);
    }
}
