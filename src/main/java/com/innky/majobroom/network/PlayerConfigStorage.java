package com.innky.majobroom.network;

import net.minecraft.server.level.ServerPlayer;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerConfigStorage {
    private static final Map<UUID, Boolean> SHIFT_MAP = new HashMap<>();

    public static void setShiftToDismount(ServerPlayer player, boolean value) {
        SHIFT_MAP.put(player.getUUID(), value);
    }

    public static boolean getShiftToDismount(ServerPlayer player) {
        return SHIFT_MAP.getOrDefault(player.getUUID(), true);
    }

    public static void remove(ServerPlayer player) {
        SHIFT_MAP.remove(player.getUUID());
    }
}
