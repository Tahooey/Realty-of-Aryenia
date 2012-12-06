package def;

import java.awt.*;
import java.awt.event.KeyEvent;

import mob.Entity;

import wrld.*;

public class Engine {
	
	public static WorldFileHandler fh = new WorldFileHandler();
	public static MapBuilder mb = new MapBuilder();
	public static Camera cam = new Camera(400,200);
	public static void RunGame(Graphics g){
		WorldRunner.RunWorld(g);
	}
	public static void KeyPressed(KeyEvent e){
		int KeyCode = e.getKeyCode();
		if(KeyCode==KeyEvent.VK_W){
			mb.ENTITIES[0].move(Entity.UP);
		}
		if(KeyCode==KeyEvent.VK_S){
			mb.ENTITIES[0].move(Entity.DOWN);
		}
		if(KeyCode==KeyEvent.VK_A){
			mb.ENTITIES[0].move(Entity.LEFT);
		}
		if(KeyCode==KeyEvent.VK_D){
			mb.ENTITIES[0].move(Entity.RIGHT);
		}
	}

}
