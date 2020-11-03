package network.starplum;

import net.md_5.bungee.api.plugin.Plugin;
import network.starplum.commands.Server;

public class Terraria extends Plugin {
	
	private static Terraria terraria;
	public static Terraria getTerraria() { return terraria; }
	
	@Override
	public void onEnable() {
		terraria = this;
		
		new Server();
		
	}
	
	@Override public String toString() { return "Are you okay or..?"; }

}
