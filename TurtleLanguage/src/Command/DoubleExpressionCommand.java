package Command;

import Interpreter.Context;
import Interpreter.DoubleExpression;

public class DoubleExpressionCommand implements ExpressionCommand {
	
	private DoubleExpression expression;

	public DoubleExpressionCommand(DoubleExpression expression) {
		this.expression = expression;
	}

	@Override
	public Object undo(Context values) {

		ExpressionCommand firstPart = (ExpressionCommand) expression
				.firstPart();
		ExpressionCommand nextPart = (ExpressionCommand) expression.nextPart();
		firstPart.undo(values);
		nextPart.undo(values);
		return true;
	}

	@Override
	public Object evaluate(Context values) {
		return expression.evaluate(values);
	}

}
