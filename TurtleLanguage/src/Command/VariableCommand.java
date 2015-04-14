package Command;

import Interpreter.Context;
import Interpreter.Variable;

public class VariableCommand implements ExpressionCommand {

	private Variable expression;

	public VariableCommand(Variable expression) {
		this.expression = expression;
	}

	@Override
	public Object undo(Context values) {
		String name = expression.toString();
		values.remove(name);
		return true;
	}

	@Override
	public Object evaluate(Context values) {
		return expression.evaluate(values);
	}

}
