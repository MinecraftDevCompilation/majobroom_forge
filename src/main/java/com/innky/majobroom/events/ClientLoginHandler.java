package com.innky.majobroom.events;

import com.innky.majobroom.network.ClientConfigSyncPack;
import com.innky.majobroom.network.Networking;
import com.innky.majobroom.utills.ClientConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.network.ClientPlayerNetworkEvent.LoggedInEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "majobroom", value = Dist.CLIENT)
public class ClientLoginHandler {

    private static boolean sent = false;

    @SubscribeEvent
    public static void onClientJoin(LoggedInEvent event) {
        if (Networking.INSTANCE != null) {
            boolean shiftToDismount = ClientConfig.SHIFT_TO_DISMOUNT.get();
            Networking.INSTANCE.sendToServer(new ClientConfigSyncPack(shiftToDismount));
        }
    }
}
