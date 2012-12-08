package mob;

import img.ImageHandler;

public class Player extends Entity{
	
	public Player(int xco,int yco,int layer){
		mobName="Player";
		SHOOT_PARTICLE=ImageHandler.PlayerFire;
		canCollide=true;
		x=xco;
		y=yco;
		IMG_TO_DRAW=ImageHandler.Player;
		currentLayer=layer;
	}

}
