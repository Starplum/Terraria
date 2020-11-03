package network.starplum.commands;

import java.util.Random;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.TabExecutor;
import network.starplum.Terraria;

public class BaiChat extends Command implements TabExecutor {

	@Override public String toString() { return "what bout nah ?"; }
	
	public BaiChat() {
		super("gclear", "terraria.staff");
		ProxyServer.getInstance().getPluginManager().registerCommand(Terraria.getTerraria(), this);
	}
	
	@Override
	public void execute(CommandSender arg0, String[] arg1) {
		
		final CommandSender sender = arg0;
		final boolean isPlayer = sender instanceof ProxiedPlayer;
		
		if(!isPlayer) { return; }
		
		final ProxiedPlayer player = (ProxiedPlayer) sender;
		
		ProxyServer.getInstance().getPlayers().forEach(pl -> {
			if(!pl.hasPermission("terraria.staff")) {
				for(int a = 0; a < 100; a++) {
					Random random = new Random();
					pl.sendMessage(new ComponentBuilder("§" + random.nextInt(9)).create());
				} pl.sendMessage(new ComponentBuilder("§8* §7Global chat has been cleared by §7" + player.getName()).create());
			}
		});
		
	}
	
	@Override
	public Iterable<String> onTabComplete(CommandSender arg0, String[] arg1) {
		// TODO useful really ?
		return null;
	}
	
}
