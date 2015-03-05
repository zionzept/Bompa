package sys;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import static org.lwjgl.opengl.GL11.*;

public class GLMain {
	
	public static boolean running = true;
	
	private static final int WIDTH = 640;
	private static final int HEIGHT = WIDTH / 16 * 9;
	
	private static Game game;
	
	public static void main(String[] args) {
		try {
			initDisplay();
			initOpenGL();
			initGame();
		} catch (LWJGLException e) {
			e.printStackTrace();
			destroy();
		}
		looper();
	}
	
	private static void initDisplay() throws LWJGLException {
		if (!Display.isCreated()) {
			System.setProperty("org.lwjgl.opengl.Window.undecorated", "false");
			Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
			Display.setVSyncEnabled(true);
			Display.create();
		}
	}
	
	private static void initOpenGL() {
		glOrtho(0, Display.getWidth(), 0, Display.getHeight(), -1, 1);
	}
	
	private static void initGame() throws LWJGLException {
		org.lwjgl.input.Mouse.create();
		Keyboard.create();
		game = new Game();
	}
	
	private static void looper() {
		lastT = System.nanoTime();
		while(running) {
			glClear(GL_COLOR_BUFFER_BIT);
			loop();
			Display.update();
			if (Display.isCloseRequested()) {
				running = false;
			}
		}
		destroy();
	}
	
	private static void destroy() {
		org.lwjgl.input.Mouse.destroy();
		Keyboard.destroy();
		Display.destroy();
		System.exit(0);
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
