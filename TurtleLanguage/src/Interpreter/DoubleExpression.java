package Interpreter;

import Visitor.Visitor;

public class DoubleExpression implements Expression {

	private Expression firstPart;
	private Expression nextPart;

	public DoubleExpression(Expression firstPart, Expression nextPart) {
		this.firstPart = firstPart;
		this.nextPart = nextPart;
	}
	//added these getters to implement undo in command
	public Expression firstPart(){
		return firstPart;
	}
	public Expression nextPart(){
		return nextPart;
	}

	@Override
	public Object evaluate(Context values) {
		firstPart.evaluate(values);
		nextPart.evaluate(values);
		return true;
	}

	public String toString() {
		return firstPart.toString() + nextPart.toString();
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visitDoubleExpression(this);
	}

}
