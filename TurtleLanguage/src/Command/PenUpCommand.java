package Command;

import Interpreter.Context;
import Interpreter.Expression;
import Interpreter.PenDown;
import Interpreter.PenUp;

public class PenUpCommand implements ExpressionCommand{
	Expression expression;
	public PenUpCommand(PenUp expression){
		this.expression = expression;
	}
	@Override
	public Object undo(Context values) {
		//values.turtle().penDown();
		expression = new PenDown();
		expression.evaluate(values);
		return true;
	}

	@Override
	public Object evaluate(Context values) {
		//values.turtle().penUp();
		expression.evaluate(values);
		return true;
	}

}
