package com.dashomi.preventer.config;

import me.lortseam.completeconfig.api.ConfigEntry;
import me.lortseam.completeconfig.api.ConfigGroup;

public class ModuleConfigGroup implements ConfigGroup {
    @ConfigEntry(nameKey = "lowDurabilityProtectionRange",descriptionKey = "lowDurabilityProtectionRange.tooltip")
    @ConfigEntry.BoundedInteger(min = 1, max = 30)
    @ConfigEntry.Slider(valueKey = "lowDurabilityProtectionRange.valueKey")
    public int lowDurabilityProtectionRange = 1;
}
