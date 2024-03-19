package com.insurgence.addons.sellboostaddon.listeners;

import com.insurgence.addons.sellboostaddon.utils.AddonUtil;
import me.rivaldev.mobsword.rivalmobswords.api.SwordMoneyReceiveEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public final class RivalSwordEventListener implements Listener {

    @EventHandler
    private void onReceive(SwordMoneyReceiveEvent event) {
        double multi = AddonUtil.getMulti(event.getPlayer());

        if (multi > 0) {
            event.setMoney(AddonUtil.calculateAmount(event.getMoney(), multi));
        }
    }
}
