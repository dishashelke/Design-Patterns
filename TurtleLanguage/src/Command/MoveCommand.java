package Command;

import Interpreter.Constant;
import Interpreter.Context;
import Interpreter.Expression;
import Interpreter.Move;
import Interpreter.Turn;

public class MoveCommand implements ExpressionCommand {
	//private ExpressionCommand parameter;

	private Expression expression;

	/*public MoveCommand(Expression parameter) {
		this.parameter = (ExpressionCommand) parameter;
	}
	*/

	public MoveCommand(Move expression) {
		this.expression = expression;
	}

	@Override
	public Object undo(Context values) {
		/*
		 * int distance = (Integer) parameter.evaluate(values);
		 * values.turtle().turn(180);// turn the turtle by 180 degrees so that
		 * it // can return to its original position
		 * values.turtle().move(distance); return true;
		 */

		Turn reversedDirection = new Turn(new Constant(-180));
		reversedDirection.evaluate(values);
		return evaluate(values);

	}

	@Override
	public Object evaluate(Context values) {
		/*
		 * int distance = (Integer) parameter.evaluate(values);
		 * values.turtle().move(distance); return true;
		 */
		return expression.evaluate(values);
	}

}
