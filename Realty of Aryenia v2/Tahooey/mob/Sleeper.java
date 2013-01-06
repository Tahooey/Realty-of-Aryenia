package mob;

import itm.Candle;
import fil.ImageFileHandler;

public class Sleeper extends Mob {
	
	public Sleeper(int xco,int yco,String name,int layer){
		Layer=layer;
		x=xco;
		y=yco;
		ID=1;
		Name=name;
		inv.PType="Sleeper";
		inv.PName=Name;
		IMG_TO_DRAW=ImageFileHandler.Sleeper;
		inv.PImage=IMG_TO_DRAW;
		workFirstInts();
		loadEmptyInventory();
		loadDefaultInv();
	}
	
	public void loadDefaultInv(){
		ITEMS[inv.ItemH-1][0]=new Candle();
	}

}
