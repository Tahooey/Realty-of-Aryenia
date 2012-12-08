package def;

import img.ImageHandler;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;

public class Frame extends JFrame implements KeyListener, MouseMotionListener, MouseListener {
	
	private static final long serialVersionUID = 1L;
	
	Image dbImage;
	Graphics dbg;
	
	public static final int SPEED=8;
	public double VERSION=0.07;
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
		addMouseMotionListener(this);
		addMouseListener(this);		
		try {
			ImageHandler.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		setVisible(true);
	}
	
	public void paintComponent(Graphics g){
		
		Engine.RunGame(g);
		
		if(RUNNING){
			repaint();
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
		Engine.KeyReleased(arg0);
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}

	@Override
	public void mouseDragged(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(java.awt.event.MouseEvent arg0) {
		
	}

	@Override
	public void mouseEntered(java.awt.event.MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(java.awt.event.MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(java.awt.event.MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(java.awt.event.MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}	

}
