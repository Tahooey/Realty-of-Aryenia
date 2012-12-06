package til;

import img.ImageHandler;

import java.awt.*;
import java.awt.image.BufferedImage;

import mob.Entity;

import def.Engine;

public class Block {
	public boolean isHigh;
	public BufferedImage IMG_TO_READ;
	public int finalx,finaly;
	public int x,y;
	public int imgx,imgy,imgx1,imgy1;
	public static final int WIDTH=8,HEIGHT=8;
	public int finalw,finalh;
	public int ID;
	public boolean isCollidable=true;
	
	public int layer;
	Tile t = new Tile();
	public Block(){
	
	}
	
	public void workINTS(){
		if(isHigh){
			IMG_TO_READ=ImageHandler.terrainHigher;
		}else{
			IMG_TO_READ=ImageHandler.terrainLower;
		}
		finalx=x*def.Frame.SCALE;
		finaly=y*def.Frame.SCALE;
		finalw=WIDTH*def.Frame.SCALE;
		finalh=HEIGHT*def.Frame.SCALE;
	}
	
	public void pushEntity(){
		if(isCollidable){
			for(int i=0;i<Engine.mb.ENTITIES.length;i++){
				if(Engine.mb.ENTITIES[i].currentLayer==layer){
					if(Engine.mb.ENTITIES[i].dir==Entity.RIGHT){
						Engine.mb.ENTITIES[i].canMoveLeft=true;
						Engine.mb.ENTITIES[i].canMoveUp=true;
						Engine.mb.ENTITIES[i].canMoveDown=true;
						if(Engine.mb.ENTITIES[i].t.isIntersecting(t.r)){
							Engine.mb.ENTITIES[i].canMoveRight=false;
						}
					}
					if(Engine.mb.ENTITIES[i].dir==Entity.LEFT){
						Engine.mb.ENTITIES[i].canMoveRight=true;
						Engine.mb.ENTITIES[i].canMoveUp=true;
						Engine.mb.ENTITIES[i].canMoveDown=true;
						if(Engine.mb.ENTITIES[i].t.isIntersecting(t.r)){
							Engine.mb.ENTITIES[i].canMoveLeft=false;
						}						
					}
					if(Engine.mb.ENTITIES[i].dir==Entity.UP){
						Engine.mb.ENTITIES[i].canMoveDown=true;
						Engine.mb.ENTITIES[i].canMoveLeft=true;
						Engine.mb.ENTITIES[i].canMoveRight=true;	
						if(Engine.mb.ENTITIES[i].t.isIntersecting(t.r)){
							Engine.mb.ENTITIES[i].canMoveUp=false;						
						}
					}
					if(Engine.mb.ENTITIES[i].dir==Entity.DOWN){
						Engine.mb.ENTITIES[i].canMoveUp=true;
						Engine.mb.ENTITIES[i].canMoveLeft=true;
						Engine.mb.ENTITIES[i].canMoveRight=true;
						if(Engine.mb.ENTITIES[i].t.isIntersecting(t.r)){
							Engine.mb.ENTITIES[i].canMoveDown=false;
						}
					}
				}
			}
		}
	}
	
	public void runBlock(Graphics g){
		t.setSize(finalw,finalh);
		t.setLocation(finalx+Engine.cam.xOffset, finaly+Engine.cam.yOffset);
		workINTS();
		draw(g);
		t.runTile(g);
		pushEntity();
	}
	
	public void draw(Graphics g){
		if(finalx+Engine.cam.xOffset>=0-finalw){
			if(finalx+Engine.cam.xOffset<=def.Frame.WIDTH){
				if(finaly+Engine.cam.yOffset>=0-finalh){
					if(finalh+Engine.cam.yOffset<=def.Frame.HEIGHT);
				}
			}
		}
		g.drawImage(IMG_TO_READ, finalx+Engine.cam.xOffset, finaly+Engine.cam.yOffset, finalx+finalw+Engine.cam.xOffset, finaly+finalh+Engine.cam.yOffset, imgx, imgy, imgx1, imgy1, null);
		
	}

}
