package def;

import java.awt.*;
import java.io.*;

import javax.swing.*;

import fil.FontFileHandler;
import fil.ImageFileHandler;
import fil.SoundFileHandler;

public class Frame extends JFrame {
	private static final long serialVersionUID = 1L;
	Image dbImage;
	Graphics dbg;
	public final static Color BACKGROUND = Color.BLACK;
	public static int SPEED;
	public static final int UP = 1, DOWN = 2, LEFT = 3, RIGHT = 4, STILL = 5;
	public static final int SCALE = 8;
	public static final int WIDTH = 1028, HEIGHT = 576;
	public static final String TITLE = "Realty of Aryenia";
	GamePanel gp;

	public Frame() {

		gp = new GamePanel();

		SPEED = 1 * SCALE;
		setSize(WIDTH, HEIGHT);
		setLocationRelativeTo(null);
		setTitle(TITLE);
		setBackground(BACKGROUND);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		add(gp);

		// IO
		try {
			ImageFileHandler.loadImages();
			SoundFileHandler.load();
			FontFileHandler.loadFont();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (FontFormatException e) {
			e.printStackTrace();
		}

		Engine.Initialise();

		setVisible(true);
	}

}
