package com.innky.majobroom.network;

import com.innky.majobroom.network.PlayerConfigStorage;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;
import net.minecraft.server.level.ServerPlayer;

import java.util.function.Supplier;

public class ClientConfigSyncPack {
    private final boolean shiftToDismount;

    public ClientConfigSyncPack(boolean shiftToDismount) {
        this.shiftToDismount = shiftToDismount;
    }

    public ClientConfigSyncPack(FriendlyByteBuf buf) {
        this.shiftToDismount = buf.readBoolean();
    }

    public void toBytes(FriendlyByteBuf buf) {
        buf.writeBoolean(shiftToDismount);
    }

    public void handler(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ServerPlayer sender = ctx.get().getSender();
            if (sender != null) {
                PlayerConfigStorage.setShiftToDismount(sender, shiftToDismount);
            }
        });
        ctx.get().setPacketHandled(true);
    }
}
