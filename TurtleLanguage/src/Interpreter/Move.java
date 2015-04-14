package Interpreter;

import Visitor.Visitor;

public class Move implements Expression {

	private Expression parameter;

	public Move(Expression parameter) {
		this.parameter = parameter;
	}
	//added getter to use in DistanceVisitor 
	public Expression parameter(){
		return parameter;
	}

	@Override
	public Object evaluate(Context values) {
		int distance = (Integer) parameter.evaluate(values);
		values.turtle().move(distance);
		return true;
	}

	public String toString() {
		return "move" + parameter.toString();
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visitMove(this);
	}

}
