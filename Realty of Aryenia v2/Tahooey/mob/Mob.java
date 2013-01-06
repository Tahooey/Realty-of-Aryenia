package mob;

import itm.*;

import java.awt.*;
import def.*;

public class Mob {

	public String Name;
	public int x, y, MobType;
	public int finalx, finaly;
	public int w = 8, h = 8;
	public int finalw, finalh;
	public Image IMG_TO_DRAW;
	public int Layer;
	
	public int map=0;

	public int direction;

	public int ID;

	public int dx = 0, dy = 0;
	public int imgx = 0, imgy = 0, imgx2 = imgx + w, imgy2 = imgy + h;

	public boolean isControlledByPlayer = false;

	public Rectangle forward;
	public Rectangle r;
	public Rectangle up, down, left, right;
	boolean canMoveLeft = true, canMoveRight = true, canMoveUp = true,
			canMoveDown = true;
	public boolean GoingLeft = false, GoingRight = false, GoingUp = false,
			GoingDown = false;

	public int invSize = Inventory.LARGE;

	public Inventory inv = new Inventory(invSize);

	public Item[][] ITEMS = new Item[inv.ItemH][inv.ItemW];

	public Mob() {
		forward = new Rectangle();
		r = new Rectangle();
		up = new Rectangle();
		down = new Rectangle();
		left = new Rectangle();
		right = new Rectangle();
	}

	public void loadEmptyInventory() {
		for (int h = 0; h < ITEMS.length; h++) {
			for (int w = 0; w < ITEMS[h].length; w++) {
				ITEMS[h][w] = new NoItem();
			}
		}
	}

	public void setImage(int frame) {
		if (frame == def.Frame.UP) {
			imgx = 16;
			imgy = 0;
			imgx2 = imgx + w;
			imgy2 = imgy + h;
		} else if (frame == def.Frame.DOWN) {
			imgx = 24;
			imgy = 0;
			imgx2 = imgx + w;
			imgy2 = imgy + h;
		} else if (frame == def.Frame.LEFT) {
			imgx = 8;
			imgy = 0;
			imgx2 = imgx + w;
			imgy2 = imgy + h;
		} else if (frame == def.Frame.RIGHT) {
			imgx = 0;
			imgy = 0;
			imgx2 = imgx + w;
			imgy2 = imgy + h;
		} else {

		}
	}

	public void workFirstInts() {
		finalw = w * def.Frame.SCALE;
		finalh = h * def.Frame.SCALE;
		finalx = (x * def.Frame.SCALE);
		finaly = (y * def.Frame.SCALE);
	}

	public void setRectangles() {
		if (direction == def.Frame.UP) {
			forward.setSize(finalw, def.Frame.SPEED);
			forward.setLocation(finalx + Engine.cam.x, finaly + Engine.cam.y
					+ (def.Frame.SPEED));
		}
		if (direction == def.Frame.DOWN) {
			forward.setSize(finalw, def.Frame.SPEED);
			forward.setLocation(finalx + Engine.cam.x, finaly + Engine.cam.y
					+ finalh - (def.Frame.SPEED * 2));
		}
		if (direction == def.Frame.LEFT) {
			forward.setSize(def.Frame.SPEED, finalh);
			forward.setLocation(finalx + Engine.cam.x + (def.Frame.SPEED),
					finaly + Engine.cam.y);
		}
		if (direction == def.Frame.RIGHT) {
			forward.setSize(def.Frame.SPEED, finalh);
			forward.setLocation(finalx + Engine.cam.x + finalw
					- (def.Frame.SPEED * 2), finaly + Engine.cam.y);
		}
		r.setSize(finalw, finalh);
		r.setLocation(finalx + Engine.cam.x, finaly + Engine.cam.y);

		up.setSize(finalw, def.Frame.SPEED);
		down.setSize(finalw, def.Frame.SPEED);
		left.setSize(def.Frame.SPEED, finalh);
		right.setSize(def.Frame.SPEED, finalh);

		up.setLocation(finalx + Engine.cam.x, (finaly + Engine.cam.y)
				- def.Frame.SPEED);
		down.setLocation(finalx + Engine.cam.x,
				(finaly + finalh + Engine.cam.y));
		left.setLocation(finalx + Engine.cam.x - def.Frame.SPEED, finaly
				+ Engine.cam.y);
		right.setLocation(finalx + finalw + Engine.cam.x, finaly + Engine.cam.y);

	}

