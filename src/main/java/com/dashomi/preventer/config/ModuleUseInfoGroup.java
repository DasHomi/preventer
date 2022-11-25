package com.dashomi.preventer.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "ModuleUseInfoGroup")
public class ModuleUseInfoGroup implements ConfigData {
    @ConfigEntry.Gui.PrefixText

    public boolean noStrip_msg = false;
    public boolean noPath_msg = false;
    public boolean noFarmland_msg = false;
    public boolean noSweetBerrieHarvest_msg = false;
    public boolean noGlowBerrieHarvest_msg = false;
    public boolean onlyMatureCropHarvest_msg = false;
    public boolean noCake_msg = false;
    public boolean noScraping_msg = false;
    public boolean noDeWax_msg = false;
    public boolean lowDurabilityProtection_msg = false;
    public boolean preventVillagerPunch_msg = false;
    public boolean noZombifiedPiglinPunch_msg = false;
    public boolean noTrappedChestOpening_msg = false;
    public boolean preventBuddingAmethystBreaking_msg = false;
    public boolean preventRocketUse_msg = false;
    public boolean preventEndCrystalHitting_msg = false;
    public boolean preventBedUse_msg = false;
    public boolean preventCoralPlace_msg = false;
    public boolean preventWaterPlace_msg = false;
    public boolean preventStemBreaking_msg = false;
    public boolean preventItemFrameBreaking_msg = false;
    public boolean preventPaintingBreaking_msg = false;
    public boolean preventRenamedBlockPlacing_msg = false;
}
