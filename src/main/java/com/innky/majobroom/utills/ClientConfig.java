package com.innky.majobroom.utills;

import net.minecraftforge.common.ForgeConfigSpec;

public class ClientConfig {
    public static ForgeConfigSpec CLIENT_CONFIG;
    public static ForgeConfigSpec.BooleanValue AUTO_PERSPECTIVE;
    public static ForgeConfigSpec.BooleanValue SHIFT_TO_DISMOUNT;
    static {
        ForgeConfigSpec.Builder CLIENT_BUILDER = new ForgeConfigSpec.Builder();
        CLIENT_BUILDER.comment("Client settings").push("client");
        AUTO_PERSPECTIVE = CLIENT_BUILDER.comment("When this value equals false, perspective will not be changed automatically when you get on or get off the broom.").define("auto_perspective",true);
        SHIFT_TO_DISMOUNT = CLIENT_BUILDER.comment("When this value equals false, you can bind the key 'shift' to descend the broom").define("shift_key_to_dismount",true);
        CLIENT_BUILDER.pop();
        CLIENT_CONFIG = CLIENT_BUILDER.build();
    }
}
