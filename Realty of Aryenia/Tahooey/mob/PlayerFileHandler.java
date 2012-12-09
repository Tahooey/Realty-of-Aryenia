package mob;

import java.io.*;
import java.util.*;

import def.Engine;

public class PlayerFileHandler {
	
	public String PlayerReadName;
	public int PlayerReadX;
	public int PlayerReadY;
	public int PlayerReadXOff;
	public int PlayerReadYOff;
	public int PlayerReadMaxHealth;
	public int PlayerReadCurHealth;
	public String PlayerReadMob;
	
	File player = new File("res/player01.thu");
	FileWriter fw;
	Scanner ps;
	
	public PlayerFileHandler(){
		if(!player.exists()){
			try {
				fw = new FileWriter(player);
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				WriteStartPlayerData();
			} catch (IOException e) {
				e.printStackTrace();						
			}
		}
		try {
			ps = new Scanner(player);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		readPlayerData();
	}
	
	public void save() throws IOException{
		try {
			fw = new FileWriter(player);
		} catch (IOException e) {
			e.printStackTrace();
		}
		fw.write(Engine.mb.ENTITIES[0].name+"\r\n");
		fw.write(Engine.mb.ENTITIES[0].x+" "+Engine.mb.ENTITIES[0].y+"\r\n");
		fw.write(Engine.mb.ENTITIES[0].xoffset+" "+Engine.mb.ENTITIES[0].yoffset+"\r\n");
		fw.write(Engine.mb.ENTITIES[0].currentHealth+" "+Engine.mb.ENTITIES[0].maxHealth+"\r\n");
		fw.write(Engine.mb.ENTITIES[0].mobName);
		
		fw.flush();
		fw.close();
	}
		
	public void WriteStartPlayerData() throws IOException{
		fw.write("Player\r\n");
		fw.write("24 24\r\n");
		fw.write("0 0\r\n");
		fw.write("100 100\r\n");
		fw.write("Player");
		
		fw.flush();
		fw.close();
	}
	
	public void readPlayerData(){
		PlayerReadName=ps.next();
		PlayerReadX=ps.nextInt();
		PlayerReadY=ps.nextInt();
		PlayerReadXOff=ps.nextInt();
		PlayerReadYOff=ps.nextInt();
		PlayerReadCurHealth=ps.nextInt();
		PlayerReadMaxHealth=ps.nextInt();
		PlayerReadMob=ps.next();
	}

}
