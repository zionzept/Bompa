package sys;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import static org.lwjgl.opengl.GL11.*;

public class GLMain {
	private static final int WIDTH = 640;
	private static final int HEIGHT = WIDTH / 16 * 9;
	private static final int FPS = 120;
	private static Game game;
	
	public static void main(String[] args) {
		try {
			initDisplay();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		initOpenGL();
		initGame();
		looper();
	}
	
	private static void initDisplay() throws LWJGLException {
		if (!Display.isCreated()) {
			Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
			Display.create();
		}
	}
	
	private static void initOpenGL() {
		glOrtho(0, Display.getWidth(), Display.getHeight(), 0, -1, 1);
	}
	
	private static void initGame() {
		game = new Game();
	}
	
	private static void looper() {
		lastT = System.nanoTime();
		while(!Display.isCloseRequested()) {
			glClear(GL_COLOR_BUFFER_BIT);
			loop();
			
			Display.update();
			Display.sync(FPS);
		}
	}
	
	private static void loop() {
		double dt = deltaTime();
		game.update(dt);
		game.render();
	}
	
	private static long lastT;
	private static double deltaTime() {
		long t = System.nanoTime();
		double dt = (t - lastT) / 1E9;
		lastT = t;
		return dt;
	}
}
