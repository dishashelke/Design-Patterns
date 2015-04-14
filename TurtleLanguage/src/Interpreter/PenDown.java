package Interpreter;

import Visitor.Visitor;

public class PenDown implements Expression {

	@Override
	public Object evaluate(Context values) {
		(values.turtle()).penDown();
		return true;
	}

	public String toString() {
		return "penDown";
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visitPenDown(this);
	}

}
