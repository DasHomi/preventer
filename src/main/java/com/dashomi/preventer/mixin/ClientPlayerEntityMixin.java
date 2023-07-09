package com.dashomi.preventer.mixin;

import com.dashomi.preventer.PreventerClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ClientPlayerEntity.class)
public class ClientPlayerEntityMixin {
    @Inject(method = "dropSelectedItem(Z)Z", at = @At(value = "HEAD"), cancellable = true)
    private void stopDropSelectedItem(boolean entireStack, CallbackInfoReturnable<Boolean> cir) {
        if (!PreventerClient.overrideKeyPressed) {
            ClientPlayerEntity clientPlayerEntity = (ClientPlayerEntity) (Object) this;
            ItemStack itemStack = clientPlayerEntity.getMainHandStack();

            if (PreventerClient.config.preventToolDropping) {
                if (itemStack.getItem() instanceof ToolItem) {
                    if (PreventerClient.config.preventToolDropping_msg) {
                        clientPlayerEntity.sendMessage(Text.translatable("config.preventer.preventToolDropping.text"), true);
                    }
                    cir.setReturnValue(false);
                }
            }

            if (PreventerClient.config.preventRenamedItemDropping) {
                if (itemStack.hasCustomName()) {
                    if (PreventerClient.config.preventRenamedItemDropping_msg) {
                        clientPlayerEntity.sendMessage(Text.translatable("config.preventer.preventRenamedItemDropping.text"), true);
                    }
                    cir.setReturnValue(false);
                }
            }
        }
    }
}
