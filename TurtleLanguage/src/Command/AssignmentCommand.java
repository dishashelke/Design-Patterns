package Command;

import Interpreter.Assignment;
import Interpreter.Context;
import Interpreter.Expression;

public class AssignmentCommand implements ExpressionCommand {

	// private String name; private int value;

	private Expression expression;

	/*
	 * public AssignmentCommand(String name, int value) {
	 * 
	 * this.name = name; this.value = value;
	 * 
	 * }
	 */
	public AssignmentCommand(Assignment expression) {
		this.expression =  expression;
	}

	@Override
	public Object undo(Context values) {
		// values.remove(name);
		values.remove(expression.toString());
		return true;
	}

	@Override
	public Object evaluate(Context values) {

		// values.setValue(name, value); return true;

		return expression.evaluate(values);
	}

}
