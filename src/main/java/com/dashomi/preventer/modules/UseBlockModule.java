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

import static com.dashomi.preventer.utils.DurabilityProtection.checkDurabilityProtection;
import static net.minecraft.block.CaveVines.BERRIES;
import static net.minecraft.block.SweetBerryBushBlock.AGE;

public class UseBlockModule {
    public static ActionResult checkBlockUse(PlayerEntity playerEntity, World world, Hand hand, BlockHitResult blockHitResult) {
        if (!PreventerClient.config.overrideKeyPressed) {
            Block targetBlock = world.getBlockState(blockHitResult.getBlockPos()).getBlock();
            Item handItem = playerEntity.getStackInHand(hand).getItem();
            if (PreventerClient.config.noStrip) {
                if (handItem instanceof AxeItem) {
                    if (AxeItem.STRIPPED_BLOCKS.containsKey(targetBlock)) {
                        if (PreventerClient.config.moduleUseInfoGroup.noStrip_msg) {
                            playerEntity.sendMessage(new TranslatableText("config.preventer.noStrip.text"), true);
                        }
                        return ActionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.noPath) {
                if (handItem instanceof ShovelItem) {
                    if (ShovelItem.PATH_STATES.containsKey(targetBlock)) {
                        if (PreventerClient.config.moduleUseInfoGroup.noPath_msg) {
                            playerEntity.sendMessage(new TranslatableText("config.preventer.noPath.text"), true);
                        }
                        return ActionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.noFarmland) {
                if (handItem instanceof HoeItem) {
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
                if (handItem instanceof AxeItem) {
                    if (targetBlock instanceof Oxidizable) {
                        if (PreventerClient.config.moduleUseInfoGroup.noScraping_msg) {
                            playerEntity.sendMessage(new TranslatableText("config.preventer.noScraping.text"), true);
                        }
                        return ActionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.noDeWax) {
                if (handItem instanceof AxeItem) {
                    if (HoneycombItem.WAXED_TO_UNWAXED_BLOCKS.get().containsKey(targetBlock)) {
                        if (PreventerClient.config.moduleUseInfoGroup.noDeWax_msg) {
                            playerEntity.sendMessage(new TranslatableText("config.preventer.noDeWax.text"), true);
                        }
                        return ActionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.noCake) {
                if (targetBlock instanceof CakeBlock || targetBlock instanceof CandleCakeBlock) {
                    if (PreventerClient.config.moduleUseInfoGroup.noCake_msg) {
                        playerEntity.sendMessage(new TranslatableText("config.preventer.noCake.text"), true);
                    }
                    return ActionResult.FAIL;
                }
            }

            if (PreventerClient.config.noTrappedChestOpening) {
                if (targetBlock instanceof TrappedChestBlock) {
                    if (PreventerClient.config.moduleUseInfoGroup.noTrappedChestOpening_msg) {
                        playerEntity.sendMessage(new TranslatableText("config.preventer.noTrappedChestOpening.text"), true);
                    }
                    return ActionResult.FAIL;
                }
            }

            if (PreventerClient.config.preventBedUse) {
                if (targetBlock instanceof BedBlock) {
                    if (!world.getDimension().isBedWorking()) {
                        if (PreventerClient.config.moduleUseInfoGroup.preventBedUse_msg) {
                            playerEntity.sendMessage(new TranslatableText("config.preventer.preventBedUse.text"), true);
                        }
                        return ActionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.preventWaterPlace) {
                if (handItem.equals(Items.WATER_BUCKET)) {
                    if (world.getDimension().isUltrawarm()) {
                        if (PreventerClient.config.moduleUseInfoGroup.preventWaterPlace_msg) {
                            playerEntity.sendMessage(new TranslatableText("config.preventer.preventWaterPlace.text"), true);
                        }
                        return ActionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.preventCoralPlace) {
                if (handItem instanceof BlockItem){
                    Block handItemBlock = ((BlockItem) handItem).getBlock();
                    if (handItemBlock instanceof CoralBlock || handItemBlock instanceof CoralBlockBlock || handItemBlock instanceof CoralFanBlock) {
                        Block targetBlock2 = world.getBlockState(blockHitResult.getBlockPos().offset(blockHitResult.getSide(), 1)).getBlock();
                        if (!targetBlock2.equals(Blocks.WATER)) {
                            if (PreventerClient.config.moduleUseInfoGroup.preventCoralPlace_msg) {
                                playerEntity.sendMessage(new TranslatableText("config.preventer.preventCoralPlace.text"), true);
                            }
                            return ActionResult.FAIL;
                        }
                    }
                }
            }

            if (PreventerClient.config.preventRocketUse && !playerEntity.isSpectator()) {
                if (!playerEntity.isFallFlying()) {
                    if (PreventerClient.config.moduleConfigGroup.rocketInOffhand && playerEntity.getOffHandStack().getItem() instanceof FireworkRocketItem) {
                        if (PreventerClient.config.moduleUseInfoGroup.preventRocketUse_msg) {
                            playerEntity.sendMessage(new TranslatableText("config.preventer.preventRocketUse.text"), true);
                        }
                        return ActionResult.FAIL;
                    }
                    if (PreventerClient.config.moduleConfigGroup.rocketInMainHand && playerEntity.getMainHandStack().getItem() instanceof FireworkRocketItem) {
                        if (PreventerClient.config.moduleUseInfoGroup.preventRocketUse_msg) {
                            playerEntity.sendMessage(new TranslatableText("config.preventer.preventRocketUse.text"), true);
                        }
                        return ActionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.preventRenamedBlockPlacing) {
                if (handItem instanceof BlockItem) {
                    if (!handItem.isFood()) {
                        if (!playerEntity.getStackInHand(hand).getName().getString().equals(handItem.getName().getString())) {
                            if (PreventerClient.config.moduleUseInfoGroup.preventRenamedBlockPlacing_msg) {
                                playerEntity.sendMessage(new TranslatableText("config.preventer.preventRenamedBlockPlacing.text"), true);
                            }
                            return ActionResult.FAIL;
                        }
                    }
                }
            }

            if (checkDurabilityProtection(playerEntity, hand)) return ActionResult.FAIL;
        }

        return ActionResult.PASS;
    }
}
