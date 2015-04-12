public class PenDown implements Expression {

	@Override
	public Object evaluate(Context values) {
		(values.SDSU_Turtle).penDown();
		return true;
	}

	public String toString() {
		return "penDown";
	}

}
