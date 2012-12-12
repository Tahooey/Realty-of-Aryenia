package def;

import java.awt.*;
import java.awt.event.*;

import world.*;
import fil.*;

public class Engine {
	
	public static WorldFileHandler wfh = new WorldFileHandler("test");
	public static PlayerFileHandler pfh = new PlayerFileHandler("test");
	public static MapBuilder mb = new MapBuilder();
	public static WorldRunner wr = new WorldRunner();
	public static Camera cam = new Camera();
	
	public static void RunGame(Graphics g){
		wr.RunWorld(g);
		cam.RunCam();
	}
	
	public static void KeyPressed(KeyEvent e){
		int KeyCode=e.getKeyCode();
		if(KeyCode==KeyEvent.VK_W){
			cam.move(Frame.UP);
			mb.MOBS[0].move(Frame.UP);
		}
		if(KeyCode==KeyEvent.VK_S){
			cam.move(Frame.DOWN);
			mb.MOBS[0].move(Frame.DOWN);
		}
		if(KeyCode==KeyEvent.VK_A){
			cam.move(Frame.LEFT);
			mb.MOBS[0].move(Frame.LEFT);
		}
		if(KeyCode==KeyEvent.VK_D){
			cam.move(Frame.RIGHT);
			mb.MOBS[0].move(Frame.RIGHT);
		}
		if(KeyCode==KeyEvent.VK_UP){
			mb.MOBS[0].Layer+=2;
		}
		if(KeyCode==KeyEvent.VK_DOWN){
			mb.MOBS[0].Layer-=2;
		}
	}
	public static void KeyReleased(KeyEvent e){
		int KeyCode=e.getKeyCode();
		if(KeyCode==KeyEvent.VK_W){
			cam.move(Frame.STILL);
			mb.MOBS[0].move(Frame.STILL);
		}
		if(KeyCode==KeyEvent.VK_S){
			cam.move(Frame.STILL);
			mb.MOBS[0].move(Frame.STILL);
		}
		if(KeyCode==KeyEvent.VK_A){
			cam.move(Frame.STILL);
			mb.MOBS[0].move(Frame.STILL);
		}
		if(KeyCode==KeyEvent.VK_D){
			cam.move(Frame.STILL);
			mb.MOBS[0].move(Frame.STILL);
		}
	}
}
