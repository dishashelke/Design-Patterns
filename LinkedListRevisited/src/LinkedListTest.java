import static org.junit.Assert.*;

import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

public class LinkedListTest {
	LinkedList<Student> students;

	@Before
	public void setUp() throws Exception {
		students = new LinkedList<Student>(new StudentNameComparator());
		students.add(new Student("Rohit", 817394475l, 3.78f));
		students.add(new Student("Neha", 817394875l, 4.00f));
		students.add(new Student("Amruta", 817394675l, 3.99f));
		students.add(new Student("Shaila", 817394485l, 2.56f));
		students.add(new Student("Prasad", 817394470l, 2.4f));
		students.add(new Student("Ameya", 817394875l, 4f));
		students.add(new Student("Niki", 817394975l, 2.0f));
		students.add(new Student("Tanya", 817394905l, 4f));
	}

	@Test
	public void testAdd() {
		assertTrue(students.add(new Student("Ian", 817394999l, 3.12f)));
	}

	@Test
	public void testNullListFail() {
		assertTrue(students.isEmpty());
	}

	@Test
	public void testNullList() {
		assertTrue(!students.isEmpty());
	}

	@Test
	public void testGet() {
		Student firstStudent = new Student("Ameya", 817394875l, 4.0f);
		assertEquals(firstStudent.toString(), students.get(0).toString());
		Student lastStudent = new Student("Tanya", 817394905l, 4f);
		assertEquals(lastStudent.toString(), students.get(7).toString());
		Student randomStudent = new Student("Niki", 817394975l, 2.0f);
		assertEquals(randomStudent.toString(), students.get(3).toString());
	}

	@Test
	public void testGetFail() {
		Student firstStudent = new Student("Ameya", 817394875l, 4.0f);
		assertEquals(firstStudent.toString(), students.get(2).toString());
	}

	@Test(expected = NoSuchElementException.class)
	public void testGetByNegativeIndex() {
		students.get(-1);
	}

	@Test(expected = NoSuchElementException.class)
	public void testGetByInvalidIndex() {
		students.get(8);
	}

	@Test
	public void testOnProbationDecorator() {
		OnProbationDecorator<Student> decorator = new OnProbationDecorator<Student>(
				students);
		String result = "\n[Name : Niki, RedId : 817394975, GPA : 2.0]"
				+ "\n[Name : Prasad, RedId : 817394470, GPA : 2.4]"
				+ "\n[Name : Shaila, RedId : 817394485, GPA : 2.56]";
		assertEquals("Students on probation", result, decorator.toString());
	}

	@Test
	public void testGPAStrategy() {
		LinkedList<Student> studentsOrderedByGPA = new LinkedList<Student>(
				new StudentGPAComparator());
		studentsOrderedByGPA.add(new Student("Rohit", 817394475l, 3.78f));
		studentsOrderedByGPA.add(new Student("Neha", 817394875l, 4.00f));
		studentsOrderedByGPA.add(new Student("Amruta", 817394675l, 3.99f));
		studentsOrderedByGPA.add(new Student("Shaila", 817394485l, 2.56f));
		String result = "\n[Name : Shaila, RedId : 817394485, GPA : 2.56]"
				+ "\n[Name : Rohit, RedId : 817394475, GPA : 3.78]"
				+ "\n[Name : Amruta, RedId : 817394675, GPA : 3.99]"
				+ "\n[Name : Neha, RedId : 817394875, GPA : 4.0]";

		String order = "";
		ListIterator<Student> iterator = studentsOrderedByGPA.listIterator();
		while (iterator.hasNext())
			order += (iterator.next());
		assertEquals("Students ordered by GPA", result, order);
	}

	@Test
	public void testBackwardIterator() {
		LinkedList<Student> studentsList = new LinkedList<Student>(
				new StudentNameComparator());
		studentsList.add(new Student("Rohit", 817394475l, 3.78f));
		studentsList.add(new Student("Neha", 817394875l, 4.00f));
		studentsList.add(new Student("Amruta", 817394675l, 3.99f));
		studentsList.add(new Student("Shaila", 817394485l, 2.56f));
		String result = "\n[Name : Shaila, RedId : 817394485, GPA : 2.56]"
				+ "\n[Name : Rohit, RedId : 817394475, GPA : 3.78]"
				+ "\n[Name : Neha, RedId : 817394875, GPA : 4.0]"
				+ "\n[Name : Amruta, RedId : 817394675, GPA : 3.99]";

		String order = "";
		ListIterator<Student> reverseIter = studentsList.reverseIterator();
		while (reverseIter.hasPrevious())
			order += (reverseIter.previous());
		assertEquals("Backword Iterator", result, order);
	}
}
