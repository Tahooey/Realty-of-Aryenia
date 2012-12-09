package img;

import java.awt.*;
import java.io.*;

public class FontLoader {
	
	public static Font Tahooey;
	static File font1 = new File("res/Font/tahooey.ttf");
	
	public static void loadFont() throws FontFormatException, IOException{
		Tahooey=Font.createFont(Font.TRUETYPE_FONT, font1).deriveFont(Font.BOLD,12);
	}

}
