package com.dashomi.preventer.listeners;

import com.dashomi.preventer.PreventerClient;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

import java.util.Optional;

public class UseItemEvent {
    public static ActionResult useItemListener(PlayerEntity player, World world, Hand hand) {
        if (PreventerClient.getPrevent()) {
            Item handItem = player.getStackInHand(hand).getItem();
            ItemStack handStack = player.getStackInHand(hand);
            if (PreventerClient.config.preventRenamedItemUsing) {
                if (handStack.get(DataComponentTypes.FOOD) != null ) {
                    if (handStack.get(DataComponentTypes.CUSTOM_NAME) != null) {
                        if (PreventerClient.config.preventRenamedItemUsing_msg) {
                            player.sendMessage(Text.translatable("config.preventer.preventRenamedItemUsing.text"), true);
                        }
                        return ActionResult.FAIL;
                    }
                }
            }

            if (PreventerClient.config.preventPlaceAfterEating) {
                if (handStack.get(DataComponentTypes.FOOD) != null ) {
                    //confirms the player is actually eating the food and not just right-clicked the food on full hunger
                    if (handStack.use(world, player, hand).isAccepted()) {
                        PreventerClient.ticksSinceEating = 0;
                    }
                }
            }

            if (PreventerClient.config.preventCurseOfBindingEquip) {
                DynamicRegistryManager drm = world.getRegistryManager();
                Optional<RegistryEntry<Enchantment>> enchantRegistry = drm.getOptional(RegistryKeys.ENCHANTMENT)
                        .flatMap(r -> r.getEntry(Enchantments.BINDING_CURSE.getValue()));
                if (enchantRegistry.isPresent()) {
                    int curseLvl = handStack.getEnchantments().getLevel(enchantRegistry.get());
                    if (curseLvl > 0) {
                        if (PreventerClient.config.preventCurseOfBindingEquip_msg) {
                            player.sendMessage(Text.translatable("config.preventer.preventCurseOfBindingEquip.text"), true);
                        }
                        return ActionResult.FAIL;
                    }
                }
            }

        }

        return ActionResult.PASS;
    }
}
