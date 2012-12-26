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
	
	public int direction;
	
	public int ID;
	
	public int dx=0,dy=0;	
	public int imgx=0,imgy=0,imgx2=imgx+w,imgy2=imgy+h;
	
	public boolean isControlledByPlayer=false;
	
	public Rectangle forward;
	public Rectangle r;
	public Rectangle up,down,left,right;
	public boolean GoingLeft=false,GoingRight=false,GoingUp=false,GoingDown=false;
	
	public Mob(){
		forward=new Rectangle();
		r=new Rectangle();
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
		if(direction==def.Frame.UP){
			forward.setSize(finalw,def.Frame.SPEED);
			forward.setLocation(finalx+Engine.cam.x, finaly+Engine.cam.y+(def.Frame.SPEED));
		}
		if(direction==def.Frame.DOWN){
			forward.setSize(finalw,def.Frame.SPEED);
			forward.setLocation(finalx+Engine.cam.x, finaly+Engine.cam.y+finalh-(def.Frame.SPEED*2));
		}
		if(direction==def.Frame.LEFT){
			forward.setSize(def.Frame.SPEED,finalh);
			forward.setLocation(finalx+Engine.cam.x+(def.Frame.SPEED), finaly+Engine.cam.y);
		}
		if(direction==def.Frame.RIGHT){
			forward.setSize(def.Frame.SPEED,finalh);
			forward.setLocation(finalx+Engine.cam.x+finalw-(def.Frame.SPEED*2), finaly+Engine.cam.y);
		}
		r.setSize(finalw,finalh);
		r.setLocation(finalx+Engine.cam.x,finaly+Engine.cam.y);
		
		up.setSize(finalw, def.Frame.SPEED);
		down.setSize(finalw, def.Frame.SPEED);
		left.setSize(def.Frame.SPEED, finalh);
		right.setSize(def.Frame.SPEED, finalh);
		
		up.setLocation(finalx+Engine.cam.x, (finaly+Engine.cam.y)-def.Frame.SPEED);
		down.setLocation(finalx+Engine.cam.x, (finaly+finalh+Engine.cam.y));
		left.setLocation(finalx+Engine.cam.x-def.Frame.SPEED, finaly+Engine.cam.y);
		right.setLocation(finalx+finalw+Engine.cam.x, finaly+Engine.cam.y);
		
	}
	
	public void move(int dir){
		direction=dir;
		setImage(dir);
		if(dir==def.Frame.UP){
			GoingUp=true;
			GoingDown=false;
			dy=-def.Frame.SPEED;
			dx=0;
		}
		if(dir==def.Frame.DOWN){
			GoingDown=true;
			GoingUp=false;
			dy=def.Frame.SPEED;
			dx=0;
		}
		if(dir==def.Frame.LEFT){
			GoingLeft=true;
			GoingRight=false;
			dx=-def.Frame.SPEED;
			dy=0;
		}
		if(dir==def.Frame.RIGHT){
			GoingRight=true;
			GoingLeft=false;
			dx=def.Frame.SPEED;
			dy=0;
		}
		if(dir==def.Frame.STILL){
			dx=0;
			dy=0;
		}
	}
	
	public void runMob(){
		if(finalx+Engine.cam.x>=0-finalw){
			if(finalx+Engine.cam.x<=def.Frame.WIDTH){
				if(finaly+Engine.cam.y>=0-finalh){
					if(finaly+Engine.cam.y<=def.Frame.HEIGHT){
						finalx=finalx+dx;
						finaly=finaly+dy;
						setRectangles();
					}
				}
			}
		}
	}
	
	public void drawMob(Graphics g){
		if(finalx+Engine.cam.x>=0-finalw){
			if(finalx+Engine.cam.x<=def.Frame.WIDTH){
				if(finaly+Engine.cam.y>=0-finalh){
					if(finaly+Engine.cam.y<=def.Frame.HEIGHT){
		g.drawImage(IMG_TO_DRAW,finalx+Engine.cam.x,finaly+Engine.cam.y,finalx+finalw+Engine.cam.x,finaly+finalh+Engine.cam.y,imgx,imgy,imgx2,imgy2,null);
					}
				}
			}
		}
	}

}
