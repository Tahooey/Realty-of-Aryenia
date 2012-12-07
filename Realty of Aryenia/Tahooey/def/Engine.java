package def;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import mob.Entity;

import til.Block;
import wrld.*;

public class Engine {
	
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
				if(KeyCode==KeyEvent.VK_W){
					mb.ENTITIES[i].move(Entity.UP);
				}
				if(KeyCode==KeyEvent.VK_S){
					mb.ENTITIES[i].move(Entity.DOWN);
				}
				if(KeyCode==KeyEvent.VK_A){
					mb.ENTITIES[i].move(Entity.LEFT);
				}
				if(KeyCode==KeyEvent.VK_D){
					mb.ENTITIES[i].move(Entity.RIGHT);
				}				
			}
		}

	}
	public static void KeyReleased(KeyEvent e){
		int KeyCode = e.getKeyCode();
		
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
