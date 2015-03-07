public class NullNode<T> extends Node<T> {
	public NullNode() {
		data = null;
	}

	@Override
	public T getData() {
		throw new NullPointerException();
	}

	@Override
	public Node<T> getNext() {
		return null;
	}

	@Override
	public Node<T> getPrevious() {
		return null;
	}

	@Override
	public boolean isNull() {
		return true;
	}

	@Override
	public boolean hasNext() {
		return false;
	}

	@Override
	public boolean hasPrevious() {
		return false;
	}

	@Override
	protected void setNext(Node<T> next) {
		throw new IllegalStateException();
	}

	@Override
	protected void setPrevious(Node<T> previous) {
		throw new IllegalStateException();
	}

	@Override
	public boolean insertNext(T data) {
		return false;
	}

	@Override
	public boolean insertPrevious(T data) {
		return false;
	}

}
