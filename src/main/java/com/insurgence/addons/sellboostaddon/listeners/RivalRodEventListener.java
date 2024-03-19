package com.insurgence.addons.sellboostaddon.listeners;

import com.insurgence.addons.sellboostaddon.utils.AddonUtil;
import me.rivaldev.fishingrod.rivalfishingrods.api.RodMoneyReceiveEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public final class RivalRodEventListener implements Listener {

    @EventHandler
    private void onReceive(RodMoneyReceiveEvent event) {
        double multi = AddonUtil.getMulti(event.getPlayer());

        if (multi > 0) {
            event.setMoney(AddonUtil.calculateAmount(event.getMoney(), multi));
        }
    }
}
