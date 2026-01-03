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
    public boolean preventLogStripping = false;
    public boolean preventPathCreation = false;
    public boolean preventFarmlandCreation = false;
    public boolean preventCakeEating = false;
    public boolean preventCopperOxidationScraping = false;
    public boolean preventCopperDeWaxing = false;
    public boolean preventTrappedChestOpening = false;
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
    public boolean preventItemFrameInteracting = false;
    public boolean preventRocketSpamming = false;

    // Plants
    public boolean preventGlowBerrieHarvesting = false;
    public boolean preventSweetBerrieHarvesting = false;
    public boolean preventNonMatureCropHarvesting = false; // fix
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
    public boolean preventBreakingWithoutFortune = false;

    // Placing
    public boolean preventCoralPlacing = false;
    public boolean preventWaterPlacing = false;
    public boolean preventLavaPlacing = false;
    public boolean preventOffhandPlacing = false;
    public boolean preventBerriePlanting = false;
    public PreventPlacingAfterEatingConfig preventPlacingAfterEating = PreventPlacingAfterEatingConfig.OFF;

    // Attacking
    public boolean preventVillagerPunching = false;
    public boolean preventZombifiedPiglinPunching = false;
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
    public boolean preventEnchantedItemSmelting = false;
    public boolean preventCurseOfBindingEquip = false;

    // General Settings
    public ActionPreventedInfo actionPreventedInfoType = ActionPreventedInfo.DEFAULT;
    public boolean showLowDurabilityProtectionWarning = true;
}
