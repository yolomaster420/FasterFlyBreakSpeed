package com.aurorab0realis.fasterflybreakspeed.event;

import com.aurorab0realis.fasterflybreakspeed.FasterFlyBreakSpeed;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
@Mod.EventBusSubscriber(modid = FasterFlyBreakSpeed.MOD_ID)
public class BreakSpeed {
    @SubscribeEvent
    public static void onBreakSpeedEvent(PlayerEvent.BreakSpeed event) {
        Player player = event.getPlayer();

        if (player.isInWater()) {
            if (player.isEyeInFluid(FluidTags.WATER)) {
                event.setNewSpeed(event.getNewSpeed() * 5);
            }
        }
        if (!player.isOnGround()) {
            event.setNewSpeed(event.getNewSpeed() * 5);
        }

    }

}
