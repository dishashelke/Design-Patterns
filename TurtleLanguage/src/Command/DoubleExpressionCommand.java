package Command;

import Interpreter.Context;
import Interpreter.DoubleExpression;
import Interpreter.Expression;

public class DoubleExpressionCommand implements ExpressionCommand{
	/*private ExpressionCommand firstPart;
	private ExpressionCommand nextPart;*/
	private DoubleExpression expression;

	/*public DoubleExpressionCommand(ExpressionCommand firstPart, ExpressionCommand nextPart) {
		this.firstPart = firstPart;
		this.nextPart = nextPart;
	}*/
	public DoubleExpressionCommand(DoubleExpression expression){
		this.expression = expression;
	}
	@Override
	public Object undo(Context values) {
		/*firstPart.undo(values);
		nextPart.undo(values);*/
		ExpressionCommand firstPart = (ExpressionCommand) expression.firstPart();
		ExpressionCommand nextPart = (ExpressionCommand) expression.nextPart();
		firstPart.undo(values);
		nextPart.undo(values);
		return true;
	}

	@Override
	public Object evaluate(Context values) {
		/*firstPart.evaluate(values);
		nextPart.evaluate(values);
		return true;*/
		return expression.evaluate(values);
	}

}
