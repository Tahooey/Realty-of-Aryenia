package itm;

import java.awt.*;

import def.Mouse;
import fil.*;

public class Inventory {

	public Image PImage;
	public String PName;
	public String PType;

	public boolean swapped = false;

	public boolean isControlledByPlayer;

	public Item can = new Candle();

	public Rectangle[][] RECTS;

	public boolean isShown = false;
	public static final int EXTRA_SMALL = 0, SMALL = 1, LARGE = 2,
			EXTRA_LARGE = 3;
	public int ItemW, ItemH;

	public int w, h;
	public int x, y;

	public Item[][] ITEMS;

	public Image img = ImageFileHandler.Inventory;

	public Inventory(int size) {
		ItemW = 8;
		if (size == EXTRA_SMALL) {
			ItemH = 1;
		}
		if (size == SMALL) {
			ItemH = 4;
		}
		if (size == LARGE) {
			ItemH = 8;
		}
		if (size == EXTRA_LARGE) {
			ItemH = 8;
			ItemW = 12;
		}

		w = ItemW * 8 * 8;
		h = ItemH * 8 * 8;

		x = (def.Frame.WIDTH / 2) - (w / 2);
		y = 20;

		RECTS = new Rectangle[ItemH][ItemW];
		for (int h = 0; h < RECTS.length; h++) {
			for (int w = 0; w < RECTS[h].length; w++) {
				RECTS[h][w] = new Rectangle();
				RECTS[h][w].setSize(32, 32);
				RECTS[h][w].setLocation(x + 16 + (w * 64), y + 128 + 48
						+ (h * 40));
			}
		}
	}

	public void showInventory() {
		isShown = true;
	}

	public void stopShowingInventory() {
		isShown = false;
	}

	public void checkForSwap() {
		int amount = 0;
		for (int h = 0; h < ItemH; h++) {
			for (int w = 0; w < ItemW; w++) {
				if (ITEMS[h][w].isSelected) {
					amount++;
				}
			}
		}
		if (amount == 2) {
			swap();
		}
	}

	public void swap() {
		Item itm1 = new NoItem();
		Item itm2 = new NoItem();

		int Itm1W = 0;
		int Itm1H = 0;
		int Itm2W = 0;
		int Itm2H = 1;
		int amount = 1;
		for (int h = 0; h < ItemH; h++) {
			for (int w = 0; w < ItemW; w++) {
				if (ITEMS[h][w].isSelected) {
					if (amount == 1) {
						itm1 = ITEMS[h][w];
						Itm1W = w;
						Itm1H = h;
						amount++;
					} else if (amount == 2) {
						itm2 = ITEMS[h][w];
						Itm2W = w;
						Itm2H = h;
						amount++;
					}
				}
			}
		}
		ITEMS[Itm1H][Itm1W] = itm2;
		ITEMS[Itm2H][Itm2W] = itm1;
		// System.out.println("1: "+ITEMS[Itm1H][Itm1W]);
		// System.out.println("2: "+ITEMS[Itm2H][Itm2W]);
		for (int h = 0; h < ItemH; h++) {
			for (int w = 0; w < ItemW; w++) {
				ITEMS[h][w].isSelected = false;
			}
		}
		swapped = true;
	}

	public void deselectAll() {
		for (int h = 0; h < ItemH; h++) {
			for (int w = 0; w < ItemW; w++) {
				ITEMS[h][w].isSelected = false;
			}
		}
	}

	public void draw(Graphics g) {
		if (isShown) {
			g.drawImage(img, x, y, x + (3 * 8), y + (3 * 8), 0, 0, 3, 3, null);
			g.drawImage(img, x, y + (3 * 8), x + (3 * 8), y + h - (3 * 8), 0,
					3, 3, 6, null);
			g.drawImage(img, x, y + h - (3 * 8), x + (3 * 8), y + h, 0, 6, 3,
					9, null);
			g.drawImage(img, x + 3 * 8, y, x + w - (3 * 8), y + (3 * 8), 3, 0,
					6, 3, null);
			g.drawImage(img, x + 3 * 8, y + (3 * 8), x + w - (3 * 8), y + h
					- (3 * 8), 3, 3, 6, 6, null);
			g.drawImage(img, x + (3 * 8), y + h - (3 * 8), x + w - (3 * 8), y
					+ h, 3, 6, 6, 9, null);
			g.drawImage(img, x + w - (3 * 8), y, x + w, y + (3 * 8), 6, 0, 9,
					3, null);
			g.drawImage(img, x + w - (3 * 8), y + (3 * 8), x + w, y + h
					- (3 * 8), 6, 3, 9, 6, null);
			g.drawImage(img, x + w - (3 * 8), y + h - (3 * 8), x + w, y + h, 6,
					6, 9, 9, null);
		}
		if (!isShown) {
			if (isControlledByPlayer) {
				deselectAll();
				for (int i = 0; i < ItemW; i++) {
					g.drawImage(ITEMS[ItemH - 1][i].item, x + 16 + (i * 64), y
							+ ((ItemH - 1) * 40) + (h / 4)
							+ (h / 16 + (h / 32)), 32, 32, null);
				}
			}
		} else if (isControlledByPlayer) {
			checkForSwap();
			if (swapped) {
				if (!Mouse.isPressed) {
					deselectAll();
					swapped = false;
				}
			}
		}
		if (isShown) {
			for (int j = 0; j < ItemH; j++) {
				for (int i = 0; i < ItemW; i++) {
					g.drawImage(ITEMS[j][i].item, x + 16 + (i * 64), y
							+ (j * 40) + (h / 4) + (h / 16 + (h / 32)), 32, 32,
							null);
					if (RECTS[j][i].intersects(Mouse.r)) {
						g.drawImage(ImageFileHandler.Selecter, x + 16
								+ (i * 64), y + (j * 40) + (h / 4)
								+ (h / 16 + (h / 32)), 32, 32, null);
						if (Mouse.isPressed) {
							ITEMS[j][i].isSelected = true;
						}
					}
					if (ITEMS[j][i].isSelected) {
						g.drawImage(ImageFileHandler.Selected, x + 16
								+ (i * 64), y + (j * 40) + (h / 4)
								+ (h / 16 + (h / 32)), 32, 32, null);
					}
				}
			}
			g.drawImage(PImage, x + 16, y + 16, x + 128 + 16, y + 128 + 16, 0,
					0, 8, 8, null);
			g.setColor(Color.BLACK);
			g.drawString(PName, x + 256 - 96, y + 48);
			g.drawString(PType, x + 256 - 96, y + 72);
		}

	}

}
