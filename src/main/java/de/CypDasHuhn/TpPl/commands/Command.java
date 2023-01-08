package de.CypDasHuhn.TpPl.commands;

import de.CypDasHuhn.TpPl.Interface.FolderInterface.FolderInterface;
import de.CypDasHuhn.TpPl.commands.Register.RegisterLocation;
import org.bukkit.Bukkit;
import org.bukkit.command.BlockCommandSender;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
		Player p = null;
		if (sender instanceof Player) {
			p = (Player) sender;
			String uuid  = p.getUniqueId().toString();
			switch (label) {
				case "t":
					if (args.length == 0) FolderInterface.Interface(p, uuid, "General", 1, 5); // Interface
					else Teleport.teleport(p.getName(),p.getUniqueId().toString(),args[0], false); // Normal
					break;
				case "tg":
					break;
				case "tu":
					if (args.length == 1) FolderInterface.Interface(p, Bukkit.getPlayer(args[0]).getUniqueId().toString(), "General", 1, 5);
					else Teleport.teleportUser(p, args, p.getLocation());
					break;
				case "ts":
					RegisterLocation.registerLocation(p.getUniqueId().toString(),p,args[0],"General",-1, false);
					break;
				case "td":
					break;
				case "th":
					break;
				case "tl":
					break;
				case "tla":
					break;
					
					default:
						break;
			}
		}else if (sender instanceof BlockCommandSender commandBlock){
			switch (label) {
				case "tg":
					
					break;
				case "tu":
					Teleport.teleportUser(null, args, commandBlock.getBlock().getLocation());
					break;
			}
		}
		return false;
	}
}
