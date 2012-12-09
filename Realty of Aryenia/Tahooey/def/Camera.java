package def;

public class Camera {
	
	public int xOffset,yOffset;
	public int dx,dy;
	public static int UP=1,DOWN=2,LEFT=3,RIGHT=4;
	
	public Camera(){
		
	}
	
	public void move(){
		for(int i=0;i<Engine.mb.ENTITIES.length;i++){
			if(Engine.mb.ENTITIES[i].isFollowedByCamera){
				xOffset=(Engine.mb.ENTITIES[i].finalx*-1)+500;
				yOffset=(Engine.mb.ENTITIES[i].finaly*-1)+300;				
			}
		}
	}

}
