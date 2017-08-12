package stabletable.Main.states;

import java.awt.Graphics;

import stabletable.Main.Game;
import stabletable.Main.entities.creatures.Player;
import stabletable.Main.worlds.World;

public class GameState extends State{

	private Player player;
	private World world;
	
	public GameState(Game game) {
		super(game);
		player = new Player(game, 100,100);
		world = new World("res/worlds/world1.txt");
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
