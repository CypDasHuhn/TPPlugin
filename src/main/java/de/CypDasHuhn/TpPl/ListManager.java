package de.CypDasHuhn.TpPl;

import org.bukkit.configuration.file.FileConfiguration;

import java.util.Objects;

public class ListManager {
	public static void addOn(boolean location, boolean Private, String directory, String name) {
		//Prework
		CustomFiles[] cf = Common.getCustomFiles(1);
		FileConfiguration lConfig = cf[0].gfc("List", directory);
		String prefix = getPrefix(location, Private);
		int amount = lConfig.getInt(prefix+"amount")+1;
		// Set /////////////////
		lConfig.set(prefix+"amount", amount+"");
		lConfig.set(prefix+amount, name);
		
		CustomFiles.saveArray(cf);
		// Repeat (maybe)
		if (!Private) addOn(location, true, directory, name);
	}
	public static void removeFrom(boolean location, boolean Private, String directory, String name) {
		CustomFiles[] cf = Common.getCustomFiles(1);
		FileConfiguration lConfig = cf[0].gfc("List", directory);
		String prefix = getPrefix(location, Private);
		int amount = lConfig.getInt(prefix + "amount");
		int targetID = 0;
		for (int i = 0; i <= amount; i++) {
			if (Objects.equals(lConfig.getString(prefix + i), name)) {
				targetID = i;
				break;
			}
		}
		lConfig.set(prefix + "amount", amount - 1 + "");
		for (int i = amount; i > targetID; i--) {
			lConfig.set(prefix + i, prefix + (i - 1));
		}
		CustomFiles.saveArray(cf);
		if (Private) {
			removeFrom(location, false, directory, name);
		}
	}
	public static String getPrefix(boolean location, boolean Private) {
		return location ? (Private ? "Location.Private." : "Location.Public.") : "Folder.";
	}

}
