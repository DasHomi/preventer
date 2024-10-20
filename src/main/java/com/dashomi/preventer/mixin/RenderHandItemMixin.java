package com.dashomi.preventer.mixin;

import com.dashomi.preventer.PreventerClient;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.HeldItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HeldItemRenderer.class)
public class RenderHandItemMixin {
    @Inject(
            method = "renderItem(Lnet/minecraft/entity/LivingEntity;Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/render/model/json/ModelTransformationMode;ZLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V",
            at = @At(value = "HEAD"),
            cancellable = true
    )
    private void hideOffhandItem(LivingEntity entity, ItemStack stack, ModelTransformationMode renderMode, boolean leftHanded, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, CallbackInfo callbackInfo) {
        if (!PreventerClient.config.hideOffhand) return;

        if (!MinecraftClient.getInstance().options.getPerspective().isFirstPerson() ||
                stack.isEmpty() || entity != MinecraftClient.getInstance().player) return;

        if (PreventerClient.config.unhideOffhandOnUse && (entity.getActiveHand().equals(Hand.OFF_HAND) && entity.isUsingItem())) return;

        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        if (player != null && player.getOffHandStack() != stack) return;
        Item handItem = stack.getItem();

        if (PreventerClient.config.hiddenOffhandItems.contains(Registries.ITEM.getId(handItem).toString())) {
            callbackInfo.cancel();
        }
    }
}
