package def;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;

import mob.*;
import wrld.*;

public class Engine {
	
	
	public static boolean inEditMode=false;
	public static boolean canPressKey=true;
	public static MobFileHandler mfh = new MobFileHandler();
	public static WorldFileHandler fh = new WorldFileHandler();	
	public static PlayerFileHandler pfh = new PlayerFileHandler();	
	public static MapBuilder mb = new MapBuilder();
	public static Camera cam = new Camera();
	public static void RunGame(Graphics g){
		WorldRunner.RunWorld(g);
		cam.move();
		Mouse.runMouse(g);
	}
	
	public static void MouseMoved(MouseEvent e){
		int mouseX=e.getX();
		int mouseY=e.getY();
		
		Mouse.x=mouseX;
		Mouse.y=mouseY;
	}
	
	public static void KeyPressed(KeyEvent e){
		int KeyCode = e.getKeyCode();
		Mouse.KeyPressed(e);
		for(int i=0;i<mb.ENTITIES.length;i++){
			if(mb.ENTITIES[i].isControlledByPlayer){
				if(canPressKey){
					if(KeyCode==KeyEvent.VK_W){
						mb.ENTITIES[i].move(Entity.UP);
						canPressKey=false;
					}
					if(KeyCode==KeyEvent.VK_S){
						mb.ENTITIES[i].move(Entity.DOWN);
						canPressKey=false;
					}
					if(KeyCode==KeyEvent.VK_A){
						mb.ENTITIES[i].move(Entity.LEFT);
						canPressKey=false;
					}
					if(KeyCode==KeyEvent.VK_D){
						mb.ENTITIES[i].move(Entity.RIGHT);
						canPressKey=false;
					}
					if(!inEditMode){
						if(KeyCode==KeyEvent.VK_UP){
							mb.ENTITIES[i].FireProjectile(Projectile.UP);
						}
						if(KeyCode==KeyEvent.VK_DOWN){
							mb.ENTITIES[i].FireProjectile(Projectile.DOWN);
						}
						if(KeyCode==KeyEvent.VK_LEFT){
							mb.ENTITIES[i].FireProjectile(Projectile.LEFT);
						}
						if(KeyCode==KeyEvent.VK_RIGHT){
							mb.ENTITIES[i].FireProjectile(Projectile.RIGHT);
						}
					}
				}
			}
		}
		if(KeyCode==KeyEvent.VK_P){
			try {
				pfh.save();
				fh.SaveWorld();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if(KeyCode==KeyEvent.VK_UP){
			if(inEditMode){
				Mouse.curlayer=2;
			}		
		}
		if(KeyCode==KeyEvent.VK_DOWN){
			if(inEditMode){
				Mouse.curlayer=1;
			}
			
		}
		if(KeyCode==KeyEvent.VK_E){
			inEditMode=true;
		}
		if(KeyCode==KeyEvent.VK_R){
			inEditMode=false;
		}

	}
	public static void KeyReleased(KeyEvent e){
		int KeyCode = e.getKeyCode();
		canPressKey=true;
		for(int i=0;i<mb.ENTITIES.length;i++){
			if(mb.ENTITIES[i].isControlledByPlayer){
				mb.ENTITIES[i].changingX=false;
				mb.ENTITIES[i].changingY=false;
				if(KeyCode==KeyEvent.VK_W){
					mb.ENTITIES[i].dy=0;
				}
				if(KeyCode==KeyEvent.VK_S){
					mb.ENTITIES[i].dy=0;
				}
				if(KeyCode==KeyEvent.VK_A){
					mb.ENTITIES[i].dx=0;
				}
				if(KeyCode==KeyEvent.VK_D){
					mb.ENTITIES[i].dx=0;
				}
				mb.ENTITIES[i].canLetMove=true;				
			}
		}
		

	}
	public static void MousePressed(MouseEvent e){
		Mouse.hasClicked=true;
		Mouse.hasReleased=false;
	}
	public static void MouseReleased(MouseEvent e){
		Mouse.hasReleased=true;
		Mouse.hasClicked=false;
	}

}
