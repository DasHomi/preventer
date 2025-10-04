package com.dashomi.preventer.listeners;

import com.dashomi.preventer.PreventerClient;
import net.minecraft.block.*;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.registry.tag.EnchantmentTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import java.util.Objects;

import static com.dashomi.preventer.utils.ActionPreventedMessage.sendActionPreventedMessage;
import static com.dashomi.preventer.utils.DurabilityProtection.checkDurabilityProtection;

public class AttackBlockEvent {
    public static ActionResult attackBlockListener(PlayerEntity playerEntity, World world, Hand hand, BlockPos pos, Direction direction) {
        if (PreventerClient.getPrevent()) {
            Block targetBlock = world.getBlockState(pos).getBlock();
            ItemStack mainHandStack = playerEntity.getMainHandStack();

            if (PreventerClient.config.preventBreakingWithWeapon) {
                Item item = mainHandStack.getItem();
                if (mainHandStack.isIn(ItemTags.SWORDS) || item instanceof TridentItem || item instanceof MaceItem) {
                    sendActionPreventedMessage(playerEntity, Text.translatable("config.preventer.preventBreakingWithWeapon.text"));
                    return ActionResult.FAIL;
                }
            }

            if (PreventerClient.config.onlyMatureCropHarvest) {
                if (targetBlock instanceof CropBlock) {
                    if (!((CropBlock) targetBlock).isMature(world.getBlockState(pos))) {
                        sendActionPreventedMessage(playerEntity, Text.translatable("config.preventer.onlyMatureCropHarvest.text"));
                        return ActionResult.FAIL;
                    }
                }
                if (targetBlock instanceof NetherWartBlock) {
                    if (world.getBlockState(pos).get(NetherWartBlock.AGE) < 3) {
                        sendActionPreventedMessage(playerEntity, Text.translatable("config.preventer.onlyMatureCropHarvest.text"));
                        return ActionResult.FAIL;
                    }
                }
                if (targetBlock instanceof CocoaBlock) {
                    if (world.getBlockState(pos).get(CocoaBlock.AGE) < 2) {
                        sendActionPreventedMessage(playerEntity, Text.translatable("config.preventer.onlyMatureCropHarvest.text"));
                        return ActionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.preventBuddingAmethystBreaking) {
                if (targetBlock instanceof BuddingAmethystBlock) {
                    sendActionPreventedMessage(playerEntity, Text.translatable("config.preventer.preventBuddingAmethystBreaking.text"));
                    return ActionResult.FAIL;
                }
            }

            if (PreventerClient.config.preventStemBreaking) {
                if (targetBlock instanceof AttachedStemBlock || targetBlock instanceof StemBlock) {
                    sendActionPreventedMessage(playerEntity, Text.translatable("config.preventer.preventStemBreaking.text"));
                    return ActionResult.FAIL;
                }
            }

            if (PreventerClient.config.preventGlassBreaking) {
                if (targetBlock instanceof TransparentBlock || targetBlock instanceof PaneBlock) {
                    if (!Objects.equals(targetBlock.getTranslationKey(), "block.minecraft.iron_bars")) {
                        if (!(targetBlock instanceof TintedGlassBlock)) {
                            sendActionPreventedMessage(playerEntity, Text.translatable("config.preventer.preventGlassBreaking.text"));
                            return ActionResult.FAIL;
                        }
                    }
                }
            }

            if (PreventerClient.config.preventSuspiciousBlockBreaking) {
                if (targetBlock instanceof BrushableBlock) {
                    sendActionPreventedMessage(playerEntity, Text.translatable("config.preventer.preventSuspiciousBlockBreaking.text"));
                    return ActionResult.FAIL;
                } else if (PreventerClient.config.enhancedSuspiciousBlockBreakingPrevention) {
                    if (world.getBlockState(pos.offset(Direction.Axis.Y, 1)).getBlock() instanceof BrushableBlock) {
                        sendActionPreventedMessage(playerEntity, Text.translatable("config.preventer.enhancedSuspiciousBlockBreakingPrevention.text"));
                        return ActionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.preventEnderChestBreaking) {
                if (targetBlock instanceof EnderChestBlock) {
                    if (mainHandStack.isIn(ItemTags.PICKAXES)) {
                        if (!EnchantmentHelper.hasAnyEnchantmentsIn(mainHandStack, EnchantmentTags.PREVENTS_BEE_SPAWNS_WHEN_MINING)) {
                            sendActionPreventedMessage(playerEntity, Text.translatable("config.preventer.preventEnderChestBreaking.text"));
                            return ActionResult.FAIL;
                        }
                    }
                }
            }

            if (PreventerClient.config.preventSpawnerBreaking) {
                if (targetBlock instanceof SpawnerBlock) {
                    sendActionPreventedMessage(playerEntity, Text.translatable("config.preventer.preventSpawnerBreaking.text"));
                    return ActionResult.FAIL;
                }
            }

            if (PreventerClient.config.preventSugarCaneBreaking) {
                if (targetBlock instanceof SugarCaneBlock || targetBlock instanceof BambooBlock || targetBlock instanceof CactusBlock) {
                    Block block = world.getBlockState(pos.offset(Direction.Axis.Y, -1)).getBlock();
                    if (!(block instanceof SugarCaneBlock) && !(block instanceof BambooBlock) && !(block instanceof CactusBlock)) {
                        sendActionPreventedMessage(playerEntity, Text.translatable("config.preventer.preventSugarCaneBreaking.text"));
                        return ActionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.preventChestBreaking) {
                if (targetBlock instanceof ChestBlock) {
                    if (mainHandStack.isIn(ItemTags.PICKAXES)) {
                        sendActionPreventedMessage(playerEntity, Text.translatable("config.preventer.preventChestBreaking.text"));
                        return ActionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.preventCarpetBreaking) {
                if (targetBlock instanceof CarpetBlock) {
                    sendActionPreventedMessage(playerEntity, Text.translatable("config.preventer.preventCarpetBreaking.text"));
                    return ActionResult.FAIL;
                }
            }

            if (PreventerClient.config.preventSaplingBreaking) {
                if (targetBlock instanceof SaplingBlock) {
                    sendActionPreventedMessage(playerEntity, Text.translatable("config.preventer.preventSaplingBreaking.text"));
                    return ActionResult.FAIL;
                }
            }

            if (PreventerClient.config.preventImmatureAmethystBreaking) {
                if (targetBlock instanceof AmethystClusterBlock) {
                    if (!targetBlock.getTranslationKey().equals("block.minecraft.amethyst_cluster")) {
                        sendActionPreventedMessage(playerEntity, Text.translatable("config.preventer.preventImmatureAmethystBreaking.text"));
                        return ActionResult.FAIL;
                    }
                }
            }

            if (checkDurabilityProtection(playerEntity, hand)) return ActionResult.FAIL;
        }

        return ActionResult.PASS;
    }
}
