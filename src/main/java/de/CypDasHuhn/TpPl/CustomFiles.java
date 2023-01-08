package de.CypDasHuhn.TpPl;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class CustomFiles {
	private File file;
	private FileConfiguration customFile;
	                                             //GetFileConfiguration
	public FileConfiguration gfc(String name, String folder) {
		file = new File(Bukkit.getServer().getPluginManager().getPlugin("TPPlugin").getDataFolder()+"/"+folder, name+".yml");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		customFile = YamlConfiguration.loadConfiguration(file);
		return customFile;
	}
	
	public void save() {
		try {
			customFile.save(file);
		} catch (IOException e) {

		}

	}

	public static void saveArray(CustomFiles[] cf) {
		for (CustomFiles customFile : cf) {
			customFile.save();
		}
	}
	
	public void reload() {
		customFile = YamlConfiguration.loadConfiguration(file);
	}
	
	public void delete(String name, String folder) {
		file = new File(Bukkit.getServer().getPluginManager().getPlugin("TPPlugin").getDataFolder()+"/"+folder, name+".yml");
		if (file.exists()) file.delete();
	}
}
