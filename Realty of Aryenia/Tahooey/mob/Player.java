package mob;

import img.ImageHandler;

public class Player extends Entity{
	
	public Player(){
		isFollowedByCamera=true;
		canCollide=true;
		x=8;
		y=8;
		IMG_TO_DRAW=ImageHandler.Player;
		currentLayer=2;
	}

}
