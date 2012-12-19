package blcks;

public class WoodStairs extends Block {
	
	public WoodStairs(int low,int high,int dir){
		ChangesLayer=true;
		isCollidable=false;
		LowerLayer=low;
		HigherLayer=high;
		if(dir==UP){
			ID=4;
			imgx=24;
			imgy=0;
			imgx2=32;
			imgy2=8;
		}else if(dir==DOWN){
			ID=5;
			imgx=32;
			imgy=0;
			imgx2=40;
			imgy2=8;
		}else if(dir==LEFT){
			ID=6;
			imgx=48;
			imgy=0;
			imgx2=56;
			imgy2=8;
		}else if(dir==RIGHT){
			ID=7;
			imgx=40;
			imgy=0;
			imgx2=48;
			imgy2=8;
		}
		setSteps(dir);
	}

}
