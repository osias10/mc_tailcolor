package com.osias10.mc_tailcolor;

import org.bukkit.Bukkit;
//import org.bukkit.Location;
//import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TailGameCommand implements CommandExecutor{
	
	public static TailGame tailGame;
	
	public static void setPlugin(TailGame TailGame) {
		tailGame = TailGame;

	}
	
	 @Override
	    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

	    	if(sender instanceof Player){

	            Player p = (Player) sender;
	            //p.sendMessage("Successfully added marker at your location");
	    		
	    		if (args.length ==0) return false;
	    		
	    		if (args[0].equals("참가") || args[0].equals("in")){
	    			
	    			p.chat("참가하였습니다!");
	    			tailGame.participation(p);
	    			
	    		}
	    		else if (args[0].equals("list")) {
	    			//Bukkit.broadcastMessage(tailGame.printParticipations());
	    			p.sendMessage(tailGame.printParticipations());
	    		}
	    		else if (args[0].equals("참가해제") || args[0].equals("out")){
	    			p.chat("참가해제 되었습니다!");
	    			tailGame.unparticipation(p);
	    			
	    		}
	    		else if (args[0].equals("시작") || args[0].equals("start")){
	    			if (tailGame.startGame()==true) {
	    				Bukkit.broadcastMessage("게임을 시작합니다");
	    			}
	    			else {
	    				Bukkit.broadcastMessage("이미 게임이 진행중 입니다.");
	    			}
	    			
	    		}
	    		else if (args[0].equals("종료") || args[0].equals("stop")){
	    			if (tailGame.checkGame()==true) {
	    				tailGame.stopGame();
	    				Bukkit.broadcastMessage("게임이 종료되었습니다.");
	    			}
	    			else {
	    				Bukkit.broadcastMessage("게임이 실행중이 아닙니다.");
	    			}
	    			
	    		}
	    		//게임이 실행중일때
	    		if(tailGame.checkGame()==true) {
	    			if (args[0].equals("생존") || args[0].equals("live")) {
		    			p.sendMessage(tailGame.printPlayerLiving());
		    		}
		    		else if (args[0].equals("test")) {
		    			p.sendMessage(tailGame.printTest());

		    		}
	    		}
	    		
	    		
	    		
	            return true;

	        }else{

	            // Print to the command line that you need to be a player to execute this command
	            System.out.println("Cannot execute this command on the command line");

	            return false;

	        }

	    }

}
