package blcks;

public class WoodStairs extends Block {
	
	public WoodStairs(int low,int high,int dir){
		ChangesLayer=true;
		isCollidable=false;
		LowerLayer=low;
		HigherLayer=high;
		
		name="Wood Stairs";
		
		if(dir==UP){
			name=name+": UP";
			ID=4;
			imgx=24;
			imgy=0;
			imgx2=32;
			imgy2=8;
		}else if(dir==DOWN){
			name=name+": DOWN";
			ID=5;
			imgx=32;
			imgy=0;
			imgx2=40;
			imgy2=8;
		}else if(dir==LEFT){
			name=name+": LEFT";
			ID=6;
			imgx=48;
			imgy=0;
			imgx2=56;
			imgy2=8;
		}else if(dir==RIGHT){
			name=name+": RIGHT";
			ID=7;
			imgx=40;
			imgy=0;
			imgx2=48;
			imgy2=8;
		}
		setSteps(dir);
	}

}
