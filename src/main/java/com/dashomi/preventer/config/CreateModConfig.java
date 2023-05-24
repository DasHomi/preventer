package com.dashomi.preventer.config;

import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.TranslatableText;

public class  CreateModConfig {
    public static Screen createConfigScreen(Screen parent) {
        ConfigBuilder builder = ConfigBuilder.create()
                .setParentScreen(parent)
                .setTitle(new TranslatableText("text.preventer.configTitle"));

        ConfigEntryBuilder entryBuilder = builder.entryBuilder();
        PreventerConfig config = PreventerConfig.get();

        builder.getOrCreateCategory(new TranslatableText("category.preventer.default"))
                .addEntry(entryBuilder.startBooleanToggle(
                                new TranslatableText("option.preventer.noStrip"),
                                config.noStrip)
                        .setDefaultValue(false)
                        .setTooltip(new TranslatableText("tooltip.preventer.noStrip"))
                        .setSaveConsumer(value -> config.noStrip = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                new TranslatableText("option.preventer.noPath"),
                                config.noPath)
                        .setDefaultValue(false)
                        .setTooltip(new TranslatableText("tooltip.preventer.noPath"))
                        .setSaveConsumer(value -> config.noPath = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                new TranslatableText("option.preventer.noFarmland"),
                                config.noFarmland)
                        .setDefaultValue(false)
                        .setTooltip(new TranslatableText("tooltip.preventer.noFarmland"))
                        .setSaveConsumer(value -> config.noFarmland = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                new TranslatableText("option.preventer.noSweetBerrieHarvest"),
                                config.noSweetBerrieHarvest)
                        .setDefaultValue(false)
                        .setTooltip(new TranslatableText("tooltip.preventer.noSweetBerrieHarvest"))
                        .setSaveConsumer(value -> config.noSweetBerrieHarvest = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                new TranslatableText("option.preventer.noGlowBerrieHarvest"),
                                config.noGlowBerrieHarvest)
                        .setDefaultValue(false)
                        .setTooltip(new TranslatableText("tooltip.preventer.noGlowBerrieHarvest"))
                        .setSaveConsumer(value -> config.noGlowBerrieHarvest = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                new TranslatableText("option.preventer.onlyMatureCropHarvest"),
                                config.onlyMatureCropHarvest)
                        .setDefaultValue(false)
                        .setTooltip(new TranslatableText("tooltip.preventer.onlyMatureCropHarvest"))
                        .setSaveConsumer(value -> config.onlyMatureCropHarvest = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                new TranslatableText("option.preventer.noCake"),
                                config.noCake)
                        .setDefaultValue(false)
                        .setTooltip(new TranslatableText("tooltip.preventer.noCake"))
                        .setSaveConsumer(value -> config.noCake = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                new TranslatableText("option.preventer.noScraping"),
                                config.noScraping)
                        .setDefaultValue(false)
                        .setTooltip(new TranslatableText("tooltip.preventer.noScraping"))
                        .setSaveConsumer(value -> config.noScraping = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                new TranslatableText("option.preventer.noDeWax"),
                                config.noDeWax)
                        .setDefaultValue(false)
                        .setTooltip(new TranslatableText("tooltip.preventer.noDeWax"))
                        .setSaveConsumer(value -> config.noDeWax = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                new TranslatableText("option.preventer.lowDurabilityProtection"),
                                config.lowDurabilityProtection)
                        .setDefaultValue(false)
                        .setTooltip(new TranslatableText("tooltip.preventer.lowDurabilityProtection"))
                        .setSaveConsumer(value -> config.lowDurabilityProtection = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                new TranslatableText("option.preventer.preventVillagerPunch"),
                                config.preventVillagerPunch)
                        .setDefaultValue(false)
                        .setTooltip(new TranslatableText("tooltip.preventer.preventVillagerPunch"))
                        .setSaveConsumer(value -> config.preventVillagerPunch = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                new TranslatableText("option.preventer.noZombifiedPiglinPunch"),
                                config.noZombifiedPiglinPunch)
                        .setDefaultValue(false)
                        .setTooltip(new TranslatableText("tooltip.preventer.noZombifiedPiglinPunch"))
                        .setSaveConsumer(value -> config.noZombifiedPiglinPunch = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                new TranslatableText("option.preventer.noTrappedChestOpening"),
                                config.noTrappedChestOpening)
                        .setDefaultValue(false)
                        .setTooltip(new TranslatableText("tooltip.preventer.noTrappedChestOpening"))
                        .setSaveConsumer(value -> config.noTrappedChestOpening = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                new TranslatableText("option.preventer.preventBuddingAmethystBreaking"),
                                config.preventBuddingAmethystBreaking)
                        .setDefaultValue(false)
                        .setTooltip(new TranslatableText("tooltip.preventer.preventBuddingAmethystBreaking"))
                        .setSaveConsumer(value -> config.preventBuddingAmethystBreaking = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                new TranslatableText("option.preventer.preventRocketUse"),
                                config.preventRocketUse)
                        .setDefaultValue(false)
                        .setTooltip(new TranslatableText("tooltip.preventer.preventRocketUse"))
                        .setSaveConsumer(value -> config.preventRocketUse = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                new TranslatableText("option.preventer.preventEndCrystalHitting"),
                                config.preventEndCrystalHitting)
                        .setDefaultValue(false)
                        .setTooltip(new TranslatableText("tooltip.preventer.preventEndCrystalHitting"))
                        .setSaveConsumer(value -> config.preventEndCrystalHitting = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                new TranslatableText("option.preventer.preventBedUse"),
                                config.preventBedUse)
                        .setDefaultValue(false)
                        .setTooltip(new TranslatableText("tooltip.preventer.preventBedUse"))
                        .setSaveConsumer(value -> config.preventBedUse = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                new TranslatableText("option.preventer.preventCoralPlace"),
                                config.preventCoralPlace)
                        .setDefaultValue(false)
                        .setTooltip(new TranslatableText("tooltip.preventer.preventCoralPlace"))
                        .setSaveConsumer(value -> config.preventCoralPlace = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                new TranslatableText("option.preventer.preventWaterPlace"),
                                config.preventWaterPlace)
                        .setDefaultValue(false)
                        .setTooltip(new TranslatableText("tooltip.preventer.preventWaterPlace"))
                        .setSaveConsumer(value -> config.preventWaterPlace = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                new TranslatableText("option.preventer.preventStemBreaking"),
                                config.preventStemBreaking)
                        .setDefaultValue(false)
                        .setTooltip(new TranslatableText("tooltip.preventer.preventStemBreaking"))
                        .setSaveConsumer(value -> config.preventStemBreaking = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                new TranslatableText("option.preventer.preventItemFrameBreaking"),
                                config.preventItemFrameBreaking)
                        .setDefaultValue(false)
                        .setTooltip(new TranslatableText("tooltip.preventer.preventItemFrameBreaking"))
                        .setSaveConsumer(value -> config.preventItemFrameBreaking = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                new TranslatableText("option.preventer.preventPaintingBreaking"),
                                config.preventPaintingBreaking)
                        .setDefaultValue(false)
                        .setTooltip(new TranslatableText("tooltip.preventer.preventPaintingBreaking"))
                        .setSaveConsumer(value -> config.preventPaintingBreaking = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                new TranslatableText("option.preventer.preventToolDropping"),
                                config.preventToolDropping)
                        .setDefaultValue(false)
                        .setTooltip(new TranslatableText("tooltip.preventer.preventToolDropping"))
                        .setSaveConsumer(value -> config.preventToolDropping = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                new TranslatableText("option.preventer.preventGlassBreaking"),
                                config.preventGlassBreaking)
                        .setDefaultValue(false)
                        .setTooltip(new TranslatableText("tooltip.preventer.preventGlassBreaking"))
                        .setSaveConsumer(value -> config.preventGlassBreaking = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                new TranslatableText("option.preventer.preventRenamedBlockPlacing"),
                                config.preventRenamedBlockPlacing)
                        .setDefaultValue(false)
                        .setTooltip(new TranslatableText("tooltip.preventer.preventRenamedBlockPlacing"))
                        .setSaveConsumer(value -> config.preventRenamedBlockPlacing = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                new TranslatableText("option.preventer.preventRenamedItemEating"),
                                config.preventRenamedItemEating)
                        .setDefaultValue(false)
                        .setTooltip(new TranslatableText("tooltip.preventer.preventRenamedItemEating"))
                        .setSaveConsumer(value -> config.preventRenamedItemEating = value)
                        .build())

                //no usage msg
                .addEntry(entryBuilder.startBooleanToggle(
                                new TranslatableText("option.preventer.hideShield"),
                                config.hideShield)
                        .setDefaultValue(false)
                        .setTooltip(new TranslatableText("tooltip.preventer.hideShield"))
                        .setSaveConsumer(value -> config.hideShield = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                new TranslatableText("option.preventer.hideTotem"),
                                config.hideTotem)
                        .setDefaultValue(false)
                        .setTooltip(new TranslatableText("tooltip.preventer.hideTotem"))
                        .setSaveConsumer(value -> config.hideTotem = value)
                        .build());


        builder.getOrCreateCategory(new TranslatableText("category.preventer.moduleConfig"))
                .addEntry(entryBuilder.startIntSlider(
                                new TranslatableText("config.preventer.lowDurabilityProtectionRange"),
                                config.lowDurabilityProtectionRange, 1, 30)
                        .setDefaultValue(5)
                        .setTooltip(new TranslatableText("tooltip.preventer.lowDurabilityProtectionRange"))
                        .setSaveConsumer(value -> config.lowDurabilityProtectionRange = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                new TranslatableText("config.preventer.rocketInOffhand"),
                                config.rocketInOffhand)
                        .setDefaultValue(true)
                        .setSaveConsumer(value -> config.rocketInOffhand = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                new TranslatableText("config.preventer.rocketInMainHand"),
                                config.rocketInMainHand)
                        .setDefaultValue(true)
                        .setSaveConsumer(value -> config.rocketInMainHand = value)
                        .build());


        builder.getOrCreateCategory(new TranslatableText("category.preventer.moduleUsageInfo"))
                .addEntry(entryBuilder.startTextDescription(
                                new TranslatableText("text.preventer.moduleUseInfo"))
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                new TranslatableText("option.preventer.noStrip"),
                                config.noStrip_msg)
                        .setDefaultValue(false)
                        .setSaveConsumer(value -> config.noStrip_msg = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                new TranslatableText("option.preventer.noPath"),
                                config.noPath_msg)
                        .setDefaultValue(false)
                        .setSaveConsumer(value -> config.noPath_msg = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                new TranslatableText("option.preventer.noFarmland"),
                                config.noFarmland_msg)
                        .setDefaultValue(false)
                        .setSaveConsumer(value -> config.noFarmland_msg = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                new TranslatableText("option.preventer.noSweetBerrieHarvest"),
                                config.noSweetBerrieHarvest_msg)
                        .setDefaultValue(false)
                        .setSaveConsumer(value -> config.noSweetBerrieHarvest_msg = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                new TranslatableText("option.preventer.noGlowBerrieHarvest"),
                                config.noGlowBerrieHarvest_msg)
                        .setDefaultValue(false)
                        .setSaveConsumer(value -> config.noGlowBerrieHarvest_msg = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                new TranslatableText("option.preventer.onlyMatureCropHarvest"),
                                config.onlyMatureCropHarvest_msg)
                        .setDefaultValue(false)
                        .setSaveConsumer(value -> config.onlyMatureCropHarvest_msg = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                new TranslatableText("option.preventer.noCake"),
                                config.noCake_msg)
                        .setDefaultValue(false)
                        .setSaveConsumer(value -> config.noCake_msg = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                new TranslatableText("option.preventer.noScraping"),
                                config.noScraping_msg)
                        .setDefaultValue(false)
                        .setSaveConsumer(value -> config.noScraping_msg = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                new TranslatableText("option.preventer.noDeWax"),
                                config.noDeWax_msg)
                        .setDefaultValue(false)
                        .setSaveConsumer(value -> config.noDeWax_msg = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                new TranslatableText("option.preventer.lowDurabilityProtection"),
                                config.lowDurabilityProtection_msg)
                        .setDefaultValue(false)
                        .setSaveConsumer(value -> config.lowDurabilityProtection_msg = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                new TranslatableText("option.preventer.preventVillagerPunch"),
                                config.preventVillagerPunch_msg)
                        .setDefaultValue(false)
                        .setSaveConsumer(value -> config.preventVillagerPunch_msg = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                new TranslatableText("option.preventer.noZombifiedPiglinPunch"),
                                config.noZombifiedPiglinPunch_msg)
                        .setDefaultValue(false)
                        .setSaveConsumer(value -> config.noZombifiedPiglinPunch_msg = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                new TranslatableText("option.preventer.noTrappedChestOpening"),
                                config.noTrappedChestOpening_msg)
                        .setDefaultValue(false)
                        .setSaveConsumer(value -> config.noTrappedChestOpening_msg = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                new TranslatableText("option.preventer.preventBuddingAmethystBreaking"),
                                config.preventBuddingAmethystBreaking_msg)
                        .setDefaultValue(false)
                        .setSaveConsumer(value -> config.preventBuddingAmethystBreaking_msg = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                new TranslatableText("option.preventer.preventRocketUse"),
                                config.preventRocketUse_msg)
                        .setDefaultValue(false)
                        .setSaveConsumer(value -> config.preventRocketUse_msg = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                new TranslatableText("option.preventer.preventEndCrystalHitting"),
                                config.preventEndCrystalHitting_msg)
                        .setDefaultValue(false)
                        .setSaveConsumer(value -> config.preventEndCrystalHitting_msg = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                new TranslatableText("option.preventer.preventBedUse"),
                                config.preventBedUse_msg)
                        .setDefaultValue(false)
                        .setSaveConsumer(value -> config.preventBedUse_msg = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                new TranslatableText("option.preventer.preventCoralPlace"),
                                config.preventCoralPlace_msg)
                        .setDefaultValue(false)
                        .setSaveConsumer(value -> config.preventCoralPlace_msg = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                new TranslatableText("option.preventer.preventWaterPlace"),
                                config.preventWaterPlace_msg)
                        .setDefaultValue(false)
                        .setSaveConsumer(value -> config.preventWaterPlace_msg = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                new TranslatableText("option.preventer.preventStemBreaking"),
                                config.preventStemBreaking_msg)
                        .setDefaultValue(false)
                        .setSaveConsumer(value -> config.preventStemBreaking_msg = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                new TranslatableText("option.preventer.preventItemFrameBreaking"),
                                config.preventItemFrameBreaking_msg)
                        .setDefaultValue(false)
                        .setSaveConsumer(value -> config.preventItemFrameBreaking_msg = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                new TranslatableText("option.preventer.preventPaintingBreaking"),
                                config.preventPaintingBreaking_msg)
                        .setDefaultValue(false)
                        .setSaveConsumer(value -> config.preventPaintingBreaking_msg = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                new TranslatableText("option.preventer.preventToolDropping"),
                                config.preventToolDropping_msg)
                        .setDefaultValue(false)
                        .setSaveConsumer(value -> config.preventToolDropping_msg = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                new TranslatableText("option.preventer.preventGlassBreaking"),
                                config.preventGlassBreaking_msg)
                        .setDefaultValue(false)
                        .setSaveConsumer(value -> config.preventGlassBreaking_msg = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                new TranslatableText("option.preventer.preventRenamedBlockPlacing"),
                                config.preventRenamedBlockPlacing_msg)
                        .setDefaultValue(false)
                        .setSaveConsumer(value -> config.preventRenamedBlockPlacing_msg = value)
                        .build())

                .addEntry(entryBuilder.startBooleanToggle(
                                new TranslatableText("option.preventer.preventRenamedItemEating"),
                                config.preventRenamedItemEating_msg)
                        .setDefaultValue(false)
                        .setSaveConsumer(value -> config.preventRenamedItemEating_msg = value)
                        .build());

        return builder
                .setSavingRunnable(PreventerConfig::save)
                .build();
    }
}