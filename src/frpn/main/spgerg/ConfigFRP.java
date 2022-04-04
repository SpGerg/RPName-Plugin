package frpn.main.spgerg;

import java.io.File;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class ConfigFRP {
	
	private Main plugin;
	
	private File configFile;
	private File namesFile;
	
	public ConfigFRP() { }
	public ConfigFRP(Main plugin) {
		this.plugin = plugin;
		
		configFile = new File(plugin.getDataFolder() + File.separator + "config.yml");
		namesFile = new File(plugin.getDataFolder() + File.separator + "names.yml");
		
		if(!configFile.exists()) {
			plugin.getLogger().info("Config file not found!");
			plugin.getLogger().info("Create new config file!");
			
			plugin.saveDefaultConfig();
		}
	}
	
	public void SaveName(String name, String surname, String playerName) {
		FileConfiguration names = YamlConfiguration.loadConfiguration(namesFile);			
		List<String> namesList = names.getStringList("names");
		List<String> surnamesList = names.getStringList("surnames");
		List<String> playersList = names.getStringList("players");
		
		if(playersList.contains(playerName)) {
			for(int i = 0;i < names.getStringList("players").size();i++) {	
				if(names.getStringList("players").toArray()[i].toString().equals(playerName)) {		
					namesList.remove(i);
					surnamesList.remove(i);
					
					namesList.add(i, name);
					surnamesList.add(i, surname);
					
					names.set("names", namesList);
					names.set("surnames", surnamesList);
					names.set("players", playersList);
					
					try {
						names.save(namesFile);
					}
					catch(IOException e) {
						e.printStackTrace();
					}
					
					return;
				}
			}
		}	
		else {
			namesList.add(name);
			surnamesList.add(surname);
			playersList.add(playerName);
			
			names.set("names", namesList);
			names.set("surnames", surnamesList);
			names.set("players", playersList);
			
			try {
				names.save(namesFile);
			}
			catch(IOException e) {
				e.printStackTrace();
			}
			
			return;
		}
		
	}
	
	public String GetNames(String playerName) {
		FileConfiguration names = YamlConfiguration.loadConfiguration(namesFile);	
		
		for(int i = 0;i < names.getStringList("players").size();i++) {	
			if(names.getStringList("players").toArray()[i].toString().equals(playerName)) {		
				String str = names.getStringList("names").toArray()[i].toString() + " " + names.getStringList("surnames").toArray()[i].toString();
				return str;
			}
		}
		
		plugin.getLogger().info("Name not found!");
		
		return "John Doe";
	}
}
