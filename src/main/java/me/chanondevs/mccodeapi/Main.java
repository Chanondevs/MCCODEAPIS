package me.chanondevs.mccodeapi;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static void sendMessageConsole(String message){
        Bukkit.getConsoleSender().sendMessage(message.replaceAll("&","§"));
    }

    private static Main main;

    @Override
    public void onEnable() {
        main = this;
        sendMessageConsole("");
        sendMessageConsole("&7___  ________  _____ ___________ _____  ___  ______ _____ ");
        sendMessageConsole("&7|  \\/  /  __ \\/  __ \\  _  |  _  \\  ___|/ _ \\ | ___ \\_   _|");
        sendMessageConsole("&7| .  . | /  \\/| /  \\/ | | | | | | |__ / /_\\ \\| |_/ / | |  ");
        sendMessageConsole("&7| |\\/| | |    | |   | | | | | | |  __||  _  ||  __/  | |  ");
        sendMessageConsole("&7| |  | | \\__/\\| \\__/\\ \\_/ / |/ /| |___| | | || |    _| |_ ");
        sendMessageConsole("&7\\_|  |_/\\____/ \\____/\\___/|___/ \\____/\\_| |_/\\_|    \\___/ ");
        sendMessageConsole("");
        registerListener();
        sendMessageConsole("&7- &aRegister Listener Success");
    }

    @Override
    public void onDisable() {
        main = null;
    }

    public void registerListener(){
        PluginManager register = Bukkit.getPluginManager();
        register.registerEvents(new Inventoria(), this);
    }

    public Main getCore(){
        return main;
    }
}
