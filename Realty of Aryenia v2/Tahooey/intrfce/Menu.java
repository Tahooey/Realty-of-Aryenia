package intrfce;

import java.awt.*;

import def.Engine;
import fil.ImageFileHandler;

public class Menu {

	public static boolean runMenu = true;

	public static Button[] BUTTONS = new Button[6];
	public static Button b1 = new Button("Start", 10 * 8, 20 * 8, 50 * 8, true);
	public static Button b2 = new Button("The Realty of Aryenia", 22 * 8,
			5 * 8, 70 * 8, false);
	public static Button b3 = new Button("Credits", 10 * 8, 30 * 8, 50 * 8,
			true);
	public static Button b4 = new Button("Help", 10 * 8, 40 * 8, 50 * 8, true);
	public static Button b5 = new Button("Contact Me", 10 * 8, 50 * 8, 50 * 8,
			true);
	public static Button b6 = new Button("||Save||", 10 * 8, 60 * 8, 50 * 8,
			true);

	public static TextBox[] TEXTBOXES = new TextBox[3];
	public static TextBox tb1 = new TextBox(70 * 8, 15 * 8, 40 * 8, 40 * 8,
			"CREDITS");
	public static TextBox tb2 = new TextBox(70 * 8, 15 * 8, 40 * 8, 40 * 8,
			"HELP");
	public static TextBox tb3 = new TextBox(70 * 8, 15 * 8, 40 * 8, 40 * 8,
			"CONTACT");

	public static void Init() {
		buildArray();
	}

	public static void runMenu(Graphics g) {
		if (runMenu) {
			g.drawImage(ImageFileHandler.Menu, 0, 0, def.Frame.WIDTH,
					def.Frame.HEIGHT, 0, 0, 129, 72, null);
			for (int i = 0; i < BUTTONS.length; i++) {
				BUTTONS[i].run(g);
			}
			for (int i = 0; i < TEXTBOXES.length; i++) {
				TEXTBOXES[i].run(g);
			}
		}
	}

	public static void menuUpdate() {
		doButtonsActions();
	}

	public static void doButtonsActions() {
		if (b1.isClicked) {
			runMenu = false;
		}
		if (b3.isClicked) {
			tb1.closed = false;
		}
		if (b4.isClicked) {
			tb2.closed = false;
		}
		if (b5.isClicked) {
			tb3.closed = false;
		}
		if (b6.isClicked) {
			Engine.save();
		}
	}

	public static void buildArray() {
		BUTTONS[0] = b1;
		BUTTONS[1] = b2;
		BUTTONS[2] = b3;
		BUTTONS[3] = b4;
		BUTTONS[4] = b5;
		BUTTONS[5] = b6;

		TEXTBOXES[0] = tb1;
		TEXTBOXES[1] = tb2;
		TEXTBOXES[2] = tb3;
	}
}
