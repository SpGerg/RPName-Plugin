package frpn.main.spgerg;

import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	private ConfigFRP config = new ConfigFRP(this);
	
	@Override
	public void onEnable() {
		this.getLogger().info("Plugin enable!");
		
		this.getServer().getPluginManager().registerEvents(new Events(this, config), this);
		this.getCommand("changename").setExecutor(new Commands(this, config));
	}
}