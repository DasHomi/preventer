package com.dashomi.preventer.utils;

import com.dashomi.preventer.PreventerClient;
import com.dashomi.preventer.enums.ActionPreventedInfo;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.network.chat.Component;
import net.minecraft.ChatFormatting;

public class ActionPreventedMessage {
    public static void sendActionPreventedMessage(Player player, Component legacyMessage) {
        if (PreventerClient.config.actionPreventedInfoType == ActionPreventedInfo.LEGACY) {
            player.sendOverlayMessage(legacyMessage);
            return;
        }
        sendActionPreventedMessage(player);
    }

    public static void sendActionPreventedMessage(Player player) {
        switch (PreventerClient.config.actionPreventedInfoType) {
            case MINIMAL:
                player.sendOverlayMessage(Component.literal("❌").withStyle(ChatFormatting.RED));
                break;
            case LEGACY, DEFAULT:
                player.sendOverlayMessage(Component.translatable("preventer.defaultActionPreventedMessage"));
                break;
            case AUDIO:
                player.playSound(SoundEvents.NOTE_BLOCK_BASEDRUM.value(), 1.0f, 1.1f);
                break;
        }
    }
}
