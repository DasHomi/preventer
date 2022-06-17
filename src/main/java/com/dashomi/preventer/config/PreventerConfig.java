package com.dashomi.preventer.config;

import com.dashomi.preventer.PreventerClient;
import me.lortseam.completeconfig.api.ConfigContainer;
import me.lortseam.completeconfig.api.ConfigEntry;
import me.lortseam.completeconfig.data.Config;
import me.lortseam.completeconfig.gui.ConfigScreenBuilder;
import me.lortseam.completeconfig.gui.coat.CoatScreenBuilder;
import net.fabricmc.loader.api.FabricLoader;


public class PreventerConfig extends Config implements ConfigContainer {
    public static PreventerConfig initialize() {
        PreventerClient.LOGGER.info("Initializing Config");
        PreventerConfig config = new PreventerConfig();
        config.load();
        if (FabricLoader.getInstance().isModLoaded("completeconfig-gui-coat")) {
            ConfigScreenBuilder.setMain(PreventerClient.MOD_ID, new CoatScreenBuilder());
        } else {
            PreventerClient.LOGGER.warn("Couldn't initialize Coat Screen because completeconfig-gui-coat is missing");
        }
        return config;
    }

    public PreventerConfig() {
        super(PreventerClient.MOD_ID);
    }

    @Transitive
    public final ModuleConfigGroup moduleConfigGroup = new ModuleConfigGroup();

    // Toggles
    @ConfigEntry(descriptionKey = "noStrip.tooltip")
    public boolean noStrip = false;

    @ConfigEntry(descriptionKey = "noPath.tooltip")
    public boolean noPath = false;

    @ConfigEntry(descriptionKey = "noFarmland.tooltip")
    public boolean noFarmland = false;

    @ConfigEntry(descriptionKey = "hideShield.tooltip")
    public boolean hideShield = false;

    @ConfigEntry(descriptionKey = "hideTotem.tooltip")
    public boolean hideTotem = false;

    @ConfigEntry(descriptionKey = "noSweetBerrieHarvest.tooltip")
    public boolean noSweetBerrieHarvest = false;

    @ConfigEntry(descriptionKey = "noGlowBerrieHarvest.tooltip")
    public boolean noGlowBerrieHarvest = false;

    @ConfigEntry(descriptionKey = "onlyMatureCropHarvest.tooltip")
    public boolean onlyMatureCropHarvest = false;

    //@ConfigEntry(descriptionKey = "noCake.tooltip")
    //public boolean noCake = false;

    @ConfigEntry(descriptionKey = "noScraping.tooltip")
    public boolean noScraping = false;

    @ConfigEntry(descriptionKey = "noDeWax.tooltip")
    public boolean noDeWax = false;

    @ConfigEntry(descriptionKey = "lowDurabilityProtection.tooltip")
    public boolean lowDurabilityProtection = false;
}
