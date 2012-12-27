package def;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class GamePanel extends JPanel implements Runnable {
	private static final long serialVersionUID = 1L;

	private Image dbImage;
	private Graphics dbg;
	static final int W = Frame.WIDTH, H = Frame.HEIGHT;
	static final Dimension gameDim = new Dimension(W, H);

	private Thread game;
	private volatile boolean running = false;
	//private long period = 6 * 1000000;

	public GamePanel() {
		setPreferredSize(gameDim);
		setBackground(Color.WHITE);
		setFocusable(true);
		requestFocus();
		// Handle all key inputs from user
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				Engine.KeyPressed(e);
			}

			@Override
			public void keyReleased(KeyEvent e) {
				Engine.KeyReleased(e);
			}

			@Override
			public void keyTyped(KeyEvent e) {

			}
		});

		addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {
				Engine.MousePressed(e);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				Engine.MouseReleased(e);
			}
		});

		addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseDragged(MouseEvent e) {
				Engine.MouseMoved(e);

			}

			@Override
			public void mouseMoved(MouseEvent e) {
				Engine.MouseMoved(e);

			}
		});
	}

	@Override
	public void run() {
		while (running) {
			gameUpdate();
			gameRender();
			paintScreen();
		}
	}

	private void gameUpdate() {
		if (running && game != null) {
			Engine.GameUpdate();
		}
	}

	public void draw(Graphics g) {
		Engine.RunGame(g);
	}

	private void gameRender() {
		if (dbImage == null) { // Create the buffer
			dbImage = createImage(W, H);
			if (dbImage == null) {
				System.err.println("dbImage is still null!");
				return;
			} else {
				dbg = dbImage.getGraphics();
			}
		}
		dbg.setColor(Frame.BACKGROUND);
		dbg.fillRect(0, 0, W, H);
		draw(dbg);
	}

	private void paintScreen() {
		Graphics g;
		try {
			g = this.getGraphics();
			if (dbImage != null && g != null) {
				g.drawImage(dbImage, 0, 0, null);
			}
			Toolkit.getDefaultToolkit().sync();
			g.dispose();
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	public void addNotify() {
		super.addNotify();
		startGame();
	}

	private void startGame() {
		if (game == null || !running) {
			game = new Thread(this);
			running = true;
			game.start();
		}
	}

	public void stopGame() {
		if (running) {
			running = false;
		}
	}

	public void log(String i) {
		System.out.println(i);
	}

}
