import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {
	
	public static ArrayList<Player> flymode = new ArrayList();
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
		Player p = (Player)sender;
		if(cmd.getName().equalsIgnoreCase("fly")) {
			if (p.hasPermission("fly.use")) {
				if(args.length == 0) {
					if (!flymode.contains(p)) {
						flymode.add(p);
						p.setAllowFlight(true);
						p.setFlying(true);
						p.sendMessage("§aModo magico de vuelo §9activado§a!");	
					}
					else {
						flymode.remove(p);
						p.setAllowFlight(false);
						p.setFlying(false);
						p.sendMessage("§aModo magico de vuelo §cdesactivado§a!");	
					}
				}
				else {
					if (args[0].equalsIgnoreCase("on")) {
						if (!flymode.contains(p)) {
							flymode.add(p);
							p.setAllowFlight(true);
							p.setFlying(true);
							p.sendMessage("§aModo magico de vuelo §9activado§a!");	
						}
						else {
							p.sendMessage("§bEn Tierra!");
						}
					}
					else if (args[0].equalsIgnoreCase("off")) {
						if (!flymode.contains(p)) {
							flymode.remove(p);
							p.setAllowFlight(true);
							p.setFlying(true);
							p.sendMessage("§aModo magico de vuelo §cdesactivado§a!");	
						}
						else {
							p.sendMessage("§bEn Vuelo");
						}
					}
					else {
						p.sendMessage("§2Error en la sintaxis del comando");
					}
				}
			}
			else {
				p.sendMessage("§4No tienes el permiso de hacer esto, puedes conseguirlo en la tienda oficial de RageMC");
			}
		}
		return false;
			}
	}
