package de.fredo121.lobbyutils.main;

import java.io.File;
import java.io.IOException;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;

import de.fredo121.lobbyutils.main.LobbyUtils; 

public class Settings { 
	private static Settings instance;
	private FileConfiguration config;
	private String bungeeLobbyServer;
	private boolean useEventHandler = false; 
	
	public static Settings get() {
		if (instance == null) {
			instance = new Settings();
		}
		return instance;
	}

	public Settings() { 
		LobbyUtils.get().saveDefaultConfig(); 
		this.config = LobbyUtils.get().getConfig(); 
		
		reloadConfig(); 
	}

	public void reloadConfig() {
		LobbyUtils.get().reloadConfig(); 
		config = LobbyUtils.get().getConfig(); 

		bungeeLobbyServer = config.getString("lobby.bungeeServer", "lobby"); 
		useEventHandler = config.getBoolean("lobby.useEventHandler", false); 
		saveConfig(); 
	}

	public void saveConfig() {
		config.set("lobby.bungeeServer", bungeeLobbyServer); 
		config.set("lobby.useEventHandler", useEventHandler); 
		
		File gameConfig = new File(LobbyUtils.get().getDataFolder() + "/" + "config.yml");
		try {
			config.save(gameConfig);
		} catch (IOException e) {
			Bukkit.getLogger().warning("Could not save config");
		}
	}

	public String getBungeeLobbyServer() {
		return bungeeLobbyServer;
	}

	public void setBungeeLobbyServer(String bungeeLobbyServer) { 
		this.bungeeLobbyServer = bungeeLobbyServer; 
		saveConfig(); 
	} 
	
	public boolean getUseEventHandler() { 
	    return useEventHandler; 
	}
	
	public void setUseEventHandler(boolean value) { 
	    useEventHandler = value; 
	    saveConfig(); 
	} 
	
} 
