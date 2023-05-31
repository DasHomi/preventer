package com.dashomi.preventer.modules;

import com.dashomi.preventer.PreventerClient;
import com.dashomi.preventer.config.PreventerConfig;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.text.Text;

public class PlayerJoinEvent {
    public static void onPlayerJoin(ClientPlayNetworkHandler handler, PacketSender sender, MinecraftClient client) {
        if(PreventerClient.config.welcomeMessage) {
            assert client.player != null;
            client.player.sendMessage(Text.translatable("text.preventer.welcomeMessage"), false);
            PreventerClient.config.welcomeMessage = false;
            PreventerConfig.save();
        }
    }
}
