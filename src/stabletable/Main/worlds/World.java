package stabletable.Main.worlds;

import java.awt.Graphics;

import stabletable.Main.Game;
import stabletable.Main.tiles.Tile;
import stabletable.Main.utils.Utils;

public class World {

	private int width, height, spawnX, spawnY;
	private int[][] tiles;
	private Game game;
	
	public World(Game game, String path) {
		this.game = game;
		loadWorld(path);
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		for(int y = 0;y < height;y++) {
			for(int x = 0;x < width;x++) {
				getTile(x,y).render(g, (int) (x*Tile.TILEWIDTH - game.getGameCamera().getxOffset()), (int) (y*Tile.TILEHEIGHT - game.getGameCamera().getyOffset()));
			}
		}
	}
	
	public Tile getTile(int x, int y) {
		Tile t = Tile.tiles[tiles[x][y]];
		if(t == null)
			return Tile.dirtTile;
		return t;
	}
	
	private void loadWorld(String path) {
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		tiles = new int[width][height];
		for(int y = 0;y<height;y++) {
			for(int x=0;x<width;x++) {
				tiles[x][y] = Utils.parseInt(tokens[(x+y*width)+4]);
			}
		}
	}
	
}
