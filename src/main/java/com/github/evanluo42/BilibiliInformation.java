package com.github.evanluo42;

import org.bukkit.plugin.java.JavaPlugin;

public final class BilibiliInformation extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("[BilibiliInformation]The plugin has been loaded!");

    }

    @Override
    public void onDisable() {
        getLogger().info("[BilibiliInformation]The plugin has been closed!");
    }
}
