package fil;

import java.io.*;
import java.util.*;

import def.Engine;

public class WorldFileHandler {
	
	File actionBlocks;
	File world;
	File dir1;
	File dir2;
	FileWriter fw;
	FileWriter ab;
	Scanner ws;
	Scanner abs;
	
	public int[][][] WrittenBlockID;
	public int WrittenWorldW, WrittenWorldH,WrittenWorldLayers;
	public String WrittenWorldName;
	
	public int[][][]ReadBlockID;
	public int ReadWorldW, ReadWorldH,ReadWorldLayers;
	public String ReadWorldName;
	public int ReadActionBlocks;
	
	public int[] ReadActionBlocksMapToChangeTo;
	public int[] ReadActionBlocksPlayerX;
	public int[] ReadActionBlocksPlayerY;
	
	public WorldFileHandler(String WorldName,int w,int h,int layers,String name){
		WrittenWorldW=w;
		WrittenWorldH=h;
		WrittenWorldName=name;
		WrittenWorldLayers=layers;
		dir1= new File("res/worlds/"+WorldName);
		dir2= new File("res/worlds/"+WorldName+"/"+name);
		world = new File("res/worlds/"+WorldName+"/"+name+"/map.thu");
		actionBlocks = new File("res/worlds/"+WorldName+"/"+name+"/actblks.thu");
		//System.out.println("Hi");
		if(!world.exists()){
			WrittenBlockID=new int[WrittenWorldLayers][WrittenWorldH][WrittenWorldW];
			try {
				dir1.mkdir();
				dir2.mkdir();
				world.createNewFile();
				fw=new FileWriter(world);
				
				GenerateTiles();
				WriteWorld();
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}
		if(!actionBlocks.exists()){
			try {
				actionBlocks.createNewFile();
				ab=new FileWriter(actionBlocks);
				WriteActionBlocks();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			ws=new Scanner(world);
			abs = new Scanner(actionBlocks);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		ReadInfo();
		ReadBlockID=new int[ReadWorldLayers][ReadWorldH][ReadWorldW];
		ReadActionBlocks();
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
	
	public void ReadActionBlocks(){
		ReadActionBlocks=abs.nextInt();
		ReadActionBlocksMapToChangeTo=new int[ReadActionBlocks];
		ReadActionBlocksPlayerX=new int[ReadActionBlocks];
		ReadActionBlocksPlayerY=new int[ReadActionBlocks];
		for(int i=0;i<ReadActionBlocksMapToChangeTo.length;i++){
			ReadActionBlocksMapToChangeTo[i]=abs.nextInt();
			ReadActionBlocksPlayerX[i]=abs.nextInt();
			ReadActionBlocksPlayerY[i]=abs.nextInt();
		}
	}
	
	public void WriteActionBlocks() throws IOException{
		ab.write("0");
		
		ab.flush();
		ab.close();
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
