package com.dashomi.preventer.listeners;

import com.dashomi.preventer.PreventerClient;
import com.dashomi.preventer.enums.PreventSuspiciousBlockBreakingConfig;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.MaceItem;
import net.minecraft.world.item.TridentItem;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.entity.player.Player;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Objects;

import static com.dashomi.preventer.utils.ActionPreventedMessage.sendActionPreventedMessage;
import static com.dashomi.preventer.utils.DurabilityProtection.checkDurabilityProtection;

public class AttackBlockEvent {
    public static InteractionResult attackBlockListener(Player playerEntity, Level world, InteractionHand hand, BlockPos pos, Direction direction) {
        if (PreventerClient.preventerActive()) {
            BlockState blockState = world.getBlockState(pos);
            Block targetBlock = blockState.getBlock();
            ItemStack mainHandStack = playerEntity.getMainHandItem();

            if (PreventerClient.config.preventBreakingWithWeapon) {
                Item item = mainHandStack.getItem();
                if (mainHandStack.is(ItemTags.SWORDS) || item instanceof TridentItem || item instanceof MaceItem) {
                    sendActionPreventedMessage(playerEntity, Component.translatable("preventer.breaking.prevented.preventBreakingWithWeapon"));
                    return InteractionResult.FAIL;
                }
            }

            if (PreventerClient.config.preventNonMatureCropHarvesting) {
                if (targetBlock instanceof CropBlock) {
                    if (!((CropBlock) targetBlock).isMaxAge(world.getBlockState(pos))) {
                        sendActionPreventedMessage(playerEntity, Component.translatable("preventer.plants.prevented.preventNonMatureCropHarvesting"));
                        return InteractionResult.FAIL;
                    }
                }
                if (targetBlock instanceof NetherWartBlock) {
                    if (world.getBlockState(pos).getValue(NetherWartBlock.AGE) < 3) {
                        sendActionPreventedMessage(playerEntity, Component.translatable("config.preventer.onlyMatureCropHarvest.text"));
                        return InteractionResult.FAIL;
                    }
                }
                if (targetBlock instanceof CocoaBlock) {
                    if (world.getBlockState(pos).getValue(CocoaBlock.AGE) < 2) {
                        sendActionPreventedMessage(playerEntity, Component.translatable("config.preventer.onlyMatureCropHarvest.text"));
                        return InteractionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.preventBuddingAmethystBreaking) {
                if (targetBlock instanceof BuddingAmethystBlock) {
                    sendActionPreventedMessage(playerEntity, Component.translatable("preventer.breaking.prevented.preventBuddingAmethystBreaking"));
                    return InteractionResult.FAIL;
                }
            }

            if (PreventerClient.config.preventStemBreaking) {
                if (targetBlock instanceof AttachedStemBlock || targetBlock instanceof StemBlock) {
                    sendActionPreventedMessage(playerEntity, Component.translatable("preventer.plants.prevented.preventStemBreaking"));
                    return InteractionResult.FAIL;
                }
            }

            if (PreventerClient.config.preventGlassBreaking) {
                if (targetBlock instanceof TransparentBlock || targetBlock instanceof IronBarsBlock) {
                    if (!Objects.equals(targetBlock.getDescriptionId(), "block.minecraft.iron_bars")) {
                        if (!(targetBlock instanceof TintedGlassBlock)) {
                            sendActionPreventedMessage(playerEntity, Component.translatable("preventer.breaking.prevented.preventGlassBreaking"));
                            return InteractionResult.FAIL;
                        }
                    }
                }
            }

            if (PreventerClient.config.preventSuspiciousBlockBreaking != PreventSuspiciousBlockBreakingConfig.OFF) {
                if (targetBlock instanceof BrushableBlock) {
                    sendActionPreventedMessage(playerEntity, Component.translatable("preventer.breaking.prevented.preventSuspiciousBlockBreaking"));
                    return InteractionResult.FAIL;
                } else if (PreventerClient.config.preventSuspiciousBlockBreaking == PreventSuspiciousBlockBreakingConfig.ENHANCED) {
                    if (world.getBlockState(pos.relative(Direction.Axis.Y, 1)).getBlock() instanceof BrushableBlock) {
                        sendActionPreventedMessage(playerEntity, Component.translatable("preventer.breaking.prevented.enhancedSuspiciousBlockBreakingPrevention"));
                        return InteractionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.preventEnderChestBreaking) {
                if (targetBlock instanceof EnderChestBlock) {
                    if (mainHandStack.is(ItemTags.PICKAXES)) {
                        if (!EnchantmentHelper.hasTag(mainHandStack, EnchantmentTags.PREVENTS_BEE_SPAWNS_WHEN_MINING)) {
                            sendActionPreventedMessage(playerEntity, Component.translatable("preventer.breaking.prevented.preventEnderChestBreaking"));
                            return InteractionResult.FAIL;
                        }
                    }
                }
            }

            if (PreventerClient.config.preventSpawnerBreaking) {
                if (targetBlock instanceof SpawnerBlock) {
                    sendActionPreventedMessage(playerEntity, Component.translatable("preventer.breaking.prevented.preventSpawnerBreaking"));
                    return InteractionResult.FAIL;
                }
            }

            if (PreventerClient.config.preventSugarCaneBreaking) {
                if (targetBlock instanceof SugarCaneBlock || targetBlock instanceof BambooStalkBlock || targetBlock instanceof CactusBlock) {
                    Block block = world.getBlockState(pos.relative(Direction.Axis.Y, -1)).getBlock();
                    if (!(block instanceof SugarCaneBlock) && !(block instanceof BambooStalkBlock) && !(block instanceof CactusBlock)) {
                        sendActionPreventedMessage(playerEntity, Component.translatable("preventer.plants.prevented.preventSugarCaneBreaking"));
                        return InteractionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.preventChestBreaking) {
                if (targetBlock instanceof ChestBlock) {
                    if (mainHandStack.is(ItemTags.PICKAXES)) {
                        sendActionPreventedMessage(playerEntity, Component.translatable("preventer.breaking.prevented.preventChestBreaking"));
                        return InteractionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.preventCarpetBreaking) {
                if (targetBlock instanceof CarpetBlock) {
                    sendActionPreventedMessage(playerEntity, Component.translatable("preventer.breaking.prevented.preventCarpetBreaking"));
                    return InteractionResult.FAIL;
                }
            }

            if (PreventerClient.config.preventSaplingBreaking) {
                if (targetBlock instanceof SaplingBlock) {
                    sendActionPreventedMessage(playerEntity, Component.translatable("preventer.breaking.prevented.preventSaplingBreaking"));
                    return InteractionResult.FAIL;
                }
            }

            if (PreventerClient.config.preventImmatureAmethystBreaking) {
                if (targetBlock instanceof AmethystClusterBlock) {
                    if (!targetBlock.getDescriptionId().equals("block.minecraft.amethyst_cluster")) {
                        sendActionPreventedMessage(playerEntity, Component.translatable("preventer.breaking.prevented.preventImmatureAmethystBreaking"));
                        return InteractionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.preventBreakingWithoutFortune) {
                if (isOreBlock(blockState)) {
                    if (EnchantmentHelper.getItemEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FORTUNE), mainHandStack) == 0) {
                        sendActionPreventedMessage(playerEntity, Component.translatable("preventer.breaking.prevented.preventBreakingWithoutFortune"));
                        return InteractionResult.FAIL;
                    }
                }
            }

            if (checkDurabilityProtection(playerEntity, hand)) return InteractionResult.FAIL;
        }

        return InteractionResult.PASS;
    }

    private static boolean isOreBlock(BlockState blockState) {
        return blockState.is(BlockTags.COAL_ORES) ||
               blockState.is(BlockTags.DIAMOND_ORES) ||
               blockState.is(BlockTags.EMERALD_ORES) ||
               blockState.is(BlockTags.GOLD_ORES) ||
               blockState.is(BlockTags.IRON_ORES) ||
               blockState.is(BlockTags.LAPIS_ORES) ||
               blockState.is(BlockTags.REDSTONE_ORES) ||
               blockState.is(Blocks.NETHER_QUARTZ_ORE) ||
               blockState.is(Blocks.GLOWSTONE) ||
               blockState.is(Blocks.AMETHYST_CLUSTER);
    }
}
