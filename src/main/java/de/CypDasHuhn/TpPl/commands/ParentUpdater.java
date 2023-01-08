package de.CypDasHuhn.TpPl.commands;

import de.CypDasHuhn.TpPl.Common;
import de.CypDasHuhn.TpPl.CustomFiles;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.Objects;

public class ParentUpdater {
	public static void changeChildren(String Parent, String Directory, int Slot, String Name) {
		// Prework
		CustomFiles[] cf = Common.getCustomFiles(1);
		FileConfiguration cConfig = cf[0].gfc(Name,Directory+"/Location");
		// Set
		cConfig.set("Parent.Name", Parent);
		cConfig.set("Parent.Slot", Slot+"");
		
		CustomFiles.saveArray(cf);
	}
	public static void changeParent(String Parent, String Directory, int Slot, String Type, String Name) {
		// Prework
		CustomFiles[] cf = Common.getCustomFiles(1);
		FileConfiguration pConfig = cf[0].gfc(Parent,Directory+"/Folder");
		// Set
		pConfig.set("Child."+Slot+".Name", Name);
		pConfig.set("Child."+Slot+".Type", Type);
		
		CustomFiles.saveArray(cf);
	}
	public static void listAdd(String Parent, String Directory, int Slot, String Name) {
		// Prework
		CustomFiles[] cf = Common.getCustomFiles(1);
		FileConfiguration pConfig = cf[0].gfc(Parent,Directory+"/Folder");
		int amount = pConfig.getInt("List.amount")+1;
		// Set
		pConfig.set("List.amount", amount+"");
		pConfig.set("List."+amount, Name);
		
		CustomFiles.saveArray(cf);
	}
	public static void listRemove(String parent, String directory, int slot, String name) {
		CustomFiles[] cf = Common.getCustomFiles(1);
		FileConfiguration pConfig = cf[0].gfc(parent, directory + "/Folder");
		int amount = pConfig.getInt("List.amount");
		int targetID = 0;
		for (int i = 0; i <= amount; i++) {
			if (Objects.equals(pConfig.getString("List." + i), name)) {
				targetID = i;
				break;
			}
		}
		pConfig.set("List.amount", amount - 1 + "");
		for (int i = amount; i > targetID; i--) {
			pConfig.set("List." + i, "Location." + (i - 1));
		}
		CustomFiles.saveArray(cf);
	}


}
