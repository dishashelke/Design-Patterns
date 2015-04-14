package Command;

import Interpreter.Assignment;
import Interpreter.Context;

public class AssignmentCommand implements ExpressionCommand {

	private Assignment expression;

	public AssignmentCommand(Assignment expression) {
		this.expression = expression;
	}

	@Override
	public Object undo(Context values) {
		values.remove(expression.toString());
		return true;
	}

	@Override
	public Object evaluate(Context values) {
		return expression.evaluate(values);
	}

}
