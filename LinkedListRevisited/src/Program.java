import java.util.ListIterator;


public class Program {
	public static void main(String[] args) {		
		//while creating a LinkedList pass comparator as argument 
		LinkedList<Student> students = new LinkedList<Student>(new StudentNameComparator());
		//LinkedList<Student> students = new LinkedList<Student>(new StudentGPAComparator());//correct and working
		students.add(new Student("Rohit", 817394475l, 3.78f));
		students.add(new Student("Neha", 817394875l, 4.00f));
		students.add(new Student("Amruta", 817394675l, 3.99f));
		students.add(new Student("Shaila", 817394485l, 2.56f));
		students.add(new Student("Prasad", 817394470l, 2.4f));
		students.add(new Student("Ameya", 817394875l, 4f));
		students.add(new Student("Niki", 817394975l, 2.0f));
		students.add(new Student("Tanya", 817394905l, 4f));
		
		/*ArrayList<Student> collection = new ArrayList<Student>;
		collection.add(new Student("b", 888, 2.8f));
		//(List<Student>) , new Student("as", 785, 4f)};
		students.addAll(collection);*/
		
		//foreward iterator
		ListIterator<Student> iter = students.listIterator();
		while(iter.hasNext())
			System.out.print(iter.next());
		
		//backward iterator
		ListIterator<Student> reverseIter = students.reverseIterator();
		while(reverseIter.hasPrevious())
			System.out.print(reverseIter.previous());

		//get
		System.out.print(students.get(7));
		
		//Filter
		System.out.print("\n\n[Filter]\n");
		ListIterator<Student> iterfilter = students.listIterator();
		OnProbationFilter<Student> filter = new OnProbationFilter<Student>(iterfilter);
		while(filter.hasNext())
			System.out.print(filter.next());
		System.out.print("\n\n[Filter End]\n");
		
		//Decorator
		System.out.print("\n\n[Decorator]");
		OnProbationDecorator<Student> decorator = new OnProbationDecorator<Student>(students);
		System.out.print(decorator.toString());
		System.out.print("[End Decorator]\n");
		
		//Question 10
		/*System.out.print("[Q10]");
		for (Student student : students) {
			System.out.print(student);
		}*/
		
		System.out.print("[End Q10]");
	}
}
