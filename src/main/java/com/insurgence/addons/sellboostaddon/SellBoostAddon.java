package com.insurgence.addons.sellboostaddon;

import com.georgev22.voidchest.api.VoidChestAPI;
import com.insurgence.addons.sellboostaddon.listeners.*;
import org.insurgencedev.insurgenceboosters.api.addon.IBoostersAddon;
import org.insurgencedev.insurgenceboosters.api.addon.InsurgenceBoostersAddon;
import org.insurgencedev.insurgenceboosters.libs.fo.Common;

@IBoostersAddon(name = "SellBoostAddon", version = "1.0.0", author = "InsurgenceDev", description = "All-in-one sell boost")
public class SellBoostAddon extends InsurgenceBoostersAddon {

    public static final String TYPE = "Sell";
    public static final String NAMESPACE = "GENERAL_SELL";

    @Override
    public void onAddonStart() {
        if (Common.doesPluginExist("VoidChest")) {
            VoidChestAPI.getInstance().eventManager().register(new VoidChestListener());
        }
    }

    @Override
    public void onAddonReloadAblesStart() {
        if (Common.doesPluginExist("DeluxeSellwands")) {
            registerEvent(new DeluxeSellWandsListener());
        }

        if (Common.doesPluginExist("EconomyShopGUI")) {
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
    }
}
