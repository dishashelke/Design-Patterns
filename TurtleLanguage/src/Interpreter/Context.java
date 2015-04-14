package Interpreter;

import java.util.Hashtable;

import Turtle.Turtle;

public class Context {
	private Turtle SDSU_Turtle;
	private Hashtable<String, Integer> values = new Hashtable<String, Integer>();

	public Context() {
		SDSU_Turtle = new Turtle();
	}

	public Turtle turtle() {
		return SDSU_Turtle;
	}
	public Hashtable<String, Integer> values(){
		return values;
	}

	public int getValue(String variableName) {
		return values.get(variableName);
	}

	public void remove(String variableName) {
		values.remove(variableName);
	}

	public void setValue(String variableName, int value) {
		values.put(variableName, value);
	}
}
