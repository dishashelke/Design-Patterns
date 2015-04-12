import java.util.Hashtable;

public class Context {
	Turtle SDSU_Turtle;

	Context() {
		SDSU_Turtle = new Turtle();
	}

	Hashtable<String, Integer> values = new Hashtable<String, Integer>();

	public int getValue(String variableName) {
		return values.get(variableName);
	}

	public void setValue(String variableName, int value) {
		values.put(variableName, value);
	}
}
