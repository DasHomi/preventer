package com.dashomi.preventer.listeners;

import com.dashomi.preventer.PreventerClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class UseEntityEvent {
    public static ActionResult useEntityListener(PlayerEntity player, World world, Hand hand, Entity entity, @Nullable EntityHitResult hitResult) {
        if (PreventerClient.getPrevent()) {
            if (PreventerClient.config.preventRenamedItemUsing) {
                if (player.getStackInHand(hand).hasCustomName()) {
                    if (PreventerClient.config.preventRenamedItemUsing_msg) {
                        player.sendMessage(Text.translatable("config.preventer.preventRenamedItemUsing.text"), true);
                    }
                    return ActionResult.FAIL;
                }
            }
        }

        return ActionResult.PASS;
    }
}
