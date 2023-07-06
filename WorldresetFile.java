package de.tempoo50.system.files;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;

public class WorldresetFile {

	public static void loadWorldReset() {

		File file = new File("plugins//ServerSystem//WorldSaves//WorldReset.yml");
		YamlConfiguration config = YamlConfiguration.loadConfiguration(file);

		config.addDefault("Welt1", "Farmwelt");
		config.addDefault("Welt2", "Nether");
		config.addDefault("Welt3", "Ende");

		config.options().copyDefaults(true);
		try {
			config.save(file);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}