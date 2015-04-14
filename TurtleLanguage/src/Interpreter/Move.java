package Interpreter;

import Visitor.Visitor;

public class Move implements Expression {

	private Expression parameter;

	public Move(Expression parameter) {
		this.parameter = parameter;
	}

	public Expression parameter() {
		return parameter;
	}

	@Override
	public Object evaluate(Context values) {
		int distance = (Integer) parameter.evaluate(values);
		values.turtle().move(distance);
		return true;
	}

	@Override
	public String toString() {
		return "move" + parameter.toString();
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visitMove(this);
	}

}
