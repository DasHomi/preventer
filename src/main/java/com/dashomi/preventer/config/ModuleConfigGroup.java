package com.dashomi.preventer.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "ModuleConfigGroup")
public class ModuleConfigGroup implements ConfigData {
    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.BoundedDiscrete(min = 1, max = 30)
    public int lowDurabilityProtectionRange = 5;

    public boolean rocketInOffhand = true;

    public boolean rocketInMainHand = false;
}
