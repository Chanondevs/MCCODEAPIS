package me.chanondevs.mccodeapi.configmanager;

import me.chanondevs.mccodeapi.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class ConfigManage {

    private static HashMap<String,ConfigManage> configManage = new HashMap<>();
    private File file;
    private FileConfiguration config;
    private String name;

    public ConfigManage(JavaPlugin main,String file_name){
        this.file = new File(main.getDataFolder()+"//"+file_name+".yml");
        this.name = file_name;
        this.config = YamlConfiguration.loadConfiguration(file);
        configManage.put(name, this);
    }

    public static ConfigManage getConfigManager(String file_name){
        return configManage.get(file_name);
    }

    public String getName(){
        return name;
    }

    public File getFile(){
        return file;
    }

    public FileConfiguration getConfig(){
        return config;
    }

    public void save() throws IOException {
        getConfig().save(getFile());
    }

    public static void saveAll() throws IOException {
        for (ConfigManage file : configManage.values()){
            file.save();
        }
    }

}
