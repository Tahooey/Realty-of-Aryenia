package blcks;

import java.awt.*;

import def.Engine;
import fil.ImageFileHandler;

public class Block {
	
	public int ID;
	public Image IMG_TO_DRAW;
	public int imgx,imgy,imgx2,imgy2;
	public int x,y,l;
	public static int w=8,h=8;
	public int dx,dy;
	public int finalx,finaly,finalw,finalh;
	public boolean isCollidable=true;
	
	Rectangle r = new Rectangle();
	public Block(){
		
	}
	
	public void RunBlock(Graphics g){
		workInts();
		drawBlock(g);
		setRectangle();
		pushMob();
	}
	
	public void setRectangle(){
		r.setSize(finalw, finalh);
		r.setLocation(finalx+Engine.cam.x,finaly+Engine.cam.y);
	}
	
	public void workInts(){
		finalx=x*def.Frame.SCALE;
		finaly=y*def.Frame.SCALE;
		finalx=finalx+dx;
		finaly=finaly+dy;
		
		finalw=w*def.Frame.SCALE;
		finalh=h*def.Frame.SCALE;
	}
	
	public void pushMob(){
		if(isCollidable){
			for(int i=0;i<Engine.mb.MOBS.length;i++){
				if(Engine.mb.MOBS[i].Layer==l){
					if(Engine.mb.MOBS[i].up.intersects(r)){
						Engine.mb.MOBS[i].canMoveUp=false;
					}
					if(Engine.mb.MOBS[i].down.intersects(r)){
						Engine.mb.MOBS[i].canMoveDown=false;
					}
					if(Engine.mb.MOBS[i].left.intersects(r)){
						Engine.mb.MOBS[i].canMoveLeft=false;
					}
					if(Engine.mb.MOBS[i].right.intersects(r)){
						Engine.mb.MOBS[i].canMoveRight=false;
					}
				}
			}
		}
		
	}
	
	public void drawBlock(Graphics g){
		if(finalx+Engine.cam.x>=0-finalw){
			if(finaly+Engine.cam.y>0-finalh){
				if(finalx+Engine.cam.x<=def.Frame.WIDTH){
					if(finaly+Engine.cam.y<=def.Frame.HEIGHT){
						if(l==Engine.mb.MOBS[0].Layer){
							IMG_TO_DRAW=ImageFileHandler.TerrainHigher;
							g.drawImage(IMG_TO_DRAW,finalx+Engine.cam.x,finaly+Engine.cam.y,finalx+finalw+Engine.cam.x,finaly+finalh+Engine.cam.y,imgx,imgy,imgx2,imgy2,null);
						}else if(l==Engine.mb.MOBS[0].Layer-1){
							IMG_TO_DRAW=ImageFileHandler.TerrainLower;
							g.drawImage(IMG_TO_DRAW,finalx+Engine.cam.x,finaly+Engine.cam.y,finalx+finalw+Engine.cam.x,finaly+finalh+Engine.cam.y,imgx,imgy,imgx2,imgy2,null);
						}						
					}
				}
			}
		}

	}

}
