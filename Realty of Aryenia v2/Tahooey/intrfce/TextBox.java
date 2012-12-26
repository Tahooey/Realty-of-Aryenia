package intrfce;

import java.awt.*;

import fil.FontFileHandler;
import fil.ImageFileHandler;

public class TextBox {
	
	int x,y,w,h;
	String text;
	public Button b;
	boolean closed=true;
	Image img;
	
	public TextBox(int xco,int yco,int width,int height,String Text){
		x=xco;
		y=yco;
		w=width;
		h=height;
		text=Text;
		b=new Button("Close",x,y+height+8,width,true);
		img=ImageFileHandler.TextBox;
	}
	
	public void run(Graphics g){
		if(!closed){
			g.drawImage(img, x,y,x+(3*8), y+(3*8), 0, 0, 3, 3, null);
			g.drawImage(img, x,y+(3*8), x+(3*8), y+h-(3*8), 0, 3, 3, 6, null);
			g.drawImage(img, x,y+h-(3*8), x+(3*8), y+h, 0, 6, 3, 9, null);
			g.drawImage(img, x+3*8,y,x+w-(3*8), y+(3*8), 3, 0, 6, 3, null);
			g.drawImage(img, x+3*8,y+(3*8),x+w-(3*8), y+h-(3*8), 3, 3, 6, 6, null);
			g.drawImage(img, x+(3*8),y+h-(3*8), x+w-(3*8), y+h, 3, 6, 6, 9, null);
			g.drawImage(img, x+w-(3*8),y,x+w, y+(3*8), 6, 0, 9, 3, null);
			g.drawImage(img, x+w-(3*8),y+(3*8), x+w, y+h-(3*8), 6, 3, 9, 6, null);
			g.drawImage(img, x+w-(3*8),y+h-(3*8), x+w, y+h, 6, 6, 9, 9, null);
			g.setFont(FontFileHandler.Tahooey);
			if(text.equals("CREDITS")){
				g.drawString("Lead Developer: Tahooey",x+(4*8),y+(4*8));
				g.drawString("Music By: Tahooey",x+(4*8),y+(5*8)+2);
				g.drawString("Textures By: Tahooey",x+(4*8),y+(6*8)+4);
				g.drawString("Help with Coding: DeathJockey",x+(4*8),y+(7*8)+6);
				g.drawString("(c) TheOnlyTahooey Games",x+(4*8),y+(32*8)+32);
			}else if(text.equals("HELP")){
				g.drawString("Controls: Up : w",x+(4*8),y+(4*8));
				g.drawString("                  Down : s",x+(4*8),y+(5*8)+2);
				g.drawString("                  Left : a",x+(4*8),y+(6*8)+4);
				g.drawString("                  Right : d",x+(4*8),y+(7*8)+6);
				g.drawString("                  Turn Music Off : o",x+(4*8),y+(8*8)+8);
				g.drawString("                  Toggle Blocks : Left",x+(4*8),y+(9*8)+10);
				g.drawString("                   and Right Arrows",x+(4*8),y+(10*8)+12);
				g.drawString("Goal: Defeat the Enemies (Soon)",x+(4*8),y+(14*8)+20);
				g.drawString("and Don't die (Soon)",x+(4*8),y+(15*8)+22);
			}else if(text.equals("CONTACT")){
				g.drawString("Please report Bugs to me on",x+(4*8),y+(4*8)+2);
				g.drawString("Twitter @Tahooey",x+(4*8),y+(5*8)+4);
			}else{
				g.drawString(text, x+(4*8),y+(4*8));
			}
			b.run(g);
			if(b.isClicked){
				closed=true;
			}
		}
	}

}
