package de.fredo121.lobbyutils.main;


import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class LobbyUtils extends JavaPlugin {
	private static LobbyUtils instance;

	@Override
	public void onEnable() { 
		this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");

		getLogger().info("Lobby wurde aktiviert");
	}

	@Override
	public void onDisable() {
		getLogger().info("Lobby wurde deaktiviert");
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) { 
		if (command.getName().equalsIgnoreCase("lobby") || command.getName().equalsIgnoreCase("hub")) {
			Util.SendToBungeeServer(Settings.get().getBungeeLobbyServer(), (Player)sender);
		}
		return false; 
	}

	public static LobbyUtils get() {
		return instance;
	}

	public LobbyUtils() {
		instance = this;
	}
}
