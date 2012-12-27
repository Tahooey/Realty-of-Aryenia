package world;

import mob.*;
import def.*;
import blcks.*;

public class MapBuilder {

	public Block[][][] BLOCKS;
	public Mob[] MOBS;
	public int[][][] ID;

	public MapBuilder() {
		MOBS = new Mob[1];
		BLOCKS = new Block[Engine.wfh.ReadWorldLayers][Engine.wfh.ReadWorldH][Engine.wfh.ReadWorldW];
		ID = Engine.wfh.ReadBlockID;
		BuildMap();
	}

	public void BuildMap() {
		BuildBlocks();
		BuildMobs();
	}

	public void BuildMobs() {
		for (int i = 0; i < MOBS.length; i++) {
			if (Engine.pfh.ReadPlayerType == 1) {
				MOBS[i] = new Sleeper(Engine.pfh.ReadPlayerX,
						Engine.pfh.ReadPlayerY, Engine.pfh.ReadPlayerName,
						Engine.pfh.ReadPlayerLayer);
			} else if (Engine.pfh.ReadPlayerType == 2) {
				MOBS[i] = new Wizard(Engine.pfh.ReadPlayerX,
						Engine.pfh.ReadPlayerY, Engine.pfh.ReadPlayerName,
						Engine.pfh.ReadPlayerLayer);
			}
			if (i == 0) {
				MOBS[i].isControlledByPlayer = true;
			}
		}
	}

	public void BuildBlocks() {
		for (int l = 0; l < BLOCKS.length; l++) {
			for (int h = 0; h < BLOCKS[l].length; h++) {
				for (int w = 0; w < BLOCKS[l][h].length; w++) {
					if (ID[l][h][w] == 0) {
						BLOCKS[l][h][w] = new Air();
					} else if (ID[l][h][w] == 1) {
						BLOCKS[l][h][w] = new Grass();
					} else if (ID[l][h][w] == 2) {
						BLOCKS[l][h][w] = new StoneBrick();
					} else if (ID[l][h][w] == 3) {
						BLOCKS[l][h][w] = new Bricks();
					} else if (ID[l][h][w] == 4) {
						BLOCKS[l][h][w] = new WoodStairs(l + 1, l + 2, Block.UP);
					} else if (ID[l][h][w] == 5) {
						BLOCKS[l][h][w] = new WoodStairs(l + 1, l + 2,
								Block.DOWN);
					} else if (ID[l][h][w] == 6) {
						BLOCKS[l][h][w] = new WoodStairs(l + 1, l + 2,
								Block.LEFT);
					} else if (ID[l][h][w] == 7) {
						BLOCKS[l][h][w] = new WoodStairs(l + 1, l + 2,
								Block.RIGHT);
					} else if (ID[l][h][w] == 8) {
						BLOCKS[l][h][w] = new MossyStoneBrick();
					} else if (ID[l][h][w] == 9) {
						BLOCKS[l][h][w] = new Wood();
					} else if (ID[l][h][w] == 10) {
						BLOCKS[l][h][w] = new Stone();
					}
					BLOCKS[l][h][w].l = l + 1;
					BLOCKS[l][h][w].x = w * Block.w;
					BLOCKS[l][h][w].y = h * Block.h;
				}
			}
		}
	}

}
