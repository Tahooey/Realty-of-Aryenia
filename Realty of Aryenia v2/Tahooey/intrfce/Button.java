package intrfce;

import java.awt.*;

import fil.FontFileHandler;
import fil.ImageFileHandler;

public class Button {
	
	public boolean isClicked,isHoveredOver,isReleased;
	public String txt;
	public int x,y,w,h=72;
	public Rectangle r;
	boolean doStuff;
	
	public int imgy1=9;
	public Button(String Text, int x,int y,int w,boolean doesStuff){
		r=new Rectangle();
		txt=Text;
		this.x=x;
		this.y=y;
		this.w=w;
		doStuff=doesStuff;
	}
	
	public void run(Graphics g){
		if(doStuff){
			setRect();
			if(isClicked){
				imgy1=18;
			}else if(isHoveredOver){
				imgy1=9;
			}else{
				imgy1=0;
			}
		}
		draw(g);
	}
	
	public void setRect(){
		r.setSize(w,h);
		r.setLocation(x,y);
	}
	
	public void draw(Graphics g){
		g.setFont(FontFileHandler.TahooeyLarge);
		g.drawImage(ImageFileHandler.Buttons, x, y, x+24, y+72, 0, imgy1, 3, imgy1+9, null);
		g.drawImage(ImageFileHandler.Buttons, x+24, y, x+w-48, y+72, 3, imgy1, 6, imgy1+9, null);
		g.drawImage(ImageFileHandler.Buttons, x+(w-48), y, x+(w-48)+24, y+72, 6, imgy1, 9, imgy1+9, null);
		g.drawString(txt, x+60, y+42);
	}

}
