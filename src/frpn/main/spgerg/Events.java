package frpn.main.spgerg;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Events implements Listener {
	
	private Main plugin;
	private ConfigFRP config;
	
	public Events(Main plugin, ConfigFRP config) {
		this.plugin = plugin;
		this.config = config;
	}
	
	@EventHandler
	public void onPlayerMessage(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		String s = config.GetNames(p.getName());
		
		e.setFormat(s + ": " + e.getMessage());
	}
}
