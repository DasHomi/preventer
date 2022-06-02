package com.dashomi.preventer.modules;

import com.dashomi.preventer.PreventerClient;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.tag.Tag;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.UseAction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

import java.util.Arrays;
import java.util.List;

public class UseBlockModule {
    public static ActionResult checkBlockUse(PlayerEntity playerEntity, World world, Hand hand, BlockHitResult blockHitResult) {
        if (PreventerClient.config.noStrip) {
            List<Item> axeItems = Arrays.asList(Items.NETHERITE_AXE, Items.DIAMOND_AXE, Items.GOLDEN_AXE, Items.IRON_AXE, Items.STONE_AXE, Items.WOODEN_AXE);
            if (axeItems.contains(playerEntity.getStackInHand(hand).getItem())) {
                BlockState blockState = world.getBlockState(blockHitResult.getBlockPos());
                if (AxeItem.STRIPPED_BLOCKS.containsKey(blockState.getBlock())) {
                    return ActionResult.FAIL;
                }
            }
        }
        if (PreventerClient.config.noPath) {
            List<Item> shovelItems = Arrays.asList(Items.NETHERITE_SHOVEL, Items.DIAMOND_SHOVEL, Items.GOLDEN_SHOVEL, Items.IRON_SHOVEL, Items.STONE_SHOVEL, Items.WOODEN_SHOVEL);
            if (shovelItems.contains(playerEntity.getStackInHand(hand).getItem())) {
                BlockState blockState = world.getBlockState(blockHitResult.getBlockPos());
                if (ShovelItem.PATH_STATES.containsKey(blockState.getBlock())) {
                    return ActionResult.FAIL;
                }
            }
        }
        if (PreventerClient.config.noFarmland) {
            List<Item> hoeItems = Arrays.asList(Items.NETHERITE_HOE, Items.DIAMOND_HOE, Items.GOLDEN_HOE, Items.IRON_HOE, Items.STONE_HOE, Items.WOODEN_HOE);
            if (hoeItems.contains(playerEntity.getStackInHand(hand).getItem())) {
                BlockState blockState = world.getBlockState(blockHitResult.getBlockPos());
                if (HoeItem.TILLING_ACTIONS.containsKey(blockState.getBlock())) {
                    return ActionResult.FAIL;
                }
            }
        }
        return ActionResult.PASS;
    }
}
