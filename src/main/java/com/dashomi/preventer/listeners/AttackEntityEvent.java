package com.dashomi.preventer.listeners;

import com.dashomi.preventer.PreventerClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.decoration.EndCrystalEntity;
import net.minecraft.entity.decoration.ItemFrameEntity;
import net.minecraft.entity.decoration.painting.PaintingEntity;
import net.minecraft.entity.mob.ZombifiedPiglinEntity;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import static com.dashomi.preventer.utils.DurabilityProtection.checkDurabilityProtection;

public class AttackEntityEvent {
    public static ActionResult attackEntityListener(PlayerEntity playerEntity, World world, Hand hand, Entity entity, @Nullable EntityHitResult result) {
        if (!PreventerClient.overrideKeyPressed) {
            if (PreventerClient.config.preventVillagerPunch) {
                if (entity instanceof VillagerEntity) {
                    if (PreventerClient.config.preventVillagerPunch_msg) {
                        playerEntity.sendMessage(Text.translatable("config.preventer.preventVillagerPunch.text"), true);
                    }
                    return ActionResult.FAIL;
                }
            }

            if (PreventerClient.config.noZombifiedPiglinPunch) {
                if (entity instanceof ZombifiedPiglinEntity) {
                    if (PreventerClient.config.noZombifiedPiglinPunch_msg) {
                        playerEntity.sendMessage(Text.translatable("config.preventer.noZombifiedPiglinPunch.text"), true);
                    }
                    return ActionResult.FAIL;
                }
            }

            if (PreventerClient.config.preventEndCrystalHitting) {
                if (entity instanceof EndCrystalEntity) {
                    if (PreventerClient.config.preventEndCrystalHitting_msg) {
                        playerEntity.sendMessage(Text.translatable("config.preventer.preventEndCrystalHitting.text"), true);
                    }
                    return ActionResult.FAIL;
                }
            }

            if (PreventerClient.config.preventItemFrameBreaking) {
                if (entity instanceof ItemFrameEntity) {
                    if (PreventerClient.config.preventItemFrameBreaking_msg) {
                        playerEntity.sendMessage(Text.translatable("config.preventer.preventItemFrameBreaking.text"), true);
                    }
                    return ActionResult.FAIL;
                }
            }

            if (PreventerClient.config.preventPaintingBreaking) {
                if (entity instanceof PaintingEntity) {
                    if (PreventerClient.config.preventPaintingBreaking_msg) {
                        playerEntity.sendMessage(Text.translatable("config.preventer.preventPaintingBreaking.text"), true);
                    }
                    return ActionResult.FAIL;
                }
            }

            if (PreventerClient.config.preventIronGolemAttacking) {
                if (entity instanceof net.minecraft.entity.passive.IronGolemEntity) {
                    if (PreventerClient.config.preventIronGolemAttacking_msg) {
                        playerEntity.sendMessage(Text.translatable("config.preventer.preventIronGolemAttacking.text"), true);
                    }
                    return ActionResult.FAIL;
                }
            }

            if (PreventerClient.config.preventSnowGolemAttacking) {
                if (entity instanceof net.minecraft.entity.passive.SnowGolemEntity) {
                    if (PreventerClient.config.preventSnowGolemAttacking_msg) {
                        playerEntity.sendMessage(Text.translatable("config.preventer.preventSnowGolemAttacking.text"), true);
                    }
                    return ActionResult.FAIL;
                }
            }

            if (PreventerClient.config.preventNamedMobAttacking) {
                if (entity.hasCustomName()) {
                    if (PreventerClient.config.preventNamedMobAttacking_msg) {
                        playerEntity.sendMessage(Text.translatable("config.preventer.preventNamedMobAttacking.text"), true);
                    }
                    return ActionResult.FAIL;
                }
            }

            if (PreventerClient.config.preventTamedMobAttacking) {
                if (entity instanceof TameableEntity) {
                    if (((TameableEntity) entity).isTamed()) {
                        if (PreventerClient.config.preventTamedMobAttacking_msg) {
                            playerEntity.sendMessage(Text.translatable("config.preventer.preventTamedMobAttacking.text"), true);
                        }
                        return ActionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.preventRareMobAttacking) {
                if (entity instanceof AxolotlEntity || entity instanceof ParrotEntity || entity instanceof AllayEntity) {
                    if (PreventerClient.config.preventRareMobAttacking_msg) {
                        playerEntity.sendMessage(Text.translatable("config.preventer.preventRareMobAttacking.text"), true);
                    }
                    return ActionResult.FAIL;
                }
            }

            if (PreventerClient.config.preventHorseAttacking) {
                if (entity instanceof AbstractHorseEntity) {
                    if (PreventerClient.config.preventHorseAttacking_msg) {
                        playerEntity.sendMessage(Text.translatable("config.preventer.preventHorseAttacking.text"), true);
                    }
                    return ActionResult.FAIL;
                }
            }

            if (checkDurabilityProtection(playerEntity, hand)) return ActionResult.FAIL;
        }

        return ActionResult.PASS;
    }
}
