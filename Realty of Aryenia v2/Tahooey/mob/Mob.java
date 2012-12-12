package mob;

import java.awt.*;
import def.*;

public class Mob {
	
	public String Name;
	public int x,y,MobType;
	public int finalx,finaly;
	public int w=8,h=8;
	public int finalw,finalh;
	public Image IMG_TO_DRAW;
	public int Layer;
	
	public int ID;
	
	public int dx=0,dy=0;	
	public int imgx=0,imgy=0,imgx2=imgx+w,imgy2=imgy+h;
	
	public boolean isControlledByPlayer=false;
	
	public Rectangle up,down,left,right;
	public boolean canMoveLeft=true,canMoveRight=true,canMoveUp=true,canMoveDown=true;
	
	public Mob(){
		up=new Rectangle();
		down=new Rectangle();
		left=new Rectangle();
		right=new Rectangle();
	}
	
	public void setImage(int frame){
		if(frame==def.Frame.UP){
			imgx=16;
			imgy=0;
			imgx2=imgx+w;
			imgy2=imgy+h;
		}else if(frame==def.Frame.DOWN){
			imgx=24;
			imgy=0;
			imgx2=imgx+w;
			imgy2=imgy+h;
		}else if(frame==def.Frame.LEFT){
			imgx=8;
			imgy=0;
			imgx2=imgx+w;
			imgy2=imgy+h;
		}else if(frame==def.Frame.RIGHT){
			imgx=0;
			imgy=0;
			imgx2=imgx+w;
			imgy2=imgy+h;
		}else{
			
		}
	}
	
	public void workFirstInts(){
		finalw=w*def.Frame.SCALE;
		finalh=h*def.Frame.SCALE;
		finalx=(x*def.Frame.SCALE);
		finaly=(y*def.Frame.SCALE);
	}
	
	public void setRectangles(){
		up.setSize(finalw-2, 1);
		down.setSize(finalw-2, 1);
		left.setSize(1, finalh-2);
		right.setSize(1, finalh-2);
		
		up.setLocation(finalx+Engine.cam.x, (finaly+Engine.cam.y)-1);
		down.setLocation(finalx+Engine.cam.x, (finaly+finalh+Engine.cam.y)+1);
		left.setLocation(finalx+Engine.cam.x-1, finaly+Engine.cam.y);
		right.setLocation(finalx+finalw+Engine.cam.x+1, finaly+Engine.cam.y);
		
	}
	
	public void move(int dir){
		setImage(dir);
		if(dir==def.Frame.UP){
			if(canMoveUp){
				canMoveDown=true;
				dy=-def.Frame.SPEED;
				dx=0;
			}else{
				dx=0;
				dy=0;
			}
		}
		if(dir==def.Frame.DOWN){
			if(canMoveDown){
				canMoveUp=true;
				dy=def.Frame.SPEED;
				dx=0;
			}else{
				dx=0;
				dy=0;
			}
		}
		if(dir==def.Frame.LEFT){
			if(canMoveLeft){
				canMoveRight=true;
				dx=-def.Frame.SPEED;
				dy=0;
			}else{
				dy=0;
				dx=0;
			}
		}
		if(dir==def.Frame.RIGHT){
			if(canMoveRight){
				canMoveLeft=true;
				dx=def.Frame.SPEED;
				dy=0;
			}else{
				dy=0;
				dx=0;
			}
		}
		if(dir==def.Frame.STILL){
			dx=0;
			dy=0;
		}
	}
	
	public void runMob(Graphics g){
		if(finalx+Engine.cam.x>=0-finalw){
			if(finalx+Engine.cam.x<=def.Frame.WIDTH){
				if(finaly+Engine.cam.y>=0-finalh){
					if(finaly+Engine.cam.y<=def.Frame.HEIGHT){
						finalx=finalx+dx;
						finaly=finaly+dy;
						drawMob(g);
						setRectangles();
					}
				}
			}
		}
	}
	
	public void drawMob(Graphics g){
		g.fillRect(up.x,up.y,up.width,up.height);
		g.fillRect(down.x,down.y,down.width,down.height);
		g.drawImage(IMG_TO_DRAW,finalx+Engine.cam.x,finaly+Engine.cam.y,finalx+finalw+Engine.cam.x,finaly+finalh+Engine.cam.y,imgx,imgy,imgx2,imgy2,null);
	}

}
