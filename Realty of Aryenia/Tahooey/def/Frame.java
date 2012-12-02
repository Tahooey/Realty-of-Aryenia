package def;

import img.ImageHandler;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.*;

public class Frame extends JFrame implements KeyListener {
	
	private static final long serialVersionUID = 1L;
	
	Image dbImage;
	Graphics dbg;
	
	public static final int SPEED=8;
	public double VERSION=0.01;
	public static int WIDTH=1028,HEIGHT=576;
	public static int SCALE=8;
	public boolean RUNNING=true;
	public String TITLE="The Realty of Aryenia v "+VERSION;
	public Color BACKGROUND=Color.BLACK;
		
	public Frame(){
		setSize(WIDTH,HEIGHT);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setTitle(TITLE);
		setBackground(Color.black);
		addKeyListener(this);
		
		setVisible(true);
	}
	
	public void paintComponent(Graphics g){
		
		Engine.RunGame(g);
		
		if(RUNNING){
			repaint();
		}
		try {
			ImageHandler.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}
	
	

}
