package com.dashomi.preventer.listeners;

import com.dashomi.preventer.PreventerClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class UseItemEvent {
    public static TypedActionResult<ItemStack> useItemListener(PlayerEntity player, World world, Hand hand) {
        if (!PreventerClient.overrideKeyPressed) {
            if (PreventerClient.config.preventRenamedItemEating) {
                if (player.getStackInHand(hand).isFood()) {
                    if (player.getStackInHand(hand).hasCustomName()) {
                        if (PreventerClient.config.preventRenamedItemEating_msg) {
                            player.sendMessage(Text.translatable("config.preventer.preventRenamedItemEating.text"), true);
                        }
                        return TypedActionResult.fail(player.getStackInHand(hand));
                    }
                }
            }
        }

        return TypedActionResult.pass(player.getStackInHand(hand));
    }
}