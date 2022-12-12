package com.dashomi.preventer.mixin;

import com.dashomi.preventer.PreventerClient;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.HeldItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HeldItemRenderer.class)
public class RenderHandItemMixin {
    @Inject(
            method = "renderItem(Lnet/minecraft/entity/LivingEntity;Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/render/model/json/ModelTransformation$Mode;ZLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V",
            at = @At(value = "HEAD"),
            cancellable = true
    )
    private void hideOffhandItem(LivingEntity entity, ItemStack stack, ModelTransformation.Mode renderMode, boolean leftHanded, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, CallbackInfo callbackInfo) {
        if (!MinecraftClient.getInstance().options.getPerspective().isFirstPerson() ||
                stack.isEmpty() || entity != MinecraftClient.getInstance().player || entity.isUsingItem()) return;

        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        if (player != null && player.getOffHandStack() != stack) return;
        Identifier handItem = Registry.ITEM.getId(stack.getItem());

        if (handItem == Registry.ITEM.getId(Items.SHIELD) && PreventerClient.config.hideShield) {
            callbackInfo.cancel();
        }

        if (handItem == Registry.ITEM.getId(Items.TOTEM_OF_UNDYING) && PreventerClient.config.hideTotem) {
            callbackInfo.cancel();
        }
    }
}
