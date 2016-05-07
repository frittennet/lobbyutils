package de.fredo121.lobbyutils.main;


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
		
		if (command.getName().equalsIgnoreCase("ts")) {
		    if (args.length>1) {
		        return false;
		    }

		    Player player = (Player) sender;
		    player.sendMessage("§7[§6Toothwitch§7] §7Unsere TS3-IP lautet §6ts.toothwit.ch§7!");
		    return true;    
		 
		}    

		if (command.getName().equalsIgnoreCase("ts3")) {
		    if (args.length>1) {
		        return false;
		    }

		    Player player = (Player) sender;
		    player.sendMessage("§7[§6Toothwitch§7] §7Unsere TS3-IP lautet §6ts.toothwit.ch§7!");
		    return true;    
		 
		} 
		   
		if (command.getName().equalsIgnoreCase("vote")) {
		    if (args.length>1) {
		        return false;
		    }

		    Player player = (Player) sender;
		    player.sendMessage("§7[§6Toothwitch§7] §7Vote für uns auf §6ts.toothwit.ch/vote§7!");
		    return true;    
		 
		}
		
		if (command.getName().equalsIgnoreCase("web")) {
		    if (args.length>1) {
		        return false;
		    }

		    Player player = (Player) sender;
		    player.sendMessage("§7[§6Toothwitch§7] §7Besuche unsere Website auf §6ts.toothwit.ch§7!");
		    return true;    
		 
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