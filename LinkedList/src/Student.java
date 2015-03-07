public class Student {
	private String name;
	private long redID;
	private float gpa;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setRedID(long redID) {
		this.redID = redID;
	}

	public long getRedID() {
		return redID;
	}

	public void setGpa(float gpa) {
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
		return "\n" + name + "\t" + redID + "\t" + gpa;
	}
}
