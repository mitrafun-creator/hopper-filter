package net.hopperfilter.mixin;

import java.util.Optional;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.Hopper;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.VanillaInventoryCodeHooks;
import org.apache.commons.lang3.tuple.Pair;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import net.hopperfilter.FilteredExtractItemHandler;

@Mixin(value = VanillaInventoryCodeHooks.class, remap = false)
public class VanillaInventoryCodeHooksMixin {

    @Inject(
        method = "getSourceItemHandler(Lnet/minecraft/world/level/Level;Lnet/minecraft/world/level/block/entity/Hopper;)Ljava/util/Optional;",
        at = @At("RETURN"),
        cancellable = true
    )
    private static void onGetSourceItemHandler(Level level, Hopper hopper, CallbackInfoReturnable<Optional<Pair<IItemHandler, Object>>> cir) {
        Optional<Pair<IItemHandler, Object>> original = cir.getReturnValue();
        if (original.isPresent()) {
            Pair<IItemHandler, Object> pair = original.get();
            IItemHandler wrapped = new FilteredExtractItemHandler(pair.getKey(), level, hopper);
            cir.setReturnValue(Optional.of(Pair.of(wrapped, pair.getValue())));
        }
    }
}
