package stabletable.town.states;

import java.awt.Graphics;

import stabletable.town.Main.Handler;
import stabletable.town.entities.creatures.Player;
import stabletable.town.worlds.World;

public class GameState extends State{

	private Player player;
	private World world;
	
	public GameState(Handler handler) {
		super(handler);
		world = new World(handler, "res/worlds/world1.txt");
		handler.setWorld(world);
		player = new Player(handler, 100,100);
	}
	
	@Override
	public void tick() {
		world.tick();
		player.tick();
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
		player.render(g);
	}

}
