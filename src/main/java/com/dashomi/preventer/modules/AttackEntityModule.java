package com.dashomi.preventer.modules;

import com.dashomi.preventer.PreventerClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.decoration.EndCrystalEntity;
import net.minecraft.entity.mob.ZombifiedPiglinEntity;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class AttackEntityModule {
    public static ActionResult checkEntityAttack(PlayerEntity playerEntity, World world, Hand hand, Entity entity, @Nullable EntityHitResult result) {
        if (!PreventerClient.config.overrideKeyPressed) {
            if (PreventerClient.config.lowDurabilityProtection) {
                if (!playerEntity.isCreative() && !playerEntity.isSpectator()) {
                    ItemStack stack = playerEntity.getStackInHand(hand);
                    if (stack.isDamageable()) {
                        if (stack.getDamage() >= stack.getMaxDamage() - PreventerClient.config.moduleConfigGroup.lowDurabilityProtectionRange) {
                            if (PreventerClient.config.moduleUseInfoGroup.lowDurabilityProtection_msg) {
                                playerEntity.sendMessage(Text.translatable("config.preventer.lowDurabilityProtection.text"), true);
                            }
                            return ActionResult.FAIL;
                        }
                    }
                }
            }

            if (PreventerClient.config.preventVillagerPunch) {
                if (entity instanceof VillagerEntity) {
                    if (PreventerClient.config.moduleUseInfoGroup.preventVillagerPunch_msg) {
                        playerEntity.sendMessage(Text.translatable("config.preventer.preventVillagerPunch.text"), true);
                    }
                    return ActionResult.FAIL;
                }
            }

            if (PreventerClient.config.noZombifiedPiglinPunch) {
                if (entity instanceof ZombifiedPiglinEntity) {
                    if (PreventerClient.config.moduleUseInfoGroup.noZombifiedPiglinPunch_msg) {
                        playerEntity.sendMessage(Text.translatable("config.preventer.noZombifiedPiglinPunch.text"), true);
                    }
                    return ActionResult.FAIL;
                }
            }

            if (PreventerClient.config.preventEndCrystalHitting) {
                if (entity instanceof EndCrystalEntity) {
                    if (PreventerClient.config.moduleUseInfoGroup.preventEndCrystalHitting_msg) {
                        playerEntity.sendMessage(Text.translatable("config.preventer.preventEndCrystalHitting.text"), true);
                    }
                    return ActionResult.FAIL;
                }
            }
        }
        return ActionResult.PASS;
    }
}
