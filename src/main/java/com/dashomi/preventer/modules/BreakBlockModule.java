package com.dashomi.preventer.modules;

import com.dashomi.preventer.PreventerClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class BreakBlockModule {
    public static ActionResult checkBlockBreak(PlayerEntity player, World world, Hand hand, BlockPos pos, Direction direction) {
        if (PreventerClient.config.lowDurabilityProtection) { // Annoying if-s, I know
            if (!player.isCreative() && !player.isSpectator()) { // AttackBlockCallback does not do game mode check for us, so we need to do it by ourselves
                ItemStack stack = player.getStackInHand(hand);
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
