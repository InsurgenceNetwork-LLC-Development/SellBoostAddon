package com.insurgence.addons.sellboostaddon;

import com.insurgence.addons.sellboostaddon.listeners.*;
import com.insurgence.addons.sellboostaddon.settings.MyConfig;
import org.insurgencedev.insurgenceboosters.api.addon.IBoostersAddon;
import org.insurgencedev.insurgenceboosters.api.addon.InsurgenceBoostersAddon;
import org.insurgencedev.insurgenceboosters.libs.fo.Common;

@IBoostersAddon(name = "SellBoostAddon", version = "2.0.2", author = "InsurgenceDev", description = "All-in-one sell boost")
public class SellBoostAddon extends InsurgenceBoostersAddon {

    public static final String TYPE = "Sell";
    public static final String NAMESPACE = "GENERAL_SELL";

    @Override
    public void onAddonReloadAblesStart() {
        MyConfig.instance.reload();

        if (isSupported("DeluxeSellwands")) {
            registerEvent(new DeluxeSellWandsListener());
        }

        if (isSupported("EconomyShopGUI") || isSupported("EconomyShopGUI-Premium")) {
            registerEvent(new EconomyShopGUIListener());
        }

        if (isSupported("ShopGUIPlus")) {
            registerEvent(new ShopGUIPlusListener());
        }

        if (isSupported("ManifestCollector")) {
            registerEvent(new ManifestCollectorListener());
        }

        if (isSupported("WildTools")) {
            registerEvent(new WildToolsListener());
        }

        if (isSupported("RivalPickaxes")) {
            registerEvent(new RivalPickaxeEventListener());
        }

        if (isSupported("RivalHarvesterHoes")) {
            registerEvent(new RivalHoeEventListener());
        }

        if (isSupported("RivalFishingRods")) {
            registerEvent(new RivalRodEventListener());
        }

        if (isSupported("RivalMobSwords")) {
            registerEvent(new RivalSwordEventListener());
        }

        if (isSupported("VoidChest")) {
            registerEvent(new VoidChestListener());
        }

        if (isSupported("ZithiumCollectors")) {
            registerEvent(new ZithiumCollectorListener());
        }

        if (isSupported("Sellwand")) {
            registerEvent(new SellwandListener());
        }
    }

    private boolean isSupported(String pluginName) {
        return Common.doesPluginExist(pluginName) && MyConfig.shouldBoost(pluginName);
    }
}
