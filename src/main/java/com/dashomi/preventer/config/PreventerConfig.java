package com.dashomi.preventer.config;

import com.dashomi.preventer.PreventerClient;
import me.lortseam.completeconfig.api.ConfigContainer;
import me.lortseam.completeconfig.api.ConfigEntries;
import me.lortseam.completeconfig.api.ConfigEntry;
import me.lortseam.completeconfig.data.Config;
import me.lortseam.completeconfig.gui.ConfigScreenBuilder;
import me.lortseam.completeconfig.gui.cloth.ClothConfigScreenBuilder;
import net.fabricmc.loader.api.FabricLoader;


public class PreventerConfig extends Config implements ConfigContainer {
    public static PreventerConfig initialize() {
        PreventerConfig config = new PreventerConfig();
        config.load();
        if (FabricLoader.getInstance().isModLoaded("cloth-config")) {
            ConfigScreenBuilder.setMain(PreventerClient.MOD_ID, new ClothConfigScreenBuilder());
        }
        return config;
    }

    public PreventerConfig() {
        super(PreventerClient.MOD_ID);
    }

    @ConfigEntry(tooltipTranslationKeys = "noStrip.tooltip")
    private boolean noStrip = false;

    @ConfigEntry(tooltipTranslationKeys = "noPath.tooltip")
    private boolean noPath = false;

}
