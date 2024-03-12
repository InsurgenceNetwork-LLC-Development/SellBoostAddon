package com.insurgence.addons.sellboostaddon.listeners;

import com.insurgence.addons.sellboostaddon.utils.AddonUtil;
import net.codava.virtualspawner.api.event.PreSpawnerSellEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public final class VirtualSpawnerEventListener implements Listener {

    @EventHandler(ignoreCancelled = true)
    private void onSell(PreSpawnerSellEvent event) {
        AddonUtil.getMulti(event.getPlayer(), (found, multi) -> {
            if (found) {
                event.setAmount(AddonUtil.calculateAmount(event.getAmount(), multi));
            }
        });
    }
}