	public void move(int dir) {
		direction = dir;
		setImage(dir);
		if (dir == def.Frame.UP) {
			GoingUp = true;
			GoingDown = false;
			beStoped();
			if (canMoveUp) {
				dy = -def.Frame.SPEED;
			}

		}
		if (dir == def.Frame.DOWN) {
			GoingDown = true;
			GoingUp = false;
			beStoped();
			if (canMoveDown) {
				dy = def.Frame.SPEED;
			}
		}
		if (dir == def.Frame.LEFT) {
			GoingLeft = true;
			GoingRight = false;
			beStoped();
			if (canMoveLeft) {
				dx = -def.Frame.SPEED;
			}

		}
		if (dir == def.Frame.RIGHT) {
			GoingRight = true;
			GoingLeft = false;
			beStoped();
			if (canMoveRight) {
				dx = def.Frame.SPEED;
			}
		}
		if (dir == def.Frame.STILL) {
			dx = 0;
			dy = 0;
			canMoveLeft = true;
			canMoveRight = true;
			canMoveUp = true;
			canMoveDown = true;
		}
	}

	public void beStoped() {
		for (int h = 0; h < Engine.mb.BLOCKS[Layer - 1].length; h++) {
			for (int w = 0; w < Engine.mb.BLOCKS[Layer - 1][h].length; w++) {
				if (Engine.mb.BLOCKS[Layer - 1][h][w].isCollidable) {
					if (Engine.mb.BLOCKS[Layer - 1][h][w] != null) {
						if (up.intersects(Engine.mb.BLOCKS[Layer - 1][h][w].r)) {
							dy = 0;
							canMoveUp = false;
						}
						if (down.intersects(Engine.mb.BLOCKS[Layer - 1][h][w].r)) {
							dy = 0;
							canMoveDown = false;
						}
						if (left.intersects(Engine.mb.BLOCKS[Layer - 1][h][w].r)) {
							dx = 0;
							canMoveLeft = false;
						}
						if (right.intersects(Engine.mb.BLOCKS[Layer][h][w].r)) {
							dx = 0;
							canMoveRight = false;
						}
					}
				}
			}
		}
	}

	public void runMob() {
		if (finalx + Engine.cam.x >= 0 - finalw) {
			if (finalx + Engine.cam.x <= def.Frame.WIDTH) {
				if (finaly + Engine.cam.y >= 0 - finalh) {
					if (finaly + Engine.cam.y <= def.Frame.HEIGHT) {
						finalx = finalx + dx;
						finaly = finaly + dy;
						setRectangles();
						beStoped();
						inv.ITEMS = ITEMS;
						inv.isControlledByPlayer = isControlledByPlayer;
					}
				}
			}
		}
	}

	public void drawMob(Graphics g) {
		if (finalx + Engine.cam.x >= 0 - finalw) {
			if (finalx + Engine.cam.x <= def.Frame.WIDTH) {
				if (finaly + Engine.cam.y >= 0 - finalh) {
					if (finaly + Engine.cam.y <= def.Frame.HEIGHT) {
						g.drawImage(IMG_TO_DRAW, finalx + Engine.cam.x, finaly
								+ Engine.cam.y, finalx + finalw + Engine.cam.x,
								finaly + finalh + Engine.cam.y, imgx, imgy,
								imgx2, imgy2, null);
						if (isControlledByPlayer) {
							inv.draw(g);
						}
					}
				}
			}
		}
	}

}
