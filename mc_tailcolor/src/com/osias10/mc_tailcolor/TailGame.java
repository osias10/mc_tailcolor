package com.osias10.mc_tailcolor;

import java.util.ArrayList;

import org.bukkit.entity.Player;

import java.util.*;

public class TailGame {
	
	

	static ArrayList<Player> playerList = new ArrayList<Player>();
	ArrayList<Player> playerLiving= new ArrayList<Player>();
	ArrayList<Player> playerDead= new ArrayList<Player>();
	ArrayList<Player> playerGame= new ArrayList<Player>();
	static ArrayList<String> wools= new ArrayList<String>(Arrays.asList("Red Wool","Orange Wool","Yellow Wool","Green Wool","Blue Wool","Purple Wool","Black Wool","Pink Wool"));
	static ArrayList<String> woolsKor= (ArrayList<String>) (Arrays.asList("빨강","주황","노랑","초록","파랑","보라","검정","핑크"));
	ArrayList<String> woolsGame= new ArrayList<String>();
	ArrayList<String> woolsGameKor= new ArrayList<String>();
	
	static public boolean statusGame = false;
	
	public void participation(Player playerName) {
		if (!playerList.contains(playerName)) {
			playerList.add(playerName);
			
		}
		
	}
	
	public  String printParticipations() {
		String printPlayerList = new String();
		printPlayerList += "참가중인 플레이어 목록 ("+playerList.size()+"명)";
		for (int i=0;i<playerList.size();i++) {
			printPlayerList+="\n"+playerList.get(i).getPlayerListName();
		}
		return (printPlayerList);
	}
	public void unparticipation(Player playerName) {
		if (playerList.contains(playerName)) {
			playerList.remove(playerName);
			
		}
		
	}
	public boolean checkGame() {
		return statusGame;
	}
	public boolean startGame() {
		if (statusGame==true) {
			return false;
		}
		else {
			for (Player p : playerList) {
				playerLiving.add(p);
				playerGame.add(p);
				
			}
			
			Collections.shuffle(playerGame);
			woolsGame.subList(0, playerList.size());
			woolsGameKor.subList(0, playerList.size());
			
			statusGame=true;
			return true;
		}
	}
	public boolean stopGame() {
		if (statusGame==false) {
			return false;
		}
		else {
			playerList = new ArrayList<Player>();
			playerLiving= new ArrayList<Player>();
			playerDead= new ArrayList<Player>();
			playerGame= new ArrayList<Player>();
			statusGame=false;
			return true;
		}
	}
	
	//살아있는 사람 목록
	public String printPlayerLiving() {
		String printPlayerLiving = new String();
		if (statusGame==true) {
			
			for (int i=0;i<playerLiving.size();i++) {
				
				printPlayerLiving+="\n"+playerLiving.get(i).getPlayerListName();
			}
			return printPlayerLiving;
		}
		else {
			return "현재 게임중이 아닙니다.";
		}
	}
	
	public String printTest() {
		
		
		String printPlayerGaming = new String();
		for (int i=0;i<playerLiving.size();i++) {
			printPlayerGaming+="\n"+playerGame.get(i).getPlayerListName();
		}
		return printPlayerGaming;
	}
}
