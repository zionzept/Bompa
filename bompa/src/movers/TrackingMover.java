package movers;

import entities.Entity;

public class TrackingMover extends Mover {

	public static final int MOVEMENT_FOLLOW = 1;
	public static final int ROTATION_COPY = 1, ROTATION_LOOK_AT = 2;

	private int movementTrackingMode;
	private int rotationTrackingMode;

	private Entity movementTracking;
	private Entity rotationTracking;

	public TrackingMover(Entity entity) {
		super(entity);
	}

	public void setMovementTrackingEntity(Entity entity) {
		movementTracking = entity;
	}

	public void setRotationTrackingEntity(Entity entity) {
		rotationTracking = entity;
	}
	
	public void setMovementTrackingMode(int mode) {
		movementTrackingMode = mode;
	}
	
	public void setRotationTrackingMode(int mode) {
		rotationTrackingMode = mode;
	}

	@Override
	public void update(double dt) {
		if (movementTracking != null) {
			move();
		}
		if (rotationTracking != null) {
			rotate();
		}
	}

	private void move() {
		switch (movementTrackingMode) {
		case MOVEMENT_FOLLOW:
			entity.setLocation(movementTracking.getX(), movementTracking.getY());
			break;
		}
	}

	private void rotate() {
		switch (rotationTrackingMode) {
		case ROTATION_COPY:
			entity.setRotation(rotationTracking.getRotation());
			break;
		case ROTATION_LOOK_AT:
			entity.setRotation(entity.angleTo(rotationTracking));
			break;
		}
		
	}

}