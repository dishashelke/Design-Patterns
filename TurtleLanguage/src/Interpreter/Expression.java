package Interpreter;
import Visitor.Visitor;
//return type of evaluate?
public interface Expression {
	public Object evaluate(Context values);

	public String toString();
	public void accept(Visitor visitor);

}
