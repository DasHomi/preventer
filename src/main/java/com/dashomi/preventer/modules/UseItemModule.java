package com.dashomi.preventer.modules;

import com.dashomi.preventer.PreventerClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class UseItemModule {
    public static TypedActionResult<ItemStack> checkItemUse(PlayerEntity player, World world, Hand hand) {
        if (!PreventerClient.config.overrideKeyPressed) {
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
