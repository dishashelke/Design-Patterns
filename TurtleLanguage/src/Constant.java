public class Constant implements Expression {

	private int value;

	public Constant(int value) {
		this.value = value;
	}

	@Override
	public Object evaluate(Context values) {
		return value;
	}

	public String toString() {
		return String.valueOf(value);
	}

}
