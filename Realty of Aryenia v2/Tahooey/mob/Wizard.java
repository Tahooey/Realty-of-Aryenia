package mob;

import fil.*;

public class Wizard extends Mob{
	
	public Wizard(int xco,int yco,String name,int layer){
		Layer=layer;
		x=xco;
		y=yco;
		ID=1;
		Name=name;
		inv.PType="Wizard";
		inv.PName=Name;
		IMG_TO_DRAW=ImageFileHandler.Wizard;
		inv.PImage=IMG_TO_DRAW;
		workFirstInts();
		loadEmptyInventory();
	}

}
