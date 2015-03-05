package sys;

import java.util.LinkedList;

import movers.DefaultMover;
import movers.TrackingMover;
import entities.Entity;
import entities.Mouse;
import entities.Square;

public class Game {
	
	public static final Entity mouse = Mouse.instance();
	private LinkedList<Square> entities;
	
	public Game() {
		entities = new LinkedList<>();
		
		Square sq = new Square(300, 200, 100);
		DefaultMover mov = new DefaultMover(sq);
		mov.setRotationSpeed(2);
		mov.setSpeed(12, 12);
		entities.add(sq);
		
		sq = new Square(500, 100, 60);
		TrackingMover mov2 = new TrackingMover(sq);
		mov2.setRotationTracking(mouse, TrackingMover.ROTATION_LOOK_AT);
		entities.add(sq);
		
		sq = new Square(0, 0, 30);
		mov2 = new TrackingMover(sq);
		mov2.setMovementTracking(mouse, TrackingMover.MOVEMENT_FOLLOW);
		mov2.setRotationTracking(entities.getLast(), TrackingMover.ROTATION_COPY);
		entities.add(sq);
	}
	
	public void update(double dt) {
		mouse.update(dt);
		for (Square sq : entities) {
			sq.update(dt);
		}
	}
	
	public void render() {
		for (Square sq : entities) {
			sq.render();
		}
	}	
}