import java.util.ArrayList;
import org.junit.Test;
import junit.framework.TestCase;

public class StudentDLLTest extends TestCase{
	private static StudentDLL studentList;
	
	protected void setUp(){		
		studentList = new StudentDLL();
		studentList.add("Rohit", 817394475l, 3.78f);
		studentList.add("Neha", 817394875l, 4.00f);
		studentList.add("Amruta", 817394675l, 3.99f);
		studentList.add("Shaila", 817394485l, 2.56f);
		studentList.add("Prasad", 817394470l, 2.4f);
		studentList.add("Ameya", 817394875l, 4f);
		studentList.add("Niki", 817394975l, 2.0f);
		studentList.add("Tanya", 817394905l, 4f);
	}
	
	@Test
	public static void testFind(){		
		Student firstStudent = new Student("Ameya", 817394875l, 4.0f);
		assertEquals(firstStudent.toString(), studentList.findStudentAt(0).toString());
		Student lastStudent = new Student("Tanya", 817394905l, 4f);
		assertEquals(lastStudent, studentList.findStudentAt(7));
	}
	@Test
	public static void testProbation(){
		ArrayList<Long> studentsOnProbation = new ArrayList<Long>();
		studentsOnProbation.add(817394975l);
		studentsOnProbation.add(817394470l);
		studentsOnProbation.add(817394485l);
		assertEquals(studentsOnProbation, studentList.studentsOnProbation());		
	}
	@Test
	public static  void testGpa(){	
		ArrayList<String> studentsWith4Gpa = new ArrayList<String>();
		studentsWith4Gpa.add("Tanya");
		studentsWith4Gpa.add("Neha");
		studentsWith4Gpa.add("Ameya");
		assertEquals(studentsWith4Gpa, studentList.studentsWithGpa4());		
	}
}
