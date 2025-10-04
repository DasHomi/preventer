package com.dashomi.preventer.listeners;

import com.dashomi.preventer.PreventerClient;
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
            if (PreventerClient.config.preventVillagerPunch) {
                if (entity instanceof VillagerEntity) {
                    sendActionPreventedMessage(playerEntity, Text.translatable("config.preventer.preventVillagerPunch.text"));
                    return ActionResult.FAIL;
                }
            }

            if (PreventerClient.config.noZombifiedPiglinPunch) {
                if (entity instanceof ZombifiedPiglinEntity) {
                    sendActionPreventedMessage(playerEntity, Text.translatable("config.preventer.noZombifiedPiglinPunch.text"));
                    return ActionResult.FAIL;

                }
            }

            if (PreventerClient.config.preventEndCrystalHitting) {
                if (entity instanceof EndCrystalEntity) {
                    sendActionPreventedMessage(playerEntity, Text.translatable("config.preventer.preventEndCrystalHitting.text"));
                    return ActionResult.FAIL;
                }
            }

            if (PreventerClient.config.preventItemFrameBreaking) {
                if (entity instanceof ItemFrameEntity) {
                    sendActionPreventedMessage(playerEntity, Text.translatable("config.preventer.preventItemFrameBreaking.text"));
                    return ActionResult.FAIL;
                }
            }

            if (PreventerClient.config.preventPaintingBreaking) {
                if (entity instanceof PaintingEntity) {
                    sendActionPreventedMessage(playerEntity, Text.translatable("config.preventer.preventPaintingBreaking.text"));
                    return ActionResult.FAIL;
                }
            }

            if (PreventerClient.config.preventGolemAttacking) {
                if (entity instanceof GolemEntity) {
                    if (!(entity instanceof ShulkerEntity)) {
                        sendActionPreventedMessage(playerEntity, Text.translatable("config.preventer.preventGolemAttacking.text"));
                        return ActionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.preventNamedMobAttacking) {
                if (entity.hasCustomName()) {
                    sendActionPreventedMessage(playerEntity, Text.translatable("config.preventer.preventNamedMobAttacking.text"));
                    return ActionResult.FAIL;
                }
            }

            if (PreventerClient.config.preventTamedMobAttacking) {
                if (entity instanceof TameableEntity) {
                    if (((TameableEntity) entity).isTamed()) {
                        sendActionPreventedMessage(playerEntity, Text.translatable("config.preventer.preventTamedMobAttacking.text"));
                        return ActionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.preventRareMobAttacking) {
                if (entity instanceof AxolotlEntity || entity instanceof ParrotEntity || entity instanceof AllayEntity) {
                    sendActionPreventedMessage(playerEntity, Text.translatable("config.preventer.preventRareMobAttacking.text"));
                    return ActionResult.FAIL;
                }
            }

            if (PreventerClient.config.preventHorseAttacking) {
                if (entity instanceof AbstractHorseEntity) {
                    sendActionPreventedMessage(playerEntity, Text.translatable("config.preventer.preventHorseAttacking.text"));
                    return ActionResult.FAIL;
                }
            }

            if (PreventerClient.config.preventNeutralMobAttacking) {
                if (PreventerClient.config.fullNeutralMobAttackingPrevention) {
                    if (isNeutralMob(entity) || entity instanceof SpiderEntity || entity instanceof EndermanEntity) {
                        sendActionPreventedMessage(playerEntity, Text.translatable("config.preventer.preventNeutralMobAttacking.text"));
                        return ActionResult.FAIL;
                    }
                } else {
                    if (isNeutralMob(entity) && (!(entity instanceof PiglinEntity)
                            || !PreventerClient.config.neutralMobAttackingPiglinException)) {
                        sendActionPreventedMessage(playerEntity, Text.translatable("config.preventer.preventNeutralMobAttacking.text"));
                        return ActionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.preventDolphinAttacking) {
                if (entity instanceof DolphinEntity) {
                    sendActionPreventedMessage(playerEntity, Text.translatable("config.preventer.preventDolphinAttacking.text"));
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
