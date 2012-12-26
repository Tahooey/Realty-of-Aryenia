package def;

import java.awt.Rectangle;

public class Mouse {
	
	static int blockToChangeTo=0;
	static int maxBlock=10;
	
	static int layer;
	static Rectangle r;
	static int X,Y;
	static boolean isPressed=false;
	
	public static void Init(){
		r=new Rectangle();
		r.setSize(1,1);
	}
	
	public static void Update(){
		r.setLocation(X,Y);
		//if(!intrfce.Menu.runMenu){
		layer=Engine.mb.MOBS[0].Layer;
		ChangeTile();
		//}
		comButtons();
	}
	
	public static void comButtons(){
		for(int i=0;i<intrfce.Menu.BUTTONS.length;i++){
			if(r.intersects(intrfce.Menu.BUTTONS[i].r)){
				if(isPressed){
					intrfce.Menu.BUTTONS[i].isClicked=true;
					intrfce.Menu.BUTTONS[i].isHoveredOver=false;
				}else{
					intrfce.Menu.BUTTONS[i].isClicked=false;
					intrfce.Menu.BUTTONS[i].isHoveredOver=true;
				}
			}else{
				intrfce.Menu.BUTTONS[i].isClicked=false;
				intrfce.Menu.BUTTONS[i].isHoveredOver=false;
			}
		}
		for(int i=0;i<intrfce.Menu.TEXTBOXES.length;i++){
			if(r.intersects(intrfce.Menu.TEXTBOXES[i].b.r)){
				if(isPressed){
					intrfce.Menu.TEXTBOXES[i].b.isClicked=true;
					intrfce.Menu.TEXTBOXES[i].b.isHoveredOver=false;
				}else{
					intrfce.Menu.TEXTBOXES[i].b.isClicked=false;
					intrfce.Menu.TEXTBOXES[i].b.isHoveredOver=true;
				}
			}else{
				intrfce.Menu.TEXTBOXES[i].b.isClicked=false;
				intrfce.Menu.TEXTBOXES[i].b.isHoveredOver=false;
			}
		}
	}
	
	public static void HighLightTile(){
		for(int h=0;h<Engine.mb.BLOCKS[layer].length;h++){
			for(int w=0;w<Engine.mb.BLOCKS[layer][h].length;w++){
				if(r.intersects(Engine.mb.BLOCKS[layer][h][w].r)){
					Engine.mb.BLOCKS[layer][h][w].isIntersectedByMouse=true;
				}else{
					Engine.mb.BLOCKS[layer][h][w].isIntersectedByMouse=false;
				}
			}
		}
	}
	
	public static void ChangeTile(){
		for(int h=0;h<Engine.mb.BLOCKS[layer-1].length;h++){
			for(int w=0;w<Engine.mb.BLOCKS[layer-1][h].length;w++){
				if(r.intersects(Engine.mb.BLOCKS[layer-1][h][w].r)){
					if(isPressed){
							Engine.mb.ID[layer-1][h][w]=blockToChangeTo;
					}
				}
			}
		}
		Engine.mb.BuildBlocks();
	}
	
	public static void setXY(int xco,int yco){
		X=xco;
		Y=yco;
	}

}
