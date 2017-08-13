package stabletable.town.states;

import java.awt.Graphics;

import stabletable.town.Main.Handler;

public class MenuState extends State{

	public MenuState(Handler handler) {
		super(handler);
	}
	
	@Override
	public void tick() {
		if(handler.getMouseManager().isLeftPressed() && handler.getMouseManager().isRightPressed())
			State.setState(handler.getGame().gameState);
	}

	@Override
	public void render(Graphics g) {
		
	}

}
