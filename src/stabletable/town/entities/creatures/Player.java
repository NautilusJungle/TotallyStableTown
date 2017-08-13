package stabletable.town.entities.creatures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import stabletable.town.Main.Handler;
import stabletable.town.gfx.Animation;
import stabletable.town.gfx.Assets;

public class Player extends Creature {

	private Handler handler;
	
	// Animations
	
	private Animation animDown, animUp, animLeft, animRight;
		
	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, DEFAULT_CREATURE_HEIGHT);
		this.handler = handler;
		bounds.x = 16;
		bounds.y = 96;
		bounds.width=32;
		bounds.height=32;
		
		// Animations
		
		animDown = new Animation(200, Assets.player_down);
		animUp = new Animation(200, Assets.player_up);
		animLeft = new Animation(200, Assets.player_left);
		animRight = new Animation(200, Assets.player_right);
	}

	@Override
	public void tick() {
		// Animations
		animDown.tick();
		animUp.tick();
		animLeft.tick();
		animRight.tick();
		
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
	}

	private void getInput() {
		xMove = 0;
		yMove = 0;
		
		if(handler.getKeyManager().up)
			yMove = -speed;
		if(handler.getKeyManager().down)
			yMove = speed;
		if(handler.getKeyManager().left)
			xMove = -speed;
		if(handler.getKeyManager().right)
			xMove = speed;
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);

//		SHOW PLAYER'S HITBOX
//		g.setColor(Color.RED);
//		g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
//				(int) (y + bounds.y - handler.getGameCamera().getyOffset()),
//				bounds.width, bounds.height);
	}

	private BufferedImage getCurrentAnimationFrame() {
		if (xMove < 0)
		{
			return animLeft.getCurrentFrame();
		}
		else if (xMove > 0)
		{
			return animRight.getCurrentFrame();
		}
		else if (yMove < 0)
		{
			return animUp.getCurrentFrame();
		}
		else if (yMove > 0)
		{
			return animDown.getCurrentFrame();
		}
		else
			return animDown.getFirstFrame();
	}
	
}
