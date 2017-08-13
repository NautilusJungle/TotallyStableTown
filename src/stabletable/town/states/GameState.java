package stabletable.town.states;

import java.awt.Graphics;

import stabletable.town.Main.Handler;
import stabletable.town.entities.creatures.Player;
import stabletable.town.entities.statics.Tree;
import stabletable.town.worlds.World;

public class GameState extends State{

	private World world;
	
	public GameState(Handler handler) {
		super(handler);
		world = new World(handler, "res/worlds/world1.txt");
		handler.setWorld(world);
	}
	
	@Override
	public void tick() {
		world.tick();
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
	}

}
