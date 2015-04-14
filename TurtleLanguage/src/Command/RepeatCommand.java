package Command;

import Interpreter.Context;
import Interpreter.Repeat;

public class RepeatCommand implements ExpressionCommand {

	private Repeat expression;

	public RepeatCommand(Repeat expression) {
		this.expression = expression;
	}

	@Override
	public Object undo(Context values) {
		int parameter = expression.counter(values);
		ExpressionCommand statement = 
			(ExpressionCommand) expression.statement();
		for (int i = 0; i < parameter; i++)
			statement.undo(values);
		return true;
	}

	@Override
	public Object evaluate(Context values) {
		return expression.evaluate(values);
	}
}
