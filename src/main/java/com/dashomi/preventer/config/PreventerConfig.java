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

    // Interaction
    public boolean noStrip = false;
    public boolean noStrip_msg = false;
    public boolean noPath = false;
    public boolean noPath_msg = false;
    public boolean noFarmland = false;
    public boolean noFarmland_msg = false;
    public boolean noCake = false;
    public boolean noCake_msg = false;
    public boolean noScraping = false;
    public boolean noScraping_msg = false;
    public boolean noDeWax = false;
    public boolean noDeWax_msg = false;
    public boolean noTrappedChestOpening = false;
    public boolean noTrappedChestOpening_msg = false;
    public boolean preventRocketUse = false;
    public boolean preventRocketUse_msg = false;
    public boolean rocketInOffhand = true;
    public boolean rocketInMainHand = false;
    public boolean preventBedUse = false;
    public boolean preventBedUse_msg = false;
    public boolean preventDragonEggTeleport = false;
    public boolean preventDragonEggTeleport_msg = false;
    public boolean preventRenamedItemUsing = false;
    public boolean preventRenamedItemUsing_msg = false;
    public boolean preventNoteBlockEditing = false;
    public boolean preventNoteBlockEditing_msg = false;
    public boolean preventRespawnAnchorUse = false;
    public boolean preventRespawnAnchorUse_msg = false;
    public boolean preventGrassBonemeal = false;
    public boolean preventGrassBonemeal_msg = false;
    public boolean preventSignEditing = false;
    public boolean preventSignEditing_msg = false;
    public boolean preventChestSignEditing = false;
    public boolean preventChiseledBookshelfInteracting = false;
    public boolean preventChiseledBookshelfInteracting_msg = false;

    // Plants
    public boolean noGlowBerrieHarvest = false;
    public boolean noGlowBerrieHarvest_msg = false;
    public boolean noSweetBerrieHarvest = false;
    public boolean noSweetBerrieHarvest_msg = false;
    public boolean onlyMatureCropHarvest = false; // fix
    public boolean onlyMatureCropHarvest_msg = false;
    public boolean preventStemBreaking = false;
    public boolean preventStemBreaking_msg = false;
    public boolean preventSugarCaneBreaking = false;
    public boolean preventSugarCaneBreaking_msg = false;
    public boolean preventFarmlandJumping = false;
    public boolean preventFarmlandJumping_msg = false;

    // Breaking
    public boolean preventBuddingAmethystBreaking = false;
    public boolean preventBuddingAmethystBreaking_msg = false;
    public boolean preventItemFrameBreaking = false;
    public boolean preventItemFrameBreaking_msg = false;
    public boolean preventPaintingBreaking = false;
    public boolean preventPaintingBreaking_msg = false;
    public boolean preventGlassBreaking = false;
    public boolean preventGlassBreaking_msg = false;
    public boolean preventSuspiciousBlockBreaking = false;
    public boolean preventSuspiciousBlockBreaking_msg = false;
    public boolean enhancedSuspiciousBlockBreakingPrevention = false;
    public boolean preventEnderChestBreaking = false;
    public boolean preventEnderChestBreaking_msg = false;
    public boolean preventSpawnerBreaking = false;
    public boolean preventSpawnerBreaking_msg = false;
    public boolean preventChestBreaking = false;
    public boolean preventChestBreaking_msg = false;
    public boolean preventCarpetBreaking = false;
    public boolean preventCarpetBreaking_msg = false;
    public boolean preventSaplingBreaking = false;
    public boolean preventSaplingBreaking_msg = false;
    public boolean preventImmatureAmethystBreaking = false;
    public boolean preventImmatureAmethystBreaking_msg = false;
    public boolean preventBreakingWithWeapon = false;
    public boolean preventBreakingWithWeapon_msg = false;

    // Placing
    public boolean preventCoralPlace = false;
    public boolean preventCoralPlace_msg = false;
    public boolean preventWaterPlace = false;
    public boolean preventWaterPlace_msg = false;
    public boolean preventLavaPlacing = false;
    public boolean preventLavaPlacing_msg = false;
    public boolean preventOffhandPlacing = false;
    public boolean preventOffhandPlacing_msg = false;
    public boolean preventBerriePlanting = false;
    public boolean preventBerriePlanting_msg = false;
    public boolean preventPlaceAfterEating = false;
    public boolean preventPlaceAfterEating_msg = false;
    public int afterEatingPreventionTicks = 10;
    public boolean preventTorchPlaceAfterEating = false;
    public boolean countLanternsAsTorches = false;

    // Attacking
    public boolean preventVillagerPunch = false;
    public boolean preventVillagerPunch_msg = false;
    public boolean noZombifiedPiglinPunch = false;
    public boolean noZombifiedPiglinPunch_msg = false;
    public boolean preventEndCrystalHitting = false;
    public boolean preventEndCrystalHitting_msg = false;
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
    public boolean fullNeutralMobAttackingPrevention = false;
    public boolean neutralMobAttackingPiglinException = false;
    public boolean preventDolphinAttacking = false;
    public boolean preventDolphinAttacking_msg = false;

    // Other
    public boolean lowDurabilityProtection = false;
    public boolean lowDurabilityProtection_msg = false;
    public int lowDurabilityProtectionRange = 5;
    public boolean preventToolDropping = false;
    public boolean preventToolDropping_msg = false;
    public boolean preventRenamedItemDropping = false;
    public boolean preventRenamedItemDropping_msg = false;
    public boolean preventSwimming = false;
    public boolean preventSwimming_msg = false;
    //public boolean preventEnchantedItemBurning = false;
    //public boolean preventEnchantedItemBurning_msg = false;
    public boolean hideShield = false;
    public boolean hideTotem = false;
    public boolean notifyToggledOff = true;
}
