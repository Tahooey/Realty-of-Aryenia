package fil;
import java.io.*;
import java.util.*;

public class MapFileOverLord {
	
	FileWriter fw;
	String directory;
	File list;
	File dir;
	Scanner ls;
	
	public int amount;
	public PlayerFileHandler pfh;
	public WorldFileHandler[] WFH;
	public int[] ReadWidth;
	public int[] ReadHeight;
	public int[] ReadLayers;
	public String[] ReadName;
	public MapFileOverLord(String mapName){
		directory = mapName;
		dir= new File("res/worlds/"+directory);
		list=new File("res/worlds/"+directory+"/maps.thu");
		if(!dir.exists()){
			dir.mkdir();
		}
		if(!list.exists()){
			try {
				list.createNewFile();
				writeList();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		pfh = new PlayerFileHandler(directory);
		try {
			readList();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void writeList() throws IOException{
		fw=new FileWriter(list);
		
		fw.write(1+"\r\n");
		fw.write("map 16 16 16");
		
		fw.flush();
		fw.close();
	}
	public void readList() throws FileNotFoundException{
		ls = new Scanner(list);
		amount=ls.nextInt();
		WFH = new WorldFileHandler[amount];
		ReadWidth = new int[amount];
		ReadHeight = new int[amount];
		ReadLayers = new int[amount];
		ReadName= new String[amount];
		for(int i=0;i<WFH.length;i++){
			ReadName[i]=ls.next();
			ReadWidth[i]=ls.nextInt();
			ReadHeight[i]=ls.nextInt();
			ReadLayers[i]=ls.nextInt();
			WFH[i]= new WorldFileHandler(directory,ReadWidth[i],ReadHeight[i],ReadLayers[i],ReadName[i]);
		}
	}

}
