public class Move implements Expression {

	private Expression parameter;

	public Move(Expression parameter) {
		this.parameter = parameter;
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

}
