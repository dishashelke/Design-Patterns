package Turtle;

import java.awt.geom.Point2D;

public class Turtle {
	private int direction;// is 0 to 360 degrees
	private Point2D location;
	private boolean penUp;
	static final int MAX_DEGREES = 360;

	public Turtle() {
		location = new Point2D.Double(0, 0);
		penUp = false;// pen is down
		direction = 0;
	}

	public void move(int distance) {
		Point2D oldLocation = location;
		// convert degrees to radians
		double radians = direction * Math.PI / (MAX_DEGREES / 2);
		double deltaX = Math.cos(radians) * distance;
		double deltaY = Math.sin(radians) * distance;
		double newX = location.getX() + deltaX;
		double newY = location.getY() + deltaY;
		location.setLocation(newX, newY);
		if (isPenUp())
			drawLine(oldLocation, location);
	}

	private void drawLine(Point2D start, Point2D end) {
		//code to draw figures
	}

	public void turn(int degrees) {
		direction = (direction + degrees) % MAX_DEGREES;
		if (direction < 0)
			direction += MAX_DEGREES;
	}

	public void penUp() {
		penUp = true;
	}

	public void penDown() {
		penUp = false;
	}

	public boolean isPenUp() {
		return penUp;
	}

	public int direction() {
		return direction;
	}

	public Point2D location() {
		return location;
	}
}
