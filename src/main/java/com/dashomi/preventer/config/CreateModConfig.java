package com.dashomi.preventer.config;

import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class  CreateModConfig {
    public static Screen createConfigScreen(Screen parent) {
        ConfigBuilder builder = ConfigBuilder.create()
                .setParentScreen(parent)
                .setTitle(Text.translatable("text.preventer.configTitle"));

        ConfigEntryBuilder entryBuilder = builder.entryBuilder();
        PreventerConfig config = PreventerConfig.get();

        builder.getOrCreateCategory(Text.translatable("category.preventer.default"))
                // Interaction
                .addEntry(entryBuilder.startTextDescription(
                                Text.translatable("text.preventer.interactionCategory"))
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.noStrip"),
                                config.noStrip)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("tooltip.preventer.noStrip"))
                        .setSaveConsumer(value -> config.noStrip = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.noPath"),
                                config.noPath)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("tooltip.preventer.noPath"))
                        .setSaveConsumer(value -> config.noPath = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.noFarmland"),
                                config.noFarmland)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("tooltip.preventer.noFarmland"))
                        .setSaveConsumer(value -> config.noFarmland = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.noCake"),
                                config.noCake)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("tooltip.preventer.noCake"))
                        .setSaveConsumer(value -> config.noCake = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.noScraping"),
                                config.noScraping)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("tooltip.preventer.noScraping"))
                        .setSaveConsumer(value -> config.noScraping = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.noDeWax"),
                                config.noDeWax)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("tooltip.preventer.noDeWax"))
                        .setSaveConsumer(value -> config.noDeWax = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.noTrappedChestOpening"),
                                config.noTrappedChestOpening)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("tooltip.preventer.noTrappedChestOpening"))
                        .setSaveConsumer(value -> config.noTrappedChestOpening = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.preventRocketUse"),
                                config.preventRocketUse)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("tooltip.preventer.preventRocketUse"))
                        .setSaveConsumer(value -> config.preventRocketUse = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.preventBedUse"),
                                config.preventBedUse)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("tooltip.preventer.preventBedUse"))
                        .setSaveConsumer(value -> config.preventBedUse = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.preventDragonEggTeleport"),
                                config.preventDragonEggTeleport)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("tooltip.preventer.preventDragonEggTeleport"))
                        .setSaveConsumer(value -> config.preventDragonEggTeleport = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.preventRenamedItemUsing"),
                                config.preventRenamedItemUsing)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("tooltip.preventer.preventRenamedItemUsing"))
                        .setSaveConsumer(value -> config.preventRenamedItemUsing = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.preventNoteBlockEditing"),
                                config.preventNoteBlockEditing)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("tooltip.preventer.preventNoteBlockEditing"))
                        .setSaveConsumer(value -> config.preventNoteBlockEditing = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.preventRespawnAnchorUse"),
                                config.preventRespawnAnchorUse)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("tooltip.preventer.preventRespawnAnchorUse"))
                        .setSaveConsumer(value -> config.preventRespawnAnchorUse = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.preventGrassBonemeal"),
                                config.preventGrassBonemeal)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("tooltip.preventer.preventGrassBonemeal"))
                        .setSaveConsumer(value -> config.preventGrassBonemeal = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.preventSignEditing"),
                                config.preventSignEditing)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("tooltip.preventer.preventSignEditing"))
                        .setSaveConsumer(value -> config.preventSignEditing = value)
                        .build())

                // Plants
                .addEntry(entryBuilder.startTextDescription(
                                Text.translatable("text.preventer.plantsCategory"))
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.noGlowBerrieHarvest"),
                                config.noGlowBerrieHarvest)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("tooltip.preventer.noGlowBerrieHarvest"))
                        .setSaveConsumer(value -> config.noGlowBerrieHarvest = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.noSweetBerrieHarvest"),
                                config.noSweetBerrieHarvest)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("tooltip.preventer.noSweetBerrieHarvest"))
                        .setSaveConsumer(value -> config.noSweetBerrieHarvest = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.onlyMatureCropHarvest"),
                                config.onlyMatureCropHarvest)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("tooltip.preventer.onlyMatureCropHarvest"))
                        .setSaveConsumer(value -> config.onlyMatureCropHarvest = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.preventStemBreaking"),
                                config.preventStemBreaking)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("tooltip.preventer.preventStemBreaking"))
                        .setSaveConsumer(value -> config.preventStemBreaking = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.preventSugarCaneBreaking"),
                                config.preventSugarCaneBreaking)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("tooltip.preventer.preventSugarCaneBreaking"))
                        .setSaveConsumer(value -> config.preventSugarCaneBreaking = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.preventFarmlandJumping"),
                                config.preventFarmlandJumping)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("tooltip.preventer.preventFarmlandJumping"))
                        .setSaveConsumer(value -> config.preventFarmlandJumping = value)
                        .build())

                // Breaking
                .addEntry(entryBuilder.startTextDescription(
                                Text.translatable("text.preventer.breakingCategory"))
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.preventBuddingAmethystBreaking"),
                                config.preventBuddingAmethystBreaking)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("tooltip.preventer.preventBuddingAmethystBreaking"))
                        .setSaveConsumer(value -> config.preventBuddingAmethystBreaking = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.preventItemFrameBreaking"),
                                config.preventItemFrameBreaking)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("tooltip.preventer.preventItemFrameBreaking"))
                        .setSaveConsumer(value -> config.preventItemFrameBreaking = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.preventPaintingBreaking"),
                                config.preventPaintingBreaking)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("tooltip.preventer.preventPaintingBreaking"))
                        .setSaveConsumer(value -> config.preventPaintingBreaking = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.preventGlassBreaking"),
                                config.preventGlassBreaking)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("tooltip.preventer.preventGlassBreaking"))
                        .setSaveConsumer(value -> config.preventGlassBreaking = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.preventSuspiciousBlockBreaking"),
                                config.preventSuspiciousBlockBreaking)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("tooltip.preventer.preventSuspiciousBlockBreaking"))
                        .setSaveConsumer(value -> config.preventSuspiciousBlockBreaking = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.preventEnderChestBreaking"),
                                config.preventEnderChestBreaking)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("tooltip.preventer.preventEnderChestBreaking"))
                        .setSaveConsumer(value -> config.preventEnderChestBreaking = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.preventSpawnerBreaking"),
                                config.preventSpawnerBreaking)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("tooltip.preventer.preventSpawnerBreaking"))
                        .setSaveConsumer(value -> config.preventSpawnerBreaking = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.preventChestBreaking"),
                                config.preventChestBreaking)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("tooltip.preventer.preventChestBreaking"))
                        .setSaveConsumer(value -> config.preventChestBreaking = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.preventCarpetBreaking"),
                                config.preventCarpetBreaking)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("tooltip.preventer.preventCarpetBreaking"))
                        .setSaveConsumer(value -> config.preventCarpetBreaking = value)
                        .build())

                // Placing
                .addEntry(entryBuilder.startTextDescription(
                                Text.translatable("text.preventer.placingCategory"))
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.preventCoralPlace"),
                                config.preventCoralPlace)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("tooltip.preventer.preventCoralPlace"))
                        .setSaveConsumer(value -> config.preventCoralPlace = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.preventWaterPlace"),
                                config.preventWaterPlace)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("tooltip.preventer.preventWaterPlace"))
                        .setSaveConsumer(value -> config.preventWaterPlace = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.preventLavaPlacing"),
                                config.preventLavaPlacing)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("tooltip.preventer.preventLavaPlacing"))
                        .setSaveConsumer(value -> config.preventLavaPlacing = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.preventOffhandPlacing"),
                                config.preventOffhandPlacing)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("tooltip.preventer.preventOffhandPlacing"))
                        .setSaveConsumer(value -> config.preventOffhandPlacing = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.preventBerriePlanting"),
                                config.preventBerriePlanting)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("tooltip.preventer.preventBerriePlanting"))
                        .setSaveConsumer(value -> config.preventBerriePlanting = value)
                        .build())

                // Attacking
                .addEntry(entryBuilder.startTextDescription(
                                Text.translatable("text.preventer.AttackingCategory"))
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.preventVillagerPunch"),
                                config.preventVillagerPunch)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("tooltip.preventer.preventVillagerPunch"))
                        .setSaveConsumer(value -> config.preventVillagerPunch = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.noZombifiedPiglinPunch"),
                                config.noZombifiedPiglinPunch)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("tooltip.preventer.noZombifiedPiglinPunch"))
                        .setSaveConsumer(value -> config.noZombifiedPiglinPunch = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.preventEndCrystalHitting"),
                                config.preventEndCrystalHitting)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("tooltip.preventer.preventEndCrystalHitting"))
                        .setSaveConsumer(value -> config.preventEndCrystalHitting = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.preventGolemAttacking"),
                                config.preventGolemAttacking)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("tooltip.preventer.preventGolemAttacking"))
                        .setSaveConsumer(value -> config.preventGolemAttacking = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.preventNamedMobAttacking"),
                                config.preventNamedMobAttacking)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("tooltip.preventer.preventNamedMobAttacking"))
                        .setSaveConsumer(value -> config.preventNamedMobAttacking = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.preventTamedMobAttacking"),
                                config.preventTamedMobAttacking)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("tooltip.preventer.preventTamedMobAttacking"))
                        .setSaveConsumer(value -> config.preventTamedMobAttacking = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.preventRareMobAttacking"),
                                config.preventRareMobAttacking)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("tooltip.preventer.preventRareMobAttacking"))
                        .setSaveConsumer(value -> config.preventRareMobAttacking = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.preventHorseAttacking"),
                                config.preventHorseAttacking)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("tooltip.preventer.preventHorseAttacking"))
                        .setSaveConsumer(value -> config.preventHorseAttacking = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.preventNeutralMobAttacking"),
                                config.preventNeutralMobAttacking)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("tooltip.preventer.preventNeutralMobAttacking"))
                        .setSaveConsumer(value -> config.preventNeutralMobAttacking = value)
                        .build())

                // Other
                .addEntry(entryBuilder.startTextDescription(
                                Text.translatable("text.preventer.otherCategory"))
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.lowDurabilityProtection"),
                                config.lowDurabilityProtection)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("tooltip.preventer.lowDurabilityProtection"))
                        .setSaveConsumer(value -> config.lowDurabilityProtection = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.preventToolDropping"),
                                config.preventToolDropping)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("tooltip.preventer.preventToolDropping"))
                        .setSaveConsumer(value -> config.preventToolDropping = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.preventRenamedItemDropping"),
                                config.preventRenamedItemDropping)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("tooltip.preventer.preventRenamedItemDropping"))
                        .setSaveConsumer(value -> config.preventRenamedItemDropping = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.preventEnchantedItemBurning"),
                                config.preventEnchantedItemBurning)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("tooltip.preventer.preventEnchantedItemBurning"))
                        .setSaveConsumer(value -> config.preventEnchantedItemBurning = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.hideShield"),
                                config.hideShield)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("tooltip.preventer.hideShield"))
                        .setSaveConsumer(value -> config.hideShield = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.hideTotem"),
                                config.hideTotem)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("tooltip.preventer.hideTotem"))
                        .setSaveConsumer(value -> config.hideTotem = value)
                        .build())

                .addEntry(entryBuilder.startTextDescription(
                                Text.translatable("text.preventer.missingFeatures"))
                        .build());


        builder.getOrCreateCategory(Text.translatable("category.preventer.moduleConfig"))
                .addEntry(entryBuilder.startIntSlider(
                                Text.translatable("config.preventer.lowDurabilityProtectionRange"),
                                config.lowDurabilityProtectionRange, 1, 30)
                        .setDefaultValue(5)
                        .setTooltip(Text.translatable("tooltip.preventer.lowDurabilityProtectionRange"))
                        .setSaveConsumer(value -> config.lowDurabilityProtectionRange = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("config.preventer.rocketInOffhand"),
                                config.rocketInOffhand)
                        .setDefaultValue(true)
                        .setSaveConsumer(value -> config.rocketInOffhand = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("config.preventer.rocketInMainHand"),
                                config.rocketInMainHand)
                        .setDefaultValue(true)
                        .setSaveConsumer(value -> config.rocketInMainHand = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("config.preventer.enhancedSuspiciousBlockBreakingPrevention"),
                                config.enhancedSuspiciousBlockBreakingPrevention)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("tooltip.preventer.enhancedSuspiciousBlockBreakingPrevention"))
                        .setSaveConsumer(value -> config.enhancedSuspiciousBlockBreakingPrevention = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("config.preventer.fullNeutralMobAttackingPrevention"),
                                config.fullNeutralMobAttackingPrevention)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("tooltip.preventer.fullNeutralMobAttackingPrevention"))
                        .setSaveConsumer(value -> config.fullNeutralMobAttackingPrevention = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("config.preventer.preventChestSignEditing"),
                                config.preventChestSignEditing)
                        .setDefaultValue(false)
                        .setTooltip(Text.translatable("tooltip.preventer.preventChestSignEditing"))
                        .setSaveConsumer(value -> config.preventChestSignEditing = value)
                        .build());


        builder.getOrCreateCategory(Text.translatable("category.preventer.moduleUsageInfo"))
                .addEntry(entryBuilder.startTextDescription(
                                Text.translatable("text.preventer.moduleUseInfo"))
                        .build())

                // Interactions
                .addEntry(entryBuilder.startTextDescription(
                                Text.translatable("text.preventer.interactionCategory"))
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.noStrip"),
                                config.noStrip_msg)
                        .setDefaultValue(false)
                        .setSaveConsumer(value -> config.noStrip_msg = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.noPath"),
                                config.noPath_msg)
                        .setDefaultValue(false)
                        .setSaveConsumer(value -> config.noPath_msg = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.noFarmland"),
                                config.noFarmland_msg)
                        .setDefaultValue(false)
                        .setSaveConsumer(value -> config.noFarmland_msg = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.noCake"),
                                config.noCake_msg)
                        .setDefaultValue(false)
                        .setSaveConsumer(value -> config.noCake_msg = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.noScraping"),
                                config.noScraping_msg)
                        .setDefaultValue(false)
                        .setSaveConsumer(value -> config.noScraping_msg = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.noDeWax"),
                                config.noDeWax_msg)
                        .setDefaultValue(false)
                        .setSaveConsumer(value -> config.noDeWax_msg = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.noTrappedChestOpening"),
                                config.noTrappedChestOpening_msg)
                        .setDefaultValue(false)
                        .setSaveConsumer(value -> config.noTrappedChestOpening_msg = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.preventRocketUse"),
                                config.preventRocketUse_msg)
                        .setDefaultValue(false)
                        .setSaveConsumer(value -> config.preventRocketUse_msg = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.preventBedUse"),
                                config.preventBedUse_msg)
                        .setDefaultValue(false)
                        .setSaveConsumer(value -> config.preventBedUse_msg = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.preventDragonEggTeleport"),
                                config.preventDragonEggTeleport_msg)
                        .setDefaultValue(false)
                        .setSaveConsumer(value -> config.preventDragonEggTeleport_msg = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.preventRenamedItemUsing"),
                                config.preventRenamedItemUsing_msg)
                        .setDefaultValue(false)
                        .setSaveConsumer(value -> config.preventRenamedItemUsing_msg = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.preventNoteBlockEditing"),
                                config.preventNoteBlockEditing_msg)
                        .setDefaultValue(false)
                        .setSaveConsumer(value -> config.preventNoteBlockEditing_msg = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.preventRespawnAnchorUse"),
                                config.preventRespawnAnchorUse_msg)
                        .setDefaultValue(false)
                        .setSaveConsumer(value -> config.preventRespawnAnchorUse_msg = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.preventGrassBonemeal"),
                                config.preventGrassBonemeal_msg)
                        .setDefaultValue(false)
                        .setSaveConsumer(value -> config.preventGrassBonemeal_msg = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.preventSignEditing"),
                                config.preventSignEditing_msg)
                        .setDefaultValue(false)
                        .setSaveConsumer(value -> config.preventSignEditing_msg = value)
                        .build())

                // Plants
                .addEntry(entryBuilder.startTextDescription(
                                Text.translatable("text.preventer.plantsCategory"))
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.noGlowBerrieHarvest"),
                                config.noGlowBerrieHarvest_msg)
                        .setDefaultValue(false)
                        .setSaveConsumer(value -> config.noGlowBerrieHarvest_msg = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.noSweetBerrieHarvest"),
                                config.noSweetBerrieHarvest_msg)
                        .setDefaultValue(false)
                        .setSaveConsumer(value -> config.noSweetBerrieHarvest_msg = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.onlyMatureCropHarvest"),
                                config.onlyMatureCropHarvest_msg)
                        .setDefaultValue(false)
                        .setSaveConsumer(value -> config.onlyMatureCropHarvest_msg = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.preventStemBreaking"),
                                config.preventStemBreaking_msg)
                        .setDefaultValue(false)
                        .setSaveConsumer(value -> config.preventStemBreaking_msg = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.preventSugarCaneBreaking"),
                                config.preventSugarCaneBreaking_msg)
                        .setDefaultValue(false)
                        .setSaveConsumer(value -> config.preventSugarCaneBreaking_msg = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.preventFarmlandJumping"),
                                config.preventFarmlandJumping_msg)
                        .setDefaultValue(false)
                        .setSaveConsumer(value -> config.preventFarmlandJumping_msg = value)
                        .build())

                // Breaking
                .addEntry(entryBuilder.startTextDescription(
                                Text.translatable("text.preventer.breakingCategory"))
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.preventBuddingAmethystBreaking"),
                                config.preventBuddingAmethystBreaking_msg)
                        .setDefaultValue(false)
                        .setSaveConsumer(value -> config.preventBuddingAmethystBreaking_msg = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.preventItemFrameBreaking"),
                                config.preventItemFrameBreaking_msg)
                        .setDefaultValue(false)
                        .setSaveConsumer(value -> config.preventItemFrameBreaking_msg = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.preventPaintingBreaking"),
                                config.preventPaintingBreaking_msg)
                        .setDefaultValue(false)
                        .setSaveConsumer(value -> config.preventPaintingBreaking_msg = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.preventGlassBreaking"),
                                config.preventGlassBreaking_msg)
                        .setDefaultValue(false)
                        .setSaveConsumer(value -> config.preventGlassBreaking_msg = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.preventSuspiciousBlockBreaking"),
                                config.preventSuspiciousBlockBreaking_msg)
                        .setDefaultValue(false)
                        .setSaveConsumer(value -> config.preventSuspiciousBlockBreaking_msg = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.preventEnderChestBreaking"),
                                config.preventEnderChestBreaking_msg)
                        .setDefaultValue(false)
                        .setSaveConsumer(value -> config.preventEnderChestBreaking_msg = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.preventSpawnerBreaking"),
                                config.preventSpawnerBreaking_msg)
                        .setDefaultValue(false)
                        .setSaveConsumer(value -> config.preventSpawnerBreaking_msg = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.preventChestBreaking"),
                                config.preventChestBreaking_msg)
                        .setDefaultValue(false)
                        .setSaveConsumer(value -> config.preventChestBreaking_msg = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.preventCarpetBreaking"),
                                config.preventCarpetBreaking_msg)
                        .setDefaultValue(false)
                        .setSaveConsumer(value -> config.preventCarpetBreaking_msg = value)
                        .build())

                // Placing
                .addEntry(entryBuilder.startTextDescription(
                                Text.translatable("text.preventer.placingCategory"))
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.preventCoralPlace"),
                                config.preventCoralPlace_msg)
                        .setDefaultValue(false)
                        .setSaveConsumer(value -> config.preventCoralPlace_msg = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.preventWaterPlace"),
                                config.preventWaterPlace_msg)
                        .setDefaultValue(false)
                        .setSaveConsumer(value -> config.preventWaterPlace_msg = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.preventLavaPlacing"),
                                config.preventLavaPlacing_msg)
                        .setDefaultValue(false)
                        .setSaveConsumer(value -> config.preventLavaPlacing_msg = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.preventOffhandPlacing"),
                                config.preventOffhandPlacing_msg)
                        .setDefaultValue(false)
                        .setSaveConsumer(value -> config.preventOffhandPlacing_msg = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.preventBerriePlanting"),
                                config.preventBerriePlanting_msg)
                        .setDefaultValue(false)
                        .setSaveConsumer(value -> config.preventBerriePlanting_msg = value)
                        .build())

                // Attacking
                .addEntry(entryBuilder.startTextDescription(
                                Text.translatable("text.preventer.AttackingCategory"))
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.preventVillagerPunch"),
                                config.preventVillagerPunch_msg)
                        .setDefaultValue(false)
                        .setSaveConsumer(value -> config.preventVillagerPunch_msg = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.noZombifiedPiglinPunch"),
                                config.noZombifiedPiglinPunch_msg)
                        .setDefaultValue(false)
                        .setSaveConsumer(value -> config.noZombifiedPiglinPunch_msg = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.preventEndCrystalHitting"),
                                config.preventEndCrystalHitting_msg)
                        .setDefaultValue(false)
                        .setSaveConsumer(value -> config.preventEndCrystalHitting_msg = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.preventGolemAttacking"),
                                config.preventGolemAttacking_msg)
                        .setDefaultValue(false)
                        .setSaveConsumer(value -> config.preventGolemAttacking_msg = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.preventNamedMobAttacking"),
                                config.preventNamedMobAttacking_msg)
                        .setDefaultValue(false)
                        .setSaveConsumer(value -> config.preventNamedMobAttacking_msg = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.preventTamedMobAttacking"),
                                config.preventTamedMobAttacking_msg)
                        .setDefaultValue(false)
                        .setSaveConsumer(value -> config.preventTamedMobAttacking_msg = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.preventRareMobAttacking"),
                                config.preventRareMobAttacking_msg)
                        .setDefaultValue(false)
                        .setSaveConsumer(value -> config.preventRareMobAttacking_msg = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.preventHorseAttacking"),
                                config.preventHorseAttacking_msg)
                        .setDefaultValue(false)
                        .setSaveConsumer(value -> config.preventHorseAttacking_msg = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.preventNeutralMobAttacking"),
                                config.preventNeutralMobAttacking_msg)
                        .setDefaultValue(false)
                        .setSaveConsumer(value -> config.preventNeutralMobAttacking_msg = value)
                        .build())

                // Other
                .addEntry(entryBuilder.startTextDescription(
                                Text.translatable("text.preventer.otherCategory"))
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.lowDurabilityProtection"),
                                config.lowDurabilityProtection_msg)
                        .setDefaultValue(false)
                        .setSaveConsumer(value -> config.lowDurabilityProtection_msg = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.preventToolDropping"),
                                config.preventToolDropping_msg)
                        .setDefaultValue(false)
                        .setSaveConsumer(value -> config.preventToolDropping_msg = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.preventRenamedItemDropping"),
                                config.preventRenamedItemDropping_msg)
                        .setDefaultValue(false)
                        .setSaveConsumer(value -> config.preventRenamedItemDropping_msg = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                Text.translatable("option.preventer.preventEnchantedItemBurning"),
                                config.preventEnchantedItemBurning_msg)
                        .setDefaultValue(false)
                        .setSaveConsumer(value -> config.preventEnchantedItemBurning_msg = value)
                        .build());

        return builder
                .setSavingRunnable(PreventerConfig::save)
                .build();
    }
}
