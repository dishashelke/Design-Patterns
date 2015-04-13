import java.util.Hashtable;

public class Context {
	private Turtle SDSU_Turtle;
	private Hashtable<String, Integer> values = new Hashtable<String, Integer>();

	Context() {
		SDSU_Turtle = new Turtle();
	}
	public Turtle turtle(){
		return SDSU_Turtle;
	}

	public int getValue(String variableName) {
		return values.get(variableName);
	}

	public void setValue(String variableName, int value) {
		values.put(variableName, value);
	}
}
