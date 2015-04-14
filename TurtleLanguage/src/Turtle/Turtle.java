package Turtle;
import java.awt.geom.Point2D;


public class Turtle {
	private int direction;// is of 0 to 360 degrees
	private Point2D location;
	private boolean penUp;
	
	public Turtle(){
		location = new Point2D.Double(0,0);
		penUp = false;// pen is down
		direction = 0;
	}
	public void move(int distance){
		Point2D oldLocation = location;
		double radians = direction * Math.PI / 180;//convert degrees to radians
		double deltaX = Math.cos(radians) * distance;
		double deltaY = Math.sin(radians) * distance;
		double newX = location.getX() + deltaX;
		double newY = location.getY() + deltaY;
		location.setLocation(newX, newY);
		if(isPenUp())
			drawLine(oldLocation, location);
	}
	private void drawLine(Point2D start, Point2D end){
		
	}
	public void turn(int degrees){
		final int MAX_DEGREES = 360;
		direction = (direction + degrees) % MAX_DEGREES;
		if(direction < 0)
			direction += MAX_DEGREES;
	}
	public void penUp(){
		penUp = true;
	}
	public void penDown(){
		penUp = false;
	}
	public boolean isPenUp(){
		return penUp;
	}
	public int direction(){
		return direction;
	}
	public Point2D location(){
		return location;
	}
}
