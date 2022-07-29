package com.dashomi.preventer.config;

import me.lortseam.completeconfig.api.ConfigEntry;
import me.lortseam.completeconfig.api.ConfigGroup;

public class ModuleConfigGroup implements ConfigGroup {
    @ConfigEntry(translationKey = "lowDurabilityProtectionRange",tooltipTranslationKeys = "lowDurabilityProtectionRange.tooltip")
    @ConfigEntry.BoundedInteger(min = 1, max = 30)
    @ConfigEntry.Slider(valueTranslationKey = "lowDurabilityProtectionRange.valueKey")
    public int lowDurabilityProtectionRange = 1;

    @ConfigEntry(translationKey = "preventRocketUse.offhand", tooltipTranslationKeys = "preventRocketUse.offhand.tooltip")
    public boolean rocketInOffhand = true;

    @ConfigEntry(translationKey = "preventRocketUse.mainHand", tooltipTranslationKeys = "preventRocketUse.mainHand.tooltip")
    public boolean rocketInMainHand = false;
}
