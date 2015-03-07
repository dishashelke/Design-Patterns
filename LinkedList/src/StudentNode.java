public class StudentNode {
	private StudentNode previous;
	private Student student;
	private StudentNode next;

	public StudentNode getPrevious() {
		return previous;
	}

	public void setPrevious(StudentNode previous) {
		this.previous = previous;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public StudentNode getNext() {
		return next;
	}

	public void setNext(StudentNode next) {
		this.next = next;
	}

	public StudentNode(String name, long redID, float gpa) {
		this(null, null, name, redID, gpa);
	}

	public StudentNode(StudentNode previous, StudentNode next, String name,
			long redID, float gpa) {
		this.previous = previous;
		this.next = next;
		student = new Student(name, redID, gpa);
	}

	public void insertNext(String name, long redID, float gpa) {
		StudentNode newNode = new StudentNode(this, next, name, redID, gpa);
		next = newNode;
	}

	public void insertPrevious(String name, long redID, float gpa) {
		StudentNode newNode = new StudentNode(previous, this, name, redID, gpa);
		previous = newNode;
	}

}
