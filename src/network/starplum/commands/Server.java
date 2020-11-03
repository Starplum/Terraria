package network.starplum.commands;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.TabExecutor;
import network.starplum.Terraria;

public class Server extends Command implements TabExecutor {

	public Server() {
		super("server");
		ProxyServer.getInstance().getPluginManager().registerCommand(Terraria.getTerraria(), this);
	}

	@Override public void execute(CommandSender arg0, String[] arg1) {
		
		CommandSender sender = arg0;
		final boolean isPlayer = sender instanceof ProxiedPlayer;
		final String[] args = arg1;
		
		if(!isPlayer) { return; }
		
		final ProxiedPlayer player = (ProxiedPlayer) sender;
		
		if(args.length > 1) {
			player.sendMessage(new ComponentBuilder("§8* §7You must put a server name to connect to !").create());
		} else if(args.length <= 1) {
			
			switch (args[0]) {
			case "lobby": { 
				final ServerInfo server = BungeeCord.getInstance().getServerInfo("lobby-1");
				if(alreadyConnected(player, server.getName())) { /** send that already connected*/ }
				player.connect(server);
			}
			case "star": {
				final ServerInfo server = BungeeCord.getInstance().getServerInfo("star");
				if(alreadyConnected(player, server.getName())) { /** send that already connected*/ }
				if(checkPermission(player, "terraria.staff")) { player.connect(server); } 
				else { /** no permission to join this server; yet.*/ }
			}
			case "imposter": {
				final ServerInfo server = BungeeCord.getInstance().getServerInfo("imposter");
				if(alreadyConnected(player, server.getName())) { /** send that already connected*/ }
				player.connect(server);
			}
			case "practice": {
				final ServerInfo server = BungeeCord.getInstance().getServerInfo("practice");
				if(alreadyConnected(player, server.getName())) { /** send that already connected*/ }
				player.connect(server);
			}
			case "oxkeep": {
				final ServerInfo server = BungeeCord.getInstance().getServerInfo("rpg");
				if(alreadyConnected(player, server.getName())) { /** send that already connected*/ }
				if(checkPermission(player, "terraria.staff")) { player.connect(server); } 
				else { /** no permission to join this server; yet.*/ }
			}
			case "bridge": {
				final ServerInfo server = BungeeCord.getInstance().getServerInfo("bridge");
				if(alreadyConnected(player, server.getName())) { /** send that already connected*/ }
				if(checkPermission(player, "terraria.staff")) { player.connect(server); } 
				else { /** no permission to join this server; yet.*/ }
			}
			case "zombie": {
				
				final ServerInfo server = BungeeCord.getInstance().getServerInfo("zombie");
				if(alreadyConnected(player, server.getName())) { /** send that already connected*/ }
				if(checkPermission(player, "terraria.staff")) { player.connect(server); } 
				else { /** no permission to join this server; yet.*/ }
			}

			default: { player.sendMessage(new ComponentBuilder("§8* §7An error occured..? §7(code: default)").create());}
			}
			
		}

	}
	
	@Override public Iterable<String> onTabComplete(CommandSender arg0, String[] arg1) {
		// TODO: make the method lol
		return null;
	}
	
	private boolean checkPermission(ProxiedPlayer proxiedPlayer, String permission) {
		if(proxiedPlayer.hasPermission(permission)) {
			return true;
		} else return false;
	}
	
	private boolean alreadyConnected(ProxiedPlayer proxiedPlayer, String server) {
		final ServerInfo info = proxiedPlayer.getServer().getInfo();
		if(info.getName() == server) {
			return true;
		} else return false;
	}

}
