import java.io.FileNotFoundException;
import java.util.StringTokenizer;


public class Temp {

	public static void main(String[] args) throws FileNotFoundException {
		Parser fileParser = new Parser();
		fileParser.parse("repeatInput.txt");
		Expression expressions = fileParser.parse("repeatInput.txt");
		Context values = fileParser.context();
		expressions.evaluate(values);
		Turtle testTurtle = values.turtle();
		System.out.println(testTurtle.direction());
		System.out.println(testTurtle.location());
	}

}
