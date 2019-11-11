package me.hypews.apocacore;

import me.hypews.apocacore.events.PlayerJoin;
import me.hypews.apocacore.events.PlayerLeave;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        System.out.println("ApocaCore loaded successfully.");
        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new PlayerLeave(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String CommandLabel, String[] args){
        if(cmd.getName().equalsIgnoreCase("fly")) {
            Player player;

            if (!(sender instanceof Player)) {
                sender.sendMessage("Only players may use this command!");
                return false;
            }
            player = (Player) sender;
            if (player.hasPermission("Apoca.fly")) {
                player.setAllowFlight(!(player.getAllowFlight()));
                sender.sendMessage(ChatColor.GREEN + "Flight has been enabled!");
            } else {
                String noperm = getConfig().getString("no_perms");
                player.sendMessage(ChatColor.RED + noperm);
            }
        }


        if(cmd.getName().equalsIgnoreCase("gmc")) {
            Player player;

            if (!(sender instanceof Player)) {
                sender.sendMessage("Only players may use this command!");
                return false;
            }
            player = (Player) sender;
            if (player.hasPermission("Apoca.gamemode.gmc")) {
                player.setGameMode(GameMode.CREATIVE);
                sender.sendMessage(ChatColor.GOLD + "You are now in Creative");
            } else {
                String noperm = getConfig().getString("no_perms");
                player.sendMessage(ChatColor.RED + noperm);
            }
        }


        if(cmd.getName().equalsIgnoreCase("gms")) {
            Player player;

            if (!(sender instanceof Player)) {
                sender.sendMessage("Only players may use this command!");
                return false;
            }
            player = (Player) sender;
            if (player.hasPermission("Apoca.gamemode.gms")) {
                player.setGameMode(GameMode.SURVIVAL);
                sender.sendMessage(ChatColor.GOLD + "You are now in Survival");
            } else {
                String noperm = getConfig().getString("no_perms");
                player.sendMessage(ChatColor.RED + noperm);
            }
        }


        if(cmd.getName().equalsIgnoreCase("gmsp")) {
            Player player;

            if (!(sender instanceof Player)) {
                sender.sendMessage("Only players may use this command!");
                return false;
            }
            player = (Player) sender;
            if (player.hasPermission("Apoca.gamemode.gmsp")) {
                player.setGameMode(GameMode.SPECTATOR);
                sender.sendMessage(ChatColor.GOLD + "You are now in Spectator");
            } else {
                String noperm = getConfig().getString("no_perms");
                player.sendMessage(ChatColor.RED + noperm);
            }
        }

        if(sender instanceof Player){
                if(cmd.getName().equalsIgnoreCase("gmo")){
                    Player player = (Player) sender;
                    if(args.length == 0) {
                        player.sendMessage(ChatColor.RED + "Please use this format: /gmo <tagerted player> <gamemode>");
                    } else {
                        Player target = Bukkit.getPlayerExact(args[0]);
                        String gamemode = args[1];
                        target.setGameMode(GameMode.valueOf(gamemode));
                        sender.sendMessage(ChatColor.GOLD + "Set " + ChatColor.RED + target + ChatColor.GOLD + "'s gamemode to " + ChatColor.AQUA + gamemode);
            }
            }


        }else{
            sender.sendMessage("Only players may execute this command!");
        }

            return true;
        }

}

