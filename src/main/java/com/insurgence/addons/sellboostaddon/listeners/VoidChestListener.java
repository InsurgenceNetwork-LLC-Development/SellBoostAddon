package com.insurgence.addons.sellboostaddon.listeners;

import com.georgev22.voidchest.api.VoidChestAPI;
import com.insurgence.addons.sellboostaddon.utils.AddonUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.insurgencedev.insurgenceboosters.events.IBoosterStartEvent;

import java.time.Instant;

public final class VoidChestListener implements Listener {

    @EventHandler
    private void onStart(IBoosterStartEvent event) {
        Player player = event.getPlayer();

        AddonUtil.getMulti(player, (found, multi) -> {
            if (found) {
                VoidChestAPI.getInstance().playerManager().getEntity(player.getUniqueId()).thenAccept(data -> {
                    final long result = Instant.now().toEpochMilli() + (1000 * event.getBoosterData().getTimeLeft());
                    data.booster().boostTime(result);
                    data.booster().booster(multi);
                });
            }
        });
    }
}