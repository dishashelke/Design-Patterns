import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.naming.directory.InvalidAttributesException;

public class Parser {
	private ArrayList<Expression> expressions;
	private Context values;

	public Parser() {
		expressions = new ArrayList<Expression>();
		values = new Context();
	}

	public void parse(String filename) {
		File file = new File(filename);
		Expression expression = null;
		try {
			Scanner fileScanner = new Scanner(file);
			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				expression = generate(line, fileScanner);
				if (expression != null)
					expressions.add(expression);
			}
			fileScanner.close();
		} catch (Exception handleException) {
			System.out.println(handleException);
		}
		// how to execute this arraylist ???
		// or to return this arrayList and context??
	}

	private Expression generate(String line, Scanner fileScanner) {
		StringTokenizer tokenizer = new StringTokenizer(line, " ");
		String command = tokenizer.nextToken();

		Expression expression = null;
		if (command.equalsIgnoreCase("move")) {
			String parameterToken = tokenizer.nextToken();
			Expression parameter = parseParameter(parameterToken, tokenizer);
			expression = new Move(parameter);
		} else if (command.equalsIgnoreCase("turn")) {
			String parameterToken = tokenizer.nextToken();
			Expression parameter = parseParameter(parameterToken, tokenizer);
			expression = new Turn(parameter);
		} else if (command.equalsIgnoreCase("penUp")) {
			expression = new PenUp();
		} else if (command == "penDown") {
			expression = new PenDown();
		} else if (command.startsWith("$")) {
			String variable = command.substring(1);
			parseAssignment(variable, tokenizer);
		} else if (command.equalsIgnoreCase("repeat")) {
			String parameterToken = tokenizer.nextToken();
			Expression parameter = parseParameter(parameterToken, tokenizer);
			Expression expressionToRepeat = parseRepeat(fileScanner);
			expression = new Repeat(parameter, expressionToRepeat);
		}
		return expression;
	}

	private Expression parseRepeat(Scanner fileScanner) {
		String line = fileScanner.nextLine();
		Expression expression = null;
		Expression firstPart = null, nextPart = null;
		while(!line.equalsIgnoreCase("end")){
			firstPart = generate(line, fileScanner);
			if(fileScanner.hasNextLine())
				nextPart = parseRepeat(fileScanner);
		}
		if(nextPart != null)
			expression = new DoubleExpression(firstPart, nextPart);
		else
			expression = firstPart;
		return expression;
	}

	private void checkValidExpression(StringTokenizer tokenizer) {
		if (tokenizer.hasMoreElements())
			try {
				throw new InvalidAttributesException("Invalid Expression");
			} catch (InvalidAttributesException e) {
				e.printStackTrace();
			}

	}

	private Expression parseParameter(String parameterToken,
			StringTokenizer tokenizer) {
		Expression parameter;
		if (parameterToken.startsWith("$"))
			parameter = new Variable(parameterToken);
		else
			parameter = new Constant(Integer.valueOf(parameterToken));
		checkValidExpression(tokenizer);
		return parameter;
	}

	private void parseAssignment(String variable, StringTokenizer tokenizer) {
		tokenizer.nextToken();// passes '=' token
		int value = Integer.valueOf(tokenizer.nextToken());
		values.setValue(variable, value);
		checkValidExpression(tokenizer);
	}

	public Turtle turtle() {// evaluates expressions and returns turtle obj
		for (Expression each : expressions) {
			((Expression) each).evaluate(values);
		}
		return values.SDSU_Turtle;
	}
	// write test to test invalid expr

}
