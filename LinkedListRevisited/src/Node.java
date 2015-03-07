public abstract class Node<T> {
	protected T data;
	protected Node<T> next;
	protected Node<T> previous;

	public abstract T getData();

	public abstract Node<T> getNext();

	public abstract Node<T> getPrevious();

	protected abstract void setNext(Node<T> next);

	protected abstract void setPrevious(Node<T> previous);

	public abstract boolean isNull();

	public abstract boolean hasNext();

	public abstract boolean hasPrevious();

	public abstract boolean insertNext(T data);

	public abstract boolean insertPrevious(T data);

}
