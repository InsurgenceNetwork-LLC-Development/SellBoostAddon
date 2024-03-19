package com.insurgence.addons.sellboostaddon.listeners;

import com.bgsoftware.wildtools.api.events.HarvesterHoeSellEvent;
import com.bgsoftware.wildtools.api.events.SellWandUseEvent;
import com.insurgence.addons.sellboostaddon.utils.AddonUtil;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public final class WildToolsListener implements Listener {

    @EventHandler(ignoreCancelled = true)
    private void onSell(SellWandUseEvent event) {
        double multi = AddonUtil.getMulti(event.getPlayer());

        if (multi > 0) {
            event.setPrice(AddonUtil.calculateAmount(event.getPrice(), multi));
        }
    }

    @EventHandler(ignoreCancelled = true)
    private void onSell(HarvesterHoeSellEvent event) {
        double multi = AddonUtil.getMulti(event.getPlayer());

        if (multi > 0) {
            event.setPrice(AddonUtil.calculateAmount(event.getPrice(), multi));
        }
    }
}
