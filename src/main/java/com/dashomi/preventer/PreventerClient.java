package com.dashomi.preventer;

import com.dashomi.preventer.config.PreventerConfig;
import com.dashomi.preventer.modules.AttackEntityModule;
import com.dashomi.preventer.modules.BreakBlockModule;
import com.dashomi.preventer.modules.UseBlockModule;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Environment(EnvType.CLIENT)
public class PreventerClient implements ClientModInitializer {
    public static final String MOD_ID = "preventer";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static PreventerConfig config;

    @Override
    public void onInitializeClient() {
        AutoConfig.register(PreventerConfig.class, GsonConfigSerializer::new);
        config = AutoConfig.getConfigHolder(PreventerConfig.class).getConfig();

        UseBlockCallback.EVENT.register(UseBlockModule::checkBlockUse);
        AttackBlockCallback.EVENT.register(BreakBlockModule::checkBlockBreak);
        AttackEntityCallback.EVENT.register(AttackEntityModule::checkEntityAttack);

        RegisterKeyBindings.register();

        LOGGER.info("Initialized");
    }
}
