package com.dashomi.preventer.config;

import me.lortseam.completeconfig.api.ConfigEntry;
import me.lortseam.completeconfig.api.ConfigGroup;

public class ModuleUseInfoGroup implements ConfigGroup {

    @ConfigEntry(nameKey = "description", descriptionKey = "description.description")
    private boolean description;

    @ConfigEntry(nameKey = "noStrip")
    public boolean noStrip_msg = false;

    @ConfigEntry(nameKey = "noPath")
    public boolean noPath_msg = false;

    @ConfigEntry(nameKey = "noFarmland")
    public boolean noFarmland_msg = false;

    @ConfigEntry(nameKey = "noSweetBerrieHarvest")
    public boolean noSweetBerrieHarvest_msg = false;

    @ConfigEntry(nameKey = "noGlowBerrieHarvest")
    public boolean noGlowBerrieHarvest_msg = false;

    @ConfigEntry(nameKey = "onlyMatureCropHarvest")
    public boolean onlyMatureCropHarvest_msg = false;

    @ConfigEntry(nameKey = "noScraping")
    public boolean noScraping_msg = false;

    @ConfigEntry(nameKey = "noDeWax")
    public boolean noDeWax_msg = false;

    @ConfigEntry(nameKey = "lowDurabilityProtection")
    public boolean lowDurabilityProtection_msg = false;

    @ConfigEntry(nameKey = "preventVillagerPunch")
    public boolean preventVillagerPunch_msg = false;

    @ConfigEntry(nameKey = "noZombifiedPiglinPunch")
    public boolean noZombifiedPiglinPunch_msg = false;

    @ConfigEntry(nameKey = "noCake")
    public boolean noCake_msg = false;

    @ConfigEntry(nameKey = "noTrappedChestOpening")
    public boolean noTrappedChestOpening_msg = false;

    @ConfigEntry(nameKey = "preventBuddingAmethystBreaking")
    public boolean preventBuddingAmethystBreaking_msg = false;

    @ConfigEntry(nameKey = "preventRocketUse")
    public boolean preventRocketUse_msg = false;

    @ConfigEntry(nameKey = "preventEndCrystalHitting")
    public boolean preventEndCrystalHitting_msg = false;
}
