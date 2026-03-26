package com.dashomi.preventer.listeners;

import com.dashomi.preventer.PreventerClient;
import net.minecraft.client.multiplayer.ClientLevel;

public class EndLevelTickEvent {
    public static void endLevelTickListener(ClientLevel world) {
        PreventerClient.ticksSinceEating ++;
        if (PreventerClient.rocketTicksRemaining > 0) {
            PreventerClient.rocketTicksRemaining--;
        }
    }
}
