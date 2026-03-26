package com.dashomi.preventer.listeners;

import com.dashomi.preventer.PreventerClient;
import com.dashomi.preventer.config.CreateModConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;

import static com.dashomi.preventer.PreventerClient.overrideKey;
import static com.dashomi.preventer.PreventerClient.configKey;
import static com.dashomi.preventer.PreventerClient.toggleKey;

public class EndClientTickEvent {
    public static void endClientTickListener(Minecraft client) {
        if (client.player == null) return;

        while (configKey.consumeClick()) {
            client.setScreenAndShow(CreateModConfig.createConfigScreen(client.screen));
        }

        while (toggleKey.consumeClick()) {
            PreventerClient.overrideToggleOff = !PreventerClient.overrideToggleOff;
            if (PreventerClient.overrideToggleOff) {
                client.player.sendOverlayMessage(Component.translatable("key.preventer.toggleKey.offText"));
            } else {
                client.player.sendOverlayMessage(Component.translatable("key.preventer.toggleKey.onText"));
            }
        }

        if (!PreventerClient.overrideToggleOff) {
            if (overrideKey.isDown()) {
                client.player.sendOverlayMessage(Component.translatable(
                        PreventerClient.overrideToggleOff
                                ? "key.preventer.overrideKey.notifyToggledOff"
                                : "key.preventer.overrideKey.text"
                ));
            } else if (PreventerClient.overrideKeyPressed) {
                client.player.sendOverlayMessage(Component.nullToEmpty(""));
            }
        }

        PreventerClient.overrideKeyPressed = overrideKey.isDown();
    }
}
