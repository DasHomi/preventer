package com.dashomi.preventer.utils;

import com.dashomi.preventer.PreventerClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;

public class DurabilityProtection {
    public static boolean checkDurabilityProtection(PlayerEntity playerEntity, Hand hand) {
        if (PreventerClient.config.lowDurabilityProtection) {
            if (!playerEntity.isCreative() && !playerEntity.isSpectator()) {
                ItemStack stack = playerEntity.getStackInHand(hand);
                if (stack.isDamageable()) {
                    if (stack.getDamage() >= stack.getMaxDamage() - PreventerClient.config.lowDurabilityProtectionRange) {
                        if (PreventerClient.config.lowDurabilityProtection_msg) {
                            playerEntity.sendMessage(Text.translatable("config.preventer.lowDurabilityProtection.text"), true);
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
