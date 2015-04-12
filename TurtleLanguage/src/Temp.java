import java.io.FileNotFoundException;


public class Temp {

	public static void main(String[] args) throws FileNotFoundException {
		Parser fileParser = new Parser();
		fileParser.parse("repeatInput.txt");
		Turtle testTurtle = fileParser.turtle();
		System.out.println(testTurtle.direction());
		System.out.println(testTurtle.location());
	}

}
