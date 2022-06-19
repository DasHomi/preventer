package com.dashomi.preventer.modules;

import com.dashomi.preventer.PreventerClient;
import net.minecraft.block.Block;
import net.minecraft.block.CropBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class BreakBlockModule {
    public static ActionResult checkBlockBreak(PlayerEntity playerEntity, World world, Hand hand, BlockPos pos, Direction direction) {
        Block targetBlock = world.getBlockState(pos).getBlock();
        if (PreventerClient.config.onlyMatureCropHarvest) {
            if (targetBlock instanceof CropBlock) {
                if (!((CropBlock) targetBlock).isMature(world.getBlockState(pos))) {
                    if (PreventerClient.config.moduleUseInfoGroup.onlyMatureCropHarvest_msg) {
                        playerEntity.sendMessage(Text.translatable("config.preventer.onlyMatureCropHarvest.text"), true);
                    }
                    return ActionResult.FAIL;
                }
            }
        }

        if (PreventerClient.config.lowDurabilityProtection) {
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

        return ActionResult.PASS;
    }
}
