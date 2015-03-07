import java.util.ArrayList;

public class StudentDLL {
	private StudentNode head;
	private StudentNode tail;

	public StudentDLL() {
		head = tail = null;
	}

	public StudentDLL(String name, long redID, float gpa) {
		StudentNode newNode = new StudentNode(name, redID, gpa);
		head = tail = newNode;
	}

	public void add(String name, long redID, float gpa) {
		if (head == null)
			head = tail = new StudentNode(name, redID, gpa);
		else {
			StudentNode currentNode = findLocationToInsert(name);
			// if new Student needs to be added at the front of the list
			if (currentNode == null)
				insertFirst(name, redID, gpa);
			// if new Student needs to be added at the end of the list
			else if (currentNode == tail)
				insertLast(name, redID, gpa);
			// new Student needs to be added in the list other than front or end
			else
				currentNode.insertNext(name, redID, gpa);
		}
	}

	public StudentNode findLocationToInsert(String name) {
		StudentNode currentNode = tail; 
		int equal = 0;// Student name in the current node is greater than name
						// of new Student if the value returned by comparedTo is
						// grater than zero
		// keep traversing previous node if Student name in the current node is
		// lexicographically greater than name of new Student
		while ((currentNode != null)
				&& (currentNode.getStudent().getName().compareTo(name) > equal))
			currentNode = currentNode.getPrevious();
		return currentNode;// insert new Student after this node
	}

	public void insertFirst(String name, long redID, float gpa) {
		head.insertPrevious(name, redID, gpa);
		head = head.getPrevious();
	}

	public void insertLast(String name, long redID, float gpa) {
		tail.insertNext(name, redID, gpa);
		tail = tail.getNext();
	}

	public ArrayList<Long> studentsOnProbation() {
		ArrayList<Long> students = new ArrayList<Long>();
		StudentNode currentNode = head;
		while (currentNode != null) {
			Student currentStudent = currentNode.getStudent();
			if (currentStudent.isOnProbation())
				students.add(currentStudent.getRedID());
			currentNode = currentNode.getNext();
		}
		return students;
	}

	public ArrayList<String> studentsWithGpa4() {
		ArrayList<String> students = new ArrayList<String>();
		StudentNode currentNode = tail;
		while (currentNode != null) {
			Student currentStudent = currentNode.getStudent();
			if (currentStudent.has4Gpa())
				students.add(currentStudent.getName());
			currentNode = currentNode.getPrevious();
		}
		return students;
	}

	public Student findStudentAt(int position) {
		if (position < 0) {
			throw new RuntimeException(
			"[EXCEPTION]Position of element is out of bounds");
		}
		StudentNode currentNode = head;
		int nodeCount = 0;		
		while (currentNode != null && nodeCount < position) {
			currentNode = currentNode.getNext();
			nodeCount++;
		}
		try {
			return currentNode.getStudent();
		} catch (Exception e) {
			throw new RuntimeException(
					"[EXCEPTION]Position of element is out of bounds");
		}
	}

	public void print() {
		StudentNode current = head;
		while (current != null) {
			System.out.print(current.getStudent().toString());
			current = current.getNext();
		}
	}
	public static void main(String[] args) {	
		StudentDLL studentList = new StudentDLL();
		studentList.add("Rohit", 817394475l, 3.78f);
		studentList.add("Neha", 817394875l, 4.00f);
		studentList.add("Amruta", 817394675l, 3.99f);
		studentList.add("Shaila", 817394485l, 2.56f);
		studentList.add("Prasad", 817394470l, 2.4f);
		studentList.add("Ameya", 817394875l, 4f);
		studentList.add("Niki", 817394975l, 2.0f);
		studentList.add("Tanya", 817394905l, 4f);
		System.out.print("\n\nStudents in the list are: ");
		studentList.print();
		System.out.print("\n\nRedIDs of Students that are on probation: "+studentList.studentsOnProbation());
		System.out.print("\n\nNames of Student having 4 GPA:"+studentList.studentsWithGpa4()+"\n\n");
		System.out.print(studentList.findStudentAt(10));
	}
}
