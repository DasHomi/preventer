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

import static com.dashomi.preventer.utils.DurabilityProtection.checkDurabilityProtection;

public class UseEntityEvent {
    public static ActionResult useEntityListener(PlayerEntity player, World world, Hand hand, Entity entity, @Nullable EntityHitResult hitResult) {
        if (!PreventerClient.overrideKeyPressed) {
            if (PreventerClient.config.preventRenamedItemUsing) {
                if (player.getStackInHand(hand).get(DataComponentTypes.CUSTOM_NAME) != null) {
                    if (PreventerClient.config.preventRenamedItemUsing_msg) {
                        player.sendMessage(Text.translatable("config.preventer.preventRenamedItemUsing.text"), true);
                    }
                    return ActionResult.FAIL;
                }
            }

            if (checkDurabilityProtection(player, hand)) return ActionResult.FAIL;
        }

        return ActionResult.PASS;
    }
}
