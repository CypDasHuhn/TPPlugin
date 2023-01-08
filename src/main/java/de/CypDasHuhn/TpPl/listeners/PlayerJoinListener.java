package de.CypDasHuhn.TpPl.listeners;

import de.CypDasHuhn.TpPl.Common;
import de.CypDasHuhn.TpPl.CustomFiles;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.IOException;

public class PlayerJoinListener implements Listener{
	@EventHandler
	public static void pjListener(PlayerJoinEvent e) {
		//prework
		Player p = e.getPlayer();
		String name = p.getName();
		String uuid = p.getUniqueId().toString();
		CustomFiles[] cf = Common.getCustomFiles(1);
		FileConfiguration Config = cf[0].gfc("Players", "");
		//Check
		if (Config.getString("Players.Name."+name) == null) {
			int playerAmount = Config.getInt("PlayerAmount");
			if (Config.getString("Players.UUID."+uuid) != null) {
				//Set replace
				/**
				String oldName = Config.getString("Players.UUID."+uuid);
				for (int i = 1; i <= Amount+2; i++) {
					if (Config.getString("Players.ID."+i) == oldName) {
						Config.set("Players.ID."+i, name);
						i = Amount;
						p.sendMessage("�cYOO");
					}p.sendMessage("�ctf");
				}Config.set("Players.Name."+name, uuid);
				Config.set("Players.UUID."+uuid, name);
				cf[0].save();
				return;
				**/
			}
			//Set new
			playerAmount++;
			Config.set("PlayerAmount", playerAmount);
			Config.set("Players.ID."+playerAmount, name);
			Config.set("Players.Name."+name, uuid);
			Config.set("Players.UUID."+uuid, name);
			cf[0].save();
		}
	}
}
