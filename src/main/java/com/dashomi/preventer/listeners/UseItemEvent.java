package com.dashomi.preventer.listeners;

import com.dashomi.preventer.PreventerClient;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class UseItemEvent {
    public static TypedActionResult<ItemStack> useItemListener(PlayerEntity player, World world, Hand hand) {
        if (!PreventerClient.overrideKeyPressed) {
            if (PreventerClient.config.preventRenamedItemUsing) {
                if (player.getStackInHand(hand).get(DataComponentTypes.FOOD) != null ) {
                    if (player.getStackInHand(hand).get(DataComponentTypes.CUSTOM_NAME) != null) {
                        if (PreventerClient.config.preventRenamedItemUsing_msg) {
                            player.sendMessage(Text.translatable("config.preventer.preventRenamedItemUsing.text"), true);
                        }
                        return TypedActionResult.fail(player.getStackInHand(hand));
                    }
                }
            }
        }

        return TypedActionResult.pass(player.getStackInHand(hand));
    }
}
