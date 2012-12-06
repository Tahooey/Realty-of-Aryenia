package img;

import java.awt.image.*;
import java.io.*;
import java.net.*;

import javax.imageio.*;

public class ImageHandler {
	
	static ImageHandler loader = new ImageHandler();
	
	public static BufferedImage terrainHigher;
	public static BufferedImage terrainLower;
	public static BufferedImage Player;
	
	public static void load() throws IOException{
		terrainHigher=loadImage("terrainHigher.png");
		terrainLower=loadImage("terrainLower.png");
		Player=loadImage("mob0.png");
	}
	
	public static BufferedImage loadImage(String path) throws IOException {
		URL url = loader.getClass().getResource(path);
		return ImageIO.read(url);
	}
}
