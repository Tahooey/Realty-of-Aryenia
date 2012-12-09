package def;

import java.awt.*;
import java.awt.event.*;

import blck.*;

public class Mouse {
	public static int blockToChange=1;
	public static  int x=0,y=0;
	public static boolean hasClicked=false,hasReleased=true;
	public static Rectangle r = new Rectangle();
	public static int curlayer=1;
	
	public static void runMouse(Graphics g){
		setRect();
		if(Engine.inEditMode){
			isIntersectingBlock();
			g.setColor(Color.white);
			g.fillRect(r.x,r.y,r.width,r.height);
			g.drawString(x+" "+y, 30, 40);
			g.drawString(hasClicked+"", 30, 50);
			g.drawString(hasReleased+"", 30, 60);			
		}
	}
	
	public static void setRect(){
		r.setSize(1,1);
		r.setLocation(x, y);
	}
	
	public static void KeyPressed(KeyEvent e){
		int KeyCode=e.getKeyCode();
		if(Engine.inEditMode){
			if(KeyCode==KeyEvent.VK_1){
				if(blockToChange>=1){
					blockToChange--;
				}else{
					blockToChange=3;
				}
			}
			if(KeyCode==KeyEvent.VK_2){
				if(blockToChange<=3){
					blockToChange++;;
				}else{
					blockToChange=1;
				}
			}			
		}
	}
	
	public static void isIntersectingBlock(){		
		for(int i=0;i<Engine.mb.HigherBLOCKS.length;i++){
			for(int j=0;j<Engine.mb.HigherBLOCKS[i].length;j++){
				if(curlayer==2){
					Engine.mb.LowerBLOCKS[i][j].isIntersectedByMouse=false;
					if(r.intersects(Engine.mb.HigherBLOCKS[i][j].t.r)){
						Engine.mb.HigherBLOCKS[i][j].isIntersectedByMouse=true;
						if(hasClicked){
							if(blockToChange==1){
								Engine.mb.HigherBLOCKS[i][j]=new Air();
							}else if(blockToChange==2){
								Engine.mb.HigherBLOCKS[i][j]=new Grass();
							}else if(blockToChange==3){
								Engine.mb.HigherBLOCKS[i][j]=new StoneTile();
							}else{
								Engine.mb.HigherBLOCKS[i][j]=new Air();
							}
						}
					}else{
						Engine.mb.HigherBLOCKS[i][j].isIntersectedByMouse=false;
					}
				}else if(curlayer==1){
					Engine.mb.HigherBLOCKS[i][j].isIntersectedByMouse=false;
					if(r.intersects(Engine.mb.LowerBLOCKS[i][j].t.r)){
						Engine.mb.LowerBLOCKS[i][j].isIntersectedByMouse=true;
						if(hasClicked){
							if(blockToChange==1){
								Engine.mb.LowerBLOCKS[i][j]=new Air();
							}else if(blockToChange==2){
								Engine.mb.LowerBLOCKS[i][j]=new Grass();
							}else if(blockToChange==3){
								Engine.mb.LowerBLOCKS[i][j]=new StoneTile();
							}else{
								Engine.mb.LowerBLOCKS[i][j]=new Air();
							}
						}
					}else{
						Engine.mb.LowerBLOCKS[i][j].isIntersectedByMouse=false;
					}
				}else{
			System.out.println("An Error has Occured");
				}
			}
		}
				
	}

}
