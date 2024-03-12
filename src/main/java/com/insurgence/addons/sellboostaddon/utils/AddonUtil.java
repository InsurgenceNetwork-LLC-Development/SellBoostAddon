package com.insurgence.addons.sellboostaddon.utils;

import com.insurgence.addons.sellboostaddon.SellBoostAddon;
import lombok.experimental.UtilityClass;
import org.bukkit.entity.Player;
import org.insurgencedev.insurgenceboosters.api.IBoosterAPI;
import org.insurgencedev.insurgenceboosters.data.BoosterFindResult;

import java.util.function.BiConsumer;

@UtilityClass
public class AddonUtil {

    public void getMulti(Player player, BiConsumer<Boolean, Double> ifFound) {
        final double[] totalMulti = {0};

        BoosterFindResult pResult = IBoosterAPI.INSTANCE.getCache(player).getBoosterDataManager().findActiveBooster(SellBoostAddon.TYPE, SellBoostAddon.NAMESPACE);
        if (pResult instanceof BoosterFindResult.Success boosterResult) {
            totalMulti[0] += boosterResult.getBoosterData().getMultiplier();
        }

        IBoosterAPI.INSTANCE.getGlobalBoosterManager().findGlobalBooster(SellBoostAddon.TYPE, SellBoostAddon.NAMESPACE, globalBooster -> {
            totalMulti[0] += globalBooster.getMultiplier();
            return null;
        }, () -> null);

        ifFound.accept(totalMulti[0] > 0, totalMulti[0]);
    }

    public double calculateAmount(double amount, double multi) {
        return amount * (multi <= 1 ? 1 + multi : multi);
    }
}
