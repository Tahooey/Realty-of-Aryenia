package def;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

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
		Mouse.Update();
	}
	
	public static void Initialise(){
		Mouse.Init();
	}
	
	public static void MousePressed(MouseEvent e){
		Mouse.isPressed=true;
	}
	
	public static void MouseReleased(MouseEvent e){
		Mouse.isPressed=false;
	}
	
	public static void MouseMoved(MouseEvent e){
		int x=e.getX();
		int y=e.getY();
		Mouse.setXY(x, y);
	}
	
	public static void KeyPressed(KeyEvent e){
		int KeyCode=e.getKeyCode();
		if(KeyCode==KeyEvent.VK_W){
			mb.MOBS[0].move(Frame.UP);
		}
		if(KeyCode==KeyEvent.VK_S){
			mb.MOBS[0].move(Frame.DOWN);
		}
		if(KeyCode==KeyEvent.VK_A){
			mb.MOBS[0].move(Frame.LEFT);
		}
		if(KeyCode==KeyEvent.VK_D){
			mb.MOBS[0].move(Frame.RIGHT);
		}
		if(KeyCode==KeyEvent.VK_UP){
			if(mb.MOBS[0].Layer<Engine.mb.BLOCKS.length-1){
				mb.MOBS[0].Layer+=1;
			}else{
				mb.MOBS[0].Layer=mb.BLOCKS.length-2;
			}
		}
		if(KeyCode==KeyEvent.VK_DOWN){
			if(mb.MOBS[0].Layer>0+1){
				mb.MOBS[0].Layer-=1;
			}else{
				mb.MOBS[0].Layer=0+1;
			}
		}
		if(KeyCode==KeyEvent.VK_RIGHT){
			if(Mouse.blockToChangeTo<Mouse.maxBlock){
				Mouse.blockToChangeTo+=1;
			}			
		}
		if(KeyCode==KeyEvent.VK_LEFT){
			if(Mouse.blockToChangeTo>0){
			Mouse.blockToChangeTo-=1;
			}
		}
		if(KeyCode==KeyEvent.VK_P){
			try {
				wfh.SaveWorld();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
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
