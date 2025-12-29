package com.dashomi.preventer.listeners;

import com.dashomi.preventer.PreventerClient;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.decoration.ItemFrame;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import static com.dashomi.preventer.utils.ActionPreventedMessage.sendActionPreventedMessage;
import static com.dashomi.preventer.utils.DurabilityProtection.checkDurabilityProtection;

public class UseEntityEvent {
    public static InteractionResult useEntityListener(Player playerEntity, Level world, InteractionHand hand, Entity entity, @Nullable EntityHitResult hitResult) {
        if (PreventerClient.preventerActive()) {
            if (PreventerClient.config.preventRenamedItemUsing) {
                if (playerEntity.getItemInHand(hand).get(DataComponents.CUSTOM_NAME) != null) {
                    sendActionPreventedMessage(playerEntity, Component.translatable("preventer.interactions.prevented.preventRenamedItemUsing"));
                    return InteractionResult.FAIL;
                }
            }

            if (PreventerClient.config.preventItemFrameInteracting) {
                if (entity instanceof ItemFrame) {
                    sendActionPreventedMessage(playerEntity, Component.translatable("preventer.interactions.prevented.preventItemFrameInteracting"));
                    return InteractionResult.FAIL;
                }
            }

            if (checkDurabilityProtection(playerEntity, hand)) return InteractionResult.FAIL;
        }

        return InteractionResult.PASS;
    }
}
