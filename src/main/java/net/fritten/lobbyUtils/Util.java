package net.fritten.lobbyUtils;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;


public class Util {
	public static void SendToBungeeServer(final String server, final Player player) { 
		new BukkitRunnable() { 
			
			public void run() {
                ByteArrayOutputStream b = new ByteArrayOutputStream();
                DataOutputStream out = new DataOutputStream(b);

                try {
                    out.writeUTF("Connect");
                    out.writeUTF(server);
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }

                if (b != null) {
                    player.sendPluginMessage(LobbyUtils.get(), "BungeeCord", b.toByteArray());
                }
            }
        }.runTaskLater(LobbyUtils.get(), 20L); 
	} 
}
