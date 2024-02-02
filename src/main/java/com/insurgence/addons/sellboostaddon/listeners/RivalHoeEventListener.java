package com.insurgence.addons.sellboostaddon.listeners;

import com.insurgence.addons.sellboostaddon.utils.AddonUtil;
import me.rivaldev.harvesterhoes.api.events.HoeMoneyReceiveEnchant;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public final class RivalHoeEventListener implements Listener {

    @EventHandler
    private void onReceive(HoeMoneyReceiveEnchant event) {
        AddonUtil.getMulti(event.getPlayer(), (found, multi) -> {
            if (found) {
                event.setMoney(AddonUtil.calculateAmount(event.getMoney(), multi));
            }
        });
    }
}
