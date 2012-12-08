package def;

public class Camera {
	
	public int xOffset,yOffset;
	public int dx,dy;
	public static int UP=1,DOWN=2,LEFT=3,RIGHT=4;
	
	public Camera(){
		
	}
	
	public void move(){
		for(int i=0;i<Engine.mb.ENTITIES.length;i++){
			if(Engine.mb.ENTITIES[0].isFollowedByCamera){
				xOffset=(Engine.mb.ENTITIES[0].xoffset*-1)+400;
				yOffset=(Engine.mb.ENTITIES[0].yoffset*-1)+200;				
			}
		}
	}

}
