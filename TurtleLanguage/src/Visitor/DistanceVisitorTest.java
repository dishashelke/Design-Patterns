package Visitor;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Interpreter.Context;
import Interpreter.Expression;
import Turtle.Parser;

public class DistanceVisitorTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDistanceVisitor() {
		Parser fileParser = new Parser();
		Expression expressions = fileParser.parse("assignmentInput.txt");
		Context values = fileParser.context();

		Visitor generator = new DistanceVisitor(values);
		expressions.accept(generator);
		int totalDistance = (Integer) generator.getResult();
		assertEquals(45, totalDistance);
	}

	@Test
	public void testDistanceVisitorForRepeats() {
		Parser fileParser = new Parser();
		Expression expressions = fileParser.parse("repeatInput.txt");
		Context values = fileParser.context();

		Visitor generator = new DistanceVisitor(values);
		expressions.accept(generator);
		int totalDistance = (Integer) generator.getResult();
		assertEquals(30, totalDistance);

		// testing on nestedRepeats
		Expression nestedExpressions =
			fileParser.parse("nestedRepeatInput.txt");
		Context nestedValues = fileParser.context();

		Visitor nestedGenerator = new DistanceVisitor(nestedValues);
		nestedExpressions.accept(nestedGenerator);
		int nestedTotalDistance = (Integer) nestedGenerator.getResult();
		assertEquals(0, nestedTotalDistance);
	}

	@Test
	public void testDistanceVisitorFail() {
		Parser fileParser = new Parser();
		Expression expressions = fileParser.parse("assignmentInput.txt");
		Context values = fileParser.context();

		Visitor generator = new DistanceVisitor(values);
		expressions.accept(generator);
		int totalDistance = (Integer) generator.getResult();
		assertEquals(0, totalDistance);
	}
}
