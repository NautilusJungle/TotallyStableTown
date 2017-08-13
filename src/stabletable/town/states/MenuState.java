package stabletable.town.states;

import java.awt.Graphics;

import stabletable.town.Main.Handler;
import stabletable.town.gfx.Assets;
import stabletable.town.ui.ClickListener;
import stabletable.town.ui.UIImageButton;
import stabletable.town.ui.UIManager;

public class MenuState extends State{

	private UIManager uiManager;
	
	public MenuState(Handler handler) {
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		
		uiManager.addOjbect(new UIImageButton(200,200,128,64,Assets.BtnStart, new ClickListener(){

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
