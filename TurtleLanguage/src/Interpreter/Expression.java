package Interpreter;

import Visitor.Visitor;

public interface Expression {
	public Object evaluate(Context values);

	public String toString();

	public void accept(Visitor visitor);

}
