package com.dashomi.preventer.utils;

import com.dashomi.preventer.PreventerClient;
import com.dashomi.preventer.enums.ActionPreventedInfo;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;

import static com.dashomi.preventer.utils.ActionPreventedMessage.sendActionPreventedMessage;

public class DurabilityProtection {
    public static boolean checkDurabilityProtection(Player playerEntity, InteractionHand hand) {
        if (PreventerClient.config.lowDurabilityProtection) {
            if (!playerEntity.isCreative() && !playerEntity.isSpectator()) {
                ItemStack stack = playerEntity.getItemInHand(hand);
                if (stack.isDamageableItem()) {
                    if (stack.getDamageValue() >= stack.getMaxDamage() - 5) {
                        if (PreventerClient.config.showLowDurabilityProtectionWarning) {
                            playerEntity.displayClientMessage(Component.translatable("preventer.miscellaneous.prevented.lowDurabilityProtection"), true);
                            if (PreventerClient.config.actionPreventedInfoType == ActionPreventedInfo.AUDIO) {
                                playerEntity.playSound(SoundEvents.NOTE_BLOCK_BASEDRUM.value(), 1.0f, 1.1f);
                            }
                        } else {
                            sendActionPreventedMessage(playerEntity, Component.translatable("preventer.miscellaneous.prevented.lowDurabilityProtection"));
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
