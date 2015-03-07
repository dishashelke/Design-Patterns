
public class Student{
	private String name;
	private long redID;
	private float gpa;

	private void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	private void setRedID(long redID) {
		this.redID = redID;
	}

	public long getRedID() {
		return redID;
	}

	private void setGpa(float gpa) {
		this.gpa = gpa;
	}

	public float getGpa() {
		return gpa;
	}

	public Student(String name, long redID, float gpa) {
		setName(name);
		setRedID(redID);
		setGpa(gpa);
	}

	public boolean isOnProbation() {
		return gpa < 2.85f;
	}

	public boolean has4Gpa() {
		return gpa == 4f;
	}

	public String toString() {
		return "\n[Name : " + name + ", RedId : " + redID + ", GPA : " + gpa+"]";
	}

}