package com.dashomi.preventer.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "PreventerConfig")
public class PreventerConfig implements ConfigData {
    @ConfigEntry.Gui.Excluded
    public boolean overrideKeyPressed = false;

    @ConfigEntry.Category("moduleConfigGroup")
    @ConfigEntry.Gui.TransitiveObject
    public ModuleConfigGroup moduleConfigGroup = new ModuleConfigGroup();

    @ConfigEntry.Category("moduleUseInfoGroup")
    @ConfigEntry.Gui.TransitiveObject
    public ModuleUseInfoGroup moduleUseInfoGroup = new ModuleUseInfoGroup();

    // Toggles
    @ConfigEntry.Gui.Tooltip
    public boolean noStrip = false;

    @ConfigEntry.Gui.Tooltip
    public boolean noPath = false;

    @ConfigEntry.Gui.Tooltip
    public boolean noFarmland = false;

    @ConfigEntry.Gui.Tooltip
    public boolean hideShield = false;

    @ConfigEntry.Gui.Tooltip
    public boolean hideTotem = false;

    @ConfigEntry.Gui.Tooltip
    public boolean noSweetBerrieHarvest = false;

    @ConfigEntry.Gui.Tooltip
    public boolean noGlowBerrieHarvest = false;

    @ConfigEntry.Gui.Tooltip
    public boolean onlyMatureCropHarvest = false;

    @ConfigEntry.Gui.Tooltip
    public boolean noCake = false;

    @ConfigEntry.Gui.Tooltip
    public boolean noScraping = false;

    @ConfigEntry.Gui.Tooltip
    public boolean noDeWax = false;

    @ConfigEntry.Gui.Tooltip
    public boolean lowDurabilityProtection = false;

    @ConfigEntry.Gui.Tooltip
    public boolean preventVillagerPunch = false;

    @ConfigEntry.Gui.Tooltip
    public boolean noZombifiedPiglinPunch = false;

    @ConfigEntry.Gui.Tooltip
    public boolean noTrappedChestOpening = false;

    @ConfigEntry.Gui.Tooltip
    public boolean preventBuddingAmethystBreaking = false;

    @ConfigEntry.Gui.Tooltip
    public boolean preventRocketUse = false;

    @ConfigEntry.Gui.Tooltip
    public boolean preventEndCrystalHitting = false;

    @ConfigEntry.Gui.Tooltip
    public boolean preventBedUse = false;

    @ConfigEntry.Gui.Tooltip
    public boolean preventCoralPlace = false;

    @ConfigEntry.Gui.Tooltip
    public boolean preventWaterPlace = false;
}
