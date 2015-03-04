package sys;

import java.util.LinkedList;

public class Game {
	private LinkedList<Square> gameObjects;
	
	public Game() {
		gameObjects = new LinkedList<>();
		gameObjects.add(new Square(200, 200, 100));
		gameObjects.getFirst().setRotationSpeed(1);
		Square sq = new Square(590, 50, 60);
		sq.setRotationSpeed(2.4);
		gameObjects.add(sq);
	}
	
	public void update(double dt) {
		for (Square sq : gameObjects) {
			sq.update(dt);
		}
	}
	
	public void render() {
		for (Square sq : gameObjects) {
			sq.render();
		}
	}
	
}
