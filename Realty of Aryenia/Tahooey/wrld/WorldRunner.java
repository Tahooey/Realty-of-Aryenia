package wrld;

import java.awt.*;
import til.*;

import def.Engine;

public class WorldRunner {
	
	public static void RunWorld(Graphics g){
		setBlocksXY();
		drawLowerTiles(g);
	}
	public static void setBlocksXY(){
		for(int i=0;i<Engine.mb.LowerBLOCKS.length;i++){
			for(int j=0;j<Engine.mb.LowerBLOCKS[i].length;j++){
				Engine.mb.LowerBLOCKS[i][j].x=i*Block.WIDTH;
				Engine.mb.LowerBLOCKS[i][j].y=j*Block.HEIGHT;
				Engine.mb.LowerBLOCKS[i][j].isHigh=false;
				Engine.mb.HigherBLOCKS[i][j].x=i*Block.WIDTH;
				Engine.mb.HigherBLOCKS[i][j].y=j*Block.HEIGHT;
				Engine.mb.HigherBLOCKS[i][j].isHigh=true;
			}
		}
	}
	public static void drawLowerTiles(Graphics g){
		for(int i=0;i<Engine.mb.LowerBLOCKS.length;i++){
			for(int j=0;j<Engine.mb.LowerBLOCKS[i].length;j++){
				Engine.mb.LowerBLOCKS[i][j].runBlock(g);
			}
		}
		for(int i=0;i<Engine.mb.HigherBLOCKS.length;i++){
			for(int j=0;j<Engine.mb.HigherBLOCKS[i].length;j++){
				Engine.mb.HigherBLOCKS[i][j].runBlock(g);
			}
		}
	}

}
