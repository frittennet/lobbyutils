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

		bungeeLobbyServer = config.getString("lobby.bungeeServer"); 
	}

	public void saveConfig() {
		config.set("lobby.bungeeServer", bungeeLobbyServer); 

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
}
