package com.dashomi.preventer.listeners;

import com.dashomi.preventer.PreventerClient;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

import static com.dashomi.preventer.utils.ActionPreventedMessage.sendActionPreventedMessage;

public class UseItemEvent {
    public static ActionResult useItemListener(PlayerEntity playerEntity, World world, Hand hand) {
        if (PreventerClient.getPrevent()) {
            Item handItem = playerEntity.getStackInHand(hand).getItem();
            if (PreventerClient.config.preventRenamedItemUsing) {
                if (playerEntity.getStackInHand(hand).get(DataComponentTypes.FOOD) != null ) {
                    if (playerEntity.getStackInHand(hand).get(DataComponentTypes.CUSTOM_NAME) != null) {
                        sendActionPreventedMessage(playerEntity, Text.translatable("config.preventer.preventRenamedItemUsing.text"));
                        return ActionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.preventPlaceAfterEating) {
                if (playerEntity.getStackInHand(hand).get(DataComponentTypes.FOOD) != null ) {
                    //confirms the player is actually eating the food and not just right-clicked the food on full hunger
                    if (playerEntity.getStackInHand(hand).use(world, playerEntity, hand).isAccepted()) {
                        PreventerClient.ticksSinceEating = 0;
                    }
                }
            }
        }

        return ActionResult.PASS;
    }
}
