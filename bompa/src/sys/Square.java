package sys;

import static org.lwjgl.opengl.GL11.*;
import static java.lang.Math.*;

public class Square {
	private static final double PI2 = PI * 2;
	private static final double SCALING = 1 / sqrt(2);
	
	private double x;
	private double y;
	private double s;
	private double a;
	
	private double dx;
	private double dy;
	private double da;
	
	public Square(double x, double y, double s, double a) {
		this.x = x;
		this.y = y;
		this.s = s / 2;
		this.a = a;
	}
	
	public Square(double x, double y, double s) {
		this(x, y, s, 0);
	}
	
	public void setLocation(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public void move(double dx, double dy) {
		this.x += x;
		this.y += y;
	}
	
	public void setRotation(double a) {
		if (a >= PI2) {
			a -= (int)(a / PI2);		//TODO: Merge if correct
		} else if (da < 0) {
			a -= (int)(a / PI2);
		}
		this.a = a;
	}
	
	public void rotate(double da) {
		this.a += da;
		if (a >= PI2) {
			a -= (int)(a / PI2);		//TODO: Merge if correct
		} else if (da < 0) {
			a -= (int)(a / PI2);
		}
	}
	
	public void setSpeed(double dx, double dy) {
		this.dx = dx;
		this.dy = dy;
	}
	
	public void setRotationSpeed(double da) {
		if (da >= PI2) {
			da -= (int)(da / PI2);		//TODO: Merge if correct
		} else if (da < 0) {
			da -= (int)(da / PI2);
		}
		this.da = da;
	}
	
	public void update(double dt) {
		this.x += this.dx * dt;
		this.y += this.dy * dt;
		this.a += this.da * dt;
		a = a < 0 ? a + PI2 : a >= PI2 ? a - PI2 : a;
	}
	
	public void render() {
		double cos = cos(a) * s * SCALING;
		double sin = sin(a) * s * SCALING;
		glBegin(GL_QUADS); {
			glVertex2d(x - cos - sin, y - cos + sin);
			glVertex2d(x + cos - sin, y - cos - sin);
			glVertex2d(x + cos + sin, y + cos - sin);
			glVertex2d(x - cos + sin, y + cos + sin);
		} glEnd();
	}
	
	public double getX(){
		return x;
	}
	
	public double getY(){
		return y;
	}
	
	
	
}
