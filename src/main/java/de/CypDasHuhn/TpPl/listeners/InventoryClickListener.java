package de.CypDasHuhn.TpPl.listeners;

import de.CypDasHuhn.TpPl.Common;
import de.CypDasHuhn.TpPl.CustomFiles;
import de.CypDasHuhn.TpPl.Interface.FolderInterface.fiListener;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClickListener implements Listener {
	public static Player p = null;
	public static CustomFiles[] cf = null;
	@EventHandler
	public static void icListener(InventoryClickEvent e) {
		//Prework
		Player p = (Player) e.getWhoClicked();
		String directory = p.getUniqueId().toString();
		CustomFiles[] cf = Common.getCustomFiles(1);
		FileConfiguration dConfig = cf[0].gfc("Data", directory);
		//Transfer
		switch(dConfig.getString("WhichInv")) {
			case "FolderInterface":
				fiListener.listener(e);
				break;
			case "EditInterface":
				
				break;
				default:
					break;
		}
	}public static void setAll(InventoryClickEvent e, int cfLength) {
		p = (Player) e.getWhoClicked();
		cf = new CustomFiles[cfLength];
	}
}
