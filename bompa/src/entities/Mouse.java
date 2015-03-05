package entities;

public class Mouse extends Entity {

	private static Mouse instance;
	
	private Mouse(double x, double y, double s) {
		super(x, y, s);
		instance = this;
	}
	
	public static Mouse instance() {
		if (instance == null) {
			instance = new Mouse(0, 0, 0);
		}
		return instance;
	}
	
	@Override
	public void update(double dt) {
		setLocation(org.lwjgl.input.Mouse.getX(), org.lwjgl.input.Mouse.getY() );
	}

	@Override
	public void render() {
	}
	
	@Override
	public String toString() {
		return "Mouse: [x = " + x + "] [y = " + y + "]";
	}

}