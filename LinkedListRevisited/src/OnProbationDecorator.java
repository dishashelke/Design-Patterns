import java.util.ArrayList;
import java.util.ListIterator;

public class OnProbationDecorator<T> {
	private LinkedList<T> list;

	public OnProbationDecorator(LinkedList<T> list) {
		this.list = list;
	}

	public String toString() {
		String order = "";
		ListIterator<T> iterator = this.iterator();
		while (iterator.hasNext())
			order += iterator.next();
		return order;
	}

	public Object[] toArray() {
		ArrayList<T> array = new ArrayList<T>();
		ListIterator<T> iterator = this.iterator();
		while (iterator.hasNext())
			array.add(iterator.next());
		return array.toArray();
	}

	public ListIterator<T> iterator() {
		return new OnProbationFilter<T>(list.listIterator());
	}
}
