package Command;

import Interpreter.Context;

public interface ExpressionCommand {
	public Object undo(Context values);

	// change name to redo?
	public Object evaluate(Context values);

}
