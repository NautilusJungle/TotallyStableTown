package stabletable.Main;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import stabletable.Main.Display.Display;
import stabletable.Main.gfx.Assets;

public class Game implements Runnable {

	private Display display;
	public int width, height;
	public String title;
	
	private boolean running = false;
	
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
		
	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
	}
	
	private void init() {
		display = new Display(title, width, height);
		Assets.init();
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
	
	int x = 0;
	
	private void tick() {
		x += 1;
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
		
		g.drawImage(Assets.player, x, 0, null);
		
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
