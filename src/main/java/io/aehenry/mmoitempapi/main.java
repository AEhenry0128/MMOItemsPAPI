package io.aehenry.mmoitempapi;

import io.lumine.mythic.core.skills.CustomComponentRegistry;
import org.bukkit.plugin.java.JavaPlugin;

public final class main extends JavaPlugin {

    @Override
    public void onEnable() {
        new PAPIExpansion(this).register();
        new CustomComponentRegistry(this, "io.aehenry.mmoitempapi");
    }

}
