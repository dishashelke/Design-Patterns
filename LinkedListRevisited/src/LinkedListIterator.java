//implement iterator as inner class in linkedlist class 
//so that modcount will be accessible in iterator and then there is no need to pass list object to iterator

import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class LinkedListIterator<T> implements ListIterator<T> {
	int expectedModCount;
	private Node<T> current;
	LinkedList<T> list;

	public LinkedListIterator(int modCount, LinkedList<T> object) {
		this(new NullNode<T>(), modCount, object);
		//current = new NullNode<T>();//submitted in assignment
		//expectedModCount = modCount;
	}

	public LinkedListIterator(Node<T> head, int modCount, LinkedList<T> object) {
		current = head;
		expectedModCount = modCount;
		list = object;
	}

	@Override
	public boolean hasNext() {
		return !(current.isNull());
	}

	@Override
	public T next() {
		checkForComodification();
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
		checkForComodification();
		if (!hasPrevious())
			throw new NoSuchElementException();
		T data = current.getData();
		current = current.getPrevious();
		return data;
	}

	public void checkForComodification() {
        if (list.modCount != expectedModCount)
            throw new ConcurrentModificationException();
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
