package me.masonrapa.lobby;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	public static Main plugin;
	public static String pr,noperm,fly_on,fly_off,aon,aoff,invalid_args;
	
	public void onEnable() {
		plugin = this;
		Bukkit.getServer().getConsoleSender().sendMessage("§c§l[Plugin] §aMasonrapa created me!");
		getConfig().options().copyDefaults(true);
		getServer().getPluginManager().registerEvents(this, this);
		saveDefaultConfig();
		getCommand("fly").setExecutor(new FlyCommand());
	}

	public void onDisable() {
		Bukkit.getServer().getConsoleSender().sendMessage("§c§l[Plugin] §aMasonrapa deleted me!");
	}
	
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "gamemode 2 "+p.getName());
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "say HELLO "+p.getName());
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tp "+p.getPlayer().getName()+" 1 87 0");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "effect "+p.getPlayer().getName()+" 1 99999 1");
        p.sendMessage("");
        p.sendMessage("§5****************************************************");
        p.sendMessage("§6Bienvenido §a"+p.getName()+" §cA Nuestro servidor §4RageMC.es");
        p.sendMessage("§bUtiliza la pagina help.RageMC.es para obtener informacion sobre las normas de comportamiento y conseguir las entradas a nuestro foro, tienda, website o discord");
        p.sendMessage("§1Esperamos que disfrutes de tu estancia!!!");
        p.sendMessage("§5****************************************************");
        p.sendMessage("");
    }
}
