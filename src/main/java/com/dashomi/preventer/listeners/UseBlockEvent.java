package com.dashomi.preventer.listeners;

import com.dashomi.preventer.PreventerClient;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.world.World;

import java.util.Objects;

import static com.dashomi.preventer.utils.DurabilityProtection.checkDurabilityProtection;
import static net.minecraft.block.CaveVines.BERRIES;
import static net.minecraft.block.SweetBerryBushBlock.AGE;

public class UseBlockEvent {
    public static ActionResult useBlockListener(PlayerEntity playerEntity, World world, Hand hand, BlockHitResult blockHitResult) {
        if (!PreventerClient.overrideKeyPressed) {
            BlockState targetBlockState = world.getBlockState(blockHitResult.getBlockPos());
            Block targetBlock = targetBlockState.getBlock();
            Item handItem = playerEntity.getStackInHand(hand).getItem();
            if (PreventerClient.config.noStrip) {
                if (handItem instanceof AxeItem) {
                    if (AxeItem.STRIPPED_BLOCKS.containsKey(targetBlock)) {
                        if (PreventerClient.config.noStrip_msg) {
                            playerEntity.sendMessage(Text.translatable("config.preventer.noStrip.text"), true);
                        }
                        return ActionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.noPath) {
                if (handItem instanceof ShovelItem) {
                    if (ShovelItem.PATH_STATES.containsKey(targetBlock)) {
                        if (PreventerClient.config.noPath_msg) {
                            playerEntity.sendMessage(Text.translatable("config.preventer.noPath.text"), true);
                        }
                        return ActionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.noFarmland) {
                if (handItem instanceof HoeItem) {
                    if (HoeItem.TILLING_ACTIONS.containsKey(targetBlock)) {
                        if (PreventerClient.config.noFarmland_msg) {
                            playerEntity.sendMessage(Text.translatable("config.preventer.noFarmland.text"), true);
                        }
                        return ActionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.noGlowBerrieHarvest) {
                if (targetBlock instanceof CaveVines) {
                    if (world.getBlockState(blockHitResult.getBlockPos()).get(BERRIES)) {
                        if (PreventerClient.config.noGlowBerrieHarvest_msg) {
                            playerEntity.sendMessage(Text.translatable("config.preventer.noGlowBerrieHarvest.text"), true);
                        }
                        return ActionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.noSweetBerrieHarvest) {
                if (targetBlock instanceof SweetBerryBushBlock) {
                    if (world.getBlockState(blockHitResult.getBlockPos()).get(AGE) >= 2) {
                        if (PreventerClient.config.noSweetBerrieHarvest_msg) {
                            playerEntity.sendMessage(Text.translatable("config.preventer.noSweetBerrieHarvest.text"), true);
                        }
                        return ActionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.noScraping) {
                if (handItem instanceof AxeItem) {
                    if (targetBlock instanceof Oxidizable) {
                        if (PreventerClient.config.noScraping_msg) {
                            playerEntity.sendMessage(Text.translatable("config.preventer.noScraping.text"), true);
                        }
                        return ActionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.noDeWax) {
                if (handItem instanceof AxeItem) {
                    if (HoneycombItem.WAXED_TO_UNWAXED_BLOCKS.get().containsKey(targetBlock)) {
                        if (PreventerClient.config.noDeWax_msg) {
                            playerEntity.sendMessage(Text.translatable("config.preventer.noDeWax.text"), true);
                        }
                        return ActionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.noCake) {
                if (targetBlock instanceof CandleCakeBlock) {
                    if (PreventerClient.config.noCake_msg) {
                        playerEntity.sendMessage(Text.translatable("config.preventer.noCake.text"), true);
                    }
                    return ActionResult.FAIL;
                } else if (targetBlock instanceof CakeBlock) {
                    String[] itemName = String.valueOf(handItem).split("_");
                    if (!Objects.equals(itemName[itemName.length - 1], "candle")) {
                        if (PreventerClient.config.noCake_msg) {
                            playerEntity.sendMessage(Text.translatable("config.preventer.noCake.text"), true);
                        }
                        return ActionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.noTrappedChestOpening) {
                if (targetBlock instanceof TrappedChestBlock) {
                    if (PreventerClient.config.noTrappedChestOpening_msg) {
                        playerEntity.sendMessage(Text.translatable("config.preventer.noTrappedChestOpening.text"), true);
                    }
                    return ActionResult.FAIL;
                }
            }

            if (PreventerClient.config.preventBedUse) {
                if (targetBlock instanceof BedBlock) {
                    if (!world.getDimension().bedWorks()) {
                        if (PreventerClient.config.preventBedUse_msg) {
                            playerEntity.sendMessage(Text.translatable("config.preventer.preventBedUse.text"), true);
                        }
                        return ActionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.preventWaterPlace) {
                if (handItem.equals(Items.WATER_BUCKET)) {
                    if (world.getDimension().ultrawarm()) {
                        if (canNotInteractWithBlock(targetBlockState, playerEntity, hand, blockHitResult)) {
                            if (PreventerClient.config.preventWaterPlace_msg) {
                                playerEntity.sendMessage(Text.translatable("config.preventer.preventWaterPlace.text"), true);
                            }
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
                                if (PreventerClient.config.preventCoralPlace_msg) {
                                    playerEntity.sendMessage(Text.translatable("config.preventer.preventCoralPlace.text"), true);
                                }
                                return ActionResult.FAIL;
                            }
                        }
                    }
                }
            }

            if (PreventerClient.config.preventRocketUse && !playerEntity.isSpectator()) {
                if (!playerEntity.isFallFlying() && handItem instanceof FireworkRocketItem && playerEntity.getWorld().isClient) {
                    if (canNotInteractWithBlock(targetBlockState, playerEntity, hand, blockHitResult)) {
                        if (PreventerClient.config.rocketInOffhand && Hand.OFF_HAND == hand) {
                            if (PreventerClient.config.preventRocketUse_msg) {
                                playerEntity.sendMessage(Text.translatable("config.preventer.preventRocketUse.text"), true);
                            }
                            return ActionResult.FAIL;
                        }
                        if (PreventerClient.config.rocketInMainHand && Hand.MAIN_HAND == hand) {
                            if (PreventerClient.config.preventRocketUse_msg) {
                                playerEntity.sendMessage(Text.translatable("config.preventer.preventRocketUse.text"), true);
                            }
                            return ActionResult.FAIL;
                        }
                    }
                }
            }

            if (PreventerClient.config.preventRenamedItemUsing) {
                if (!(handItem.getDefaultStack().isDamageable())) {
                    if (!isShulkerBox(handItem)) {
                        if (!playerEntity.getStackInHand(hand).getName().getString().equals(handItem.getName().getString())) {
                            if (targetBlock instanceof CakeBlock || targetBlock instanceof ComposterBlock || targetBlock instanceof CampfireBlock) {
                                if (PreventerClient.config.preventRenamedItemUsing_msg) {
                                    playerEntity.sendMessage(Text.translatable("config.preventer.preventRenamedItemUsing.text"), true);
                                }
                                return ActionResult.FAIL;
                            } else {
                                if (canNotInteractWithBlock(targetBlockState, playerEntity, hand, blockHitResult)) {
                                    if (PreventerClient.config.preventRenamedItemUsing_msg) {
                                        playerEntity.sendMessage(Text.translatable("config.preventer.preventRenamedItemUsing.text"), true);
                                    }
                                    return ActionResult.FAIL;
                                }
                            }
                        }
                    }
                }
            }

            if (PreventerClient.config.preventNoteBlockEditing) {
                if (targetBlock instanceof NoteBlock) {
                    if (PreventerClient.config.preventNoteBlockEditing_msg) {
                        playerEntity.sendMessage(Text.translatable("config.preventer.preventNoteBlockEditing.text"), true);
                    }
                    return ActionResult.FAIL;
                }
            }

            if (PreventerClient.config.preventLavaPlacing) {
                if (handItem.equals(Items.LAVA_BUCKET)) {
                    if (canNotInteractWithBlock(targetBlockState, playerEntity, hand, blockHitResult)) {
                        if (PreventerClient.config.preventLavaPlacing_msg) {
                            playerEntity.sendMessage(Text.translatable("config.preventer.preventLavaPlacing.text"), true);
                        }
                        return ActionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.preventRespawnAnchorUse) {
                if(targetBlock instanceof RespawnAnchorBlock) {
                    if (!world.getDimension().respawnAnchorWorks()) {
                        if (PreventerClient.config.preventRespawnAnchorUse_msg) {
                            playerEntity.sendMessage(Text.translatable("config.preventer.preventRespawnAnchorUse.text"), true);
                        }
                        return ActionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.preventDragonEggTeleport) {
                if (targetBlock instanceof DragonEggBlock) {
                    if (PreventerClient.config.preventDragonEggTeleport_msg) {
                        playerEntity.sendMessage(Text.translatable("config.preventer.preventDragonEggTeleport.text"), true);
                    }
                    return ActionResult.FAIL;
                }
            }

            if (PreventerClient.config.preventOffhandPlacing) {
                if (hand == Hand.OFF_HAND && handItem != Items.AIR) {
                    if (canNotInteractWithBlock(targetBlockState, playerEntity, hand, blockHitResult)) {
                        if (PreventerClient.config.preventOffhandPlacing_msg) {
                            playerEntity.sendMessage(Text.translatable("config.preventer.preventOffhandPlacing.text"), true);
                        }
                        return ActionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.preventGrassBonemeal) {
                if (handItem.equals(Items.BONE_MEAL)) {
                    if (targetBlock instanceof GrassBlock) {
                        if (PreventerClient.config.preventGrassBonemeal_msg) {
                            playerEntity.sendMessage(Text.translatable("config.preventer.preventGrassBonemeal.text"), true);
                        }
                        return ActionResult.FAIL;
                    }
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
        ActionResult actionResult = block.onUse(playerEntity.getWorld(), playerEntity, blockHitResult);
        return !actionResult.isAccepted();
    }

    private static boolean isShulkerBox(Item handItem) {
        if (handItem instanceof BlockItem) {
            return ((BlockItem) handItem).getBlock() instanceof ShulkerBoxBlock;
        }
        return false;
    }
}
