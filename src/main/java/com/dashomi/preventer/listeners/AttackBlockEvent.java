package com.dashomi.preventer.listeners;

import com.dashomi.preventer.PreventerClient;
import net.minecraft.block.*;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.PickaxeItem;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.block.GlassBlock;

import java.util.Objects;

import static com.dashomi.preventer.utils.DurabilityProtection.checkDurabilityProtection;

public class AttackBlockEvent {
    public static ActionResult attackBlockListener(PlayerEntity playerEntity, World world, Hand hand, BlockPos pos, Direction direction) {
        if (!PreventerClient.overrideKeyPressed) {
            Block targetBlock = world.getBlockState(pos).getBlock();
            if (PreventerClient.config.onlyMatureCropHarvest) {
                if (targetBlock instanceof CropBlock) {
                    if (!((CropBlock) targetBlock).isMature(world.getBlockState(pos))) {
                        if (PreventerClient.config.onlyMatureCropHarvest_msg) {
                            playerEntity.sendMessage(Text.translatable("config.preventer.onlyMatureCropHarvest.text"), true);
                        }
                        return ActionResult.FAIL;
                    }
                }
                if (targetBlock instanceof NetherWartBlock) {
                    if (world.getBlockState(pos).get(NetherWartBlock.AGE) < 3) {
                        if (PreventerClient.config.onlyMatureCropHarvest_msg) {
                            playerEntity.sendMessage(Text.translatable("config.preventer.onlyMatureCropHarvest.text"), true);
                        }
                        return ActionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.preventBuddingAmethystBreaking) {
                if (targetBlock instanceof BuddingAmethystBlock) {
                    if (PreventerClient.config.preventBuddingAmethystBreaking_msg) {
                        playerEntity.sendMessage(Text.translatable("config.preventer.preventBuddingAmethystBreaking.text"), true);
                    }
                    return ActionResult.FAIL;
                }
            }

            if (PreventerClient.config.preventStemBreaking) {
                if (targetBlock instanceof AttachedStemBlock || targetBlock instanceof StemBlock) {
                    if (PreventerClient.config.preventStemBreaking_msg) {
                        playerEntity.sendMessage(Text.translatable("config.preventer.preventStemBreaking.text"), true);
                    }
                    return ActionResult.FAIL;
                }
            }

            if (PreventerClient.config.preventGlassBreaking) {
                if (targetBlock instanceof GlassBlock || targetBlock instanceof StainedGlassBlock || targetBlock instanceof PaneBlock || targetBlock instanceof TintedGlassBlock) {
                    if (!Objects.equals(targetBlock.getTranslationKey(), "block.minecraft.iron_bars")) {
                        if (PreventerClient.config.preventGlassBreaking_msg) {
                            playerEntity.sendMessage(Text.translatable("config.preventer.preventGlassBreaking.text"), true);
                        }
                        return ActionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.preventSuspiciousBlockBreaking) {
                if (targetBlock instanceof BrushableBlock) {
                    if (PreventerClient.config.preventSuspiciousBlockBreaking_msg) {
                        playerEntity.sendMessage(Text.translatable("config.preventer.preventSuspiciousBlockBreaking.text"), true);
                    }
                    return ActionResult.FAIL;
                } else if (PreventerClient.config.enhancedSuspiciousBlockBreakingPrevention) {
                    if (world.getBlockState(pos.offset(Direction.Axis.Y, 1)).getBlock() instanceof BrushableBlock) {
                        if (PreventerClient.config.preventSuspiciousBlockBreaking_msg) {
                            playerEntity.sendMessage(Text.translatable("config.preventer.enhancedSuspiciousBlockBreakingPrevention.text"), true);
                        }
                        return ActionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.preventEnderChestBreaking) {
                if (targetBlock instanceof EnderChestBlock) {
                    if (playerEntity.getMainHandStack().getItem() instanceof PickaxeItem) {
                        if (EnchantmentHelper.getLevel(Enchantments.SILK_TOUCH, playerEntity.getMainHandStack()) == 0) {
                            if (PreventerClient.config.preventEnderChestBreaking_msg) {
                                playerEntity.sendMessage(Text.translatable("config.preventer.preventEnderChestBreaking.text"), true);
                            }
                            return ActionResult.FAIL;
                        }
                    }
                }
            }

            if (PreventerClient.config.preventSpawnerBreaking) {
                if (targetBlock instanceof SpawnerBlock) {
                    if (PreventerClient.config.preventSpawnerBreaking_msg) {
                        playerEntity.sendMessage(Text.translatable("config.preventer.preventSpawnerBreaking.text"), true);
                    }
                    return ActionResult.FAIL;
                }
            }

            if (PreventerClient.config.preventSugarCaneBreaking) {
                if (targetBlock instanceof SugarCaneBlock || targetBlock instanceof BambooBlock || targetBlock instanceof CactusBlock) {
                    Block block = world.getBlockState(pos.offset(Direction.Axis.Y, -1)).getBlock();
                    if (!(block instanceof SugarCaneBlock) && !(block instanceof BambooBlock) && !(block instanceof CactusBlock)) {
                        if (PreventerClient.config.preventSugarCaneBreaking_msg) {
                            playerEntity.sendMessage(Text.translatable("config.preventer.preventSugarCaneBreaking.text"), true);
                        }
                        return ActionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.preventChestBreaking) {
                if (targetBlock instanceof ChestBlock) {
                    if (playerEntity.getMainHandStack().getItem() instanceof AxeItem) {
                        if (PreventerClient.config.preventChestBreaking_msg) {
                            playerEntity.sendMessage(Text.translatable("config.preventer.preventChestBreaking.text"), true);
                        }
                        return ActionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.preventCarpetBreaking) {
                if (targetBlock instanceof CarpetBlock) {
                    if (PreventerClient.config.preventCarpetBreaking_msg) {
                        playerEntity.sendMessage(Text.translatable("config.preventer.preventCarpetBreaking.text"), true);
                    }
                    return ActionResult.FAIL;
                }
            }

            if (checkDurabilityProtection(playerEntity, hand)) return ActionResult.FAIL;
        }

        return ActionResult.PASS;
    }
}
