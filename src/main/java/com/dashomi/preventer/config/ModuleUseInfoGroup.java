package com.dashomi.preventer.config;

import me.lortseam.completeconfig.api.ConfigEntry;
import me.lortseam.completeconfig.api.ConfigGroup;

public class ModuleUseInfoGroup implements ConfigGroup {

    @ConfigEntry(translationKey = "description", tooltipTranslationKeys = "description.description")
    private boolean description;

    @ConfigEntry(translationKey = "noStrip")
    public boolean noStrip_msg = false;

    @ConfigEntry(translationKey = "noPath")
    public boolean noPath_msg = false;

    @ConfigEntry(translationKey = "noFarmland")
    public boolean noFarmland_msg = false;

    @ConfigEntry(translationKey = "noSweetBerrieHarvest")
    public boolean noSweetBerrieHarvest_msg = false;

    @ConfigEntry(translationKey = "noGlowBerrieHarvest")
    public boolean noGlowBerrieHarvest_msg = false;

    @ConfigEntry(translationKey = "onlyMatureCropHarvest")
    public boolean onlyMatureCropHarvest_msg = false;

    @ConfigEntry(translationKey = "noScraping")
    public boolean noScraping_msg = false;

    @ConfigEntry(translationKey = "noDeWax")
    public boolean noDeWax_msg = false;

    @ConfigEntry(translationKey = "lowDurabilityProtection")
    public boolean lowDurabilityProtection_msg = false;

    @ConfigEntry(translationKey = "preventVillagerPunch")
    public boolean preventVillagerPunch_msg = false;

    @ConfigEntry(translationKey = "noZombifiedPiglinPunch")
    public boolean noZombifiedPiglinPunch_msg = false;

    @ConfigEntry(translationKey = "noCake")
    public boolean noCake_msg = false;

    @ConfigEntry(translationKey = "noTrappedChestOpening")
    public boolean noTrappedChestOpening_msg = false;
}