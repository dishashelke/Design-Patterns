public class PenDown implements Expression {

	@Override
	public Object evaluate(Context values) {
		(values.turtle()).penDown();
		return true;
	}

	public String toString() {
		return "penDown";
	}

}
