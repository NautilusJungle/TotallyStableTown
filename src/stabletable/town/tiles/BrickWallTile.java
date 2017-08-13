package stabletable.town.tiles;

import stabletable.town.gfx.Assets;

public class BrickWallTile extends Tile {

	public BrickWallTile(int id) {
		super(Assets.brickWall, id);
	}

	@Override
	public boolean isSolid() {
		return true;
	}
	
}
