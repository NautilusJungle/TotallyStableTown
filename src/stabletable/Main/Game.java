package stabletable.Main;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import stabletable.Main.Display.Display;
import stabletable.Main.gfx.ImageLoader;
import stabletable.Main.gfx.SpriteSheet;

public class Game implements Runnable {

	private Display display;
	public int width, height;
	public String title;
	
	private boolean running = false;
	
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	private BufferedImage testImage;
	private SpriteSheet charSheet;
	
	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
	}
	
	private void init() {
		display = new Display(title, width, height);
		testImage = ImageLoader.loadImage("/textures/char-sheet.png");
		charSheet = new SpriteSheet(testImage,128);
	}
	
	public void run() {
		init();
		
		while(running) {
			tick();
			render();
		}
		
		stop();
		
	}
	
	private void tick() {

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
		
		g.drawImage(charSheet.crop(1, 1), 5, 5, null);
		
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
