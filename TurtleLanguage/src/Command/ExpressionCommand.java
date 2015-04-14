package Command;

import Interpreter.Context;

public interface ExpressionCommand {
	public Object undo(Context values);

	public Object evaluate(Context values);

}
