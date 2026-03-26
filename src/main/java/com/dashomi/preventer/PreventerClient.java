package com.dashomi.preventer;

import com.dashomi.preventer.config.PreventerConfig;
import com.dashomi.preventer.listeners.*;
import com.mojang.blaze3d.platform.InputConstants;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keymapping.v1.KeyMappingHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.minecraft.client.KeyMapping;
import net.minecraft.resources.Identifier;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Environment(EnvType.CLIENT)
public class PreventerClient implements ClientModInitializer {
    public static final String MOD_ID = "preventer";

    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static PreventerConfig config;
    public static boolean overrideKeyPressed = false;
    public static boolean overrideToggleOff = false;

    public static int ticksSinceEating = 0;
    public static int rocketTicksRemaining = 0;

    public static KeyMapping overrideKey;
    public static KeyMapping configKey;
    public static KeyMapping toggleKey;

    public static boolean preventerActive() {
        return !(overrideToggleOff || overrideKeyPressed);
    }

    @Override
    public void onInitializeClient() {
        // Register keybinds
        KeyMapping.Category PREVENTER_CATEGORY = KeyMapping.Category.register(Identifier.fromNamespaceAndPath("preventer", "category"));
        overrideKey = new KeyMapping("key.preventer.overrideKey", InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_R, PREVENTER_CATEGORY);
        configKey = new KeyMapping("key.preventer.configKey", InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_I, PREVENTER_CATEGORY);
        toggleKey = new KeyMapping("key.preventer.toggleKey", InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN, PREVENTER_CATEGORY);
        KeyMappingHelper.registerKeyMapping(overrideKey);
        KeyMappingHelper.registerKeyMapping(configKey);
        KeyMappingHelper.registerKeyMapping(toggleKey);

        // Register Config
        AutoConfig.register(PreventerConfig.class, GsonConfigSerializer::new);
        config = PreventerConfig.get();

        // Register event listeners
        AttackBlockCallback.EVENT.register(AttackBlockEvent::attackBlockListener);
        AttackEntityCallback.EVENT.register(AttackEntityEvent::attackEntityListener);
        ClientPlayConnectionEvents.JOIN.register(PlayerJoinEvent::playerJoinListener);
        UseBlockCallback.EVENT.register(UseBlockEvent::useBlockListener);
        UseItemCallback.EVENT.register(UseItemEvent::useItemListener);
        UseEntityCallback.EVENT.register(UseEntityEvent::useEntityListener);
        ClientTickEvents.END_CLIENT_TICK.register(EndClientTickEvent::endClientTickListener);
        ClientTickEvents.END_LEVEL_TICK.register(EndLevelTickEvent::endLevelTickListener);
    }
}
