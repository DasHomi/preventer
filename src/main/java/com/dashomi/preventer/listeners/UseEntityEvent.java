package com.dashomi.preventer.listeners;

import com.dashomi.preventer.PreventerClient;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import static com.dashomi.preventer.utils.ActionPreventedMessage.sendActionPreventedMessage;
import static com.dashomi.preventer.utils.DurabilityProtection.checkDurabilityProtection;

public class UseEntityEvent {
    public static ActionResult useEntityListener(PlayerEntity playerEntity, World world, Hand hand, Entity entity, @Nullable EntityHitResult hitResult) {
        if (PreventerClient.getPrevent()) {
            if (PreventerClient.config.preventRenamedItemUsing) {
                if (playerEntity.getStackInHand(hand).get(DataComponentTypes.CUSTOM_NAME) != null) {
                    sendActionPreventedMessage(playerEntity, Text.translatable("config.preventer.preventRenamedItemUsing.text"));
                    return ActionResult.FAIL;
                }
            }

            if (checkDurabilityProtection(playerEntity, hand)) return ActionResult.FAIL;
        }

        return ActionResult.PASS;
    }
}
