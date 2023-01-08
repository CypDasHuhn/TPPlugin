package de.CypDasHuhn.TpPl.Interface.FolderInterface;

import de.CypDasHuhn.TpPl.listeners.InventoryClickListener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class fiListener extends InventoryClickListener{
	public static void listener(InventoryClickEvent e) {
		setAll(e, 1);
		e.setCancelled(true);
	}
}
