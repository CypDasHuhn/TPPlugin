package de.CypDasHuhn.TpPl.commands;

import de.CypDasHuhn.TpPl.Common;
import de.CypDasHuhn.TpPl.CustomFiles;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class Teleport {
	public static void teleport(String pName, String Directory, String Name, boolean all) {
		//Prework
		CustomFiles[] cf = Common.getCustomFiles(1);
		Player p = null;
		if (pName != null) p = Bukkit.getPlayer(pName);

		return;
	}public static void teleportUser(Player p, String[] args, Location l) {
		//Prework
		String pName = args[0]; //Player
		String lName = args[1]; //Location
			String args2;
			if (args.length < 3) args2 = p.getName();
			else if (args[2] == null) args2 = p.getName();
			else args2 = args[2];
		String tName = args2; //Target
		CustomFiles[] cf = Common.getCustomFiles(1);
		FileConfiguration pdConfig = cf[0].gfc("Players", "");
		
		//Check
		if (pdConfig.getString("Players.Name."+pName) == null) {
			
			return;
		} if (pdConfig.getString("Players.Name."+tName) == null) {
			if (! (tName.equals("@p") || tName.equals("@r") || tName.equals("@a") ) ) {
				
				return;
			}//Transfer @'s
			switch (tName) {
				case "@p":
					teleport(Common.getNearestPlayer(l).getName(),Bukkit.getPlayer(pName).getUniqueId().toString(),lName,false);
					break;
				case "@r":
					teleport(Common.getRandomPlayer().getName(),Bukkit.getPlayer(pName).getUniqueId().toString(),lName,false);
					break;
				case "@a":
					teleport(null,Bukkit.getPlayer(pName).getUniqueId().toString(),lName,true);
					break;
					default:
						break;
			}
			return;
		}
		//Transfer
		teleport(tName,Bukkit.getPlayer(pName).getUniqueId().toString(),lName,false);
	}
}
