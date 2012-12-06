package def;

public class Camera {
	
	public int xOffset,yOffset;
	public static int UP=1,DOWN=2,LEFT=3,RIGHT=4;
	
	public Camera(int x,int y){
		setXY(x,y);
	}
	
	public void setXY(int x, int y){
		xOffset=x;
		yOffset=y;
	}
	
	public void move(int dir){
		if(dir==UP){
			yOffset+=Frame.SPEED;
		}
		if(dir==DOWN){
			yOffset-=Frame.SPEED;
		}
		if(dir==LEFT){
			xOffset+=Frame.SPEED;
		}
		if(dir==RIGHT){
			xOffset-=Frame.SPEED;
		}
	}

}
