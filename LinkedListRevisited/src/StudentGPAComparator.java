import java.util.Comparator;

public class StudentGPAComparator implements Comparator<Student> {
	@Override
	public int compare(Student first, Student o2) {
		float difference = (first.getGpa() - (o2.getGpa()));
		if (difference > 0)
			return 1;
		else if (difference < 0)
			return -1;
		else
			return 0;
	}
}
