package com.dashomi.preventer.modules;

import com.dashomi.preventer.PreventerClient;
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
    static List<Item> shovelItems = Arrays.asList(Items.NETHERITE_SHOVEL, Items.DIAMOND_SHOVEL, Items.GOLDEN_SHOVEL, Items.IRON_SHOVEL, Items.STONE_SHOVEL, Items.WOODEN_SHOVEL);
    static List<Item> axeItems = Arrays.asList(Items.NETHERITE_AXE, Items.DIAMOND_AXE, Items.GOLDEN_AXE, Items.IRON_AXE, Items.STONE_AXE, Items.WOODEN_AXE);
    static List<Item> hoeItems = Arrays.asList(Items.NETHERITE_HOE, Items.DIAMOND_HOE, Items.GOLDEN_HOE, Items.IRON_HOE, Items.STONE_HOE, Items.WOODEN_HOE);
    static List<Block> glowBerryBlocks = Arrays.asList(Blocks.CAVE_VINES, Blocks.CAVE_VINES_PLANT);
    static List<Item> candleItems = Arrays.asList(Items.CANDLE, Items.WHITE_CANDLE, Items.ORANGE_CANDLE, Items.MAGENTA_CANDLE, Items.LIGHT_BLUE_CANDLE,
            Items.YELLOW_CANDLE, Items.LIME_CANDLE, Items.PINK_CANDLE, Items.GRAY_CANDLE, Items.LIGHT_GRAY_CANDLE, Items.CYAN_CANDLE, Items.PURPLE_CANDLE,
            Items.BLUE_CANDLE, Items.BROWN_CANDLE, Items.GREEN_CANDLE, Items.RED_CANDLE, Items.BLACK_CANDLE);

    public static ActionResult checkBlockUse(PlayerEntity playerEntity, World world, Hand hand, BlockHitResult blockHitResult) {
        if (PreventerClient.config.noStrip) {
            if (axeItems.contains(playerEntity.getStackInHand(hand).getItem())) {
                BlockState blockState = world.getBlockState(blockHitResult.getBlockPos());
                if (AxeItem.STRIPPED_BLOCKS.containsKey(blockState.getBlock())) {
                    return ActionResult.FAIL;
                }
            }
        }
        if (PreventerClient.config.noPath) {
            if (shovelItems.contains(playerEntity.getStackInHand(hand).getItem())) {
                BlockState blockState = world.getBlockState(blockHitResult.getBlockPos());
                if (ShovelItem.PATH_STATES.containsKey(blockState.getBlock())) {
                    return ActionResult.FAIL;
                }
            }
        }
        if (PreventerClient.config.noFarmland) {
            if (hoeItems.contains(playerEntity.getStackInHand(hand).getItem())) {
                BlockState blockState = world.getBlockState(blockHitResult.getBlockPos());
                if (HoeItem.TILLING_ACTIONS.containsKey(blockState.getBlock())) {
                    return ActionResult.FAIL;
                }
            }
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
            if (axeItems.contains(playerEntity.getStackInHand(hand).getItem())) {
                Block block = world.getBlockState(blockHitResult.getBlockPos()).getBlock();
                if (block instanceof Oxidizable) {
                    return ActionResult.FAIL;
                }
            }
        }
        if (PreventerClient.config.noDeWax) {
            if (axeItems.contains(playerEntity.getStackInHand(hand).getItem())) {
                Block block = world.getBlockState(blockHitResult.getBlockPos()).getBlock();
                if (HoneycombItem.WAXED_TO_UNWAXED_BLOCKS.get().containsKey(block)) {
                    return ActionResult.FAIL;
                }
            }
        }
        return ActionResult.PASS;
    }
}
