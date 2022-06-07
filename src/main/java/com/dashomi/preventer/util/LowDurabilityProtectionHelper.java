package com.dashomi.preventer.util;

import com.dashomi.preventer.PreventerClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;

public class LowDurabilityProtectionHelper {
    public static ActionResult doDurabilityCheck(ItemStack stack, PlayerEntity player) {
        if (PreventerClient.config.lowDurabilityProtection) { // Annoying if-s, I know
            if (!player.isCreative() && !player.isSpectator()) { // AttackBlockCallback does not do game mode check for us, so we need to do it by ourselves
                if (stack.isDamageable()) { // Check if the item is damageable
                    if (stack.getDamage() >= stack.getMaxDamage() - PreventerClient.config.lowDurabilityProtectionRange) { // Check if the item is *almost* broken
                        return ActionResult.FAIL;
                    }
                }
            }
        }
        return ActionResult.PASS;
    }
}
