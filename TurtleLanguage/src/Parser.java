import java.io.File;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.naming.directory.InvalidAttributesException;

public class Parser {
	private Expression expressions;
	private Context values;

	public Parser() {
		values = new Context();
	}

	public Expression expressions() {
		return expressions;
	}

	public Context context() {
		return values;
	}

	public Expression parse(String filename) {
		File file = new File(filename);
		try {
			Scanner fileScanner = new Scanner(file);
			if (fileScanner.hasNextLine()) {
				expressions = generate(fileScanner);
			}
			fileScanner.close();
		} catch (Exception handleException) {
			System.out.println(handleException);
		}
		return expressions;
	}

	private Expression generate(Scanner fileScanner) {
		String line = fileScanner.nextLine();
		StringTokenizer tokenizer = new StringTokenizer(line.trim(), " ");
		String command = tokenizer.nextToken();
		Expression firstPart = null, nextPart = null;
		if (command.equalsIgnoreCase("move")) {
			String parameterToken = tokenizer.nextToken();
			Expression parameter = parseParameter(parameterToken, tokenizer);
			firstPart = new Move(parameter);
		} else if (command.equalsIgnoreCase("turn")) {
			String parameterToken = tokenizer.nextToken();
			Expression parameter = parseParameter(parameterToken, tokenizer);
			firstPart = new Turn(parameter);
		} else if (command.equalsIgnoreCase("penUp")) {
			firstPart = new PenUp();
		} else if (command == "penDown") {
			firstPart = new PenDown();
		} else if (command.startsWith("$")) {
			String variable = command;// .substring(1);
			parseAssignment(variable, tokenizer);
		} else if (command.equalsIgnoreCase("repeat")) {
			String parameterToken = tokenizer.nextToken();
			Expression parameter = parseParameter(parameterToken, tokenizer);
			Expression expressionToRepeat = parseRepeat(fileScanner);
			firstPart = new Repeat(parameter, expressionToRepeat);
		} else if (command.equalsIgnoreCase("end")) {
			return null;
		} else {
			return null;
		}
		if (fileScanner.hasNextLine() && firstPart != null)
			nextPart = generate(fileScanner);
		else if (fileScanner.hasNextLine() && firstPart == null)
			firstPart = generate(fileScanner);
		if (nextPart != null)
			return new DoubleExpression(firstPart, nextPart);
		else
			return firstPart;
	}

	private Expression parseRepeat(Scanner fileScanner) {
		Expression firstPart = null, nextPart = null;
		firstPart = generate(fileScanner);
		if (fileScanner.hasNextLine() && firstPart != null)
			nextPart = parseRepeat(fileScanner);
		if (nextPart != null)
			return new DoubleExpression(firstPart, nextPart);
		else
			return firstPart;
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

	// write test to test invalid expr

}
