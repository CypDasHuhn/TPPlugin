package de.CypDasHuhn.TpPl.main;

import de.CypDasHuhn.TpPl.TabComp;
import de.CypDasHuhn.TpPl.commands.Command;
import de.CypDasHuhn.TpPl.listeners.ChatListener;
import de.CypDasHuhn.TpPl.listeners.InventoryClickListener;
import de.CypDasHuhn.TpPl.listeners.InventoryCloseListener;
import de.CypDasHuhn.TpPl.listeners.PlayerJoinListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	private static Main plugin; 
	
	public void onEnable() {
		Bukkit.broadcastMessage("HALLO");
		if (!getDataFolder().exists()) {
			getDataFolder().mkdirs();
		}
		plugin = this;
		getCommand("t").setExecutor(new Command());
		getCommand("t").setTabCompleter(new TabComp());
		getCommand("tg").setExecutor(new Command());
		getCommand("tg").setTabCompleter(new TabComp());
		getCommand("tu").setExecutor(new Command());
		getCommand("tu").setTabCompleter(new TabComp());
		getCommand("ts").setExecutor(new Command());
		getCommand("ts").setTabCompleter(new TabComp());
		getCommand("td").setExecutor(new Command());
		getCommand("td").setTabCompleter(new TabComp());
		getCommand("th").setExecutor(new Command());
		getCommand("th").setTabCompleter(new TabComp());
		getCommand("tl").setExecutor(new Command());
		getCommand("tl").setTabCompleter(new TabComp());
		getCommand("tla").setExecutor(new Command());
		getCommand("tla").setTabCompleter(new TabComp());
		PluginManager pluginManager = Bukkit.getPluginManager();
		pluginManager.registerEvents(new PlayerJoinListener(), this);
		pluginManager.registerEvents(new InventoryCloseListener(), this);
		pluginManager.registerEvents(new InventoryClickListener(), this);
		pluginManager.registerEvents(new ChatListener(), this);
	}
	public static Main getPlugin(){
		return plugin;
	}
}
