package Visitor;

import java.awt.SecondaryLoop;
import java.util.ArrayList;

import Command.AssignmentCommand;
import Command.ConstantCommand;
import Command.DoubleExpressionCommand;
import Command.ExpressionCommand;
import Command.MoveCommand;
import Command.PenDownCommand;
import Command.PenUpCommand;
import Command.RepeatCommand;
import Command.TurnCommand;
import Command.VariableCommand;
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

public class CommandVisitor extends Visitor{

	ArrayList<ExpressionCommand> commands;
	private Context values;
	public CommandVisitor(Context values){
		this.values = values;
		this.commands = new ArrayList<ExpressionCommand>();
	}
	@Override
	public Object getResult() {
		return commands;
	}
	@Override
	public void visitAssignment(Assignment expression) {
		ExpressionCommand moveCommand = new AssignmentCommand(expression);
		commands.add(moveCommand);
	}

	@Override
	public void visitConstant(Constant expression) {
		ExpressionCommand constantCommand = new ConstantCommand(expression);
		commands.add(constantCommand);		
	}

	@Override
	public void visitDoubleExpression(DoubleExpression expression) {
		//ExpressionCommand doubleExpressionCommand = new DoubleExpressionCommand(expression);
		//commands.add(doubleExpressionCommand);		
		Expression firstPart = expression.firstPart();
		firstPart.accept(this);
		Expression nextPart = expression.nextPart();
		nextPart.accept(this);
	}

	@Override
	public void visitMove(Move expression) {
		ExpressionCommand moveCommand = new MoveCommand(expression);
		commands.add(moveCommand);			
	}

	@Override
	public void visitPenDown(PenDown expression) {
		ExpressionCommand penDownCommand = new PenDownCommand(expression);
		commands.add(penDownCommand);		
	}

	@Override
	public void visitPenUp(PenUp expression) {
		ExpressionCommand penUpCommand = new PenUpCommand(expression);
		commands.add(penUpCommand);		
	}

	@Override
	public void visitRepeat(Repeat expression) {
		//ExpressionCommand repeatCommand = new RepeatCommand(expression);
		//commands.add(repeatCommand);
		expression.accept(this);
	}

	@Override
	public void visitTurn(Turn expression) {
		ExpressionCommand turnCommand = new TurnCommand(expression);
		commands.add(turnCommand);		
	}

	@Override
	public void visitVariable(Variable expression) {
		ExpressionCommand variableCommand = new VariableCommand(expression);
		commands.add(variableCommand);		
	}


}
