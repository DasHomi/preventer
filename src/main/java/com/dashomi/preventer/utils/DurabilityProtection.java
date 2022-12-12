package com.dashomi.preventer.utils;

import com.dashomi.preventer.PreventerClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.text.TranslatableText;

public class DurabilityProtection {
    public static boolean checkDurabilityProtection(PlayerEntity playerEntity, Hand hand) {
        if (PreventerClient.config.lowDurabilityProtection) {
            if (!playerEntity.isCreative() && !playerEntity.isSpectator()) {
                ItemStack stack = playerEntity.getStackInHand(hand);
                if (stack.isDamageable()) {
                    if (stack.getDamage() >= stack.getMaxDamage() - PreventerClient.config.moduleConfigGroup.lowDurabilityProtectionRange) {
                        if (PreventerClient.config.moduleUseInfoGroup.lowDurabilityProtection_msg) {
                            playerEntity.sendMessage(new TranslatableText("config.preventer.lowDurabilityProtection.text"), true);
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }
}