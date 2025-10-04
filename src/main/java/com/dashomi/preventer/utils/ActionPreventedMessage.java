package com.dashomi.preventer.utils;

import com.dashomi.preventer.PreventerClient;
import com.dashomi.preventer.enums.ActionPreventedInfo;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;

public class ActionPreventedMessage {
    public static void sendActionPreventedMessage(PlayerEntity player, Text legacyMessage) {
        if (PreventerClient.config.actionPreventedInfoType == ActionPreventedInfo.LEGACY) {
            player.sendMessage(legacyMessage, true);
            return;
        }
        sendActionPreventedMessage(player);
    }

    public static void sendActionPreventedMessage(PlayerEntity player) {
        if (PreventerClient.config.actionPreventedInfoType == ActionPreventedInfo.DEFAULT) {
            player.sendMessage(Text.translatable("preventer.universalActionPreventedMessage"), true);
        } else if (PreventerClient.config.actionPreventedInfoType == ActionPreventedInfo.MINIMAL) {
            player.sendMessage(Text.translatable("preventer.unobtrusiveActionPreventedMessage"), true);
        }
    }
}
