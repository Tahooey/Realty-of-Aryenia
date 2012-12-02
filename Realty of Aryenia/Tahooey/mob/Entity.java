package mob;

import java.awt.*;

import def.Engine;

public class Entity {
	
	public int currentLayer;
	public boolean canCollide;
	public int x,y;
	public int w,h;
	public int xoffset,yoffset;
	public int finalx,finaly;
	public int finalw,finalh;
	public int imgx,imgy,imgx1,imgy1;
	Image IMG_TO_DRAW;
	
	public Entity(){
		
	}
	
	public void runEntity(Graphics g){
		workINTS();
		drawEntity(g);
	}
	
	public void workINTS(){
		finalx=x+xoffset*def.Frame.SCALE;
		finaly=y+yoffset*def.Frame.SCALE;
		finalw=w*def.Frame.SCALE;
		finalh=h*def.Frame.SCALE;
	}
	
	public void drawEntity(Graphics g){
		g.drawImage(IMG_TO_DRAW, finalx+Engine.cam.xOffset, finaly+Engine.cam.yOffset, finalx+finalw+Engine.cam.xOffset, finaly+finalh+Engine.cam.yOffset, imgx, imgy, imgx1, imgy1, null);
	}

}
