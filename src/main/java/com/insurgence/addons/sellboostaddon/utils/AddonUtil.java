package com.insurgence.addons.sellboostaddon.utils;

import com.google.common.util.concurrent.AtomicDouble;
import com.insurgence.addons.sellboostaddon.SellBoostAddon;
import lombok.experimental.UtilityClass;
import org.bukkit.entity.Player;
import org.insurgencedev.insurgenceboosters.api.IBoosterAPI;
import org.insurgencedev.insurgenceboosters.data.BoosterFindResult;
import org.insurgencedev.insurgenceboosters.data.PermanentBoosterData;

import java.util.Optional;
import java.util.function.BiConsumer;

@UtilityClass
public class AddonUtil {

    public void getMulti(Player player, BiConsumer<Boolean, Double> ifFound) {
        AtomicDouble totalMulti = new AtomicDouble(getPersonalPermMulti(player) + getGlobalPermMulti());

        BoosterFindResult pResult = IBoosterAPI.INSTANCE.getCache(player).getBoosterDataManager().findActiveBooster(SellBoostAddon.TYPE, SellBoostAddon.NAMESPACE);
        if (pResult instanceof BoosterFindResult.Success boosterResult) {
            totalMulti.getAndAdd(boosterResult.getBoosterData().getMultiplier());
        }

        IBoosterAPI.INSTANCE.getGlobalBoosterManager().findGlobalBooster(SellBoostAddon.TYPE, SellBoostAddon.NAMESPACE, globalBooster -> {
            totalMulti.getAndAdd(globalBooster.getMultiplier());
            return null;
        }, () -> null);

        ifFound.accept(totalMulti.get() > 0, totalMulti.get());
    }

    private double getPersonalPermMulti(Player uuid) {
        Optional<PermanentBoosterData> foundMulti = Optional.ofNullable(IBoosterAPI.INSTANCE.getCache(uuid).getPermanentBoosts().getPermanentBooster(SellBoostAddon.TYPE, SellBoostAddon.NAMESPACE));
        return foundMulti.map(PermanentBoosterData::getMulti).orElse(0d);
    }

    private double getGlobalPermMulti() {
        AtomicDouble multi = new AtomicDouble(0d);

        IBoosterAPI.INSTANCE.getGlobalBoosterManager().findPermanentBooster(SellBoostAddon.TYPE, SellBoostAddon.NAMESPACE, data -> {
            multi.set(data.getMulti());
            return null;
        }, () -> null);

        return multi.get();
    }

    public double calculateAmount(double amount, double multi) {
        return amount * (multi < 1 ? 1 + multi : multi);
    }
}