package Command;

import Interpreter.Constant;
import Interpreter.Context;
import Interpreter.Expression;
import Interpreter.Turn;

public class TurnCommand implements ExpressionCommand {

	private Turn expression;

	public TurnCommand(Turn expression) {
		this.expression = expression;
	}

	@Override
	public Object undo(Context values) {
		Expression parameter = expression.parameter();
		int degrees = (Integer) parameter.evaluate(values);
		Constant reveresDegrees = new Constant(-degrees);
		Turn reverse = new Turn(reveresDegrees);
		return reverse.evaluate(values);
	}

	@Override
	public Object evaluate(Context values) {
		return expression.evaluate(values);
	}

}
