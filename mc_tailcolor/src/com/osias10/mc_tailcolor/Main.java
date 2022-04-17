package com.osias10.mc_tailcolor;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin implements Listener {

	ConsoleCommandSender consol = Bukkit.getConsoleSender();

	@Override
	public void onEnable() {
		
		consol.sendMessage(ChatColor.AQUA + "[플러그인 활성화 중 입니다.]");
		saveDefaultConfig();
		getServer().getPluginManager().registerEvents(this, this);
		//getCommand("tc").setExecutor(new Command());

		//getServer().getPluginManager().registerEvents(new PlayerMovementListener(), this);
		TailGame tailGame = new TailGame();
		TailGameCommand.setPlugin(tailGame);
		getCommand("tc").setExecutor(new TailGameCommand());
		
		

	}

	@Override
	public void onDisable() {

		consol.sendMessage(ChatColor.AQUA + "[플러그인 비활성화 중 입니다.]");

	}

	@EventHandler
	public void join(PlayerJoinEvent e) {

		e.setJoinMessage(ChatColor.RED + "입장했습니다!");

	}
	@EventHandler
	public void onKill(PlayerDeathEvent e){
		try {
			String killed = e.getEntity().getName();
			String killer = e.getEntity().getKiller().getName();
			e.setDeathMessage(ChatColor.RED + killed + " 가 " + killer+"에게 죽었습니다");
		}
		catch(Exception e1){
			e.setDeathMessage("오류: killer가 존재하지 않습니다.");
		}
	//e.setDeathMessage(ChatColor.RED + killed + " has been slain by " + killer);
	}

}