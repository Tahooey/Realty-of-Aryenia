package til;

import img.ImageHandler;

import java.awt.*;
import java.awt.image.BufferedImage;

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
	Tile t;
	public Block(){
		t=new Tile();
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
		t.setSize(finalw,finalh);
		t.setLocation(finalx+Engine.cam.xOffset, finaly+Engine.cam.yOffset);
	}
	
	public void runBlock(Graphics g){
		workINTS();
		draw(g);
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
