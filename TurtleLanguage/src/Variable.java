//override methods in TurtleExpression?
public class Variable implements Expression {

	private String name;

	// private Variable??
	public Variable(String name) {
		this.name = name;
	}

	@Override
	public Object evaluate(Context values) {
		return values.getValue(name);
	}

	public String toString() {
		return name;
	}

}
