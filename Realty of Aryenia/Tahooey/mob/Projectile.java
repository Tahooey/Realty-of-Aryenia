package mob;

import img.ImageHandler;

import java.awt.*;

import til.Tile;
import def.*;

public class Projectile {
	
	Tile t = new Tile();
	
	public boolean canFire=false;
	public static int UP=1,DOWN=2,LEFT=3,RIGHT=4;	
	public int dir;
	public boolean canDraw=true;
	public Image IMG=ImageHandler.PlayerFire;
	public int x,y;
	public int finalx,finaly;
	public int w=4,h=4;
	public int finalw,finalh;
	public int dx=0,dy=0;
	public int xOffset,yOffset;
	
	public Projectile(){
		
	}
	
	public void workInts(){
		if(dir==UP){
			dy=-def.Frame.SPEED*2;
			dx=0;
		}
		if(dir==DOWN){
			dy=def.Frame.SPEED*2;
			dx=0;
		}
		if(dir==LEFT){
			dx=-def.Frame.SPEED*2;
			dy=0;
		}
		if(dir==RIGHT){
			dx=def.Frame.SPEED*2;
			dy=0;
		}
		xOffset=xOffset+dx;
		yOffset=yOffset+dy;
		finalw=w*def.Frame.SCALE;
		finalh=h*def.Frame.SCALE;
		finalx=(x*def.Frame.SCALE)+xOffset;
		finaly=(y*def.Frame.SCALE)+yOffset;
	}
	
	public void drawProjectile(Graphics g){
		if(finalx+Engine.cam.xOffset>=0-finalw){
			if(finaly+Engine.cam.yOffset>=0-finalh){
				if(finalx+Engine.cam.xOffset<=def.Frame.WIDTH){
					if(finaly+Engine.cam.yOffset<=def.Frame.HEIGHT){
						if(canDraw){
							t.setSize(finalw, finalh);
							t.setLocation(finalx+Engine.cam.xOffset, finaly+Engine.cam.yOffset);
							t.runTile(g);
							g.drawImage(IMG, finalx+Engine.cam.xOffset, finaly+Engine.cam.yOffset, finalx+Engine.cam.xOffset+finalw, finaly+Engine.cam.yOffset+finalh, 0, 0, w, h, null);
							workInts();
						}						
					}else{
						canDraw=false;
					}
				}else{
					canDraw=false;
				}
			}else{
				canDraw=false;
			}
		}else{
			canDraw=false;
		}
	}

}
