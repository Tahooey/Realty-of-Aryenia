package def;

import java.awt.*;
import java.awt.event.KeyEvent;

import wrld.*;

public class Engine {
	
	public static WorldFileHandler fh = new WorldFileHandler();
	public static MapBuilder mb = new MapBuilder();
	public static Camera cam = new Camera();
	public static void RunGame(Graphics g){
		WorldRunner.RunWorld(g);
	}
	public static void KeyPressed(KeyEvent e){
		int KeyCode = e.getKeyCode();
		if(KeyCode==KeyEvent.VK_W){
			cam.move(Camera.UP);
		}
		if(KeyCode==KeyEvent.VK_S){
			cam.move(Camera.DOWN);
		}
		if(KeyCode==KeyEvent.VK_A){
			cam.move(Camera.LEFT);
		}
		if(KeyCode==KeyEvent.VK_D){
			cam.move(Camera.RIGHT);
		}
	}

}
