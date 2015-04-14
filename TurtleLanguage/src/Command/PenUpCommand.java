package Command;

import Interpreter.Context;
import Interpreter.PenDown;
import Interpreter.PenUp;

public class PenUpCommand implements ExpressionCommand {

	private PenUp expression;

	public PenUpCommand(PenUp expression) {
		this.expression = expression;
	}

	@Override
	public Object undo(Context values) {
		PenDown penDownExpression = new PenDown();
		return penDownExpression.evaluate(values);
	}

	@Override
	public Object evaluate(Context values) {
		return expression.evaluate(values);
	}

}
