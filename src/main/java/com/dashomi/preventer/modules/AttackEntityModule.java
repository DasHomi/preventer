package com.dashomi.preventer.modules;

import com.dashomi.preventer.util.LowDurabilityProtectionHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class AttackEntityModule {
    public static ActionResult checkEntityAttack(PlayerEntity player, World world, Hand hand, Entity entity, @Nullable EntityHitResult result) {
        return LowDurabilityProtectionHelper.doDurabilityCheck(player.getStackInHand(hand), player);
    }
}
