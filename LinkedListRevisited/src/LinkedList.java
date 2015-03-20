import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements List<T> {
	private Node<T> head;
	private Node<T> tail;
	Comparator<T> comparator;
	int modCount;

	public LinkedList(Comparator<T> c) {
		head = tail = new NullNode<T>();
		comparator = c;
		modCount = 0;
	}

	public LinkedList(T data, Comparator<T> c) {
		head = tail = new DataNode<T>(data);
		comparator = c;
		modCount = 0;
	}

	private boolean insertFirst(T data) {
		head.insertPrevious(data);
		head = head.getPrevious();
		return true;
	}

	private boolean insertLast(T data) {
		tail.insertNext(data);
		tail = tail.getNext();
		return true;
	}

	private boolean insertBetween(T data) {
		Node<T> current = head;
		while ((comparator.compare(current.getData(), data)) <= 0) {
			if (current.hasNext())
				current = current.getNext();
		}
		current.insertPrevious(data);
		return true;
	}

	private boolean insert(T data) {
		if ((comparator.compare(head.getData(), data)) > 0)
			return insertFirst(data);
		else if ((comparator.compare(tail.getData(), data)) <= 0)
			return insertLast(data);
		else
			return insertBetween(data);
	}

	@Override
	public boolean add(T data) {
		modCount++;
		if (isEmpty()) {
			head = tail = new DataNode<T>(data);
			return true;
		} else
			return insert(data);
	}

	@Override
	public void add(int arg0, T arg1) {

	}

	@Override
	public boolean addAll(Collection<? extends T> all) {
		for (T each : all)
			add(each);
		return true;
	}

	@Override
	public boolean addAll(int arg0, Collection<? extends T> arg1) {
		return false;
	}

	@Override
	public void clear() {
	}

	@Override
	public boolean contains(Object data) {
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		return false;
	}

	@Override
	public T get(int position) {
		if (position < 0)
			throw new NoSuchElementException();
		Iterator<T> iterator = this.iterator();
		int counter = -1;
		while (iterator.hasNext() && counter < position - 1) {
			counter++;
			iterator.next();
		}
		return iterator.next();
	}

	@Override
	public int indexOf(Object arg0) {
		return 0;
	}

	@Override
	public boolean isEmpty() {
		return head.isNull();
	}

	@Override
	public Iterator<T> iterator() {
		return new LinkedListIterator<T>(head, modCount, this);
	}

	public ListIterator<T> reverseIterator() {
		return new LinkedListIterator<T>(tail, modCount, this);
	}

	@Override
	public int lastIndexOf(Object arg0) {
		return 0;
	}

	@Override
	public ListIterator<T> listIterator() {
		return new LinkedListIterator<T>(head, modCount, this);
	}

	@Override
	public ListIterator<T> listIterator(int arg0) {
		return null;
	}

	@Override
	public boolean remove(Object arg0) {
		return false;
	}

	@Override
	public T remove(int arg0) {
		return null;
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		return false;
	}

	@Override
	public T set(int arg0, T arg1) {
		return null;
	}

	@Override
	public int size() {
		return 0;
	}

	@Override
	public List<T> subList(int arg0, int arg1) {
		return null;
	}

	@Override
	public Object[] toArray() {
		List<T> list = new ArrayList<T>();
		Iterator<T> iterator = this.iterator();
		while (iterator.hasNext())
			list.add(iterator.next());
		return list.toArray();
	}

	@Override
	public <T> T[] toArray(T[] array) {
		List<T> list = new ArrayList<T>();
		Iterator<T> iterator = (Iterator<T>) this.iterator();
		while (iterator.hasNext())
			list.add(iterator.next());
		return list.toArray(array);
	}

}
