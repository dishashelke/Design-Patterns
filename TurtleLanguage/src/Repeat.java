public class Repeat implements Expression {

	private Expression counter;
	private Expression statement;

	public Repeat(Expression counter, Expression statement) {
		this.counter = counter;
		this.statement = statement;
	}

	@Override
	public Object evaluate(Context values) {
		int parameter = (Integer) counter.evaluate(values);
		for (int i = 0; i < parameter; i++)
			statement.evaluate(values);
		return true;
	}

	public String toString() {
		return "\nrepeat" + counter.toString() + "\n\t" + statement.toString()
				+ "\nend";
	}

}
