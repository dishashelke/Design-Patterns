package Command;

import Interpreter.Context;
import Interpreter.PenDown;
import Interpreter.PenUp;

public class PenDownCommand implements ExpressionCommand {

	private PenDown expression;

	public PenDownCommand(PenDown expression) {
		this.expression = expression;
	}

	@Override
	public Object undo(Context values) {
		PenUp penUpExpression = new PenUp();
		return penUpExpression.evaluate(values);
	}

	@Override
	public Object evaluate(Context values) {
		return expression.evaluate(values);
	}

}
