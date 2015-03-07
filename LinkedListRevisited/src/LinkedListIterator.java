import java.util.ListIterator;
import java.util.NoSuchElementException;

public class LinkedListIterator<T> implements ListIterator<T> {

	private Node<T> current;

	public LinkedListIterator() {
		current = new NullNode<T>();
	}

	public LinkedListIterator(Node<T> head) {
		current = head;
	}

	@Override
	public boolean hasNext() {
		return !(current.isNull());
	}

	@Override
	public T next() {
		if (!hasNext())
			throw new NoSuchElementException();
		T data = current.getData();
		current = current.getNext();
		return data;
	}

	@Override
	public void add(T e) {

	}

	@Override
	public boolean hasPrevious() {
		return !(current.isNull());
	}

	@Override
	public int nextIndex() {
		return 0;
	}

	@Override
	public T previous() {
		if (!hasPrevious())
			throw new NoSuchElementException();
		T data = current.getData();
		current = current.getPrevious();
		return data;
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
