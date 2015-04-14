package Command;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Interpreter.Constant;
import Interpreter.Context;
import Interpreter.Move;
import Interpreter.PenDown;
import Interpreter.PenUp;
import Interpreter.Turn;
import Turtle.Turtle;

public class UndoTest {

	private Context values;
	private static final double DELTA = 1e-3;// degree of precision used in comparing doubles

	@Before
	public void setUp() throws Exception {
		values = new Context();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testUndoPenUp() {
		PenUp expression = new PenUp();
		ExpressionCommand penUpCommand = new PenUpCommand(expression);
		penUpCommand.evaluate(values);
		Turtle testTurtle = values.turtle();
		assertTrue(testTurtle.isPenUp());
		penUpCommand.undo(values);
		assertFalse(testTurtle.isPenUp());
	}

	@Test
	public void testUndoPenDown() {
		PenDown expression = new PenDown();
		ExpressionCommand penDownCommand = new PenDownCommand(expression);
		penDownCommand.evaluate(values);
		Turtle testTurtle = values.turtle();
		assertFalse(testTurtle.isPenUp());
		penDownCommand.undo(values);
		assertTrue(testTurtle.isPenUp());
	}

	@Test
	public void testUndoMove() {
		Move expression = new Move(new Constant(10));
		ExpressionCommand moveCommand = new MoveCommand(expression);
		moveCommand.evaluate(values);
		Turtle testTurtle = values.turtle();
		assertEquals(0, testTurtle.direction());
		assertEquals(10, testTurtle.location().getX(), DELTA);
		assertEquals(0, testTurtle.location().getY(), DELTA);
		moveCommand.undo(values);
		//compare with original state of turtle
		//original state is at direction 0 degrees and location at x=0 and y=0
		assertEquals(0, testTurtle.direction());
		assertEquals(0, testTurtle.location().getX(), DELTA);
		assertEquals(0, testTurtle.location().getY(), DELTA);
	}
	@Test
	public void testUndoTurn() {
		Turn expression = new Turn(new Constant(90));
		ExpressionCommand turnCommand = new TurnCommand(expression);
		turnCommand.evaluate(values);
		Turtle testTurtle = values.turtle();
		assertEquals(90, testTurtle.direction());
		assertEquals(0, testTurtle.location().getX(), DELTA);
		assertEquals(0, testTurtle.location().getY(), DELTA);
		turnCommand.undo(values);
		//compare with original state of turtle
		//original state is at direction 0 degrees and location at x=0 and y=0
		assertEquals(0, testTurtle.direction());
		assertEquals(0, testTurtle.location().getX(), DELTA);
		assertEquals(0, testTurtle.location().getY(), DELTA);
	}
}
