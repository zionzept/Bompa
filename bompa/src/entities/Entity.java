package entities;

import static java.lang.Math.PI;
import static java.lang.Math.floor;
import static java.lang.Math.sqrt;
import static java.lang.Math.hypot;
import movers.Mover;

public abstract class Entity {
	protected static final double PI2 = PI * 2;
	protected static final double SCALING = 1 / sqrt(2);

	public static final Entity NULL = new Entity(0, 0, 0, 0) {
		@Override
		public void render() {
		}

		@Override
		public void setMover(Mover mover, boolean dualLink) {
		}
	};

	private Mover mover;

	protected double x;
	protected double y;
	protected double s;
	protected double a;

	public Entity(double x, double y, double s, double a) {
		this.x = x;
		this.y = y;
		this.s = s / 2;
		this.a = a;

		mover = Mover.NULL;
	}

	public Entity(double x, double y, double s) {
		this(x, y, s, 0);
	}

	/**
	 * Links a
	 * 
	 * @param mover
	 */
	public void setMover(Mover mover, boolean dualLink) {
		this.mover = mover;
		if (dualLink) {
			mover.setEntity(this, false);
		}
	}

	public Mover getMover() {
		return mover;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getSize() {
		return s * 2;
	}

	public double getRotation() {
		return a;
	}

	public void setLocation(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public void move(double dx, double dy) {
		this.x += dx;
		this.y += dy;
	}

	public void setRotation(double a) {
		if (a >= PI2 || a < 0) {
			a -= floor(a / PI2) * PI2;
		}
		this.a = a;
	}

	public void rotate(double da) {
		this.a += da;
		if (a >= PI2 || a < 0) {
			a -= floor(a / PI2) * PI2;
		}
	}

	public void update(double dt) {
		mover.update(dt);
	}

	public abstract void render();

	public double distanceTo(Entity o) {
		return hypot(o.x - x, o.y - y);
	}

	public double angleTo(Entity o) {
		double dx = o.x - x;
		double dy = o.y - y;
		double a = Math.atan(dy / dx);
		return Double.isNaN(a) ? 0 : dx < 0 ? a + PI : dy < 0 ? a + PI2 : a;
	}
}
