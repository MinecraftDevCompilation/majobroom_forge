package com.innky.majobroom.events;

import com.innky.majobroom.entity.MajoBroom;
import com.innky.majobroom.network.PlayerConfigStorage;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.event.entity.EntityMountEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "majobroom", bus = Mod.EventBusSubscriber.Bus.MOD)
public class ServerEventHandler {

    @SubscribeEvent
    public static void onMount(EntityMountEvent event) {
        if (!event.isDismounting()) return; 

        if (!(event.getEntity() instanceof ServerPlayer player)) return;
        if (!(event.getMount() instanceof MajoBroomEntity broom)) return;

        if (!PlayerConfigStorage.getShiftToDismount(player)) {
            event.setCanceled(true); // 阻止下坐骑
        }
    }

    @SubscribeEvent
    public static void onLogout(PlayerEvent.PlayerLoggedOutEvent event) {
        if (event.getEntity() instanceof ServerPlayer player) {
            PlayerConfigStorage.remove(player);
        }
    }
}
