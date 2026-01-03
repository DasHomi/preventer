package com.dashomi.preventer.listeners;

import com.dashomi.preventer.PreventerClient;
import com.dashomi.preventer.config.PreventerConfig;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.client.gui.components.toasts.SystemToast;
import net.minecraft.network.chat.Component;

public class PlayerJoinEvent {
    public static void playerJoinListener(ClientPacketListener handler, PacketSender sender, Minecraft client) {
        if(PreventerClient.config.welcomeMessage) {
            assert client.player != null;
            client.getToastManager().addToast(SystemToast.multiline(client, SystemToast.SystemToastId.UNSECURE_SERVER_WARNING, Component.translatable("text.preventer.welcomeToastTitle"), Component.translatable("text.preventer.welcomeToast")));
            PreventerClient.config.welcomeMessage = false;
            PreventerConfig.save();
        }

        PreventerClient.ticksSinceEating = 0;
    }
}
