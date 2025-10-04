package com.dashomi.preventer.utils;

import com.dashomi.preventer.PreventerClient;
import com.dashomi.preventer.enums.ActionPreventedInfo;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class ActionPreventedMessage {
    public static void sendActionPreventedMessage(PlayerEntity player, Text legacyMessage) {
        if (PreventerClient.config.actionPreventedInfoType == ActionPreventedInfo.LEGACY) {
            player.sendMessage(legacyMessage, true);
            return;
        }
        sendActionPreventedMessage(player);
    }

    public static void sendActionPreventedMessage(PlayerEntity player) {
        switch (PreventerClient.config.actionPreventedInfoType) {
            case MINIMAL:
                player.sendMessage(Text.literal("❌").formatted(Formatting.RED), true);
                break;
            case DEFAULT:
                player.sendMessage(Text.translatable("preventer.defaultActionPreventedMessage"), true);
                break;
            case AUDIO:
                player.playSound(SoundEvents.BLOCK_NOTE_BLOCK_BASEDRUM.value(), 1.0f, 1.1f);
                break;
        }
    }
}
