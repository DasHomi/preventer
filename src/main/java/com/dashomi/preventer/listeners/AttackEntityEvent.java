package com.dashomi.preventer.listeners;

import com.dashomi.preventer.PreventerClient;
import com.dashomi.preventer.enums.PreventNeutralMobAttackingConfig;
import net.minecraft.entity.Entity;
import net.minecraft.entity.decoration.EndCrystalEntity;
import net.minecraft.entity.decoration.ItemFrameEntity;
import net.minecraft.entity.decoration.painting.PaintingEntity;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import static com.dashomi.preventer.utils.ActionPreventedMessage.sendActionPreventedMessage;
import static com.dashomi.preventer.utils.DurabilityProtection.checkDurabilityProtection;

public class AttackEntityEvent {
    public static ActionResult attackEntityListener(PlayerEntity playerEntity, World world, Hand hand, Entity entity, @Nullable EntityHitResult result) {
        if (PreventerClient.getPrevent()) {
            if (PreventerClient.config.preventVillagerPunching) {
                if (entity instanceof VillagerEntity) {
                    sendActionPreventedMessage(playerEntity, Text.translatable("preventer.attacking.prevented.preventVillagerPunching"));
                    return ActionResult.FAIL;
                }
            }

            if (PreventerClient.config.preventZombifiedPiglinPunching) {
                if (entity instanceof ZombifiedPiglinEntity) {
                    sendActionPreventedMessage(playerEntity, Text.translatable("preventer.attacking.prevented.preventZombifiedPiglinPunching"));
                    return ActionResult.FAIL;

                }
            }

            if (PreventerClient.config.preventEndCrystalHitting) {
                if (entity instanceof EndCrystalEntity) {
                    sendActionPreventedMessage(playerEntity, Text.translatable("preventer.attacking.prevented.preventEndCrystalHitting"));
                    return ActionResult.FAIL;
                }
            }

            if (PreventerClient.config.preventItemFrameBreaking) {
                if (entity instanceof ItemFrameEntity) {
                    sendActionPreventedMessage(playerEntity, Text.translatable("preventer.breaking.prevented.preventItemFrameBreaking"));
                    return ActionResult.FAIL;
                }
            }

            if (PreventerClient.config.preventPaintingBreaking) {
                if (entity instanceof PaintingEntity) {
                    sendActionPreventedMessage(playerEntity, Text.translatable("preventer.breaking.prevented.preventPaintingBreaking"));
                    return ActionResult.FAIL;
                }
            }

            if (PreventerClient.config.preventGolemAttacking) {
                if (entity instanceof GolemEntity) {
                    if (!(entity instanceof ShulkerEntity)) {
                        sendActionPreventedMessage(playerEntity, Text.translatable("preventer.attacking.prevented.preventGolemAttacking"));
                        return ActionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.preventNamedMobAttacking) {
                if (entity.hasCustomName()) {
                    sendActionPreventedMessage(playerEntity, Text.translatable("preventer.attacking.prevented.preventNamedMobAttacking"));
                    return ActionResult.FAIL;
                }
            }

            if (PreventerClient.config.preventTamedMobAttacking) {
                if (entity instanceof TameableEntity) {
                    if (((TameableEntity) entity).isTamed()) {
                        sendActionPreventedMessage(playerEntity, Text.translatable("preventer.attacking.prevented.preventTamedMobAttacking"));
                        return ActionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.preventRareMobAttacking) {
                if (entity instanceof AxolotlEntity || entity instanceof ParrotEntity || entity instanceof AllayEntity) {
                    sendActionPreventedMessage(playerEntity, Text.translatable("preventer.attacking.prevented.preventRareMobAttacking"));
                    return ActionResult.FAIL;
                }
            }

            if (PreventerClient.config.preventHorseAttacking) {
                if (entity instanceof AbstractHorseEntity) {
                    sendActionPreventedMessage(playerEntity, Text.translatable("preventer.attacking.prevented.preventHorseAttacking"));
                    return ActionResult.FAIL;
                }
            }

            if (PreventerClient.config.preventNeutralMobAttacking != PreventNeutralMobAttackingConfig.OFF) {
                if (PreventerClient.config.preventNeutralMobAttacking == PreventNeutralMobAttackingConfig.FULL && !(entity instanceof PiglinEntity)) {
                    if (isNeutralMob(entity) || entity instanceof SpiderEntity || entity instanceof EndermanEntity) {
                        sendActionPreventedMessage(playerEntity, Text.translatable("preventer.attacking.prevented.preventNeutralMobAttacking"));
                        return ActionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.preventDolphinAttacking) {
                if (entity instanceof DolphinEntity) {
                    sendActionPreventedMessage(playerEntity, Text.translatable("preventer.attacking.prevented.preventDolphinAttacking"));
                    return ActionResult.FAIL;
                }
            }

            if (checkDurabilityProtection(playerEntity, hand)) return ActionResult.FAIL;
        }

        return ActionResult.PASS;
    }

    private static boolean isNeutralMob(Entity entity) {
        return (
                    entity instanceof BeeEntity ||
                    entity instanceof DolphinEntity ||
                    entity instanceof GoatEntity ||
                    entity instanceof IronGolemEntity ||
                    entity instanceof LlamaEntity ||
                    entity instanceof PandaEntity ||
                    entity instanceof PiglinEntity ||
                    entity instanceof PolarBearEntity ||
                    entity instanceof WolfEntity ||
                    entity instanceof ZombifiedPiglinEntity ||
                    entity instanceof FoxEntity
                );
    }
}
