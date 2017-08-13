package stabletable.town.gfx;

import java.awt.image.BufferedImage;

import stabletable.town.gfx.SpriteSheet;

public class Assets {

	public static final int width = 16, height = 16;
	
	public static BufferedImage[] player_down, player_up, player_left, player_right;
	public static BufferedImage dirt, grass, brickWall, black;
	public static BufferedImage tree;
	public static BufferedImage[] BtnStart;
	
	public static SpriteSheet charSheet = new SpriteSheet(ImageLoader.loadImage("/textures/char-sheet.png"));
	public static SpriteSheet terrainSheet = new SpriteSheet(ImageLoader.loadImage("/textures/terrain-sheet.png"));
	public static SpriteSheet statentSheet = new SpriteSheet(ImageLoader.loadImage("/textures/statent-sheet.png"));
	public static SpriteSheet uiSheet = new SpriteSheet(ImageLoader.loadImage("/textures/ui-sheet.png"));
	
	public static void init() {
		
		// Player
		player_down = new BufferedImage[4];
		player_down = addAnimationCreature(player_down,0,0);
		player_up = new BufferedImage[4];
		player_up = addAnimationCreature(player_up,4,0);
		player_left = new BufferedImage[4];
		player_left = addAnimationCreature(player_left,8,0);
		player_right = new BufferedImage[4];
		player_right = addAnimationCreature(player_right,12,0);

		// Terrain
		dirt = terrainSheet.crop(width, height, width, height);
		grass = terrainSheet.crop(width*4, height, width, height);
		black = terrainSheet.crop(width*7, height, width, height);
		brickWall = terrainSheet.crop(width*2, 0, width, height);
		
		// Static Entities
		tree = statentSheet.crop(0, 0, width, height);
	
		// UI
		BtnStart = new BufferedImage[2];
		BtnStart[0] = uiSheet.crop(0,0, width*8, height*4);
		BtnStart[1] = uiSheet.crop(0, height*4, width*8, height*4);
		
	}
	
	private static BufferedImage[] addAnimationCreature(BufferedImage[] entity, int xStart, int yStart) {
		for(int i = 0; i < entity.length; i++) {
			entity[i] = charSheet.crop(width*(xStart+i),height*yStart,width,height*2);
		}
		return entity;
	}

}
