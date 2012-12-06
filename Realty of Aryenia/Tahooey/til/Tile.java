package til;

import java.awt.*;

public class Tile {
	
	int x,y;
	int w,h;
	Rectangle r;
	
	public Tile(){
		r = new Rectangle();
	}
	
	public void runTile(Graphics g){
		r.setSize(w,h);
		r.setLocation(x,y);
		g.drawRect(r.x, r.y, r.width, r.height);
	}
	public boolean isIntersecting(Rectangle r){
		return r.intersects(this.r);
	}
	public void setSize(int w,int h){
		this.w=w;
		this.h=h;
	}
	public void setLocation(int x, int y){
		this.x=x;
		this.y=y;
	}

}
