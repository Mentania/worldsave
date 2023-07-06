package de.tempoo50.system.commands;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import de.tempoo50.system.utils.MapReset;
import de.tempoo50.system.utils.MessagesUtil;

public class SaveCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String list, String[] args) {

		Player player = (Player) sender;

		File perm = new File("plugins//ServerSystem//Permission.yml");
		YamlConfiguration per = YamlConfiguration.loadConfiguration(perm);

		if (player.hasPermission((String) per.get("MapReset.Save"))) {
			if (args.length == 0) {

				File file = new File("plugins//ServerSystem//WorldSaves//WorldReset.yml");
				YamlConfiguration config = YamlConfiguration.loadConfiguration(file);

				MapReset.saveWorld(Bukkit.getWorld((String) config.get("Welt1")));
				MapReset.saveWorld(Bukkit.getWorld((String) config.get("Welt2")));
				MapReset.saveWorld(Bukkit.getWorld((String) config.get("Welt3")));
				player.sendMessage(MessagesUtil.SAVE + (String) config.get("Welt1") + (String) config.get("Welt2")
						+ (String) config.get("Welt3"));

			}
		} else {
			player.sendMessage(MessagesUtil.NOPERM);
		}
		return false;
	}

}
