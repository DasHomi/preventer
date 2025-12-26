package com.dashomi.preventer;

import com.dashomi.preventer.config.CreateModConfig;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.KeyMapping;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import org.lwjgl.glfw.GLFW;

public class RegisterKeyBindings {
    private static final KeyMapping.Category PREVENTER_CATEGORY = KeyMapping.Category.register(Identifier.fromNamespaceAndPath("preventer", "category"));

    public static void register() {
        registerOverrideKey();
        registerConfigKey();
        registerToggleKey();
    }

    private static void registerOverrideKey() {
        KeyMapping overrideKey = new KeyMapping("key.preventer.overrideKey", InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_R, PREVENTER_CATEGORY);
        KeyBindingHelper.registerKeyBinding(overrideKey);

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player == null) return;

            if (!PreventerClient.overrideToggleOff || PreventerClient.config.notifyToggledOff) {
                if (overrideKey.isDown()) {
                    client.player.displayClientMessage(Component.translatable(
                            PreventerClient.overrideToggleOff
                                    ? "key.preventer.overrideKey.notifyToggledOff"
                                    : "key.preventer.overrideKey.text"
                    ), true);
                } else if (PreventerClient.overrideKeyPressed) { // still haven't updated the status from last tick
                    client.player.displayClientMessage(Component.nullToEmpty(""), true);
                }
            }

            PreventerClient.overrideKeyPressed = overrideKey.isDown();
        });
    }

    private static void registerConfigKey() {
        KeyMapping configKey = new KeyMapping("key.preventer.configKey", InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_I, PREVENTER_CATEGORY);
        KeyBindingHelper.registerKeyBinding(configKey);

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (configKey.consumeClick()) {
                client.setScreenAndShow(CreateModConfig.createConfigScreen(client.screen));
            }
        });
    }

    private static void registerToggleKey() {
        KeyMapping toggleKey = new KeyMapping("key.preventer.toggleKey", InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_BACKSPACE, PREVENTER_CATEGORY);
        KeyBindingHelper.registerKeyBinding(toggleKey);

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player == null) return;

            while (toggleKey.consumeClick()) {
                PreventerClient.overrideToggleOff = !PreventerClient.overrideToggleOff;
                if (PreventerClient.overrideToggleOff) {
                    client.player.displayClientMessage(Component.translatable("key.preventer.toggleKey.offText"), true);
                } else {
                    client.player.displayClientMessage(Component.translatable("key.preventer.toggleKey.onText"), true);
                }
            }
        });
    }
}