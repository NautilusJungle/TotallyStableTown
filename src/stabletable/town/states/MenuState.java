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
		
		// Games
		uiManager.addOjbect(new UIImageButton((handler.getGame().getWidth()/2)-(256/2),handler.getGame().getHeight()-300,256,64,Assets.BtnStart, new ClickListener(){

			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().gameState);
			}}));
		
		// Options
		uiManager.addOjbect(new UIImageButton((handler.getGame().getWidth()/2)-(256/2),handler.getGame().getHeight()-200,256,64,Assets.BtnStart, new ClickListener(){

			@Override
			public void onClick() {
				State.setState(handler.getGame().optionsState);
			}}));
		
		// Exit
		uiManager.addOjbect(new UIImageButton((handler.getGame().getWidth()/2)-(256/2),handler.getGame().getHeight()-100,256,64,Assets.BtnStart, new ClickListener(){

			@Override
			public void onClick() {
				handler.getGame().getDisplay().getFrame().dispose();
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
