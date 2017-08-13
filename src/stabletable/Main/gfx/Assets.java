package stabletable.Main.gfx;

import java.awt.image.BufferedImage;
import stabletable.Main.gfx.SpriteSheet;

public class Assets {

	public static final int width = 128, height = 128;
	
	public static BufferedImage[] player_down, player_up, player_left, player_right;
	public static BufferedImage  player,dirt, grass, brickWall;
	
	public static SpriteSheet charSheet = new SpriteSheet(ImageLoader.loadImage("/textures/char-sheet.png"));
	public static SpriteSheet terrainSheet = new SpriteSheet(ImageLoader.loadImage("/textures/terrain-sheet.png"));
	
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
	
	}
	
	private static BufferedImage[] addAnimation(BufferedImage[] entity, int xStart, int yStart) {
		for(int i = 0; i < entity.length; i++) {
			entity[i] = charSheet.crop(width*(xStart+i),height*yStart,width,height);
		}
		return entity;
	}
}
