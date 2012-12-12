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
	
	static ImageFileHandler loader=new ImageFileHandler();
	
	public static void loadImages() throws IOException{
		TerrainHigher=loadImage("terrainHigher.png");
		TerrainLower=loadImage("terrainLower.png");
		Sleeper=loadImage("mob0.png");
		Wizard=loadImage("mob1.png");
	}
	

	public static BufferedImage loadImage(String path) throws IOException {
		URL url = loader.getClass().getResource(path);
		return ImageIO.read(url);
	}

}
