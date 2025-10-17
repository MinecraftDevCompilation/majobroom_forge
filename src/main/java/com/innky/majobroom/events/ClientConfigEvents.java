package com.innky.majobroom.client;

import com.innky.majobroom.network.ClientConfigSyncPack;
import com.innky.majobroom.network.Networking;
import com.innky.majobroom.utills.ClientConfig;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.config.ModConfigEvent;

@Mod.EventBusSubscriber(modid = "majobroom", bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientConfigEvents {

    @SubscribeEvent
    public static void onConfigReload(ModConfigEvent.Reloading event) {
        if (event.getConfig().getType() == ModConfig.Type.CLIENT && Networking.INSTANCE != null) {
            boolean shiftToDismount = ClientConfig.SHIFT_TO_DISMOUNT.get();
            Networking.INSTANCE.sendToServer(new ClientConfigSyncPack(shiftToDismount));
        }
    }

    @SubscribeEvent
    public static void onConfigChanged(ModConfigEvent.Loading event) {
        if (event.getConfig().getType() == ModConfig.Type.CLIENT && Networking.INSTANCE != null) {
            boolean shiftToDismount = ClientConfig.SHIFT_TO_DISMOUNT.get();
            Networking.INSTANCE.sendToServer(new ClientConfigSyncPack(shiftToDismount));
        }
    }
}
