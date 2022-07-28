package com.dashomi.preventer.modules;

import com.dashomi.preventer.PreventerClient;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

import java.util.Arrays;
import java.util.List;

import static net.minecraft.block.Block.hasTopRim;
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
                            playerEntity.sendMessage(Text.translatable("config.preventer.noStrip.text"), true);
                        }
                        return ActionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.noPath) {
                if (handItem instanceof ShovelItem) {
                    if (ShovelItem.PATH_STATES.containsKey(targetBlock)) {
                        if (PreventerClient.config.moduleUseInfoGroup.noPath_msg) {
                            playerEntity.sendMessage(Text.translatable("config.preventer.noPath.text"), true);
                        }
                        return ActionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.noFarmland) {
                if (handItem instanceof HoeItem) {
                    if (HoeItem.TILLING_ACTIONS.containsKey(targetBlock)) {
                        if (PreventerClient.config.moduleUseInfoGroup.noFarmland_msg) {
                            playerEntity.sendMessage(Text.translatable("config.preventer.noFarmland.text"), true);
                        }
                        return ActionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.noGlowBerrieHarvest) {
                if (targetBlock instanceof CaveVines) {
                    if (world.getBlockState(blockHitResult.getBlockPos()).get(BERRIES)) {
                        if (PreventerClient.config.moduleUseInfoGroup.noGlowBerrieHarvest_msg) {
                            playerEntity.sendMessage(Text.translatable("config.preventer.noGlowBerrieHarvest.text"), true);
                        }
                        return ActionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.noSweetBerrieHarvest) {
                if (targetBlock instanceof SweetBerryBushBlock) {
                    if (world.getBlockState(blockHitResult.getBlockPos()).get(AGE) >= 2) {
                        if (PreventerClient.config.moduleUseInfoGroup.noSweetBerrieHarvest_msg) {
                            playerEntity.sendMessage(Text.translatable("config.preventer.noSweetBerrieHarvest.text"), true);
                        }
                        return ActionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.noScraping) {
                if (handItem instanceof AxeItem) {
                    if (targetBlock instanceof Oxidizable) {
                        if (PreventerClient.config.moduleUseInfoGroup.noScraping_msg) {
                            playerEntity.sendMessage(Text.translatable("config.preventer.noScraping.text"), true);
                        }
                        return ActionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.noDeWax) {
                if (handItem instanceof AxeItem) {
                    if (HoneycombItem.WAXED_TO_UNWAXED_BLOCKS.get().containsKey(targetBlock)) {
                        if (PreventerClient.config.moduleUseInfoGroup.noDeWax_msg) {
                            playerEntity.sendMessage(Text.translatable("config.preventer.noDeWax.text"), true);
                        }
                        return ActionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.noCake) {
                if (targetBlock instanceof CakeBlock || targetBlock instanceof CandleCakeBlock) {
                    if (PreventerClient.config.moduleUseInfoGroup.noCake_msg) {
                        playerEntity.sendMessage(Text.translatable("config.preventer.noCake.text"), true);
                    }
                    return ActionResult.FAIL;
                }
            }

            if (PreventerClient.config.noTrappedChestOpening) {
                if (targetBlock instanceof TrappedChestBlock) {
                    if (PreventerClient.config.moduleUseInfoGroup.noTrappedChestOpening_msg) {
                        playerEntity.sendMessage(Text.translatable("config.preventer.noTrappedChestOpening.text"), true);
                    }
                    return ActionResult.FAIL;
                }
            }

            if (PreventerClient.config.preventBedUse) {
                if (targetBlock instanceof BedBlock) {
                    if (!world.getDimension().bedWorks()) {
                        if (PreventerClient.config.moduleUseInfoGroup.preventBedUse_msg) {
                            playerEntity.sendMessage(Text.translatable("config.preventer.preventBedUse.text"), true);
                        }
                        return ActionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.preventWaterPlace) {
                if (handItem.equals(Items.WATER_BUCKET)) {
                    if (world.getDimension().ultrawarm()) {
                        if (PreventerClient.config.moduleUseInfoGroup.preventWaterPlace_msg) {
                            playerEntity.sendMessage(Text.translatable("config.preventer.preventWaterPlace.text"), true);
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
                                playerEntity.sendMessage(Text.translatable("config.preventer.preventCoralPlace.text"), true);
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
                            playerEntity.sendMessage(Text.translatable("config.preventer.preventRocketUse.text"), true);
                        }
                        return ActionResult.FAIL;
                    }
                    if (PreventerClient.config.moduleConfigGroup.rocketInMainHand && playerEntity.getMainHandStack().getItem() instanceof FireworkRocketItem) {
                        if (PreventerClient.config.moduleUseInfoGroup.preventRocketUse_msg) {
                            playerEntity.sendMessage(Text.translatable("config.preventer.preventRocketUse.text"), true);
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
                                playerEntity.sendMessage(Text.translatable("config.preventer.lowDurabilityProtection.text"), true);
                            }
                            return ActionResult.FAIL;
                        }
                    }
                }
            }
        }

        return ActionResult.PASS;
    }
}
