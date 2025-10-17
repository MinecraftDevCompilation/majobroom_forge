package com.innky.majobroom.events;

import com.innky.majobroom.entity.MajoBroom;
import com.innky.majobroom.network.PlayerConfigStorage;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.event.entity.living.LivingEntityDismountEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "majobroom", bus = Mod.EventBusSubscriber.Bus.MOD)
public class ServerEvents {

    @SubscribeEvent
    public static void onDismount(LivingEntityDismountEvent event) {
        LivingEntity entity = event.getEntity();
        Entity dismounted = event.getDismounted();

        if (!(entity instanceof ServerPlayer player)) return;

        if (!(dismounted instanceof MajoBroom broom)) return;

        if (!PlayerConfigStorage.getShiftToDismount(player)) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void onLogout(PlayerEvent.PlayerLoggedOutEvent event) {
        if (event.getEntity() instanceof ServerPlayer player) {
            PlayerConfigStorage.remove(player);
        }
    }
}
