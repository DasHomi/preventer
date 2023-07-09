package com.dashomi.preventer.config;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;

@Config(name = "preventer")
public class PreventerConfig implements ConfigData {
    public static PreventerConfig get() {
        return AutoConfig.getConfigHolder(PreventerConfig.class).getConfig();
    }
    public boolean welcomeMessage = true;

    public static void save() {
        AutoConfig.getConfigHolder(PreventerConfig.class).save();
    }

    public static void load() {
        AutoConfig.getConfigHolder(PreventerConfig.class).load();
    }

    public boolean noStrip = false;
    public boolean noStrip_msg = false;
    public boolean noPath = false;
    public boolean noPath_msg = false;
    public boolean noFarmland = false;
    public boolean noFarmland_msg = false;
    public boolean noSweetBerrieHarvest = false;
    public boolean noSweetBerrieHarvest_msg = false;
    public boolean noGlowBerrieHarvest = false;
    public boolean noGlowBerrieHarvest_msg = false;
    public boolean onlyMatureCropHarvest = false;
    public boolean onlyMatureCropHarvest_msg = false;
    public boolean noCake = false;
    public boolean noCake_msg = false;
    public boolean noScraping = false;
    public boolean noScraping_msg = false;
    public boolean noDeWax = false;
    public boolean noDeWax_msg = false;
    public boolean lowDurabilityProtection = false;
    public boolean lowDurabilityProtection_msg = false;
    public int lowDurabilityProtectionRange = 5;
    public boolean preventVillagerPunch = false;
    public boolean preventVillagerPunch_msg = false;
    public boolean noZombifiedPiglinPunch = false;
    public boolean noZombifiedPiglinPunch_msg = false;
    public boolean noTrappedChestOpening = false;
    public boolean noTrappedChestOpening_msg = false;
    public boolean preventBuddingAmethystBreaking = false;
    public boolean preventBuddingAmethystBreaking_msg = false;
    public boolean preventRocketUse = false;
    public boolean preventRocketUse_msg = false;
    public boolean rocketInOffhand = true;
    public boolean rocketInMainHand = false;
    public boolean preventEndCrystalHitting = false;
    public boolean preventEndCrystalHitting_msg = false;
    public boolean preventBedUse = false;
    public boolean preventBedUse_msg = false;
    public boolean preventCoralPlace = false;
    public boolean preventCoralPlace_msg = false;
    public boolean preventWaterPlace = false;
    public boolean preventWaterPlace_msg = false;
    public boolean preventStemBreaking = false;
    public boolean preventStemBreaking_msg = false;
    public boolean preventItemFrameBreaking = false;
    public boolean preventItemFrameBreaking_msg = false;
    public boolean preventPaintingBreaking = false;
    public boolean preventPaintingBreaking_msg = false;
    public boolean preventToolDropping = false;
    public boolean preventToolDropping_msg = false;
    public boolean preventGlassBreaking = false;
    public boolean preventGlassBreaking_msg = false;
    public boolean preventRenamedBlockPlacing = false;
    public boolean preventRenamedBlockPlacing_msg = false;
    public boolean preventRenamedItemEating = false;
    public boolean preventRenamedItemEating_msg = false;
    public boolean preventNoteBlockEditing = false;
    public boolean preventNoteBlockEditing_msg = false;
    public boolean preventGolemAttacking = false;
    public boolean preventGolemAttacking_msg = false;
    public boolean preventNamedMobAttacking = false;
    public boolean preventNamedMobAttacking_msg = false;
    public boolean preventTamedMobAttacking = false;
    public boolean preventTamedMobAttacking_msg = false;
    public boolean preventRareMobAttacking = false;
    public boolean preventRareMobAttacking_msg = false;
    public boolean preventHorseAttacking = false;
    public boolean preventHorseAttacking_msg = false;
    public boolean preventNeutralMobAttacking = false;
    public boolean preventNeutralMobAttacking_msg = false;
    public boolean aggroMobOverride = false;
    public boolean preventSuspiciousBlockBreaking = false;
    public boolean preventSuspiciousBlockBreaking_msg = false;
    public boolean enhancedSuspiciousBlockBreakingPrevention = false;
    public boolean preventRenamedItemDropping = false;
    public boolean preventRenamedItemDropping_msg = false;

    // Configs that don't have a usage msg
    public boolean hideShield = false;
    public boolean hideTotem = false;
}
