package com.dashomi.preventer.modules;

import com.dashomi.preventer.PreventerClient;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.world.World;

public class UseBlockModule {
    public static ActionResult checkBlockUse(PlayerEntity playerEntity, World world, Hand hand, BlockHitResult blockHitResult) {
        Block targetBlock = world.getBlockState(blockHitResult.getBlockPos()).getBlock();
        if (PreventerClient.config.noStrip) {
            if (playerEntity.getStackInHand(hand).getItem() instanceof AxeItem) {
                if (AxeItem.STRIPPED_BLOCKS.containsKey(targetBlock)) {
                    return ActionResult.FAIL;
                }
            }
        }

        if (PreventerClient.config.noPath) {
            if (playerEntity.getStackInHand(hand).getItem() instanceof ShovelItem) {
                if (ShovelItem.PATH_STATES.containsKey(targetBlock)) {
                    return ActionResult.FAIL;
                }
            }
        }

        if (PreventerClient.config.noFarmland) {
            if (playerEntity.getStackInHand(hand).getItem() instanceof HoeItem) {
                if (HoeItem.TILLING_ACTIONS.containsKey(targetBlock)) {
                    return ActionResult.FAIL;
                }
            }
        }

        if (PreventerClient.config.noGlowBerrieHarvest) {
            if (targetBlock instanceof CaveVines) {
                return ActionResult.FAIL;
            }
        }

        if (PreventerClient.config.noSweetBerrieHarvest) {
            if (targetBlock instanceof SweetBerryBushBlock) {
                return ActionResult.FAIL;
            }
        }

        if (PreventerClient.config.noScraping) {
            if (playerEntity.getStackInHand(hand).getItem() instanceof AxeItem) {
                if (targetBlock instanceof Oxidizable) {
                    return ActionResult.FAIL;
                }
            }
        }

        if (PreventerClient.config.noDeWax) {
            if (playerEntity.getStackInHand(hand).getItem() instanceof AxeItem) {
                if (HoneycombItem.WAXED_TO_UNWAXED_BLOCKS.get().containsKey(targetBlock)) {
                    return ActionResult.FAIL;
                }
            }
        }

        if (PreventerClient.config.lowDurabilityProtection){
            if (!playerEntity.isCreative() && !playerEntity.isSpectator()) { // AttackBlockCallback does not do game mode check for us, so we need to do it by ourselves
                ItemStack stack = playerEntity.getStackInHand(hand);
                if (stack.isDamageable()) { // Check if the item is damageable
                    if (stack.getDamage() >= stack.getMaxDamage() - PreventerClient.config.moduleConfigGroup.lowDurabilityProtectionRange) { // Check if the item is *almost* broken
                        playerEntity.sendMessage(new TranslatableText("config.preventer.lowDurabilityProtection.text"), true);
                        return ActionResult.FAIL;
                    }
                }
            }
        }

        return ActionResult.PASS;
    }
}
