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
		Parser fileParser = new Parser();
		Expression expressions = fileParser.parse("simpleInput.txt");
		Context values = fileParser.context();
		expressions.evaluate(values);
		
/*		Visitor generator = new CommandVisitor(values);
		expressions.accept(generator);
		ArrayList<ExpressionCommand> list=  (ArrayList<ExpressionCommand>) generator.getResult();
		for(Object each: list)
			System.out.println(each);*/
	}

}
