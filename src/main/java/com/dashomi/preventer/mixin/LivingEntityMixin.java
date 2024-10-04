package com.dashomi.preventer.mixin;

import com.dashomi.preventer.PreventerClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {

    @Inject(method = "eatFood", at = @At(value = "TAIL"))
    private void resetTicksSinceFoodEat(World world, ItemStack stack, FoodComponent foodComponent, CallbackInfoReturnable<ItemStack> cir) {
        LivingEntity entity = (LivingEntity) (Object) this;
        //ensures the entity here is the client player
        if (entity instanceof ClientPlayerEntity) {
            PreventerClient.ticksSinceEating = 0;
        }
    }
}
