package com.dashomi.preventer.mixin;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import net.minecraft.item.ToolItem;
import com.dashomi.preventer.PreventerClient;

@Mixin(PlayerInventory.class)
public class PlayerInventoryMixin {
    @Inject(method = "dropSelectedItem(Z)Lnet/minecraft/item/ItemStack;", at = @At(value = "HEAD"), cancellable = true)
    private void stopItemDrop(boolean entireStack, CallbackInfoReturnable<ItemStack> cir) {
        PlayerInventory inv = (PlayerInventory) (Object) this;
        ItemStack itemStack = inv.getMainHandStack();

        if(PreventerClient.config.preventToolDropping) {
            if(itemStack.getItem() instanceof ToolItem) {
                if (PreventerClient.config.preventToolDropping_msg) {
                    inv.player.sendMessage(Text.translatable("config.preventer.preventToolDropping.text"), true);
                }
                cir.setReturnValue(ItemStack.EMPTY);
            }
        }
    }
}