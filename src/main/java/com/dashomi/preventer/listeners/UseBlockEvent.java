package com.dashomi.preventer.listeners;

import com.dashomi.preventer.PreventerClient;
import com.dashomi.preventer.enums.PreventPlacingAfterEatingConfig;
import com.dashomi.preventer.enums.PreventRocketUseConfig;
import net.minecraft.world.entity.player.Player;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.ChatFormatting;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.AbstractChestBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CakeBlock;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.CandleCakeBlock;
import net.minecraft.world.level.block.CaveVines;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.CoralBlock;
import net.minecraft.world.level.block.CoralFanBlock;
import net.minecraft.world.level.block.CoralPlantBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.Level;
import net.minecraft.world.attribute.EnvironmentAttributes;

import java.util.Objects;

import static com.dashomi.preventer.utils.ActionPreventedMessage.sendActionPreventedMessage;
import static com.dashomi.preventer.utils.DurabilityProtection.checkDurabilityProtection;
import static net.minecraft.world.level.block.CaveVines.BERRIES;
import static net.minecraft.world.level.block.SweetBerryBushBlock.AGE;

public class UseBlockEvent {
    public static InteractionResult useBlockListener(Player playerEntity, Level world, InteractionHand hand, BlockHitResult blockHitResult) {
        if (PreventerClient.preventerActive() && !playerEntity.isSpectator()) {
            BlockState targetBlockState = world.getBlockState(blockHitResult.getBlockPos());
            Block targetBlock = targetBlockState.getBlock();
            ItemStack handStack = playerEntity.getItemInHand(hand);
            Item handItem = handStack.getItem();

            if (PreventerClient.config.preventLogStripping) {
                if (handStack.is(ItemTags.AXES)) {
                    if (AxeItem.STRIPPABLES.containsKey(targetBlock)) {
                        sendActionPreventedMessage(playerEntity, Component.translatable("preventer.interactions.prevented.preventLogStripping"));
                        return InteractionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.preventPathCreation) {
                if (handStack.is(ItemTags.SHOVELS)) {
                    if (ShovelItem.FLATTENABLES.containsKey(targetBlock)) {
                        sendActionPreventedMessage(playerEntity, Component.translatable("preventer.interactions.prevented.preventPathCreation"));
                        return InteractionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.preventFarmlandCreation) {
                if (handStack.is(ItemTags.HOES)) {
                    if (HoeItem.TILLABLES.containsKey(targetBlock)) {
                        sendActionPreventedMessage(playerEntity, Component.translatable("preventer.interactions.prevented.preventFarmlandCreation"));
                        return InteractionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.preventGlowBerrieHarvesting) {
                if (targetBlock instanceof CaveVines) {
                    if (world.getBlockState(blockHitResult.getBlockPos()).getValue(BERRIES)) {
                        sendActionPreventedMessage(playerEntity, Component.translatable("preventer.plants.prevented.preventGlowBerrieHarvesting"));
                        return InteractionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.preventSweetBerrieHarvesting) {
                if (targetBlockState.is(Blocks.SWEET_BERRY_BUSH)) {
                    if (world.getBlockState(blockHitResult.getBlockPos()).getValue(AGE) >= 2) {
                        sendActionPreventedMessage(playerEntity, Component.translatable("preventer.plants.prevented.preventSweetBerrieHarvesting"));
                        return InteractionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.preventCopperOxidationScraping) {
                if (handStack.is(ItemTags.AXES)) {
                    if (targetBlock instanceof WeatheringCopper) {
                        sendActionPreventedMessage(playerEntity, Component.translatable("preventer.interactions.prevented.preventCopperOxidationScraping"));
                        return InteractionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.preventCopperDeWaxing) {
                if (handStack.is(ItemTags.AXES)) {
                    if (HoneycombItem.WAX_OFF_BY_BLOCK.get().containsKey(targetBlock)) {
                        sendActionPreventedMessage(playerEntity, Component.translatable("preventer.interactions.prevented.preventCopperDeWaxing"));
                        return InteractionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.preventCakeEating) {
                if (targetBlock instanceof CandleCakeBlock) {
                    sendActionPreventedMessage(playerEntity, Component.translatable("preventer.interactions.prevented.preventCakeEating"));
                    return InteractionResult.FAIL;
                } else if (targetBlock instanceof CakeBlock) {
                    String[] itemName = String.valueOf(handItem).split("_");
                    if (!Objects.equals(itemName[itemName.length - 1], "candle")) {
                        sendActionPreventedMessage(playerEntity, Component.translatable("preventer.interactions.prevented.preventCakeEating"));
                        return InteractionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.preventTrappedChestOpening) {
                if (targetBlockState.is(Blocks.TRAPPED_CHEST)) {
                    sendActionPreventedMessage(playerEntity, Component.translatable("preventer.interactions.prevented.preventTrappedChestOpening"));
                    return InteractionResult.FAIL;
                }
            }

            if (PreventerClient.config.preventBedUse) {
                if (targetBlockState.is(BlockTags.BEDS)) {
                    if (world.dimension() == Level.NETHER || world.dimension() == Level.END) {
                        sendActionPreventedMessage(playerEntity, Component.translatable("preventer.interactions.prevented.preventBedUse"));
                        return InteractionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.preventWaterPlacing) {
                if (handStack.is(Items.WATER_BUCKET)) {
                    if (world.dimensionType().attributes().contains(EnvironmentAttributes.WATER_EVAPORATES)) {
                        if (canNotInteractWithBlock(targetBlockState, playerEntity, hand, blockHitResult)) {
                            sendActionPreventedMessage(playerEntity, Component.translatable("preventer.placing.prevented.preventWaterPlacing"));
                            return InteractionResult.FAIL;
                        }
                    }
                }
            }

            if (PreventerClient.config.preventCoralPlacing) {
                if (handItem instanceof BlockItem){
                    Block handItemBlock = ((BlockItem) handItem).getBlock();
                    if (handItemBlock instanceof CoralPlantBlock || handItemBlock instanceof CoralBlock || handItemBlock instanceof CoralFanBlock) {
                        Block targetBlock2 = world.getBlockState(blockHitResult.getBlockPos().relative(blockHitResult.getDirection(), 1)).getBlock();
                        if (canNotInteractWithBlock(targetBlockState, playerEntity, hand, blockHitResult)) {
                            if (!targetBlock2.equals(Blocks.WATER)) {
                                sendActionPreventedMessage(playerEntity, Component.translatable("preventer.placing.prevented.preventCoralPlacing"));
                                return InteractionResult.FAIL;
                            }
                        }
                    }
                }
            }

            if (PreventerClient.config.preventRocketUse != PreventRocketUseConfig.OFF) {
                if (!playerEntity.isFallFlying() && handItem instanceof FireworkRocketItem && playerEntity.level().isClientSide()) {
                    if (canNotInteractWithBlock(targetBlockState, playerEntity, hand, blockHitResult)) {
                        if ((PreventerClient.config.preventRocketUse == PreventRocketUseConfig.OFF_HAND || PreventerClient.config.preventRocketUse == PreventRocketUseConfig.BOTH)  && InteractionHand.OFF_HAND == hand) {
                            sendActionPreventedMessage(playerEntity, Component.translatable("preventer.interactions.prevented.preventRocketUse"));
                            return InteractionResult.FAIL;
                        }
                        if ((PreventerClient.config.preventRocketUse == PreventRocketUseConfig.MAIN_HAND || PreventerClient.config.preventRocketUse == PreventRocketUseConfig.BOTH) && InteractionHand.MAIN_HAND == hand) {
                            sendActionPreventedMessage(playerEntity, Component.translatable("preventer.interactions.prevented.preventRocketUse"));
                            return InteractionResult.FAIL;
                        }
                    }
                }
            }

            if (PreventerClient.config.preventRenamedItemUsing) {
                if (!(handItem.getDefaultInstance().isDamageableItem())) {
                    if (!handItem.getDefaultInstance().is(ItemTags.SHULKER_BOXES)) {
                        if (!playerEntity.getItemInHand(hand).getHoverName().getString().equals(handItem.getName().getString())) {
                            if (targetBlock instanceof CakeBlock || targetBlock instanceof ComposterBlock || targetBlock instanceof CampfireBlock) {
                                sendActionPreventedMessage(playerEntity, Component.translatable("preventer.interactions.prevented.preventRenamedItemUsing"));
                                return InteractionResult.FAIL;
                            } else {
                                if (canNotInteractWithBlock(targetBlockState, playerEntity, hand, blockHitResult)) {
                                    sendActionPreventedMessage(playerEntity, Component.translatable("preventer.interactions.prevented.preventRenamedItemUsing"));
                                    return InteractionResult.FAIL;
                                }
                            }
                        }
                    }
                }
            }

            if (PreventerClient.config.preventNoteBlockEditing) {
                if (targetBlockState.is(Blocks.NOTE_BLOCK)) {
                    sendActionPreventedMessage(playerEntity, Component.translatable("preventer.interactions.prevented.preventNoteBlockEditing"));
                    return InteractionResult.FAIL;
                }
            }

            if (PreventerClient.config.preventLavaPlacing) {
                if (handStack.is(Items.LAVA_BUCKET)) {
                    if (canNotInteractWithBlock(targetBlockState, playerEntity, hand, blockHitResult)) {
                        sendActionPreventedMessage(playerEntity, Component.translatable("preventer.placing.prevented.preventLavaPlacing"));
                        return InteractionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.preventRespawnAnchorUse) {
                if(targetBlockState.is(Blocks.RESPAWN_ANCHOR)) {
                    if (world.dimension() == Level.OVERWORLD || world.dimension() == Level.END) {
                        sendActionPreventedMessage(playerEntity, Component.translatable("preventer.interactions.prevented.preventRespawnAnchorUse"));
                        return InteractionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.preventDragonEggTeleport) {
                if (targetBlockState.is(Blocks.DRAGON_EGG)) {
                    sendActionPreventedMessage(playerEntity, Component.translatable("preventer.interactions.prevented.preventDragonEggTeleport"));
                    return InteractionResult.FAIL;
                }
            }

            if (PreventerClient.config.preventOffhandPlacing) {
                if (hand == InteractionHand.OFF_HAND && handItem != Items.AIR) {
                    if (canNotInteractWithBlock(targetBlockState, playerEntity, hand, blockHitResult)) {
                        sendActionPreventedMessage(playerEntity, Component.translatable("preventer.placing.prevented.preventOffhandPlacing"));
                        return InteractionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.preventPlacingAfterEating != PreventPlacingAfterEatingConfig.OFF) {
                if (PreventerClient.ticksSinceEating <= 50) {
                    if (handItem instanceof BlockItem && canNotInteractWithBlock(targetBlockState, playerEntity, hand, blockHitResult)) {

                        if (PreventerClient.config.preventPlacingAfterEating != PreventPlacingAfterEatingConfig.TORCHES) {
                            sendActionPreventedMessage(playerEntity, Component.translatable("preventer.placing.prevented.preventPlacingAfterEating"));
                            return InteractionResult.FAIL;
                        } else {
                            boolean holdingTorch = handItem.equals(Items.TORCH);
                            Component heldBlockName = Component.translatable("block.minecraft.torch").withStyle(ChatFormatting.DARK_RED);
                            if (handItem.equals(Items.LANTERN) && !holdingTorch) { //skipped if already holding torch
                                holdingTorch = handItem.equals(Items.LANTERN);
                                heldBlockName = Component.translatable("block.minecraft.lantern").withStyle(ChatFormatting.DARK_RED); //fun subtle detail :)
                            }
                            if (holdingTorch) {
                                sendActionPreventedMessage(playerEntity, Component.translatable("preventer.placing.prevented.preventTorchPlaceAfterEating", heldBlockName));
                                return InteractionResult.FAIL;
                            }
                        }

                    }
                }
            }

            if (PreventerClient.config.preventGrassBonemeal) {
                if (handStack.is(Items.BONE_MEAL)) {
                    if (targetBlockState.is(Blocks.GRASS_BLOCK) || targetBlockState.is(Blocks.NETHERRACK) || targetBlockState.is(BlockTags.NYLIUM)) {
                        sendActionPreventedMessage(playerEntity, Component.translatable("preventer.interactions.prevented.preventGrassBonemeal"));
                        return InteractionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.preventSignEditing) {
                if (targetBlockState.is(BlockTags.SIGNS)) {
                    if (!PreventerClient.config.preventChestSignEditing) {
                        sendActionPreventedMessage(playerEntity, Component.translatable("preventer.interactions.prevented.preventSignEditing"));
                        return InteractionResult.FAIL;
                    } else {
                        if (targetBlockState.is(BlockTags.WALL_SIGNS)) {
                            Block blockBehindTargetBlock = world.getBlockState(blockHitResult.getBlockPos().relative(targetBlockState.getValue(HorizontalDirectionalBlock.FACING), -1)).getBlock();
                            if (blockBehindTargetBlock instanceof AbstractChestBlock) {
                                sendActionPreventedMessage(playerEntity, Component.translatable("preventer.interactions.prevented.preventSignEditing"));
                                return InteractionResult.FAIL;
                            }
                        }
                    }
                }
            }

            if (PreventerClient.config.preventBerriePlanting) {
                if (handItem.equals(Items.SWEET_BERRIES) || handItem.equals(Items.GLOW_BERRIES)) {
                    if (canNotInteractWithBlock(targetBlockState, playerEntity, hand, blockHitResult)) {
                        sendActionPreventedMessage(playerEntity, Component.translatable("preventer.placing.prevented.preventBerriePlanting"));
                        return InteractionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.preventChiseledBookshelfInteracting) {
                if (targetBlockState.is(Blocks.CHISELED_BOOKSHELF)) {
                    sendActionPreventedMessage(playerEntity, Component.translatable("preventer.interactions.prevented.preventChiseledBookshelfInteracting"));
                    return InteractionResult.FAIL;
                }
            }

            if (checkDurabilityProtection(playerEntity, hand)) return InteractionResult.FAIL;
        }

        return InteractionResult.PASS;
    }

    private static boolean canNotInteractWithBlock(BlockState block, Player playerEntity, InteractionHand hand, BlockHitResult blockHitResult) {
        if (block.is(BlockTags.CANDLE_CAKES) ||
                block.is(Blocks.CAKE) ||
                block.is(Blocks.REPEATER) ||
                block.is(Blocks.COMPARATOR)) {
            return false;
        }

        // automatically return true if the player is sneaking
        if (playerEntity.isCrouching()) {
            return true;
        }

        InteractionResult actionResult = block.useWithoutItem(playerEntity.level(), playerEntity, blockHitResult);
        return !actionResult.consumesAction();
    }
}
