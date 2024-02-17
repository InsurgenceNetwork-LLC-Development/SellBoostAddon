package com.insurgence.addons.sellboostaddon.listeners;

import com.insurgence.addons.sellboostaddon.utils.AddonUtil;
import net.zithium.collectors.events.CollectorAutoSellEvent;
import net.zithium.collectors.events.CollectorSellAllEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.hassan.plugin.collector.event.CollectorSellEvent;

public final class ZithiumCollectorListener implements Listener {

    @EventHandler
    private void onSell(CollectorSellEvent event) {
        AddonUtil.getMulti(event.getPlayer(), (found, multi) -> {
            if (found) {
                event.setPrice((float) AddonUtil.calculateAmount(event.getPrice(), multi));
            }
        });
    }

    @EventHandler
    private void onSell(CollectorSellAllEvent event) {
        AddonUtil.getMulti(event.getPlayer(), (found, multi) -> {
            if (found) {
                event.setTotalWorth(AddonUtil.calculateAmount(event.getTotalAmount(), multi));
            }
        });
    }

    @EventHandler
    private void onSell(CollectorAutoSellEvent event) {
        AddonUtil.getMulti(event.getPlayer(), (found, multi) -> {
            if (found) {
                event.setTotalWorth(AddonUtil.calculateAmount(event.getTotalAmount(), multi));
            }
        });
    }
}
