package mob;

import java.io.*;
import java.util.*;

public class MobFileHandler {
	public int WrittenTotalEntities=64;
	public String[] WrittenEntitiesName;
	public int[] WrittenEntitiesX;
	public int[] WrittenEntitiesY;
	public String[] WrittenEntitiesShownName;
	
	Random r = new Random();
	
	public int readTotalEntities;
	public String[] ReadEntitiesName;
	public int[] ReadEntitiesX;
	public int[] ReadEntitiesY;
	public String[] ReadEntitiesShownName;
	
	Player p=new Player(0,0,0);
	Wizard w=new Wizard(0,0,0);
	
	File mobs = new File("res/mob01.thu");
	FileWriter fw;
	Scanner ms;
	
	public MobFileHandler(){
		WrittenEntitiesName=new String[WrittenTotalEntities];
		WrittenEntitiesX=new int[WrittenTotalEntities];
		WrittenEntitiesY=new int[WrittenTotalEntities];
		ReadEntitiesName=new String[WrittenTotalEntities];
		ReadEntitiesX=new int[WrittenTotalEntities];
		ReadEntitiesY=new int[WrittenTotalEntities];
		if(!mobs.exists()){
			try {
				GenerateWrittenMobs();
				fw = new FileWriter(mobs);
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				WriteMobs();
			} catch (IOException e) {
				e.printStackTrace();						
			}
		}
		try {
			ms = new Scanner(mobs);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		readInfo();
		readMobsData();
	}
	
	public void GenerateWrittenMobs(){
		for(int i=0;i<WrittenTotalEntities;i++){
			int mobName=r.nextInt(3-1)+1;
			if(mobName==1){
				WrittenEntitiesName[i]=w.mobName;
			}else if(mobName==2){
				WrittenEntitiesName[i]=p.mobName;
			}else{
				System.out.println("ERROR");
				WrittenEntitiesName[i]=p.mobName;
			}
			
			WrittenEntitiesX[i]=r.nextInt((100*def.Frame.SCALE)-9)+9;
			WrittenEntitiesY[i]=r.nextInt((100*def.Frame.SCALE)-9)+9;
			
		}
	}
	
	public void WriteMobs() throws IOException{
		fw.write(WrittenTotalEntities+"\r\n");
		for(int i=0;i<WrittenTotalEntities;i++){
			fw.write(WrittenEntitiesName[i]+" ");
			fw.write(WrittenEntitiesX[i]+" ");
			fw.write(WrittenEntitiesY[i]+" ");
			fw.write("\r\n");
		}
		
		fw.flush();
		fw.close();
	}
	
	public void readInfo(){
		readTotalEntities=ms.nextInt();
	}
	public void readMobsData(){
		for(int i=0;i<readTotalEntities;i++){
			ReadEntitiesName[i]=ms.next();
			ReadEntitiesX[i]=ms.nextInt();
			ReadEntitiesY[i]=ms.nextInt();
		}
	}

}
