package net.hopperfilter.mixin;

import net.minecraft.core.Direction;
import net.minecraft.world.Container;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.HopperBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import net.hopperfilter.HopperFilterHelper;

@Mixin(value = HopperBlockEntity.class, priority = 1000)
public class HopperBlockEntityMixin {

    @Inject(
        method = "addItem(Lnet/minecraft/world/Container;Lnet/minecraft/world/Container;Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/core/Direction;)Lnet/minecraft/world/item/ItemStack;",
        at = @At("HEAD"),
        cancellable = true
    )
    private static void onAddItem(Container source, Container destination, ItemStack stack, Direction direction, CallbackInfoReturnable<ItemStack> cir) {
        if (destination instanceof HopperBlockEntity hopper) {
            Level level = hopper.getLevel();
            if (level != null) {
                Direction targetSide = direction != null ? direction : Direction.UP;
                if (!HopperFilterHelper.isItemAllowed(level, hopper.getBlockPos(), targetSide, stack)) {
                    cir.setReturnValue(stack); // Return the stack unmodified to block the transfer
                }
            }
        }
    }

    @Inject(
        method = "addItem(Lnet/minecraft/world/Container;Lnet/minecraft/world/entity/item/ItemEntity;)Z",
        at = @At("HEAD"),
        cancellable = true
    )
    private static void onAddItemEntity(Container container, ItemEntity itemEntity, CallbackInfoReturnable<Boolean> cir) {
        if (container instanceof HopperBlockEntity hopper) {
            Level level = hopper.getLevel();
            if (level != null) {
                if (!HopperFilterHelper.isItemAllowed(level, hopper.getBlockPos(), Direction.UP, itemEntity.getItem())) {
                    cir.setReturnValue(false); // Return false to block sucking in the entity
                }
            }
        }
    }
}
