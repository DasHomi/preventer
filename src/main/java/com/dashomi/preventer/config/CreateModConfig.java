package com.dashomi.preventer.config;

import com.dashomi.preventer.enums.*;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class  CreateModConfig {
    public static Screen createConfigScreen(Screen parent) {
        ConfigBuilder builder = ConfigBuilder.create()
                .setParentScreen(parent)
                .setTitle(Text.translatable("preventer.configTitle"));

        ConfigEntryBuilder entryBuilder = builder.entryBuilder();
        PreventerConfig config = PreventerConfig.get();

        // Interactions
        builder.getOrCreateCategory(Text.translatable("preventer.interactions"))
                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("preventer.interactions.option.preventLogStripping"),
                                config.preventLogStripping)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("preventer.interactions.tooltip.preventLogStripping"))
                        .setSaveConsumer(value -> config.preventLogStripping = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("preventer.interactions.option.preventPathCreation"),
                                config.preventPathCreation)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("preventer.interactions.tooltip.preventPathCreation"))
                        .setSaveConsumer(value -> config.preventPathCreation = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("preventer.interactions.option.preventFarmlandCreation"),
                                config.preventFarmlandCreation)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("preventer.interactions.tooltip.preventFarmlandCreation"))
                        .setSaveConsumer(value -> config.preventFarmlandCreation = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("preventer.interactions.option.preventCakeEating"),
                                config.preventCakeEating)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("preventer.interactions.tooltip.preventCakeEating"))
                        .setSaveConsumer(value -> config.preventCakeEating = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("preventer.interactions.option.preventCopperOxidationScraping"),
                                config.preventCopperOxidationScraping)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("preventer.interactions.tooltip.preventCopperOxidationScraping"))
                        .setSaveConsumer(value -> config.preventCopperOxidationScraping = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("preventer.interactions.option.preventCopperDeWaxing"),
                                config.preventCopperDeWaxing)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("preventer.interactions.tooltip.preventCopperDeWaxing"))
                        .setSaveConsumer(value -> config.preventCopperDeWaxing = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("preventer.interactions.option.preventTrappedChestOpening"),
                                config.preventTrappedChestOpening)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("preventer.interactions.tooltip.preventTrappedChestOpening"))
                        .setSaveConsumer(value -> config.preventTrappedChestOpening = value)
                        .build())

                .addEntry(entryBuilder.startEnumSelector(
                                Text.translatable("preventer.interactions.option.preventRocketUse"),
                                PreventRocketUseConfig.class, config.preventRocketUse)
                        .setDefaultValue(PreventRocketUseConfig.OFF)
                        .setTooltip(Text.translatable("preventer.interactions.tooltip.preventRocketUse"))
                        .setSaveConsumer(value -> config.preventRocketUse = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("preventer.interactions.option.preventBedUse"),
                                config.preventBedUse)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("preventer.interactions.tooltip.preventBedUse"))
                        .setSaveConsumer(value -> config.preventBedUse = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("preventer.interactions.option.preventDragonEggTeleport"),
                                config.preventDragonEggTeleport)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("preventer.interactions.tooltip.preventDragonEggTeleport"))
                        .setSaveConsumer(value -> config.preventDragonEggTeleport = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("preventer.interactions.option.preventRenamedItemUsing"),
                                config.preventRenamedItemUsing)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("preventer.interactions.tooltip.preventRenamedItemUsing"))
                        .setSaveConsumer(value -> config.preventRenamedItemUsing = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("preventer.interactions.option.preventNoteBlockEditing"),
                                config.preventNoteBlockEditing)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("preventer.interactions.tooltip.preventNoteBlockEditing"))
                        .setSaveConsumer(value -> config.preventNoteBlockEditing = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("preventer.interactions.option.preventRespawnAnchorUse"),
                                config.preventRespawnAnchorUse)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("preventer.interactions.tooltip.preventRespawnAnchorUse"))
                        .setSaveConsumer(value -> config.preventRespawnAnchorUse = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("preventer.interactions.option.preventGrassBonemeal"),
                                config.preventGrassBonemeal)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("preventer.interactions.tooltip.preventGrassBonemeal"))
                        .setSaveConsumer(value -> config.preventGrassBonemeal = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("preventer.interactions.option.preventSignEditing"),
                                config.preventSignEditing)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("preventer.interactions.tooltip.preventSignEditing"))
                        .setSaveConsumer(value -> config.preventSignEditing = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("preventer.interactions.option.preventChestSignEditing"),
                                config.preventChestSignEditing)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("preventer.interactions.tooltip.preventChestSignEditing"))
                        .setSaveConsumer(value -> config.preventChestSignEditing = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("preventer.interactions.option.preventChiseledBookshelfInteracting"),
                                config.preventChiseledBookshelfInteracting)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("preventer.interactions.tooltip.preventChiseledBookshelfInteracting"))
                        .setSaveConsumer(value -> config.preventChiseledBookshelfInteracting = value)
                        .build())

                .addEntry(entryBuilder.startTextDescription(
                                Text.translatable("text.preventer.missingFeatures"))
                        .build());

        // Plants
        builder.getOrCreateCategory(Text.translatable("preventer.plants"))
                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("preventer.plants.option.preventGlowBerrieHarvesting"),
                                config.preventGlowBerrieHarvesting)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("preventer.plants.tooltip.preventGlowBerrieHarvesting"))
                        .setSaveConsumer(value -> config.preventGlowBerrieHarvesting = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("preventer.plants.option.preventSweetBerrieHarvesting"),
                                config.preventSweetBerrieHarvesting)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("preventer.plants.tooltip.preventSweetBerrieHarvesting"))
                        .setSaveConsumer(value -> config.preventSweetBerrieHarvesting = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("preventer.plants.option.preventNonMatureCropHarvesting"),
                                config.preventNonMatureCropHarvesting)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("preventer.plants.tooltip.preventNonMatureCropHarvesting"))
                        .setSaveConsumer(value -> config.preventNonMatureCropHarvesting = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("preventer.plants.option.preventStemBreaking"),
                                config.preventStemBreaking)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("preventer.plants.tooltip.preventStemBreaking"))
                        .setSaveConsumer(value -> config.preventStemBreaking = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("preventer.plants.option.preventSugarCaneBreaking"),
                                config.preventSugarCaneBreaking)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("preventer.plants.tooltip.preventSugarCaneBreaking"))
                        .setSaveConsumer(value -> config.preventSugarCaneBreaking = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("preventer.plants.option.preventFarmlandJumping"),
                                config.preventFarmlandJumping)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("preventer.plants.tooltip.preventFarmlandJumping"))
                        .setSaveConsumer(value -> config.preventFarmlandJumping = value)
                        .build())

                .addEntry(entryBuilder.startTextDescription(
                                Text.translatable("text.preventer.missingFeatures"))
                        .build());

        // Breaking
        builder.getOrCreateCategory(Text.translatable("preventer.breaking"))
                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("preventer.breaking.option.preventBuddingAmethystBreaking"),
                                config.preventBuddingAmethystBreaking)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("preventer.breaking.tooltip.preventBuddingAmethystBreaking"))
                        .setSaveConsumer(value -> config.preventBuddingAmethystBreaking = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("preventer.breaking.option.preventItemFrameBreaking"),
                                config.preventItemFrameBreaking)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("preventer.breaking.tooltip.preventItemFrameBreaking"))
                        .setSaveConsumer(value -> config.preventItemFrameBreaking = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("preventer.breaking.option.preventPaintingBreaking"),
                                config.preventPaintingBreaking)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("preventer.breaking.tooltip.preventPaintingBreaking"))
                        .setSaveConsumer(value -> config.preventPaintingBreaking = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("preventer.breaking.option.preventGlassBreaking"),
                                config.preventGlassBreaking)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("preventer.breaking.tooltip.preventGlassBreaking"))
                        .setSaveConsumer(value -> config.preventGlassBreaking = value)
                        .build())

                .addEntry(entryBuilder.startEnumSelector(
                                Text.translatable("preventer.breaking.option.preventSuspiciousBlockBreaking"),
                                PreventSuspiciousBlockBreakingConfig.class, config.preventSuspiciousBlockBreaking)
                        .setDefaultValue(PreventSuspiciousBlockBreakingConfig.OFF)
                        .setTooltip(Text.translatable("preventer.breaking.tooltip.preventSuspiciousBlockBreaking"))
                        .setSaveConsumer(value -> config.preventSuspiciousBlockBreaking = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("preventer.breaking.option.preventEnderChestBreaking"),
                                config.preventEnderChestBreaking)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("preventer.breaking.tooltip.preventEnderChestBreaking"))
                        .setSaveConsumer(value -> config.preventEnderChestBreaking = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("preventer.breaking.option.preventSpawnerBreaking"),
                                config.preventSpawnerBreaking)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("preventer.breaking.tooltip.preventSpawnerBreaking"))
                        .setSaveConsumer(value -> config.preventSpawnerBreaking = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("preventer.breaking.option.preventChestBreaking"),
                                config.preventChestBreaking)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("preventer.breaking.tooltip.preventChestBreaking"))
                        .setSaveConsumer(value -> config.preventChestBreaking = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("preventer.breaking.option.preventCarpetBreaking"),
                                config.preventCarpetBreaking)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("preventer.breaking.tooltip.preventCarpetBreaking"))
                        .setSaveConsumer(value -> config.preventCarpetBreaking = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("preventer.breaking.option.preventSaplingBreaking"),
                                config.preventSaplingBreaking)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("preventer.breaking.tooltip.preventSaplingBreaking"))
                        .setSaveConsumer(value -> config.preventSaplingBreaking = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("preventer.breaking.option.preventImmatureAmethystBreaking"),
                                config.preventImmatureAmethystBreaking)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("preventer.breaking.tooltip.preventImmatureAmethystBreaking"))
                        .setSaveConsumer(value -> config.preventImmatureAmethystBreaking = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("preventer.breaking.option.preventBreakingWithWeapon"),
                                config.preventBreakingWithWeapon)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("preventer.breaking.tooltip.preventBreakingWithWeapon"))
                        .setSaveConsumer(value -> config.preventBreakingWithWeapon = value)
                        .build())

                .addEntry(entryBuilder.startTextDescription(
                                Text.translatable("text.preventer.missingFeatures"))
                        .build());

        // Placing
        builder.getOrCreateCategory(Text.translatable("preventer.placing"))
                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("preventer.placing.option.preventCoralPlacing"),
                                config.preventCoralPlacing)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("preventer.placing.tooltip.preventCoralPlacing"))
                        .setSaveConsumer(value -> config.preventCoralPlacing = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("preventer.placing.option.preventWaterPlacing"),
                                config.preventWaterPlacing)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("preventer.placing.tooltip.preventWaterPlacing"))
                        .setSaveConsumer(value -> config.preventWaterPlacing = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("preventer.placing.option.preventLavaPlacing"),
                                config.preventLavaPlacing)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("preventer.placing.tooltip.preventLavaPlacing"))
                        .setSaveConsumer(value -> config.preventLavaPlacing = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("preventer.placing.option.preventOffhandPlacing"),
                                config.preventOffhandPlacing)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("preventer.placing.tooltip.preventOffhandPlacing"))
                        .setSaveConsumer(value -> config.preventOffhandPlacing = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("preventer.placing.option.preventBerriePlanting"),
                                config.preventBerriePlanting)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("preventer.placing.tooltip.preventBerriePlanting"))
                        .setSaveConsumer(value -> config.preventBerriePlanting = value)
                        .build())

                .addEntry(entryBuilder.startEnumSelector(
                                Text.translatable("preventer.placing.option.preventPlacingAfterEating"),
                                PreventPlacingAfterEatingConfig.class, config.preventPlacingAfterEating)
                        .setDefaultValue(PreventPlacingAfterEatingConfig.OFF)
                        .setTooltip(Text.translatable("preventer.placing.tooltip.preventPlacingAfterEating"))
                        .setSaveConsumer(value -> config.preventPlacingAfterEating = value)
                        .build())

                .addEntry(entryBuilder.startTextDescription(
                                Text.translatable("text.preventer.missingFeatures"))
                        .build());

        // Attacking
        builder.getOrCreateCategory(Text.translatable("preventer.attacking"))
                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("preventer.attacking.option.preventVillagerPunching"),
                                config.preventVillagerPunching)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("preventer.attacking.tooltip.preventVillagerPunching"))
                        .setSaveConsumer(value -> config.preventVillagerPunching = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("preventer.attacking.option.preventZombifiedPiglinPunching"),
                                config.preventZombifiedPiglinPunching)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("preventer.attacking.tooltip.preventZombifiedPiglinPunching"))
                        .setSaveConsumer(value -> config.preventZombifiedPiglinPunching = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("preventer.attacking.option.preventEndCrystalHitting"),
                                config.preventEndCrystalHitting)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("preventer.attacking.tooltip.preventEndCrystalHitting"))
                        .setSaveConsumer(value -> config.preventEndCrystalHitting = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("preventer.attacking.option.preventGolemAttacking"),
                                config.preventGolemAttacking)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("preventer.attacking.tooltip.preventGolemAttacking"))
                        .setSaveConsumer(value -> config.preventGolemAttacking = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("preventer.attacking.option.preventNamedMobAttacking"),
                                config.preventNamedMobAttacking)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("preventer.attacking.tooltip.preventNamedMobAttacking"))
                        .setSaveConsumer(value -> config.preventNamedMobAttacking = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("preventer.attacking.option.preventTamedMobAttacking"),
                                config.preventTamedMobAttacking)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("preventer.attacking.tooltip.preventTamedMobAttacking"))
                        .setSaveConsumer(value -> config.preventTamedMobAttacking = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("preventer.attacking.option.preventRareMobAttacking"),
                                config.preventRareMobAttacking)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("preventer.attacking.tooltip.preventRareMobAttacking"))
                        .setSaveConsumer(value -> config.preventRareMobAttacking = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("preventer.attacking.option.preventHorseAttacking"),
                                config.preventHorseAttacking)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("preventer.attacking.tooltip.preventHorseAttacking"))
                        .setSaveConsumer(value -> config.preventHorseAttacking = value)
                        .build())

                .addEntry(entryBuilder.startEnumSelector(
                                Text.translatable("preventer.attacking.option.preventNeutralMobAttacking"),
                                PreventNeutralMobAttackingConfig.class, config.preventNeutralMobAttacking)
                        .setDefaultValue(PreventNeutralMobAttackingConfig.OFF)
                        .setTooltip(Text.translatable("preventer.attacking.tooltip.preventNeutralMobAttacking"))
                        .setSaveConsumer(value -> config.preventNeutralMobAttacking = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("preventer.attacking.option.preventDolphinAttacking"),
                                config.preventDolphinAttacking)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("preventer.attacking.tooltip.preventDolphinAttacking"))
                        .setSaveConsumer(value -> config.preventDolphinAttacking = value)
                        .build())

                .addEntry(entryBuilder.startTextDescription(
                                Text.translatable("text.preventer.missingFeatures"))
                        .build());

        // Other
        builder.getOrCreateCategory(Text.translatable("preventer.miscellaneous"))
                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("preventer.miscellaneous.option.lowDurabilityProtection"),
                                config.lowDurabilityProtection)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("preventer.miscellaneous.tooltip.lowDurabilityProtection"))
                        .setSaveConsumer(value -> config.lowDurabilityProtection = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("preventer.miscellaneous.option.preventToolDropping"),
                                config.preventToolDropping)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("preventer.miscellaneous.tooltip.preventToolDropping"))
                        .setSaveConsumer(value -> config.preventToolDropping = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("preventer.miscellaneous.option.preventRenamedItemDropping"),
                                config.preventRenamedItemDropping)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("preventer.miscellaneous.tooltip.preventRenamedItemDropping"))
                        .setSaveConsumer(value -> config.preventRenamedItemDropping = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("preventer.miscellaneous.option.preventSwimming"),
                                config.preventSwimming)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("preventer.miscellaneous.tooltip.preventSwimming"))
                        .setSaveConsumer(value -> config.preventSwimming = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("preventer.miscellaneous.option.hideShield"),
                                config.hideShield)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("preventer.miscellaneous.tooltip.hideShield"))
                        .setSaveConsumer(value -> config.hideShield = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("preventer.miscellaneous.option.hideTotem"),
                                config.hideTotem)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("preventer.miscellaneous.tooltip.hideTotem"))
                        .setSaveConsumer(value -> config.hideTotem = value)
                        .build())

                .addEntry(entryBuilder.startTextDescription(
                                Text.translatable("text.preventer.missingFeatures"))
                        .build());

        // General Settings
        builder.getOrCreateCategory(Text.translatable("preventer.general"))
                .addEntry(entryBuilder.startEnumSelector(
                                Text.translatable("preventer.general.option.actionPreventedInfoType"),
                                ActionPreventedInfo.class, config.actionPreventedInfoType)
                        .setDefaultValue(ActionPreventedInfo.DEFAULT)
                        .setTooltip(Text.translatable("preventer.general.tooltip.actionPreventedInfoType"))
                        .setSaveConsumer(value -> config.actionPreventedInfoType = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("preventer.general.option.showLowDurabilityProtectionWarning"),
                                config.showLowDurabilityProtectionWarning)
                        .setDefaultValue(true)
                        .setTooltip(Text.translatable("preventer.general.tooltip.showLowDurabilityProtectionWarning"))
                        .setSaveConsumer(value -> config.showLowDurabilityProtectionWarning = value)
                        .build());


        return builder
                .setSavingRunnable(PreventerConfig::save)
                .build();
    }
}
