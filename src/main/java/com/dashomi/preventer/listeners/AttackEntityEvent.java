package com.dashomi.preventer.listeners;

import com.dashomi.preventer.PreventerClient;
import com.dashomi.preventer.enums.PreventNeutralMobAttackingConfig;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.animal.allay.Allay;
import net.minecraft.world.entity.animal.axolotl.Axolotl;
import net.minecraft.world.entity.animal.bee.Bee;
import net.minecraft.world.entity.animal.dolphin.Dolphin;
import net.minecraft.world.entity.animal.equine.AbstractHorse;
import net.minecraft.world.entity.animal.equine.Llama;
import net.minecraft.world.entity.animal.fox.Fox;
import net.minecraft.world.entity.animal.goat.Goat;
import net.minecraft.world.entity.animal.golem.AbstractGolem;
import net.minecraft.world.entity.animal.golem.IronGolem;
import net.minecraft.world.entity.animal.panda.Panda;
import net.minecraft.world.entity.animal.parrot.Parrot;
import net.minecraft.world.entity.animal.polarbear.PolarBear;
import net.minecraft.world.entity.animal.wolf.Wolf;
import net.minecraft.world.entity.boss.enderdragon.EndCrystal;
import net.minecraft.world.entity.decoration.ItemFrame;
import net.minecraft.world.entity.decoration.painting.Painting;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.monster.Shulker;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.entity.monster.spider.Spider;
import net.minecraft.world.entity.monster.zombie.ZombifiedPiglin;
import net.minecraft.world.entity.npc.villager.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import static com.dashomi.preventer.utils.ActionPreventedMessage.sendActionPreventedMessage;
import static com.dashomi.preventer.utils.DurabilityProtection.checkDurabilityProtection;

public class AttackEntityEvent {
    public static InteractionResult attackEntityListener(Player playerEntity, Level world, InteractionHand hand, Entity entity, @Nullable EntityHitResult result) {
        if (PreventerClient.preventerActive()) {
            if (PreventerClient.config.preventVillagerPunching) {
                if (entity instanceof Villager) {
                    sendActionPreventedMessage(playerEntity, Component.translatable("preventer.attacking.prevented.preventVillagerPunching"));
                    return InteractionResult.FAIL;
                }
            }

            if (PreventerClient.config.preventZombifiedPiglinPunching) {
                if (entity instanceof ZombifiedPiglin) {
                    sendActionPreventedMessage(playerEntity, Component.translatable("preventer.attacking.prevented.preventZombifiedPiglinPunching"));
                    return InteractionResult.FAIL;

                }
            }

            if (PreventerClient.config.preventEndCrystalHitting) {
                if (entity instanceof EndCrystal) {
                    sendActionPreventedMessage(playerEntity, Component.translatable("preventer.attacking.prevented.preventEndCrystalHitting"));
                    return InteractionResult.FAIL;
                }
            }

            if (PreventerClient.config.preventItemFrameBreaking) {
                if (entity instanceof ItemFrame) {
                    sendActionPreventedMessage(playerEntity, Component.translatable("preventer.breaking.prevented.preventItemFrameBreaking"));
                    return InteractionResult.FAIL;
                }
            }

            if (PreventerClient.config.preventPaintingBreaking) {
                if (entity instanceof Painting) {
                    sendActionPreventedMessage(playerEntity, Component.translatable("preventer.breaking.prevented.preventPaintingBreaking"));
                    return InteractionResult.FAIL;
                }
            }

            if (PreventerClient.config.preventGolemAttacking) {
                if (entity instanceof AbstractGolem) {
                    if (!(entity instanceof Shulker)) {
                        sendActionPreventedMessage(playerEntity, Component.translatable("preventer.attacking.prevented.preventGolemAttacking"));
                        return InteractionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.preventNamedMobAttacking) {
                if (entity.hasCustomName()) {
                    sendActionPreventedMessage(playerEntity, Component.translatable("preventer.attacking.prevented.preventNamedMobAttacking"));
                    return InteractionResult.FAIL;
                }
            }

            if (PreventerClient.config.preventTamedMobAttacking) {
                if (entity instanceof TamableAnimal) {
                    if (((TamableAnimal) entity).isTame()) {
                        sendActionPreventedMessage(playerEntity, Component.translatable("preventer.attacking.prevented.preventTamedMobAttacking"));
                        return InteractionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.preventRareMobAttacking) {
                if (entity instanceof Axolotl || entity instanceof Parrot || entity instanceof Allay) {
                    sendActionPreventedMessage(playerEntity, Component.translatable("preventer.attacking.prevented.preventRareMobAttacking"));
                    return InteractionResult.FAIL;
                }
            }

            if (PreventerClient.config.preventHorseAttacking) {
                if (entity instanceof AbstractHorse) {
                    sendActionPreventedMessage(playerEntity, Component.translatable("preventer.attacking.prevented.preventHorseAttacking"));
                    return InteractionResult.FAIL;
                }
            }

            if (PreventerClient.config.preventNeutralMobAttacking != PreventNeutralMobAttackingConfig.OFF) {
                if (PreventerClient.config.preventNeutralMobAttacking == PreventNeutralMobAttackingConfig.FULL && !(entity instanceof Piglin)) {
                    if (isNeutralMob(entity) || entity instanceof Spider || entity instanceof EnderMan) {
                        sendActionPreventedMessage(playerEntity, Component.translatable("preventer.attacking.prevented.preventNeutralMobAttacking"));
                        return InteractionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.preventDolphinAttacking) {
                if (entity instanceof Dolphin) {
                    sendActionPreventedMessage(playerEntity, Component.translatable("preventer.attacking.prevented.preventDolphinAttacking"));
                    return InteractionResult.FAIL;
                }
            }

            if (checkDurabilityProtection(playerEntity, hand)) return InteractionResult.FAIL;
        }

        return InteractionResult.PASS;
    }

    private static boolean isNeutralMob(Entity entity) {
        return (
                    entity instanceof Bee ||
                    entity instanceof Dolphin ||
                    entity instanceof Goat ||
                    entity instanceof IronGolem ||
                    entity instanceof Llama ||
                    entity instanceof Panda ||
                    entity instanceof Piglin ||
                    entity instanceof PolarBear ||
                    entity instanceof Wolf ||
                    entity instanceof ZombifiedPiglin ||
                    entity instanceof Fox
                );
    }
}
