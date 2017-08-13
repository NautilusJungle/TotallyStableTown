package stabletable.town.entities.statics;

import java.awt.Graphics;

import stabletable.town.Main.Handler;
import stabletable.town.gfx.Assets;
import stabletable.town.tiles.Tile;

public class Tree extends StaticEntity {

	public Tree(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH*2, Tile.TILEHEIGHT*4);
		System.out.println(this.height);
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.tree, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	}

}
