public class DoubleExpression implements Expression {

	private Expression firstPart;
	private Expression nextPart;

	public DoubleExpression(Expression firstPart, Expression nextPart) {
		this.firstPart = firstPart;
		this.nextPart = nextPart;
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

}
