package stabletable.Main.tiles;

import stabletable.Main.gfx.Assets;

public class BrickWallTile extends Tile {

	public BrickWallTile(int id) {
		super(Assets.brickWall, id);
	}

	@Override
	public boolean isSolid() {
		return true;
	}
	
}
