package it.azuremc.miniere.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class DisableMine implements CommandExecutor {

    public static Map<Player, String> mainDisabled = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;

        if(p.hasPermission("miniere.disable")) {
            if(!mainDisabled.containsKey(p)) {
                mainDisabled.put(p, p.getDisplayName());
                p.sendMessage("&7Ora puoi scavare senza che il blocco non si spacchi");
            } else {
                mainDisabled.remove(p);
                p.sendMessage("&7Ora puoi scavare facendo sì che il blocco si ripiazzi normalmente");
            }
        }

        return true;
    }
}
