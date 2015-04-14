package Visitor;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Command.ExpressionCommand;
import Interpreter.Context;
import Interpreter.Expression;
import Turtle.Parser;
import Turtle.Turtle;

public class CommandVisitorTest {
	private static final double DELTA = 1e-3;// degree of precision used in comparing doubles

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testExecutionOfCommands() {
		Parser fileParser = new Parser();
		Expression expressions = fileParser.parse("assignmentInput.txt");
		Context values = fileParser.context();

		Visitor generator = new CommandVisitor(values);
		expressions.accept(generator);
		ArrayList<ExpressionCommand> list = 
			(ArrayList<ExpressionCommand>) generator.getResult();
		for (ExpressionCommand each : list)
			each.evaluate(values);
		Turtle resultTurtle = values.turtle();
		assertEquals(30, resultTurtle.direction());
		assertEquals(22.99, resultTurtle.location().getX(), DELTA);
		assertEquals(27.5, resultTurtle.location().getY(), DELTA);
	}
	
	@Test
	public void testExecutionOfRepeatCommands() {
		Parser fileParser = new Parser();
		Expression expressions = fileParser.parse("repeatInput.txt");
		Context values = fileParser.context();

		Visitor generator = new CommandVisitor(values);
		expressions.accept(generator);
		ArrayList<ExpressionCommand> list = 
			(ArrayList<ExpressionCommand>) generator.getResult();
		for (ExpressionCommand each : list)
			each.evaluate(values);
		Turtle resultTurtle = values.turtle();
		assertEquals(270, resultTurtle.direction());
		assertEquals(0, resultTurtle.location().getX(), DELTA);
		assertEquals(10, resultTurtle.location().getY(), DELTA);
	}
}
