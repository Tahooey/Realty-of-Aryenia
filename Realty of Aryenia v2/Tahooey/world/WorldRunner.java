package world;

import java.awt.*;

import def.Engine;

public class WorldRunner {

	public WorldRunner() {

	}

	public void RunWorld(Graphics g) {
		RunBlocksImg(g);
		RunMobsImg(g);
	}

	public void RunMobsImg(Graphics g) {
		for (int i = 0; i < Engine.mb.MOBS.length; i++) {
			Engine.mb.MOBS[i].drawMob(g);
		}
	}

	public void RunBlocksImg(Graphics g) {
		for (int l = 0; l < Engine.mb.BLOCKS.length; l++) {
			for (int h = 0; h < Engine.mb.BLOCKS[l].length; h++) {
				for (int w = 0; w < Engine.mb.BLOCKS[l][h].length; w++) {
					Engine.mb.BLOCKS[l][h][w].drawBlock(g);
				}
			}
		}
	}

	public void Update() {
		RunMobs();
		RunBlocks();
	}

	public void RunMobs() {
		for (int i = 0; i < Engine.mb.MOBS.length; i++) {
			Engine.mb.MOBS[i].runMob();
		}
	}

	public void RunBlocks() {
		for (int l = 0; l < Engine.mb.BLOCKS.length; l++) {
			for (int h = 0; h < Engine.mb.BLOCKS[l].length; h++) {
				for (int w = 0; w < Engine.mb.BLOCKS[l][h].length; w++) {
					Engine.mb.BLOCKS[l][h][w].RunBlock();
				}
			}
		}
		if(Engine.canUpdateMap){
			Engine.updateMap();
		}
	}

}
