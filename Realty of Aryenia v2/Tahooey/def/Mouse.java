package def;

import java.awt.Rectangle;
import blcks.*;

public class Mouse {
	
	static int blockToChangeTo=0;
	static int maxBlock=3;
	
	static int layer;
	static Rectangle r;
	static int X,Y;
	static boolean isPressed=false;
	
	public static void Init(){
		r=new Rectangle();
		r.setSize(1,1);
	}
	
	public static void Update(){
		layer=Engine.mb.MOBS[0].Layer;
		r.setLocation(X,Y);
		HighLightTile();
		ChangeTile();
	}
	
	public static void HighLightTile(){
		for(int h=0;h<Engine.mb.BLOCKS[layer].length;h++){
			for(int w=0;w<Engine.mb.BLOCKS[layer][h].length;w++){
				if(r.intersects(Engine.mb.BLOCKS[layer][h][w].r)){
					Engine.mb.BLOCKS[layer][h][w].isIntersectedByMouse=true;
				}else{
					Engine.mb.BLOCKS[layer][h][w].isIntersectedByMouse=false;
				}
			}
		}
	}
	
	public static void ChangeTile(){
		for(int h=0;h<Engine.mb.BLOCKS[layer-1].length;h++){
			for(int w=0;w<Engine.mb.BLOCKS[layer-1][h].length;w++){
				if(r.intersects(Engine.mb.BLOCKS[layer-1][h][w].r)){
					if(isPressed){
							Engine.mb.ID[layer-1][h][w]=blockToChangeTo;
					}
				}
			}
		}
		Engine.mb.BuildBlocks();
	}
	
	public static void setXY(int xco,int yco){
		X=xco;
		Y=yco;
	}

}
