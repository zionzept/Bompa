package entities;

import static org.lwjgl.opengl.GL11.*;
import static java.lang.Math.*;

public class Square extends Entity {
	
	public Square(double x, double y, double s, double a) {
		super(x, y, s, a);
	}
	
	public Square(double x, double y, double s) {
		super(x, y, s);
	}
	
	public void render() {
		double cos = cos(a) * s * SCALING;
		double sin = sin(a) * s * SCALING; 
		glBegin(GL_QUADS); {
			glVertex2d(x - cos + sin, y - cos - sin);
			glVertex2d(x + cos + sin, y - cos + sin);
			glVertex2d(x + cos - sin, y + cos + sin);
			glVertex2d(x - cos - sin, y + cos - sin);
		} glEnd();
	}
}