package fil;

import java.awt.*;
import java.io.*;

public class FontFileHandler {
	
	public static Font Tahooey;
	public static Font TahooeyLarge;
	static File font1 = new File("res/fonts/tahooey.ttf");
	
	public static void loadFont() throws FontFormatException, IOException{
		Tahooey=Font.createFont(Font.TRUETYPE_FONT, font1).deriveFont(Font.BOLD,12);
		TahooeyLarge=Font.createFont(Font.TRUETYPE_FONT, font1).deriveFont(Font.BOLD,24);
	}

}
