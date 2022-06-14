package com.dashomi.preventer.config;

import me.lortseam.completeconfig.api.ConfigEntry;
import me.lortseam.completeconfig.api.ConfigGroup;

public class ModuleConfigGroup implements ConfigGroup {
    @ConfigEntry(translationKey = "lowDurabilityProtectionRange",tooltipTranslationKeys = "lowDurabilityProtectionRange.tooltip")
    @ConfigEntry.BoundedInteger(min = 1, max = 30)
    @ConfigEntry.Slider(valueTranslationKey = "lowDurabilityProtectionRange.valueKey")
    public int lowDurabilityProtectionRange = 1;
}
