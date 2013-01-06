package itm;

import java.awt.*;

public class Item {

	public boolean shoots = false, unlocks = false, heals = false,
			hurts = false;
	public Image item;
	
	public int ID;
	
	public boolean isSelected=false;

	public Item() {
		
	}
	
	public void doAction(){
		if(unlocks){
			unLock();
		}
		if(shoots){
			Shoot();
		}
		if(heals){
			heal();
		}
		if(hurts){
			hurt();
		}
	}

	public void unLock() {

	}
	
	public void Shoot(){
		
	}
	
	public void heal(){
		
	}
	
	public void hurt(){
		
	}

}
