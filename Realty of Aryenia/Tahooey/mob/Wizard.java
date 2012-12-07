package mob;

import img.ImageHandler;

public class Wizard extends Entity {
	
	public Wizard(int xco,int yco){
		SHOOT_PARTICLE=ImageHandler.PlayerFire;
		canCollide=true;
		x=xco;
		y=yco;
		IMG_TO_DRAW=ImageHandler.Wizard;
		currentLayer=2;
	}

}
