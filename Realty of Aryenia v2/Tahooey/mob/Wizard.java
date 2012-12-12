package mob;

import fil.ImageFileHandler;

public class Wizard extends Mob{
	
	public Wizard(int xco,int yco,String name,int layer){
		Layer=layer;
		x=xco;
		y=yco;
		ID=1;
		Name=name;
		IMG_TO_DRAW=ImageFileHandler.Wizard;
		workFirstInts();
	}

}
