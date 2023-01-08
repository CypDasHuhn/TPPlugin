package de.CypDasHuhn.TpPl.Interface.FolderInterface;

import de.CypDasHuhn.TpPl.Common;
import de.CypDasHuhn.TpPl.CustomFiles;
import de.CypDasHuhn.TpPl.Interface.Interface;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;

public class FolderInterface extends Interface{
	public static HashMap<Player, Boolean> Move = new HashMap<Player,Boolean>();
	public static void Interface(Player p, String directory, String parent, int page, int rows) {
		//Prework
		Move.putIfAbsent(p, false);
		Inventory inv = Bukkit.createInventory(null, rows*9+9, "§6§l"+parent);
		
		CustomFiles[] cf = Common.getCustomFiles(3);
		FileConfiguration dConfig = cf[0].gfc("Data",p.getUniqueId()+"");
		FileConfiguration pConfig = cf[1].gfc(parent, directory+"/Folder");
		
		dConfig.set("WhichInv", "FolderInterface");
		dConfig.set("Page", page);
		dConfig.set("Parent", parent);
		
		int bonus = rows*9*(page-1);
		
		ItemStack item;
		if (Move.get(p)) item = Common.createItem(Material.LIME_STAINED_GLASS_PANE, " ", false, null);
		else item = Common.createItem(Material.LIGHT_GRAY_STAINED_GLASS_PANE, " ", false, null);
		
		//Background
		for (int i = 0; i < rows*9; i++) {
			inv.setItem(i, item);
		}//Items
		for (int i = 0; i < rows*9; i++) {
			String name = pConfig.getString("Child."+(i+bonus)+".Name");
			if (!(name == null || name.equals("EMPTY"))) {
				String type = pConfig.getString("Child."+(i+bonus)+".Type");
				FileConfiguration cConfig = cf[2].gfc(name, p.getUniqueId()+"/"+type);
				item = cConfig.getItemStack("Item");
				ItemMeta itemMeta = item.getItemMeta();
				if (type.equals("Folder")) {
					itemMeta.addEnchant(Enchantment.DAMAGE_ALL, 0,true);
					itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				}item.setItemMeta(itemMeta);
				inv.setItem(i, item);
			}
		}//Bar Beloww
		item = Common.createItem(Material.BLACK_STAINED_GLASS_PANE, " ", false, null);
		for (int i = rows*9; i < (rows+1)*9; i++) {
			inv.setItem(i, item);
		}//Constants
		if (!parent.equals("General")) inv.setItem(45, Common.createItem(Material.FEATHER, "Zurück", false, null));
		if (page > 1) inv.setItem(48, Common.createItem(Material.FEATHER, "Letzte Seite", false, null));
		inv.setItem(50, Common.createItem(Material.FEATHER, "Nächste Seite", false, null));
		
		CustomFiles.saveArray(cf);
		//Open Inventory
		p.openInventory(inv);
	}
}
