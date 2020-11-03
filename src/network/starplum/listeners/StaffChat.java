package network.starplum.listeners;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import network.starplum.Terraria;

public class StaffChat implements Listener {
	
	public StaffChat() { ProxyServer.getInstance().getPluginManager().registerListener(Terraria.getTerraria(), this); }
	
	@EventHandler public void chat(ChatEvent event) {
		
		ProxiedPlayer player = (ProxiedPlayer) event.getSender();
		final String message = event.getMessage().replaceFirst("# ", "");
		
		if(message.startsWith("# ")) {
			if(player.hasPermission("terraria.staff")) {
				event.setCancelled(true);
				ProxyServer.getInstance().getPlayers().forEach(pl -> {
					if(pl.hasPermission("terraria.staff")) {
						final String server = player.getServer().getInfo().getName();
						final TextComponent a = new TextComponent("§7(" + server + ") §f" + player.getName() + " §8・ §f" + message);
						pl.sendMessage(a);
					}
				});
			}
		}
		
	}

}
