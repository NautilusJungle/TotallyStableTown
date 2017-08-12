package stabletable.Main;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import stabletable.Main.Display.Display;
import stabletable.Main.gfx.Assets;
import stabletable.Main.input.KeyManager;
import stabletable.Main.states.GameState;
import stabletable.Main.states.MenuState;
import stabletable.Main.states.State;

public class Game implements Runnable {

	private Display display;
	public int width, height;
	public String title;
	
	private boolean running = false;
	
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	// States
	private State gameState;
	private State menuState;
	
	// Input
	private KeyManager keyManager;
	
	public KeyManager getKeyManager() {
		return keyManager;
	}

	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
	}
	
	private void init() {
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		Assets.init();
		
		gameState = new GameState(this);
		menuState = new MenuState(this);
		State.setState(gameState);
	}
	
	public void run() {
		init();
		
		int fps = 60;
		double timePerTick = 1000000000/fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		
		while(running) {
			now = System.nanoTime();
			delta += (now - lastTime)/timePerTick;
			lastTime = now;
			
			if(delta >= 1) {
				tick();
				render();
				delta--;
			}
		}
		
		stop();
		
	}
	
	
	private void tick() {
		keyManager.tick();
		
		if(State.getState() != null)
			State.getState().tick();
	}
	
	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		// Clear screen
		g.clearRect(0, 0, width, height);
		// Draw here
		if(State.getState() != null)
			State.getState().render(g);
		// End Draw here
		bs.show();
		g.dispose();
	}

	public synchronized void start() {
		
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop() {
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
