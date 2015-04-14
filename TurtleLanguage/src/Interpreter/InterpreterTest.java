package Interpreter;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Turtle.Parser;
import Turtle.Turtle;

public class InterpreterTest {
	private Turtle resultTurtle;
	private static final double DELTA = 1e-3;// degree of precision used in comparing doubles

	@Before
	public void setUp() throws Exception {
		resultTurtle = new Turtle();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSimple() {
		Parser fileParser = new Parser();
		Expression expressions = fileParser.parse("assignmentInput.txt");
		Context values = fileParser.context();
		expressions.evaluate(values);
		resultTurtle = values.turtle();
		assertEquals(30, resultTurtle.direction());
		assertEquals(22.99, resultTurtle.location().getX(), DELTA);
		assertEquals(27.5, resultTurtle.location().getY(), DELTA);
	}

	@Test
	public void testRepeat() {
		Parser fileParser = new Parser();
		Expression expressions = fileParser.parse("repeatInput.txt");
		Context values = fileParser.context();
		expressions.evaluate(values);
		resultTurtle = values.turtle();
		assertEquals(270, resultTurtle.direction());
		assertEquals(0, resultTurtle.location().getX(), DELTA);
		assertEquals(10, resultTurtle.location().getY(), DELTA);
	}

	@Test
	public void testNestedRepeat() {
		Parser fileParser = new Parser();
		Expression expressions = fileParser.parse("nestedRepeatInput.txt");
		Context values = fileParser.context();
		expressions.evaluate(values);
		resultTurtle = values.turtle();
		assertEquals(180, resultTurtle.direction());
		assertEquals(0, resultTurtle.location().getX(), DELTA);
		assertEquals(0, resultTurtle.location().getY(), DELTA);
	}

	@Test
	public void testSimpleFail() {
		Parser fileParser = new Parser();
		Expression expressions = fileParser.parse("assignmentInput.txt");
		Context values = fileParser.context();
		expressions.evaluate(values);
		resultTurtle = values.turtle();
		assertEquals(0, resultTurtle.direction());
	}
}
