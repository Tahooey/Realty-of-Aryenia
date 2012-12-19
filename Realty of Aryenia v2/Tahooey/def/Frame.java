package def;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;

import fil.ImageFileHandler;
import fil.SoundFileHandler;

public class Frame extends JFrame implements KeyListener, MouseListener, MouseMotionListener {
	private static final long serialVersionUID = 1L;
	Image dbImage;
	Graphics dbg;
	public static final int SPEED=8;
	public static final int UP=1,DOWN=2,LEFT=3,RIGHT=4,STILL=5;
	public static  final int SCALE=8;
	public static final int WIDTH=1028,HEIGHT=576;
	public static final String TITLE="Realty of Aryenia";
	
	public Frame(){
		setSize(WIDTH,HEIGHT);
		setLocationRelativeTo(null);
		setTitle(TITLE);
		setBackground(Color.black);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		//IO
		try {
			ImageFileHandler.loadImages();
			SoundFileHandler.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Listeners
		addKeyListener(this);
		addMouseListener(this);
		addMouseMotionListener(this);
		
		//Initialise
		Engine.Initialise();
		SoundFileHandler.sound1.loop();
		
		setVisible(true);
	}	
	
	public void paintComponent(Graphics g){
		Engine.RunGame(g);
		
		repaint();
	}
	
	public void paint(Graphics g){
		dbImage=createImage(getWidth(), getHeight());
		dbg = dbImage.getGraphics();		
		paintComponent(dbg);
		g.drawImage(dbImage, 0, 0, this);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		Engine.KeyPressed(arg0);
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		Engine.KeyReleased(arg0);
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		Engine.MousePressed(arg0);
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		Engine.MouseReleased(arg0);
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		Engine.MouseMoved(arg0);
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		Engine.MouseMoved(arg0);
	}

}
