package stabletable.Main.entities.creatures;

import java.awt.Graphics;

import stabletable.Main.gfx.Assets;

public class Player extends Creature {

	public Player(float x, float y) {
		super(x, y);
	}

	@Override
	public void tick() {

	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.player, (int) x, (int) y, null);
	}

}