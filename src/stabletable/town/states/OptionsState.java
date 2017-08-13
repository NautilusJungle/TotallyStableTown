package stabletable.town.states;

import java.awt.Graphics;

import stabletable.town.Main.Handler;
import stabletable.town.entities.creatures.Player;
import stabletable.town.entities.statics.Tree;
import stabletable.town.gfx.Assets;
import stabletable.town.ui.ClickListener;
import stabletable.town.ui.UIImageButton;
import stabletable.town.ui.UIManager;
import stabletable.town.worlds.World;

public class OptionsState extends State{

	private UIManager uiManager;
	
	public OptionsState(Handler handler) {
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		
		uiManager.addOjbect(new UIImageButton((handler.getGame().getWidth()/2)-(256/2),handler.getGame().getHeight()-300,256,64,Assets.BtnStart, new ClickListener(){

			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().gameState);
			}}));
	}
	
	@Override
	public void tick() {
		uiManager.tick();
	}

	@Override
	public void render(Graphics g) {
		uiManager.render(g);
	}

}
