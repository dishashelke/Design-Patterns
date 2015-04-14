package Command;

import Interpreter.Constant;
import Interpreter.Context;
import Interpreter.Expression;
import Interpreter.Turn;

public class TurnCommand implements ExpressionCommand{

	//private ExpressionCommand parameter;
	private Turn expression;

	/*public TurnCommand(ExpressionCommand parameter) {
		this.parameter = parameter;
	}*/
	public TurnCommand(Turn expression){
		this.expression = expression;
	}
	@Override
	public Object undo(Context values) {
		/*int degrees = (Integer) parameter.evaluate(values);
		(values.turtle()).turn(-degrees);
		return true;*/
		Expression parameter = expression.parameter();
		int degrees = (Integer) parameter.evaluate(values);
		Constant reveresDegrees = new Constant(-degrees);
		Turn reverse = new Turn(reveresDegrees);
		reverse.evaluate(values);
		return true;
	}

	@Override
	public Object evaluate(Context values) {
		/*int degrees = (Integer) parameter.evaluate(values);
		(values.turtle()).turn(degrees);
		return true;*/
		return expression.evaluate(values);
	}

}
