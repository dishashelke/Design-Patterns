package Command;

import Interpreter.Constant;
import Interpreter.Context;
import Interpreter.Expression;

public class ConstantCommand implements ExpressionCommand {

	//private int value;
	private Expression expression;

	/*public ConstantCommand(int value) {
		this.value = value;
		//expression = new Constant(value);
	}*/
	public ConstantCommand(Constant expression){
		this.expression = expression;
	}

	@Override
	public Object undo(Context values) {
		return true;
	}

	@Override
	public Object evaluate(Context values) {
		//return value;
		return expression.evaluate(values);
	}

}
