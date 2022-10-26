package it.azuremc.miniere;

import it.azuremc.miniere.Commands.DisableMine;
import it.azuremc.miniere.Listeners.OnBlockBreak;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;
import java.util.Random;

public final class Main extends JavaPlugin {

    public static Main plugin;

    @Override
    public void onEnable() {

        getServer().getLogger().info("§8§m-------------------------------");
        getServer().getLogger().info("§r");
        getServer().getLogger().info("§b§lPLUGIN ONLINE");
        getServer().getLogger().info("§b§lMINIERE §7by §9@TechnoAde");
        getServer().getLogger().info("§r");
        getServer().getLogger().info("§8§m-------------------------------");

        //Eventi
        new OnBlockBreak(this);

        //Variabili
        plugin = this;

        //Comandi
        Objects.requireNonNull(getCommand("disablemine")).setExecutor(new DisableMine());

        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {

    }

    public static int randonumber(int upperbound) {
        Random rand = new Random();
        return rand.nextInt(upperbound+1);
    }

}
