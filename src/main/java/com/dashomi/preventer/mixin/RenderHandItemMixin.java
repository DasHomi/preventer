package com.dashomi.preventer.mixin;

import com.dashomi.preventer.PreventerClient;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.ItemInHandRenderer;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.InteractionHand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemInHandRenderer.class)
public class RenderHandItemMixin {
    @Inject(
            method = "renderItem(Lnet/minecraft/world/entity/LivingEntity;Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/item/ItemDisplayContext;Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/SubmitNodeCollector;I)V",
            at = @At(value = "HEAD"),
            cancellable = true
    )
    private void hideOffhandItem(LivingEntity entity, ItemStack stack, ItemDisplayContext renderMode, PoseStack matrices, SubmitNodeCollector orderedRenderCommandQueue, int light, CallbackInfo ci) {
        if (!Minecraft.getInstance().options.getCameraType().isFirstPerson() ||
                stack.isEmpty() || entity != Minecraft.getInstance().player || (entity.getUsedItemHand().equals(InteractionHand.OFF_HAND) && entity.isUsingItem())) return;

        if (PreventerClient.preventerActive()) {
            LocalPlayer player = Minecraft.getInstance().player;
            if (player != null && player.getOffhandItem() != stack) return;
            Item handItem = stack.getItem();

            if (handItem == Items.SHIELD && PreventerClient.config.hideShield) {
                ci.cancel();
            }

            if (handItem == Items.TOTEM_OF_UNDYING && PreventerClient.config.hideTotem) {
                ci.cancel();
            }
        }

    }
}
