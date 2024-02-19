package com.insurgence.addons.sellboostaddon.listeners;

import com.insurgence.addons.sellboostaddon.utils.AddonUtil;
import me.zachary.sellwand.api.events.SellwandSellEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public final class SellwandListener implements Listener {

    @EventHandler(ignoreCancelled = true)
    private void onSell(SellwandSellEvent event) {
        Player player = event.getPlayer();

        AddonUtil.getMulti(player, (found, multi) -> {
            if (found) {
                event.setSellPrice(AddonUtil.calculateAmount(event.getSellPrice(), multi));
            }
        });
    }
}
