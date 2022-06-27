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
        PreventerClient.LOGGER.info("Initializing Config");
        PreventerConfig config = new PreventerConfig();
        config.load();
        if (FabricLoader.getInstance().isModLoaded("completeconfig-gui-cloth")) {
            ConfigScreenBuilder.setMain(PreventerClient.MOD_ID, new ClothConfigScreenBuilder());
        } else {
            PreventerClient.LOGGER.warn("Couldn't initialize Cloth Screen because completeconfig-gui-cloth is missing");
        }

        return config;
    }

    public PreventerConfig() {
        super(PreventerClient.MOD_ID);
    }

    @Transitive
    public final ModuleConfigGroup moduleConfigGroup = new ModuleConfigGroup();

    @Transitive
    public final ModuleUseInfoGroup moduleUseInfoGroup = new ModuleUseInfoGroup();

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

    @ConfigEntry(descriptionKey = "noCake.tooltip")
    public boolean noCake = false;

    @ConfigEntry(descriptionKey = "noScraping.tooltip")
    public boolean noScraping = false;

    @ConfigEntry(descriptionKey = "noDeWax.tooltip")
    public boolean noDeWax = false;

    @ConfigEntry(descriptionKey = "lowDurabilityProtection.tooltip")
    public boolean lowDurabilityProtection = false;

    @ConfigEntry(descriptionKey = "preventVillagerPunch.tooltip")
    public boolean preventVillagerPunch = false;

    @ConfigEntry(descriptionKey = "noZombifiedPiglinPunch.tooltip")
    public boolean noZombifiedPiglinPunch = false;

    @ConfigEntry(descriptionKey = "noTrappedChestOpening.tooltip")
    public boolean noTrappedChestOpening = false;
}
