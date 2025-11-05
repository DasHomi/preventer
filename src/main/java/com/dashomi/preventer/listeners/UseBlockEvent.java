package com.dashomi.preventer.listeners;

import com.dashomi.preventer.PreventerClient;
import com.dashomi.preventer.enums.PreventPlacingAfterEatingConfig;
import com.dashomi.preventer.enums.PreventRocketUseConfig;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.world.World;
import java.util.Objects;

import static com.dashomi.preventer.utils.ActionPreventedMessage.sendActionPreventedMessage;
import static com.dashomi.preventer.utils.DurabilityProtection.checkDurabilityProtection;
import static net.minecraft.block.CaveVines.BERRIES;
import static net.minecraft.block.SweetBerryBushBlock.AGE;

public class UseBlockEvent {
    public static ActionResult useBlockListener(PlayerEntity playerEntity, World world, Hand hand, BlockHitResult blockHitResult) {
        if (PreventerClient.getPrevent() && !playerEntity.isSpectator()) {
            BlockState targetBlockState = world.getBlockState(blockHitResult.getBlockPos());
            Block targetBlock = targetBlockState.getBlock();
            Item handItem = playerEntity.getStackInHand(hand).getItem();
            if (PreventerClient.config.preventLogStripping) {
                if (handItem instanceof AxeItem) {
                    if (AxeItem.STRIPPED_BLOCKS.containsKey(targetBlock)) {
                        sendActionPreventedMessage(playerEntity, Text.translatable("preventer.interactions.prevented.preventLogStripping"));
                        return ActionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.preventPathCreation) {
                if (handItem instanceof ShovelItem) {
                    if (ShovelItem.PATH_STATES.containsKey(targetBlock)) {
                        sendActionPreventedMessage(playerEntity, Text.translatable("preventer.interactions.prevented.preventPathCreation"));
                        return ActionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.preventFarmlandCreation) {
                if (handItem instanceof HoeItem) {
                    if (HoeItem.TILLING_ACTIONS.containsKey(targetBlock)) {
                        sendActionPreventedMessage(playerEntity, Text.translatable("preventer.interactions.prevented.preventFarmlandCreation"));
                        return ActionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.preventGlowBerrieHarvesting) {
                if (targetBlock instanceof CaveVines) {
                    if (world.getBlockState(blockHitResult.getBlockPos()).get(BERRIES)) {
                        sendActionPreventedMessage(playerEntity, Text.translatable("preventer.plants.prevented.preventGlowBerrieHarvesting"));
                        return ActionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.preventSweetBerrieHarvesting) {
                if (targetBlock instanceof SweetBerryBushBlock) {
                    if (world.getBlockState(blockHitResult.getBlockPos()).get(AGE) >= 2) {
                        sendActionPreventedMessage(playerEntity, Text.translatable("preventer.plants.prevented.preventSweetBerrieHarvesting"));
                        return ActionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.preventCopperOxidationScraping) {
                if (handItem instanceof AxeItem) {
                    if (targetBlock instanceof Oxidizable) {
                        sendActionPreventedMessage(playerEntity, Text.translatable("preventer.interactions.prevented.preventCopperOxidationScraping"));
                        return ActionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.preventCopperDeWaxing) {
                if (handItem instanceof AxeItem) {
                    if (HoneycombItem.WAXED_TO_UNWAXED_BLOCKS.get().containsKey(targetBlock)) {
                        sendActionPreventedMessage(playerEntity, Text.translatable("preventer.interactions.prevented.preventCopperDeWaxing"));
                        return ActionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.preventCakeEating) {
                if (targetBlock instanceof CandleCakeBlock) {
                    sendActionPreventedMessage(playerEntity, Text.translatable("preventer.interactions.prevented.preventCakeEating"));
                    return ActionResult.FAIL;
                } else if (targetBlock instanceof CakeBlock) {
                    String[] itemName = String.valueOf(handItem).split("_");
                    if (!Objects.equals(itemName[itemName.length - 1], "candle")) {
                        sendActionPreventedMessage(playerEntity, Text.translatable("preventer.interactions.prevented.preventCakeEating"));
                        return ActionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.preventTrappedChestOpening) {
                if (targetBlock instanceof TrappedChestBlock) {
                    sendActionPreventedMessage(playerEntity, Text.translatable("preventer.interactions.prevented.preventTrappedChestOpening"));
                    return ActionResult.FAIL;
                }
            }

            if (PreventerClient.config.preventBedUse) {
                if (targetBlock instanceof BedBlock) {
                    if (!world.getDimension().bedWorks()) {
                        sendActionPreventedMessage(playerEntity, Text.translatable("preventer.interactions.prevented.preventBedUse"));
                        return ActionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.preventWaterPlacing) {
                if (handItem.equals(Items.WATER_BUCKET)) {
                    if (world.getDimension().ultrawarm()) {
                        if (canNotInteractWithBlock(targetBlockState, playerEntity, hand, blockHitResult)) {
                            sendActionPreventedMessage(playerEntity, Text.translatable("preventer.placing.prevented.preventWaterPlacing"));
                            return ActionResult.FAIL;
                        }
                    }
                }
            }

            if (PreventerClient.config.preventCoralPlacing) {
                if (handItem instanceof BlockItem){
                    Block handItemBlock = ((BlockItem) handItem).getBlock();
                    if (handItemBlock instanceof CoralBlock || handItemBlock instanceof CoralBlockBlock || handItemBlock instanceof CoralFanBlock) {
                        Block targetBlock2 = world.getBlockState(blockHitResult.getBlockPos().offset(blockHitResult.getSide(), 1)).getBlock();
                        if (canNotInteractWithBlock(targetBlockState, playerEntity, hand, blockHitResult)) {
                            if (!targetBlock2.equals(Blocks.WATER)) {
                                sendActionPreventedMessage(playerEntity, Text.translatable("preventer.placing.prevented.preventCoralPlacing"));
                                return ActionResult.FAIL;
                            }
                        }
                    }
                }
            }

            if (PreventerClient.config.preventRocketUse != PreventRocketUseConfig.OFF) {
                if (!playerEntity.isGliding() && handItem instanceof FireworkRocketItem && playerEntity.getEntityWorld().isClient()) {
                    if (canNotInteractWithBlock(targetBlockState, playerEntity, hand, blockHitResult)) {
                        if ((PreventerClient.config.preventRocketUse == PreventRocketUseConfig.OFF_HAND || PreventerClient.config.preventRocketUse == PreventRocketUseConfig.BOTH)  && Hand.OFF_HAND == hand) {
                            sendActionPreventedMessage(playerEntity, Text.translatable("preventer.interactions.prevented.preventRocketUse"));
                            return ActionResult.FAIL;
                        }
                        if ((PreventerClient.config.preventRocketUse == PreventRocketUseConfig.MAIN_HAND || PreventerClient.config.preventRocketUse == PreventRocketUseConfig.BOTH) && Hand.MAIN_HAND == hand) {
                            sendActionPreventedMessage(playerEntity, Text.translatable("preventer.interactions.prevented.preventRocketUse"));
                            return ActionResult.FAIL;
                        }
                    }
                }
            }

            if (PreventerClient.config.preventRenamedItemUsing) {
                if (!(handItem.getDefaultStack().isDamageable())) {
                    if (!handItem.getDefaultStack().isIn(ItemTags.SHULKER_BOXES)) {
                        if (!playerEntity.getStackInHand(hand).getName().getString().equals(handItem.getName().getString())) {
                            if (targetBlock instanceof CakeBlock || targetBlock instanceof ComposterBlock || targetBlock instanceof CampfireBlock) {
                                sendActionPreventedMessage(playerEntity, Text.translatable("preventer.interactions.prevented.preventRenamedItemUsing"));
                                return ActionResult.FAIL;
                            } else {
                                if (canNotInteractWithBlock(targetBlockState, playerEntity, hand, blockHitResult)) {
                                    sendActionPreventedMessage(playerEntity, Text.translatable("preventer.interactions.prevented.preventRenamedItemUsing"));
                                    return ActionResult.FAIL;
                                }
                            }
                        }
                    }
                }
            }

            if (PreventerClient.config.preventNoteBlockEditing) {
                if (targetBlock instanceof NoteBlock) {
                    sendActionPreventedMessage(playerEntity, Text.translatable("preventer.interactions.prevented.preventNoteBlockEditing"));
                    return ActionResult.FAIL;
                }
            }

            if (PreventerClient.config.preventLavaPlacing) {
                if (handItem.equals(Items.LAVA_BUCKET)) {
                    if (canNotInteractWithBlock(targetBlockState, playerEntity, hand, blockHitResult)) {
                        sendActionPreventedMessage(playerEntity, Text.translatable("preventer.placing.prevented.preventLavaPlacing"));
                        return ActionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.preventRespawnAnchorUse) {
                if(targetBlock instanceof RespawnAnchorBlock) {
                    if (!world.getDimension().respawnAnchorWorks()) {
                        sendActionPreventedMessage(playerEntity, Text.translatable("preventer.interactions.prevented.preventRespawnAnchorUse"));
                        return ActionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.preventDragonEggTeleport) {
                if (targetBlock instanceof DragonEggBlock) {
                    sendActionPreventedMessage(playerEntity, Text.translatable("preventer.interactions.prevented.preventDragonEggTeleport"));
                    return ActionResult.FAIL;
                }
            }

            if (PreventerClient.config.preventOffhandPlacing) {
                if (hand == Hand.OFF_HAND && handItem != Items.AIR) {
                    if (canNotInteractWithBlock(targetBlockState, playerEntity, hand, blockHitResult)) {
                        sendActionPreventedMessage(playerEntity, Text.translatable("preventer.placing.prevented.preventOffhandPlacing"));
                        return ActionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.preventPlacingAfterEating != PreventPlacingAfterEatingConfig.OFF) {
                if (PreventerClient.ticksSinceEating <= 50) {
                    if (handItem instanceof BlockItem && canNotInteractWithBlock(targetBlockState, playerEntity, hand, blockHitResult)) {

                        if (PreventerClient.config.preventPlacingAfterEating != PreventPlacingAfterEatingConfig.TORCHES) {
                            sendActionPreventedMessage(playerEntity, Text.translatable("preventer.placing.prevented.preventPlacingAfterEating"));
                            return ActionResult.FAIL;
                        } else {
                            boolean holdingTorch = handItem.equals(Items.TORCH);
                            Text heldBlockName = Text.translatable("block.minecraft.torch").formatted(Formatting.DARK_RED);
                            if (handItem.equals(Items.LANTERN) && !holdingTorch) { //skipped if already holding torch
                                holdingTorch = handItem.equals(Items.LANTERN);
                                heldBlockName = Text.translatable("block.minecraft.lantern").formatted(Formatting.DARK_RED); //fun subtle detail :)
                            }
                            if (holdingTorch) {
                                sendActionPreventedMessage(playerEntity, Text.translatable("preventer.placing.prevented.preventTorchPlaceAfterEating", heldBlockName));
                                return ActionResult.FAIL;
                            }
                        }

                    }
                }
            }

            if (PreventerClient.config.preventGrassBonemeal) {
                if (handItem.equals(Items.BONE_MEAL)) {
                    if (targetBlock instanceof GrassBlock || targetBlock instanceof NetherrackBlock || targetBlock instanceof NyliumBlock) {
                        sendActionPreventedMessage(playerEntity, Text.translatable("preventer.interactions.prevented.preventGrassBonemeal"));
                        return ActionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.preventSignEditing) {
                if (targetBlock instanceof AbstractSignBlock) {
                    if (!PreventerClient.config.preventChestSignEditing) {
                        sendActionPreventedMessage(playerEntity, Text.translatable("preventer.interactions.prevented.preventSignEditing"));
                        return ActionResult.FAIL;
                    } else {
                        if (targetBlock instanceof WallSignBlock) {
                            Block blockBehindTargetBlock = world.getBlockState(blockHitResult.getBlockPos().offset(targetBlockState.get(HorizontalFacingBlock.FACING), -1)).getBlock();
                            if (blockBehindTargetBlock instanceof AbstractChestBlock) {
                                sendActionPreventedMessage(playerEntity, Text.translatable("preventer.interactions.prevented.preventSignEditing"));
                                return ActionResult.FAIL;
                            }
                        }
                    }
                }
            }

            if (PreventerClient.config.preventBerriePlanting) {
                if (handItem.equals(Items.SWEET_BERRIES) || handItem.equals(Items.GLOW_BERRIES)) {
                    if (canNotInteractWithBlock(targetBlockState, playerEntity, hand, blockHitResult)) {
                        sendActionPreventedMessage(playerEntity, Text.translatable("preventer.placing.prevented.preventBerriePlanting"));
                        return ActionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.preventChiseledBookshelfInteracting) {
                if (targetBlock instanceof ChiseledBookshelfBlock) {
                    sendActionPreventedMessage(playerEntity, Text.translatable("preventer.interactions.prevented.preventChiseledBookshelfInteracting"));
                    return ActionResult.FAIL;
                }
            }

            if (checkDurabilityProtection(playerEntity, hand)) return ActionResult.FAIL;
        }

        return ActionResult.PASS;
    }

    private static boolean canNotInteractWithBlock(BlockState block, PlayerEntity playerEntity, Hand hand, BlockHitResult blockHitResult) {
        if (block.isIn(BlockTags.CANDLE_CAKES) ||
                block.isOf(Blocks.CAKE) ||
                block.isOf(Blocks.REPEATER) ||
                block.isOf(Blocks.COMPARATOR)) {
            return false;
        }
        ActionResult actionResult = block.onUse(playerEntity.getEntityWorld(), playerEntity, blockHitResult);
        return !actionResult.isAccepted();
    }
}
