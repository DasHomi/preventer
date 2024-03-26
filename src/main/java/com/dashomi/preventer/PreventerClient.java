package com.dashomi.preventer;

import com.dashomi.preventer.config.PreventerConfig;
import com.dashomi.preventer.listeners.*;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Environment(EnvType.CLIENT)
public class PreventerClient implements ClientModInitializer {
    public static final String MOD_ID = "preventer";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static PreventerConfig config;
    public static boolean overrideKeyPressed = false;
    public static boolean overrideToggleOff = false;

    // public static boolean getIgnore() {
    //     return (overrideToggleOff || overrideKeyPressed);
    // }
    public static boolean getPrevent() {
        // return !getIgnore();
        return !(overrideToggleOff || overrideKeyPressed);
    }

    @Override
    public void onInitializeClient() {
        AutoConfig.register(PreventerConfig.class, GsonConfigSerializer::new);
        config = PreventerConfig.get();

        AttackBlockCallback.EVENT.register(AttackBlockEvent::attackBlockListener);
        AttackEntityCallback.EVENT.register(AttackEntityEvent::attackEntityListener);
        ClientPlayConnectionEvents.JOIN.register(PlayerJoinEvent::playerJoinListener);
        UseBlockCallback.EVENT.register(UseBlockEvent::useBlockListener);
        UseItemCallback.EVENT.register(UseItemEvent::useItemListener);
        UseEntityCallback.EVENT.register(UseEntityEvent::useEntityListener);

        RegisterKeyBindings.register();
    }
}
