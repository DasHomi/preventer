package com.dashomi.preventer.mixin;

import com.dashomi.preventer.PreventerClient;
import net.minecraft.client.multiplayer.MultiPlayerGameMode;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static com.dashomi.preventer.utils.ActionPreventedMessage.sendActionPreventedMessage;

@Mixin(MultiPlayerGameMode.class)
public class MultiplayerGameModeMixin {
    @Inject(method = "handleContainerInput(IIILnet/minecraft/world/inventory/ContainerInput;Lnet/minecraft/world/entity/player/Player;)V", at = @At("HEAD"), cancellable = true)
    private void interceptInventoryDrop(int i, int j, int k, ContainerInput containerInput, Player player, CallbackInfo ci) {
        if (PreventerClient.preventerActive() && !player.isSpectator()) {
            // j is slotId
            AbstractContainerMenu menu = player.containerMenu;

            if (PreventerClient.config.preventToolDropping) {
                if (containerInput == ContainerInput.THROW) {
                    if (j == AbstractContainerMenu.SLOT_CLICKED_OUTSIDE) {
                        if (menu.getCarried().get(DataComponents.TOOL) != null) {
                            sendActionPreventedMessage(player, Component.translatable("preventer.miscellaneous.prevented.preventToolDropping"));
                            ci.cancel();
                        }
                    } else if (menu.getSlot(j).getItem().get(DataComponents.TOOL) != null) {
                        sendActionPreventedMessage(player, Component.translatable("preventer.miscellaneous.prevented.preventToolDropping"));
                        ci.cancel();
                    }
                }
            }

            if (PreventerClient.config.preventRenamedItemDropping) {
                if (containerInput == ContainerInput.THROW) {
                    if (j == AbstractContainerMenu.SLOT_CLICKED_OUTSIDE) {
                        if (menu.getCarried().get(DataComponents.CUSTOM_NAME) != null) {
                            sendActionPreventedMessage(player, Component.translatable("preventer.miscellaneous.prevented.preventRenamedItemDropping"));
                            ci.cancel();
                        }
                    } else if (menu.getSlot(j).getItem().get(DataComponents.CUSTOM_NAME) != null) {
                        sendActionPreventedMessage(player, Component.translatable("preventer.miscellaneous.prevented.preventRenamedItemDropping"));
                        ci.cancel();
                    }
                }
            }

            if (PreventerClient.config.preventEnchantedItemSmelting) {
                if (containerInput == ContainerInput.QUICK_MOVE && j != AbstractContainerMenu.SLOT_CLICKED_OUTSIDE) {
                    if (menu instanceof FurnaceMenu || menu instanceof BlastFurnaceMenu || menu instanceof SmokerMenu) {
                        if (!menu.getSlot(j).getItem().getEnchantments().isEmpty()) {
                            sendActionPreventedMessage(player);
                            ci.cancel();
                        }
                    }
                }
            }
        }

    }
}
