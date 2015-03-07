import java.util.ListIterator;
import java.util.NoSuchElementException;

public class OnProbationFilter<T> implements ListIterator<T> {

	private ListIterator<T> iterator;
	private T next;

	public OnProbationFilter() {
		iterator = null;
		getCurrent();
	}

	public OnProbationFilter(ListIterator<T> input) {
		iterator = (ListIterator<T>) input;
		getCurrent();
	}

	private void getCurrent() {
		next = null;
		while (iterator.hasNext()) {
			next = iterator.next();
			if (((Student)next).isOnProbation())
				break;
		}
		if (!iterator.hasNext())
			next = null;
	}

	@Override
	public void add(T e) {

	}

	@Override
	public boolean hasNext() {
		return next != null;
	}

	@Override
	public boolean hasPrevious() {
		return next != null;
	}

	@Override
	public T next() {
		if (next == null)
			throw new NoSuchElementException();
		T current = next;
		getCurrent();
		return (T) current;
	}

	@Override
	public int nextIndex() {
		return 0;
	}

	@Override
	public T previous() {
		return null;
	}

	@Override
	public int previousIndex() {
		return 0;
	}

	@Override
	public void remove() {
	}

	@Override
	public void set(T e) {
	}
}
