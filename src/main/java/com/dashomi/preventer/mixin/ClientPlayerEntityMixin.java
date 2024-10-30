package com.dashomi.preventer.mixin;

import com.dashomi.preventer.PreventerClient;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.block.Blocks;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.*;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ClientPlayerEntity.class)
public class ClientPlayerEntityMixin {
    @Inject(method = "dropSelectedItem(Z)Z", at = @At(value = "HEAD"), cancellable = true)
    private void stopDropSelectedItem(boolean entireStack, CallbackInfoReturnable<Boolean> cir) {
        if (PreventerClient.getPrevent()) {
            ClientPlayerEntity clientPlayerEntity = (ClientPlayerEntity) (Object) this;
            ItemStack itemStack = clientPlayerEntity.getMainHandStack();

            if (PreventerClient.config.preventToolDropping) {
                if (itemStack.get(DataComponentTypes.TOOL) != null) {
                    if (PreventerClient.config.preventToolDropping_msg) {
                        clientPlayerEntity.sendMessage(Text.translatable("config.preventer.preventToolDropping.text"), true);
                    }
                    cir.setReturnValue(false);
                }
            }

            if (PreventerClient.config.preventRenamedItemDropping) {
                if (itemStack.get(DataComponentTypes.CUSTOM_NAME) != null) {
                    if (PreventerClient.config.preventRenamedItemDropping_msg) {
                        clientPlayerEntity.sendMessage(Text.translatable("config.preventer.preventRenamedItemDropping.text"), true);
                    }
                    cir.setReturnValue(false);
                }
            }
        }
    }

    @Inject(method = "tickMovement", at = @At(value = "HEAD"))
    private void onTickMovement(CallbackInfo ci) {
        if (!PreventerClient.overrideKeyPressed) {
            ClientPlayerEntity player = (ClientPlayerEntity) (Object) this;
            World world = player.getWorld();
            BlockPos pos = player.getBlockPos();


            if (PreventerClient.config.preventFarmlandJumping) {
                if (world.getBlockState(pos).isOf(Blocks.FARMLAND)) {
                    if (PreventerClient.config.preventFarmlandJumping_msg) {
                        player.sendMessage(Text.translatable("config.preventer.preventFarmlandJumping.text"), true);
                    }
                    PreventerClient.LOGGER.info(String.valueOf(player.getVelocity().y));
                    player.setOnGround(false);
                }
            }
        }
    }

    @WrapOperation(method = "tickMovement", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/network/ClientPlayerEntity;setSprinting(Z)V"))
    private void wrapSetSprinting(ClientPlayerEntity instance, boolean value, Operation<Void> original) {
        if (!PreventerClient.overrideKeyPressed && value && instance.isSubmergedInWater()) {
            if (PreventerClient.config.preventSwimming) {
                if (PreventerClient.config.preventSwimming_msg) {
                    instance.sendMessage(Text.translatable("config.preventer.preventSwimming.text"), true);
                }
                return;
            }
        }
        original.call(instance, value);
    }
}
