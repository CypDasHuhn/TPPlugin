package de.CypDasHuhn.TpPl;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class TabComp implements TabCompleter {
	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
		// Prework
		Player p = (Player) sender;
		CustomFiles[] cf = Common.getCustomFiles(1);
		List <String> arguments = new ArrayList<String>();
		FileConfiguration lConfig = cf[0].gfc("List", p.getUniqueId()+"");
		// Set
		switch (label) {
			case "t":
				if (args.length == 1) {
					arguments = getLocations(p.getUniqueId()+"","Private");
				}
				break;
			case "ts":
				if (args.length == 1) {
					arguments.add("[Name]");
				}
				break;
			case "tu":
				if (args.length == 1) {

				}
				break;
			case "tg":
				
				break;
			case "tl":
				
				break;
			case "tla":
				
				break;
				default:
					
					break;
		}
		List <String> result = new ArrayList<String>();
		if (args.length == 1) {
			for (String a : arguments) {
				if (a.toLowerCase().startsWith(args[0].toLowerCase())) {
					result.add(a);
				}
			}return result;
		}
		return null;
	}
	
	public static List<String> getLocations(String directory, String prefix) {
		List<String> arguments = new ArrayList<String>();
		CustomFiles[] cf = Common.getCustomFiles(1);
		FileConfiguration lConfig = cf[0].gfc("List", directory);

		int amount = lConfig.getInt("Location."+prefix+".ammount");
		
		for (int i = 1; i <= amount; i++) {
			arguments.add(lConfig.getString("Location."+prefix+"."+i));
		}
		
		return arguments;
	}
}
