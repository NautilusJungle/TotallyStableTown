package stabletable.town.gfx;

import java.awt.image.BufferedImage;

import stabletable.town.gfx.SpriteSheet;

public class Assets {

	public static final int width = 128, height = 128;
	
	public static BufferedImage[] player_down, player_up, player_left, player_right;
	public static BufferedImage  player,dirt, grass, brickWall;
	public static BufferedImage tree;
	public static BufferedImage[] BtnStart;
	
	public static SpriteSheet charSheet = new SpriteSheet(ImageLoader.loadImage("/textures/char-sheet.png"));
	public static SpriteSheet terrainSheet = new SpriteSheet(ImageLoader.loadImage("/textures/terrain-sheet.png"));
	public static SpriteSheet statentSheet = new SpriteSheet(ImageLoader.loadImage("/textures/statent-sheet.png"));
	public static SpriteSheet uiSheet = new SpriteSheet(ImageLoader.loadImage("/textures/ui-sheet.png"));
	
	public static void init() {
		
		// Player
		player = charSheet.crop(0, 0, width, height);
		player_down = new BufferedImage[4];
		player_down = addAnimation(player_down,1,0);
		player_up = new BufferedImage[4];
		player_up = addAnimation(player_up,6,0);
		player_left = new BufferedImage[4];
		player_left = addAnimation(player_left,11,0);
		player_right = new BufferedImage[4];
		player_right = addAnimation(player_right,16,0);

		// Terrain
		dirt = terrainSheet.crop(0, 0, width, height);
		grass = terrainSheet.crop(width, 0, width, height);
		brickWall = terrainSheet.crop(width*2, 0, width, height);
		
		// Static Entities
		tree = statentSheet.crop(0, 0, width, height);
	
		// UI
		BtnStart = new BufferedImage[2];
		BtnStart[0] = uiSheet.crop(0,0, width*2, height);
		BtnStart[1] = uiSheet.crop(width*2, 0, width*2, height);
		
	}
	
	private static BufferedImage[] addAnimation(BufferedImage[] entity, int xStart, int yStart) {
		for(int i = 0; i < entity.length; i++) {
			entity[i] = charSheet.crop(width*(xStart+i),height*yStart,width,height);
		}
		return entity;
	}
}
