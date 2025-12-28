package com.dashomi.preventer.listeners;

import com.dashomi.preventer.PreventerClient;
import com.dashomi.preventer.enums.PreventPlacingAfterEatingConfig;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.level.Level;

import static com.dashomi.preventer.utils.ActionPreventedMessage.sendActionPreventedMessage;

public class UseItemEvent {
    public static InteractionResult useItemListener(Player playerEntity, Level world, InteractionHand hand) {
        if (PreventerClient.preventerActive()) {
            Item handItem = playerEntity.getItemInHand(hand).getItem();
            if (PreventerClient.config.preventRenamedItemUsing) {
                if (playerEntity.getItemInHand(hand).get(DataComponents.FOOD) != null ) {
                    if (playerEntity.getItemInHand(hand).get(DataComponents.CUSTOM_NAME) != null) {
                        sendActionPreventedMessage(playerEntity, Component.translatable("preventer.interactions.prevented.preventRenamedItemUsing"));
                        return InteractionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.preventPlacingAfterEating != PreventPlacingAfterEatingConfig.OFF) {
                if (playerEntity.getItemInHand(hand).get(DataComponents.FOOD) != null ) {
                    //confirms the player is actually eating the food and not just right-clicked the food on full hunger
                    if (playerEntity.getItemInHand(hand).use(world, playerEntity, hand).consumesAction()) {
                        PreventerClient.ticksSinceEating = 0;
                    }
                }
            }
        }

        return InteractionResult.PASS;
    }
}
