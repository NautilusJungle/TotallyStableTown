package stabletable.Main.gfx;

import java.awt.image.BufferedImage;
import stabletable.Main.gfx.SpriteSheet;

public class Assets {

	public static final int width = 128, height = 128;
	
	public static BufferedImage player;
	public static BufferedImage  dirt, grass, brickWall;
	
	public static void init() {
		SpriteSheet charSheet = new SpriteSheet(ImageLoader.loadImage("/textures/char-sheet.png"));
		SpriteSheet terrainSheet = new SpriteSheet(ImageLoader.loadImage("/textures/terrain-sheet.png"));
		
		player = charSheet.crop(0, 0, width, height);
		dirt = terrainSheet.crop(0, 0, width, height);
		grass = terrainSheet.crop(width, 0, width, height);
		brickWall = terrainSheet.crop(width*2, 0, width, height);
	
	}
	
}
