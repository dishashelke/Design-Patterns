//delete this class

package Turtle;

import Interpreter.Context;
import Interpreter.Expression;

public class Command {
	private Turtle receiver;
	private Expression command;
	private Context values;

	public Command(Expression command, Context values) {
		// this.receiver = receiver;
		this.command = command;
		this.values = values;
	}

	public Turtle execute() /*
							 * throws InvocationTargetException,
							 * IllegalAccessException
							 */{
		command.evaluate(values);
		receiver = values.turtle();
		return receiver;
	}
}
