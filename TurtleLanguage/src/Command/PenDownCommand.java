package Command;

import Interpreter.Context;
import Interpreter.Expression;
import Interpreter.PenDown;
import Interpreter.PenUp;

public class PenDownCommand implements ExpressionCommand{

	Expression expression;
	public PenDownCommand(PenDown expression){
		this.expression = expression;
	}
	@Override
	public Object undo(Context values) {
		//(values.turtle()).penUp();
		expression = new PenUp();
		expression.evaluate(values);
		return true;
	}

	@Override
	public Object evaluate(Context values) {
		//(values.turtle()).penDown();
		expression.evaluate(values);
		return true;
	}

}
