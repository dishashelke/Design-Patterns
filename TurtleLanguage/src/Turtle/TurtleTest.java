package Turtle;

import static org.junit.Assert.*;

import java.awt.geom.Point2D;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;

public class TurtleTest {

	private Turtle testTurtle;
	private static final double DELTA = 1e-3;// degree of precision used in comparing doubles

	@Before
	public void setUp() throws Exception {
		testTurtle = new Turtle();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPenUpFali() {
		assertTrue(testTurtle.isPenUp());
	}

	@Test
	public void testPenDown() {
		assertFalse(testTurtle.isPenUp());
	}

	@Test
	public void testTurn() {
		testTurtle.turn(-90);
		assertEquals(270, testTurtle.direction());
		testTurtle.turn(90);
		assertEquals(0, testTurtle.direction());
		testTurtle.turn(-270);
		assertEquals(90, testTurtle.direction());
	}

	@Test
	public void testMove() {
		// at location(0,0) and direction of 0 degrees
		testTurtle.move(10);
		testTurtle.turn(90);
		testTurtle.move(20);// at location (10,20) and direction of 90 degrees
		testTurtle.turn(-90);
		testTurtle.turn(30);// and direction of 30 degrees
		assertEquals(30, testTurtle.direction());
		assertEquals(10, testTurtle.location().getX(), DELTA);
		assertEquals(20, testTurtle.location().getY(), DELTA);
		testTurtle.move(15);
		Point2D movedLocation = new Point2D.Double(22.99, 27.5);
		assertEquals(movedLocation.getX(), testTurtle.location().getX(), DELTA);
		assertEquals(movedLocation.getY(), testTurtle.location().getY(), DELTA);
	}
}
