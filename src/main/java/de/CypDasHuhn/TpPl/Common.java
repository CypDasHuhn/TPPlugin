package de.CypDasHuhn.TpPl;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class Common {
	////////// CREATE CUSTOM FILES ////////////////
	public static CustomFiles[] getCustomFiles(int amount) {
		CustomFiles[] cf = new CustomFiles[amount];
		for (int i = 0; i <= amount-1; i++) {
			cf[i] = new CustomFiles();
		}return cf;
	}/////// CREATE ITEM//////////////////////////
	public static ItemStack createItem(Material m, String name, boolean glitzer, List<String> lore) {
		ItemStack item = new ItemStack(m);
		ItemMeta itemMeta = item.getItemMeta();
		itemMeta.setDisplayName(name);
		itemMeta.setLore(lore);
		if (glitzer) {
			itemMeta.addEnchant(Enchantment.DAMAGE_ALL, 0, true);
			itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		}item.setItemMeta(itemMeta);
		return item;
	}
	//////////////// @R ////////////////
	public static Player getRandomPlayer() {
		Player p = null;
		int playerAmount = Bukkit.getOnlinePlayers().size();
		int randomInt =  (int)(Math.random()*(playerAmount-1+1)+1);
		int i = 1;
		for (Player a : Bukkit.getOnlinePlayers()) {
			if (i == randomInt) p = a;
			i++;
		}return p;
	}////////////// @P //////////////
	public static Player getNearestPlayer(Location position) {
		World world = position.getWorld();
		Player nearestPlayer = null;
		double nearestDistance = Double.MAX_VALUE;
		for (Player player : world.getPlayers()) {
			double distance = player.getLocation().distance(position);
			if (distance < nearestDistance) {
				nearestPlayer = player;
				nearestDistance = distance;
			}
		}
		return nearestPlayer;
	}
	///// ILLEGAL CHARACTER
	public static boolean illegalCharacter(String name) {
		return (name.contains("/") ||
				name.contains("\\") ||
				name.contains(":") ||
				name.contains("*") ||
				name.contains("?") ||
				name.contains("\"") ||
				name.contains("<") ||
				name.contains(">") ||
				name.contains("|"));
	}
	
}
