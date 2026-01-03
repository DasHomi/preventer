package com.dashomi.preventer.listeners;

import com.dashomi.preventer.PreventerClient;
import com.dashomi.preventer.enums.PreventPlacingAfterEatingConfig;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

import java.util.Objects;

import static com.dashomi.preventer.utils.ActionPreventedMessage.sendActionPreventedMessage;

public class UseItemEvent {
    public static InteractionResult useItemListener(Player playerEntity, Level world, InteractionHand hand) {
        if (PreventerClient.preventerActive() && !playerEntity.isSpectator()) {
            ItemStack handStack = playerEntity.getItemInHand(hand);
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

            if (PreventerClient.config.preventRocketSpamming) {
                if (handStack.is(Items.FIREWORK_ROCKET) && playerEntity.isFallFlying()) {
                    if (PreventerClient.rocketTicksRemaining > 0) {
                        sendActionPreventedMessage(playerEntity, Component.translatable("preventer.interactions.prevented.preventRocketSpamming"));
                        return InteractionResult.FAIL;
                    }
                    int flightDuration = Objects.requireNonNull(handStack.get(DataComponents.FIREWORKS)).flightDuration();
                    if (flightDuration == 1) {
                        PreventerClient.rocketTicksRemaining = 24; // 1.2 seconds
                    } else if (flightDuration == 2) {
                        PreventerClient.rocketTicksRemaining = 30; // 1.5 seconds
                    } else {
                        PreventerClient.rocketTicksRemaining = 45; // 2.25 seconds
                    }
                }
            }

            if (PreventerClient.config.preventCurseOfBindingEquip) {
                if (EnchantmentHelper.getItemEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.BINDING_CURSE), handStack) > 0) {
                    sendActionPreventedMessage(playerEntity, Component.translatable("preventer.interactions.prevented.preventCurseOfBindingEquip"));
                    return InteractionResult.FAIL;
                }
            }
        }

        return InteractionResult.PASS;
    }
}
