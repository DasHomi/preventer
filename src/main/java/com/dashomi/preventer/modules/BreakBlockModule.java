package com.dashomi.preventer.modules;

import com.dashomi.preventer.util.LowDurabilityProtectionHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class BreakBlockModule {
    public static ActionResult checkBlockBreak(PlayerEntity player, World world, Hand hand, BlockPos pos, Direction direction) {
        return LowDurabilityProtectionHelper.doDurabilityCheck(player.getStackInHand(hand), player);
    }
}
