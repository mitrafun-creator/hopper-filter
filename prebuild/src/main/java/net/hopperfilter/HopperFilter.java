package net.hopperfilter;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.items.wrapper.InvWrapper;

@Mod(HopperFilter.MOD_ID)
public class HopperFilter {
    public static final String MOD_ID = "hopperfilter";

    public HopperFilter() {
    }

    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD)
    public static class ModEvents {
        @SubscribeEvent(priority = EventPriority.HIGHEST)
        public static void registerCapabilities(RegisterCapabilitiesEvent event) {
            event.registerBlockEntity(
                Capabilities.ItemHandler.BLOCK,
                BlockEntityType.HOPPER,
                (hopper, side) -> new FilteredItemHandler(new InvWrapper(hopper), hopper, side)
            );
        }
    }
}
