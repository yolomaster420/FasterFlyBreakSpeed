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

        float multiplier = 1.0f;
        Player player = event.getPlayer();

        if (player.isInWater()) {
            if (player.isEyeInFluid(FluidTags.WATER)) {
                multiplier *= 5.0f;
            }
        }
        if (!player.isOnGround()) {
            multiplier *= 5.0f;
        }

        event.setNewSpeed(event.getNewSpeed() * multiplier);

    }
}
