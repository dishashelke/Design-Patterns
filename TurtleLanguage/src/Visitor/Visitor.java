package Visitor;

import Interpreter.Assignment;
import Interpreter.Constant;
import Interpreter.DoubleExpression;
import Interpreter.Move;
import Interpreter.PenDown;
import Interpreter.PenUp;
import Interpreter.Repeat;
import Interpreter.Turn;
import Interpreter.Variable;

abstract public class Visitor {
	abstract public Object getResult();// to return result calculated by visitor

	abstract public void visitAssignment(Assignment expression);

	abstract public void visitConstant(Constant expression);

	abstract public void visitDoubleExpression(DoubleExpression expression);

	abstract public void visitMove(Move expression);

	abstract public void visitPenDown(PenDown expression);

	abstract public void visitPenUp(PenUp expression);

	abstract public void visitRepeat(Repeat expression);

	abstract public void visitTurn(Turn expression);

	abstract public void visitVariable(Variable expression);
}
