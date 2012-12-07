package mob;

import img.ImageHandler;

public class Player extends Entity{
	
	public Player(int xco,int yco){
		SHOOT_PARTICLE=ImageHandler.PlayerFire;
		canCollide=true;
		x=xco;
		y=yco;
		IMG_TO_DRAW=ImageHandler.Player;
		currentLayer=2;
	}

}
