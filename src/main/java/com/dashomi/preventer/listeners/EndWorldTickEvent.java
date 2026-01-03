package com.dashomi.preventer.listeners;

import com.dashomi.preventer.PreventerClient;
import net.minecraft.client.multiplayer.ClientLevel;

public class EndWorldTickEvent {
    public static void endWorldTickListener(ClientLevel world) {
        PreventerClient.ticksSinceEating ++;
        if (PreventerClient.rocketTicksRemaining > 0) {
            PreventerClient.rocketTicksRemaining--;
        }
    }
}
