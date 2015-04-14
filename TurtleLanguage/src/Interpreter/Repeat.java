package Interpreter;

import Visitor.Visitor;

public class Repeat implements Expression {

	private Expression counter;
	private Expression statement;

	public Repeat(Expression counter, Expression statement) {
		this.counter = counter;
		this.statement = statement;
	}

	public int counter(Context values) {
		return (Integer) counter.evaluate(values);
	}

	public Expression statement() {
		return statement;
	}

	@Override
	public Object evaluate(Context values) {
		int parameter = (Integer) counter.evaluate(values);
		for (int i = 0; i < parameter; i++)
			statement.evaluate(values);
		return true;
	}

	@Override
	public String toString() {
		return "\nrepeat" + counter.toString() + "\n\t" + statement.toString()
				+ "\nend";
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visitRepeat(this);
	}

}
