package com.insurgence.addons.sellboostaddon.listeners;

import com.insurgence.addons.sellboostaddon.utils.AddonUtil;
import dev.norska.dsw.api.DeluxeSellwandSellEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public final class DeluxeSellWandsListener implements Listener {

    @EventHandler(ignoreCancelled = true)
    private void onSell(DeluxeSellwandSellEvent event) {
        AddonUtil.getMulti(event.getPlayer(), (found, multi) -> {
            if (found) {
                event.setMoney(AddonUtil.calculateAmount(event.getMoney(), multi));
            }
        });
    }
}
