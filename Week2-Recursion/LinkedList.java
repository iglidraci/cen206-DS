/*
# Main operations
prepend(value)        -> Add a node in the beginning
append(value)         -> Add a node in the end
pop()                 -> Remove a node from the end
popFirst()            -> Remove a node from the beginning
head()                -> Return the first node
tail()                -> Return the last node
remove(Node)          -> Remove Node from the list
*/
import java.util.ArrayList;
import java.util.Optional;

public class LinkedList<T> {
	private Node<T> head;
	private Node<T> tail;
	private int size = 0;
	public LinkedList() {
	}
	public LinkedList(T headValue) {
		append(headValue);
	}
	public Node<T> head() {
		return this.head;
	}
	public Node<T> tail() {
		return this.tail;
	}
	public int size() {
		return this.size;
	}
	public boolean isEmpty() {
		return size == 0;
	}
	public void prepend(T value) {
		// add a node in the beginning
		if (isEmpty()) {
			head = new Node<>(value);
			tail =  head;
		} else {
			Node<T> temp = this.head;
			this.head = new Node<>(value);
			this.head.next = temp;
		}
		size++;
	}
	public void append(T value) {
		// Add a node in the end
		if (isEmpty()) {
			head = new Node<>(value);
			tail =  head;
		} else {
			Node<T> temp = this.tail;
			this.tail = new Node<>(value);
			temp.next = this.tail;
		}
		size++;
	}
	public ArrayList<T> toList() {
		ArrayList<T> list = new ArrayList<>();
		Node<T> dummy = this.head;
		while (dummy != null) {
			list.add(dummy.value);
			dummy = dummy.next;
		}
		return list;
	}
	public T pop() {
		// Remove a node from the end and return it
		T val;
		if (isEmpty()) {
			return null;
		}
		else if (size == 1) {
			val = this.head.value;
			this.head = null;
			this.tail = null;
		} else {
			Node<T> current = head;
			while (current.next != null && current.next.next != null) {
				current = current.next;
			}
			val = current.next.value;
			current.next = null;
			this.tail = current;
		}
		size--;
		return val;
	}
	public T popFirst() {
		T val;
		if (size == 0) {
			return null;
		}
		else if (size == 1) {
			val = this.head.value;
			this.head = null;
			this.tail = null;
		} else {
			val = this.head.value;
			this.head = this.head.next;
		}
		size--;
		return val;
	}
	public T remove(T target) {
        // Remove Node from the list
        Node<T> current = head;
        Node<T> prev = null;
        while (current != null) {
            T val;
            if (current.value == target) {
                val = current.value;
                if (prev == null) {
                    // it's head
                    if (size == 1) {
                        this.head = null;
                        this.tail = null;
                    } else {
                        this.head = this.head.next;
                    }
                } else if (current.next == null) {
                    // is tail
                    prev.next = null;
                    this.tail = prev;
                }
                else {
                    prev.next = current.next;
                }
                return val;
            } else {
                prev = current;
                current = current.next;
            }
        }
        return null;
    }
	@Override
	public String toString() {
		Optional<String> result = toList().stream().map(x -> x.toString())
                .reduce((x, y) -> x + " -> " + y);
        return result.orElse("[]");
	}
}

class Node<T> {
	public T value;
	public Node<T> next;
	public Node() {}
	public Node (T value, Node<T> next) {
		this.value = value;
		this.next = next;
	}
	public Node (T value) {
		this.value = value;
		this.next = null;
	}
	@Override
	public String toString() {
		return ""+value;
	}
}
