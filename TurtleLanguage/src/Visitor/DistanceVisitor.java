package Visitor;

import Interpreter.Assignment;
import Interpreter.Constant;
import Interpreter.Context;
import Interpreter.DoubleExpression;
import Interpreter.Expression;
import Interpreter.Move;
import Interpreter.PenDown;
import Interpreter.PenUp;
import Interpreter.Repeat;
import Interpreter.Turn;
import Interpreter.Variable;

public class DistanceVisitor extends Visitor {

	private int totalDistance;
	private Context values;

	public DistanceVisitor(Context values) {
		totalDistance = 0;
		this.values = values;
	}

	@Override
	public Object getResult() {
		return totalDistance;
	}

	@Override
	public void visitAssignment(Assignment expression) {
		expression.evaluate(values);
	}

	@Override
	public void visitConstant(Constant expression) {

	}

	@Override
	public void visitDoubleExpression(DoubleExpression expression) {
		Expression firstPart = expression.firstPart();
		Expression nextPart = expression.nextPart();
		firstPart.accept(this);
		nextPart.accept(this);
	}

	@Override
	public void visitMove(Move expression) {
		Expression parameter = expression.parameter();
		int distance = (Integer) parameter.evaluate(values);
		this.totalDistance += distance;
	}

	@Override
	public void visitPenDown(PenDown expression) {

	}

	@Override
	public void visitPenUp(PenUp expression) {

	}

	@Override
	public void visitRepeat(Repeat expression) {

	}

	@Override
	public void visitTurn(Turn expression) {

	}

	@Override
	public void visitVariable(Variable expression) {

	}

}
