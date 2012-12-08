package mob;


import java.awt.*;
import java.util.Random;

import def.Engine;
import til.Tile;

public class Entity {
	
	public boolean canLetMove;
	public static boolean canStartAI=false;
	
	public String mobName;
	
	public boolean changingX=false,changingY=false;
	Random r = new Random();
	public int dx=0,dy=0;
	int currentHealth,maxHealth;
	public int cur=0;
	public int tick;
	Image SHOOT_PARTICLE;
	public boolean Shoot=false;
	public boolean isControlledByPlayer=false;
	public boolean canMoveUp=true,canMoveDown=true,canMoveLeft=true,canMoveRight=true;
	public int dir;
	public boolean isFollowedByCamera=false;
	public static int UP=1,DOWN=2,LEFT=3,RIGHT=4,STILL=5;
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
		if(!isControlledByPlayer){
			if(canStartAI){
				runAI();
			}			
		}
	}
	
	public void runAI(){
		int dire=0;
		if(cur<=100){
			canLetMove=true;
			changingX=false;
			changingY=false;
			if(cur>=0){
				if(cur==0){
					dire=r.nextInt(6-1)+1;
				}
				if(cur<=75){
					canLetMove=false;
					if(dire==1){
						move(UP);	
					}else if(dire==2){
						move(DOWN);	
					}else if(dire==3){
						move(LEFT);	
					}else if(dire==4){
						move(RIGHT);	
					}else if(dire==5){
						dx=0;
						dy=0;
					}
				}
				if(cur==75+1){
					dx=0;
					dy=0;
				}
			}
			cur++;
		}else{
			cur=0;
		}
	}
	
	public void setImage(int img){
		if(img==RIGHT){
			imgx=0;
			imgy=0;
			imgx1=8;
			imgy1=8;
		}
		if(img==LEFT){
			imgx=8;
			imgy=0;
			imgx1=16;
			imgy1=8;
		}
		if(img==UP){
			imgx=16;
			imgy=0;
			imgx1=24;
			imgy1=8;
		}
		if(img==DOWN){
			imgx=24;
			imgy=0;
			imgx1=32;
			imgy1=8;
		}
		
	}
	
	public void move(int direction){
			if(direction==UP){
				changingY=true;
				if(!changingX){
					dir=direction;
					setImage(direction);
					if(canMoveUp){
						dy=-def.Frame.SCALE;
						dx=0;				
					}else{
						dy=0;
					}
				}
			}
			if(direction==DOWN){
				changingY=true;
				if(!changingX){
					dir=direction;
					setImage(direction);
					if(canMoveDown){
						dy=def.Frame.SCALE;
						dx=0;				
					}else{
						dy=0;
					}
				}
			}
			if(direction==LEFT){
				changingX=true;
				if(!changingY){
					dir=direction;
					setImage(direction);
					if(canMoveLeft){
						dx=-def.Frame.SCALE;
						dy=0;				
					}else{
						dx=0;
					}
				}
			}
			if(direction==RIGHT){
				changingX=true;
				if(!changingY){
					dir=direction;
					setImage(direction);
					if(canMoveRight){
						dx=def.Frame.SCALE;
						dy=0;				
					}else{
						dx=0;
					}
				}
			}			
	}
	
	public void workINTS(){
		xoffset=xoffset+dx;
		yoffset=yoffset+dy;
		finalx=(x*def.Frame.SCALE)+xoffset;
		finaly=(y*def.Frame.SCALE)+yoffset;
		finalw=w*def.Frame.SCALE;
		finalh=h*def.Frame.SCALE;
	}
	
	public void drawEntity(Graphics g){
		if(finalx+Engine.cam.xOffset>=0-finalw){
			if(finalx+Engine.cam.xOffset<=def.Frame.WIDTH){
				if(finaly+Engine.cam.yOffset>=0-finalh){
					if(finaly+Engine.cam.yOffset<=def.Frame.HEIGHT){
						g.drawImage(IMG_TO_DRAW, finalx+Engine.cam.xOffset, finaly+Engine.cam.yOffset, finalx+finalw+Engine.cam.xOffset, finaly+finalh+Engine.cam.yOffset, imgx, imgy, imgx1, imgy1, null);
						canStartAI=true;
					}
				}
			}
		}
		
	}

}
