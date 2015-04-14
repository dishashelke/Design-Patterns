package Turtle;
import static org.junit.Assert.*;

import java.awt.geom.Point2D;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;

import Visitor.CommandVisitor;
import Visitor.DistanceVisitor;
import Visitor.Visitor;

import Interpreter.Context;
import Interpreter.Expression;

public class TurtleTest {

	private Turtle testTurtle;
	private static final double DELTA = 1e-3;// value that two doubles can be
												// off by

	@Before
	public void setUp() throws Exception {
		testTurtle = new Turtle();
	}

	@After
	public void tearDown() throws Exception {
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

	// following are interpreter tests create class for it!
	@Test
	public void testSimplePasrer() {
		Parser fileParser = new Parser();
		Expression expressions = fileParser.parse("assignmentInput.txt");
		Context values = fileParser.context();
		expressions.evaluate(values);
		testTurtle = values.turtle();
		assertEquals(30, testTurtle.direction());
		assertEquals(22.99, testTurtle.location().getX(), DELTA);
		assertEquals(27.5, testTurtle.location().getY(), DELTA);
	}

	@Test
	public void testRepeatPasrer() {
		Parser fileParser = new Parser();
		Expression expressions = fileParser.parse("repeatInput.txt");
		Context values = fileParser.context();
		expressions.evaluate(values);
		testTurtle = values.turtle();
		assertEquals(270, testTurtle.direction());
		assertEquals(0, testTurtle.location().getX(), DELTA);
		assertEquals(10, testTurtle.location().getY(), DELTA);
	}

	@Test
	public void testNestedRepeatPasrer() {
		Parser fileParser = new Parser();
		Expression expressions = fileParser.parse("nestedRepeatInput.txt");
		Context values = fileParser.context();
		expressions.evaluate(values);
		testTurtle = values.turtle();
		assertEquals(180, testTurtle.direction());
		assertEquals(0, testTurtle.location().getX(), DELTA);
		assertEquals(0, testTurtle.location().getY(), DELTA);
	}
	
	//following are command tests write class for it!!
	@Test
	public void testCommand(){
		Parser fileParser = new Parser();
		Expression expressions = fileParser.parse("assignmentInput.txt");
		Context values = fileParser.context();
		
		Command command = new Command(expressions, values);
		Turtle receiver = command.execute();
		assertEquals(30, receiver.direction());
		assertEquals(22.99, receiver.location().getX(), DELTA);
		assertEquals(27.5, receiver.location().getY(), DELTA);
	}
	//foll. are distancevisitor tests
	@Test
	public void testDistanceVisitor(){
		Parser fileParser = new Parser();
		Expression expressions = fileParser.parse("assignmentInput.txt");
		Context values = fileParser.context();
		
		Visitor generator = new DistanceVisitor(values);
		expressions.accept(generator);
		int totalDistance = (Integer) generator.getResult();
		assertEquals(45, totalDistance);
	}
	public void testDistanceVisitorForRepeats(){
		Parser fileParser = new Parser();
		Expression expressions = fileParser.parse("repeatInput.txt");
		Context values = fileParser.context();
		
		Visitor generator = new DistanceVisitor(values);
		expressions.accept(generator);
		int totalDistance = (Integer) generator.getResult();
		assertEquals(30, totalDistance);
		
		//testing on nestedRepeats 
		Expression nestedExpressions = fileParser.parse("nestedRepeatInput.txt");
		Context nestedValues = fileParser.context();
		
		Visitor nestedGenerator = new DistanceVisitor(nestedValues);
		nestedExpressions.accept(nestedGenerator);
		int nestedTotalDistance = (Integer) nestedGenerator.getResult();
		assertEquals(0, nestedTotalDistance);
	}
}
