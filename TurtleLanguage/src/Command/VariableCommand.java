package Command;

import Interpreter.Context;
import Interpreter.Variable;

public class VariableCommand implements ExpressionCommand {
	/*private String name;

	public VariableCommand(String name) {
		this.name = name;
	}*/
	private Variable expression;
	public VariableCommand(Variable expression){
		this.expression = expression;
	}

	@Override
	public Object undo(Context values) {
		//values.remove(name);
		String name = expression.toString();
		values.remove(name);
		return true;
	}

	@Override
	public Object evaluate(Context values) {
		//return values.getValue(name);
		return expression.evaluate(values);
	}

}
