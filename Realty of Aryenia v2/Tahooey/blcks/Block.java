package blcks;

import java.awt.*;

import def.Engine;
import fil.ImageFileHandler;

public class Block {
	
	public boolean ChangesLayer=false;
	public int LowerLayer,HigherLayer;
	public boolean HasChangedLayer;
	public boolean isIntersectedByMouse=false;
	public int ID;
	public Image IMG_TO_DRAW;
	public int imgx,imgy,imgx2,imgy2;
	public int x,y,l;
	public static int w=8,h=8;
	public int dx,dy;
	public int finalx,finaly,finalw,finalh;
	public boolean isCollidable=true;
	
	public static final int UP=1,DOWN=2,LEFT=3,RIGHT=4;
	
	public int directionOfSteps;
	public Rectangle lower,upper;
	
	public Rectangle r = new Rectangle();
	public Block(){
		
	}
	
	public void setSteps(int dir){
		directionOfSteps=dir;
		lower=new Rectangle();
		upper=new Rectangle();
	}
	
	public void RunBlock(){
		workInts();
		setRectangle();
		pushMob();
		if(ChangesLayer){
			ChangeLayers();
		}
	}
	
	public void ChangeLayers(){
		if(directionOfSteps==UP){
			lower.setSize(finalw, finalh/2);
			lower.setLocation(finalx+Engine.cam.x, finaly+(finalh/2)+Engine.cam.y);
			upper.setSize(finalw, finalh/2);
			upper.setLocation(finalx+Engine.cam.x, finaly+Engine.cam.y);
		}
		if(directionOfSteps==DOWN){
			lower.setSize(finalw, finalh/2);
			lower.setLocation(finalx+Engine.cam.x, finaly+Engine.cam.y);
			upper.setSize(finalw, finalh/2);
			upper.setLocation(finalx+Engine.cam.x, finaly+(finalh/2)+Engine.cam.y);
		}
		if(directionOfSteps==LEFT){
			lower.setSize(finalw/2, finalh);
			lower.setLocation(finalx+Engine.cam.x, finaly+Engine.cam.y);
			upper.setSize(finalw/2, finalh);
			upper.setLocation(finalx+Engine.cam.x+(finalw/2), finaly+Engine.cam.y);
		}
		if(directionOfSteps==RIGHT){
			lower.setSize(finalw/2, finalh);
			lower.setLocation(finalx+(finalw/2)+Engine.cam.x, finaly+Engine.cam.y);
			upper.setSize(finalw/2, finalh);
			upper.setLocation(finalx+Engine.cam.x, finaly+Engine.cam.y);
		}
		for(int i=0;i<Engine.mb.MOBS.length;i++){
			if(Engine.mb.MOBS[i].Layer==l){
				if(Engine.mb.MOBS[i].forward.intersects(lower)){
					if(Engine.mb.MOBS[i].Layer>0){
						Engine.mb.MOBS[i].Layer=LowerLayer;
					}				
				}else if(Engine.mb.MOBS[i].forward.intersects(upper)){
					if(Engine.mb.MOBS[0].Layer<Engine.mb.BLOCKS.length-1){
						Engine.mb.MOBS[i].Layer=HigherLayer;
					}				
				}
			}else if(Engine.mb.MOBS[i].Layer==l+1){
				if(Engine.mb.MOBS[i].forward.intersects(lower)){
					if(Engine.mb.MOBS[i].Layer>0){
						Engine.mb.MOBS[i].Layer=LowerLayer;
					}				
				}else if(Engine.mb.MOBS[i].forward.intersects(upper)){
					if(Engine.mb.MOBS[0].Layer<Engine.mb.BLOCKS.length-1){
						Engine.mb.MOBS[i].Layer=HigherLayer;
					}				
				}
			}
		}		
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
						if(!Engine.mb.MOBS[i].GoingDown){
							Engine.mb.MOBS[i].dy=0;
						}
					}
					if(Engine.mb.MOBS[i].down.intersects(r)){
						if(!Engine.mb.MOBS[i].GoingUp){
							Engine.mb.MOBS[i].dy=0;
						}						
					}
					if(Engine.mb.MOBS[i].left.intersects(r)){
						if(!Engine.mb.MOBS[i].GoingRight){
								Engine.mb.MOBS[i].dx=0;
						}						
					}
					if(Engine.mb.MOBS[i].right.intersects(r)){
						if(!Engine.mb.MOBS[i].GoingLeft){
							Engine.mb.MOBS[i].dx=0;
						}						
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
						}
						if(l==Engine.mb.MOBS[0].Layer-1){
							isIntersectedByMouse=false;
						}
						if(l==Engine.mb.MOBS[0].Layer-1){
							IMG_TO_DRAW=ImageFileHandler.TerrainLower;
							g.drawImage(IMG_TO_DRAW,finalx+Engine.cam.x,finaly+Engine.cam.y,finalx+finalw+Engine.cam.x,finaly+finalh+Engine.cam.y,imgx,imgy,imgx2,imgy2,null);
						}
					}
				}
			}
		}

	}

}
