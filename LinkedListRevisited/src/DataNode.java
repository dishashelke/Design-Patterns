public class DataNode<T> extends Node<T> {

	public T getData() {
		return data;
	}

	private void setData(T data) {
		this.data = data;
	}

	public Node<T> getNext() {
		return next;
	}

	@Override
	protected void setNext(Node<T> next) {
		this.next = next;
	}

	public Node<T> getPrevious() {
		return previous;
	}

	@Override
	protected void setPrevious(Node<T> prev) {
		this.previous = prev;
	}

	public DataNode() {
		this(null);
	}

	public DataNode(T data) {
		setData(data);
		setNext(new NullNode<T>());
		setPrevious(new NullNode<T>());
	}

	public DataNode(T data, Node<T> prev, Node<T> next) {
		setData(data);
		setPrevious(prev);
		setNext(next);
	}

	@Override
	public boolean insertNext(T data) {
		DataNode<T> newNode = new DataNode<T>(data, this, next);
		next = newNode;
		Node<T> nextNode = newNode.getNext();
		if (!nextNode.isNull())
			nextNode.setPrevious(newNode);
		return true;
	}

	@Override
	public boolean insertPrevious(T data) {
		DataNode<T> newNode = new DataNode<T>(data, previous, this);
		previous = newNode;
		Node<T> previousNode = newNode.getPrevious();
		if (!previousNode.isNull())
			previousNode.setNext(newNode);
		return true;
	}

	@Override
	public boolean hasNext() {
		return !(next.isNull());
	}

	@Override
	public boolean hasPrevious() {
		return !(previous.isNull());
	}

	@Override
	public boolean isNull() {
		return false;
	}
}
