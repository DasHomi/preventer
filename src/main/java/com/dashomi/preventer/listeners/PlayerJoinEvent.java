package com.dashomi.preventer.listeners;

import com.dashomi.preventer.PreventerClient;
import com.dashomi.preventer.config.PreventerConfig;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.toast.SystemToast;
import net.minecraft.text.Text;

public class PlayerJoinEvent {
    public static void playerJoinListener(ClientPlayNetworkHandler handler, PacketSender sender, MinecraftClient client) {
        if(PreventerClient.config.welcomeMessage) {
            assert client.player != null;
            client.getToastManager().add(SystemToast.create(client, SystemToast.Type.UNSECURE_SERVER_WARNING, Text.translatable("text.preventer.welcomeToastTitle"), Text.translatable("text.preventer.welcomeToast")));
            PreventerClient.config.welcomeMessage = false;
            PreventerConfig.save();
        }

        PreventerClient.ticksSinceEating = 0;
    }
}
