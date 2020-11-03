package network.starplum.commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.TabExecutor;
import network.starplum.Terraria;

public class Halp extends Command implements TabExecutor {
	
	@Override public String toString() { return "nah"; }
	
	public Halp() {
		super("ghelp");
		ProxyServer.getInstance().getPluginManager().registerCommand(Terraria.getTerraria(), this);
	}
	
	@Override public void execute(CommandSender arg0, String[] arg1) {
		
		final CommandSender sender = arg0;
		final boolean isPlayer = sender instanceof ProxiedPlayer;
		
		if(!isPlayer) { return; }
		
		ProxiedPlayer player = (ProxiedPlayer) sender;
		
		final TextComponent text = new TextComponent("§8* §7Command coming soon. please refer to the local §f/help §7command.");
		text.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§2✔ §fClick here to get the command in your chat.").create()));
		text.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/help"));
		
		player.sendMessage(text);
		
	}
	
	@Override public Iterable<String> onTabComplete(CommandSender arg0, String[] arg1) {
		// TODO: will this even be useful for this command ?
		return null;
	}

}
