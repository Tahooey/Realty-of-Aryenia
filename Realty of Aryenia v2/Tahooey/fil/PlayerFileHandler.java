package fil;

import java.io.*;
import java.util.*;

import def.Engine;

public class PlayerFileHandler {
	
	File pf;
	FileWriter fw;
	Scanner ps;
	
	public String WrittenPlayerName="Tahooey";
	public int WrittenPlayerX=16,WrittenPlayerY=16;
	public int WrittenPlayerType=1,WrittenPlayerLayer=2;

	public String ReadPlayerName;
	public int ReadPlayerX,ReadPlayerY;
	public int ReadPlayerType,ReadPlayerLayer;
	public int ReadPlayerMap;
	
	public int[][] ITEMS = new int[8][8];
	
	public PlayerFileHandler(String map){
		pf=new File("res/worlds/"+map+"/player.thu");
		if(!pf.exists()){
			try {
				pf.createNewFile();
				fw=new FileWriter(pf);
				WritePlayer();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		try {
			ps=new Scanner(pf);
			ReadPlayer();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void ReadPlayer(){
		ReadPlayerName=ps.next();
		ReadPlayerX=ps.nextInt();
		ReadPlayerY=ps.nextInt();
		ReadPlayerType=ps.nextInt();
		ReadPlayerLayer=ps.nextInt();
		ReadPlayerMap=ps.nextInt();
		for(int h=0;h<ITEMS.length;h++){
			for(int w=0;w<ITEMS[h].length;w++){
				ITEMS[h][w]=ps.nextInt();
			}
		}
	}
	
	public void save() throws IOException{
		fw = new FileWriter(pf);
		fw.write(Engine.mb.MOBS[0].Name+"\r\n");
		fw.write(Engine.mb.MOBS[0].finalx/def.Frame.SCALE+" "+Engine.mb.MOBS[0].finaly/def.Frame.SCALE+"\r\n");
		fw.write(Engine.mb.MOBS[0].ID+"\r\n");
		fw.write(Engine.mb.MOBS[0].Layer+" "+Engine.mb.MOBS[0].map+"\r\n");
		for(int h=0;h<Engine.mb.MOBS[0].inv.ItemH;h++){
			for(int w=0;w<Engine.mb.MOBS[0].inv.ItemW;w++){
				fw.write(Engine.mb.MOBS[0].inv.ITEMS[h][w].ID+" ");
			}
			fw.write("\r\n");
		}
		
		fw.flush();
		fw.close();
	}
	
	public void WritePlayer() throws IOException{
		fw.write(WrittenPlayerName+"\r\n");
		fw.write(WrittenPlayerX+" "+WrittenPlayerY+"\r\n");
		fw.write(WrittenPlayerType+"\r\n");
		fw.write(WrittenPlayerLayer+" 0\r\n");
		
		writeInv();
		
		fw.flush();
		fw.close();
	}
	
	public void writeInv() throws IOException{
		for(int h=0;h<ITEMS.length;h++){
			for(int w=0;w<ITEMS[h].length;w++){
				fw.write(0+" ");
			}
			fw.write("\r\n");
		}
	}

}
