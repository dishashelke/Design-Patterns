//delete this file

package Turtle;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import Command.ExpressionCommand;
import Interpreter.Context;
import Interpreter.Expression;
import Visitor.CommandVisitor;
import Visitor.DistanceVisitor;
import Visitor.Visitor;


public class Temp {

	public static void main(String[] args) throws FileNotFoundException {
		//testing distanceVisitor
		Parser fileParser = new Parser();
		Expression expressions = fileParser.parse("repeatInput.txt");
		Context values = fileParser.context();
		Visitor generator = new DistanceVisitor(values);
		expressions.accept(generator);
		System.out.println(generator.getResult());
		
		/*testing commandvisitor
		 * Parser fileParser = new Parser();
		Expression expressions = fileParser.parse("repeatInput.txt");
		Context values = fileParser.context();
		//expressions.evaluate(values);
		
		Visitor generator = new CommandVisitor(values);
		expressions.accept(generator);
		ArrayList<ExpressionCommand> list=  (ArrayList<ExpressionCommand>) generator.getResult();
		for(Object each: list)
			System.out.println(each);*/
		
		/*
		//testing undos
		Parser fileParser = new Parser();
		Expression expressions = fileParser.parse("undoInput.txt");
		Context values = fileParser.context();
		//expressions.evaluate(values);
		
		Visitor generator = new CommandVisitor(values);
		expressions.accept(generator);
		ArrayList<ExpressionCommand> list=  (ArrayList<ExpressionCommand>) generator.getResult();
		ExpressionCommand command = list.get(0);
		command.evaluate(values);
		System.out.println(values.turtle().direction()+ "\t" +values.turtle().location());
		command.undo(values);
		System.out.println(values.turtle().direction()+ "\t" +values.turtle().location());*/
	}

}
