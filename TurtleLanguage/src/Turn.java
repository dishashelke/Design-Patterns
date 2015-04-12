public class Turn implements Expression {

	private Expression parameter;

	public Turn(Expression parameter) {
		this.parameter = parameter;
	}

	@Override
	public Object evaluate(Context values) {
		int degrees = (Integer) parameter.evaluate(values);
		values.SDSU_Turtle.turn(degrees);
		return true;
	}

	public String toString() {
		return "turn" + parameter.toString();
	}

}
