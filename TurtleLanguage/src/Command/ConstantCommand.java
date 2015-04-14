package Command;

import Interpreter.Constant;
import Interpreter.Context;

public class ConstantCommand implements ExpressionCommand {

	private Constant expression;

	public ConstantCommand(Constant expression) {
		this.expression = expression;
	}

	@Override
	public Object undo(Context values) {
		return true;
	}

	@Override
	public Object evaluate(Context values) {
		return expression.evaluate(values);
	}

}
