package world;

import java.awt.*;

import def.Engine;

public class WorldRunner {
	
	public WorldRunner(){
		
	}
	
	public void RunWorld(Graphics g){
		RunBlocks(g);
		RunMobs(g);
	}
	
	public void RunMobs(Graphics g){
		for(int i=0;i<Engine.mb.MOBS.length;i++){
			Engine.mb.MOBS[i].runMob(g);
		}
	}
	
	public void RunBlocks(Graphics g){
		for(int l=0;l<Engine.mb.BLOCKS.length;l++){
			for(int h=0;h<Engine.mb.BLOCKS[l].length;h++){
				for(int w=0;w<Engine.mb.BLOCKS[l][h].length;w++){
					Engine.mb.BLOCKS[l][h][w].RunBlock(g);
				}
			}
		}
	}

}
