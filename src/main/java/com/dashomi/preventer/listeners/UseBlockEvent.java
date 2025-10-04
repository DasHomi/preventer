package com.dashomi.preventer.listeners;

import com.dashomi.preventer.PreventerClient;
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
        if (PreventerClient.getPrevent()) {
            BlockState targetBlockState = world.getBlockState(blockHitResult.getBlockPos());
            Block targetBlock = targetBlockState.getBlock();
            Item handItem = playerEntity.getStackInHand(hand).getItem();
            if (PreventerClient.config.noStrip) {
                if (handItem instanceof AxeItem) {
                    if (AxeItem.STRIPPED_BLOCKS.containsKey(targetBlock)) {
                        sendActionPreventedMessage(playerEntity, Text.translatable("config.preventer.noStrip.text"));
                        return ActionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.noPath) {
                if (handItem instanceof ShovelItem) {
                    if (ShovelItem.PATH_STATES.containsKey(targetBlock)) {
                        sendActionPreventedMessage(playerEntity, Text.translatable("config.preventer.noPath.text"));
                        return ActionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.noFarmland) {
                if (handItem instanceof HoeItem) {
                    if (HoeItem.TILLING_ACTIONS.containsKey(targetBlock)) {
                        sendActionPreventedMessage(playerEntity, Text.translatable("config.preventer.noFarmland.text"));
                        return ActionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.noGlowBerrieHarvest) {
                if (targetBlock instanceof CaveVines) {
                    if (world.getBlockState(blockHitResult.getBlockPos()).get(BERRIES)) {
                        sendActionPreventedMessage(playerEntity, Text.translatable("config.preventer.noGlowBerrieHarvest.text"));
                        return ActionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.noSweetBerrieHarvest) {
                if (targetBlock instanceof SweetBerryBushBlock) {
                    if (world.getBlockState(blockHitResult.getBlockPos()).get(AGE) >= 2) {
                        sendActionPreventedMessage(playerEntity, Text.translatable("config.preventer.noSweetBerrieHarvest.text"));
                        return ActionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.noScraping) {
                if (handItem instanceof AxeItem) {
                    if (targetBlock instanceof Oxidizable) {
                        sendActionPreventedMessage(playerEntity, Text.translatable("config.preventer.noScraping.text"));
                        return ActionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.noDeWax) {
                if (handItem instanceof AxeItem) {
                    if (HoneycombItem.WAXED_TO_UNWAXED_BLOCKS.get().containsKey(targetBlock)) {
                        sendActionPreventedMessage(playerEntity, Text.translatable("config.preventer.noDeWax.text"));
                        return ActionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.noCake) {
                if (targetBlock instanceof CandleCakeBlock) {
                    sendActionPreventedMessage(playerEntity, Text.translatable("config.preventer.noCake.text"));
                    return ActionResult.FAIL;
                } else if (targetBlock instanceof CakeBlock) {
                    String[] itemName = String.valueOf(handItem).split("_");
                    if (!Objects.equals(itemName[itemName.length - 1], "candle")) {
                        sendActionPreventedMessage(playerEntity, Text.translatable("config.preventer.noCake.text"));
                        return ActionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.noTrappedChestOpening) {
                if (targetBlock instanceof TrappedChestBlock) {
                    sendActionPreventedMessage(playerEntity, Text.translatable("config.preventer.noTrappedChestOpening.text"));
                    return ActionResult.FAIL;
                }
            }

            if (PreventerClient.config.preventBedUse) {
                if (targetBlock instanceof BedBlock) {
                    if (!world.getDimension().bedWorks()) {
                        sendActionPreventedMessage(playerEntity, Text.translatable("config.preventer.preventBedUse.text"));
                        return ActionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.preventWaterPlace) {
                if (handItem.equals(Items.WATER_BUCKET)) {
                    if (world.getDimension().ultrawarm()) {
                        if (canNotInteractWithBlock(targetBlockState, playerEntity, hand, blockHitResult)) {
                            sendActionPreventedMessage(playerEntity, Text.translatable("config.preventer.preventWaterPlace.text"));
                            return ActionResult.FAIL;
                        }
                    }
                }
            }

            if (PreventerClient.config.preventCoralPlace) {
                if (handItem instanceof BlockItem){
                    Block handItemBlock = ((BlockItem) handItem).getBlock();
                    if (handItemBlock instanceof CoralBlock || handItemBlock instanceof CoralBlockBlock || handItemBlock instanceof CoralFanBlock) {
                        Block targetBlock2 = world.getBlockState(blockHitResult.getBlockPos().offset(blockHitResult.getSide(), 1)).getBlock();
                        if (canNotInteractWithBlock(targetBlockState, playerEntity, hand, blockHitResult)) {
                            if (!targetBlock2.equals(Blocks.WATER)) {
                                sendActionPreventedMessage(playerEntity, Text.translatable("config.preventer.preventCoralPlace.text"));
                                return ActionResult.FAIL;
                            }
                        }
                    }
                }
            }

            if (PreventerClient.config.preventRocketUse && !playerEntity.isSpectator()) {
                if (!playerEntity.isGliding() && handItem instanceof FireworkRocketItem && playerEntity.getEntityWorld().isClient()) {
                    if (canNotInteractWithBlock(targetBlockState, playerEntity, hand, blockHitResult)) {
                        if (PreventerClient.config.rocketInOffhand && Hand.OFF_HAND == hand) {
                            sendActionPreventedMessage(playerEntity, Text.translatable("config.preventer.preventRocketUse.text"));
                            return ActionResult.FAIL;
                        }
                        if (PreventerClient.config.rocketInMainHand && Hand.MAIN_HAND == hand) {
                            sendActionPreventedMessage(playerEntity, Text.translatable("config.preventer.preventRocketUse.text"));
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
                                sendActionPreventedMessage(playerEntity, Text.translatable("config.preventer.preventRenamedItemUsing.text"));
                                return ActionResult.FAIL;
                            } else {
                                if (canNotInteractWithBlock(targetBlockState, playerEntity, hand, blockHitResult)) {
                                    sendActionPreventedMessage(playerEntity, Text.translatable("config.preventer.preventRenamedItemUsing.text"));
                                    return ActionResult.FAIL;
                                }
                            }
                        }
                    }
                }
            }

            if (PreventerClient.config.preventNoteBlockEditing) {
                if (targetBlock instanceof NoteBlock) {
                    sendActionPreventedMessage(playerEntity, Text.translatable("config.preventer.preventNoteBlockEditing.text"));
                    return ActionResult.FAIL;
                }
            }

            if (PreventerClient.config.preventLavaPlacing) {
                if (handItem.equals(Items.LAVA_BUCKET)) {
                    if (canNotInteractWithBlock(targetBlockState, playerEntity, hand, blockHitResult)) {
                        sendActionPreventedMessage(playerEntity, Text.translatable("config.preventer.preventLavaPlacing.text"));
                        return ActionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.preventRespawnAnchorUse) {
                if(targetBlock instanceof RespawnAnchorBlock) {
                    if (!world.getDimension().respawnAnchorWorks()) {
                        sendActionPreventedMessage(playerEntity, Text.translatable("config.preventer.preventRespawnAnchorUse.text"));
                        return ActionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.preventDragonEggTeleport) {
                if (targetBlock instanceof DragonEggBlock) {
                    sendActionPreventedMessage(playerEntity, Text.translatable("config.preventer.preventDragonEggTeleport.text"));
                    return ActionResult.FAIL;
                }
            }

            if (PreventerClient.config.preventOffhandPlacing) {
                if (hand == Hand.OFF_HAND && handItem != Items.AIR) {
                    if (canNotInteractWithBlock(targetBlockState, playerEntity, hand, blockHitResult)) {
                        sendActionPreventedMessage(playerEntity, Text.translatable("config.preventer.preventOffhandPlacing.text"));
                        return ActionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.preventPlaceAfterEating) {
                if (PreventerClient.ticksSinceEating <= PreventerClient.config.afterEatingPreventionTicks) {
                    if (handItem instanceof BlockItem && canNotInteractWithBlock(targetBlockState, playerEntity, hand, blockHitResult)) {

                        if (!PreventerClient.config.preventTorchPlaceAfterEating) {
                            sendActionPreventedMessage(playerEntity, Text.translatable("config.preventer.preventPlaceAfterEating.text"));
                            return ActionResult.FAIL;
                        } else {
                            boolean holdingTorch = handItem.equals(Items.TORCH);
                            Text heldBlockName = Text.translatable("block.minecraft.torch").formatted(Formatting.DARK_RED);
                            if (PreventerClient.config.countLanternsAsTorches && !holdingTorch) { //skipped if already holding torch
                                holdingTorch = handItem.equals(Items.LANTERN);
                                heldBlockName = Text.translatable("block.minecraft.lantern").formatted(Formatting.DARK_RED); //fun subtle detail :)
                            }
                            if (holdingTorch) {
                                sendActionPreventedMessage(playerEntity, Text.translatable("config.preventer.preventTorchPlaceAfterEating.text", heldBlockName));
                                return ActionResult.FAIL;
                            }
                        }

                    }
                }
            }

            if (PreventerClient.config.preventGrassBonemeal) {
                if (handItem.equals(Items.BONE_MEAL)) {
                    if (targetBlock instanceof GrassBlock || targetBlock instanceof NetherrackBlock || targetBlock instanceof NyliumBlock) {
                        sendActionPreventedMessage(playerEntity, Text.translatable("config.preventer.preventGrassBonemeal.text"));
                        return ActionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.preventSignEditing) {
                if (targetBlock instanceof AbstractSignBlock) {
                    if (!PreventerClient.config.preventChestSignEditing) {
                        sendActionPreventedMessage(playerEntity, Text.translatable("config.preventer.preventSignEditing.text"));
                        return ActionResult.FAIL;
                    } else {
                        if (targetBlock instanceof WallSignBlock) {
                            Block blockBehindTargetBlock = world.getBlockState(blockHitResult.getBlockPos().offset(targetBlockState.get(HorizontalFacingBlock.FACING), -1)).getBlock();
                            if (blockBehindTargetBlock instanceof AbstractChestBlock) {
                                sendActionPreventedMessage(playerEntity, Text.translatable("config.preventer.preventSignEditing.text"));
                                return ActionResult.FAIL;
                            }
                        }
                    }
                }
            }

            if (PreventerClient.config.preventBerriePlanting) {
                if (handItem.equals(Items.SWEET_BERRIES) || handItem.equals(Items.GLOW_BERRIES)) {
                    if (canNotInteractWithBlock(targetBlockState, playerEntity, hand, blockHitResult)) {
                        sendActionPreventedMessage(playerEntity, Text.translatable("config.preventer.preventBerriePlanting.text"));
                        return ActionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.preventChiseledBookshelfInteracting) {
                if (targetBlock instanceof ChiseledBookshelfBlock) {
                    sendActionPreventedMessage(playerEntity, Text.translatable("config.preventer.preventChiseledBookshelfInteracting.text"));
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
