package movers;

import static java.lang.Math.floor;
import entities.Entity;

public class DefaultMover extends Mover {
	
	protected double dx;
	protected double dy;
	protected double da;
	
	public DefaultMover(Entity entity) {
		super(entity);
	}

	public void setSpeed(double dx, double dy) {
		this.dx = dx;
		this.dy = dy;
	}

	public void setRotationSpeed(double da) {
		if (da >= PI2 || da < 0) {
			da -= floor(da / PI2) * PI2;
		}
		this.da = da;
	}
	
	public void update(double dt) {
		entity.move(dx * dt, dy * dt);
		entity.rotate(da * dt);
	}
}
