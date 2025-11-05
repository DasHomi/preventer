package com.dashomi.preventer.utils;

import com.dashomi.preventer.PreventerClient;
import com.dashomi.preventer.enums.ActionPreventedInfo;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;

import static com.dashomi.preventer.utils.ActionPreventedMessage.sendActionPreventedMessage;

public class DurabilityProtection {
    public static boolean checkDurabilityProtection(PlayerEntity playerEntity, Hand hand) {
        if (PreventerClient.config.lowDurabilityProtection) {
            if (!playerEntity.isCreative() && !playerEntity.isSpectator()) {
                ItemStack stack = playerEntity.getStackInHand(hand);
                if (stack.isDamageable()) {
                    if (stack.getDamage() >= stack.getMaxDamage() - 5) {
                        if (PreventerClient.config.showLowDurabilityProtectionWarning) {
                            playerEntity.sendMessage(Text.translatable("preventer.miscellaneous.prevented.lowDurabilityProtection"), true);
                            if (PreventerClient.config.actionPreventedInfoType == ActionPreventedInfo.AUDIO) {
                                playerEntity.playSound(SoundEvents.BLOCK_NOTE_BLOCK_BASEDRUM.value(), 1.0f, 1.1f);
                            }
                        } else {
                            sendActionPreventedMessage(playerEntity, Text.translatable("preventer.miscellaneous.prevented.lowDurabilityProtection"));
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
