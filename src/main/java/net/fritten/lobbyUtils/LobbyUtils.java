package net.fritten.lobbyUtils;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.java.JavaPlugin;


public final class LobbyUtils extends JavaPlugin implements Listener{
    private static LobbyUtils instance;

    @Override
    public void onEnable() {
        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");

        if(Settings.get().getUseEventHandler()){
            Bukkit.getPluginManager().registerEvents(this, this);
        }

        getLogger().info("Lobby wurde aktiviert");
    }

    @Override
    public void onDisable() {
        getLogger().info("Lobby wurde deaktiviert");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!Settings.get().getUseEventHandler()){
            if (command.getName().equalsIgnoreCase("lobby") || command.getName().equalsIgnoreCase("hub")) {
                Util.SendToBungeeServer(Settings.get().getBungeeLobbyServer(), (Player)sender);
                return true;
            }
            return false;
        }
        return false;
    }

    // We needed to do this because some other plugin killed this event

    @EventHandler(priority=EventPriority.HIGHEST)
    public void onCommand(PlayerCommandPreprocessEvent event) {
        if(Settings.get().getUseEventHandler()){
            String command = event.getMessage();
            if (command.equalsIgnoreCase("/lobby") || command.equalsIgnoreCase("/hub")) {
                Util.SendToBungeeServer(Settings.get().getBungeeLobbyServer(), event.getPlayer());
                event.setCancelled(true);
            }
        }
    }

    public static LobbyUtils get() {
        return instance;
    }

    public LobbyUtils() {
        instance = this;
    }
}
