package com.dashomi.preventer.config;

import com.dashomi.preventer.PreventerClient;
import me.lortseam.completeconfig.api.ConfigContainer;
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
    public boolean noStrip = false;

    @ConfigEntry(tooltipTranslationKeys = "noPath.tooltip")
    public boolean noPath = false;

    @ConfigEntry(tooltipTranslationKeys = "noFarmland.tooltip")
    public boolean noFarmland = false;

    @ConfigEntry(tooltipTranslationKeys = "hideShield.tooltip")
    public boolean hideShield = false;

    @ConfigEntry(tooltipTranslationKeys = "hideTotem.tooltip")
    public boolean hideTotem = false;

    @ConfigEntry(tooltipTranslationKeys = "noSweetBerrieHarvest.tooltip")
    public boolean noSweetBerrieHarvest = false;

    @ConfigEntry(tooltipTranslationKeys = "noGlowBerrieHarvest.tooltip")
    public boolean noGlowBerrieHarvest = false;

}
