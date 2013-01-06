package world;

import itm.*;

import java.io.IOException;

import mob.*;
import def.*;
import blcks.*;

public class MapBuilder {

	public Block[][][] BLOCKS;
	public Mob[] MOBS;
	public int[][][] ID;
	public int currentmap;

	int currentab = 0;

	public MapBuilder(int map) {
		map=Engine.mfo.pfh.ReadPlayerMap;
		currentmap = Engine.mfo.pfh.ReadPlayerMap;
		MOBS = new Mob[1];
		BLOCKS = new Block[Engine.mfo.WFH[map].ReadWorldLayers][Engine.mfo.WFH[map].ReadWorldH][Engine.mfo.WFH[map].ReadWorldW];
		ID = Engine.mfo.WFH[map].ReadBlockID;
		BuildMap();
	}

	public void ChangeMap(int toChange) {
		Engine.changingMaps = true;
		MOBS[0].map=toChange;
		currentab = 0;
		def.Frame.gp.blankScreen = true;
		currentmap = toChange;
		BLOCKS = new Block[Engine.mfo.WFH[currentmap].ReadWorldLayers][Engine.mfo.WFH[currentmap].ReadWorldH][Engine.mfo.WFH[currentmap].ReadWorldW];
		ID = Engine.mfo.WFH[currentmap].ReadBlockID;
		BuildBlocks();
		def.Frame.gp.blankScreen = false;
		Engine.changingMaps = false;
	}

	public void save() {
		try {
			Engine.mfo.WFH[currentmap].SaveWorld();
			Engine.mfo.pfh.save();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void BuildMap() {
		BuildBlocks();
		BuildMobs();
		currentab = 0;
	}

	public void BuildMobs() {
		for (int i = 0; i < MOBS.length; i++) {
			if (Engine.mfo.pfh.ReadPlayerType == 1) {
				MOBS[i] = new Sleeper(Engine.mfo.pfh.ReadPlayerX,
						Engine.mfo.pfh.ReadPlayerY,
						Engine.mfo.pfh.ReadPlayerName,
						Engine.mfo.pfh.ReadPlayerLayer);
			} else if (Engine.mfo.pfh.ReadPlayerType == 2) {
				MOBS[i] = new Wizard(Engine.mfo.pfh.ReadPlayerX,
						Engine.mfo.pfh.ReadPlayerY,
						Engine.mfo.pfh.ReadPlayerName,
						Engine.mfo.pfh.ReadPlayerLayer);
			}
			if (i == 0) {
				MOBS[i].isControlledByPlayer = true;
				MOBS[i].map=Engine.mfo.pfh.ReadPlayerMap;
				for(int h=0;h<MOBS[i].ITEMS.length;h++){
					for(int w=0;w<MOBS[i].ITEMS[h].length;w++){
						if(Engine.mfo.pfh.ITEMS[h][w]==0){
							MOBS[i].ITEMS[h][w]=new NoItem();
						}else if(Engine.mfo.pfh.ITEMS[h][w]==1){
							MOBS[i].ITEMS[h][w]=new Candle();
						} 
					}
				}
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
					} else if (ID[l][h][w] == 11) {
						if (currentab < Engine.mfo.WFH[currentmap].ReadActionBlocksMapToChangeTo.length) {
							BLOCKS[l][h][w] = new MapChanger(
									Engine.mfo.WFH[currentmap].ReadActionBlocksMapToChangeTo[currentab],
									Engine.mfo.WFH[currentmap].ReadActionBlocksPlayerX[currentab],
									Engine.mfo.WFH[currentmap].ReadActionBlocksPlayerY[currentab],
									Block.UP);
							currentab += 1;
						} else {
							BLOCKS[l][h][w] = new MapChanger(currentmap,0,0,
									Block.UP);
						}
					} else if (ID[l][h][w] == 12) {
						if (currentab < Engine.mfo.WFH[currentmap].ReadActionBlocksMapToChangeTo.length) {
							BLOCKS[l][h][w] = new MapChanger(
									Engine.mfo.WFH[currentmap].ReadActionBlocksMapToChangeTo[currentab],
									Engine.mfo.WFH[currentmap].ReadActionBlocksPlayerX[currentab],
									Engine.mfo.WFH[currentmap].ReadActionBlocksPlayerY[currentab],
									Block.DOWN);
							currentab += 1;
						} else {
							BLOCKS[l][h][w] = new MapChanger(currentmap,0,0,
									Block.DOWN);
						}
						currentab += 1;
					} else if (ID[l][h][w] == 13) {
						if (currentab < Engine.mfo.WFH[currentmap].ReadActionBlocksMapToChangeTo.length) {
							BLOCKS[l][h][w] = new MapChanger(
									Engine.mfo.WFH[currentmap].ReadActionBlocksMapToChangeTo[currentab],
									Engine.mfo.WFH[currentmap].ReadActionBlocksPlayerX[currentab],
									Engine.mfo.WFH[currentmap].ReadActionBlocksPlayerY[currentab],
									Block.RIGHT);
							currentab += 1;
						} else {
							BLOCKS[l][h][w] = new MapChanger(currentmap,0,0,
									Block.RIGHT);
						}
					} else if (ID[l][h][w] == 14) {
						if (currentab < Engine.mfo.WFH[currentmap].ReadActionBlocksMapToChangeTo.length) {
							BLOCKS[l][h][w] = new MapChanger(
									Engine.mfo.WFH[currentmap].ReadActionBlocksMapToChangeTo[currentab],
									Engine.mfo.WFH[currentmap].ReadActionBlocksPlayerX[currentab],
									Engine.mfo.WFH[currentmap].ReadActionBlocksPlayerY[currentab],
									Block.LEFT);
							currentab += 1;
						} else {
							BLOCKS[l][h][w] = new MapChanger(currentmap,0,0,
									Block.LEFT);
						}
					}
					BLOCKS[l][h][w].l = l + 1;
					BLOCKS[l][h][w].x = w * Block.w;
					BLOCKS[l][h][w].y = h * Block.h;
				}
			}
		}
		currentab = 0;
	}

}
