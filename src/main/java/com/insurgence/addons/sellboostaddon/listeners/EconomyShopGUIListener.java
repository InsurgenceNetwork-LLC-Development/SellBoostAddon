package com.insurgence.addons.sellboostaddon.listeners;

import com.insurgence.addons.sellboostaddon.utils.AddonUtil;
import me.gypopo.economyshopgui.api.events.PreTransactionEvent;
import me.gypopo.economyshopgui.util.Transaction;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public final class EconomyShopGUIListener implements Listener {

    @EventHandler(ignoreCancelled = true)
    private void onSell(PreTransactionEvent event) {
        Transaction.Type type = event.getTransactionType();
        if (!type.getMode().equalsIgnoreCase("sold")) {
            return;
        }

        double multi = AddonUtil.getMulti(event.getPlayer());

        if (multi > 0) {
            if (type.equals(Transaction.Type.SELL_GUI_SCREEN) || type.equals(Transaction.Type.SELL_ALL_SCREEN) ||
                    type.equals(Transaction.Type.SELL_ALL_COMMAND)) {

                event.getPrices().replaceAll((k, v) -> AddonUtil.calculateAmount(v, multi));
                return;
            }

            event.setPrice(AddonUtil.calculateAmount(event.getPrice(), multi));
        }
    }
}
