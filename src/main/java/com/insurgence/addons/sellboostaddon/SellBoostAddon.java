package com.insurgence.addons.sellboostaddon;

import com.insurgence.addons.sellboostaddon.listeners.*;
import org.insurgencedev.insurgenceboosters.api.addon.IBoostersAddon;
import org.insurgencedev.insurgenceboosters.api.addon.InsurgenceBoostersAddon;
import org.insurgencedev.insurgenceboosters.libs.fo.Common;

@IBoostersAddon(name = "SellBoostAddon", version = "1.0.2", author = "InsurgenceDev", description = "All-in-one sell boost")
public class SellBoostAddon extends InsurgenceBoostersAddon {

    public static final String TYPE = "Sell";
    public static final String NAMESPACE = "GENERAL_SELL";

    @Override
    public void onAddonReloadAblesStart() {
        if (Common.doesPluginExist("DeluxeSellwands")) {
            registerEvent(new DeluxeSellWandsListener());
        }

        if (Common.doesPluginExist("EconomyShopGUI") || Common.doesPluginExist("EconomyShopGUI-Premium")) {
            registerEvent(new EconomyShopGUIListener());
        }

        if (Common.doesPluginExist("ShopGUIPlus")) {
            registerEvent(new ShopGUIPlusListener());
        }

        if (Common.doesPluginExist("ManifestCollector")) {
            registerEvent(new ManifestCollectorListener());
        }

        if (Common.doesPluginExist("WildTools")) {
            registerEvent(new WildToolsListener());
        }

        if (Common.doesPluginExist("RivalPickaxes")) {
            registerEvent(new RivalPickaxeEventListener());
        }

        if (Common.doesPluginExist("RivalHarvesterHoes")) {
            registerEvent(new RivalHoeEventListener());
        }

        if (Common.doesPluginExist("RivalFishingRods")) {
            registerEvent(new RivalRodEventListener());
        }

        if (Common.doesPluginExist("RivalMobSwords")) {
            registerEvent(new RivalSwordEventListener());
        }

        if (Common.doesPluginExist("VoidChest")) {
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
