package Command;

import Interpreter.Constant;
import Interpreter.Context;
import Interpreter.Move;
import Interpreter.Turn;

public class MoveCommand implements ExpressionCommand {

	private Move expression;

	public MoveCommand(Move expression) {
		this.expression = expression;
	}

	@Override
	public Object undo(Context values) {
		final int reveredDegrees = 180; 
		//revere the direction of turtle
		Turn reversedDirection = new Turn(new Constant(-reveredDegrees));
		reversedDirection.evaluate(values);
		//move in the revered direction by same distance
		evaluate(values);
		//change the direction to the original direction
		Turn originalDirection = new Turn(new Constant(reveredDegrees));
		return originalDirection.evaluate(values);
	}

	@Override
	public Object evaluate(Context values) {
		return expression.evaluate(values);
	}

}
