package stabletable.Main.gfx;

import java.awt.image.BufferedImage;

public class SpriteSheet {

	private BufferedImage sheet;
	private int DIM;
	
	
	public SpriteSheet(BufferedImage sheet, int DIM) {
		this.sheet = sheet;
		this.DIM = DIM;
	}
	
	public BufferedImage crop(int x, int y) {
		return sheet.getSubimage((x - 1)*DIM, (y - 1)*DIM, DIM, DIM);
	}
	
}
