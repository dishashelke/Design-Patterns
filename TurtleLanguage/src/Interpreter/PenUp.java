package Interpreter;

import Visitor.Visitor;

public class PenUp implements Expression {

	@Override
	public Object evaluate(Context values) {
		values.turtle().penUp();
		return true;
	}

	@Override
	public String toString() {
		return "penUP";
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visitPenUp(this);
	}

}
