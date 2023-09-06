package com.dashomi.preventer;

import com.dashomi.preventer.config.CreateModConfig;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

public class RegisterKeyBindings {
    private static final String CATEGORY = "key.preventer.category";

    public static void register() {
        registerOverrideKey();
        registerConfigKey();
    }

    private static void registerOverrideKey() {
        KeyBinding overrideKey = new KeyBinding("key.preventer.overrideKey", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_R, CATEGORY);
        KeyBindingHelper.registerKeyBinding(overrideKey);

        ClientTickEvents.END_CLIENT_TICK.register(client -> {

            if (overrideKey.isPressed()) {
                assert MinecraftClient.getInstance().player != null;
                MinecraftClient.getInstance().player.sendMessage(Text.translatable("key.preventer.overrideKey.text"), true);
            } else {
                if (MinecraftClient.getInstance().player != null) {
                    if (PreventerClient.overrideKeyPressed) {
                        MinecraftClient.getInstance().player.sendMessage(Text.of(""), true);
                    }
                }
            }
            PreventerClient.overrideKeyPressed = overrideKey.isPressed();
        });
    }

    private static void registerConfigKey() {
        KeyBinding configKey = new KeyBinding("key.preventer.configKey", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_I, CATEGORY);
        KeyBindingHelper.registerKeyBinding(configKey);

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (configKey.wasPressed()) {
                MinecraftClient.getInstance().setScreenAndRender(CreateModConfig.createConfigScreen(MinecraftClient.getInstance().currentScreen));
            }
        });
    }
}
