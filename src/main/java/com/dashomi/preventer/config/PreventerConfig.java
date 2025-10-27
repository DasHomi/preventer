package com.dashomi.preventer.config;

import com.dashomi.preventer.enums.*;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;

@Config(name = "preventer")
public class PreventerConfig implements ConfigData {
    public static PreventerConfig get() {
        return AutoConfig.getConfigHolder(PreventerConfig.class).getConfig();
    }

    public static void save() {
        AutoConfig.getConfigHolder(PreventerConfig.class).save();
    }

    public static void load() {
        AutoConfig.getConfigHolder(PreventerConfig.class).load();
    }

    public boolean welcomeMessage = true;

    // Interaction
    public boolean noStrip = false;
    public boolean noPath = false;
    public boolean noFarmland = false;
    public boolean noCake = false;
    public boolean noScraping = false;
    public boolean noDeWax = false;
    public boolean noTrappedChestOpening = false;
    public PreventRocketUseConfig preventRocketUse = PreventRocketUseConfig.OFF;
    public boolean preventBedUse = false;
    public boolean preventDragonEggTeleport = false;
    public boolean preventRenamedItemUsing = false;
    public boolean preventNoteBlockEditing = false;
    public boolean preventRespawnAnchorUse = false;
    public boolean preventGrassBonemeal = false;
    public boolean preventSignEditing = false;
    public boolean preventChestSignEditing = false;
    public boolean preventChiseledBookshelfInteracting = false;

    // Plants
    public boolean noGlowBerrieHarvest = false;
    public boolean noSweetBerrieHarvest = false;
    public boolean onlyMatureCropHarvest = false; // fix
    public boolean preventStemBreaking = false;
    public boolean preventSugarCaneBreaking = false;
    public boolean preventFarmlandJumping = false;

    // Breaking
    public boolean preventBuddingAmethystBreaking = false;
    public boolean preventItemFrameBreaking = false;
    public boolean preventPaintingBreaking = false;
    public boolean preventGlassBreaking = false;
    public PreventSuspiciousBlockBreakingConfig preventSuspiciousBlockBreaking = PreventSuspiciousBlockBreakingConfig.OFF;
    public boolean preventEnderChestBreaking = false;
    public boolean preventSpawnerBreaking = false;
    public boolean preventChestBreaking = false;
    public boolean preventCarpetBreaking = false;
    public boolean preventSaplingBreaking = false;
    public boolean preventImmatureAmethystBreaking = false;
    public boolean preventBreakingWithWeapon = false;

    // Placing
    public boolean preventCoralPlace = false;
    public boolean preventWaterPlace = false;
    public boolean preventLavaPlacing = false;
    public boolean preventOffhandPlacing = false;
    public boolean preventBerriePlanting = false;
    public PreventPlacingAfterEatingConfig preventPlacingAfterEating = PreventPlacingAfterEatingConfig.OFF;

    // Attacking
    public boolean preventVillagerPunch = false;
    public boolean noZombifiedPiglinPunch = false;
    public boolean preventEndCrystalHitting = false;
    public boolean preventGolemAttacking = false;
    public boolean preventNamedMobAttacking = false;
    public boolean preventTamedMobAttacking = false;
    public boolean preventRareMobAttacking = false;
    public boolean preventHorseAttacking = false;
    public PreventNeutralMobAttackingConfig preventNeutralMobAttacking = PreventNeutralMobAttackingConfig.OFF;
    public boolean preventDolphinAttacking = false;

    // Other
    public boolean lowDurabilityProtection = false;
    public boolean preventToolDropping = false;
    public boolean preventRenamedItemDropping = false;
    public boolean preventSwimming = false;
    public boolean hideShield = false;
    public boolean hideTotem = false;
    public boolean notifyToggledOff = true;

    // General Settings
    public ActionPreventedInfo actionPreventedInfoType = ActionPreventedInfo.DEFAULT;
    public boolean showLowDurabilityProtectionWarning = true;
}
