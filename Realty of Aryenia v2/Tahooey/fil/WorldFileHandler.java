package fil;

import java.io.*;
import java.util.*;

import def.Engine;

public class WorldFileHandler {
	
	File world;
	File dir;
	FileWriter fw;
	Scanner ws;
	
	public int[][][] WrittenBlockID;
	public int WrittenWorldW=64, WrittenWorldH=64,WrittenWorldLayers=8;
	public String WrittenWorldName="test";
	
	public int[][][]ReadBlockID;
	public int ReadWorldW, ReadWorldH,ReadWorldLayers;
	public String ReadWorldName;
	
	public WorldFileHandler(String WorldName){
		dir= new File("res/worlds/"+WorldName);
		world = new File("res/worlds/"+WorldName+"/map.thu");
		//System.out.println("Hi");
		if(!world.exists()){
			WrittenBlockID=new int[WrittenWorldLayers][WrittenWorldH][WrittenWorldW];
			try {
				dir.mkdir();
				world.createNewFile();
				fw=new FileWriter(world);
				GenerateTiles();
				WriteWorld();
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}
		try {
			ws=new Scanner(world);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		ReadInfo();
		ReadBlockID=new int[ReadWorldLayers][ReadWorldH][ReadWorldW];
		
		ReadWorld();
	}
	
	public void ReadInfo(){
		ReadWorldName=ws.next();
		ReadWorldW=ws.nextInt();
		ReadWorldH=ws.nextInt();
		ReadWorldLayers=ws.nextInt();
	}
	
	public void ReadWorld(){
		for(int l=0;l<ReadBlockID.length;l++){
			for(int h=0;h<ReadBlockID[l].length;h++){
				for(int w=0;w<ReadBlockID[l][h].length;w++){
					ReadBlockID[l][h][w]=ws.nextInt();
				}
				
			}
		}
	}
	
	public void GenerateTiles(){
		for(int l=0;l<WrittenBlockID.length;l++){
			for(int h=0;h<WrittenBlockID[l].length;h++){
				for(int w=0;w<WrittenBlockID[l][h].length;w++){
					if(l==0){
						WrittenBlockID[l][h][w]=1;					
					}else{
						if(h==0){
							WrittenBlockID[l][h][w]=2;
						}else if(h==WrittenWorldH-1){
							WrittenBlockID[l][h][w]=2;
						}else if(w==0){
							WrittenBlockID[l][h][w]=2;
						}else if(w==WrittenWorldW-1){
							WrittenBlockID[l][h][w]=2;
						}else{
							WrittenBlockID[l][h][w]=0;
						}							
					}
				}
			}
		}
	}
	
	public void SaveWorld() throws IOException{
		fw=new FileWriter(world);
		fw.write(ReadWorldName+"\r\n");
		fw.write(ReadWorldW+"\r\n");
		fw.write(ReadWorldH+"\r\n");
		fw.write(ReadWorldLayers+"\r\n");
		for(int l=0;l<Engine.mb.BLOCKS.length;l++){
			for(int h=0;h<Engine.mb.BLOCKS[l].length;h++){
				for(int w=0;w<Engine.mb.BLOCKS[l][h].length;w++){
					fw.write(Engine.mb.BLOCKS[l][h][w].ID+" ");
				}
				fw.write("\r\n");
			}
			fw.write("\r\n");
		}
		
		fw.flush();
		fw.close();
	}
	
	public void WriteWorld() throws IOException{
		fw.write(WrittenWorldName+"\r\n");
		fw.write(WrittenWorldW+"\r\n");
		fw.write(WrittenWorldH+"\r\n");
		fw.write(WrittenWorldLayers+"\r\n");
		for(int l=0;l<WrittenBlockID.length;l++){
			for(int h=0;h<WrittenBlockID[l].length;h++){
				for(int w=0;w<WrittenBlockID[l][h].length;w++){
					fw.write(WrittenBlockID[l][h][w]+" ");
				}
				fw.write("\r\n");
			}
			fw.write("\r\n");
		}
		
		fw.flush();
		fw.close();
	}

}
