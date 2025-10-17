package com.innky.majobroom.events;

import com.innky.majobroom.network.ClientConfigSyncPack;
import com.innky.majobroom.network.Networking;
import com.innky.majobroom.utills.ClientConfig;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.network.ClientPlayerNetworkEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "majobroom", value = Dist.CLIENT)
public class ClientLoginHandler {

    @SubscribeEvent
    public static void onClientLogin(ClientPlayerNetworkEvent.LoggingIn event) {
        if (Networking.INSTANCE != null) {
            boolean shiftToDismount = ClientConfig.SHIFT_TO_DISMOUNT.get();
            Networking.INSTANCE.sendToServer(new ClientConfigSyncPack(shiftToDismount));
        } else {
            System.err.println("[Majobroom] Networking.INSTANCE is null, cannot send ClientConfigSyncPack.");
        }
    }
}
