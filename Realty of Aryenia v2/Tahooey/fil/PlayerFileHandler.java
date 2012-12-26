package fil;

import java.io.*;
import java.util.*;

public class PlayerFileHandler {
	
	File pf;
	FileWriter fw;
	Scanner ps;
	
	public String WrittenPlayerName="Player";
	public int WrittenPlayerX=16,WrittenPlayerY=16;
	public int WrittenPlayerType=1,WrittenPlayerLayer=2;

	public String ReadPlayerName;
	public int ReadPlayerX,ReadPlayerY;
	public int ReadPlayerType,ReadPlayerLayer;
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
	}
	
	public void WritePlayer() throws IOException{
		fw.write(WrittenPlayerName+"\r\n");
		fw.write(WrittenPlayerX+" "+WrittenPlayerY+"\r\n");
		fw.write(WrittenPlayerType+"\r\n");
		fw.write(WrittenPlayerLayer+"\r\n");
		
		fw.flush();
		fw.close();
	}

}
