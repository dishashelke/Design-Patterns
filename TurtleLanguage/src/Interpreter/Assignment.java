//chk this
package Interpreter;

import Visitor.Visitor;

public class Assignment implements Expression {

	private String name;
	private int value;

	public Assignment(String name, int value) {
		this.name = name;
		this.value = value;
	}

	@Override
	public Object evaluate(Context values) {
		values.setValue(name, value);
		return true;
	}
	
	@Override
	public String toString(){
		return name;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visitAssignment(this);
	}

}
