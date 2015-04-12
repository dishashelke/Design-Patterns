
public class PenUp implements Expression{

	@Override
	public Object evaluate(Context values) {
		values.SDSU_Turtle.penUp();
		return true;
	}
	
	public String toString() {
		return "penUP";
	}

}
