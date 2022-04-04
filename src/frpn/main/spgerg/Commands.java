package frpn.main.spgerg;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {
	private Main plugin;
	private ConfigFRP config;
	
	public Commands(Main plugin, ConfigFRP config) {
		this.plugin = plugin;
		this.config = config;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		
		if(sender instanceof Player && cmd.getName().equalsIgnoreCase("changename") && args.length != 0) {
			config.SaveName(args[0], args[1], player.getName());
		}
		
		return true;
	}
}
