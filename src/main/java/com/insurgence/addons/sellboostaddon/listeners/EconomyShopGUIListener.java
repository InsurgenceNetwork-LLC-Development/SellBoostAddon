package com.insurgence.addons.sellboostaddon.listeners;

import com.insurgence.addons.sellboostaddon.utils.AddonUtil;
import me.gypopo.economyshopgui.api.events.PreTransactionEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public final class EconomyShopGUIListener implements Listener {

    @EventHandler(ignoreCancelled = true)
    private void onSell(PreTransactionEvent event) {
        AddonUtil.getMulti(event.getPlayer(), (found, multi) -> {
            if (found) {
                event.setPrice(AddonUtil.calculateAmount(event.getPrice(), multi));
            }
        });
    }
}
