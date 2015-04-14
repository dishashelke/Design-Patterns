package Interpreter;

import Visitor.Visitor;

public class Turn implements Expression {

	private Expression parameter;

	public Turn(Expression parameter) {
		this.parameter = parameter;
	}
	//getter is added for undo of Turncommand
	public Expression parameter(){
		return parameter;
	}

	@Override
	public Object evaluate(Context values) {
		int degrees = (Integer) parameter.evaluate(values);
		values.turtle().turn(degrees);
		return true;
	}

	public String toString() {
		return "turn" + parameter.toString();
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visitTurn(this);
	}

}
