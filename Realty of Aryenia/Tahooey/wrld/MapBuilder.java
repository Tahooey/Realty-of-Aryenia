package wrld;

import mob.*;
import blck.*;
import def.*;
import til.*;

public class MapBuilder {
	public Block[] Type=new Block[2];
	public Block[][] LowerBLOCKS;
	public Block[][] HigherBLOCKS;
	public Entity[] ENTITIES;
	
	Player p=new Player(0,0,0);
	Wizard w = new Wizard(0,0,0);
	
	public MapBuilder(){
		LowerBLOCKS = new Block[Engine.fh.ReadWorldWIDTH][Engine.fh.ReadWorldHEIGHT];
		HigherBLOCKS = new Block[Engine.fh.ReadWorldWIDTH][Engine.fh.ReadWorldHEIGHT];
		ENTITIES = new Entity[Engine.mfh.readTotalEntities+1];
		createENTITIES();
		setUpTypeArray();
		workBlocks();
	}
	
	public void setUpTypeArray(){
		Type[0]= new Grass();
		Type[1]=new Air();
	}
	
	public void createENTITIES(){
		ENTITIES[0]= new Player(8,8,2);
		ENTITIES[0].isControlledByPlayer=true;
		ENTITIES[0].isFollowedByCamera=true;
		for(int i=0;i<ENTITIES.length-1;i++){
			if(Engine.mfh.ReadEntitiesName[i].equals(w.mobName)){
				ENTITIES[i+1]=new Wizard(Engine.mfh.ReadEntitiesX[i],Engine.mfh.ReadEntitiesY[i],2);
				
			}
		}
		
	}
	
	public void workBlocks(){
		for(int i=0;i<LowerBLOCKS.length;i++){
			for(int j=0;j<LowerBLOCKS[i].length;j++){
				for(int bid=0;bid<Type.length;bid++){
					if(Engine.fh.INTSlay1[i][j]==1){
						LowerBLOCKS[j][i]=new Grass();
					}else if(Engine.fh.INTSlay1[i][j]==0){
						LowerBLOCKS[j][i]=new Air();
					}else if(Engine.fh.INTSlay1[i][j]==2){
						LowerBLOCKS[j][i]=new StoneTile();
					}
				}
			}
		}
		for(int i=0;i<HigherBLOCKS.length;i++){
			for(int j=0;j<HigherBLOCKS[i].length;j++){
				for(int bid=0;bid<Type.length;bid++){
					if(Engine.fh.INTSlay2[i][j]==1){
						HigherBLOCKS[j][i]=new Grass();
					}else if(Engine.fh.INTSlay2[i][j]==0){
						HigherBLOCKS[j][i]=new Air();
					}else if(Engine.fh.INTSlay2[i][j]==2){
						HigherBLOCKS[j][i]=new StoneTile();
					}
				}
			}
		}
	}

}
