package com.insurgence.addons.sellboostaddon.listeners;

import com.insurgence.addons.sellboostaddon.utils.AddonUtil;
import me.zachary.sellwand.api.events.SellwandSellEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public final class SellwandListener implements Listener {

    @EventHandler(ignoreCancelled = true)
    private void onSell(SellwandSellEvent event) {
        double multi = AddonUtil.getMulti(event.getPlayer());

        if (multi > 0) {
            event.setSellPrice(AddonUtil.calculateAmount(event.getSellPrice(), multi));
        }
    }
}
