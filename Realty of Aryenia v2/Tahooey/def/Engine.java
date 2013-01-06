package def;

import java.awt.*;
import java.awt.event.*;

import world.*;
import fil.*;

public class Engine {

	public static boolean frozen = false;

	public static boolean gameIsRunning = true;

	public static boolean changingMaps;

	public static boolean editMode = true;

	public static boolean canUpdateMap = false;
	public static int currentmap;

	public static MapFileOverLord mfo = new MapFileOverLord("The World");
	public static MapBuilder mb;
	public static WorldRunner wr = new WorldRunner();
	public static Camera cam = new Camera();

	public static void RunGame(Graphics g) {
		g.setColor(Color.black);
		wr.RunWorld(g);
		if (editMode == true) {
			Mouse.highLightTiles(g);
		}
		if (intrfce.Menu.runMenu) {
			intrfce.Menu.runMenu(g);
		}
	}

	public static void GameUpdate() {
		if (changingMaps) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			BlockUpdater.run();
			MobUpdater.run();
			CamUpdater.run();
			MouseUpdater.run();
			MenuDecider.run();
		}
	}

	static Thread BlockUpdater = new Thread() {
		public void run() {
			wr.RunBlocks();
		}
	};
	static Thread MobUpdater = new Thread() {
		public void run() {
			wr.RunMobs();
		}
	};
	static Thread CamUpdater = new Thread() {
		public void run() {
			cam.RunCam();
		}
	};
	static Thread MouseUpdater = new Thread() {
		public void run() {
			Mouse.Update();
		}
	};
	static Thread MenuDecider = new Thread() {
		public void run() {
			if (intrfce.Menu.runMenu) {
				intrfce.Menu.menuUpdate();
			}
		}
	};

	public static void changeMap(int i) {
		mb.ChangeMap(i);
	}

	public static void updateMap() {
		mb.ChangeMap(currentmap);
		canUpdateMap = false;
	}

	public static void Initialise() {
		mb = new MapBuilder(0);
		Mouse.Init();
		intrfce.Menu.Init();
	}

	public static void MousePressed(MouseEvent e) {
		Mouse.isPressed = true;
	}

	public static void MouseReleased(MouseEvent e) {
		Mouse.isPressed = false;
	}

	public static void MouseMoved(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		Mouse.setXY(x, y);
	}

	public static void KeyPressed(KeyEvent e) {
		int KeyCode = e.getKeyCode();
		if (intrfce.Menu.runMenu == false) {
			if (!editMode) {
				if (KeyCode == KeyEvent.VK_E) {
					if (!mb.MOBS[0].inv.isShown) {
						mb.MOBS[0].inv.showInventory();
						frozen=true;
					} else {
						mb.MOBS[0].inv.stopShowingInventory();
						frozen=false;
					}
				}
				if (!frozen) {
					if (KeyCode == KeyEvent.VK_W) {
						mb.MOBS[0].move(Frame.UP);
					}
					if (KeyCode == KeyEvent.VK_S) {
						mb.MOBS[0].move(Frame.DOWN);
					}
					if (KeyCode == KeyEvent.VK_A) {
						mb.MOBS[0].move(Frame.LEFT);
					}
					if (KeyCode == KeyEvent.VK_D) {
						mb.MOBS[0].move(Frame.RIGHT);
					}
				}else{
					mb.MOBS[0].dx=0;
					mb.MOBS[0].dy=0;
				}
			} else {
				if (KeyCode == KeyEvent.VK_W) {
					cam.move(Frame.UP);
				}
				if (KeyCode == KeyEvent.VK_S) {
					cam.move(Frame.DOWN);
				}
				if (KeyCode == KeyEvent.VK_A) {
					cam.move(Frame.LEFT);
				}
				if (KeyCode == KeyEvent.VK_D) {
					cam.move(Frame.RIGHT);
				}
			}
		}
		if (KeyCode == KeyEvent.VK_O) {
			SoundFileHandler.sound1.stop();
		}
		if (KeyCode == KeyEvent.VK_ESCAPE) {
			intrfce.Menu.runMenu = true;
		}
		if (editMode) {
			if (KeyCode == KeyEvent.VK_1) {
				if (currentmap > 0) {
					currentmap -= 1;
					canUpdateMap = true;
				}
			}
			if (KeyCode == KeyEvent.VK_2) {
				if (currentmap < mfo.WFH.length - 1) {
					currentmap += 1;
					canUpdateMap = true;
				}
			}
			if (KeyCode == KeyEvent.VK_UP) {
				if (mb.MOBS[0].Layer < Engine.mb.BLOCKS.length - 1) {
					mb.MOBS[0].Layer += 1;
				} else {
					mb.MOBS[0].Layer = mb.BLOCKS.length - 2;
				}
			}
			if (KeyCode == KeyEvent.VK_DOWN) {
				if (mb.MOBS[0].Layer > 0 + 1) {
					mb.MOBS[0].Layer -= 1;
				} else {
					mb.MOBS[0].Layer = 0 + 1;
				}
			}
		}
		if (KeyCode == KeyEvent.VK_RIGHT) {
			if (Mouse.blockToChangeTo < Mouse.maxBlock) {
				Mouse.blockToChangeTo += 1;
				Mouse.currentBlock = Mouse.bl[Mouse.blockToChangeTo].name;
			}
		}
		if (KeyCode == KeyEvent.VK_LEFT) {
			if (Mouse.blockToChangeTo > 0) {
				Mouse.blockToChangeTo -= 1;
				Mouse.currentBlock = Mouse.bl[Mouse.blockToChangeTo].name;
			}
		}
	}

	public static void save() {
		mb.save();
	}

	public static void KeyReleased(KeyEvent e) {
		int KeyCode = e.getKeyCode();
		if (KeyCode == KeyEvent.VK_W) {
			cam.move(Frame.STILL);
			mb.MOBS[0].move(Frame.STILL);
		}
		if (KeyCode == KeyEvent.VK_S) {
			cam.move(Frame.STILL);
			mb.MOBS[0].move(Frame.STILL);
		}
		if (KeyCode == KeyEvent.VK_A) {
			cam.move(Frame.STILL);
			mb.MOBS[0].move(Frame.STILL);
		}
		if (KeyCode == KeyEvent.VK_D) {
			cam.move(Frame.STILL);
			mb.MOBS[0].move(Frame.STILL);
		}
	}
}
