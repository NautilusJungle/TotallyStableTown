package stabletable.Main.entities.creatures;

import java.awt.Graphics;

import stabletable.Main.Game;
import stabletable.Main.gfx.Assets;
import stabletable.Main.input.KeyManager;

public class Player extends Creature {

	private Game game;
	
	public Player(Game game, float x, float y) {
		super(x, y, Creature.DEFAULT_CREATURE_WIDTH, DEFAULT_CREATURE_HEIGHT);
		this.game = game;
	}

	@Override
	public void tick() {
		KeyManager k = game.getKeyManager();
		if(k.up)
			y-= 3;
		if(k.down)
			y+= 3;
		if(k.left)
			x-= 3;
		if(k.right)
			x+= 3;
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.player, (int) x, (int) y, null);
	}

}
