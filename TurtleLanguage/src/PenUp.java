
public class PenUp implements Expression{

	@Override
	public Object evaluate(Context values) {
		values.turtle().penUp();
		return true;
	}
	
	public String toString() {
		return "penUP";
	}

}
