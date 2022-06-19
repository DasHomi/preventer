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

import static net.minecraft.block.CaveVines.BERRIES;
import static net.minecraft.block.SweetBerryBushBlock.AGE;

public class UseBlockModule {
    public static ActionResult checkBlockUse(PlayerEntity playerEntity, World world, Hand hand, BlockHitResult blockHitResult) {
        Block targetBlock = world.getBlockState(blockHitResult.getBlockPos()).getBlock();
        if (PreventerClient.config.noStrip) {
            if (playerEntity.getStackInHand(hand).getItem() instanceof AxeItem) {
                if (AxeItem.STRIPPED_BLOCKS.containsKey(targetBlock)) {
                    if (PreventerClient.config.moduleUseInfoGroup.noStrip_msg) {
                        playerEntity.sendMessage(new TranslatableText("config.preventer.noStrip.text"), true);
                    }
                    return ActionResult.FAIL;
                }
            }
        }

        if (PreventerClient.config.noPath) {
            if (playerEntity.getStackInHand(hand).getItem() instanceof ShovelItem) {
                if (ShovelItem.PATH_STATES.containsKey(targetBlock)) {
                    if (PreventerClient.config.moduleUseInfoGroup.noPath_msg) {
                        playerEntity.sendMessage(new TranslatableText("config.preventer.noPath.text"), true);
                    }
                    return ActionResult.FAIL;
                }
            }
        }

        if (PreventerClient.config.noFarmland) {
            if (playerEntity.getStackInHand(hand).getItem() instanceof HoeItem) {
                if (HoeItem.TILLING_ACTIONS.containsKey(targetBlock)) {
                    if (PreventerClient.config.moduleUseInfoGroup.noFarmland_msg) {
                        playerEntity.sendMessage(new TranslatableText("config.preventer.noFarmland.text"), true);
                    }
                    return ActionResult.FAIL;
                }
            }
        }

        if (PreventerClient.config.noGlowBerrieHarvest) {
            if (targetBlock instanceof CaveVines) {
                if (world.getBlockState(blockHitResult.getBlockPos()).get(BERRIES)) {
                    if (PreventerClient.config.moduleUseInfoGroup.noGlowBerrieHarvest_msg) {
                        playerEntity.sendMessage(new TranslatableText("config.preventer.noGlowBerrieHarvest.text"), true);
                    }
                    return ActionResult.FAIL;
                }
            }
        }

        if (PreventerClient.config.noSweetBerrieHarvest) {
            if (targetBlock instanceof SweetBerryBushBlock) {
                if (world.getBlockState(blockHitResult.getBlockPos()).get(AGE) >= 2) {
                    if (PreventerClient.config.moduleUseInfoGroup.noSweetBerrieHarvest_msg) {
                        playerEntity.sendMessage(new TranslatableText("config.preventer.noSweetBerrieHarvest.text"), true);
                    }
                    return ActionResult.FAIL;
                }
            }
        }

        if (PreventerClient.config.noScraping) {
            if (playerEntity.getStackInHand(hand).getItem() instanceof AxeItem) {
                if (targetBlock instanceof Oxidizable) {
                    if (PreventerClient.config.moduleUseInfoGroup.noScraping_msg) {
                        playerEntity.sendMessage(new TranslatableText("config.preventer.noScraping.text"), true);
                    }
                    return ActionResult.FAIL;
                }
            }
        }

        if (PreventerClient.config.noDeWax) {
            if (playerEntity.getStackInHand(hand).getItem() instanceof AxeItem) {
                if (HoneycombItem.WAXED_TO_UNWAXED_BLOCKS.get().containsKey(targetBlock)) {
                    if (PreventerClient.config.moduleUseInfoGroup.noDeWax_msg) {
                        playerEntity.sendMessage(new TranslatableText("config.preventer.noDeWax.text"), true);
                    }
                    return ActionResult.FAIL;
                }
            }
        }

        if (PreventerClient.config.lowDurabilityProtection){
            if (!playerEntity.isCreative() && !playerEntity.isSpectator()) { // AttackBlockCallback does not do game mode check for us, so we need to do it by ourselves
                ItemStack stack = playerEntity.getStackInHand(hand);
                if (stack.isDamageable()) { // Check if the item is damageable
                    if (stack.getDamage() >= stack.getMaxDamage() - PreventerClient.config.moduleConfigGroup.lowDurabilityProtectionRange) { // Check if the item is *almost* broken
                        if (PreventerClient.config.moduleUseInfoGroup.lowDurabilityProtection_msg) {
                            playerEntity.sendMessage(new TranslatableText("config.preventer.lowDurabilityProtection.text"), true);
                        }
                        return ActionResult.FAIL;
                    }
                }
            }
        }

        return ActionResult.PASS;
    }
}
