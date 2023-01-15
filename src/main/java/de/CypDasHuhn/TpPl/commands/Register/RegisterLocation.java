package de.CypDasHuhn.TpPl.commands.Register;

import de.CypDasHuhn.TpPl.Common;
import de.CypDasHuhn.TpPl.CustomFiles;
import de.CypDasHuhn.TpPl.ListManager;
import de.CypDasHuhn.TpPl.commands.ParentUpdater;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.Objects;

public class RegisterLocation {
	public static void registerLocation(String directory, Player p, String name, String parent, int slot, boolean Private) {
		//Prework //////////
		if (slot == -1) slot = getID(directory,parent);
		CustomFiles[] cf = Common.getCustomFiles(1);
		FileConfiguration cConfig = cf[0].gfc(name, directory+"/Location");
		// Check ////////////
		
		if (cConfig.getString("Parent.Name") != null) {
			
			return;
		}if (Common.illegalCharacter(name)) {
			
			return;
		}
		//Set  Location //////////
		Location location = p.getLocation();
		cConfig.set("Coordinates", location);
		// Item //////////////////////////
		cConfig.set("Item",Common.createItem(Material.GRASS_BLOCK, "§f"+name, false, null));
		
		CustomFiles.saveArray(cf);
		// Parent //////////////////////
		ParentUpdater.changeChildren(parent, directory, slot, name);
		ParentUpdater.changeParent(parent, directory, slot, "Location", name);
		ParentUpdater.listAdd(parent, directory, slot, name);
		// List //////////////////////
		ListManager.addOn(true, Private, directory, name);
	}
	public static int getID(String directory, String parent) {
		CustomFiles[] cf = Common.getCustomFiles(1);
		FileConfiguration dConfig = cf[0].gfc(parent, directory + "/Folder");
		int a = 0;

		while (dConfig.getString("Child." + a + ".Name") != null && !Objects.equals(dConfig.getString("Child." + a + ".Name"), "EMPTY")) {
			a++;
		}
		return a;
	}



}
