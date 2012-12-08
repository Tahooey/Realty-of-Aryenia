package def;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import mob.*;
import wrld.*;

public class Engine {
	
	public static boolean canPressKey=true;
	public static MobFileHandler mfh = new MobFileHandler();
	public static WorldFileHandler fh = new WorldFileHandler();	
	public static MapBuilder mb = new MapBuilder();
	public static Camera cam = new Camera();
	public static void RunGame(Graphics g){
		WorldRunner.RunWorld(g);
		cam.move();
	}
	public static void KeyPressed(KeyEvent e){
		int KeyCode = e.getKeyCode();
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
				}
			
			}
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
	}

}
