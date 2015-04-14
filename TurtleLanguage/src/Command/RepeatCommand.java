package Command;

import Interpreter.Context;
import Interpreter.Expression;
import Interpreter.Repeat;

public class RepeatCommand implements ExpressionCommand {
	/*private ExpressionCommand counter;
	private ExpressionCommand statement;*/

	private Repeat expression;
	/*public RepeatCommand(ExpressionCommand counter, ExpressionCommand statement) {
		this.counter = counter;
		this.statement = statement;
	}*/
	/*public RepeatCommand(Expression counter, Expression statement) {
		expression = new Repeat(counter, statement);
	}*/
	public RepeatCommand(Repeat expression){
		this.expression =  expression;
	}

	
	@Override
	public Object undo(Context values) {
		/*int parameter = (Integer) counter.evaluate(values);
		for (int i = 0; i < parameter; i++)
			statement.undo(values);*/
		int parameter = expression.counter(values);
		ExpressionCommand statement = (ExpressionCommand) expression.statement();
		for (int i = 0; i < parameter; i++)
			statement.undo(values);
		return true;
	}

	@Override
	public Object evaluate(Context values) {
		/*int parameter = (Integer) counter.evaluate(values);
		for (int i = 0; i < parameter; i++)
			statement.evaluate(values);
		return true;*/
		return expression.evaluate(values);
	}
}
