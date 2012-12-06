package mob;


import java.awt.*;

import def.Engine;

import til.Tile;

public class Entity {
	
	
	public boolean canMoveUp=true,canMoveDown=true,canMoveLeft=true,canMoveRight=true;
	public int dir;
	public boolean isFollowedByCamera=false;
	public static int UP=1,DOWN=2,LEFT=3,RIGHT=4;
	public int currentLayer;
	public boolean canCollide;
	public int x,y;
	public int w=8,h=8;
	public int xoffset=0,yoffset=0;
	public int finalx,finaly;
	public int finalw,finalh;
	public int imgx=0,imgy=0,imgx1=8,imgy1=8;
	public Image IMG_TO_DRAW;
	public Tile t = new Tile();
	
	public Entity(){
		
	}
	
	public void runEntity(Graphics g){
		workINTS();
		t.setSize(finalw, finalh);
		t.setLocation(finalx+Engine.cam.xOffset, finaly+Engine.cam.yOffset);
		drawEntity(g);
		t.runTile(g);
	}
	
	public void move(int direction){
		dir=direction;
		if(direction==UP){
			if(canMoveUp){
				if(isFollowedByCamera){
					Engine.cam.move(UP);
				}
				yoffset-=def.Frame.SPEED;
				imgx=16;
				imgy=0;
				imgx1=24;
				imgy1=8;				
			}

		}
		if(direction==DOWN){
			if(canMoveDown){
				if(isFollowedByCamera){
					Engine.cam.move(DOWN);
				}
				yoffset+=def.Frame.SPEED;
				imgx=24;
				imgy=0;
				imgx1=32;
				imgy1=8;				
			}

		}
		if(direction==LEFT){
			if(canMoveLeft){
				if(isFollowedByCamera){
					Engine.cam.move(LEFT);
				}
				xoffset-=def.Frame.SPEED;
				imgx=8;
				imgy=0;
				imgx1=16;
				imgy1=8;				
			}

		}
		if(direction==RIGHT){
			if(canMoveRight){
				if(isFollowedByCamera){
					Engine.cam.move(RIGHT);
				}
				xoffset+=def.Frame.SPEED;
				imgx=0;
				imgy=0;
				imgx1=8;
				imgy1=8;				
			}

		}
	}
	
	public void workINTS(){
		finalx=(x*def.Frame.SCALE)+xoffset;
		finaly=(y*def.Frame.SCALE)+yoffset;
		finalw=w*def.Frame.SCALE;
		finalh=h*def.Frame.SCALE;
	}
	
	public void drawEntity(Graphics g){
		g.drawImage(IMG_TO_DRAW, finalx+Engine.cam.xOffset, finaly+Engine.cam.yOffset, finalx+finalw+Engine.cam.xOffset, finaly+finalh+Engine.cam.yOffset, imgx, imgy, imgx1, imgy1, null);
	}

}
