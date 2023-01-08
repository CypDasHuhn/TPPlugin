package de.CypDasHuhn.TpPl.listeners;

import de.CypDasHuhn.TpPl.Common;
import de.CypDasHuhn.TpPl.CustomFiles;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

import java.util.HashMap;

public class InventoryCloseListener implements Listener{
	public static HashMap<Player, Boolean> Exception = new HashMap<Player,Boolean>();
	@EventHandler
	public static void icListener(InventoryCloseEvent e) {
		Player p = (Player) e.getPlayer();
		CustomFiles[] cf = Common.getCustomFiles(1);
		FileConfiguration dConfig = cf[0].gfc("Data", p.getUniqueId()+"");
		Exception.putIfAbsent(p, false);
		if (!Exception.get(p)) {
			dConfig.set("WhichInv", "None");
		}CustomFiles.saveArray(cf);
	}
}
