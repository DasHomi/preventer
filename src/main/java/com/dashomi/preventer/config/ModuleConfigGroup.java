package com.dashomi.preventer.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "ModuleConfigGroup")
public class ModuleConfigGroup implements ConfigData {
    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.BoundedDiscrete(min = 1, max = 30)
    public int lowDurabilityProtectionRange = 1;
    @ConfigEntry.Gui.Tooltip
    public boolean rocketInOffhand = true;
    @ConfigEntry.Gui.Tooltip
    public boolean rocketInMainHand = false;
}
