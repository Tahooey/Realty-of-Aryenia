package fil;

import java.awt.image.*;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class ImageFileHandler {

	public static BufferedImage TerrainHigher;
	public static BufferedImage TerrainLower;
	public static BufferedImage Sleeper;
	public static BufferedImage Wizard;
	public static BufferedImage Buttons;
	public static BufferedImage Menu;
	public static BufferedImage TextBox;
	public static BufferedImage Inventory;
	public static BufferedImage ItemSheet;

	// Items
	public static BufferedImage Candle;
	public static BufferedImage Nothing;
	public static BufferedImage Selecter;
	public static BufferedImage Selected;

	static ImageFileHandler loader = new ImageFileHandler();

	public static void loadImages() throws IOException{		
		TerrainHigher=loadImage("terrainHigher.png");
		TerrainLower=loadImage("terrainLower.png");
		Sleeper=loadImage("mob0.png");
		Wizard=loadImage("mob1.png");
		Buttons=loadImage("buttons.png");
		Menu=loadImage("menu.png");
		TextBox=loadImage("txtbox.png");
		Inventory=loadImage("inv.png");
		ItemSheet=loadImage("itemsheet.png");
		TextBox = loadImage("txtbox.png");
		
		//Items
		Candle=getItem(0,0);
		Nothing=getItem(1,0);
		Selecter=getItem(15,15);
		Selected=getItem(14,15);
	}

	public static BufferedImage getItem(int across, int down) {
		BufferedImage i;

		i = ItemSheet.getSubimage(across * 8, down * 8, 8, 8);

		return i;
	}

	public static BufferedImage loadImage(String path) throws IOException {
		URL url = loader.getClass().getResource(path);
		return ImageIO.read(url);
	}

}
