package def;

import java.awt.*;

import blcks.*;

public class Mouse {

	static String currentBlock = "Air";

	static Block[] bl;

	static int blockToChangeTo = 0;
	static int MapToChangeTo = 0;
	static int maxBlock = 14;

	static int layer;
	public static Rectangle r;
	static int X, Y;
	public static boolean isPressed = false;

	public static void Init() {
		bl = new Block[maxBlock + 1];
		buildArray();
		r = new Rectangle();
		r.setSize(1, 1);
	}

	public static void buildArray() {
		bl[0] = new Air();
		bl[1] = new Grass();
		bl[2] = new StoneBrick();
		bl[3] = new Bricks();
		bl[4] = new WoodStairs(0, 0, Block.UP);
		bl[5] = new WoodStairs(0, 0, Block.DOWN);
		bl[6] = new WoodStairs(0, 0, Block.LEFT);
		bl[7] = new WoodStairs(0, 0, Block.RIGHT);
		bl[8] = new MossyStoneBrick();
		bl[9] = new Wood();
		bl[10] = new Stone();
		bl[11] = new MapChanger(0, 0, 0, Block.UP);
		bl[12] = new MapChanger(0, 0, 0, Block.DOWN);
		bl[13] = new MapChanger(0, 0, 0, Block.LEFT);
		bl[14] = new MapChanger(0, 0, 0, Block.RIGHT);
	}

	public static void Update() {
		r.setLocation(X, Y);
		layer = Engine.mb.MOBS[0].Layer;
		if (Engine.editMode) {
			ChangeTile();
		}
		comButtons();
	}

	public static void highLightTiles(Graphics g) {
		if (!intrfce.Menu.runMenu) {
			for (int h = 0; h < Engine.mb.BLOCKS[layer - 1].length; h++) {
				for (int w = 0; w < Engine.mb.BLOCKS[layer - 1][h].length; w++) {
					if (r.intersects(Engine.mb.BLOCKS[layer - 1][h][w].r)) {
						g.drawRect(Engine.mb.BLOCKS[layer - 1][h][w].finalx
								+ Engine.cam.x,
								Engine.mb.BLOCKS[layer - 1][h][w].finaly
										+ Engine.cam.y, Block.finalw,
								Block.finalh);
						g.setColor(Color.WHITE);
						g.drawString(w+" "+h, 20, 30);

					}
				}
			}

		}
	}

	public static void comButtons() {
		for (int i = 0; i < intrfce.Menu.BUTTONS.length; i++) {
			if (r.intersects(intrfce.Menu.BUTTONS[i].r)) {
				if (isPressed) {
					intrfce.Menu.BUTTONS[i].isClicked = true;
					intrfce.Menu.BUTTONS[i].isHoveredOver = false;
				} else {
					intrfce.Menu.BUTTONS[i].isClicked = false;
					intrfce.Menu.BUTTONS[i].isHoveredOver = true;
				}
			} else {
				intrfce.Menu.BUTTONS[i].isClicked = false;
				intrfce.Menu.BUTTONS[i].isHoveredOver = false;
			}
		}
		for (int i = 0; i < intrfce.Menu.TEXTBOXES.length; i++) {
			if (r.intersects(intrfce.Menu.TEXTBOXES[i].b.r)) {
				if (isPressed) {
					intrfce.Menu.TEXTBOXES[i].b.isClicked = true;
					intrfce.Menu.TEXTBOXES[i].b.isHoveredOver = false;
				} else {
					intrfce.Menu.TEXTBOXES[i].b.isClicked = false;
					intrfce.Menu.TEXTBOXES[i].b.isHoveredOver = true;
				}
			} else {
				intrfce.Menu.TEXTBOXES[i].b.isClicked = false;
				intrfce.Menu.TEXTBOXES[i].b.isHoveredOver = false;
			}
		}
	}

	public static void ChangeTile() {
		if (!intrfce.Menu.runMenu) {
			for (int h = 0; h < Engine.mb.BLOCKS[layer - 1].length; h++) {
				for (int w = 0; w < Engine.mb.BLOCKS[layer - 1][h].length; w++) {
					if (r.intersects(Engine.mb.BLOCKS[layer - 1][h][w].r)) {
						if (isPressed) {
							Engine.mb.ID[layer - 1][h][w] = blockToChangeTo;
							currentBlock = Engine.mb.BLOCKS[layer - 1][h][w].name;
							Engine.mb.BuildBlocks();
						}
					}
				}
			}

		}
	}

	public static void setXY(int xco, int yco) {
		X = xco;
		Y = yco;
	}

}
