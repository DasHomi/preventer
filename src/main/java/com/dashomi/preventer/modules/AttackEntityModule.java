package com.dashomi.preventer.modules;

import com.dashomi.preventer.PreventerClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class AttackEntityModule {
    public static ActionResult checkEntityAttack(PlayerEntity playerEntity, World world, Hand hand, Entity entity, @Nullable EntityHitResult result) {
        if (PreventerClient.config.lowDurabilityProtection) {
            if (!playerEntity.isCreative() && !playerEntity.isSpectator()) { // AttackBlockCallback does not do game mode check for us, so we need to do it by ourselves
                ItemStack stack = playerEntity.getStackInHand(hand);
                if (stack.isDamageable()) { // Check if the item is damageable
                    if (stack.getDamage() >= stack.getMaxDamage() - PreventerClient.config.moduleConfigGroup.lowDurabilityProtectionRange) { // Check if the item is *almost* broken
                        playerEntity.sendMessage(Text.translatable("config.preventer.lowDurabilityProtection.text"), true);
                        return ActionResult.FAIL;
                    }
                }
            }
        }

        return ActionResult.PASS;
    }
}
