package movers;

import static java.lang.Math.PI;
import entities.Entity;

public abstract class Mover {
	protected static final double PI2 = PI * 2;

	public static final Mover NULL = new Mover(Entity.NULL) {
		@Override
		public void update(double dt) {
		}
		@Override
		public void setEntity(Entity entity, boolean dualLink){
		}
	};

	protected Entity entity;

	

	public Mover(Entity entity) {
		setEntity(entity, true);
	}

	public void setEntity(Entity entity, boolean dualLink) {
		this.entity = entity;
		if (dualLink) {
			entity.setMover(this, false);
		}
	}

	public abstract void update(double dt);

}