package com.insurgence.addons.sellboostaddon.listeners;

import com.insurgence.addons.sellboostaddon.utils.AddonUtil;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.hassan.plugin.collector.event.CollectorSellEvent;

public final class ManifestCollectorListener implements Listener {

    @EventHandler(ignoreCancelled = true)
    private void onSell(CollectorSellEvent event) {
        double multi = AddonUtil.getMulti(event.getPlayer());

        if (multi > 0) {
            event.setPrice((float) AddonUtil.calculateAmount(event.getPrice(), multi));
        }
    }
}
