package com.dashomi.preventer.modules;

import com.dashomi.preventer.PreventerClient;
import com.dashomi.preventer.util.LowDurabilityProtectionHelper;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.world.World;

import java.util.Arrays;
import java.util.List;

public class UseBlockModule {
    static List<Block> glowBerryBlocks = Arrays.asList(Blocks.CAVE_VINES, Blocks.CAVE_VINES_PLANT);

    public static ActionResult checkBlockUse(PlayerEntity playerEntity, World world, Hand hand, BlockHitResult blockHitResult) {
        if (PreventerClient.config.noStrip) {
            if (playerEntity.getStackInHand(hand).getItem() instanceof AxeItem) {
                BlockState blockState = world.getBlockState(blockHitResult.getBlockPos());
                if (AxeItem.STRIPPED_BLOCKS.containsKey(blockState.getBlock())) {
                    return ActionResult.FAIL;
                }
            }
        } else {
            return LowDurabilityProtectionHelper.doDurabilityCheck(playerEntity.getStackInHand(hand), playerEntity);
        }
        if (PreventerClient.config.noPath) {
            if (playerEntity.getStackInHand(hand).getItem() instanceof ShovelItem) {
                BlockState blockState = world.getBlockState(blockHitResult.getBlockPos());
                if (ShovelItem.PATH_STATES.containsKey(blockState.getBlock())) {
                    return ActionResult.FAIL;
                }
            }
        } else {
            return LowDurabilityProtectionHelper.doDurabilityCheck(playerEntity.getStackInHand(hand), playerEntity);
        }
        if (PreventerClient.config.noFarmland) {
            if (playerEntity.getStackInHand(hand).getItem() instanceof HoeItem) {
                BlockState blockState = world.getBlockState(blockHitResult.getBlockPos());
                if (HoeItem.TILLING_ACTIONS.containsKey(blockState.getBlock())) {
                    return ActionResult.FAIL;
                }
            }
        } else {
            return LowDurabilityProtectionHelper.doDurabilityCheck(playerEntity.getStackInHand(hand), playerEntity);
        }
        if (PreventerClient.config.noGlowBerrieHarvest) {
            BlockState blockState = world.getBlockState(blockHitResult.getBlockPos());
            if (glowBerryBlocks.contains(blockState.getBlock())) {
                return ActionResult.FAIL;
            }
        }
        if (PreventerClient.config.noSweetBerrieHarvest) {
            BlockState blockState = world.getBlockState(blockHitResult.getBlockPos());
            if (blockState.getBlock().equals(Blocks.SWEET_BERRY_BUSH)) {
                return ActionResult.FAIL;
            }
        }
        if (PreventerClient.config.noScraping) {
            if (playerEntity.getStackInHand(hand).getItem() instanceof AxeItem) {
                Block block = world.getBlockState(blockHitResult.getBlockPos()).getBlock();
                if (block instanceof Oxidizable) {
                    return ActionResult.FAIL;
                }
            }
        } else {
            return LowDurabilityProtectionHelper.doDurabilityCheck(playerEntity.getStackInHand(hand), playerEntity);
        }
        if (PreventerClient.config.noDeWax) {
            if (playerEntity.getStackInHand(hand).getItem() instanceof AxeItem) {
                Block block = world.getBlockState(blockHitResult.getBlockPos()).getBlock();
                if (HoneycombItem.WAXED_TO_UNWAXED_BLOCKS.get().containsKey(block)) {
                    return ActionResult.FAIL;
                }
            }
        } else {
            return LowDurabilityProtectionHelper.doDurabilityCheck(playerEntity.getStackInHand(hand), playerEntity);
        }
        return ActionResult.PASS;
    }
}
