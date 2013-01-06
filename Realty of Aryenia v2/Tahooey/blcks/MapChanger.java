package blcks;

public class MapChanger extends Block {
	
	public MapChanger(int MapToChangeTo,int playerX,int playerY,int direction){
		ChangesMap=true;
		isInvisible=true;
		mapToChangeTo=MapToChangeTo;
		isCollidable=false;
		directionOfChange=direction;
		name="Map Changer";
		if(direction==UP){
			name=name+": UP";
			ID=11;
			imgx=96;
			imgy=0;
			imgx2=104;
			imgy2=8;
		}else if(direction==DOWN){
			name=name+": DOWN";
			ID=12;
			imgx=104;
			imgy=0;
			imgx2=112;
			imgy2=8;
		}else if(direction==RIGHT){
			name=name+": RIGHT";
			ID=13;
			imgx=80;
			imgy=0;
			imgx2=88;
			imgy2=8;
		}else if(direction==LEFT){
			name=name+": LEFT";
			ID=14;
			imgx=88;
			imgy=0;
			imgx2=96;
			imgy2=8;
		}
		
		mapChangerX=playerX;
		mapChangerY=playerY;
		
		setMapChanger();
		
	}

}
