package com.insurgence.addons.sellboostaddon.listeners;

import com.georgev22.voidchest.api.event.annotations.EventHandler;
import com.georgev22.voidchest.api.event.events.sell.VoidSellChunkItemEvent;
import com.georgev22.voidchest.api.event.events.sell.VoidSellItemEvent;
import com.georgev22.voidchest.api.event.interfaces.EventListener;
import com.insurgence.addons.sellboostaddon.utils.AddonUtil;
import org.bukkit.entity.Player;
import org.insurgencedev.insurgenceboosters.libs.fo.remain.Remain;

import java.math.BigDecimal;
import java.util.Objects;

public final class VoidChestListener implements EventListener {

    @EventHandler
    private void onSell(VoidSellItemEvent event) {
        Player player = Remain.getPlayerByUUID(Objects.requireNonNull(event.getVoidStorage()).ownerUUID());
        AddonUtil.getMulti(player, (found, multi) -> {
            if (found) {
                event.setPrice(BigDecimal.valueOf(AddonUtil.calculateAmount(event.getPrice().doubleValue(), multi)));
            }
        });
    }

    @EventHandler
    private void onSell(VoidSellChunkItemEvent event) {
        Player player = Remain.getPlayerByUUID(Objects.requireNonNull(event.getVoidStorage()).ownerUUID());
        AddonUtil.getMulti(player, (found, multi) -> {
            if (found) {
                event.setPrice(BigDecimal.valueOf(AddonUtil.calculateAmount(event.getPrice().doubleValue(), multi)));
            }
        });
    }
}
