public class Node<T> {
	private T value;
	private Node<T> next;
	private Node<T> prev;
	public Node() {}
	public Node (T value, Node<T> next) {
		this(value, next, null);
	}
	public Node (T value) {
		this(value, null);
	}
	public Node (T value, Node<T> next, Node<T> prev) {
		this.setValue(value);
		this.setNext(next);
		this.setPrev(prev);
	}
	@Override
	public String toString() {
		return ""+ getValue();
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

	public Node<T> getPrev() {
		return prev;
	}

	public void setPrev(Node<T> prev) {
		this.prev = prev;
	}
}
