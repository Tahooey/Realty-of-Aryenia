package wrld;

import java.io.*;
import java.util.*;

public class WorldFileHandler {
	
	String WorldName;
	int ReadWorldWIDTH;
	int ReadWorldHEIGHT;
	
	int[] [] INTSlay1;
	int[] [] INTSlay2;
	
	File world = new File("res/world01.thu");
	FileWriter fw;
	boolean hasWorld;
	int thisWorldWIDTH=128;
	int thisWorldHEIGHT=128;
	Scanner ws;
	
	public WorldFileHandler(){
		
		if(!world.exists()){
			try {
				fw = new FileWriter(world);
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				WriteWorld();
			} catch (IOException e) {
				e.printStackTrace();						
			}
		}
		try {
			ws = new Scanner(world);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		readInfo();
		INTSlay1= new int[ReadWorldWIDTH] [ReadWorldHEIGHT];
		INTSlay2= new int[ReadWorldWIDTH] [ReadWorldHEIGHT];
		readWorldData();
	}
	
	public void WriteWorld() throws IOException{
		fw.write("World1 ");
		fw.write(" "+thisWorldWIDTH+" "+thisWorldHEIGHT+" ");
		for(int i=0;i<thisWorldWIDTH;i++){
			for(int j=0;j<thisWorldHEIGHT;j++){
				fw.write(" 1");
			}
		}
		fw.write(" ~ ");
		for(int i=0;i<thisWorldWIDTH;i++){
			for(int j=0;j<thisWorldHEIGHT;j++){
				if(i==0){
					fw.write(" 2");
				}else if(j==0){
					fw.write(" 2");
				}else if(j==thisWorldWIDTH-1){
					fw.write(" 2");
				}else if(i==thisWorldHEIGHT-1){
					fw.write(" 2");
				}else{
					fw.write(" 0");
				}
			}	
		}
		fw.write(" ");
		
		fw.flush();
		fw.close();
	}
	
	public void readInfo(){
		WorldName=ws.next();
		ReadWorldWIDTH=ws.nextInt();
		ReadWorldHEIGHT=ws.nextInt();
	}
	public void readWorldData(){
		for(int i=0;i<INTSlay1.length;i++){
			for(int j=0;j<INTSlay1[i].length;j++){
				INTSlay1[i] [j]=ws.nextInt();
				ws.skip(" ");
			}
		}
		ws.skip("~ ");
		for(int i=0;i<INTSlay2.length;i++){
			for(int j=0;j<INTSlay2[i].length;j++){
				INTSlay2[i] [j]=ws.nextInt();
				ws.skip(" ");
			}
		}
		
	}

}
